public static void main(String[] a){
  ArrayList<String> b=new ArrayList<String>();
  b.add("hello");
  b.add("world");
  b.add("java");
  Iterator<String> c=b.iterator();
  while (c.hasNext()) {
    String d=c.next();
    System.out.println(d);
  }
  for (int e=0; e < b.size(); e++) {
    String f=b.get(e);
    System.out.println(f);
  }
}
