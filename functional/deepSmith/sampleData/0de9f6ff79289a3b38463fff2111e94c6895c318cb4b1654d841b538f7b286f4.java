public static String fn_A(String a,int b,char c){
  if (a.length() >= b) {
    return a;
  }
  StringBuilder d=new StringBuilder(b);
  d.append(a);
  for (int e=a.length(); e < b; e++) {
    d.append(c);
  }
  return d.toString();
}
