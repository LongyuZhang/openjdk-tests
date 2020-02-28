public static String fn_A(String a){
  String b=null;
  String[] c=null;
  a=a.trim().toLowerCase();
  c=a.split("[?]");
  if (a.length() > 0) {
    if (c.length > 1) {
      if (c[0] != null) {
        b=c[0];
      }
    }
  }
  return b;
}
