/*******************************************************************************
 * Copyright (c) 2019, 2019 IBM Corp. and others
 *
 * This program and the accompanying materials are made available under
 * the terms of the Eclipse Public License 2.0 which accompanies this
 * distribution and is available at https://www.eclipse.org/legal/epl-2.0/
 * or the Apache License, Version 2.0 which accompanies this distribution and
 * is available at https://www.apache.org/licenses/LICENSE-2.0.
 *
 * This Source Code may also be made available under the following
 * Secondary Licenses when the conditions for such availability set
 * forth in the Eclipse Public License, v. 2.0 are satisfied: GNU
 * General Public License, version 2 with the GNU Classpath
 * Exception [1] and GNU General Public License, version 2 with the
 * OpenJDK Assembly Exception [2].
 *
 * [1] https://www.gnu.org/software/classpath/license.html
 * [2] http://openjdk.java.net/legal/assembly-exception.html
 *
 * SPDX-License-Identifier: EPL-2.0 OR Apache-2.0 OR GPL-2.0 WITH Classpath-exception-2.0 OR LicenseRef-GPL-2.0 WITH Assembly-exception
 *******************************************************************************/
package org.openj9.test.driver;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.SimpleJavaFileObject;
import javax.tools.ToolProvider;

public class JavaDriver {

	// The mode used to create argument values.
	enum Mode {
	DEFAULT, RANDOM
	}

	/**
	 * The driver configuration. Specifies the rules used to produce inputs, and
	 * their size.
	 */
	public static class JavaDriverConfiguration {
	public JavaDriverConfiguration(final Mode mode, final int arrayLength, final long seed) {
		this.mode = mode;
		this.arrayLength = arrayLength;
		this.seed = seed;
	}

	public final Mode mode;
	public int arrayLength;
	public long seed;
	}

	private static Object[] getArray(Object val) {
	if (val instanceof Object[])
		return (Object[])val;
	int arrlength = Array.getLength(val);
	Object[] outputArray = new Object[arrlength];
	for(int i = 0; i < arrlength; ++i){
		outputArray[i] = Array.get(val, i);
	}
	return outputArray;
	}

	/** The result of driving a Java Method. */
	public static class JavaDriverResult {
	public JavaDriverResult() {
		succeeded_ = false;
		failed_ = false;
		parameterValues_ = new ArrayList<Object>();
	}

	public int getMutableParameterCount() {
		return parameterValues_.size();
	}

	public String getMutableParameterValue(int i) {
		if (parameterValues_.get(i).getClass().isArray()) {
		Object [] arrayMutableParameterValue = getArray(parameterValues_.get(i));
		if (arrayMutableParameterValue.getClass().getComponentType().isArray()) {
			return Arrays.deepToString(arrayMutableParameterValue);
		}
		return Arrays.toString(arrayMutableParameterValue);
		} else {
		return String.format("%s", parameterValues_.get(i));
		}
	}

	public String getReturnValue() {
		if (returnValue_ != null && returnValue_.getClass().isArray()) {
		Object [] arrayReturnValue = getArray(returnValue_);
		if (arrayReturnValue.getClass().getComponentType().isArray()) {
			return Arrays.deepToString(arrayReturnValue);
		}
		return Arrays.toString(arrayReturnValue);
		} else {
		return String.format("%s", returnValue_);
		}
	}

	public String toString() {
		if (!succeeded_ && !failed_) {
		return "Unknown driver result";
		} else if (!succeeded_) {
		assert failed_;
		return errorMessage_;
		}

		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < getMutableParameterCount(); ++i) {
		builder.append(String.format("Par[%d]: %s\n", i, getMutableParameterValue(i)));
		}
		builder.append(String.format("Return: %s", getReturnValue()));
		return builder.toString();
	}

	public void SetSuccess() {
		assert !failed_;
		assert !succeeded_;
		succeeded_ = true;
	}

	// Don't call this directly, use SetInvalidDriverInput() or
	// SetValidDriverFailure() instead.
	private void SetFailed() {
		assert !failed_;
		assert !succeeded_;
		failed_ = true;
	}

	public void SetValidDriverFailure(final String message) {
		errorMessage_ = message;
		SetFailed();
	}

