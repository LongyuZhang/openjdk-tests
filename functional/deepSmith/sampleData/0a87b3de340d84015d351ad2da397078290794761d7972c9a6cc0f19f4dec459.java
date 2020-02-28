protected static Vector<String> fn_A(Hashtable<String,String> a){
  Vector<String> b;
  Enumeration<String> c;
  String d;
  b=new Vector<String>();
  c=a.elements();
  while (c.hasMoreElements()) {
    d=c.nextElement();
    if (!b.contains(d)) {
      b.add(d);
    }
  }
  Collections.sort(b);
  return b;
}
