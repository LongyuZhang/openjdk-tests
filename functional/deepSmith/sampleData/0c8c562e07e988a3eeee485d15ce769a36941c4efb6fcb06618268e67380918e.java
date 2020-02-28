private static boolean fn_A(String a,String[] b){
  for (  String c : b) {
    if (a.matches(c)) {
      return true;
    }
  }
  return false;
}
