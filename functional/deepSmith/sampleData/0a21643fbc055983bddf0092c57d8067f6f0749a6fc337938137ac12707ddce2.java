private static String fn_A(InputStream a) throws IOException {
  BufferedReader b=new BufferedReader(new InputStreamReader(a));
  String c="";
  String d="";
  while ((c=b.readLine()) != null) {
    d+=c;
  }
  a.close();
  return d;
}
