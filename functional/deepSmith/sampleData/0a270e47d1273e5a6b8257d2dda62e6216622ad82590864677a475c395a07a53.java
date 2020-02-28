public static float[] fn_A(float[] a,int b,int c){
  for (int d=b; d < b + c; d++) {
    int e=d - b;
    a[d]=(float)(a[d] * 0.5 * (1.0 - Math.cos(2.0 * Math.PI * e / c)));
  }
  return a;
}
