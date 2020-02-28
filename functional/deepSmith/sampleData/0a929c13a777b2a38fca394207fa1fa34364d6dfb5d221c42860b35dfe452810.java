public static int[] fn_A(int[] a,int[] b){
  Arrays.sort(a);
  Arrays.sort(b);
  int c=a.length;
  int d=b.length;
  int[] e=new int[c > d ? d : c];
  int f=0;
  for (int g=0, h=0; g < a.length && h < b.length; ) {
    if (a[g] == b[h]) {
      e[f++]=a[g];
      g++;
      h++;
    }
 else     if (a[g] < b[h]) {
      g++;
    }
 else {
      h++;
    }
  }
  int[] i=new int[f];
  for (int j=0; j < f; j++) {
    i[j]=e[j];
  }
  return i;
}
