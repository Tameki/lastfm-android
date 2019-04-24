package com.geektech.core;

import android.content.Context;
import android.widget.Toast;

public class CoreUtils {
    public static void showShortToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
