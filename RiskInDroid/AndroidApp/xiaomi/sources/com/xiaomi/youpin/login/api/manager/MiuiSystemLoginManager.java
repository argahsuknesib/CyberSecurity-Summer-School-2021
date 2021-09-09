package com.xiaomi.youpin.login.api.manager;

import _m_j.ibh;
import _m_j.ibm;
import _m_j.ibq;
import _m_j.ici;
import _m_j.icl;
import android.app.Activity;
import android.content.Context;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class MiuiSystemLoginManager extends CoreBaseLoginManager {
    private boolean O0000OOo = ibm.f1156O000000o.O00000o0;

    public MiuiSystemLoginManager(Context context) {
        super(context);
    }

    public final void O000000o(final Activity activity, final ibq ibq) {
        icl.O000000o(this.O0000OOo, activity, this.O00000o0, this.O00000oo, new ibh<MiServiceTokenInfo, ExceptionError>() {
            /* class com.xiaomi.youpin.login.api.manager.MiuiSystemLoginManager.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                String str;
                ExceptionError exceptionError = (ExceptionError) error;
                HashMap hashMap = new HashMap();
                if (exceptionError == null) {
                    str = null;
                } else {
                    str = exceptionError.f12083O000000o + ":" + exceptionError.O00000Oo;
                }
                hashMap.put("error", str);
                hashMap.put("mRequiredSid", MiuiSystemLoginManager.this.O00000o0);
                StringBuilder sb = new StringBuilder();
                sb.append(MiuiSystemLoginManager.this.O00000oo);
                hashMap.put("mIsNeedTimeDiff", sb.toString());
                ibq.O000000o(exceptionError.f12083O000000o, exceptionError.O00000Oo, hashMap);
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiuiSystemLoginManager.this.O000000o(activity, (MiServiceTokenInfo) obj, ibq);
            }
        });
    }

    public final void O000000o(Activity activity, final MiServiceTokenInfo miServiceTokenInfo, final ibq ibq) {
        final ArrayList arrayList = new ArrayList();
        if (this.O0000O0o) {
            arrayList.addAll(this.O00000oO);
        } else {
            arrayList.addAll(this.O00000o);
        }
        icl.O000000o(this.O0000OOo, activity, arrayList, new ibh<List<MiServiceTokenInfo>, Error>() {
            /* class com.xiaomi.youpin.login.api.manager.MiuiSystemLoginManager.AnonymousClass2 */

            public final /* synthetic */ void onSuccess(Object obj) {
                List<MiServiceTokenInfo> list = (List) obj;
                list.add(miServiceTokenInfo);
                for (MiServiceTokenInfo miServiceTokenInfo : list) {
                    miServiceTokenInfo.O00000oO = miServiceTokenInfo.O00000oO;
                }
                LoginMiAccount loginMiAccount = new LoginMiAccount();
                loginMiAccount.O000000o(ici.O00000Oo(MiuiSystemLoginManager.this.f12065O000000o), null, true, list);
                MiuiSystemLoginManager.O000000o(loginMiAccount, ibq);
            }

            public final void onFailure(Error error) {
                String str;
                HashMap hashMap = new HashMap();
                if (error == null) {
                    str = null;
                } else {
                    str = error.f12083O000000o + ":" + error.O00000Oo;
                }
                hashMap.put("error", str);
                hashMap.put("optionalSids", Arrays.toString(arrayList.toArray()));
                ibq.O000000o(error.f12083O000000o, error.O00000Oo, hashMap);
            }
        });
    }
}
