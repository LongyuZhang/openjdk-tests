private static byte[] fn_A(byte[] a,int b,int c){
  int d=c - b;
  if (d < 0) {
    throw new IllegalArgumentException(b + " > " + c);
  }
  byte[] e=new byte[d];
  System.arraycopy(a,b,e,0,Math.min(a.length - b,d));
  return e;
}
