package _m_j;

import com.xiaomi.smarthome.library.log.LogType;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

public final class hts {
    public static void O000000o(String str, String str2, Object... objArr) {
        if (!(objArr == null || objArr.length == 0)) {
            str2 = String.format(str2, objArr);
        }
        gsy.O00000o0(LogType.KUAILIAN, str, str2);
    }

    public static void O000000o(String str, String str2) {
        gsy.O00000o0(LogType.KUAILIAN, str, str2);
    }

    public static String O000000o(Throwable th) {
        if (th == null) {
            return "";
        }
        for (Throwable th2 = th; th2 != null; th2 = th2.getCause()) {
            if (th2 instanceof UnknownHostException) {
                return "";
            }
        }
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        return stringWriter.toString();
    }
}
