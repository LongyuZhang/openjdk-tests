public final static boolean fn_A(String a){
  File b=new File(a);
  if (b.isDirectory()) {
    if (!b.exists()) {
      return b.mkdirs();
    }
  }
 else {
    File c=b.getParentFile();
    if (!c.exists()) {
      if (c.mkdirs()) {
        try {
          return b.createNewFile();
        }
 catch (        IOException d) {
          d.printStackTrace();
        }
      }
    }
  }
  return false;
}
