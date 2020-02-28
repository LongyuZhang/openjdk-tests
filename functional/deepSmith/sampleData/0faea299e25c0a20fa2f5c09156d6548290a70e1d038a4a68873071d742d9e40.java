public static void main(String[] a){
  Scanner b=new Scanner(System.in);
  String c="";
  int d=0;
  int e=0;
  int f=0;
  int g=0;
  boolean h=false;
  System.out.println("Social Insurance Number");
  System.out.println("In Canada, all people are identified by the Government" + "with a Social Insurance Number (SIN) consisting of 9 digits");
  System.out.println("The first eight numbers" + "are assigned digits,while the last one is a digit check.");
  System.out.println("This program determines if the check digit is corrrect");
  do {
    d=0;
    e=0;
    f=0;
    g=0;
    System.out.println("Enter a SIN number: ");
    c=b.nextLine();
    c=c.trim();
    if (c.length() == 9) {
      try {
        e=Integer.parseInt(c);
        for (int i=1; i < c.length(); i=i + 1) {
          e=2 * (Integer.parseInt("" + c.charAt(i)));
          d=d + ((e % 10) + (e / 10));
          System.out.println("product: " + e + " even: "+ d);
          c=c.substring(0,i) + c.substring(i + 1,c.length());
          h=true;
        }
        for (int j=0; j < c.length() - 1; j++) {
          e=Integer.parseInt("" + c.charAt(j));
          f=f + e;
          System.out.println("product: " + e + " odd: "+ f);
          h=true;
        }
        e=d + f;
        g=Integer.parseInt(c.substring(c.length() - 1,c.length()));
        System.out.println(g);
        if (((e + 10) - (e % 10)) - e == g) {
          System.out.println("The SIN number is valid");
        }
 else {
          System.out.println("The SIN number is invalid");
          h=false;
        }
      }
 catch (      Exception k) {
        System.out.println("Invalid input, not a proper number");
        h=false;
      }
    }
 else {
      System.out.println("Invalid length, try again");
      h=false;
    }
  }
 while (!h);
}
