package _m_j;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.util.Log;
import android.widget.Toast;

public final class dir {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f14695O000000o = 6;
    public static Context O00000Oo;
    private static O000000o O00000o;
    private static O000000o O00000o0;
    private static final String O00000oO;

    public interface O000000o {
        void O000000o(String str, String str2, String str3, int i, long j, long j2, String str4);

        void O00000Oo(String str, String str2, String str3, int i, long j, long j2, String str4);

        void O00000o(String str, String str2, String str3, int i, long j, long j2, String str4);

        void O00000o0(String str, String str2, String str3, int i, long j, long j2, String str4);

        void O00000oO(String str, String str2, String str3, int i, long j, long j2, String str4);

        void O00000oo(String str, String str2, String str3, int i, long j, long j2, String str4);

        void appenderClose();

        void appenderFlush(boolean z);
    }

    static {
        AnonymousClass1 r0 = new O000000o() {
            /* class _m_j.dir.AnonymousClass1 */

            /* renamed from: O000000o  reason: collision with root package name */
            private Handler f14696O000000o = new Handler(Looper.getMainLooper());

            public final void appenderClose() {
            }

            public final void appenderFlush(boolean z) {
            }

            public final void O000000o(String str, String str2, String str3, int i, long j, long j2, String str4) {
                if (dir.f14695O000000o <= 0) {
                    Log.v(str, str4);
                }
            }

            public final void O00000Oo(String str, String str2, String str3, int i, long j, long j2, String str4) {
                if (dir.f14695O000000o <= 2) {
                    Log.i(str, str4);
                }
            }

            public final void O00000o0(String str, String str2, String str3, int i, long j, long j2, String str4) {
                if (dir.f14695O000000o <= 1) {
                    Log.d(str, str4);
                }
            }

            public final void O00000o(String str, String str2, String str3, int i, long j, long j2, String str4) {
                if (dir.f14695O000000o <= 3) {
                    Log.w(str, str4);
                }
            }

            public final void O00000oO(String str, String str2, String str3, int i, long j, long j2, String str4) {
                if (dir.f14695O000000o <= 4) {
                    Log.e(str, str4);
                }
            }

            public final void O00000oo(String str, String str2, String str3, int i, long j, long j2, final String str4) {
                if (dir.f14695O000000o <= 5) {
                    Log.e(str, str4);
                    if (dir.O00000Oo != null) {
                        this.f14696O000000o.post(new Runnable() {
                            /* class _m_j.dir.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                Toast.makeText(dir.O00000Oo, str4, 1).show();
                            }
                        });
                    }
                }
            }
        };
        O00000o0 = r0;
        O00000o = r0;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        O00000oO = sb.toString();
    }

    public static void O000000o(O000000o o000000o) {
        O00000o = o000000o;
    }

    public static void O000000o() {
        O000000o o000000o = O00000o;
        if (o000000o != null) {
            o000000o.appenderClose();
        }
    }

    public static void O000000o(boolean z) {
        O000000o o000000o = O00000o;
        if (o000000o != null) {
            o000000o.appenderFlush(z);
        }
    }

    public static void O000000o(String str, String str2) {
        O000000o o000000o = O00000o;
        if (o000000o != null) {
            o000000o.O00000oo(str, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void O00000Oo(String str, String str2) {
        if (O00000o != null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            O00000o.O00000oO(str3, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void O00000o0(String str, String str2) {
        if (O00000o != null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            O00000o.O00000o(str3, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void O00000o(String str, String str2) {
        if (O00000o != null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            O00000o.O00000Oo(str3, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void O00000oO(String str, String str2) {
        if (O00000o != null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            O00000o.O00000o0(str3, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void O00000oo(String str, String str2) {
        if (O00000o != null) {
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            O00000o.O000000o(str3, "", "", Process.myPid(), (long) Process.myTid(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }
}
