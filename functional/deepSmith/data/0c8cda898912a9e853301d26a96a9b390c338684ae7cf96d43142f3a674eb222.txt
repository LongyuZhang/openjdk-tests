private static int fn_A(int a,int b,int c,int d){
  int e=1;
  if (b > c || a > d) {
    int f=b / 2;
    int g=a / 2;
    while ((g / e) >= c && (f / e) >= d) {
      e*=2;
    }
  }
  return e;
}
