protected static String[] fn_A(String[] a){
  String[] b=new String[a.length];
  for (int c=0; c < a.length; c++) {
    b[c]=a[c].trim();
  }
  return b;
}
