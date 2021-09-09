package com.xiaomi.passport.ui.internal;

import _m_j.iuj;
import _m_j.iwb;
import _m_j.ixe;
import android.content.Context;
import com.xiaomi.accountsdk.account.XMPassport;
import com.xiaomi.accountsdk.account.data.ActivatorPhoneInfo;
import com.xiaomi.accountsdk.account.data.QueryPhoneInfoParams;
import com.xiaomi.accountsdk.account.data.RegisterUserInfo;
import com.xiaomi.phonenum.data.AccountCertification;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberManagerFactory;
import com.xiaomi.phonenum.procedure.AccountPhoneNumberSourceFlag;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ljava/util/ArrayList;", "Lcom/xiaomi/accountsdk/account/data/ActivatorPhoneInfo;", "Lkotlin/collections/ArrayList;", "invoke"}, k = 3, mv = {1, 1, 10})
public final class PassportRepoImpl$getLocalActivatorPhone$1 extends Lambda implements iwb<ArrayList<ActivatorPhoneInfo>> {
    final /* synthetic */ Context $context;
    final /* synthetic */ boolean $queryDisplayPhoneNumber;
    final /* synthetic */ String $sid;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PassportRepoImpl$getLocalActivatorPhone$1(Context context, String str, boolean z) {
        super(0);
        this.$context = context;
        this.$sid = str;
        this.$queryDisplayPhoneNumber = z;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void
     arg types: [com.xiaomi.phonenum.data.AccountCertification[], java.lang.String]
     candidates:
      _m_j.ixe.O000000o(java.lang.String, java.lang.Object):java.lang.String
      _m_j.ixe.O000000o(java.lang.Throwable, java.lang.String):T
      _m_j.ixe.O000000o(java.lang.Object, java.lang.Object):boolean
      _m_j.ixe.O000000o(java.lang.Object, java.lang.String):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.iun.O000000o(java.lang.Object[], java.util.Collection):C
     arg types: [com.xiaomi.phonenum.data.AccountCertification[], java.util.ArrayList]
     candidates:
      _m_j.iun.O000000o(java.lang.Object[], java.lang.Object):boolean
      _m_j.ium.O000000o(java.lang.Object[], java.util.Comparator):void
      _m_j.iun.O000000o(java.lang.Object[], java.util.Collection):C */
    /* access modifiers changed from: private */
    /* renamed from: O000000o */
    public ArrayList<ActivatorPhoneInfo> invoke() {
        RegisterUserInfo registerUserInfo;
        ArrayList<ActivatorPhoneInfo> arrayList = new ArrayList<>();
        Class<AccountPhoneNumberManagerFactory> cls = AccountPhoneNumberManagerFactory.class;
        AccountCertification[] accountCertifications = AccountPhoneNumberManagerFactory.createProperManager(this.$context).getAccountCertifications(this.$context, this.$sid, AccountPhoneNumberSourceFlag.getFlag(new int[]{0}));
        ixe.O000000o((Object) accountCertifications, "accountCerts");
        ixe.O00000o0(accountCertifications, "receiver$0");
        for (AccountCertification accountCertification : (List) iuj.O000000o((Object[]) accountCertifications, (Collection) new ArrayList())) {
            if (!this.$queryDisplayPhoneNumber) {
                arrayList.add(new ActivatorPhoneInfo.Builder().phoneHash(accountCertification.hashedPhoneNumber).activatorToken(accountCertification.activatorToken).build());
            } else {
                String str = null;
                try {
                    registerUserInfo = XMPassport.queryPhoneUserInfo(new QueryPhoneInfoParams.Builder().serviceId(this.$sid).subId(String.valueOf(accountCertification.subId)).phoneHashActivatorToken(new ActivatorPhoneInfo.Builder().activatorToken(accountCertification.activatorToken).phoneHash(accountCertification.hashedPhoneNumber).build()).build());
                } catch (Throwable unused) {
                    registerUserInfo = null;
                }
                CharSequence charSequence = registerUserInfo != null ? registerUserInfo.phone : null;
                if (!(charSequence == null || charSequence.length() == 0)) {
                    ActivatorPhoneInfo.Builder activatorToken = new ActivatorPhoneInfo.Builder().phoneHash(accountCertification.hashedPhoneNumber).activatorToken(accountCertification.activatorToken);
                    if (registerUserInfo != null) {
                        str = registerUserInfo.phone;
                    }
                    arrayList.add(activatorToken.phone(str).build());
                }
            }
        }
        return arrayList;
    }
}
