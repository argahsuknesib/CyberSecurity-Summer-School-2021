package _m_j;

import _m_j.eht;
import _m_j.ehw;
import _m_j.iar;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.R$id;
import com.xiaomi.passport.ui.internal.NeedBindSnsException;
import java.io.IOException;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\"\u001a\u00020#H\u0016J\u0010\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020&H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010(\u001a\u00020\u00012\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020#H\u0016J\u0010\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020.H\u0016J\u0012\u0010/\u001a\u00020#2\b\u00100\u001a\u0004\u0018\u000101H\u0016J\u0012\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020#H\u0016J\b\u00106\u001a\u00020#H\u0016J\u0010\u00107\u001a\u00020#2\u0006\u00108\u001a\u000209H\u0016JH\u0010:\u001a\u00020#2\u0006\u0010;\u001a\u00020<26\u0010=\u001a2\u0012\u0013\u0012\u001109¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u001109¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020#0>H\u0016J\u0010\u0010C\u001a\u00020#2\u0006\u0010%\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020#H\u0016J\u0010\u0010F\u001a\u00020#2\u0006\u0010G\u001a\u00020HH\u0016J\u0018\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u0002092\u0006\u0010K\u001a\u00020LH\u0004R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006M"}, d2 = {"Lcom/xiaomi/passport/ui/internal/SignInFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/xiaomi/passport/ui/internal/SignInContract$View;", "()V", "accountLoginController", "Lcom/xiaomi/passport/ui/uicontroller/AccountLoginController;", "getAccountLoginController", "()Lcom/xiaomi/passport/ui/uicontroller/AccountLoginController;", "setAccountLoginController", "(Lcom/xiaomi/passport/ui/uicontroller/AccountLoginController;)V", "addAccountListener", "Lcom/xiaomi/passport/ui/internal/AddAccountListener;", "getAddAccountListener", "()Lcom/xiaomi/passport/ui/internal/AddAccountListener;", "setAddAccountListener", "(Lcom/xiaomi/passport/ui/internal/AddAccountListener;)V", "mCommonErrorHandler", "Lcom/xiaomi/passport/ui/internal/CommonErrorHandler;", "getMCommonErrorHandler", "()Lcom/xiaomi/passport/ui/internal/CommonErrorHandler;", "mProgressHolder", "Lcom/xiaomi/passport/ui/internal/ProgressHolder;", "mVerificationManager", "Lcom/xiaomi/verificationsdk/VerificationManager;", "getMVerificationManager", "()Lcom/xiaomi/verificationsdk/VerificationManager;", "setMVerificationManager", "(Lcom/xiaomi/verificationsdk/VerificationManager;)V", "mWebAuth", "Lcom/xiaomi/passport/ui/internal/WebAuth;", "getMWebAuth", "()Lcom/xiaomi/passport/ui/internal/WebAuth;", "setMWebAuth", "(Lcom/xiaomi/passport/ui/internal/WebAuth;)V", "dismissProgress", "", "gotoBindSnsFragment", "e", "Lcom/xiaomi/passport/ui/internal/NeedBindSnsException;", "gotoFragment", "fragment", "addToBackStack", "", "loginCancelled", "loginSuccess", "accountInfo", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "onAttach", "context", "Landroid/content/Context;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onDetach", "openNotificationUrl", "url", "", "showCaptcha", "captcha", "Lcom/xiaomi/passport/ui/internal/Captcha;", "callback", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "ick", "showNetworkError", "Ljava/io/IOException;", "showProgress", "showUnKnowError", "tr", "", "showVerification", "action", "verifyResultCallback", "Lcom/xiaomi/verificationsdk/VerificationManager$VerifyResultCallback;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public class ehu extends Fragment implements eht.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    private final egc f15301O000000o = new egc();
    private HashMap O00000Oo;
    final ehh O0000OOo = new ehh();
    public ekk O0000Oo;
    efp O0000Oo0;
    eih O0000OoO = new eih();
    public iar O0000Ooo;

    public View O000000o(int i) {
        if (this.O00000Oo == null) {
            this.O00000Oo = new HashMap();
        }
        View view = (View) this.O00000Oo.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i);
        this.O00000Oo.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public void O000000o() {
        HashMap hashMap = this.O00000Oo;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final ekk O0000O0o() {
        ekk ekk = this.O0000Oo;
        if (ekk == null) {
            ixe.O000000o("accountLoginController");
        }
        return ekk;
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof efp) {
            this.O0000Oo0 = (efp) context;
            if (context instanceof ekk) {
                this.O0000Oo = (ekk) context;
                return;
            }
            throw new IllegalStateException("attached context " + context + " must implement AccountLoginController");
        }
        StringBuilder sb = new StringBuilder();
        if (context == null) {
            ixe.O000000o();
        }
        sb.append(context.toString());
        sb.append(" must implement AddAccountListener");
        throw new RuntimeException(sb.toString());
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.O0000Ooo = new iar(getActivity());
        iar iar = this.O0000Ooo;
        if (iar == null) {
            ixe.O000000o("mVerificationManager");
        }
        iar.O00000o0("https://verify.sec.xiaomi.com");
        iar iar2 = this.O0000Ooo;
        if (iar2 == null) {
            ixe.O000000o("mVerificationManager");
        }
        iar2.O000000o("8027422fb0eb42fbac1b521ec4a7961f");
        iar iar3 = this.O0000Ooo;
        if (iar3 == null) {
            ixe.O000000o("mVerificationManager");
        }
        iar3.O000000o(Boolean.TRUE);
        iar iar4 = this.O0000Ooo;
        if (iar4 == null) {
            ixe.O000000o("mVerificationManager");
        }
        iar4.O000000o();
    }

    public void onDetach() {
        super.onDetach();
        this.O0000Oo0 = null;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, iar.O00000Oo o00000Oo) {
        ixe.O00000o0(str, "action");
        ixe.O00000o0(o00000Oo, "verifyResultCallback");
        iar iar = this.O0000Ooo;
        if (iar == null) {
            ixe.O000000o("mVerificationManager");
        }
        iar.O00000Oo(str).O000000o(o00000Oo).O00000o0();
    }

    public final void O000000o(IOException iOException) {
        ixe.O00000o0(iOException, "e");
        if (getContext() != null) {
            egc egc = this.f15301O000000o;
            Context context = getContext();
            if (context == null) {
                ixe.O000000o();
            }
            egc.O000000o(iOException, context, (ConstraintLayout) O000000o(R$id.fragment_main));
        }
    }

    public final void O000000o(Throwable th) {
        ixe.O00000o0(th, "tr");
        if (getContext() != null) {
            egc egc = this.f15301O000000o;
            Context context = getContext();
            if (context == null) {
                ixe.O000000o();
            }
            egc.O000000o(th, context);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [android.view.LayoutInflater, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    public final void O000000o(efz efz, iwn<? super String, ? super String, iuh> iwn) {
        ixe.O00000o0(efz, "captcha");
        ixe.O00000o0(iwn, "callback");
        if (getContext() != null) {
            egc egc = this.f15301O000000o;
            Context context = getContext();
            if (context == null) {
                ixe.O000000o();
            }
            LayoutInflater layoutInflater = getLayoutInflater();
            ixe.O000000o((Object) layoutInflater, "layoutInflater");
            egc.O000000o(context, layoutInflater, efz, iwn);
        }
    }

    public final void O00000oO() {
        if (getContext() != null) {
            ehh ehh = this.O0000OOo;
            Context context = getContext();
            if (context == null) {
                ixe.O000000o();
            }
            ehh.O000000o(context);
        }
    }

    public final void O00000oo() {
        this.O0000OOo.O000000o();
    }

    public final void O000000o(NeedBindSnsException needBindSnsException) {
        ixe.O00000o0(needBindSnsException, "e");
        efp efp = this.O0000Oo0;
        if (efp != null) {
            ixe.O00000o0(needBindSnsException, "e");
            ehw.O000000o o000000o = ehw.f15304O000000o;
            ixe.O00000o0(needBindSnsException, "e");
            ehw ehw = new ehw();
            Bundle bundle = new Bundle();
            bundle.putParcelable("sns_bind_parameter", needBindSnsException.getSnsBindParams());
            ehw.setArguments(bundle);
            efp.gotoFragment(ehw, true);
        }
    }

    public final void O00000o(String str) {
        ixe.O00000o0(str, "url");
        efp efp = this.O0000Oo0;
        if (efp != null) {
            efp.gotoFragment(eih.O000000o(str), true);
        }
    }

    public final void O000000o(AccountInfo accountInfo) {
        ixe.O00000o0(accountInfo, "accountInfo");
        efp efp = this.O0000Oo0;
        if (efp != null) {
            efp.loginSuccess(accountInfo);
        }
    }

    public final void O0000OOo() {
        efp efp = this.O0000Oo0;
        if (efp != null) {
            efp.loginCancelled();
        }
    }

    public final void O000000o(Fragment fragment, boolean z) {
        ixe.O00000o0(fragment, "fragment");
        efp efp = this.O0000Oo0;
        if (efp != null) {
            efp.gotoFragment(fragment, z);
        }
    }

    public void onDestroyView() {
        this.O0000OOo.O000000o();
        super.onDestroyView();
        O000000o();
    }
}
