public static String fn_A(int a,String... b){
  String c="push:" + a;
  if (b != null && b.length > 0) {
    c+="#" + String.join("#",b);
  }
  return c;
}
