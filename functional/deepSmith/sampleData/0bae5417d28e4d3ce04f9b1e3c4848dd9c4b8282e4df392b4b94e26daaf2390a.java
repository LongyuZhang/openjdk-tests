public static Set<String> fn_A(Set<String> a,String b){
  if (a.isEmpty() && (b == null || b.isEmpty())) {
    return Collections.emptySet();
  }
  HashSet<String> c=new HashSet<String>();
  c.addAll(a);
  if (b != null && !b.isEmpty()) {
    Collections.addAll(c,b.split("\\s*,\\s*"));
  }
  return c;
}
