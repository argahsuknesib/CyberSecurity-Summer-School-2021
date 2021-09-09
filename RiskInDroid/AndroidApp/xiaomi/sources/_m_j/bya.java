package _m_j;

import android.util.Log;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Locale;

public final class bya {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object f13400O000000o = new Object();
    private static final SimpleDateFormat O00000Oo = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss.SSS", Locale.US);
    private static final SimpleDateFormat O00000o0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public static void O000000o() {
        bxz.O00000Oo().post(new Runnable() {
            /* class _m_j.bya.AnonymousClass1 */

            public final void run() {
                long currentTimeMillis = System.currentTimeMillis();
                File[] O00000o0 = bxw.O00000o0();
                if (O00000o0 != null && O00000o0.length > 0) {
                    synchronized (bya.f13400O000000o) {
                        for (File file : O00000o0) {
                            if (currentTimeMillis - file.lastModified() > 172800000) {
                                file.delete();
                            }
                        }
                    }
                }
            }
        });
    }

    public static void O00000Oo() {
        synchronized (f13400O000000o) {
            try {
                File[] O00000o02 = bxw.O00000o0();
                if (O00000o02 != null && O00000o02.length > 0) {
                    for (File delete : O00000o02) {
                        delete.delete();
                    }
                }
            } catch (Throwable th) {
                Log.e("LogWriter", "deleteAll: ", th);
            }
        }
    }
}
