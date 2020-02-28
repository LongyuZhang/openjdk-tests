public static void main(String[] a){
  Scanner b=new Scanner(System.in);
  String c=b.nextLine();
  int d=Integer.parseInt(c);
  String e=b.nextLine();
  String f=b.nextLine();
  int g=0;
  for (int h=0; h < d; h++) {
    int i=(e.charAt(h) - '0');
    int j=(f.charAt(h) - '0');
    int k=i ^ j;
    if (k == 1) {
      g+=Math.pow(2,d - 1 - h);
    }
  }
  System.out.println(g);
}
