public static String fn_A(String a){
  char b[]=a.toLowerCase().toCharArray();
  int c=0;
  String d="";
  char e='\0';
  for (  char f : b) {
    if ((int)f >= 97 & (int)f <= 122) {
      if (c % 5 == 0 & c != 0) {
        d=d + " ";
      }
      e=(char)(122 - (f - 97));
      d=d + e;
      c++;
    }
 else     if ((int)f >= 48 & (int)f <= 57) {
      d=d + f;
      c++;
    }
  }
  return d;
}
