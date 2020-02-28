public static String fn_A(final int a){
  if (a < 1000) {
    return Integer.toString(a);
  }
 else   if (a < 1100) {
    return "1.0." + (a - 1000);
  }
 else {
    StringBuffer b=new StringBuffer(Integer.toString(a));
    b.insert(2,'.');
    b.insert(1,'.');
    return b.toString();
  }
}
