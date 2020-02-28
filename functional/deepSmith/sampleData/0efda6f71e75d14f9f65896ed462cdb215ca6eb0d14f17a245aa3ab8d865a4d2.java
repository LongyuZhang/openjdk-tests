public static String fn_A(byte[] a,int b,int c){
  int d=1, e=0;
  for (int f=b; f < c; ++f) {
    d=(d + a[f]) % 65521;
    e=(e + d) % 65521;
  }
  return Integer.toHexString((e << 16) | d);
}
