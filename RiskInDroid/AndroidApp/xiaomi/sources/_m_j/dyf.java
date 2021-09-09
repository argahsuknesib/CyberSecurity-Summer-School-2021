package _m_j;

import _m_j.dxr;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Printer;
import com.xiaomi.miot.support.monitor.exceptions.MiotMonitorBlockException;
import org.json.JSONException;
import org.json.JSONObject;

public final class dyf extends dyo {

    /* renamed from: O000000o  reason: collision with root package name */
    Handler f15062O000000o;
    long O00000Oo;
    private final String O00000o = "BlockTask";
    Runnable O00000o0 = new Runnable() {
        /* class _m_j.dyf.AnonymousClass1 */

        public final void run() {
            if (dyf.this.O00000o0()) {
                StackTraceElement[] stackTrace = Looper.getMainLooper().getThread().getStackTrace();
                if (dyf.this.O00000o0()) {
                    dxy O000000o2 = dxr.O000000o.f15041O000000o.O000000o();
                    MiotMonitorBlockException miotMonitorBlockException = new MiotMonitorBlockException();
                    miotMonitorBlockException.setStackTrace(stackTrace);
                    if (TextUtils.equals(O000000o2.O00000o0.report_type, "1")) {
                        O000000o2.f15049O000000o.O000000o(100, O000000o2.O00000o0.report_type, miotMonitorBlockException);
                        return;
                    }
                    try {
                        O000000o2.f15049O000000o.O000000o(100, O000000o2.O00000o0.report_type, new JSONObject().put("stack", miotMonitorBlockException.getLogInfo()));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };
    private HandlerThread O00000oO = new HandlerThread("blockThread");

    public final void O000000o() {
        try {
            super.O000000o();
            this.O00000Oo = dxr.O000000o.f15041O000000o.O000000o().O00000o0.threshold_ms;
            if (!this.O00000oO.isAlive()) {
                this.O00000oO.start();
                this.f15062O000000o = new Handler(this.O00000oO.getLooper());
                Looper.getMainLooper().setMessageLogging(new Printer() {
                    /* class _m_j.dyf.AnonymousClass2 */

                    public final void println(String str) {
                        if (dyf.this.O00000o0()) {
                            if (str.startsWith(">>>>> Dispatching")) {
                                dyf dyf = dyf.this;
                                dyf.f15062O000000o.postDelayed(dyf.O00000o0, dyf.O00000Oo);
                            }
                            if (str.startsWith("<<<<< Finished")) {
                                dyf dyf2 = dyf.this;
                                dyf2.f15062O000000o.removeCallbacks(dyf2.O00000o0);
                            }
                        }
                    }
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
