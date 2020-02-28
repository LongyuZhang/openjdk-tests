public static Object fn_A(Serializable a){
  try {
    ByteArrayOutputStream b=new ByteArrayOutputStream();
    ObjectOutputStream c=new ObjectOutputStream(b);
    c.writeObject(a);
    c.flush();
    c.close();
    byte[] d=b.toByteArray();
    ByteArrayInputStream e=new ByteArrayInputStream(d);
    return new ObjectInputStream(e).readObject();
  }
 catch (  Exception f) {
    f.printStackTrace();
    return null;
  }
}
