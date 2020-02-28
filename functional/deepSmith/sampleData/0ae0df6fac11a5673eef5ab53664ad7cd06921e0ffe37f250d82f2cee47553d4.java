private static int[] fn_A(int a){
  int[] b=new int[8];
  int c=0;
  int d=b.length - 1;
  while (true) {
    if ((a & 0x1) != c) {
      c=a & 0x1;
      d--;
      if (d < 0) {
        break;
      }
    }
    b[d]++;
    a>>=1;
  }
  return b;
}
