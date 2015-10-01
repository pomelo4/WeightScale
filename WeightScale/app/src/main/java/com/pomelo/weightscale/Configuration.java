package com.pomelo.weightscale;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Configuration {

    public static final String CONFIG_FIRST_START = "isFirstStart";

    private static SharedPreferences mSharedPreferences;

    public static void initialize(Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static boolean isFirstStart() {
        return mSharedPreferences.getBoolean(CONFIG_FIRST_START, true);
    }
}
