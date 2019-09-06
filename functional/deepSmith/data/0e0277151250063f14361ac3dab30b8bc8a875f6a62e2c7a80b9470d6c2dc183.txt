public static byte[] fn_A(char a){
  int b=(int)a;
  byte[] c=new byte[2];
  for (int d=c.length - 1; d > -1; d--) {
    c[d]=new Integer(b & 0xff).byteValue();
    b=b >> 8;
  }
  return c;
}
