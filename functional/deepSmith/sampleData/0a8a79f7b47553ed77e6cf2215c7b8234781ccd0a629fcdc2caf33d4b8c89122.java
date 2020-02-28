public static void main(String[] a) throws Exception {
  int b=0;
  FileInputStream c=new FileInputStream(new BufferedReader(new InputStreamReader(System.in)).readLine());
  while (c.available() > 0) {
    int d=c.read();
    if (d > b) {
      b=d;
    }
  }
  c.close();
  System.out.println(b);
}
