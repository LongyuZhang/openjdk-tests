private static void add(Map<Class<?>,Class<?>> a,Map<Class<?>,Class<?>> b,Class<?> c,Class<?> d){
  a.put(c,d);
  b.put(d,c);
}
