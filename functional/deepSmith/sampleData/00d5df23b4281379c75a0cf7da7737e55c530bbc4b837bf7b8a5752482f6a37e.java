public static void fn_A(String a,StringBuilder b){
  if (a != null && !a.isEmpty()) {
    if (b.length() > 0) {
      b.append('\n');
    }
    b.append(a);
  }
}
