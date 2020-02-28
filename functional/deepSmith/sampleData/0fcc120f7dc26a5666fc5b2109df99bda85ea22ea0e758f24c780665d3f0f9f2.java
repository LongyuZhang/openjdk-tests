public static int fn_A(Object a,int b){
  if (a == null || a.toString().equals("")) {
    return b;
  }
  try {
    return Integer.valueOf(a.toString());
  }
 catch (  Exception c) {
    try {
      return Double.valueOf((a.toString())).intValue();
    }
 catch (    Exception d) {
      return b;
    }
  }
}
