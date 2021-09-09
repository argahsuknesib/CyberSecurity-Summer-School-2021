package _m_j;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.fragment.app.FragmentActivity;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.internal.PassportWebView;
import com.xiaomi.passport.ui.settings.utils.AccountSmsVerifyCodeReceiver;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Ref;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016J(\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0001\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\fH\u0016J\u001c\u0010\u0016\u001a\u00020\f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u001a\u001a\u00020\fH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WebAuthFragment;", "Lcom/xiaomi/passport/ui/internal/SignInFragment;", "Lcom/xiaomi/passport/ui/internal/WebViewBack;", "Lcom/xiaomi/passport/ui/settings/utils/AccountSmsVerifyCodeReceiver$SmsVerifyCodeMessageListener;", "()V", "mSmsReceiver", "Lcom/xiaomi/passport/ui/settings/utils/AccountSmsVerifyCodeReceiver;", "mWebView", "Landroid/webkit/WebView;", "canGoBack", "", "goBack", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onReceived", "message", "", "verifyCode", "onResume", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eii extends ehu implements eij, AccountSmsVerifyCodeReceiver.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15318O000000o = new O000000o((byte) 0);
    private WebView O00000Oo;
    private HashMap O00000o;
    private AccountSmsVerifyCodeReceiver O00000o0;

    public final View O000000o(int i) {
        if (this.O00000o == null) {
            this.O00000o = new HashMap();
        }
        View view = (View) this.O00000o.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O00000o.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final void O000000o() {
        HashMap hashMap = this.O00000o;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        O000000o();
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/xiaomi/passport/ui/internal/WebAuthFragment$Companion;", "", "()V", "newInstance", "Lcom/xiaomi/passport/ui/internal/WebAuthFragment;", "url", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static eii O000000o(String str) {
            ixe.O00000o0(str, "url");
            eii eii = new eii();
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            eii.setArguments(bundle);
            return eii;
        }
    }

    public final void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
        this.O00000o0 = new AccountSmsVerifyCodeReceiver(this);
        FragmentActivity activity = getActivity();
        if (activity == null) {
            ixe.O000000o();
        }
        activity.registerReceiver(this.O00000o0, intentFilter);
    }

    public final void onPause() {
        super.onPause();
        if (this.O00000o0 != null) {
            FragmentActivity activity = getActivity();
            if (activity == null) {
                ixe.O000000o();
            }
            activity.unregisterReceiver(this.O00000o0);
            this.O00000o0 = null;
        }
    }

    public final void O000000o(String str) {
        if (str != null) {
            WebView webView = this.O00000Oo;
            if (webView == null) {
                ixe.O000000o("mWebView");
            }
            webView.loadUrl("javascript:(function(){document.getElementsByName('ticket')[0].value='" + str + "';})()");
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u001c\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016¨\u0006\u000e"}, d2 = {"com/xiaomi/passport/ui/internal/WebAuthFragment$onCreateView$1", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/WebAuthFragment;Lkotlin/jvm/internal/Ref$ObjectRef;Landroid/content/Context;)V", "onLoginEnd", "", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onNeedReLogin", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo extends PassportWebView {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eii f15319O000000o;
        final /* synthetic */ Ref.ObjectRef O00000Oo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(eii eii, Ref.ObjectRef objectRef, Context context) {
            super(context);
            this.f15319O000000o = eii;
            this.O00000Oo = objectRef;
        }

        public final void O00000Oo() {
            this.f15319O000000o.O0000OOo.O000000o();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean
         arg types: [java.lang.String, java.lang.String, int]
         candidates:
          _m_j.iyx.O000000o(java.lang.CharSequence, int, int):int
          _m_j.iyw.O000000o(java.lang.String, java.lang.String, boolean):boolean
          _m_j.iyx.O000000o(java.lang.CharSequence, java.lang.CharSequence, boolean):boolean */
        public final boolean O000000o(AccountInfo accountInfo) {
            ixe.O00000o0(accountInfo, "accountInfo");
            T t = this.O00000Oo.element;
            if (t == null) {
                ixe.O000000o("strUrl");
            }
            if (iyo.O000000o((CharSequence) ((String) t), (CharSequence) "register", false)) {
                efn.O000000o("password_sign_up_success");
            }
            eks.O00000Oo(getContext(), accountInfo);
            this.f15319O000000o.O000000o(accountInfo);
            return true;
        }

        public final boolean O000000o() {
            efp efp = this.f15319O000000o.O0000Oo0;
            if (efp != null) {
                efp.goBack(true);
            }
            return true;
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = null;
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        this.O00000Oo = new O00000Oo(this, objectRef, context);
        O00000oO();
        Bundle arguments = getArguments();
        if (arguments == null) {
            ixe.O000000o();
        }
        T t = arguments.get("url");
        if (t != null) {
            objectRef.element = (String) t;
            WebView webView = this.O00000Oo;
            if (webView == null) {
                ixe.O000000o("mWebView");
            }
            Bundle arguments2 = getArguments();
            if (arguments2 == null) {
                ixe.O000000o();
            }
            webView.loadUrl((String) arguments2.get("url"));
            WebView webView2 = this.O00000Oo;
            if (webView2 == null) {
                ixe.O000000o("mWebView");
            }
            return webView2;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
    }

    public final void O00000o() {
        WebView webView = this.O00000Oo;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        webView.goBack();
    }

    public final boolean O00000o0() {
        WebView webView = this.O00000Oo;
        if (webView == null) {
            ixe.O000000o("mWebView");
        }
        return webView.canGoBack();
    }
}
