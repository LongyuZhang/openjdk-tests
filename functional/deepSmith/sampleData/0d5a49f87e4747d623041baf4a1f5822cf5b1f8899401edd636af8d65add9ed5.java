protected static int fn_A(double[] a,double[] b,int c,int d){
  double e=a[(c + d) / 2];
{
  }
  double f;
{
  }
  while (c < d) {
    while ((a[c] < e) && (c < d)) {
      c++;
    }
    while ((a[d] > e) && (c < d)) {
      d--;
    }
    if (c < d) {
      f=a[c];
      a[c]=a[d];
      a[d]=f;
      f=b[c];
      b[c]=b[d];
      b[d]=f;
      c++;
      d--;
    }
  }
  if ((c == d) && (a[d] > e)) {
    d--;
  }
  return d;
}
