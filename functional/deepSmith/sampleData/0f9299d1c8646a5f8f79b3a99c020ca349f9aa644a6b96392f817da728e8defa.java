public static int fn_A(Date a){
  if (a == null) {
    throw new IllegalArgumentException("dnull");
  }
  Calendar b=Calendar.getInstance();
  b.setTime(a);
  return b.get(Calendar.DAY_OF_YEAR);
}
