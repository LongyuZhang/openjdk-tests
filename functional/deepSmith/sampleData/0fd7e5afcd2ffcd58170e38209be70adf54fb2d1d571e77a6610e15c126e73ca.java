public static String fn_A(int a){
  String b="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
  Random c=new Random();
  String d="";
  for (int e=0; e < a; e++) {
    int f=c.nextInt(62);
    d+=b.substring(f,f + 1);
  }
  return d;
}
