public static long fn_A(float a,float b){
  final int c=Float.floatToRawIntBits(a);
  final int d=Float.floatToRawIntBits(b);
  return ((long)c) << 32 | ((long)d);
}
