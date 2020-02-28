public static void main(String[] a){
  String b="exp scott/tiger@orcl file=D:/myeclipse/work0516/0806_OracleExp/bin/scott_tiger_20140818091505.dmp log=D:/myeclipse/work0516/0806_OracleExp/bin/scott_tiger_20140818091505.log";
  try {
    Process c=Runtime.getRuntime().exec(b);
    InputStream d=c.getErrorStream();
    InputStreamReader e=new InputStreamReader(d);
    BufferedReader f=new BufferedReader(e);
    String g=null;
    while ((g=f.readLine()) != null) {
      System.out.println(g);
    }
    int h=c.waitFor();
  }
 catch (  Exception i) {
    i.printStackTrace();
  }
 finally {
  }
}
