package com.geektech.core;

import android.util.Log;

public class Logger {
    private static String TAG = "ololo";
    private static boolean sEnabled = true;

    public static void setEnabled(boolean enabled) {
        sEnabled = enabled;
    }

    public static void d(String message) {
        d(TAG, message);
    }

    public static void d(String tag, String message) {
        if (sEnabled) {
            Log.d(tag, message);
        }
    }
}
