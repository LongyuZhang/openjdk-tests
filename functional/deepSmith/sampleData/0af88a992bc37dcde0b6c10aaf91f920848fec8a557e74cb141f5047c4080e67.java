public static List<String> fn_A(){
  List<String> a=new ArrayList<>();
  Calendar b=Calendar.getInstance();
  String c=b.get(Calendar.YEAR) + "/";
  String d=b.get(Calendar.MONTH) + 1 + "";
  String e=b.get(Calendar.DAY_OF_MONTH) + "";
  String f=b.get(Calendar.HOUR_OF_DAY) + ":";
  String g=b.get(Calendar.MINUTE) + ":";
  String h=b.get(Calendar.SECOND) + "";
  a.add(c);
  a.add(d);
  a.add(e);
  a.add(f);
  a.add(g);
  a.add(h);
  return a;
}
