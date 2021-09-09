package com.mi.multimonitor;

import _m_j.ccz;
import android.app.ActivityManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PrefPersistUtils {
    private static ExecutorService mThreadPool = Executors.newSingleThreadExecutor();
    public static String prefName;

    public static int getInt(Context context, String str, int i) {
        return context.getSharedPreferences(getPrefName(context), 0).getInt(str, i);
    }

    public static long getLong(Context context, String str, long j) {
        return context.getSharedPreferences(getPrefName(context), 0).getLong(str, j);
    }

    public static String getString(Context context, String str, String str2) {
        return context.getSharedPreferences(getPrefName(context), 0).getString(str, str2);
    }

    public static boolean getBoolean(Context context, String str) {
        return context.getSharedPreferences(getPrefName(context), 0).getBoolean(str, false);
    }

    public static void putInt(Context context, String str, int i) {
        SharedPreferences.Editor edit = context.getSharedPreferences(getPrefName(context), 0).edit();
        edit.putInt(str, i);
        commit(edit);
    }

    public static void putLong(Context context, String str, long j) {
        SharedPreferences.Editor edit = context.getSharedPreferences(getPrefName(context), 0).edit();
        edit.putLong(str, j);
        commit(edit);
    }

    public static void putString(Context context, String str, String str2) {
        SharedPreferences.Editor edit = context.getSharedPreferences(getPrefName(context), 0).edit();
        edit.putString(str, str2);
        commit(edit);
    }

    public static void putBoolean(Context context, String str, boolean z) {
        SharedPreferences.Editor edit = context.getSharedPreferences(getPrefName(context), 0).edit();
        edit.putBoolean(str, z);
        commit(edit);
    }

    private static void commit(final SharedPreferences.Editor editor) {
        mThreadPool.execute(new Runnable() {
            /* class com.mi.multimonitor.PrefPersistUtils.AnonymousClass1 */

            public final void run() {
                editor.commit();
            }
        });
    }

    public static boolean hasKey(Context context, String str) {
        return context.getSharedPreferences(getPrefName(context), 0).contains(str);
    }

    public static boolean removeKey(Context context, String str) {
        return context.getSharedPreferences(getPrefName(context), 0).edit().remove(str).commit();
    }

    public static String getPrefName(Context context) {
        if (!TextUtils.isEmpty(prefName)) {
            return prefName;
        }
        String processName = getProcessName(context);
        if (TextUtils.equals(processName, context.getPackageName())) {
            prefName = "mistat";
        } else {
            prefName = "mistat" + ccz.O000000o(processName);
        }
        return prefName;
    }

    private static String getProcessName(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (activityManager.getRunningAppProcesses() == null) {
            return "";
        }
        for (ActivityManager.RunningAppProcessInfo next : activityManager.getRunningAppProcesses()) {
            if (next.pid == Process.myPid()) {
                return next.processName;
            }
        }
        return "";
    }

    public static void clear(Context context) {
        context.getSharedPreferences(getPrefName(context), 0).edit().clear().commit();
    }
}
