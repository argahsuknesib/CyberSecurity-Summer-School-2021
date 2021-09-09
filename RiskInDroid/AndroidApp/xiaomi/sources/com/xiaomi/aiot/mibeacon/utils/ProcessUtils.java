package com.xiaomi.aiot.mibeacon.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.List;

public class ProcessUtils {
    Context mContext;

    public ProcessUtils(Context context) {
        this.mContext = context;
    }

    public String getProcessName() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) this.mContext.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == getPid()) {
                return next.processName;
            }
        }
        return null;
    }

    public String getPackageName() {
        return this.mContext.getApplicationContext().getPackageName();
    }

    public int getPid() {
        return Process.myPid();
    }

    public boolean isMainProcess() {
        return getPackageName().equals(getProcessName());
    }
}
