public static boolean fn_A(int a,int b,int c){
  if (a < 0 || b < 0 || c < 0) {
    return false;
  }
  int d=a * 5 + b;
  if (d < c) {
    System.out.println("Not enough bags to make a package.");
  }
 else {
    int e=(c / 5);
    if (e * 5 + b >= c) {
      return true;
    }
  }
  return false;
}
