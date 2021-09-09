package com.xiaomi.passport.ui.internal;

import _m_j.efz;
import _m_j.egm;
import _m_j.egs;
import _m_j.ekq;
import _m_j.iwb;
import _m_j.ixe;
import android.graphics.Bitmap;
import android.util.Pair;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.Step2LoginParams;
import com.xiaomi.accountsdk.account.exception.NeedCaptchaException;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$signInWithVStep2code$1 extends Lambda implements iwb<AccountInfo> {
    final /* synthetic */ egm $credential;
    final /* synthetic */ egs this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$signInWithVStep2code$1(egs egs, egm egm) {
        super(0);
        this.this$0 = egs;
        this.$credential = egm;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [java.lang.String, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public AccountInfo invoke() {
        try {
            return ekq.O000000o(new Step2LoginParams.Builder().setTrust(this.$credential.O0000Oo0).setMetaLoginData(this.$credential.O0000O0o).setStep1Token(this.$credential.O00000oO).setServiceId(this.$credential.O00000o).setUserId(this.$credential.O00000oo).setStep2code(this.$credential.O0000OOo).build());
        } catch (NeedCaptchaException e) {
            String captchaUrl = e.getCaptchaUrl();
            ixe.O000000o((Object) captchaUrl, "url");
            Pair<Bitmap, String> O00000o = egs.O00000o(captchaUrl);
            Object obj = O00000o.second;
            ixe.O000000o(obj, "captcha.second");
            throw new CaptchaException(new efz((Bitmap) O00000o.first, (String) obj, captchaUrl));
        }
    }
}
