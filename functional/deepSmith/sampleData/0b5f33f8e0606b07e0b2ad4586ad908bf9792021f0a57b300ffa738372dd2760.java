public static long fn_A(Date a){
  long b=new Date().getTime() - a.getTime();
  return b / (60 * 60 * 1000);
}
