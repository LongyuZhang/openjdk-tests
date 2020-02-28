public static void main(String[] a) throws IOException {
  int b;
  BufferedReader c=new BufferedReader(new InputStreamReader(System.in));
  InputStream d=new FileInputStream(c.readLine());
  while (d.available() > 0) {
    b=d.read();
    System.out.print((char)b);
  }
  d.close();
}
