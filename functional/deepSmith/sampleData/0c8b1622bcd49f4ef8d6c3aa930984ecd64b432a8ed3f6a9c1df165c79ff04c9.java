private static boolean[] fn_A(float[] a,float b){
  boolean[] c=new boolean[a.length];
  for (int d=0; d < a.length; d++) {
    c[d]=a[d] > b;
  }
  c[0]=c[c.length - 1]=false;
  return c;
}
