private static long[] fn_A(String a){
  String[] b=a.split(",");
  long[] c=new long[b.length];
  for (int d=0; d < b.length; d++) {
    try {
      c[d]=Long.parseLong(b[d]);
    }
 catch (    Exception e) {
      c[d]=-1;
      continue;
    }
  }
  return c;
}
