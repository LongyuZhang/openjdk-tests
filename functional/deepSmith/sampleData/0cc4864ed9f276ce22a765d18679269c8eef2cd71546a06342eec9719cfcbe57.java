public static void main(String[] a){
  File b=new File("/home/adminuser/Documents/me.txt");
  if (b.exists()) {
    System.out.println("File is there.");
  }
 else {
    System.out.println("File absent.");
  }
  FileReader c=null;
  BufferedReader d=null;
  try {
    c=new FileReader(b);
    d=new BufferedReader(c);
    String e;
    while ((e=d.readLine()) != null) {
      System.out.println(e);
    }
  }
 catch (  FileNotFoundException f) {
    System.out.println(f);
  }
catch (  IOException g) {
    System.out.println(g);
  }
 finally {
    try {
      c.close();
      d.close();
    }
 catch (    IOException h) {
    }
  }
}
