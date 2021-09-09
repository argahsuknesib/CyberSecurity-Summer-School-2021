package _m_j;

import android.app.Activity;
import com.xiaomi.smarthome.operation.js_sdk.base.CommonWebView;
import java.lang.ref.WeakReference;

public abstract class hlj extends hli {

    public interface O000000o {
        void O000000o(String str);

        void O00000Oo(String str);
    }

    /* access modifiers changed from: protected */
    public abstract void O000000o(O000000o o000000o);

    public hlj(WeakReference<CommonWebView> weakReference, WeakReference<Activity> weakReference2) {
        super(weakReference, weakReference2);
        O000000o(new O000000o() {
            /* class _m_j.hlj.AnonymousClass1 */

            public final void O000000o(String str) {
                gsy.O000000o(3, "JsPromiseSync", "onSuccess: ".concat(String.valueOf(str)));
                hlj.this.mResultSubject.onNext(str);
            }

            public final void O00000Oo(String str) {
                gsy.O000000o(3, "JsPromiseSync", "invoke: ".concat(String.valueOf(str)));
                hlj.this.mResultSubject.onError(new Exception(str));
            }
        });
    }
}
