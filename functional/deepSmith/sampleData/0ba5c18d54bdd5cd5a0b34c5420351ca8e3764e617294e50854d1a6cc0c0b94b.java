public static Date fn_A(){
  GregorianCalendar a=new GregorianCalendar();
  a.add(Calendar.MONTH,1);
  a.set(Calendar.DATE,1);
  a.add(Calendar.DATE,-1);
  return a.getTime();
}
