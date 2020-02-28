public static List<String> fn_A(String a,int b){
  List<String> c=new ArrayList<String>();
  int d=a.length();
  for (int e=0; e < d; e+=b) {
    c.add(a.substring(e,Math.min(d,e + b)));
  }
  return c;
}
