public static String toString(byte[] a){
  try {
    return new String(a,"utf-8");
  }
 catch (  UnsupportedEncodingException b) {
    return null;
  }
}
