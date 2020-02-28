public static byte[][] fn_A(String a){
  byte[][] b=new byte[4][4];
  for (int c=0; c < 32; c+=2) {
    String d=a.substring(c,c + 2);
    b[(c / 2) % 4][(c / 8)]=Integer.decode("0x" + d).byteValue();
  }
  return b;
}
