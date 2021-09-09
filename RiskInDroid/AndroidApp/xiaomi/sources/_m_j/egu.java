package _m_j;

import _m_j.eib;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.ui.internal.PassportWebView;
import com.xiaomi.passport.ui.internal.PassportWebView$onReceivedLoginRequest$1;
import com.xiaomi.passport.ui.internal.PassportWebView$onReceivedLoginRequest$2;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J0\u0010\u000b\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\f\u001a\u0004\u0018\u00010\n2\b\u0010\r\u001a\u0004\u0018\u00010\n2\b\u0010\u000e\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000f\u001a\u00020\u00102\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PassportWebViewClient;", "Landroid/webkit/WebViewClient;", "webView", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/PassportWebView;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onReceivedLoginRequest", "realm", "account", "args", "shouldOverrideUrlLoading", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egu extends WebViewClient {

    /* renamed from: O000000o  reason: collision with root package name */
    private final PassportWebView f15255O000000o;

    public egu(PassportWebView passportWebView) {
        ixe.O00000o0(passportWebView, "webView");
        this.f15255O000000o = passportWebView;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
    public final void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
        PassportWebView passportWebView = this.f15255O000000o;
        if (ixe.O000000o((Object) "com.xiaomi", (Object) str)) {
            ServiceTokenFuture O000000o2 = MiAccountManager.O00000Oo(passportWebView.getContext()).O000000o(passportWebView.getContext(), "weblogin:".concat(String.valueOf(str3)));
            eib.O000000o o000000o = eib.f15310O000000o;
            eib.O000000o.O000000o(new PassportWebView$onReceivedLoginRequest$1(O000000o2)).O000000o(new PassportWebView$onReceivedLoginRequest$2(passportWebView));
        }
    }

    public final void onPageFinished(WebView webView, String str) {
        this.f15255O000000o.O00000Oo();
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        ixe.O00000o0(str, "url");
        return this.f15255O000000o.O000000o(webView, str);
    }
}
