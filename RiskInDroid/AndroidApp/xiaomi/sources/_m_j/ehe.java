package _m_j;

import _m_j.egv;
import _m_j.egw;
import _m_j.eib;
import android.content.Context;
import android.os.Bundle;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.ui.internal.PhoneSmsAuthProvider$signInOrSignUpWithChoice$1;
import com.xiaomi.passport.ui.internal.PhoneSmsAuthProvider$signInOrSignUpWithChoice$2;
import com.xiaomi.passport.ui.internal.PhoneSmsAuthProvider$trySignInWithAuthCredential$1;
import com.xiaomi.passport.ui.internal.PhoneSmsAuthProvider$trySignInWithAuthCredential$2;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u0012H\u0014J\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002¨\u0006\u0016"}, d2 = {"Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthProvider;", "Lcom/xiaomi/passport/ui/internal/BaseAuthProvider;", "()V", "getFragment", "Lcom/xiaomi/passport/ui/internal/BaseSignInFragment;", "sid", "", "setPresenter", "", "fragment", "signInOrSignUpWithChoice", "Lcom/xiaomi/passport/ui/internal/Source;", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "credential", "Lcom/xiaomi/passport/ui/internal/ChoosePhoneSmsAuthCredential;", "signInWithAuthCredential", "context", "Landroid/content/Context;", "Lcom/xiaomi/passport/ui/internal/AuthCredential;", "trySignInWithAuthCredential", "authCredential", "Lcom/xiaomi/passport/ui/internal/PhoneSmsAuthCredential;", "client-ui_release"}, k = 1, mv = {1, 1, 10})
public final class ehe extends efw {
    public ehe() {
        super("PHONE_SMS_AUTH_PROVIDER");
    }

    public final void O000000o(String str, efx efx) {
        ixe.O00000o0(str, "sid");
        ixe.O00000o0(efx, "fragment");
        egw egw = (egw) efx;
        Context context = egw.getContext();
        if (context == null) {
            ixe.O000000o();
        }
        egv.O000000o egx = new egx(context, str, (egv.O00000Oo) efx);
        ixe.O00000o0(egx, "<set-?>");
        egw.O00000o = egx;
    }

    public final efx O000000o(String str) {
        ixe.O00000o0(str, "sid");
        egw.O000000o o000000o = egw.O0000O0o;
        ixe.O00000o0(str, "sid");
        egw egw = new egw();
        Bundle bundle = new Bundle();
        bundle.putString("sid", str);
        egw.setArguments(bundle);
        return egw;
    }

    /* access modifiers changed from: protected */
    public final eib<AccountInfo> O000000o(Context context, efs efs) {
        ixe.O00000o0(context, "context");
        ixe.O00000o0(efs, "credential");
        if (efs instanceof egb) {
            egb egb = (egb) efs;
            if (egb.O00000oo) {
                eib.O000000o o000000o = eib.f15310O000000o;
                return eib.O000000o.O000000o(new PhoneSmsAuthProvider$signInOrSignUpWithChoice$1(this, egb));
            }
            eib.O000000o o000000o2 = eib.f15310O000000o;
            return eib.O000000o.O000000o(new PhoneSmsAuthProvider$signInOrSignUpWithChoice$2(this, egb));
        } else if (efs instanceof ehd) {
            ehd ehd = (ehd) efs;
            eib.O000000o o000000o3 = eib.f15310O000000o;
            return eib.O000000o.O000000o(new PhoneSmsAuthProvider$trySignInWithAuthCredential$1(this, ehd)).O00000Oo(new PhoneSmsAuthProvider$trySignInWithAuthCredential$2(this, ehd));
        } else {
            throw new IllegalStateException("not support originAuthCredential:".concat(String.valueOf(efs)));
        }
    }
}
