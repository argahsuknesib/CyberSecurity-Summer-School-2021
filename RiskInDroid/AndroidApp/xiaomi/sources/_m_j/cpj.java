package _m_j;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.UnknownHostException;

final class cpj {
    static boolean O000000o(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    static String O000000o(Throwable th) {
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

    static <T> T O000000o(Object obj) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException();
    }
}
