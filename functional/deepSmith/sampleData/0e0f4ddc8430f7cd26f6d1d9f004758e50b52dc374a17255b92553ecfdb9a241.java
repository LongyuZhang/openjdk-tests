public static int[][] fn_A(int[][] a,int[] b){
  int[][] c=new int[a.length + 1][];
  for (int d=0; d < a.length; d++) {
    c[d]=a[d];
  }
  c[c.length - 1]=b;
  return c;
}
