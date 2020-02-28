public static int fn_A(){
  StackTraceElement[] a=Thread.currentThread().getStackTrace();
  return a.length;
}
