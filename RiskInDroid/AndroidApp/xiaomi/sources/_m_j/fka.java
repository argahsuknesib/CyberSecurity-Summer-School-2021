package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import java.util.List;

public final class fka {
    public static boolean O000000o(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
        }
    }

    public static boolean O00000Oo(Context context) {
        ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
        if (Build.VERSION.SDK_INT < 21) {
            String packageName = context.getPackageName();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next.processName.startsWith(packageName) && (next.importance == 100 || next.importance == 200)) {
                    gsy.O000000o(6, "CommonUtils", "Process:" + next.processName);
                    return true;
                }
            }
            return false;
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses2 = activityManager.getRunningAppProcesses();
        if (activityManager.getRunningTasks(1).size() == 0 || activityManager.getRunningTasks(1).get(0) == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next2 : runningAppProcesses2) {
            if (next2.processName.equals("com.xiaomi.smarthome")) {
                try {
                    if (((Integer) ActivityManager.RunningAppProcessInfo.class.getField("processState").get(next2)).intValue() == 6) {
                        return true;
                    }
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return false;
    }
}
