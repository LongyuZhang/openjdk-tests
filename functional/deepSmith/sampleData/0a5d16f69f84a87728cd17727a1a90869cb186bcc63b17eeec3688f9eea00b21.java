private static void fn_A(File a,File b) throws IOException {
  FileInputStream c=new FileInputStream(a);
  FileOutputStream d=new FileOutputStream(b);
  byte[] e=new byte[1024];
  int f=0;
  while ((f=c.read(e)) != -1) {
    d.write(e,0,f);
  }
  d.close();
  c.close();
}
