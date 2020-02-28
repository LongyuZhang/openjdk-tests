public static void main(String[] a){
  Scanner b=new Scanner(System.in);
  int c=b.nextInt();
  boolean d=false;
  while (!d) {
    int e=0;
    for (int f=2; f <= 10; f++) {
      Vector<Integer> g=new Vector<>();
      int h=c;
      boolean i=true;
      g.add(h % f);
      while (h / f != 0) {
        h/=f;
        g.add(h % f);
      }
      for (int j=0; j < g.size() / 2; j++) {
        if (g.get(j) != g.get(g.size() - 1 - j)) {
          i=false;
          break;
        }
      }
      if (i) {
        e++;
      }
    }
    if (e >= 2) {
      System.out.printf("%d",c);
      d=!d;
    }
    c++;
  }
}
