package com.example.githhubdemo.utils;

import android.content.Context;
import android.content.SharedPreferences;

//SharedPreferences manager class
public class SharedPrefsUtilsModule {

    public static String TAG="SharedPrefs";

    //// TODO: 2020-07-09 for rate dialog
    public static String reviewed_dialog="reviewedDialog";

    // TODO: SharedPreferences file name
    private static String SHARED_PREFS_FILE_NAME = "REALME_23";

    // TODO: use for getting current device id
    public static final String DEVICE_ID = "device_id";

    public static final String KEY_SAVE_IMEI = "save_imei";
    public static final String KEY_SAVE_EMAIL = "save_email";
    public static final String KEY_SAVE_TC = "save_terms";


    private static SharedPreferences getPrefs(Context context) {
        return context.getSharedPreferences(SHARED_PREFS_FILE_NAME, Context.MODE_PRIVATE);
    }

    public static boolean contain(Context context, String key) {
        return getPrefs(context).contains(key);
    }

    public static void clearPrefs(Context context) {
        String device_id = getString(context, DEVICE_ID);
        getPrefs(context).edit().clear().commit();
        save(context, DEVICE_ID, device_id);
    }

    //Save Booleans
    public static void savePref(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).commit();
    }

    //Get Booleans
    public static boolean getBoolean(Context context, String key) {
        return getPrefs(context).getBoolean(key, false);
    }

    //Get Booleans if not found return activity_new_video_cutter predefined default value
    public static boolean getBoolean(Context context, String key, boolean defaultValue) {
        return getPrefs(context).getBoolean(key, defaultValue);
    }

    //Strings
    public static void save(Context context, String key, String value) {
        getPrefs(context).edit().putString(key, value).commit();
    }

    public static String getString(Context context, String key) {
        return getPrefs(context).getString(key, "");
    }

    public static String getString(Context context, String key, String defaultValue) {
        return getPrefs(context).getString(key, defaultValue);
    }

    //Integers
    public static void save(Context context, String key, int value) {
        getPrefs(context).edit().putInt(key, value).commit();
    }

    public static int getInt(Context context, String key) {
        return getPrefs(context).getInt(key, 0);
    }

    public static int getInt(Context context, String key, int defaultValue) {
        return getPrefs(context).getInt(key, defaultValue);
    }

    //Floats
    public static void save(Context context, String key, float value) {
        getPrefs(context).edit().putFloat(key, value).commit();
    }

    public static float getFloat(Context context, String key) {
        return getPrefs(context).getFloat(key, 0);
    }

    public static float getFloat(Context context, String key, float defaultValue) {
        return getPrefs(context).getFloat(key, defaultValue);
    }

    //Longs
    public static void save(Context context, String key, long value) {
        getPrefs(context).edit().putLong(key, value).commit();
    }
    public static void save(Context context, String key, boolean value) {
        getPrefs(context).edit().putBoolean(key, value).commit();
    }

    public static long getLong(Context context, String key) {
        return getPrefs(context).getLong(key, 0);
    }

    public static long getLong(Context context, String key, long defaultValue) {
        return getPrefs(context).getLong(key, defaultValue);
    }

    public static void removeKey(Context context, String key) {
        getPrefs(context).edit().remove(key).commit();
    }



}