public static void fn_A(String[] a,int b){
  int c=a.length;
  int d=256;
  String[] e=new String[c];
  for (int f=b - 1; f >= 0; f--) {
    int[] g=new int[d + 1];
    for (int h=0; h < c; h++) {
      g[a[h].charAt(f) + 1]++;
    }
    for (int i=0; i < d; i++) {
      g[i + 1]+=g[i];
    }
    for (int j=0; j < c; j++) {
      e[g[a[j].charAt(f)]++]=a[j];
    }
    for (int k=0; k < c; k++) {
      a[k]=e[k];
    }
  }
}
