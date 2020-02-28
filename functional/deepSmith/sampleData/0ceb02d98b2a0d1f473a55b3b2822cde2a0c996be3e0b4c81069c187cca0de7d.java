public static void main(String a[]) throws Exception {
  File b=new File("D:\\text.txt");
  if (!b.exists()) {
    try {
      b.createNewFile();
    }
 catch (    Exception c) {
      c.printStackTrace();
    }
  }
  RandomAccessFile d=new RandomAccessFile(b,"rw");
  String e=null;
  int f=0;
  e="zhangsan";
  f=30;
  d.writeBytes(e);
  d.writeInt(f);
  e="lisi    ";
  f=22;
  d.writeBytes(e);
  d.writeInt(f);
  e="wangwu  ";
  f=20;
  d.writeBytes(e);
  d.writeInt(f);
  d.close();
}
