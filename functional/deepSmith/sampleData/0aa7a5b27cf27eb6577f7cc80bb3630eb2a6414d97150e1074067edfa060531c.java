public static float[] fn_A(float[] a,int b,int c){
  int d=c - b;
  if (d < 0) {
    throw new IllegalArgumentException(b + " > " + c);
  }
  float[] e=new float[d];
  System.arraycopy(a,b,e,0,Math.min(a.length - b,d));
  return e;
}
