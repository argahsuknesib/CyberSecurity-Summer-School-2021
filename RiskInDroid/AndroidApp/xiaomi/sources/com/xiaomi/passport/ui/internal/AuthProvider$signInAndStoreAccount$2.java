package com.xiaomi.passport.ui.internal;

import _m_j.ehr;
import _m_j.iwc;
import _m_j.ixe;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.snscorelib.internal.entity.SNSBindParameter;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/xiaomi/accountsdk/account/data/AccountInfo;", "it", "invoke"}, k = 3, mv = {1, 1, 10})
public final class AuthProvider$signInAndStoreAccount$2 extends Lambda implements iwc<AccountInfo, AccountInfo> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final AuthProvider$signInAndStoreAccount$2 f6240O000000o = new AuthProvider$signInAndStoreAccount$2();

    AuthProvider$signInAndStoreAccount$2() {
        super(1);
    }

    public final /* synthetic */ Object invoke(Object obj) {
        AccountInfo accountInfo = (AccountInfo) obj;
        ixe.O00000o0(accountInfo, "it");
        ehr.O000000o o000000o = ehr.O0000O0o;
        if (!ehr.O000000o.O000000o()) {
            return accountInfo;
        }
        ehr.O000000o o000000o2 = ehr.O0000O0o;
        SNSBindParameter sNSBindParameter = ehr.O00000oO;
        if (sNSBindParameter == null) {
            ixe.O000000o();
        }
        NeedBindSnsException needBindSnsException = new NeedBindSnsException(sNSBindParameter);
        ehr.O000000o o000000o3 = ehr.O0000O0o;
        ehr.O00000oO = null;
        throw needBindSnsException;
    }
}
