public static void main(String[] a){
  TreeMap<Integer,String> b=new TreeMap<Integer,String>();
  b.put(2,"two");
  b.put(1,"one");
  b.put(3,"three");
  b.put(6,"six");
  b.put(5,"five");
  System.out.println("Value before modification: " + b);
  System.out.println("Removed value: " + b.remove(5));
  System.out.println("Value after modification: " + b);
}
