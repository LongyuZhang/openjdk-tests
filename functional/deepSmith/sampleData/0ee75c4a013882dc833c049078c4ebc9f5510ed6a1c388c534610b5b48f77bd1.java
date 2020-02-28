public static String fn_A(Date a,String[] b){
  if (b == null || b.length == 0) {
    b=new String[]{"","","","","","",""};
  }
  Calendar c=Calendar.getInstance();
  c.setTime(a);
  int d=c.get(Calendar.DAY_OF_WEEK) - 1;
  if (d < 0) {
    d=0;
  }
  return b[d];
}
