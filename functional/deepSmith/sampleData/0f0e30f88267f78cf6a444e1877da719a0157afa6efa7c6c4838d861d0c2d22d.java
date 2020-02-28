private static StackTraceElement fn_A(){
  StackTraceElement[] a=new Exception("").getStackTrace();
  StackTraceElement b=null;
  final int c=a.length;
  for (int d=0; d < c; d++) {
    StackTraceElement e=a[d];
    String f=e.getClassName();
    if (f.equals("sun.reflect.NativeMethodAccessorImpl")) {
      b=a[d - 1];
      break;
    }
  }
  return b;
}
