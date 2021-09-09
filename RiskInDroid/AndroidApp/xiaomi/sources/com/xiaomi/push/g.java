package com.xiaomi.push;

import _m_j.duv;
import _m_j.emg;
import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.AppOpsManager;
import android.app.NotificationManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.List;

public final class g {

    /* JADX INFO: Failed to restore enum class, 'enum' modifier removed */
    public static final class a extends Enum<a> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f6383a = new a("UNKNOWN", 0, 0);

        /* renamed from: a  reason: collision with other field name */
        private static final /* synthetic */ a[] f40a = a();
        public static final a b = new a("ALLOWED", 1, 1);
        public static final a c = new a("NOT_ALLOWED", 2, 2);

        /* renamed from: a  reason: collision with other field name */
        private final int f41a;

        private a(String str, int i, int i2) {
            this.f41a = i2;
        }

        public static a valueOf(String str) {
            return (a) Enum.valueOf(a.class, str);
        }

        public static a[] values() {
            return (a[]) f40a.clone();
        }

        public final int a() {
            return this.f41a;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    private static a O000000o(Context context, ApplicationInfo applicationInfo) {
        int i = Build.VERSION.SDK_INT;
        if (applicationInfo == null || i < 24) {
            return a.f6383a;
        }
        Boolean bool = null;
        try {
            if (applicationInfo.packageName.equals(context.getPackageName())) {
                bool = Boolean.valueOf(((NotificationManager) context.getSystemService("notification")).areNotificationsEnabled());
            } else {
                Object O000000o2 = i >= 29 ? emg.O000000o(context.getSystemService("notification"), "getService", new Object[0]) : context.getSystemService("security");
                if (O000000o2 != null) {
                    bool = emg.O00000Oo(O000000o2, "areNotificationsEnabledForPackage", applicationInfo.packageName, Integer.valueOf(applicationInfo.uid));
                }
            }
            if (bool != null) {
                return bool.booleanValue() ? a.b : a.c;
            }
        } catch (Exception e) {
            duv.O000000o("are notifications enabled error ".concat(String.valueOf(e)));
        }
        return a.f6383a;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T
     arg types: [android.app.AppOpsManager, java.lang.String, java.lang.Object[]]
     candidates:
      _m_j.emg.O000000o(java.lang.Class<? extends java.lang.Object>, java.lang.Object, java.lang.String):T
      _m_j.emg.O000000o(java.lang.String, java.lang.String, java.lang.Object[]):T
      _m_j.emg.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.reflect.Method[], java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.emg.O000000o(java.lang.Object, java.lang.String, java.lang.Object[]):T */
    @TargetApi(19)
    public static a O000000o(Context context, String str, boolean z) {
        if (context == null || TextUtils.isEmpty(str) || Build.VERSION.SDK_INT < 19) {
            return a.f6383a;
        }
        try {
            ApplicationInfo applicationInfo = str.equals(context.getPackageName()) ? context.getApplicationInfo() : context.getPackageManager().getApplicationInfo(str, 0);
            a O000000o2 = O000000o(context, applicationInfo);
            if (O000000o2 != a.f6383a) {
                return O000000o2;
            }
            Integer num = (Integer) emg.O000000o((Class<? extends Object>) AppOpsManager.class, "OP_POST_NOTIFICATION");
            if (num == null) {
                return a.f6383a;
            }
            Integer num2 = (Integer) emg.O000000o((Object) ((AppOpsManager) context.getSystemService("appops")), "checkOpNoThrow", num, Integer.valueOf(applicationInfo.uid), str);
            int i = (Integer) emg.O000000o((Class<? extends Object>) AppOpsManager.class, "MODE_ALLOWED");
            int i2 = (Integer) emg.O000000o((Class<? extends Object>) AppOpsManager.class, "MODE_IGNORED");
            duv.O00000Oo(String.format("get app mode %s|%s|%s", num2, i, i2));
            if (i == null) {
                i = 0;
            }
            if (i2 == null) {
                i2 = 1;
            }
            if (num2 != null) {
                return z ? !num2.equals(i2) ? a.b : a.c : num2.equals(i) ? a.b : a.c;
            }
            return a.f6383a;
        } catch (Throwable th) {
            duv.O000000o("get app op error ".concat(String.valueOf(th)));
        }
    }

    public static String O000000o(Context context, int i) {
        List<ActivityManager.RunningAppProcessInfo> list;
        if (context == null) {
            return null;
        }
        try {
            list = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        } catch (Exception unused) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : list) {
            if (runningAppProcessInfo.pid == i) {
                return runningAppProcessInfo.processName;
            }
        }
        return null;
    }

    public static String O000000o(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            duv.O000000o(e);
            packageInfo = null;
        }
        return packageInfo != null ? packageInfo.versionName : "1.0";
    }

    public static boolean O000000o(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.pid == Process.myPid() && next.processName.equals(context.getPackageName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int O00000Oo(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 16384);
        } catch (Exception e) {
            duv.O000000o(e);
            packageInfo = null;
        }
        if (packageInfo != null) {
            return packageInfo.versionCode;
        }
        return 0;
    }

    public static boolean O00000o(Context context, String str) {
        PackageInfo packageInfo;
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static boolean O00000o0(Context context, String str) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (Arrays.asList(runningAppProcessInfo.pkgList).contains(str)) {
                return true;
            }
        }
        return false;
    }

    public static String O00000oO(Context context, String str) {
        ApplicationInfo applicationInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            return (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null) ? str : packageManager.getApplicationLabel(applicationInfo).toString();
        } catch (PackageManager.NameNotFoundException e) {
            duv.O000000o(e);
            return str;
        }
    }

    public static int O00000oo(Context context, String str) {
        ApplicationInfo O0000Oo0 = O0000Oo0(context, str);
        if (O0000Oo0 == null) {
            return 0;
        }
        int i = O0000Oo0.icon;
        return (i != 0 || Build.VERSION.SDK_INT < 9) ? i : O0000Oo0.logo;
    }

    public static Drawable O0000O0o(Context context, String str) {
        ApplicationInfo O0000Oo0 = O0000Oo0(context, str);
        Drawable drawable = null;
        if (O0000Oo0 != null) {
            try {
                drawable = O0000Oo0.loadIcon(context.getPackageManager());
                if (drawable == null && Build.VERSION.SDK_INT >= 9) {
                    drawable = O0000Oo0.loadLogo(context.getPackageManager());
                }
            } catch (Exception e) {
                duv.O000000o("get app icon drawable failed, ".concat(String.valueOf(e)));
            }
        }
        return drawable != null ? drawable : new ColorDrawable(0);
    }

    public static boolean O0000OOo(Context context, String str) {
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Settings.Secure.getInt(context.getContentResolver(), "freeform_window_state", -1) >= 0) {
                return str.equals(Settings.Secure.getString(context.getContentResolver(), "freeform_package_name"));
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    private static ApplicationInfo O0000Oo0(Context context, String str) {
        if (str.equals(context.getPackageName())) {
            return context.getApplicationInfo();
        }
        try {
            return context.getPackageManager().getApplicationInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            duv.O000000o("not found app info ".concat(String.valueOf(str)));
            return null;
        }
    }
}
