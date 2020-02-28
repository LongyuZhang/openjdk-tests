public static Date fn_A(Date a,int b){
  Calendar c=Calendar.getInstance();
  c.setTime(a);
  c.add(Calendar.MINUTE,-b);
  return c.getTime();
}
