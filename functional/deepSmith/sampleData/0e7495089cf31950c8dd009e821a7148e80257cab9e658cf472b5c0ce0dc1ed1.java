public static boolean fn_A(String a){
  boolean b=false;
  if ((a != null) && (a.length() > 0)) {
    char c;
    for (int d=0; d <= a.length() - 1; d++) {
      c=a.charAt(d);
switch (c) {
case '>':
        b=true;
      break;
case '<':
    b=true;
  break;
case '"':
b=true;
break;
case '&':
b=true;
break;
}
}
}
return b;
}
