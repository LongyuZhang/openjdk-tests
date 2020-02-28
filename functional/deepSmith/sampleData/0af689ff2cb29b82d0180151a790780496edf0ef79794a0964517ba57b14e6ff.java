public static String get(String a,String... b){
  String c="1xio." + a.toLowerCase().replaceAll("^1xio_","").replace('_','.');
  String d=System.getenv(a);
  String e=null == d ? System.getProperty(c) : d;
  e=null == e && b.length > 0 ? b[0] : e;
  if (null != e) {
    System.setProperty(c,e);
    System.err.println("// -D" + c + "="+ "\""+ e+ "\"");
  }
  return e;
}
