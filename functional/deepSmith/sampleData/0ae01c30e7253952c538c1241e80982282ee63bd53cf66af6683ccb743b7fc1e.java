public static void main(String[] a) throws IOException {
  FileReader b=new FileReader("src\\day21\\IO\\p4\\demo.txt");
  FileWriter c=new FileWriter("src\\day21\\IO\\p4\\demo3.txt");
  int d;
  while ((d=b.read()) != -1) {
    c.write(d);
  }
  c.close();
  b.close();
}
