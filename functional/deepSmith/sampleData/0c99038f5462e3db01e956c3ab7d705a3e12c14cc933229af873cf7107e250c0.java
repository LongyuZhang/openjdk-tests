public final static int fn_A(char[] a,int b,char c){
  for (int d=b; d < a.length; d++) {
    if (a[d] != c) {
      return d;
    }
  }
  return -1;
}
