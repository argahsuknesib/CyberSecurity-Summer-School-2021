package _m_j;

import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.Looper;

/* renamed from: _m_j.for  reason: invalid class name */
public class Cfor implements fov {

    /* renamed from: O000000o  reason: collision with root package name */
    protected fot f16780O000000o;
    protected Handler O00000Oo = new Handler(Looper.getMainLooper());
    protected int O00000o;
    protected String O00000o0;

    static void O000000o(String str, Object... objArr) {
        htx O000000o2 = hty.O000000o();
        if (O000000o2 != null) {
            O000000o2.smartConfigLog("COMBO:BleComboConnector", str, objArr);
        }
    }

    protected Cfor(fot fot) {
        this.f16780O000000o = fot;
    }

    public final void O000000o(final String str) {
        this.O00000o0 = str;
        gnk.O00000o0(String.format("%s.onSearchComboAddress: mac = %s", getClass().getSimpleName(), str));
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.Cfor.AnonymousClass1 */

            public final void run() {
                Cfor.this.f16780O000000o.O000000o(str);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final int i, final String str, final String str2) {
        gnk.O00000o0(String.format("%s.onSendSSIDAndPassWd: code = %d", getClass().getSimpleName(), Integer.valueOf(i)));
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.Cfor.AnonymousClass2 */

            public final void run() {
                Cfor.this.f16780O000000o.O000000o(i, str, str2);
            }
        });
    }

    /* access modifiers changed from: protected */
    public final void O000000o(final int i) {
        gnk.O00000o0(String.format("%s.onNotifyStatus: status = %d", getClass().getSimpleName(), Integer.valueOf(i)));
        this.O00000o = i;
        this.O00000Oo.post(new Runnable() {
            /* class _m_j.Cfor.AnonymousClass3 */

            public final void run() {
                Cfor.this.f16780O000000o.d_(i);
            }
        });
    }

    public void O000000o(ScanResult scanResult) {
        gnk.O00000o0(String.format("%s.searchComboAddress", getClass().getSimpleName()));
    }

    public void O000000o(boolean z, String str, String str2, String str3) {
        gnk.O00000o0(String.format("%s.sendSSIDAndPassWd", getClass().getSimpleName()));
    }

    public void O000000o(boolean z, String str, long j, String str2, String str3, String str4) {
        gnk.O00000o0(String.format("%s.sendSSIDAndPassWd4DynamicDid", getClass().getSimpleName()));
    }

    public void O000000o() {
        gnk.O00000o0(String.format("%s.openComboNotify", getClass().getSimpleName()));
    }

    public void O00000Oo() {
        gnk.O00000o0(String.format("%s.closeComboNotify", getClass().getSimpleName()));
    }

    public void O00000o0() {
        gnk.O00000o0(String.format("%s.retryConnect", getClass().getSimpleName()));
    }

    public void O000000o(fou fou) {
        gnk.O00000o0(String.format("%s.restore", getClass().getSimpleName()));
    }

    public void O00000o() {
        gnk.O00000o0(String.format("%s.release", getClass().getSimpleName()));
        this.O00000Oo.removeCallbacksAndMessages(null);
    }
}
