package _m_j;

import android.os.Build;
import android.os.Trace;
import android.util.Log;
import java.lang.reflect.Method;

public final class as {

    /* renamed from: O000000o  reason: collision with root package name */
    private static long f12566O000000o;
    private static Method O00000Oo;
    private static Method O00000o;
    private static Method O00000o0;
    private static Method O00000oO;

    static {
        if (Build.VERSION.SDK_INT >= 18 && Build.VERSION.SDK_INT < 29) {
            try {
                f12566O000000o = Trace.class.getField("TRACE_TAG_APP").getLong(null);
                O00000Oo = Trace.class.getMethod("isTagEnabled", Long.TYPE);
                O00000o0 = Trace.class.getMethod("asyncTraceBegin", Long.TYPE, String.class, Integer.TYPE);
                O00000o = Trace.class.getMethod("asyncTraceEnd", Long.TYPE, String.class, Integer.TYPE);
                O00000oO = Trace.class.getMethod("traceCounter", Long.TYPE, String.class, Integer.TYPE);
            } catch (Exception e) {
                Log.i("TraceCompat", "Unable to initialize via reflection.", e);
            }
        }
    }

    public static void O000000o(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    public static void O000000o() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
