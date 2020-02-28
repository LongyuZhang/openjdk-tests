public static Date fn_A(int a){
  Calendar b=Calendar.getInstance();
  b.setTime(new Date());
  b.add(Calendar.MINUTE,a);
  Date c=b.getTime();
  return c;
}
