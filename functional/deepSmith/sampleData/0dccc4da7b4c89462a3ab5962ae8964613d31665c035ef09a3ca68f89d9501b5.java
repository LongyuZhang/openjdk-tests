private static String fn_A(int a){
  String b=String.valueOf(a & 15);
  String c=String.valueOf(a >> 4);
  return b + ":" + (c.length() == 1 ? ("0" + c) : c);
}
