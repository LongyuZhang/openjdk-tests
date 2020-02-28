static String fn_A(){
  StringBuilder a=new StringBuilder();
  a.append("Draw type: %t");
  a.append("|Bounding Box %x1");
  a.append("|Wireframe %x2");
  a.append("|Solid %x3");
  a.append("|Shaded %x4");
  a.append("|Textured %x5");
  return a.toString();
}
