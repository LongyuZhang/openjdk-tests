public static String fn_A(String a){
  try {
    sun.misc.BASE64Decoder b=new sun.misc.BASE64Decoder();
    return new String(b.decodeBuffer(a));
  }
 catch (  IOException c) {
    c.printStackTrace();
  }
  return null;
}
