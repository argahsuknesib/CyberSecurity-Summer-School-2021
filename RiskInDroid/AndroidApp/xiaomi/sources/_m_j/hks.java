package _m_j;

import android.webkit.WebView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0001\nB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/bridge/NativeHandlersForJs;", "", "mWebView", "Landroid/webkit/WebView;", "(Landroid/webkit/WebView;)V", "allHandlers", "", "Lcom/xiaomi/smarthome/operation/js_sdk/bridge/JavaBridgeHandler;", "getAllHandlers", "()Ljava/util/List;", "Companion", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class hks {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f19020O000000o = new O000000o((byte) 0);
    final List<hkr> O00000Oo;
    private final WebView O00000o0;

    public hks(WebView webView) {
        ixe.O00000o(webView, "mWebView");
        this.O00000o0 = webView;
        hku hku = new hku(this.O00000o0);
        ArrayList arrayList = new ArrayList();
        arrayList.add(hku.O00000Oo);
        arrayList.add(hku.O00000o0);
        arrayList.add(hku.O00000o);
        ixe.O00000Oo(arrayList, "LoginHandlerHelper(mWebView).handlers");
        this.O00000Oo = arrayList;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/xiaomi/smarthome/operation/js_sdk/bridge/NativeHandlersForJs$Companion;", "", "()V", "TAG", "", "smarthome-webview_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class O000000o {
        public /* synthetic */ O000000o(byte b) {
            this();
        }

        private O000000o() {
        }
    }
}
