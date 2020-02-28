private static Map<String,Boolean> fn_A(String... a){
  Map<String,Boolean> b=new HashMap<String,Boolean>();
  if (a != null) {
    for (    String c : a) {
      b.put(c,true);
    }
  }
  return b;
}
