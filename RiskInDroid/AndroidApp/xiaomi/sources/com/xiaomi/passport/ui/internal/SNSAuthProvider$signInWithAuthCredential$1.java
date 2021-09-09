package com.xiaomi.passport.ui.internal;

import _m_j.efs;
import _m_j.ehr;
import _m_j.ehx;
import _m_j.ehy;
import _m_j.iwb;
import _m_j.ixe;
import android.content.Context;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import com.xiaomi.passport.snscorelib.internal.entity.SNSLoginParameter;
import com.xiaomi.passport.snscorelib.internal.request.SNSRequest;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class SNSAuthProvider$signInWithAuthCredential$1 extends Lambda implements iwb<AccountInfo> {
    final /* synthetic */ Context $context;
    final /* synthetic */ efs $credential;
    final /* synthetic */ ehr this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSAuthProvider$signInWithAuthCredential$1(ehr ehr, efs efs, Context context) {
        super(0);
        this.this$0 = ehr;
        this.$credential = efs;
        this.$context = context;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.accountsdk.account.data.AccountInfo, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter, java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public AccountInfo invoke() {
        try {
            efs efs = this.$credential;
            if (efs instanceof ehx) {
                ehr ehr = this.this$0;
                Context context = this.$context;
                ehx ehx = (ehx) this.$credential;
                AccountInfo O000000o2 = SNSRequest.O000000o(new SNSLoginParameter.O000000o().O00000oO(ehr.O00000o0(context)).O000000o(ehx.O00000oo).O00000Oo(ehx.O00000o).O00000o0(ehx.O00000oO).O000000o());
                ixe.O000000o((Object) O000000o2, "SNSRequest.snsLoginByCode(params)");
                return O000000o2;
            } else if (efs instanceof ehy) {
                ehr ehr2 = this.this$0;
                Context context2 = this.$context;
                ehy ehy = (ehy) this.$credential;
                AccountInfo O00000Oo = SNSRequest.O00000Oo(new SNSLoginParameter.O000000o().O00000oO(ehr2.O00000o0(context2)).O00000o(ehy.O00000oo).O00000Oo(ehy.O00000o).O00000o0(ehy.O00000oO).O000000o());
                ixe.O000000o((Object) O00000Oo, "SNSRequest.snsLoginByAccessToken(params)");
                return O00000Oo;
            } else {
                throw new IllegalStateException("not support originAuthCredential:" + this.$credential);
            }
        } catch (SNSRequest.NeedLoginForBindException e) {
            SNSBindParameter sNSBindParameter = e.getSNSBindParameter();
            ixe.O000000o((Object) sNSBindParameter, "e.snsBindParameter");
            ehr.O000000o(sNSBindParameter);
            throw e;
        }
    }
}
