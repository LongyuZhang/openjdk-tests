public static void main(String[] a){
  long b=32552165;
  long c=32548512;
  long d=32575340;
  long e=32518697;
  System.out.println("sdf");
  if ((e <= c) && (d >= c) && (d <= b)) {
    BigDecimal f=new BigDecimal(d - c);
    BigDecimal g=new BigDecimal(b - c);
    if (g.compareTo(new BigDecimal(0)) == 0) {
      g=f;
    }
    g=f.divide(g,2,1);
    Double h=Double.valueOf(g.doubleValue());
    if (h.doubleValue() <= 0.9D) {
    }
  }
 else   if ((e >= c) && (e <= b) && (d >= b)) {
    BigDecimal i=new BigDecimal(b - e);
    BigDecimal j=new BigDecimal(b - c);
    if (j.compareTo(new BigDecimal(0)) == 0) {
      j=i;
    }
    j=i.divide(j,2,1);
    Double k=Double.valueOf(j.doubleValue());
    System.out.println(k);
    if (k.doubleValue() <= 0.9D) {
    }
  }
 else   if ((e >= c) && (d <= b)) {
    BigDecimal l=new BigDecimal(d - e);
    BigDecimal m=new BigDecimal(b - c);
    if (m.compareTo(new BigDecimal(0)) == 0) {
      m=l;
    }
    m=l.divide(m,2,1);
    Double n=Double.valueOf(m.doubleValue());
    System.out.println(n);
    if (n.doubleValue() <= 0.9D) {
    }
  }
 else   if ((e <= c) && (d >= b)) {
    BigDecimal o=new BigDecimal(b - c);
    BigDecimal p=new BigDecimal(b - c);
    if (p.compareTo(new BigDecimal(0)) == 0) {
      p=o;
    }
    p=o.divide(p,2,1);
    Double q=Double.valueOf(p.doubleValue());
    System.out.println(q);
    if (q.doubleValue() <= 0.9D) {
    }
  }
}
