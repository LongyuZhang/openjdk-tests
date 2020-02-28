public static List<File> fn_A(File a,String b){
  List<File> c=new ArrayList<>();
  if (a != null && a.exists() && a.isDirectory()) {
    File[] d=a.listFiles();
    if (d == null || d.length == 0) {
      return c;
    }
    for (    File e : d) {
      if (e.isDirectory()) {
        c.addAll(fn_A(e,b));
      }
 else {
        String f=e.getName();
        if (f.equals(b)) {
          c.add(e);
        }
      }
    }
  }
  return c;
}
