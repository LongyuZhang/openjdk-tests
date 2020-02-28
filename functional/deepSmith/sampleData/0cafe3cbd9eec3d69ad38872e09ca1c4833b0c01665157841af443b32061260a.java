public static void main(String[] a){
  int[][] b=new int[10][20];
  int[][] c={{1,2,3},{4,5,6}};
  for (int d=0; d < c.length; d++) {
    for (int e=0; e < c[d].length; e++) {
      System.out.println("i = " + d);
      System.out.println("j = " + e);
      System.out.println("arr2[i][j] = " + c[d][e]);
    }
  }
}
