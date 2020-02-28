public static String fn_A(String a,int b){
  String c="";
  try {
    byte[] d=a.getBytes("UTF-8");
    if (b < d.length) {
      c=new String(d,0,b,"UTF-8");
    }
 else {
      c=new String(d,"UTF-8");
    }
  }
 catch (  UnsupportedEncodingException e) {
    e.printStackTrace();
  }
  return c;
}
