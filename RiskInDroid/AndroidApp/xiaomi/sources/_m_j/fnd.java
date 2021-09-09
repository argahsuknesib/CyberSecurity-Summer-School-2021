package _m_j;

import _m_j.frj;
import android.database.Cursor;
import android.net.Uri;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.upnp.MiWiFiDownloadApi;

public final class fnd extends MiWiFiDownloadApi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Byte[] f16692O000000o = new Byte[0];
    private static volatile frk O00000Oo = null;

    public static void O000000o() {
        if (_instance == null) {
            synchronized (f16692O000000o) {
                if (_instance == null) {
                    _instance = new fnd();
                }
            }
        }
    }

    public final long startDownload(Uri uri, String str, String str2, String str3) {
        frj.O00000o0 o00000o0 = new frj.O00000o0(uri, str);
        o00000o0.O000000o(CommonApplication.getAppContext(), str2, str3);
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            return O00000Oo2.O000000o(o00000o0);
        }
        return 0;
    }

    private static frk O00000Oo() {
        if (O00000Oo == null) {
            synchronized (f16692O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new frk(CommonApplication.getAppContext(), CommonApplication.getAppContext().getContentResolver(), CommonApplication.getAppContext().getPackageName());
                }
            }
        }
        return O00000Oo;
    }

    public final void pauseDownload(long... jArr) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O00000Oo(jArr);
        }
    }

    public final void resumeDownload(long... jArr) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O00000o0(jArr);
        }
    }

    public final void restartDownload(long... jArr) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O00000o(jArr);
        }
    }

    public final void removeDownload(long... jArr) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O000000o(jArr);
        }
    }

    public final Cursor queryDownload(boolean z, long... jArr) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 == null) {
            return null;
        }
        frj.O00000Oo o00000Oo = new frj.O00000Oo();
        o00000Oo.f16972O000000o = jArr;
        o00000Oo.O00000Oo = z;
        return O00000Oo2.O000000o(o00000Oo);
    }

    public final void notifyLocalWifiConnect(boolean z) {
        frk O00000Oo2 = O00000Oo();
        if (O00000Oo2 != null) {
            O00000Oo2.O000000o(z);
        }
    }
}
