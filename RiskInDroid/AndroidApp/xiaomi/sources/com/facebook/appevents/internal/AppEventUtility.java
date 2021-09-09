package com.facebook.appevents.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Looper;
import com.facebook.FacebookSdk;
import com.facebook.internal.Utility;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AppEventUtility {
    public static void assertIsMainThread() {
    }

    public static void assertIsNotMainThread() {
    }

    public static double normalizePrice(String str) {
        try {
            Matcher matcher = Pattern.compile("[-+]*\\d+([\\,\\.]\\d+)*([\\.\\,]\\d+)?", 8).matcher(str);
            if (!matcher.find()) {
                return 0.0d;
            }
            return NumberFormat.getNumberInstance(Utility.getCurrentLocale()).parse(matcher.group(0)).doubleValue();
        } catch (ParseException unused) {
            return 0.0d;
        }
    }

    public static String bytesToHex(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            stringBuffer.append(String.format("%02x", Byte.valueOf(bArr[i])));
        }
        return stringBuffer.toString();
    }

    public static boolean isEmulator() {
        if (Build.FINGERPRINT.startsWith("generic") || Build.FINGERPRINT.startsWith("unknown") || Build.MODEL.contains("google_sdk") || Build.MODEL.contains("Emulator") || Build.MODEL.contains("Android SDK built for x86") || Build.MANUFACTURER.contains("Genymotion")) {
            return true;
        }
        return (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic")) || "google_sdk".equals(Build.PRODUCT);
    }

    private static boolean isMainThread() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static String getAppVersion() {
        Context applicationContext = FacebookSdk.getApplicationContext();
        try {
            return applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }
}
