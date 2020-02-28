public static <D extends Map<String,String>>D fn_A(final String a,final D b){
  final String[] c=a.split("&");
  for (  final String d : c) {
    final String[] e=d.split("=");
    b.put(e[0],e[1]);
  }
  return b;
}
