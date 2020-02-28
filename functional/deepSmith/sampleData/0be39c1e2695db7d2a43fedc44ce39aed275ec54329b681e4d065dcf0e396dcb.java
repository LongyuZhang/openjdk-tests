public static String fn_A(byte[] a){
  String b="0123456789ABCDEF";
  String c="";
  String d="";
  for (int e=0; e < a.length; e++) {
    d=String.valueOf(b.charAt((a[e] & 0xF0) >> 4));
    d+=String.valueOf(b.charAt(a[e] & 0x0F));
    c+=d;
  }
  return c;
}
