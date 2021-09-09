package _m_j;

import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;

public final class ibm {

    /* renamed from: O000000o  reason: collision with root package name */
    public static ibl f1156O000000o;

    public static void O000000o(final String str, final String str2, String str3, boolean z, final ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        ick.O000000o(str, str2, str3, z, new ibh<Pair<AccountInfo, Long>, ExceptionError>() {
            /* class _m_j.ibm.AnonymousClass3 */

            public final /* synthetic */ void onFailure(Error error) {
                ExceptionError exceptionError = (ExceptionError) error;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.sendFailureMessage(exceptionError);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                final Pair pair = (Pair) obj;
                goq.O000000o(new Runnable() {
                    /* class _m_j.ibm.AnonymousClass3.AnonymousClass1 */

                    public final void run() {
                        AccountInfo accountInfo = (AccountInfo) pair.first;
                        try {
                            MiAccountManager.O00000Oo(ibm.f1156O000000o.f1154O000000o).O00000oO();
                            eks.O00000Oo(ibm.f1156O000000o.f1154O000000o, accountInfo);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        if (ibh == null) {
                            return;
                        }
                        if (accountInfo == null || !TextUtils.equals(accountInfo.userId, str2)) {
                            ibh ibh = ibh;
                            ibh.sendFailureMessage(new ExceptionError(-1, "user id change currentUid " + str2 + " newAccount " + accountInfo));
                            return;
                        }
                        MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo();
                        miServiceTokenInfo.f12086O000000o = str;
                        miServiceTokenInfo.O00000Oo = accountInfo.getEncryptedUserId();
                        miServiceTokenInfo.O00000o0 = accountInfo.getServiceToken();
                        miServiceTokenInfo.O00000o = accountInfo.getSecurity();
                        miServiceTokenInfo.O00000oo = icr.O000000o(str);
                        miServiceTokenInfo.O00000oO = ((Long) pair.second).longValue();
                        ibh.sendSuccessMessage(miServiceTokenInfo);
                    }
                });
            }
        });
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.icl.O000000o(boolean, android.app.Activity, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [boolean, ?[OBJECT, ARRAY], java.lang.String, int, _m_j.ibm$1]
     candidates:
      _m_j.icl.O000000o(android.content.Context, android.app.Activity, android.accounts.Account, java.lang.String, _m_j.ibh<_m_j.iby, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.icl.O000000o(boolean, android.app.Activity, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    public static void O000000o(String str, MiServiceTokenInfo miServiceTokenInfo, final ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        boolean z = f1156O000000o.O00000o0;
        if (miServiceTokenInfo != null) {
            String str2 = miServiceTokenInfo.O00000o0 + "," + miServiceTokenInfo.O00000o;
            Context context = f1156O000000o.f1154O000000o;
            if (z) {
                AccountManager.get(context).invalidateAuthToken("com.xiaomi", str2);
            } else {
                MiAccountManager.O00000Oo(context).O000000o("com.xiaomi", str2);
            }
        }
        icl.O000000o(f1156O000000o.O00000o0, (Activity) null, str, false, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
            /* class _m_j.ibm.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                ExceptionError exceptionError = (ExceptionError) error;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.sendFailureMessage(exceptionError);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.sendSuccessMessage(miServiceTokenInfo);
                }
            }
        });
    }

    public static void O000000o(String str, final String str2, MiServiceTokenInfo miServiceTokenInfo, boolean z, final ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        boolean z2 = f1156O000000o.O00000o0;
        final Context context = f1156O000000o.f1154O000000o;
        if (miServiceTokenInfo != null) {
            String str3 = miServiceTokenInfo.O00000o0 + "," + miServiceTokenInfo.O00000o;
            if (z2) {
                AccountManager.get(context).invalidateAuthToken("com.xiaomi", str3);
            } else {
                MiAccountManager.O00000Oo(context).O000000o("com.xiaomi", str3);
            }
        }
        icl.O000000o(f1156O000000o.O00000o0, (Activity) null, str, z, new ibh<MiServiceTokenInfo, ExceptionError>() {
            /* class _m_j.ibm.AnonymousClass2 */

            public final /* synthetic */ void onFailure(Error error) {
                ExceptionError exceptionError = (ExceptionError) error;
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.sendFailureMessage(exceptionError);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                if (ibh != null) {
                    String O00000Oo2 = ici.O00000Oo(context);
                    if (TextUtils.equals(O00000Oo2, str2)) {
                        ibh.sendSuccessMessage(miServiceTokenInfo);
                        return;
                    }
                    ibh ibh = ibh;
                    ibh.sendFailureMessage(new ExceptionError(-1, "user id change currentUid " + str2 + " systemUid" + O00000Oo2));
                }
            }
        });
    }
}
