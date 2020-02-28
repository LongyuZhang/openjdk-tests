public static void fn_A(DataOutputStream a,int b,String c) throws IOException {
  a.writeInt(b);
  a.writeBytes(String.format("%-32s",c));
}
