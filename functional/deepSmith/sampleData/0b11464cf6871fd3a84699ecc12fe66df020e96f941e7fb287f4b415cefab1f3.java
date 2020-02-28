protected static int fn_A(char a,int b){
  int c=Character.digit(a,16);
  if (c == -1) {
    throw new RuntimeException("Illegal hexadecimal character " + a + " at index "+ b);
  }
  return c;
}
