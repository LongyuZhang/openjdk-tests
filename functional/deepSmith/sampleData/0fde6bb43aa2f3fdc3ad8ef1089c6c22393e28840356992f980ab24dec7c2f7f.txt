public static byte[] fn_A(long a){
  byte[] b=new byte[8];
  b[0]=(byte)(a >> 56);
  b[1]=(byte)((a << 8) >> 56);
  b[2]=(byte)((a << 16) >> 56);
  b[3]=(byte)((a << 24) >> 56);
  b[4]=(byte)((a << 32) >> 56);
  b[5]=(byte)((a << 40) >> 56);
  b[6]=(byte)((a << 48) >> 56);
  b[7]=(byte)((a << 56) >> 56);
  return b;
}
