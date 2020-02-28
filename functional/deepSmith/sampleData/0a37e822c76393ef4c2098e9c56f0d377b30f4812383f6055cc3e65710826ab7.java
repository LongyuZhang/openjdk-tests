public static HashMap<String,String> fn_A(HashMap<String,String> a){
  HashMap b=new HashMap<String,String>();
  for (  String c : a.keySet()) {
    if (c.equals("sign") || c.equals("sign_type") || a.get(c).isEmpty()) {
      continue;
    }
 else {
      b.put(c,a.get(c));
    }
  }
  return b;
}
