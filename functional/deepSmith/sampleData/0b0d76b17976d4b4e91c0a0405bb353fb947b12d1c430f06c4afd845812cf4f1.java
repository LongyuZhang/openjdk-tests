public static String fn_A(ResourceBundle a,String b){
  try {
    return a.getString(b);
  }
 catch (  MissingResourceException c) {
    return '!' + b + '!';
  }
}
