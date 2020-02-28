static int fn_A(float[] a,float b){
  int c=0;
  int d=a.length - 2;
  if (d == 0) {
    return 1;
  }
  int e=d >>> 1;
  while (true) {
    if (a[e + 1] <= b) {
      c=e + 1;
    }
 else {
      d=e;
    }
    if (c == d) {
      return c + 1;
    }
    e=(c + d) >>> 1;
  }
}
