package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class cde {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13653O000000o;
    private static ExecutorService O00000Oo = Executors.newSingleThreadExecutor();

    public static int O000000o(Context context, String str) {
        if (context == null) {
            return 0;
        }
        return context.getSharedPreferences(O000000o(context), 0).getInt(str, 0);
    }

    public static long O000000o(Context context, String str, long j) {
        if (context == null) {
            return j;
        }
        return context.getSharedPreferences(O000000o(context), 0).getLong(str, j);
    }

    public static String O000000o(Context context, String str, String str2) {
        if (context == null) {
            return str2;
        }
        return context.getSharedPreferences(O000000o(context), 0).getString(str, str2);
    }

    public static boolean O00000Oo(Context context, String str) {
        if (context == null) {
            return false;
        }
        return context.getSharedPreferences(O000000o(context), 0).getBoolean(str, false);
    }

    public static void O000000o(Context context, String str, int i) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(O000000o(context), 0).edit();
            edit.putInt(str, i);
            O000000o(edit);
        }
    }

    public static void O00000Oo(Context context, String str, long j) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(O000000o(context), 0).edit();
            edit.putLong(str, j);
            O000000o(edit);
        }
    }

    public static void O00000Oo(Context context, String str, String str2) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(O000000o(context), 0).edit();
            edit.putString(str, str2);
            O000000o(edit);
        }
    }

    public static void O000000o(Context context, String str, boolean z) {
        if (context != null) {
            SharedPreferences.Editor edit = context.getSharedPreferences(O000000o(context), 0).edit();
            edit.putBoolean(str, z);
            O000000o(edit);
        }
    }

    private static void O000000o(final SharedPreferences.Editor editor) {
        O00000Oo.execute(new Runnable() {
            /* class _m_j.cde.AnonymousClass1 */

            public final void run() {
                editor.commit();
            }
        });
    }

    private static String O000000o(Context context) {
        if (!TextUtils.isEmpty(f13653O000000o)) {
            return f13653O000000o;
        }
        if (context == null) {
            return f13653O000000o;
        }
        String O00000Oo2 = O00000Oo(context);
        if (TextUtils.equals(O00000Oo2, context.getPackageName())) {
            f13653O000000o = "mistat";
        } else {
            f13653O000000o = "mistat" + ccz.O000000o(O00000Oo2);
        }
        return f13653O000000o;
    }

    private static String O00000Oo(Context context) {
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || activityManager.getRunningAppProcesses() == null) {
                return "";
            }
            for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
                if (next.pid == Process.myPid()) {
                    return next.processName;
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }
}
