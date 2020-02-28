public static void fn_A(final File a,final boolean b,final FileFilter c){
  if (a != null && a.isDirectory()) {
    final File[] d=a.listFiles(c);
    if (d != null) {
      for (      final File e : d) {
        if (e.isDirectory()) {
          fn_A(e,b,c);
        }
 else {
          e.delete();
        }
      }
    }
    if (b) {
      a.delete();
    }
  }
}
