package com.sdu.didi.uuid;

import android.content.Context;
import android.text.TextUtils;
import java.util.Locale;

public class SigLib {
    static {
        try {
            System.loadLibrary("didi_secure");
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
        }
    }

    private static native String generateAddress(Context context);

    private static native String generateParam(Context context, int[] iArr);

    private static native String generateParam1(Context context, int[] iArr);

    private static native String generateParam2(Context context, int[] iArr);

    private static native String generateSig(Context context, String str);

    static String getAddress(Context context) {
        try {
            return generateAddress(context);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getParam(Context context, int[] iArr) {
        try {
            return generateParam(context, iArr);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getParam1(Context context, int[] iArr) {
        try {
            return generateParam1(context, iArr);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getParam2(Context context, int[] iArr) {
        try {
            return generateParam2(context, iArr);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getSig(Context context, String str) {
        String str2;
        if (str.length() >= 2048) {
            str = str.substring(0, 2048);
        }
        try {
            str2 = generateSig(context, str);
        } catch (UnsatisfiedLinkError e) {
            e.printStackTrace();
            str2 = null;
        }
        if (!TextUtils.isEmpty(str2)) {
            return str2.toLowerCase(Locale.ENGLISH);
        }
        return null;
    }
}
