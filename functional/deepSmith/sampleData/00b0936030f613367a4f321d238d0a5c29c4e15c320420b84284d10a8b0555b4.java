public static void main(String[] a){
  Properties b=new Properties();
  b.put("1","one");
  b.put("2","two");
  b.put("3","three");
  System.out.println("prop:" + b);
  Set<Object> c=b.keySet();
  for (  Object d : c) {
    Object e=b.get(d);
    System.out.println(d + "=" + e);
  }
}
