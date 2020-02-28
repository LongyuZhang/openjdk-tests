private static String fn_A(String a){
  StringBuilder b=new StringBuilder(a);
  b.append("{");
  for (int c=0; c < a.length(); ++c) {
    if (c > 0) {
      b.append(",");
    }
    b.append((int)a.charAt(c));
  }
  b.append("}");
  return b.toString();
}
