public static String fn_A(){
  UUID a=UUID.randomUUID();
  String b=a.toString();
  b=b.replace("-","");
  return b;
}
