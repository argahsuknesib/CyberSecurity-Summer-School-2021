package com.xiaomi.mico.common.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DisplayUtils {
    public static int dip2px(Activity activity, float f) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((f * displayMetrics.density) + 0.5f);
    }

    public static int dip2px(Context context, float f) {
        if (context != null) {
            return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int px2dip(Activity activity, float f) {
        if (activity == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return (int) ((f / displayMetrics.density) + 0.5f);
    }

    public static int px2dip(Context context, float f) {
        if (context != null) {
            return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
        }
        return 0;
    }

    public static int getScreenWidthPixels(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int getScreenHeightPixels(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float getScreenDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static boolean isAllScreenDevice(Context context) {
        WindowManager windowManager;
        float f;
        int i;
        if (Build.VERSION.SDK_INT < 21 || (windowManager = (WindowManager) context.getSystemService("window")) == null) {
            return false;
        }
        Display defaultDisplay = windowManager.getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        if (point.x < point.y) {
            f = (float) point.x;
            i = point.y;
        } else {
            f = (float) point.y;
            i = point.x;
        }
        if (((float) i) / f >= 1.97f) {
            return true;
        }
        return false;
    }
}
