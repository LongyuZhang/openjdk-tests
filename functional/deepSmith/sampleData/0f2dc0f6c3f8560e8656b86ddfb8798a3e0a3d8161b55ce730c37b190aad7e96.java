private static Boolean fn_A(ArrayList<String> a){
  for (int b=0; b < a.size(); b++) {
    if (a.get(b) == null || a.get(b).equals("")) {
      return false;
    }
  }
  return true;
}
