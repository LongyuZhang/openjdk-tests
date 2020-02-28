static boolean fn_A(Class a,Class b){
  while (a != null) {
    if (a == b) {
      return true;
    }
    a=a.getSuperclass();
  }
  return false;
}
