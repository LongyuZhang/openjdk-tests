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

	// private static Logger logger = Logger.getLogger(JavaDriver.class);
	public static void main(String[] args) throws Throwable {
		System.out.println("Excellent Job: Running successfully!");
		File directory = new File(System.getProperty("user.dir"));
		String dataPath = directory.getParentFile().getParent() + "/functional/deepSmith/data";
		System.out.println(dataPath);
		System.out.println(System.getProperty("user.dir"));
		//previous output is /home/jenkins/workspace/Grinder_Advanced/openjdk-tests/TestConfig/test_output_15677333447999/deepSmith_0

		System.out.println(directory.getCanonicalPath());
		System.out.println(directory.getAbsolutePath());

		// File testsFolder = new File("/Users/longyuzhang/documents/repos/CasDeepSmith/DSTestTmp");
		// File[] listofTestFiles = testsFolder.listFiles();
		// if (listofTestFiles != null) {
		//   for (File curFile : listofTestFiles) {
		// 	  System.out.println(curFile.getName());
		//   }
		// }
		// logger.info("running aTestExample: INFO and above level logging enabled");
		// AssertJUnit.assertEquals(4, 2+2);

	}
}
