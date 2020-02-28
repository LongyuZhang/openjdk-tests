public static boolean fn_A(String a,String b){
  if (a == null || b == null) {
    return false;
  }
  if (a.startsWith(b)) {
    return true;
  }
  if (a.length() < b.length()) {
    return false;
  }
  String c=a.substring(0,b.length()).toLowerCase();
  String d=b.toLowerCase();
  return c.equals(d);
}
