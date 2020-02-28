public final static int compareTo(byte a[],byte b[]){
  if ((b == null) && (a == null)) {
    return 0;
  }
  if (a == null) {
    return -1;
  }
  if (b == null) {
    return 1;
  }
  if (b.length < a.length) {
    return 1;
  }
  if (b.length > a.length) {
    return -1;
  }
  for (int c=0; c < b.length; c++) {
    if ((b[c] & 0xff) > (a[c] & 0xff)) {
      return -1;
    }
 else     if ((b[c] & 0xff) < (a[c] & 0xff)) {
      return 1;
    }
  }
  return 0;
}
