public static void main(String a[]) throws Exception {
  ByteArrayOutputStream b=new ByteArrayOutputStream();
  System.setErr(new PrintStream(b));
  System.err.println("hello");
  System.err.print("world");
  System.out.print(b);
}
