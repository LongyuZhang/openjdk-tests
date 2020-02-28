public static String fn_A(String a){
  int b=a.lastIndexOf("/");
  if (b != -1) {
    return a.substring(b + 1,a.length());
  }
  return a;
}
