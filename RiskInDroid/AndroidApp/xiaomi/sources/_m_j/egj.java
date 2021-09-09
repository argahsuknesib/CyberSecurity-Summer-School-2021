package _m_j;

import _m_j.ehi;
import _m_j.ehj;
import android.content.Context;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0016\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0004H\u0016J\u001e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0014¨\u0006\u0013"}, d2 = {"Lcom/xiaomi/passport/ui/internal/IdPswAuthProvider;", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "()V", "getFragment", "Lcom/xiaomi/passport/ui/internal/BaseSignInFragment;", "sid", "", "getFragmentWithUserId", "userId", "setPresenter", "", "fragment", "signInWithAuthCredential", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "context", "Landroid/content/Context;", "credential", "Lcom/xiaomi/passport/ui/internal/AuthCredential;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class egj extends efw {
    public egj() {
        super("ID_PSW_AUTH_PROVIDER");
    }

    public final void O000000o(String str, efx efx) {
        ixe.O00000o0(str, "sid");
        ixe.O00000o0(efx, "fragment");
        ehj ehj = (ehj) efx;
        Context context = ehj.getContext();
        if (context == null) {
            ixe.O000000o();
        }
        ehi.O000000o ehk = new ehk(context, str, (ehi.O00000Oo) efx);
        ixe.O00000o0(ehk, "<set-?>");
        ehj.O00000o0 = ehk;
    }

    public final efx O000000o(String str) {
        ixe.O00000o0(str, "sid");
        ehj.O000000o o000000o = ehj.O0000O0o;
        ixe.O00000o0(str, "sid");
        return ehj.O000000o.O000000o(str, null);
    }

    /* access modifiers changed from: protected */
    public final eib<AccountInfo> O000000o(Context context, efs efs) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(efs, "credential");
        if (efs instanceof egi) {
            return this.O00000Oo.O000000o((egi) efs);
        }
        if (efs instanceof egm) {
            return this.O00000Oo.O000000o((egm) efs);
        }
        if (efs instanceof egl) {
            return this.O00000Oo.O000000o((egl) efs);
        }
        throw new IllegalStateException("not support originAuthCredential:".concat(String.valueOf(efs)));
    }
}
