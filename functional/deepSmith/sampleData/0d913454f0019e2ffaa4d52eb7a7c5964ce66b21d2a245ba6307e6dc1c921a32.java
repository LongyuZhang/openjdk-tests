static int[] fn_A(int[] a){
  for (int b=0; b < a.length; b++) {
    a[b]=(int)(Math.random() * 101);
  }
  return a;
}
