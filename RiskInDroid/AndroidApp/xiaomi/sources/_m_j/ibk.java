package _m_j;

import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;

public abstract class ibk<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public LoginMiAccount f1152O000000o;
    public ibn<T> O00000Oo;
    private MiServiceTokenInfo O00000o0;

    public abstract void O000000o(LoginMiAccount loginMiAccount, MiServiceTokenInfo miServiceTokenInfo, boolean z);

    public ibk(LoginMiAccount loginMiAccount, ibn<T> ibn) {
        this.f1152O000000o = loginMiAccount;
        if (this.f1152O000000o != null) {
            this.O00000o0 = loginMiAccount.O000000o("passportapi");
        }
        this.O00000Oo = ibn;
    }

    public final void O000000o() {
        LoginMiAccount loginMiAccount = this.f1152O000000o;
        if (loginMiAccount == null) {
            this.O00000Oo.O000000o(-1, "loginMiAccount is null");
            return;
        }
        MiServiceTokenInfo miServiceTokenInfo = this.O00000o0;
        if (miServiceTokenInfo == null) {
            this.O00000Oo.O000000o(-2, "passportapi serviceToken is null");
        } else {
            O000000o(loginMiAccount, miServiceTokenInfo, true);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, int, _m_j.ibk$1]
     candidates:
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [java.lang.String, java.lang.String, java.lang.String, int, _m_j.ibk$1]
     candidates:
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    public final void O00000Oo() {
        AnonymousClass1 r0 = new ibh<MiServiceTokenInfo, ExceptionError>() {
            /* class _m_j.ibk.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                ExceptionError exceptionError = (ExceptionError) error;
                ibn<T> ibn = ibk.this.O00000Oo;
                ibn.O000000o(-100, "refresh ServiceToken失败 " + exceptionError.f12083O000000o + " " + exceptionError.O00000Oo);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                MiServiceTokenInfo miServiceTokenInfo2 = new MiServiceTokenInfo("passportapi", miServiceTokenInfo.O00000Oo, miServiceTokenInfo.O00000o0, miServiceTokenInfo.O00000o, icr.O000000o("passportapi"), miServiceTokenInfo.O00000oO);
                ibk.this.O00000Oo.O000000o(miServiceTokenInfo2);
                ibk.this.f1152O000000o.O000000o(miServiceTokenInfo2);
                ibk ibk = ibk.this;
                ibk.O000000o(ibk.f1152O000000o, miServiceTokenInfo2, false);
            }
        };
        if (this.f1152O000000o.O00000Oo()) {
            ibm.O000000o("passportapi", this.f1152O000000o.O000000o(), this.O00000o0, false, (ibh<MiServiceTokenInfo, ExceptionError>) r0);
        } else {
            ibm.O000000o("passportapi", this.f1152O000000o.O000000o(), this.f1152O000000o.O00000o0(), false, (ibh<MiServiceTokenInfo, ExceptionError>) r0);
        }
    }
}
