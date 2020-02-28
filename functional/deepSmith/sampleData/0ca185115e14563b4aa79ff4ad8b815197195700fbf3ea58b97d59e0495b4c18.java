private static boolean fn_A(File a){
  File b=new File(a,"gbtest");
  try {
    FileOutputStream c=new FileOutputStream(b);
    try {
      c.close();
    }
 catch (    IOException d) {
    }
    b.delete();
    return true;
  }
 catch (  FileNotFoundException e) {
    return false;
  }
}
