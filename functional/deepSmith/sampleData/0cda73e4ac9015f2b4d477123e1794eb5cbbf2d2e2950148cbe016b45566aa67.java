public static int fn_A(int a,int b){
  int c=b % a == 0 ? b / a : b / a + 1;
  if (c <= 1) {
    return 1;
  }
  return c;
}
