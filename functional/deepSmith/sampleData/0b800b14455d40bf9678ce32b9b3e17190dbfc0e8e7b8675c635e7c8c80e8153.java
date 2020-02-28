public static String fn_A(String a){
  if (a == null || (a.length()) == 0) {
    return a;
  }
  return String.valueOf(Character.toTitleCase(a.charAt(0))) + a.substring(1);
}
