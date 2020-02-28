public static String fn_A(String a){
  String b=a.substring(a.lastIndexOf(".") + 1);
  int c=(int)(Math.random() * 10000);
  String d=String.valueOf(System.currentTimeMillis() + c) + "." + b;
  return d;
}
