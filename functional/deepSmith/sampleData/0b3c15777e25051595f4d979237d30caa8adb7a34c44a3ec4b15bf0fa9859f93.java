private static String fn_A(String a){
  if (a.contains("\"") || a.contains("'")) {
    throw new IllegalArgumentException("Invalid character in parameter");
  }
  return "\"" + a + "\"";
}
