package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.smarthome.library.log.LogType;

public final class fuz {
    public static void O000000o(Throwable th) {
        try {
            String stackTraceString = Log.getStackTraceString(th);
            if (!TextUtils.isEmpty(stackTraceString)) {
                if (!stackTraceString.contains("com.tencent.bugly.")) {
                    gsy.O00000Oo(LogType.GENERAL, "MiHomeCrashReporter", stackTraceString);
                    CrashReport.O000000o(th);
                    return;
                }
            }
            gsy.O00000Oo(LogType.GENERAL, "MiHomeCrashReporter", "crash with bugly, ignore it");
        } catch (Exception unused) {
        }
    }
}
