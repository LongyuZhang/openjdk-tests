static String fn_A(int a){
  int b=a / (1024 * 1024);
  int c=a % (1024 * 1024) / 1024;
  int d=a % (1024 * 1024) % 1024;
  return b > 0 ? b + "." + c / 100 + "MB" : c > 0 ? c + "." + d / 100 + "KB" : d + "B";
}
