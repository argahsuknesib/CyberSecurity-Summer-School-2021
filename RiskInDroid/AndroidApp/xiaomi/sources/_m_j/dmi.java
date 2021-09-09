package _m_j;

import android.content.Context;
import com.google.android.exoplayer2.C;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;

class dmi {

    /* renamed from: O000000o  reason: collision with root package name */
    static dlm f14784O000000o = dlv.O00000o0();
    static Context O00000oO = null;
    private static dmi O0000O0o = null;
    DefaultHttpClient O00000Oo = null;
    StringBuilder O00000o = new StringBuilder(4096);
    dlp O00000o0 = null;
    long O00000oo = 0;

    /* JADX WARNING: Can't wrap try/catch for region: R(7:0|1|2|(3:4|5|6)|7|8|9) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0066 */
    private dmi(Context context) {
        try {
            O00000oO = context.getApplicationContext();
            this.O00000oo = System.currentTimeMillis() / 1000;
            this.O00000o0 = new dlp();
            if (dkd.O00000Oo()) {
                Logger.getLogger("org.apache.http.wire").setLevel(Level.FINER);
                Logger.getLogger("org.apache.http.headers").setLevel(Level.FINER);
                System.setProperty("org.apache.commons.logging.Log", "org.apache.commons.logging.impl.SimpleLog");
                System.setProperty("org.apache.commons.logging.simplelog.showdatetime", "true");
                System.setProperty("org.apache.commons.logging.simplelog.log.httpclient.wire", "debug");
                System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http", "debug");
                System.setProperty("org.apache.commons.logging.simplelog.log.org.apache.http.headers", "debug");
            }
            BasicHttpParams basicHttpParams = new BasicHttpParams();
            HttpConnectionParams.setStaleCheckingEnabled(basicHttpParams, false);
            HttpConnectionParams.setConnectionTimeout(basicHttpParams, C.MSG_CUSTOM_BASE);
            HttpConnectionParams.setSoTimeout(basicHttpParams, C.MSG_CUSTOM_BASE);
            this.O00000Oo = new DefaultHttpClient(basicHttpParams);
            this.O00000Oo.setKeepAliveStrategy(new dmj(this));
        } catch (Throwable th) {
            f14784O000000o.O00000Oo(th);
        }
    }

    static Context O000000o() {
        return O00000oO;
    }

    static void O000000o(Context context) {
        O00000oO = context.getApplicationContext();
    }

    static dmi O00000Oo(Context context) {
        if (O0000O0o == null) {
            synchronized (dmi.class) {
                if (O0000O0o == null) {
                    O0000O0o = new dmi(context);
                }
            }
        }
        return O0000O0o;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(dkk dkk, dmh dmh) {
        O000000o(Arrays.asList(dkk.O00000oo()), dmh);
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(List<?> list, dmh dmh) {
        dlp dlp = this.O00000o0;
        if (dlp != null) {
            dlp.O000000o(new dmk(this, list, dmh));
        }
    }
}
