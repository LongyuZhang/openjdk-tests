public static <T,U>Map<T,U> fn_A(List<T> a,List<U> b){
  Map<T,U> c=new HashMap<T,U>();
  for (int d=0; d < a.size(); d++) {
    T e=a.get(d);
    c.put(e,b.get(d));
  }
  return c;
}
