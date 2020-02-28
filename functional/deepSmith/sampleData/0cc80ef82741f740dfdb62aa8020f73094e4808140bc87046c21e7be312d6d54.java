public static List fn_A(int a){
  List<String> b=new ArrayList<String>();
  Calendar c=Calendar.getInstance();
  String d="";
  String e="01";
  for (int f=0; f < 12 + 1; f++) {
    if (f < 10) {
      d="0" + f + "";
    }
 else {
      d=f + "";
    }
    if (f >= 1) {
      b.add(a + "-" + d+ "-"+ e+ " 00:00:00");
    }
  }
  return b;
}
