public static void append(StringBuilder a,Iterator<String> b,String c){
  boolean d=true;
  while (b.hasNext()) {
    if (!d) {
      a.append(c);
    }
    a.append(b.next());
    d=false;
  }
}
