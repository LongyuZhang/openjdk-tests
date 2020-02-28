public static int fn_A(Properties a,String b,int c){
  String d=a.getProperty(b);
  if (d == null) {
    return c;
  }
 else {
    try {
      return new Integer(d);
    }
 catch (    NumberFormatException e) {
      throw new NumberFormatException("Can't convert value <" + d + "> for parameter <"+ b+ "> to int.");
    }
  }
}
