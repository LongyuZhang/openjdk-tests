public static void main(String[] a){
  for (  Map.Entry b : System.getenv().entrySet()) {
    System.out.println(b.getKey() + ": " + b.getValue());
  }
}
