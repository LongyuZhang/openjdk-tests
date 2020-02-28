public static void fn_A(String a,List<Integer> b){
  PrintWriter c=null;
  for (int d=0; d < b.size(); d++) {
    StringBuilder e=new StringBuilder();
    List<Integer> f=b;
    e.append(f.get(d).toString());
    e.append(" ");
    e.append("\n");
    try {
      c=new PrintWriter(new FileWriter(a,true));
    }
 catch (    IOException g) {
      g.printStackTrace();
    }
    c.write(e.toString());
    c.close();
  }
}
