public static String fn_A(Reader a) throws IOException {
  try {
    StringWriter b=new StringWriter();
    char[] c=new char[1024];
    int d;
    while ((d=a.read(c)) != -1) {
      b.write(c,0,d);
    }
    return b.toString();
  }
  finally {
    a.close();
  }
}
