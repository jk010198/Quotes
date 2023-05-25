# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
-keep class com.infotechworld.offlinequotes.model.** {*;}

-keep class com.infotechworld.offlinequotes.screens.** {*;}

-keep class com.infotechworld.offlinequotes.MainActivity

-keep class com.infotechworld.offlinequotes.ui.theme.** {*;}

##---------------Begin: proguard configuration for Gson  ----------
# Gson uses generic type information stored in a class file when working with fields. Proguard
# removes such information by default, so configure it to keep all of it.
-keepattributes Signature

# For using GSON @Expose annotation
-keepattributes *Annotation*

# Gson specific classes
-dontwarn sun.misc.**
#-keep class com.google.gson.stream.** { *; }

# Application classes that will be serialized/deserialized over Gson
-keep class com.google.gson.examples.android.model.** { <fields>; }

# Prevent proguard from stripping interface information from TypeAdapter, TypeAdapterFactory,
# JsonSerializer, JsonDeserializer instances (so they can be used in @JsonAdapter)
-keep class * extends com.google.gson.TypeAdapter
-keep class * implements com.google.gson.TypeAdapterFactory
-keep class * implements com.google.gson.JsonSerializer
-keep class * implements com.google.gson.JsonDeserializer

# Prevent R8 from leaving Data object members always null
-keepclassmembers,allowobfuscation class * {
  @com.google.gson.annotations.SerializedName <fields>;
}

# Retain generic signatures of TypeToken and its subclasses with R8 version 3.0 and higher.
-keep,allowobfuscation,allowshrinking class com.google.gson.reflect.TypeToken
-keep,allowobfuscation,allowshrinking class * extends com.google.gson.reflect.TypeToken

##---------------End: proguard configuration for Gson  ----------

-dontobfuscate

####################################################################################################
# Sentry
####################################################################################################

# Recommended config via https://docs.sentry.io/clients/java/modules/android/#manual-integration
# Since we don't obfuscate, we don't need to use their Gradle plugin to upload ProGuard mappings.
-keepattributes LineNumberTable,SourceFile
-dontwarn org.slf4j.**
-dontwarn javax.**

# Our addition: this class is saved to disk via Serializable, which ProGuard doesn't like.
# If we exclude this, upload silently fails (Sentry swallows a NPE so we don't crash).
# I filed https://github.com/getsentry/sentry-java/issues/572
#
# If Sentry ever mysteriously stops working after we upgrade it, this could be why.
#-keep class io.sentry.event.Event { *; }

####################################################################################################
# Android and GeckoView built-ins
####################################################################################################

-dontwarn android.**
-dontwarn androidx.**
-dontwarn com.google.**

# Raptor now writes a *-config.yaml file to specify Gecko runtime settings (e.g. the profile dir). This
# file gets deserialized into a DebugConfig object, which is why we need to keep this class
# and its members.
#-keep class org.mozilla.gecko.util.DebugConfig { *; }

####################################################################################################
# Force removal of slow Dispatchers.Main ServiceLoader
#
# Please remove these rules when Android Gradle Plugin 3.6+ & coroutines 1.3.0+ are both in use
####################################################################################################
# Ensure the custom, fast service loader implementation is removed.

# Allow R8 to optimize away the FastServiceLoader.
# Together with ServiceLoader optimization in R8
# this results in direct instantiation when loading Dispatchers.Main


####################################################################################################
# Mozilla Application Services
####################################################################################################

#-keep class mozilla.appservices.** { *; }

####################################################################################################
# ViewModels
####################################################################################################

####################################################################################################
# Adjust
####################################################################################################


# Keep motionlayout internal methods
# https://github.com/mozilla-mobile/fenix/issues/2094
#-keep class androidx.constraintlayout.** { *; }

# Keep adjust relevant classes
#-keep class com.adjust.sdk.** { *; }



# Keep Android Lifecycle methods
# https://bugzilla.mozilla.org/show_bug.cgi?id=1596302
