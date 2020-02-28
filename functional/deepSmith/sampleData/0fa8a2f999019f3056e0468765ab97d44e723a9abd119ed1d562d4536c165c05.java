public static String fn_A(){
  Random a=new Random();
  Integer b=a.nextInt(9999);
  return String.valueOf(b < 1000 ? b+=1000 : b);
}
