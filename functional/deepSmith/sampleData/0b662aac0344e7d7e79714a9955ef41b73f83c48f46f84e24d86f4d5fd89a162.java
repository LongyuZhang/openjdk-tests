public static String fn_A(String a){
  StringBuffer b=new StringBuffer();
  for (int c=0; c < a.length(); c++) {
    char d=a.charAt(c);
    b.append("\\u" + Integer.toHexString(d));
  }
  String e=b.toString();
  return e.replaceAll("\\\\","0x");
}
