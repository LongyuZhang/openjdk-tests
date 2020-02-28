private static String fn_A(String a){
  StringBuilder b=new StringBuilder();
  try {
    BufferedReader c=new BufferedReader(new FileReader(a));
    String d="";
    while ((d=c.readLine()) != null) {
      b.append(d + "\n");
    }
    c.close();
  }
 catch (  IOException e) {
    e.printStackTrace();
    System.err.println("Error while opening file: " + a);
  }
  return b.toString();
}
