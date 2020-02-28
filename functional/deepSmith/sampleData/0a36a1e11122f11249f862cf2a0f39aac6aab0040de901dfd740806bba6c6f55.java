private static String fn_A(String a){
  if (a != null) {
    if (a.length() == 0) {
      return "$element$ asc";
    }
 else     if ("desc".equals(a)) {
      return "$element$ desc";
    }
  }
  return a;
}
