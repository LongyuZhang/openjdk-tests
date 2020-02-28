public static long fn_A(Date a,Date b){
  long c=b.getTime() - a.getTime();
  long d=c / (1000 * 60 * 60* 24);
  return d;
}
