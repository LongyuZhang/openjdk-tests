public static boolean fn_A(int[] a,int[] b){
  if (a.length != b.length) {
    return false;
  }
 else {
    for (int c=0; c < a.length; c++) {
      if (a[c] != b[c]) {
        return false;
      }
    }
    return true;
  }
}
