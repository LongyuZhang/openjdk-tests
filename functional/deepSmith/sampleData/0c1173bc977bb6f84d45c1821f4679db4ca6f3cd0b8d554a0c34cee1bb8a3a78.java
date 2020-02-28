public static void fn_A(String a){
  int b=10;
  int c=0;
  int d=1;
  String e=a;
  System.out.print("+");
  int f=0;
  if (e.length() > f) {
    f=e.length();
  }
  for (int g=0; g <= f + 1; g++) {
    System.out.print("-");
  }
  System.out.print("+");
  System.out.println();
  System.out.print("| " + e);
  for (int h=e.length(); h <= f - 1; h++) {
    System.out.print(" ");
  }
  System.out.print(" |");
  System.out.println();
  System.out.print("+");
  for (int i=0; i <= f + 1; i++) {
    System.out.print("-");
  }
  System.out.print("+");
  System.out.println();
}
