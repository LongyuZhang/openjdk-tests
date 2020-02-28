static void fn_A(StringBuilder a,byte b){
  int c=b < 0 ? b + 256 : b;
  int d=c / 16;
  int e=c % 16;
  a.append("0123456789ABCDEF".substring(d,d + 1));
  a.append("0123456789ABCDEF".substring(e,e + 1));
}
