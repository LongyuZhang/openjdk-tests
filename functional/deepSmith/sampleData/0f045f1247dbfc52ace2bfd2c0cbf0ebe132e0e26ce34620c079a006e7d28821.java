public static void main(String[] a) throws Exception {
  BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
  int c=Integer.parseInt(b.readLine());
  int d=Integer.parseInt(b.readLine());
  while (true) {
    int e;
    if (c > d) {
      int f=c % d;
      if (f == 0) {
        System.out.println(d);
        break;
      }
 else       if (f != 0) {
        e=f;
        f=d % f;
        d=e;
      }
    }
 else     if (d > c) {
      int g=d % c;
      if (g == 0) {
        System.out.println(c);
        break;
      }
 else       if (g != 0) {
        e=g;
        g=c % g;
        c=e;
      }
    }
  }
}
