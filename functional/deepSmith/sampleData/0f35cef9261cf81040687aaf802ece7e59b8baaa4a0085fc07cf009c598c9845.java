public static String fn_A(String a){
  StringBuilder b=new StringBuilder("");
  String[] c=a.split("/");
  if (c.length <= 3) {
    return "";
  }
  for (int d=0; d < c.length; d++) {
    if (d > 2) {
      b.append(c[d] + "/");
    }
  }
  return b.substring(0,b.length() - 1);
}
