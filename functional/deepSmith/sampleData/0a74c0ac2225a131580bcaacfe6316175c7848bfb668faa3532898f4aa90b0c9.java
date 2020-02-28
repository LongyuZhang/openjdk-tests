public static String fn_A(List<Map> a){
  String b="[ \n";
  for (  Map<String,Object> c : a) {
    b+=c.toString();
    b+="\n";
  }
  b+=" ]";
  return b;
}
