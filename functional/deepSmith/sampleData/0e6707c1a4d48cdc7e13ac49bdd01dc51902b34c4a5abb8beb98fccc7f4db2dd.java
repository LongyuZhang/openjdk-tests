private static List<String> fn_A(int a){
  List<String> b=new ArrayList<String>();
  if (a < 9) {
    b.add("/system/framework/core.jar");
    b.add("/system/framework/ext.jar");
    b.add("/system/framework/framework.jar");
    b.add("/system/framework/android.policy.jar");
    b.add("/system/framework/services.jar");
  }
 else   if (a < 12) {
    b.add("/system/framework/core.jar");
    b.add("/system/framework/bouncycastle.jar");
    b.add("/system/framework/ext.jar");
    b.add("/system/framework/framework.jar");
    b.add("/system/framework/android.policy.jar");
    b.add("/system/framework/services.jar");
    b.add("/system/framework/core-junit.jar");
  }
 else   if (a < 14) {
    b.add("/system/framework/core.jar");
    b.add("/system/framework/apache-xml.jar");
    b.add("/system/framework/bouncycastle.jar");
    b.add("/system/framework/ext.jar");
    b.add("/system/framework/framework.jar");
    b.add("/system/framework/android.policy.jar");
    b.add("/system/framework/services.jar");
    b.add("/system/framework/core-junit.jar");
  }
 else   if (a < 16) {
    b.add("/system/framework/core.jar");
    b.add("/system/framework/core-junit.jar");
    b.add("/system/framework/bouncycastle.jar");
    b.add("/system/framework/ext.jar");
    b.add("/system/framework/framework.jar");
    b.add("/system/framework/android.policy.jar");
    b.add("/system/framework/services.jar");
    b.add("/system/framework/apache-xml.jar");
    b.add("/system/framework/filterfw.jar");
  }
 else {
    b.add("/system/framework/core.jar");
    b.add("/system/framework/core-junit.jar");
    b.add("/system/framework/bouncycastle.jar");
    b.add("/system/framework/ext.jar");
    b.add("/system/framework/framework.jar");
    b.add("/system/framework/telephony-common.jar");
    b.add("/system/framework/mms-common.jar");
    b.add("/system/framework/android.policy.jar");
    b.add("/system/framework/services.jar");
    b.add("/system/framework/apache-xml.jar");
  }
  return b;
}
