public static int fn_A(int[] a){
  int[] b=new int[a.length];
  b[0]=1;
  int c=1, d=0;
  for (int e=1; e < a.length; e++) {
    b[e]=1;
    for (int f=0; f < e; f++) {
      if (a[f] < a[e]) {
        if (b[f] + 1 > b[e]) {
          b[e]=b[f] + 1;
          d=f;
        }
      }
    }
    if (c < b[e]) {
      c=b[e];
      System.out.println(d + " : " + e);
    }
  }
  return c;
}
