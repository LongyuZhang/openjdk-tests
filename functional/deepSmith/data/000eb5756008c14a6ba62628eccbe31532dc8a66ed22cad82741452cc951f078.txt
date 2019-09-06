public static void fn_A(float[] a,int b,float c,float d,float e,float f){
  float g=1.0f / (float)Math.tan(c * (Math.PI / 360.0));
  float h=1.0f / (e - f);
  a[b + 0]=g / d;
  a[b + 1]=0.0f;
  a[b + 2]=0.0f;
  a[b + 3]=0.0f;
  a[b + 4]=0.0f;
  a[b + 5]=g;
  a[b + 6]=0.0f;
  a[b + 7]=0.0f;
  a[b + 8]=0.0f;
  a[b + 9]=0.0f;
  a[b + 10]=(f + e) * h;
  a[b + 11]=-1.0f;
  a[b + 12]=0.0f;
  a[b + 13]=0.0f;
  a[b + 14]=2.0f * f * e* h;
  a[b + 15]=0.0f;
}
