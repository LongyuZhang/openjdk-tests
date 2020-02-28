private static Map<String,String> fn_A(String a){
  Map<String,String> b=new HashMap<>();
  String[] c=a.split("[\\(\\)]");
  String d=c[0];
  String e=c[1].replace(")","").trim();
  b.put("params",e);
  b.put("name",d);
  return b;
}
