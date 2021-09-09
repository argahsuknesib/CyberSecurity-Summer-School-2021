package _m_j;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0016\u0018\u0000 \u000f2\u00020\u00012\u00020\u0002:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0004J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000bH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsWebLoginBaseFragment;", "Lcom/xiaomi/passport/ui/internal/SignInFragment;", "Lcom/xiaomi/passport/ui/internal/WebViewBack;", "()V", "mWebView", "Landroid/webkit/WebView;", "getMWebView", "()Landroid/webkit/WebView;", "setMWebView", "(Landroid/webkit/WebView;)V", "bind", "", "canGoBack", "", "goBack", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class ehz extends ehu implements eij {
    public static final O000000o O00000o0 = new O000000o((byte) 0);

    /* renamed from: O000000o  reason: collision with root package name */
    private HashMap f15306O000000o;
    protected WebView O00000Oo;

    public View O000000o(int i) {
        if (this.f15306O000000o == null) {
            this.f15306O000000o = new HashMap();
        }
        View view = (View) this.f15306O000000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.f15306O000000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void O000000o() {
        HashMap hashMap = this.f15306O000000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsWebLoginBaseFragment$Companion;", "", "()V", "KEY_SNS_BIND_PARAMETER", "", "SNS_TOKEN_PH", "SNS_WEIXIN_OPENID", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }
    }

    /* access modifiers changed from: protected */
    public final void O000000o(WebView webView) {
        ixe.O00000o0(webView, "<set-?>");
        this.O00000Oo = webView;
    }

    /* access modifiers changed from: protected */
    public final WebView O00000Oo() {
        WebView webView = this.O00000Oo;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        return webView;
    }

    public final boolean O00000o0() {
        WebView webView = this.O00000Oo;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        return webView.canGoBack();
    }

    public final void O00000o() {
        WebView webView = this.O00000Oo;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        webView.goBack();
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: protected */
    public final void O0000Oo0() {
        O00000oO();
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        SNSBindParameter sNSBindParameter = (SNSBindParameter) arguments.get("sns_bind_parameter");
        if (sNSBindParameter != null) {
            Map hashMap = new HashMap();
            String str = sNSBindParameter.f6205O000000o;
            ixe.O000000o((Object) str, "bindParameter.sns_token_ph");
            hashMap.put("sns_token_ph", str);
            String str2 = sNSBindParameter.O00000Oo;
            ixe.O000000o((Object) str2, "bindParameter.sns_weixin_openId");
            hashMap.put("sns_weixin_openId", str2);
            WebView webView = this.O00000Oo;
            if (webView == null) {
                ixe.O000000o("mWebView");
            }
            efm.O000000o(webView, hashMap);
            WebView webView2 = this.O00000Oo;
            if (webView2 == null) {
                ixe.O000000o("mWebView");
            }
            webView2.loadUrl(sNSBindParameter.O00000o0 + "&_locale=" + efk.O000000o(Locale.getDefault()));
        }
    }
}
