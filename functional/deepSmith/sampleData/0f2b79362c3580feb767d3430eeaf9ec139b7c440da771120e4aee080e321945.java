public static boolean fn_A(File a){
  boolean b=false;
  if (a != null && a.exists()) {
    if (a.isDirectory()) {
      for (      File c : a.listFiles()) {
        fn_A(c);
      }
    }
    b=a.delete();
  }
  return b;
}
