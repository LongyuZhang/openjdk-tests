static int fn_A(byte[] a,int b){
  int c=0;
  c|=(a[b++] & 0xFF) << 24;
  c|=(a[b++] & 0xFF) << 16;
  c|=(a[b++] & 0xFF) << 8;
  c|=(a[b++] & 0xFF);
  return c;
}
