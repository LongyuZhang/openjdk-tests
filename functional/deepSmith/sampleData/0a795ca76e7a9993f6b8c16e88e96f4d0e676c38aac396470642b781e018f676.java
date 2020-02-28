public static char fn_A(){
  Scanner a=new Scanner(System.in);
  boolean b=true;
  char c='z';
  System.out.println("Enter 'a' for Addition \nEnter 's' for Subtraction \nEnter 'm' for Multiplication \nEnter 'd' for Division");
  while (b) {
    try {
      c=a.next().charAt(0);
    }
 catch (    Exception d) {
      System.out.println("Invalid input. 'a' for Addition, 's' for Subtraction, 'm' for Multiplication, 'd' for Division");
      a.next();
    }
switch (c) {
case 'a':
      b=false;
    break;
case 's':
  b=false;
break;
case 'm':
b=false;
break;
case 'd':
b=false;
break;
}
}
return c;
}
