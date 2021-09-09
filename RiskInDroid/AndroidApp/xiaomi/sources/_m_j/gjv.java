package _m_j;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;

public class gjv implements gjy {

    /* renamed from: O000000o  reason: collision with root package name */
    protected gjw f17914O000000o;
    protected Handler O00000Oo = new Handler(Looper.getMainLooper());
    protected int O00000o;
    public String O00000o0;

    public static void O000000o(String str, Object... objArr) {
        if (objArr.length > 0) {
            str = String.format(str, objArr);
        }
        gjn.O000000o().O000000o("BaseBleComboConnector", str);
    }

    protected gjv(gjw gjw) {
        this.f17914O000000o = gjw;
    }

    public final void O000000o(final String str) {
        this.O00000o0 = str;
        O000000o("%s.onSearchComboAddress: mac = %s", getClass().getSimpleName(), str);
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.gjv.AnonymousClass1 */

            public final void run() {
                gjv.this.f17914O000000o.O000000o(str);
            }
        });
    }

    public final void O000000o(final int i, final String str, final String str2) {
        O000000o("%s.onSendSSIDAndPassWd: code = %d", getClass().getSimpleName(), Integer.valueOf(i));
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.gjv.AnonymousClass2 */

            public final void run() {
                gjv.this.f17914O000000o.O000000o(i, str, str2);
            }
        });
    }

    public final void O000000o(final int i) {
        O000000o("%s.onNotifyStatus: status = %d", getClass().getSimpleName(), Integer.valueOf(i));
        this.O00000o = i;
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.gjv.AnonymousClass3 */

            public final void run() {
                gjv.this.f17914O000000o.O00000Oo(i);
            }
        });
    }

    public void O000000o(ScanResult scanResult) {
        O000000o("%s.searchComboAddress", getClass().getSimpleName());
    }

    public void O000000o(boolean z, gju gju) {
        O000000o("%s.sendSSIDAndPassWd", getClass().getSimpleName());
    }

    public void O000000o() {
        O000000o("%s.openComboNotify", getClass().getSimpleName());
    }

    public void O00000Oo() {
        O000000o("%s.closeComboNotify", getClass().getSimpleName());
    }

    public void O00000o0() {
        O000000o("%s.retryConnect", getClass().getSimpleName());
    }

    public void O000000o(gjx gjx) {
        O000000o("%s.restore", getClass().getSimpleName());
    }

    public void O00000o() {
        O000000o("%s.release", getClass().getSimpleName());
        this.O00000Oo.removeCallbacksAndMessages(null);
    }
}
