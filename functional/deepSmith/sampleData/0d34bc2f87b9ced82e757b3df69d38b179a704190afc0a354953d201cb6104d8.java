static String fn_A(String a){
  if (a.length() == 0) {
    return a;
  }
  return Character.toUpperCase(a.charAt(0)) + a.substring(1);
}
