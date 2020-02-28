public static String fn_A(double a){
  double b=a / 1024;
{
  }
  if (b < 1) {
    return "0K";
  }
  double c=b / 1024;
{
  }
  if (c < 1) {
    BigDecimal d=new BigDecimal(Double.toString(b));
    return d.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "K";
  }
  double e=c / 1024;
{
  }
  if (e < 1) {
    BigDecimal f=new BigDecimal(Double.toString(c));
    return f.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "M";
  }
  double g=e / 1024;
{
  }
  if (g < 1) {
    BigDecimal h=new BigDecimal(Double.toString(e));
    return h.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "GB";
  }
  BigDecimal i=new BigDecimal(g);
  return i.setScale(2,BigDecimal.ROUND_HALF_UP).toPlainString() + "TB";
}
