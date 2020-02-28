public static void fn_A(String a,String b,String c){
  byte[] d;
  if ("B15P".equals(a)) {
    d=new byte[]{(byte)0xd1,Integer.valueOf(b).byteValue(),Integer.valueOf(c).byteValue(),(byte)0x00};
  }
 else {
    Date e=new Date();
    Calendar f=Calendar.getInstance();
    d=new byte[]{(byte)0xAB,(byte)0x00,(byte)0x09,(byte)0xff,(byte)0x51,(byte)0x80,(byte)0x00,(byte)((f.get(Calendar.YEAR) - 2000)),(byte)(e.getMonth() + 1),(byte)(f.get(Calendar.DAY_OF_MONTH) - 1 & 0xff),(byte)0x00,(byte)0x00};
  }
}
