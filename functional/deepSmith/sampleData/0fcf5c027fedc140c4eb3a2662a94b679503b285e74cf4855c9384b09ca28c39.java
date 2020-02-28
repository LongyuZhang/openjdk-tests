public static double fn_A(double a){
  if (a == 0 || a == 1) {
    return a;
  }
 else {
    return a * fn_A(a - 1);
  }
}
