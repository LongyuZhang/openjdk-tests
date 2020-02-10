public static int[] fn_A(int[][] a,int b){
  int c=a.length, d=a[0].length, e=0, f=c * d - 1;
  while (e <= f) {
    int g=e + (f - e) / 2;
    int h=g / d, i=g % d;
    if (a[h][i] == b) {
      return new int[]{h,i};
    }
 else     if (a[h][i] < b) {
      e=g + 1;
    }
 else {
      f=g - 1;
    }
  }
  return new int[]{-1,-1};
}
