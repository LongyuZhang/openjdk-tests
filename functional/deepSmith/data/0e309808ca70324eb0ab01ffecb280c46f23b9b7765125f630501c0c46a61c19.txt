public static int fn_A(int[] a){
  int b=0;
  int c=0;
  for (int d=0; d < a.length; d++) {
    if ((d == 0) || (a[d] > b)) {
      c=d;
      b=a[d];
    }
  }
  return c;
}
