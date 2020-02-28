public static void remove(StringBuffer a,String b,String c){
  int d=a.indexOf(b);
  int e=a.indexOf(c);
  a.insert(e + 1,' ');
  try {
    if (e < d) {
      a.deleteCharAt(e);
    }
 else {
      a.delete(d,e + 1);
    }
  }
 catch (  Exception f) {
    System.out.println("Line " + a + " start: "+ d+ " end: "+ e);
  }
}
