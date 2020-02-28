public static long[] fn_A(long[] a,int b){
  long[] c=new long[b];
  System.arraycopy(a,0,c,0,Math.min(a.length,b));
  return c;
}
