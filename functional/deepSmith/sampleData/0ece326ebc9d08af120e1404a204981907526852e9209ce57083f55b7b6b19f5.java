public static List<int[]> fn_A(int[] a){
  List<int[]> b=new ArrayList<>();
  if (a.length == 0) {
    return b;
  }
  b.add(Arrays.copyOf(a,2));
  if (a.length > 2) {
    b.addAll(fn_A(Arrays.copyOfRange(a,2,a.length)));
  }
  return b;
}
