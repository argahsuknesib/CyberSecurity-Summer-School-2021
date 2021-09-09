package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import java.util.List;

public final class flm {
    public static boolean O000000o(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equalsIgnoreCase("com.xiaomi.smarthome") && (next.importance == 100 || next.importance == 200)) {
                return true;
            }
        }
        return false;
    }
}
