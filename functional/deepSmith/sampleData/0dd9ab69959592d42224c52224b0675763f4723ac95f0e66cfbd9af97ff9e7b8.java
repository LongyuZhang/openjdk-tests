private static boolean fn_A(Class<?>[] a,Object[] b){
  if ((a == null) || (a.length == 0)) {
    return ((b == null) || (b.length == 0));
  }
  if ((b == null) || (a.length != b.length)) {
    return false;
  }
  for (int c=0; c < a.length; c++) {
    if ((b[c] != null) && (!a[c].isAssignableFrom(b[c].getClass()))) {
      return false;
    }
  }
  return true;
}
