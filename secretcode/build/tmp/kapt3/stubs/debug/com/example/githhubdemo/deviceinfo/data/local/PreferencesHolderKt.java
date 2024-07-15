package com.example.githhubdemo.deviceinfo.data.local;

import android.content.SharedPreferences;
import kotlin.properties.ReadWriteProperty;
import kotlin.reflect.KProperty;

@kotlin.Metadata(mv = {1, 8, 0}, k = 2, xi = 48, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\"\n\u0000\u001a\"\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0003\u001aE\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\b0\u0001\"\u000e\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\t2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000b\u00a2\u0006\u0002\u0010\f\u001a\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000e0\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u000e\u001a\"\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00100\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0010\u001a\"\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00120\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0012\u001a,\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00050\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u001a.\u0010\u0015\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00160\u00012\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016\u00a8\u0006\u0017"}, d2 = {"booleanPreference", "Lkotlin/properties/ReadWriteProperty;", "Lcom/example/githhubdemo/deviceinfo/data/local/PreferencesHolder;", "", "key", "", "default", "enumPreference", "E", "", "values", "", "(Ljava/lang/String;Ljava/lang/Enum;[Ljava/lang/Enum;)Lkotlin/properties/ReadWriteProperty;", "floatPreference", "", "intPreference", "", "longPreference", "", "stringPreference", "persistDefaultIfNotExists", "stringSetPreference", "", "app_debug"})
public final class PreferencesHolderKt {
    
    /**
     * Property delegate for getting and setting a boolean shared preference.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    val isTelemetryOn by booleanPreference("telemetry", default = false)
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.lang.Boolean> booleanPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, boolean p1_772401952) {
        return null;
    }
    
    /**
     * Property delegate for getting and setting a float number shared preference.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    var percentage by floatPreference("percentage", default = 0f)
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.lang.Float> floatPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, float p1_772401952) {
        return null;
    }
    
    /**
     * Property delegate for getting and setting an int number shared preference.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    var widgetNumInvocations by intPreference("widget_number_of_invocations", default = 0)
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.lang.Integer> intPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, int p1_772401952) {
        return null;
    }
    
    /**
     * Property delegate for getting and setting a long number shared preference.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    val appInstanceId by longPreference("app_instance_id", default = 123456789L)
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.lang.Long> longPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, long p1_772401952) {
        return null;
    }
    
    /**
     * Property delegate for getting and setting a string shared preference.
     * Optionally this will persist the default value if one is not already persisted.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    var permissionsEnabledEnum by stringPreference(
     *         "permissions_enabled",
     *         default = "blocked",
     *         persistDefaultIfNotExists = true,
     *    )
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.lang.String> stringPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.lang.String p1_772401952, boolean persistDefaultIfNotExists) {
        return null;
    }
    
    /**
     * Property delegate for getting and setting a string set shared preference.
     *
     * Example usage:
     * ```
     * class Settings : PreferenceHolder {
     *    ...
     *    var connectedDevices by stringSetPreference("connected_devices", default = emptySet())
     * }
     * ```
     */
    @org.jetbrains.annotations.NotNull
    public static final kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, java.util.Set<java.lang.String>> stringSetPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    java.util.Set<java.lang.String> p1_772401952) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull
    public static final <E extends java.lang.Enum<E>>kotlin.properties.ReadWriteProperty<com.example.githhubdemo.deviceinfo.data.local.PreferencesHolder, E> enumPreference(@org.jetbrains.annotations.NotNull
    java.lang.String key, @org.jetbrains.annotations.NotNull
    E p1_772401952, @org.jetbrains.annotations.NotNull
    E[] values) {
        return null;
    }
}