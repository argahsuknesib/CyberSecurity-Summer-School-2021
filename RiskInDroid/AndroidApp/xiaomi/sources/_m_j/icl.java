package _m_j;

import _m_j.icd;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class icl {
    public static void O000000o(boolean z, Activity activity, String str, boolean z2, ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        String concat = "loginMiBySystemAccount ".concat(String.valueOf(str));
        if (!ici.O000000o(ibm.f1156O000000o.f1154O000000o)) {
            StringBuilder sb = new StringBuilder();
            sb.append(concat);
            sb.append(" none system account");
            ibh.sendFailureMessage(new ExceptionError(-2001, "AccountManager没有系统账户信息"));
        } else if (z) {
            O000000o(ibm.f1156O000000o.f1154O000000o, activity, ici.O00000o0(ibm.f1156O000000o.f1154O000000o), str, O000000o(str, z2, ibh));
        } else {
            O000000o(ibm.f1156O000000o.f1154O000000o, str, O000000o(str, z2, ibh));
        }
    }

    private static ibh<iby, ExceptionError> O000000o(final String str, final boolean z, final ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        return new ibh<iby, ExceptionError>() {
            /* class _m_j.icl.AnonymousClass1 */

            public final /* synthetic */ void onFailure(Error error) {
                ExceptionError exceptionError = (ExceptionError) error;
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" Get serviceToken fail ");
                sb.append(exceptionError);
                ibh ibh = ibh;
                if (ibh != null) {
                    ibh.onFailure(exceptionError);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                iby iby = (iby) obj;
                final MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo(str, iby.O00000oO, iby.O00000o0, iby.O00000o, icr.O000000o(str), 0);
                if (z) {
                    gor.O000000o(new icd.O000000o(new ibh<Long, Error>() {
                        /* class _m_j.icl.AnonymousClass1.AnonymousClass1 */

                        public final /* synthetic */ void onSuccess(Object obj) {
                            miServiceTokenInfo.O00000oO = ((Long) obj).longValue();
                            if (ibh != null) {
                                ibh.sendSuccessMessage(miServiceTokenInfo);
                            }
                        }

                        public final void onFailure(Error error) {
                            if (ibh != null) {
                                ibh.sendFailureMessage(new ExceptionError(-1006, "获取timeDiff失败"));
                            }
                        }
                    }), new Object[0]);
                } else {
                    ibh ibh = ibh;
                    if (ibh != null) {
                        ibh.sendSuccessMessage(miServiceTokenInfo);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append(" Get serviceToken onSuccess ");
                sb.append(iby);
            }
        };
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.icl.O000000o(boolean, android.app.Activity, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
     arg types: [boolean, android.app.Activity, java.lang.String, int, _m_j.icl$2]
     candidates:
      _m_j.icl.O000000o(android.content.Context, android.app.Activity, android.accounts.Account, java.lang.String, _m_j.ibh<_m_j.iby, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
      _m_j.icl.O000000o(boolean, android.app.Activity, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
    public static void O000000o(boolean z, Activity activity, List<String> list, ibh<List<MiServiceTokenInfo>, Error> ibh) {
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (String next : list) {
            final AtomicInteger atomicInteger2 = atomicInteger;
            final ArrayList arrayList2 = arrayList;
            final int i = size;
            final ibh<List<MiServiceTokenInfo>, Error> ibh2 = ibh;
            final String str = next;
            O000000o(z, activity, next, false, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
                /* class _m_j.icl.AnonymousClass2 */

                public final /* synthetic */ void onFailure(Error error) {
                    ibh ibh;
                    ExceptionError exceptionError = (ExceptionError) error;
                    if ("xiaomihome".equals(str) && exceptionError != null) {
                        LogType logType = LogType.LOGIN;
                        gsy.O00000o0(logType, "MiuiSystemLoginApi", "ServiceToken get failed with sid: " + str + " ; error: " + exceptionError.toString());
                    }
                    atomicInteger2.incrementAndGet();
                    if (atomicInteger2.get() == i && (ibh = ibh2) != null) {
                        ibh.sendSuccessMessage(arrayList2);
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    ibh ibh;
                    atomicInteger2.incrementAndGet();
                    arrayList2.add((MiServiceTokenInfo) obj);
                    if (atomicInteger2.get() == i && (ibh = ibh2) != null) {
                        ibh.sendSuccessMessage(arrayList2);
                    }
                }
            });
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    private static void O000000o(final Context context, final String str, final ibh<iby, ExceptionError> ibh) {
        gor.O000000o(new AsyncTask<Void, Void, ServiceTokenResult>() {
            /* class _m_j.icl.AnonymousClass3 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                ServiceTokenResult serviceTokenResult = (ServiceTokenResult) obj;
                String O000000o2 = icr.O000000o(str);
                if (serviceTokenResult == null) {
                    ibh.onFailure(new ExceptionError(-2002, "serviceTokenResult is null"));
                } else if (TextUtils.isEmpty(serviceTokenResult.O00000Oo) || TextUtils.isEmpty(serviceTokenResult.O00000o0) || TextUtils.isEmpty(serviceTokenResult.O0000Oo)) {
                    ServiceTokenResult.ErrorCode errorCode = serviceTokenResult.O00000o;
                    String str = serviceTokenResult.O00000oO;
                    if (errorCode == null) {
                        ibh.onFailure(new ExceptionError(-2002, "no error code"));
                        return;
                    }
                    switch (AnonymousClass5.f1191O000000o[errorCode.ordinal()]) {
                        case 1:
                            ibh.onFailure(new ExceptionError(-2004, str));
                            return;
                        case 2:
                            ibh.onFailure(new ExceptionError(-2005, str));
                            return;
                        case 3:
                            ibh.onFailure(new ExceptionError(-2006, str));
                            return;
                        case 4:
                            ibh.onFailure(new ExceptionError(-2007, str));
                            return;
                        case 5:
                            ibh.onFailure(new ExceptionError(-2008, str));
                            return;
                        case 6:
                            ibh.onFailure(new ExceptionError(-2009, str));
                            return;
                        case 7:
                            ibh.onFailure(new ExceptionError(-2010, str));
                            return;
                        case C.MSG_SET_VIDEO_DECODER_OUTPUT_BUFFER_RENDERER /*8*/:
                            ibh.onFailure(new ExceptionError(-2011, str));
                            return;
                        case 9:
                            ibh.onFailure(new ExceptionError(-2012, str));
                            return;
                        case 10:
                            ibh.onFailure(new ExceptionError(-2013, str));
                            return;
                        default:
                            ibh.onFailure(new ExceptionError(-2003, str));
                            return;
                    }
                } else {
                    iby iby = new iby();
                    iby.O00000o0 = serviceTokenResult.O00000Oo;
                    iby.O00000o = serviceTokenResult.O00000o0;
                    iby.O00000oO = serviceTokenResult.O0000Oo;
                    iby.f1168O000000o = str;
                    iby.O00000Oo = O000000o2;
                    ibh.onSuccess(iby);
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                MiAccountManager.O00000Oo(context).O00000o();
                ServiceTokenFuture O000000o2 = MiAccountManager.O00000Oo(context).O000000o(context, str);
                if (O000000o2 == null) {
                    return null;
                }
                return O000000o2.get();
            }
        }, new Void[0]);
    }

    /* renamed from: _m_j.icl$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f1191O000000o = new int[ServiceTokenResult.ErrorCode.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|(3:19|20|22)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(22:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|22) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0040 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0062 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0035 */
        static {
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_NONE.ordinal()] = 1;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_NO_ACCOUNT.ordinal()] = 2;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_APP_PERMISSION_FORBIDDEN.ordinal()] = 3;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_IOERROR.ordinal()] = 4;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_OLD_MIUI_ACCOUNT_MANAGER_PERMISSION_ISSUE.ordinal()] = 5;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_CANCELLED.ordinal()] = 6;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_AUTHENTICATOR_ERROR.ordinal()] = 7;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_TIME_OUT.ordinal()] = 8;
            f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_REMOTE_EXCEPTION.ordinal()] = 9;
            try {
                f1191O000000o[ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED.ordinal()] = 10;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @SuppressLint({"StaticFieldLeak"})
    private static void O000000o(Context context, Activity activity, Account account, String str, ibh<iby, ExceptionError> ibh) {
        final String str2 = str;
        final Activity activity2 = activity;
        final Context context2 = context;
        final Account account2 = account;
        final ibh<iby, ExceptionError> ibh2 = ibh;
        gor.O000000o(new AsyncTask<Object, Object, Pair<iby, ExceptionError>>() {
            /* class _m_j.icl.AnonymousClass4 */

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                return O000000o();
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                ExceptionError exceptionError = (ExceptionError) pair.second;
                if (exceptionError != null) {
                    ibh2.sendFailureMessage(exceptionError);
                    return;
                }
                ibh2.sendSuccessMessage((iby) pair.first);
            }

            /* JADX WARNING: Removed duplicated region for block: B:21:0x00ca  */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x00d0  */
            private Pair<iby, ExceptionError> O000000o() {
                ExceptionError exceptionError;
                Bundle bundle;
                AccountManagerFuture<Bundle> accountManagerFuture;
                String O000000o2 = icr.O000000o(str2);
                iby iby = new iby();
                try {
                    if (activity2 == null) {
                        accountManagerFuture = AccountManager.get(context2).getAuthToken(account2, str2, true, null, null);
                    } else {
                        accountManagerFuture = AccountManager.get(context2).getAuthToken(account2, str2, (Bundle) null, activity2, (AccountManagerCallback<Bundle>) null, (Handler) null);
                    }
                    if (accountManagerFuture == null) {
                        return new Pair<>(iby, new ExceptionError(-1, "AuthTokenResult is null"));
                    }
                    bundle = (Bundle) accountManagerFuture.getResult();
                    exceptionError = null;
                    if (exceptionError != null) {
                        return new Pair<>(iby, exceptionError);
                    }
                    String string = bundle.getString("authtoken");
                    String string2 = bundle.getString("encrypted_user_id");
                    if (!TextUtils.isEmpty(string)) {
                        String[] split = string.split(",");
                        if (split.length >= 2) {
                            iby.O00000o0 = split[0];
                            iby.O00000o = split[1];
                        }
                    }
                    if (TextUtils.isEmpty(iby.O00000o0) || TextUtils.isEmpty(iby.O00000o)) {
                        return new Pair<>(iby, new ExceptionError(-1, "serviceToken or ssecurity empty"));
                    }
                    if (TextUtils.isEmpty(string2)) {
                        try {
                            string2 = AccountManager.get(context2).getUserData(account2, "encrypted_user_id");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    iby.f1168O000000o = str2;
                    iby.O00000Oo = O000000o2;
                    iby.O00000oO = string2;
                    return new Pair<>(iby, null);
                } catch (OperationCanceledException e2) {
                    e2.printStackTrace();
                    exceptionError = new ExceptionError(-1, "OperationCanceledException " + e2.getMessage());
                    exceptionError.O00000o0 = e2;
                    bundle = null;
                    if (exceptionError != null) {
                    }
                } catch (IOException e3) {
                    e3.printStackTrace();
                    exceptionError = new ExceptionError(-1007, "IOException " + e3.getMessage());
                    exceptionError.O00000o0 = e3;
                    bundle = null;
                    if (exceptionError != null) {
                    }
                } catch (AuthenticatorException e4) {
                    e4.printStackTrace();
                    exceptionError = new ExceptionError(-1, "AuthenticatorException " + e4.getMessage());
                    exceptionError.O00000o0 = e4;
                    bundle = null;
                    if (exceptionError != null) {
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                    exceptionError = new ExceptionError(-1, "UnKnownException " + e5.getMessage());
                    exceptionError.O00000o0 = e5;
                    bundle = null;
                    if (exceptionError != null) {
                    }
                }
            }
        }, new Object[0]);
    }
}
