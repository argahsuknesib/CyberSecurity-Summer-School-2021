package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.android.arouter.facade.template.ILogger;

public final class ob implements ILogger {

    /* renamed from: O000000o  reason: collision with root package name */
    private static boolean f2338O000000o = false;
    private static boolean O00000Oo = false;
    private static boolean O00000o0 = false;
    private String O00000o = "ARouter";

    public final void showLog(boolean z) {
        f2338O000000o = z;
    }

    public final void showStackTrace(boolean z) {
        O00000Oo = z;
    }

    public ob() {
    }

    public ob(String str) {
        this.O00000o = str;
    }

    public final void debug(String str, String str2) {
        if (f2338O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.d(str, str2 + O000000o(stackTraceElement));
        }
    }

    public final void info(String str, String str2) {
        if (f2338O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.i(str, str2 + O000000o(stackTraceElement));
        }
    }

    public final void warning(String str, String str2) {
        if (f2338O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.w(str, str2 + O000000o(stackTraceElement));
        }
    }

    public final void error(String str, String str2) {
        if (f2338O000000o) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            if (TextUtils.isEmpty(str)) {
                str = getDefaultTag();
            }
            Log.e(str, str2 + O000000o(stackTraceElement));
        }
    }

    public final void monitor(String str) {
        if (f2338O000000o && isMonitorMode()) {
            StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
            Log.d(this.O00000o + "::monitor", str + O000000o(stackTraceElement));
        }
    }

    public final boolean isMonitorMode() {
        return O00000o0;
    }

    public final String getDefaultTag() {
        return this.O00000o;
    }

    private static String O000000o(StackTraceElement stackTraceElement) {
        StringBuilder sb = new StringBuilder("[");
        if (O00000Oo) {
            String name = Thread.currentThread().getName();
            String fileName = stackTraceElement.getFileName();
            String className = stackTraceElement.getClassName();
            String methodName = stackTraceElement.getMethodName();
            long id = Thread.currentThread().getId();
            int lineNumber = stackTraceElement.getLineNumber();
            sb.append("ThreadId=");
            sb.append(id);
            sb.append(" & ");
            sb.append("ThreadName=");
            sb.append(name);
            sb.append(" & ");
            sb.append("FileName=");
            sb.append(fileName);
            sb.append(" & ");
            sb.append("ClassName=");
            sb.append(className);
            sb.append(" & ");
            sb.append("MethodName=");
            sb.append(methodName);
            sb.append(" & ");
            sb.append("LineNumber=");
            sb.append(lineNumber);
        }
        sb.append(" ] ");
        return sb.toString();
    }
}
