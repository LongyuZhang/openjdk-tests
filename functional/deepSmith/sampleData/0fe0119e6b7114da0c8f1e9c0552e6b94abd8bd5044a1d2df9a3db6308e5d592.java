@SuppressWarnings({"unchecked","rawtypes"}) public final static <E>E get(Map a,Object b,E c){
  Object d=a.get(b);
  if (d == null) {
    return c;
  }
  return (E)d;
}
