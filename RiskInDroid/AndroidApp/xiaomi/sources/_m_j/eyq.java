package _m_j;

import android.util.Log;
import com.facebook.common.logging.LoggingDelegate;
import com.xiaomi.smarthome.library.log.LogType;

public final class eyq implements LoggingDelegate {
    public final int getMinimumLoggingLevel() {
        return 0;
    }

    public final boolean isLoggable(int i) {
        return true;
    }

    public final void setMinimumLoggingLevel(int i) {
    }

    public final void v(String str, String str2) {
        gsy.O00000Oo(str, str2);
    }

    public final void v(String str, String str2, Throwable th) {
        gsy.O00000Oo(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void d(String str, String str2) {
        gsy.O000000o(3, str, str2);
    }

    public final void d(String str, String str2, Throwable th) {
        gsy.O00000Oo(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void i(String str, String str2) {
        gsy.O000000o(4, str, str2);
    }

    public final void i(String str, String str2, Throwable th) {
        gsy.O00000Oo(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void w(String str, String str2) {
        gsy.O00000Oo(LogType.GENERAL, str, str2);
    }

    public final void w(String str, String str2, Throwable th) {
        gsy.O00000Oo(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void e(String str, String str2) {
        gsy.O00000o0(LogType.GENERAL, str, str2);
    }

    public final void e(String str, String str2, Throwable th) {
        gsy.O00000o0(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void wtf(String str, String str2) {
        gsy.O00000o0(LogType.GENERAL, str, str2);
    }

    public final void wtf(String str, String str2, Throwable th) {
        gsy.O00000o0(LogType.GENERAL, str, O000000o(str2, th));
    }

    public final void log(int i, String str, String str2) {
        if (i < 5) {
            gsy.O000000o(i, str, str2);
        } else if (i < 6) {
            gsy.O00000Oo(LogType.GENERAL, str, str2);
        } else {
            gsy.O00000o0(LogType.GENERAL, str, str2);
        }
    }

    private static String O000000o(String str, Throwable th) {
        return str + 10 + Log.getStackTraceString(th);
    }
}
