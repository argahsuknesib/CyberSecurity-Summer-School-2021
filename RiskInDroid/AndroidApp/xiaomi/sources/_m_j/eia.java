package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import com.xiaomi.passport.ui.internal.PassportWebView;
import com.xiaomi.passport.ui.onetrack.Analytics;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0005¢\u0006\u0002\u0010\u0002J(\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001a\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002¨\u0006\u0012"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsWebLoginFragment;", "Lcom/xiaomi/passport/ui/internal/SnsWebLoginBaseFragment;", "()V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "storePassToken", "", "context", "Landroid/content/Context;", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "Companion", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class eia extends ehz {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final O000000o f15308O000000o = new O000000o((byte) 0);
    private HashMap O00000o;

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

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SnsWebLoginFragment$Companion;", "", "()V", "KEY_SNS_AUTH_PROVIDER_NAME", "", "newInstance", "Lcom/xiaomi/passport/ui/internal/SnsWebLoginFragment;", "e", "Lcom/xiaomi/passport/snscorelib/internal/request/SNSRequest$RedirectToWebLoginException;", "snsAuthProvider", "Lcom/xiaomi/passport/ui/internal/SNSAuthProvider;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O000000o {
        private O000000o() {
        }

        public /* synthetic */ O000000o(byte b) {
            this();
        }

        public static eia O000000o(SNSRequest.RedirectToWebLoginException redirectToWebLoginException, ehr ehr) {
            ixe.O00000o0(redirectToWebLoginException, "e");
            ixe.O00000o0(ehr, "snsAuthProvider");
            eia eia = new eia();
            Bundle bundle = new Bundle();
            bundle.putParcelable("sns_bind_parameter", redirectToWebLoginException.getSNSBindParameter());
            bundle.putString("sns_auth_provider_name", ehr.f15234O000000o);
            eia.setArguments(bundle);
            return eia;
        }
    }

    @Metadata(bv = {1, 0, 2}, d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u000e"}, d2 = {"com/xiaomi/passport/ui/internal/SnsWebLoginFragment$onCreateView$1", "Lcom/xiaomi/passport/ui/internal/PassportWebView;", "(Lcom/xiaomi/passport/ui/internal/SnsWebLoginFragment;Landroid/content/Context;)V", "onPageFinished", "", "view", "Landroid/webkit/WebView;", "url", "", "onSnsBindCancel", "", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onSnsBindFinished", "client-ui_release"}, k = 1, mv = {1, 1, 10})
    public static final class O00000Oo extends PassportWebView {

        /* renamed from: O000000o  reason: collision with root package name */
        final /* synthetic */ eia f15309O000000o;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        O00000Oo(eia eia, Context context) {
            super(context);
            this.f15309O000000o = eia;
        }

        public final boolean O00000o0(AccountInfo accountInfo) {
            this.f15309O000000o.O0000OOo();
            return true;
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
         arg types: [java.lang.String, java.lang.Object]
         candidates:
          _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
          _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
          _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
          _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean */
        public final boolean O00000Oo(AccountInfo accountInfo) {
            if (accountInfo != null) {
                eia.O000000o(getContext(), accountInfo);
                this.f15309O000000o.O000000o(accountInfo);
                Bundle arguments = this.f15309O000000o.getArguments();
                if (!ixe.O000000o((Object) "GOOGLE_AUTH_PROVIDER", arguments != null ? arguments.get("sns_auth_provider_name") : null)) {
                    return true;
                }
                Analytics.O00000o0("sns_google_bind_success");
                return true;
            }
            this.f15309O000000o.O0000OOo();
            return true;
        }

        public final void O00000Oo() {
            this.f15309O000000o.O0000OOo.O000000o();
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ixe.O00000o0(layoutInflater, "inflater");
        Context context = getContext();
        if (context == null) {
            ixe.O000000o();
        }
        O000000o(new O00000Oo(this, context));
        O0000Oo0();
        return O00000Oo();
    }

    public static void O000000o(Context context, AccountInfo accountInfo) {
        if (!TextUtils.isEmpty(accountInfo.passToken)) {
            eks.O00000Oo(context, accountInfo);
        }
    }
}
