public static double fn_A(double a){
  while (a >= 360.0) {
    a-=360.0;
  }
  while (a < 0.0) {
    a+=360.0;
  }
  return a;
}
