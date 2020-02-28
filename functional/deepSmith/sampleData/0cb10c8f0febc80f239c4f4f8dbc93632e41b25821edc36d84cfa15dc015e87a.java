public static Double fn_A(Object a,Double b){
  if (a != null) {
    if (a instanceof Double) {
      return (Double)a;
    }
 else     if (a instanceof Float) {
      return ((Float)a).doubleValue();
    }
 else     if (a instanceof Number) {
      return ((Number)a).doubleValue();
    }
 else     if (a instanceof Boolean) {
      return (Boolean)a ? 1d : 0d;
    }
 else     if (a instanceof Date) {
      return ((Date)a).getTime() * 1.0;
    }
 else {
      try {
        return new Double(a.toString());
      }
 catch (      Exception c) {
        return b;
      }
    }
  }
 else {
    return b;
  }
}
