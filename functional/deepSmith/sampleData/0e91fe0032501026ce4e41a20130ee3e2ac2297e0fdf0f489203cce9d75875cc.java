private static boolean fn_A(String a,String b){
  try {
    File c=new File(a);
    if (!c.exists()) {
      c.getParentFile().mkdirs();
      c.createNewFile();
    }
    DataOutputStream d=new DataOutputStream(new FileOutputStream(c));
    d.write(b.getBytes("utf-8"));
    d.close();
    return true;
  }
 catch (  Exception e) {
    e.printStackTrace();
    return false;
  }
}
