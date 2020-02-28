public static void main(String a[]) throws Exception {
  InputStream b=System.in;
  byte c[]=new byte[1024];
  System.out.print("");
  int d=b.read(c);
  System.out.println(new String(c,0,d));
  b.close();
}
