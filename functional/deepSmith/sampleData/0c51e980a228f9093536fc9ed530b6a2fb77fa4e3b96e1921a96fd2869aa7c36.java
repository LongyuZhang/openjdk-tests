public static double fn_A(long[] a){
  long b=0L;
  for (  long c : a) {
    b+=c;
  }
  return (double)b / (double)a.length;
}
