public static String fn_A(int a,String b){
  String c="                                         " + "  " + "                                         ";
  if (b != null && a < c.length() && a + b.length() < c.length()) {
    c=c.substring(0,a) + b + c.substring(a + b.length());
  }
  return c;
}
