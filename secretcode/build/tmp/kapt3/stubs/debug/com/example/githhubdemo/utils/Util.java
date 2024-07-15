package com.example.githhubdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Patterns;
import com.example.githhubdemo.model.Setting;
import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004J\u001a\u0010\u001a\u001a\u00020\u00042\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0004J\u0012\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0004J\u0010\u0010!\u001a\u00020\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\b\u0010#\u001a\u0004\u0018\u00010\u0007J\b\u0010$\u001a\u0004\u0018\u00010\u0004J\u0018\u0010%\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u0010)\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\'J\u000e\u0010*\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\'J\u000e\u0010+\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'J\u000e\u0010,\u001a\u00020\u000e2\u0006\u0010-\u001a\u00020\'J\u000e\u0010.\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0004J\u0018\u0010/\u001a\u00020\u000e2\b\u00100\u001a\u0004\u0018\u00010\u00042\u0006\u00101\u001a\u000202J\u000e\u00103\u001a\u00020\u000e2\u0006\u0010&\u001a\u00020\'J\u0010\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u00010\u0004J\u0018\u00106\u001a\u0002072\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u0004J\u000e\u00108\u001a\u0002072\u0006\u0010&\u001a\u00020\'J\"\u00109\u001a\u0002072\u0006\u0010&\u001a\u00020\'2\b\u0010(\u001a\u0004\u0018\u00010\u00042\b\u0010:\u001a\u0004\u0018\u00010\u0004J\"\u0010;\u001a\u0002072\u0006\u0010&\u001a\u00020\'2\b\u0010<\u001a\u0004\u0018\u00010\u00042\b\u00105\u001a\u0004\u0018\u00010\u0004J\u0010\u0010=\u001a\u0002072\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007J\u0010\u0010>\u001a\u0002072\b\u0010\f\u001a\u0004\u0018\u00010\u0004J\u000e\u0010?\u001a\u0002072\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010@\u001a\u0002072\u0006\u0010A\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/example/githhubdemo/utils/Util;", "", "()V", "USER_EMAIL", "", "USER_NAME", "globalSetting", "Lcom/example/githhubdemo/model/Setting;", "getGlobalSetting$app_debug", "()Lcom/example/githhubdemo/model/Setting;", "setGlobalSetting$app_debug", "(Lcom/example/githhubdemo/model/Setting;)V", "instruction", "isShowRate", "", "()Z", "setShowRate", "(Z)V", "model", "getModel", "()Ljava/lang/String;", "preference_file_key", "secret_Key", "stripePublishableKey", "capitalize", "s", "dateToString", "date", "Ljava/util/Date;", "format", "extractExpireDate", "", "expireDate", "getDate", "dateTime", "getGlobalSetting", "getInstruction", "getSetting", "context", "Landroid/content/Context;", "key", "getUserEmail", "getUserName", "hasUser", "isNetworkConnected", "contenxt", "isNumberic", "isPackageInstalled", "packageName", "packageManager", "Landroid/content/pm/PackageManager;", "isPlayStoreInstalled", "regexEmail", "email", "removeSetting", "", "removeUser", "saveSetting", "value", "saveUser", "name", "setGlobalSetting", "setInstruction", "setSecret_Key", "setStripePublishableKey", "publishable_Key", "app_debug"})
public final class Util {
    @org.jetbrains.annotations.NotNull
    private static java.lang.String stripePublishableKey = "pk_test_DPiZCdKp1w8I2P1SBOGH3rzX";
    @org.jetbrains.annotations.NotNull
    private static java.lang.String secret_Key = "sk_test_pc9pMV5VDArJkbe5Wx4RlUV3";
    @org.jetbrains.annotations.Nullable
    private static java.lang.String instruction = "";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String preference_file_key = "preference_file_key";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String USER_NAME = "user_name";
    @org.jetbrains.annotations.NotNull
    public static final java.lang.String USER_EMAIL = "user_email";
    @org.jetbrains.annotations.Nullable
    private static com.example.githhubdemo.model.Setting globalSetting;
    private static boolean isShowRate = false;
    @org.jetbrains.annotations.NotNull
    public static final com.example.githhubdemo.utils.Util INSTANCE = null;
    
    private Util() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.githhubdemo.model.Setting getGlobalSetting$app_debug() {
        return null;
    }
    
    public final void setGlobalSetting$app_debug(@org.jetbrains.annotations.Nullable
    com.example.githhubdemo.model.Setting p0) {
    }
    
    public final boolean isShowRate() {
        return false;
    }
    
    public final void setShowRate(boolean p0) {
    }
    
    public final void setGlobalSetting(@org.jetbrains.annotations.Nullable
    com.example.githhubdemo.model.Setting s) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.example.githhubdemo.model.Setting getGlobalSetting() {
        return null;
    }
    
    public final void setSecret_Key(@org.jetbrains.annotations.NotNull
    java.lang.String secret_Key) {
    }
    
    public final void setStripePublishableKey(@org.jetbrains.annotations.NotNull
    java.lang.String publishable_Key) {
    }
    
    @org.jetbrains.annotations.Nullable
    public final java.lang.String getInstruction() {
        return null;
    }
    
    public final void setInstruction(@org.jetbrains.annotations.Nullable
    java.lang.String instruction) {
    }
    
    public final boolean isNetworkConnected(@org.jetbrains.annotations.NotNull
    android.content.Context contenxt) {
        return false;
    }
    
    public final boolean isPackageInstalled(@org.jetbrains.annotations.Nullable
    java.lang.String packageName, @org.jetbrains.annotations.NotNull
    android.content.pm.PackageManager packageManager) {
        return false;
    }
    
    public final boolean regexEmail(@org.jetbrains.annotations.Nullable
    java.lang.String email) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String capitalize(@org.jetbrains.annotations.Nullable
    java.lang.String s) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getDate(@org.jetbrains.annotations.Nullable
    java.lang.String dateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String dateToString(@org.jetbrains.annotations.Nullable
    java.util.Date date, @org.jetbrains.annotations.Nullable
    java.lang.String format) {
        return null;
    }
    
    public final boolean isNumberic(@org.jetbrains.annotations.NotNull
    java.lang.String s) {
        return false;
    }
    
    public final boolean isPlayStoreInstalled(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable
    public final int[] extractExpireDate(@org.jetbrains.annotations.Nullable
    java.lang.String expireDate) {
        return null;
    }
    
    public final void saveSetting(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String key, @org.jetbrains.annotations.Nullable
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getSetting(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String key) {
        return null;
    }
    
    public final void removeSetting(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String key) {
    }
    
    public final void saveUser(@org.jetbrains.annotations.NotNull
    android.content.Context context, @org.jetbrains.annotations.Nullable
    java.lang.String name, @org.jetbrains.annotations.Nullable
    java.lang.String email) {
    }
    
    public final boolean hasUser(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserName(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public final java.lang.String getUserEmail(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
        return null;
    }
    
    public final void removeUser(@org.jetbrains.annotations.NotNull
    android.content.Context context) {
    }
}