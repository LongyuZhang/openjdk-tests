static public String fn_A(String a,String[] b,String[] c){
  int d=b.length;
  assert(d == c.length);
  String e="", f="";
  int g=0;
  for (int h=0; h < d; ++h) {
    if (c[h] == null) {
      continue;
    }
    if (g > 0) {
      e+=" , ";
      f+=" , ";
    }
    ++g;
    e+=b[h];
    if (c[h].toString().equals("now()")) {
      f+=String.format("%s",c[h].toString());
    }
 else {
      f+=String.format("\'%s\'",c[h].toString());
    }
  }
  return String.format("insert into %s (%s) values (%s);",a,e,f);
}
