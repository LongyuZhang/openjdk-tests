public static String fn_A(){
  String a[]={"+8613","+8615","+8617","+8618","+8616"};
  Random b=new Random();
  String c=a[b.nextInt(a.length)];
  for (int d=0; d < 9; d++) {
    c=c + b.nextInt(10);
  }
  return c;
}
