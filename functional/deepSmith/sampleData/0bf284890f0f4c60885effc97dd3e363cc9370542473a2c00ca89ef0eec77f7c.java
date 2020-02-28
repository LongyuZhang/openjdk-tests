public static <T>HashSet<T> fn_A(T... a){
  HashSet<T> b=new HashSet<T>(a.length);
  for (  T c : a) {
    b.add(c);
  }
  return b;
}
