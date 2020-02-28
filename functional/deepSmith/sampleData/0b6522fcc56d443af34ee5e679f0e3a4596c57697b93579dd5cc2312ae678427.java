public static String[] fn_A(int a,int b,int c){
  String[] d=new String[3];
  d[0]=String.valueOf(a);
  if (b + 1 < 10) {
    d[1]="0" + String.valueOf(b + 1);
  }
 else {
    d[1]=String.valueOf(b + 1);
  }
  if (c < 10) {
    d[2]="0" + String.valueOf(c);
  }
 else {
    d[2]=String.valueOf(c);
  }
  return d;
}
