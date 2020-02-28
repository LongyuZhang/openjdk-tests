public static String fn_A(final CharSequence a){
  StringBuilder b=new StringBuilder();
  char c;
  for (int d=0, e=a.length(); d < e; d++) {
    c=a.charAt(d);
switch (c) {
case '<':
      b.append("&lt;");
    break;
case '>':
  b.append("&gt;");
break;
case '&':
b.append("&amp;");
break;
case '\'':
b.append("&#39;");
break;
case '"':
b.append("&quot;");
break;
default :
b.append(c);
}
}
return b.toString();
}
