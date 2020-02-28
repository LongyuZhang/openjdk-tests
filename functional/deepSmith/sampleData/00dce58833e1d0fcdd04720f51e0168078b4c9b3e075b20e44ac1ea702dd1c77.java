public static byte[] fn_A(File a){
  byte[] b=null;
  try {
    ByteArrayOutputStream c=new ByteArrayOutputStream(1000);
    FileInputStream d=new FileInputStream(a);
    byte[] e=new byte[1000];
    int f;
    while ((f=d.read(e)) != -1) {
      c.write(e,0,f);
    }
    c.close();
    d.close();
    b=c.toByteArray();
  }
 catch (  FileNotFoundException g) {
    g.printStackTrace();
  }
catch (  IOException h) {
    h.printStackTrace();
  }
  return b;
}
