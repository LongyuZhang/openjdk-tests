private static String fn_A(String[] a){
  if (a == null) {
    return "";
  }
  if (a.length >= 2) {
    return a[1];
  }
  return "";
}
