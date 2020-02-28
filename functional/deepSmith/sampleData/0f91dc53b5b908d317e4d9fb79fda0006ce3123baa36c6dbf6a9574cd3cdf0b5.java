public static void main(String[] a){
  while (true) {
    try {
      System.out.println(new Date());
      Thread.sleep(1000);
    }
 catch (    InterruptedException b) {
      b.printStackTrace();
    }
  }
}
