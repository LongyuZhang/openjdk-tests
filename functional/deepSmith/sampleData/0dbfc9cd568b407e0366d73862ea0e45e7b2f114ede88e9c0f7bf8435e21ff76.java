public static void main(String[] a) throws IOException {
  Scanner b=new Scanner(System.in);
  System.out.print("Enter a file name: ");
  String c=b.nextLine();
  FileInputStream d=new FileInputStream(c);
  while (d.available() != 0) {
    int e=d.read();
    int f=0;
    System.out.print((Integer.toHexString(e)));
    if (f % 2 == 0) {
      System.out.print(" ");
    }
    if ((f + 1) % 10 == 0) {
      System.out.println();
    }
    f++;
  }
  d.close();
}
