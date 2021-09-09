package _m_j;

import android.annotation.SuppressLint;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import com.xiaomi.smarthome.operation.js_sdk.network.NetWorkObserver;
import java.lang.ref.WeakReference;

public final class hlh {

    /* renamed from: O000000o  reason: collision with root package name */
    public final NetWorkObserver f19034O000000o = new NetWorkObserver();
    private WeakReference<CommonWebView> O00000Oo = null;
    @SuppressLint({"CheckResult"})
    private final NetWorkObserver.O000000o O00000o = new NetWorkObserver.O000000o() {
        /* class _m_j.$$Lambda$hlh$HDX5bypoZoSl82Mxubl7g6SbE0 */

        public final void onNetChanged(hlg hlg) {
            hlh.this.O000000o(hlg);
        }
    };
    private hlg O00000o0 = null;

    /* access modifiers changed from: private */
    public /* synthetic */ void O000000o(hlg hlg) {
        if (hlg != this.O00000o0) {
            this.O00000o0 = hlg;
            hlp.O000000o(this.O00000Oo.get(), "smartHome.dispatchEvent", "networkChange", hlg.O000000o().toString());
        }
    }

    public hlh(CommonWebView commonWebView) {
        this.O00000Oo = new WeakReference<>(commonWebView);
        this.f19034O000000o.O000000o(this.O00000o);
    }
}
