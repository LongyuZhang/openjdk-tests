private static float[] fn_A(float a,float b,float c,float d,int e,int f){
  float g;
  float h;
  float i;
  float j;
  if (b > e) {
    float k=(d - b) / (c - a);
    g=(e - b + k * a) / k;
    h=e;
    if (g < 0) {
      g=0;
      h=b - k * a;
    }
 else     if (g > f) {
      g=f;
      h=k * f + b - k * a;
    }
  }
 else   if (b < 0) {
    float l=(d - b) / (c - a);
    g=(-b + l * a) / l;
    h=0;
    if (g < 0) {
      g=0;
      h=b - l * a;
    }
 else     if (g > f) {
      g=f;
      h=l * f + b - l * a;
    }
  }
 else {
    g=a;
    h=b;
  }
  if (d > e) {
    float m=(d - b) / (c - a);
    i=(e - b + m * a) / m;
    j=e;
    if (i < 0) {
      i=0;
      j=b - m * a;
    }
 else     if (i > f) {
      i=f;
      j=m * f + b - m * a;
    }
  }
 else   if (d < 0) {
    float n=(d - b) / (c - a);
    i=(-b + n * a) / n;
    j=0;
    if (i < 0) {
      i=0;
      j=b - n * a;
    }
 else     if (i > f) {
      i=f;
      j=n * f + b - n * a;
    }
  }
 else {
    i=c;
    j=d;
  }
  return new float[]{g,h,i,j};
}
