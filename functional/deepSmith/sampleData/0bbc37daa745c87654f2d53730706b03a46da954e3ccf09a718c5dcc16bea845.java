public static int fn_A(int[] a,int[] b){
  Arrays.sort(a);
  Arrays.sort(b);
  int c=0;
  int d=0, e=0;
  while (d < a.length && e < b.length) {
    if (a[d] <= b[e]) {
      c++;
      d++;
      e++;
    }
 else {
      e++;
    }
  }
  return c;
}
