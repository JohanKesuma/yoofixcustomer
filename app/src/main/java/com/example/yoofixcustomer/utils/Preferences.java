package com.example.yoofixcustomer.utils;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.preference.PreferenceManager;

public class Preferences {
    private static final String KEY_IS_DB_INITIATED = "is_db_initated";

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setDbInitiated(Context context, boolean isInitiated) {
        SharedPreferences.Editor editor = getSharedPreference(context).edit();
        editor.putBoolean(KEY_IS_DB_INITIATED, isInitiated);
        editor.apply();
    }

    public static boolean getDbInitiated(Context context) {
        return getSharedPreference(context).getBoolean(KEY_IS_DB_INITIATED, false);
    }
}
