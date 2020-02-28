private static String fn_A(InputStream a) throws IOException {
  ByteArrayOutputStream b=null;
  BufferedInputStream c=null;
  String d=null;
  try {
    c=new BufferedInputStream(a);
    b=new ByteArrayOutputStream();
    byte[] e=new byte[1024];
    int f;
    while ((f=c.read(e)) > 0) {
      b.write(e,0,f);
    }
    d=b.toString("utf-8");
    return d;
  }
  finally {
    try {
      if (b != null) {
        b.close();
      }
      if (c != null) {
        c.close();
      }
    }
 catch (    Exception g) {
      g.printStackTrace();
    }
  }
}
