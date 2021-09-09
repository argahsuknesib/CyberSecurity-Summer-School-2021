package _m_j;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import com.xiaomi.smarthome.application.CommonApplication;
import java.util.List;

public final class fvc {
    public static boolean O000000o() {
        List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) CommonApplication.getAppContext().getSystemService("activity")).getRunningTasks(50);
        Class O00000Oo = cub.O00000Oo(Activity.class, "com.xiaomi.smarthome.SmartHomeMainActivity");
        if (O00000Oo != null) {
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.baseActivity.equals(new ComponentName(CommonApplication.getAppContext().getPackageName(), O00000Oo.getName()))) {
                    return true;
                }
            }
        }
        return false;
    }
}
