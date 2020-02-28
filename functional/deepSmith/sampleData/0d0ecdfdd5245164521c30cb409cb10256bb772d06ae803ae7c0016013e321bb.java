public static void fn_A(boolean[][] a,boolean[][] b,int c,int d){
  int e=a.length;
  if (c < 0 || c >= e) {
    return;
  }
  if (d < 0 || d >= e) {
    return;
  }
  if (!a[c][d]) {
    return;
  }
  if (b[c][d]) {
    return;
  }
  b[c][d]=true;
  fn_A(a,b,c + 1,d);
  fn_A(a,b,c,d + 1);
  fn_A(a,b,c,d - 1);
  fn_A(a,b,c - 1,d);
}
