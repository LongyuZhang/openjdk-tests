public static void fn_A(File a){
  if (a != null && a.exists()) {
    if (a.isFile()) {
      a.delete();
    }
 else     if (a.isDirectory()) {
      File[] b=a.listFiles();
      if (b == null || b.length == 0) {
        a.delete();
        return;
      }
      for (int c=0; c < b.length; c++) {
        fn_A(b[c]);
      }
      a.delete();
    }
  }
}
