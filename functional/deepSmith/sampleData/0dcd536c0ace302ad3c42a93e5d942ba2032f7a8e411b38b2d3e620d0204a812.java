public static Date fn_A(int a){
  int b;
  int c=1;
  Date d;
  d=new Date(a,c,1);
  b=d.getDay();
switch (b) {
case 0:
    return new Date(a,c,16);
case 1:
  return new Date(a,c,15);
case 2:
return new Date(a,c,21);
case 3:
return new Date(a,c,20);
case 4:
return new Date(a,c,19);
case 5:
return new Date(a,c,18);
default :
return new Date(a,c,17);
}
}
