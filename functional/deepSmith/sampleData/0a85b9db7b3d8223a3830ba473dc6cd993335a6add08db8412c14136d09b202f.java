public static String fn_A(String a){
  if ((a != null) && (a.length() > 0)) {
    int b=a.lastIndexOf('.');
    int c=a.lastIndexOf('?');
    if ((b > -1) && (b < (a.length() - 1))) {
      if (c > -1) {
        return a.substring(b + 1,c);
      }
      return a.substring(b + 1);
    }
  }
  return a;
}
