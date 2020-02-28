public static boolean fn_A(){
  String a=System.getProperty("os.name").toLowerCase();
  return (a.indexOf("win") >= 0);
}
