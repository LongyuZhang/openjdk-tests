private static int fn_A(int a){
  int[][] b=new int[a + 1][a + 1];
  int c, d, e;
  for (c=0; c < b.length; c++) {
    b[c][0]=0;
    b[0][c]=1;
  }
  for (c=1; c < b.length; c++) {
    b[c][1]=1;
    for (d=2; d < b[0].length; d++) {
      e=c - d;
      if (e < 0) {
        b[c][d]=b[c][d - 1];
      }
 else {
        b[c][d]=b[c][d - 1] + b[e][d];
      }
    }
  }
  c--;
  int f=b[c][c - 1];
  return (f + 1);
}
