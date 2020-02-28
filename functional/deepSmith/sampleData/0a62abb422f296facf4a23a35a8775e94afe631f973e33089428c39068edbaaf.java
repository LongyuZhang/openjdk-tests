public static int fn_A(int a,int b){
  if (a > b) {
    return 0;
  }
  if (a == b) {
    return a;
  }
  return a + new java.util.Random().nextInt(b - a);
}
