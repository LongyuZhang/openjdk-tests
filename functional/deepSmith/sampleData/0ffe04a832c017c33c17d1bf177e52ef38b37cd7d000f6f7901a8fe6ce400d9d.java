public static String toString(Object[] a){
  StringBuilder b=new StringBuilder();
  b.append("[");
  for (int c=0; c < a.length; c++) {
    b.append(a[c]);
    if (c < a.length - 1) {
      b.append(",");
    }
  }
  b.append("]");
  return b.toString();
}
