public static StringBuilder append(StringBuilder a,Iterable<? extends Object> b,String c,String d,String e,String f,String g){
  Iterator<? extends Object> h=b.iterator();
  while (h.hasNext()) {
    if (c != null) {
      a.append(c);
    }
    a.append(h.next());
    if (d != null) {
      a.append(d);
    }
    if (h.hasNext() && f != null) {
      if (e != null) {
        a.append(e);
      }
      a.append(f);
      if (g != null) {
        a.append(g);
      }
    }
  }
  return a;
}
