public static String fn_A(byte[] a,String b,String c){
  try {
    return new String(a,b);
  }
 catch (  UnsupportedEncodingException d) {
    return c == null ? null : c;
  }
}
