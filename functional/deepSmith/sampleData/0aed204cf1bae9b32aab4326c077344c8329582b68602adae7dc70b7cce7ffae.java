public static int[] fn_A(int[] a,int b){
  if (b == -1) {
    for (int c=0; c < a.length; c++) {
      a[c]=c;
    }
    return a;
  }
  for (int d=0; d < a.length; d++) {
    a[d]=b;
  }
  return a;
}
