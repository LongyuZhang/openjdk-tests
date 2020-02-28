public static String fn_A(SortedMap<String,Object> a){
  StringBuffer b=new StringBuffer();
  b.append("<xml>");
  Set c=a.entrySet();
  Iterator d=c.iterator();
  while (d.hasNext()) {
    Map.Entry e=(Map.Entry)d.next();
    String f=(String)e.getKey();
    String g=(String)e.getValue();
    if ("attach".equalsIgnoreCase(f) || "body".equalsIgnoreCase(f) || "sign".equalsIgnoreCase(f)) {
      b.append("<" + f + ">"+ "<![CDATA["+ g+ "]]></"+ f+ ">");
    }
 else {
      b.append("<" + f + ">"+ g+ "</"+ f+ ">");
    }
  }
  b.append("</xml>");
  return b.toString();
}