	public void SetReturnValue(final Object object) {
		returnValue_ = object;
	}

	public void AddParameterValue(final Object object) {
		parameterValues_.add(object);
	}

	public void SetInvalidDriverInput(final String message) {
		errorMessage_ = message;
		SetFailed();
	}

	public void SetInternalDriverFailure(final String message) {
		errorMessage_ = message;
		SetFailed();
	}

	public boolean IsFailure() {
		return failed_;
	}

	public boolean IsSuccess() {
		return succeeded_;
	}

	// We need to track both success and failure as there is a third state,
	// uninitialised.
	private boolean succeeded_;
	private boolean failed_;
	private String errorMessage_;
	private Object returnValue_;
	private ArrayList<Object> parameterValues_;
	}

	/** Abstract base class for errors during driving. */
	public abstract static class DriverException extends Exception {
	public DriverException(String message) {
		super(message);
	}
	}

	/**
	 * A "something went wrong" error with the driver. This should not occur in
	 * normal use and indicate a bug in the driver.
	 */
	public static class InternalDriverException extends DriverException {
	public InternalDriverException(String message) {
		super(message);
	}
	}

	/**
	 * Exception raised when an invalid input is passed to the driver. E.g. a string
	 * which does not compile, or an unsupported parameter type.
	 */
	public static class InvalidDriverInputException extends DriverException {
	public InvalidDriverInputException(String message) {
		super(message);
	}
	}

	/**
	 * A "valid" error during method execution. I.e. the called method raises an
	 * exception.
	 */
	public static class ValidDriverInputException extends DriverException {
	public ValidDriverInputException(String message) {
		super(message);
	}
	}

	/** An in-memory java source file. */
	public class JavaSourceFromString extends SimpleJavaFileObject {
	final String code_;

	public JavaSourceFromString(String name, String code) {
		// Replace package qualifiers with directory separators when building the
		// name.
		super(URI.create("string:///" + name.replace('.', '/') + Kind.SOURCE.extension), Kind.SOURCE);
		code_ = code;
	}

	@Override
	public CharSequence getCharContent(boolean unusedIgnoreEncodingErrors) {
		return code_;
	}
	}

	/** The factory class for producing values of given types. */
	public static class ValueGenerator {
	public ValueGenerator(final JavaDriverConfiguration config) {
		config_ = config;
		rng_ = new Random();
		rng_.setSeed(config_.seed);
	}

	/**
	 * Generate a value of the given type.
	 *
	 * @param parameterType The type of value to produce.
	 * @return A value of the given type. The value is determined by the
	 *         JavaDriverConfiguration settings.
	 * @throws InvalidDriverInputException If a value of the given type cannot be
	 *                                     produced.
	 */
	public Object Generate(Class<?> type) throws InvalidDriverInputException {
		if (type.isPrimitive()) {
		return GeneratePrimitive(type);
		} else if (type.isArray()) {
		return GenerateArray(type.getComponentType());
		} else {
		// For non-primitive and non-arrays, try using the default constructor.
		try {
			return type.getConstructor().newInstance();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
			throw new InvalidDriverInputException(
				String.format("Unable to construct parameter of type `%s`", type.getSimpleName()));
		} catch (InvocationTargetException e) {
			e.printStackTrace();
			throw new InvalidDriverInputException(
				String.format("Constructor for type `%s` raised exception `%s`", type.getSimpleName(), e));
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw new InvalidDriverInputException(
				String.format("Constructor for type `%s` raised exception `%s`", type.getSimpleName(), e));
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw new InvalidDriverInputException(
				String.format("Constructor for type `%s` cannot be accessed", type.getSimpleName()));
		}
		}
	}

	// Private generator methods.

	/**
	 * Generate an array of values of the given type.
	 *
	 * @param elementType The type of the element to produce.
	 */
	private Object GenerateArray(Class<?> elementType) throws InvalidDriverInputException {
		final int arrayLength = config_.arrayLength;
		Object arrayDefaults = Array.newInstance(elementType, arrayLength);
		for (int i = 0; i < arrayLength; ++i) {
		Array.set(arrayDefaults, i, Generate(elementType));
		}
		return arrayDefaults;
	}

	/**
	 * Produce a primitive of the given type.
	 *
	 * @param type The type to generate.
	 * @return An object of the given type.
	 * @throws InvalidDriverInputException If the type is not supported.
	 */
	private Object GeneratePrimitive(Class<?> type) throws InvalidDriverInputException {
		if (type == Boolean.TYPE) {
		return GenerateBoolean();
		} else if (type == Character.TYPE) {
		return GenerateCharacter();
		} else if (type == Byte.TYPE) {
		return GenerateByte();
		} else if (type == Short.TYPE) {
		return GenerateShort();
		} else if (type == Integer.TYPE) {
		return GenerateInteger();
		} else if (type == Long.TYPE) {
		return GenerateLong();
		} else if (type == Float.TYPE) {
		return GenerateFloat();
		} else if (type == Double.TYPE) {
		return GenerateDouble();
		}
		throw new InvalidDriverInputException("Unsupport primitive type");
	}

	private boolean GenerateBoolean() {
		if (config_.mode == Mode.DEFAULT) {
		return true;
		} else {
		return rng_.nextBoolean();
		}
	}

	private char GenerateCharacter() {
		if (config_.mode == Mode.DEFAULT) {
		return 'A';
		} else {
		return (char) (rng_.nextInt(95) + 32);
		}
	}

	private byte GenerateByte() {
		if (config_.mode == Mode.DEFAULT) {
		return 0;
		} else {
		byte[] value = new byte[1];
		rng_.nextBytes(value);
		return value[0];
		}
	}

	private short GenerateShort() {
		if (config_.mode == Mode.DEFAULT) {
		return (short) config_.arrayLength;
		} else {
		return (short) (rng_.nextInt(65536) - 32768);
		}
	}

	private int GenerateInteger() {
		if (config_.mode == Mode.DEFAULT) {
		return config_.arrayLength;
		} else {
		return rng_.nextInt();
		}
	}

	private long GenerateLong() {
		if (config_.mode == Mode.DEFAULT) {
		return (long) config_.arrayLength;
		} else {
		return rng_.nextLong();
		}
	}

	private float GenerateFloat() {
		if (config_.mode == Mode.DEFAULT) {
		return 0.0f;
		} else {
		return Float.MIN_VALUE + (Float.MAX_VALUE - Float.MIN_VALUE) * rng_.nextFloat();
		}
	}

	private double GenerateDouble() {
		if (config_.mode == Mode.DEFAULT) {
		return 0.0d;
		} else {
		return Double.MIN_VALUE + (Double.MAX_VALUE - Double.MIN_VALUE) * rng_.nextDouble();
		}
	}

	private final JavaDriverConfiguration config_;
	private Random rng_;
	}

	public JavaDriver(final JavaDriverConfiguration config) {
	compiler_ = ToolProvider.getSystemJavaCompiler();
	config_ = config;
	}

	/**
	 * Create a temporary directory with an informative prefix. Crashes on error.
	 *
	 * <p>
	 * It is the responsibility of the calling code to delete this directory once
	 * finished. Call JavaDriver.DeleteTree().
	 *
	 * @return The path of the temporary directory.
	 */
	public static Path CreateTemporaryDirectoryOrDie() {
	try {
		return Files.createTempDirectory("phd_deeplearning_deepsmith_harnesses_JavaDriver_");
	} catch (IOException e) {
		e.printStackTrace();
		System.err.println("[driver error] Failed to create temporary directory");
		System.exit(1);
		return null;
	}
	}

	/**
	 * Delete a directory containing zero or more files.
	 *
	 * <p>
	 * This is not recursive, only files are allowed.
	 *
	 * @param path The directory to delete.
	 */
	public static void DeleteTree(final File path) {
	String[] entries = path.list();
	for (String s : entries) {
		File currentFile = new File(path.getPath(), s);
		currentFile.delete();
	}
	// Now delete the empty directory.
	path.delete();
	}

	private static Class<?> LoadClassFromFile(final File classDirectory, final String className)
		throws InternalDriverException {
	try {
		URL url = classDirectory.toURI().toURL();
		URLClassLoader classLoader = URLClassLoader.newInstance(new URL[] { url });
		return classLoader.loadClass(className);
	} catch (MalformedURLException e) {
		e.printStackTrace();
		throw new InternalDriverException("Failed to create URL");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
		throw new InternalDriverException("Failed to load compiled class");
	}
	}

	public Object[] CreateValuesForParameters(Class<?>[] parameterTypes) throws InvalidDriverInputException {
	ValueGenerator generator = new ValueGenerator(config_);

	Object[] parameters = new Object[parameterTypes.length];
	for (int i = 0; i < parameterTypes.length; ++i) {
		Class<?> parameterType = parameterTypes[i];
		Object value = generator.Generate(parameterType);

		// Array types must be cast, but scalar types cannot.
		if (parameterType.isArray()) {
		parameters[i] = parameterType.cast(value);
		} else {
		parameters[i] = value;
		}
	}
	return parameters;
	}

	public static Method GetMethodFromClass(Class<?> parentClass) throws InvalidDriverInputException {
	Method[] methods = parentClass.getDeclaredMethods();
	if (methods.length == 0) {
		throw new InvalidDriverInputException("Class contains no methods, need one");
	} else if (methods.length > 1) {
		throw new InvalidDriverInputException(String.format("Class contains %d methods, need one", methods.length));
	}
	return methods[0];
	}

	/**
	 * Wrap the method in a class definition.
	 *
	 * <p>
	 * TODO: This is duplicated from:
	 * //deeplearning/clgen/preprocessors:JavaPreprocessor. It is duplicated so that
	 * this file can be compiled standalone. Before a public release of this code,
	 * this duplication should be reconciled.
	 *
	 * @param methodSrc The method to wrap.
	 * @return The method, embedded in a class "A".
	 */
	public String WrapMethodInClassWithShim(final String methodSrc) {
	// Template:
	// import java.io.*;
	// import java.math.*;
	// import java.nio.charset.*;
	// import java.nio.file.*;
	// import java.time.format.*;
	// import java.util.*;
	// public class A {
	// /* METHOD GOES HERE */
	// }
	return ("import java.io.*;\n" + "import java.math.*;\n" + "import java.nio.charset.*;\n"
		+ "import java.nio.file.*;\n" + "import java.time.format.*;\n" + "import java.util.*;\n" + "public class A{"
		+ methodSrc + "}");
	}

	// Driver methods.

	public JavaDriverResult Drive(final Path workingDirectory, final String methodSrc) {
	final String classSrc = WrapMethodInClassWithShim(methodSrc);
	final JavaSourceFromString javaSrc = new JavaSourceFromString("A", classSrc);
	return Drive(workingDirectory, javaSrc);
	}

	public JavaDriverResult Drive(final Path workingDirectory, final JavaFileObject javaSrc) {
	Iterable<? extends JavaFileObject> fileObjects = Arrays.asList(javaSrc);

	List<String> options = new ArrayList<String>();
	options.add("-d");
	options.add(workingDirectory.toString());

	StringWriter output = new StringWriter();
	boolean success = compiler_.getTask(/* out= */ output, /* fileManager= */ null, /* diagnosticListener= */ null,
		/* options= */ options, /* classes= */ null, /* compilationUnits= */ fileObjects).call();

	if (!success) {
		JavaDriverResult result = new JavaDriverResult();
		result.SetInvalidDriverInput("Failed to compile class: " + output);
		return result;
	}

	String className = javaSrc.getName();
	// Strip trailing extension.
	className = className.replaceFirst("[.][^.]+$", "");
	// Strip leading path.
	className = className.replaceFirst("^.*/", "");

	try {
		Class<?> parentClass = LoadClassFromFile(workingDirectory.toFile(), className);
		Method method = GetMethodFromClass(parentClass);
		return Drive(method);
	} catch (InternalDriverException e) {
		e.printStackTrace();
		JavaDriverResult result = new JavaDriverResult();
		result.SetInternalDriverFailure(e.getMessage());
		return result;
	} catch (InvalidDriverInputException e) {
		e.printStackTrace();
		JavaDriverResult result = new JavaDriverResult();
		result.SetInvalidDriverInput(e.getMessage());
		return result;
	}
	}

	/**
	 * Drive the given Java method.
	 *
	 * <p>
	 * This method will attempt to catch all errors and return a JavaDriverResult,
	 * but I haven't done an exhaustive check, and there may still remain room for
	 * things to break.
	 *
	 * @param method The method to drive.
	 * @return A JavaDriverResult instance.
	 */
	public JavaDriverResult Drive(final Method method) {
	JavaDriverResult result = new JavaDriverResult();
	Class<?>[] parameterTypes = method.getParameterTypes();
	try {
		Object[] parameters = CreateValuesForParameters(parameterTypes);
		Class<?> parentClass = method.getDeclaringClass();
		Object instance;
		instance = parentClass.getConstructor().newInstance();
		result.SetSuccess();
		for (int i = 0; i < parameters.length; ++i) {
		Class<?> parameterType = parameterTypes[i];
		Object parameter = parameters[i];
		result.AddParameterValue(parameter);
		}
		method.setAccessible(true);

		result.SetReturnValue(method.invoke(instance, parameters));
		
	} catch (InvalidDriverInputException e) {
		e.printStackTrace();
		result.SetInvalidDriverInput(e.getMessage());
	} catch (InstantiationException e) {
		e.printStackTrace();
		result.SetInvalidDriverInput("Class cannot be instantiated");
	} catch (IllegalAccessException e) {
		e.printStackTrace();
		result.SetInvalidDriverInput("Method is inaccessible");
	} catch (InvocationTargetException e) {
		e.printStackTrace();
		result.SetValidDriverFailure("Method threw exception: " + e);
	} catch (IllegalArgumentException e) {
		e.printStackTrace();
		result.SetValidDriverFailure("Method threw exception: " + e);
	} catch (NoSuchMethodException e) {
		e.printStackTrace();
		result.SetValidDriverFailure("Method threw exception: " + e);
	} catch (SecurityException e) {
		e.printStackTrace();
		result.SetValidDriverFailure("Method threw exception: " + e);
	}

	return result;
	}

	private JavaCompiler compiler_;
	private final JavaDriverConfiguration config_;

	// private static Logger logger = Logger.getLogger(JavaDriver.class);
	public static void main(String[] args) throws Throwable {

		Mode mode = Mode.RANDOM;
		int arrayLength = 10;
		long seed = 220;
		JavaDriverConfiguration config = new JavaDriverConfiguration(mode, arrayLength, seed);
	
		JavaDriver javaDriver = new JavaDriver(config);	
		final Path tmpDir = JavaDriver.CreateTemporaryDirectoryOrDie();
		
		/* Obtain path of test data folder */
		File directory = new File(System.getProperty("user.dir"));
		String dataPath = directory.toString() + "/data/deepSmithData";
		System.out.println("Data folder path is: " + dataPath + "\n");
		File testsFolder = new File(dataPath);
		if(!testsFolder.exists()) {
			throw new FileNotFoundException("Cannot find test data folder!");
		}
		File[] listofTestFiles = testsFolder.listFiles();
		if (listofTestFiles != null) {
			for (File curFile : listofTestFiles) {
				if (curFile.isFile() && curFile.toString().contains(".txt")) {
					String curFileName = curFile.getName();
					System.out.println("Current TEST_NAME is: " + curFileName);
					String curFileAbsolutePath = testsFolder.toString() + File.separator + curFileName;
					StringBuilder inputString = new StringBuilder();

					try(BufferedReader bufferReader = new BufferedReader(new FileReader(curFileAbsolutePath))) {
						String line = bufferReader.readLine();
						System.out.println("Current TEST_CONTENT is: ");
						while (line != null) {
							System.out.println(line);
							inputString.append(line);
							inputString.append("\n");
							line = bufferReader.readLine();
						}
					} catch (IOException ex) {
						System.out.println("Error reading file " + curFileAbsolutePath);
					}

					JavaDriverResult curOutput = javaDriver.Drive(tmpDir, inputString.toString());
					System.out.println("Current TEST_OUTPUT is: \n" + curOutput.toString() + "\n");
				}
			}
		} else {
			System.out.println("No Test files in the data folder");
		}
		JavaDriver.DeleteTree(tmpDir.toFile());
	}
}
