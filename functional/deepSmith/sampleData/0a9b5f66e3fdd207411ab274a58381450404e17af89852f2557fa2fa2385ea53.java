public static int fn_A(Calendar a,Calendar b){
  if ((a == null) || (b == null)) {
    return -1;
  }
  long c=a.getTimeInMillis() - b.getTimeInMillis();
  c/=86400000L;
  return (int)c;
}
