public static void main(String[] a){
  Process b=null;
  try {
    StringBuffer c=new StringBuffer("");
    c.append("exp scott/tiger@ORCL           ");
    c.append("file=E:\\backup\\export.dmp    ");
    c.append("log=E:\\backup\\export.log     ");
    b=Runtime.getRuntime().exec(c.toString());
    InputStreamReader d=new InputStreamReader(b.getErrorStream());
    BufferedReader e=new BufferedReader(d);
    String f;
    while ((f=e.readLine()) != null) {
      System.out.println(f);
    }
  }
 catch (  IOException g) {
    if (b != null) {
      b.destroy();
    }
    return;
  }
}
