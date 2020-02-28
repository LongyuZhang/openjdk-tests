public static FileOutputStream fn_A(String a,boolean b) throws FileNotFoundException {
  File c=new File(a);
  String d=c.getParent();
  File e=new File(d);
  if (!e.exists()) {
    e.mkdirs();
  }
  return new FileOutputStream(a,b);
}
