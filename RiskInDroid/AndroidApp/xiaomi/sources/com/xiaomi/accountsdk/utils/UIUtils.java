package com.xiaomi.accountsdk.utils;

import android.content.Context;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class UIUtils {
    private UIUtils() {
    }

    public static boolean isDarkMode(Context context) {
        return context.getResources().getConfiguration().uiMode == 32;
    }

    private static void setWebSettingsForceDark(WebSettings webSettings, int i) {
        try {
            webSettings.getClass().getMethod("setForceDark", Integer.TYPE).invoke(webSettings, Integer.valueOf(i));
        } catch (Exception e) {
            AccountLog.e("UIUtils", "setWebSettingsForceDark reflect error", e);
        }
    }

    public static void adaptForceDarkInApi29(Context context, WebView webView) {
        if (webView != null) {
            WebSettings settings = webView.getSettings();
            if (Build.VERSION.SDK_INT < 29) {
                return;
            }
            if (isSystemNightMode(context)) {
                setWebSettingsForceDark(settings, 2);
            } else {
                setWebSettingsForceDark(settings, 1);
            }
        } else {
            throw new IllegalArgumentException("param webView shouldn't be null!");
        }
    }

    private static boolean isSystemNightMode(Context context) {
        return (context.getResources().getConfiguration().uiMode & 48) == 32;
    }
}
