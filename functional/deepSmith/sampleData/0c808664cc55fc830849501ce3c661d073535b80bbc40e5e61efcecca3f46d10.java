private static Class fn_A(String a){
  Class b=null;
  try {
    b=Class.forName(a);
  }
 catch (  ClassNotFoundException c) {
    c.printStackTrace();
  }
  return b;
}
