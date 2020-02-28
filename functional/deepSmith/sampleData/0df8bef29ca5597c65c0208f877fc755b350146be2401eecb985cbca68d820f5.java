public static final <T>boolean fn_A(Comparable<T> a,T b){
  if (a == null) {
    if (b != null) {
      return false;
    }
  }
 else   if (a.compareTo(b) <= 0) {
    return false;
  }
  return true;
}
