public static int[] fn_A(int[] a,int b){
  PriorityQueue<Integer> c=new PriorityQueue<>();
  for (int d=0; d <= Math.min(b,a.length - 1); d++) {
    c.offer(a[d]);
  }
  for (int e=0; e < a.length; e++) {
    if (e + b + 1 < a.length) {
      c.offer(a[e]);
    }
    a[e]=c.poll();
  }
  return a;
}
