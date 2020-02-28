public static int fn_A(String a){
  String b[]=a.trim().split("-");
  int c=Integer.parseInt(b[0]);
  int d=Integer.parseInt(b[1]);
  int e=Integer.parseInt(b[2]);
  Calendar f=Calendar.getInstance();
  int g=f.get(Calendar.YEAR);
  int h=f.get(Calendar.MONTH) + 1;
  int i=f.get(Calendar.DATE);
  int j=g - c;
  int k=h - d;
  int l=i - e;
  int m=j;
  if (j < 0) {
    m=0;
  }
 else   if (j == 0) {
    if (k < 0) {
      m=0;
    }
 else     if (k == 0) {
      if (l < 0) {
        m=0;
      }
 else       if (l >= 0) {
        m=1;
      }
    }
 else     if (k > 0) {
      m=1;
    }
  }
 else   if (j > 0) {
    if (k < 0) {
    }
 else     if (k == 0) {
      if (l < 0) {
      }
 else       if (l >= 0) {
        m=m - 1;
      }
    }
 else     if (k > 0) {
      m=m - 1;
    }
  }
  return m;
}
