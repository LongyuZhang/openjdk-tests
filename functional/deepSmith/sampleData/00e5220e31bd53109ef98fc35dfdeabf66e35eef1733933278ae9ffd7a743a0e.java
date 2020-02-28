private static String fn_A(long a){
  String b=Long.toHexString(a);
  int c=b.length();
  if (c < 8) {
    int d=8 - c;
    StringBuilder e=new StringBuilder();
    for (int f=0; f < d; f++) {
      e.append("0");
    }
    e.append(b);
    return e.toString();
  }
  return b.substring(0,8);
}
