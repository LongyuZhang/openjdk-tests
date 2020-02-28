public static void fn_A(String a) throws IOException {
  FileInputStream b=new FileInputStream(a);
  byte[] c=new byte[20 * 1024];
  int d=0;
  int e=1;
  while ((d=b.read(c,0,c.length)) != -1) {
    for (int f=0; f < d; f++) {
      System.out.print(Integer.toHexString(c[f] & 0xff) + "  ");
      if (e++ % 10 == 0) {
        System.out.println();
      }
    }
  }
  b.close();
}
