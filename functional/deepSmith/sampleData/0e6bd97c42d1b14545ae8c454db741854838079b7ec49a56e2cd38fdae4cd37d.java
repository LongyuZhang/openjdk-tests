private static int fn_A(char a){
switch (a) {
case 'Z':
    return 0;
case 'B':
  return 1;
case 'S':
return 2;
case 'C':
return 3;
case 'I':
case 'F':
return 4;
case 'J':
case 'D':
return 5;
case 'L':
case '[':
return 6;
default :
}
throw new RuntimeException(String.format("Unknown type %s: ",a));
}
