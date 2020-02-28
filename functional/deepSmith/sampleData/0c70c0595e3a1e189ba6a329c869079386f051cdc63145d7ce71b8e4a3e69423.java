static String fn_A(String a){
  if (a.indexOf(';') < 0) {
    return a;
  }
  StringBuilder b=new StringBuilder(a.length());
  int c=0;
  int d=a.length();
  while (c < d) {
    int e=a.indexOf(';',c);
    if (e < 0) {
      e=d;
    }
    b.append(a.substring(c,e));
    int f=a.indexOf('/',e);
    if (f < 0) {
      c=d;
    }
 else {
      c=f;
    }
  }
  return b.toString();
}
