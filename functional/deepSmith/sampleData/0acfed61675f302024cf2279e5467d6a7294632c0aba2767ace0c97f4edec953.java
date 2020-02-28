public static <T>long fn_A(T[] a,Comparator<T> b){
  long c=0;
  int d=a.length;
  @SuppressWarnings("unchecked") T[] e=(T[])new Object[d];
  for (int f=1; f < d; f*=2) {
    for (int g=0; g < d; g+=2 * f) {
      int h=g;
      int i=Math.min(g + f,a.length);
      int j=i;
      int k=Math.min(g + 2 * f,a.length);
      for (int l=h; l < k; l++) {
        c++;
        if (h < j && (i >= k || b.compare(a[h],a[i]) < 0)) {
          e[l]=a[h++];
        }
 else {
          e[l]=a[i++];
        }
      }
    }
    c+=d;
    System.arraycopy(e,0,a,0,d);
  }
  return c;
}
