public static Date fn_A(Date a){
  Calendar b=Calendar.getInstance();
  b.setTime(a);
  int c=b.get(Calendar.YEAR);
  int d=b.get(Calendar.MONTH);
  int e=b.get(Calendar.DAY_OF_MONTH);
  return new GregorianCalendar(c,d,e,23,59,59).getTime();
}
