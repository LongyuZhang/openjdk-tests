public static String fn_A(String a,boolean b){
  if (b) {
    return "(java.lang.Boolean) org.apache.jasper.runtime.JspRuntimeLibrary.coerce(" + a + ", java.lang.Boolean.class)";
  }
 else {
    if (a == null || a.length() == 0) {
      return "new java.lang.Boolean(false)";
    }
 else {
      return "new java.lang.Boolean(" + Boolean.valueOf(a).toString() + ")";
    }
  }
}
