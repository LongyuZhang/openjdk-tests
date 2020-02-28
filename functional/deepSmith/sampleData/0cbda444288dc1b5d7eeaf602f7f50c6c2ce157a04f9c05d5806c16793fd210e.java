public static int fn_A(byte[] a){
  int b=0;
  int c=a[0] & 0xff;
  int d=a[1] & 0xff;
  int e=a[2] & 0xff;
  int f=a[3] & 0xff;
  f<<=24;
  e<<=16;
  d<<=8;
  b=c | d | e| f;
  return b;
}
