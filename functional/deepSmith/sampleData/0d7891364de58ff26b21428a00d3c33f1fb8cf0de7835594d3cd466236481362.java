public static byte[] fn_A(InputStream a){
  try {
    byte[] b=new byte[1024];
    int c=-1;
    ByteArrayOutputStream d=new ByteArrayOutputStream();
    while ((c=a.read(b)) != -1) {
      d.write(b,0,c);
    }
    d.close();
    return d.toByteArray();
  }
 catch (  Exception e) {
    e.printStackTrace();
  }
  return null;
}
