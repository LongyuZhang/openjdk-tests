public static boolean fn_A(){
  boolean a=false;
  String b=System.getProperty("os.name");
  if (b.toLowerCase().indexOf("windows") > -1) {
    a=true;
  }
  return a;
}
