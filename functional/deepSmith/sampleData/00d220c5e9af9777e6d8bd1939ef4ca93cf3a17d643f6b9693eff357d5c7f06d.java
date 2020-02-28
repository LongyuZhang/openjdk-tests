private static void fn_A(double[] a){
  double[] b=a.clone();
{
  }
  for (int c=0; c < b.length; c++) {
    double d=0;
{
    }
    boolean e=false;
    for (int f=0; f < b.length; f++) {
      if (b[f] - b[c] > 700) {
        e=true;
        break;
      }
      d+=Math.exp(b[f] - b[c]);
    }
    if (e) {
      a[c]=0.0;
    }
 else {
      a[c]=1.0 / d;
    }
  }
}
