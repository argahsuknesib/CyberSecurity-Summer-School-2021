package _m_j;

import android.webkit.WebView;
import com.xiaomi.smarthome.operation.js_sdk.lifecycle.LifeCycleEvent;
import java.util.ArrayList;
import java.util.List;

public final class hlc {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<O000000o> f19030O000000o = new ArrayList();

    public interface O000000o {
        void O000000o(LifeCycleEvent lifeCycleEvent, WebView webView);
    }

    public final void O000000o(LifeCycleEvent lifeCycleEvent, hke hke, String str) {
        if (hke == null) {
            gsy.O000000o(6, "LifeCycleDispatcher", "dispatchEvent: target is null");
            return;
        }
        synchronized (this.f19030O000000o) {
            for (O000000o O000000o2 : this.f19030O000000o) {
                O000000o2.O000000o(lifeCycleEvent, hke.getWebView());
            }
        }
        String str2 = lifeCycleEvent.mActionName;
        if (lifeCycleEvent == LifeCycleEvent.PAGE_RESUME) {
            hlp.O000000o(hke.getWebView(), "smartHome.dispatchEvent", str2, str);
            return;
        }
        hlp.O000000o(hke.getWebView(), "smartHome.dispatchEvent", str2);
    }
}
