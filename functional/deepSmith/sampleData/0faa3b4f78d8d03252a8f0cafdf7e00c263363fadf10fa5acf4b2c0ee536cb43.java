public static String fn_A(int a){
  StringBuffer b=new StringBuffer("0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ");
  Random c=new Random();
  StringBuffer d=new StringBuffer("");
  for (int e=0; e < a; ++e) {
    d.append(b.charAt(c.nextInt(b.length())));
  }
  return d.toString();
}
