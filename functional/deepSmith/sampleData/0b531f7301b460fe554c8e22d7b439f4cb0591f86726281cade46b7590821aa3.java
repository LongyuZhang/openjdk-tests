public static String fn_A(int a){
  final String[] b={"","","","","","","","","",""};
  final String[] c={"","","","","","","","","","","",""};
  return b[(a - 4) % 10] + c[(a - 4) % 12] + "";
}
