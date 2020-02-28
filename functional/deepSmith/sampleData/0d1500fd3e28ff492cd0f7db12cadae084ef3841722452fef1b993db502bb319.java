public static int fn_A(final int a){
  if ((a & (0xffffffff << 7)) == 0) {
    return 1;
  }
  if ((a & (0xffffffff << 14)) == 0) {
    return 2;
  }
  if ((a & (0xffffffff << 21)) == 0) {
    return 3;
  }
  if ((a & (0xffffffff << 28)) == 0) {
    return 4;
  }
  return 5;
}
