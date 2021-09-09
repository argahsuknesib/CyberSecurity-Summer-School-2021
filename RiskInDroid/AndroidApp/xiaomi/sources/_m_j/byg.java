package _m_j;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Process;
import java.util.Iterator;
import java.util.List;

public final class byg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile String f13406O000000o;
    private static final Object O00000Oo = new Object();

    public static String O000000o() {
        String str;
        if (f13406O000000o != null) {
            return f13406O000000o;
        }
        synchronized (O00000Oo) {
            if (f13406O000000o != null) {
                String str2 = f13406O000000o;
                return str2;
            }
            bxw.O00000Oo();
            Context O00000oo = bxv.O00000oo();
            int myPid = Process.myPid();
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) O00000oo.getSystemService("activity")).getRunningAppProcesses();
            if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next != null && next.pid == myPid) {
                        str = next.processName;
                        break;
                    }
                }
            }
            str = null;
            f13406O000000o = str;
            return str;
        }
    }
}
