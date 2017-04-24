# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in C:\Users\Administrator\AppData\Local\Android\Sdk/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}
#（声明lib文件）-libraryjars .jar
 #（不提示警告）-dontwarn com.xx.bbb.
 #（不进行混淆）-keep class com.xx.bbb.** { *;}

-keep class com.app.src.main.java.MainActivity {
   *;
}
 # support.v7
 -dontwarn android.support.v7.**
 -keep class android.support.v7.** { *; }
 -keep interface android.support.v7.** { *; }

 # support.v4
 -dontwarn android.support.v4.**
 -keep class android.support.v4.** { *; }
 -keep public class * extends android.support.v4.**
 -keep public class * extends android.app.Fragment

## ----------------------------------
##   ########## ButterKnife ##########
## ----------------------------------
-keep class butterknife.** { *; }
-dontwarn butterknife.internal.**
-keep class **$$ViewBinder { *; }

-keepclasseswithmembernames class * {
    @butterknife.* <fields>;
}

-keepclasseswithmembernames class * {
    @butterknife.* <methods>;
}

# Platform calls Class.forName on types which do not exist on Android to determine platform.
-dontnote retrofit2.Platform
# Platform used when running on RoboVM on iOS. Will not be used at runtime.
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
# Platform used when running on Java 8 VMs. Will not be used at runtime.
-dontwarn retrofit2.Platform$Java8
# Retain generic type information for use by reflection by converters and adapters.
-keepattributes Signature
# Retain declared checked exceptions for use by a Proxy instance.
-keepattributes Exceptions

# Retrofit
-dontnote retrofit2.Platform
-dontnote retrofit2.Platform$IOS$MainThreadExecutor
-dontwarn retrofit2.Platform$Java8
-keepattributes Signature
-keepattributes Exceptions
# okhttp
-dontwarn okio.**
# Gson
-keep class com.example.testing.retrofitdemo.bean.**{*;} # 自定义数据模型的bean目录

#不混淆第三方jar包中的类
-keep class com.bigkoo.pickerview.lib.WheelView.** {*;}

-dontwarn com.pickerview.**
-keep class com.pickerview.** {*;}