private static void fn_A(Vector<Integer> a){
  for (int b=0; b < a.size(); b++) {
    if (a.get(b).equals(3)) {
      a.remove(b);
    }
  }
}
