package xcrash;

import _m_j.jrm;
import _m_j.jrp;
import _m_j.jrq;
import _m_j.jrr;
import _m_j.jru;
import _m_j.jrv;
import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import java.io.File;
import java.util.Map;

@SuppressLint({"StaticFieldLeak"})
public class NativeHandler {
    private static final NativeHandler O00000o0 = new NativeHandler();

    /* renamed from: O000000o  reason: collision with root package name */
    public boolean f15499O000000o;
    public boolean O00000Oo = false;
    private long O00000o = 15000;
    private Context O00000oO;
    private boolean O00000oo;
    private jrq O0000O0o;
    private boolean O0000OOo;
    private jrq O0000Oo0;

    private static native int nativeInit(int i, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, boolean z, boolean z2, int i2, int i3, int i4, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i5, String[] strArr, boolean z8, boolean z9, int i6, int i7, int i8, boolean z10, boolean z11);

    public static native void nativeNotifyJavaCrashed();

    static native void nativeTestCrash(int i);

    public static native void nativeTraceSignalInit();

    private NativeHandler() {
    }

    public static NativeHandler O000000o() {
        return O00000o0;
    }

    /* access modifiers changed from: package-private */
    public final int O000000o(Context context, jrr jrr, String str, String str2, String str3, boolean z, boolean z2, int i, int i2, int i3, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, int i4, String[] strArr, jrq jrq, boolean z8, boolean z9, boolean z10, int i5, int i6, int i7, boolean z11, boolean z12, jrq jrq2) {
        if (jrr == null) {
            try {
                System.loadLibrary("xcrash");
            } catch (Throwable th) {
                XCrash.O000000o().O00000o0("xcrash", "NativeHandler System.loadLibrary failed", th);
                return -2;
            }
        }
        this.O00000oO = context;
        this.O00000oo = z2;
        this.O0000O0o = jrq;
        this.f15499O000000o = z8;
        this.O0000OOo = z10;
        this.O0000Oo0 = jrq2;
        this.O00000o = z9 ? 15000 : DashMediaSource.DEFAULT_LIVE_PRESENTATION_DELAY_FIXED_MS;
        try {
            if (nativeInit(Build.VERSION.SDK_INT, Build.VERSION.RELEASE, jrv.O000000o(), Build.MANUFACTURER, Build.BRAND, Build.MODEL, Build.FINGERPRINT, str, str2, context.getApplicationInfo().nativeLibraryDir, str3, z, z2, i, i2, i3, z3, z4, z5, z6, z7, i4, strArr, z8, z9, i5, i6, i7, z11, z12) != 0) {
                XCrash.O000000o().O000000o("xcrash", "NativeHandler init failed");
                return -3;
            }
            this.O00000Oo = true;
            return 0;
        } catch (Throwable th2) {
            XCrash.O000000o().O00000o0("xcrash", "NativeHandler init failed", th2);
            return -3;
        }
    }

    private static String O000000o(boolean z, String str) {
        try {
            for (Map.Entry next : Thread.getAllStackTraces().entrySet()) {
                Thread thread = (Thread) next.getKey();
                if ((z && thread.getName().equals("main")) || (!z && thread.getName().contains(str))) {
                    StringBuilder sb = new StringBuilder();
                    for (StackTraceElement stackTraceElement : (StackTraceElement[]) next.getValue()) {
                        sb.append("    at ");
                        sb.append(stackTraceElement.toString());
                        sb.append("\n");
                    }
                    return sb.toString();
                }
            }
            return null;
        } catch (Exception e) {
            XCrash.O000000o().O00000o0("xcrash", "NativeHandler getStacktraceByThreadName failed", e);
            return null;
        }
    }

    private static void crashCallback(String str, String str2, boolean z, boolean z2, String str3) {
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                String O000000o2 = O000000o(z2, str3);
                if (!TextUtils.isEmpty(O000000o2)) {
                    jru.O000000o(str, "java stacktrace", O000000o2);
                }
            }
            jru.O000000o(str, "memory info", jrv.O00000Oo());
            jru.O000000o(str, "foreground", jrm.O000000o().O00000Oo ? "yes" : "no");
        }
        if (!O00000o0.O00000oo) {
            jrm.O000000o().O00000Oo();
        }
    }

    private static void traceSignalInit() {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            /* class xcrash.NativeHandler.AnonymousClass1 */

            public final void run() {
                NativeHandler.nativeTraceSignalInit();
            }
        });
    }

    private static void traceCallback(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            jru.O000000o(str, "memory info", jrv.O00000Oo());
            jru.O000000o(str, "foreground", jrm.O000000o().O00000Oo ? "yes" : "no");
            NativeHandler nativeHandler = O00000o0;
            if (nativeHandler.O0000OOo && !jrv.O000000o(nativeHandler.O00000oO, nativeHandler.O00000o)) {
                jrp.O000000o().O000000o(new File(str));
            } else if (jrp.O000000o().O00000Oo()) {
                String str3 = str.substring(0, str.length() - 13) + ".anr.xcrash";
                File file = new File(str);
                if (!file.renameTo(new File(str3))) {
                    jrp.O000000o().O000000o(file);
                } else {
                    if (O00000o0.O0000Oo0 != null) {
                    }
                }
            }
        }
    }
}
