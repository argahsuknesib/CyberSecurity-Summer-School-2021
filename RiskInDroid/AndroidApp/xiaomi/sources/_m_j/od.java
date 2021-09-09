package _m_j;

import android.content.Context;
import android.content.pm.PackageInfo;

public final class od {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f2339O000000o;
    public static int O00000Oo;

    public static PackageInfo O000000o(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384);
        } catch (Exception unused) {
            ny.f2212O000000o.error("ARouter::", "Get package info error.");
            return null;
        }
    }
}
