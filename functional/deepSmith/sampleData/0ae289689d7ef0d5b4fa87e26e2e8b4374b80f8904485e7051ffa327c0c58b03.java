public static String fn_A(String[] a,String b){
  StringBuilder c=new StringBuilder();
  boolean d=true;
  for (  String e : a) {
    if (!d) {
      c.append(b);
    }
    c.append(e);
    d=false;
  }
  return c.toString();
}
