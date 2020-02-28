public static int fn_A(int[] a){
  if (a.length == 0) {
    return 0;
  }
  if (a.length == 1) {
    return a[0];
  }
  if (a.length == 2) {
    return Math.max(a[0],a[1]);
  }
  int[] b=new int[a.length];
  b[0]=a[0];
  for (int c=1; c < a.length - 1; c++) {
    b[c]=a[c];
    for (int d=0; d < c - 1; d++) {
      if (b[d] + a[c] > b[c]) {
        b[c]=b[d] + a[c];
      }
    }
  }
  int[] e=new int[a.length];
  e[1]=a[1];
  for (int f=2; f < a.length; f++) {
    e[f]=a[f];
    for (int g=1; g < f - 1; g++) {
      if (e[g] + a[f] > e[f]) {
        e[f]=e[g] + a[f];
      }
    }
  }
  System.out.println(b[a.length - 2]);
  System.out.println(e[a.length - 1]);
  return Math.max(b[a.length - 2],e[a.length - 1]);
}
