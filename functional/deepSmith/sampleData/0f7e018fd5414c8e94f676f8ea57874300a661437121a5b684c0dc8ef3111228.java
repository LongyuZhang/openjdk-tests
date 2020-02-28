public static BigDecimal fn_A(String a) throws NumberFormatException {
  if (a == null) {
    return null;
  }
  a=a.trim();
  a=a.replaceAll(",","");
  if (a.length() < 1) {
    return null;
  }
  return new BigDecimal(a);
}
