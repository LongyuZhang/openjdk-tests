static int fn_A(int a){
  a^=(a << 6);
  a^=(a >>> 21);
  a^=(a << 7);
  return a;
}
