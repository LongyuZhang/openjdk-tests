public static int hashCode(Date a){
  if (a == null) {
    return 0;
  }
  return (int)a.getTime();
}
