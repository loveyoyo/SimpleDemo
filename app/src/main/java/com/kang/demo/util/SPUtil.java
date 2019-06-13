package com.kang.demo.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by MockingJay on 2019/6/9;
 * Description:
 */

public class SPUtil {

    public static boolean getBoolean(Context context, String key, Boolean defValue){
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        return spf.getBoolean(key,defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        return spf.getString(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences spf = PreferenceManager.getDefaultSharedPreferences(context);
        return spf.getInt(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key,value);
        editor.apply();
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

}
