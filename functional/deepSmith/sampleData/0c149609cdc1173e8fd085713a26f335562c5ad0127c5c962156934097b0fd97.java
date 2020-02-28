public static void main(String a[]) throws Exception {
  PrintStream b=new PrintStream(new FileOutputStream(new File("D:\\text.txt")));
  b.print("hello");
  b.println("hello world");
  b.print("1+1=2");
  b.close();
}
