package com.alipay.sdk.interior;

import android.content.Context;
import android.os.SystemClock;
import com.alipay.sdk.app.statistic.a;
import com.alipay.sdk.sys.b;
import com.alipay.sdk.util.c;

public class Log {

    /* renamed from: a  reason: collision with root package name */
    private static long f3192a;

    public interface ISdkLogCallback {
        void onLogLine(String str);
    }

    public static void setupLogCallback(ISdkLogCallback iSdkLogCallback) {
        c.a(iSdkLogCallback);
    }

    public static boolean forcedLogReport(Context context) {
        try {
            b.a().a(context);
            long elapsedRealtime = SystemClock.elapsedRealtime() / 1000;
            if (elapsedRealtime - f3192a < 600) {
                return false;
            }
            f3192a = elapsedRealtime;
            a.a(context);
            return true;
        } catch (Exception e) {
            c.a(e);
            return false;
        }
    }
}
