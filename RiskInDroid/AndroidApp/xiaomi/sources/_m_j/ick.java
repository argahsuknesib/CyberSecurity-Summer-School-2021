package _m_j;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.xiaomi.accountsdk.account.data.AccountInfo;
import com.xiaomi.accountsdk.account.data.PassTokenLoginParams;
import com.xiaomi.accountsdk.account.exception.IllegalDeviceException;
import com.xiaomi.accountsdk.account.exception.InvalidCredentialException;
import com.xiaomi.accountsdk.account.exception.InvalidUserNameException;
import com.xiaomi.accountsdk.account.exception.NeedNotificationException;
import com.xiaomi.accountsdk.request.AccessDeniedException;
import com.xiaomi.accountsdk.request.AuthenticationFailureException;
import com.xiaomi.accountsdk.request.InvalidResponseException;
import com.xiaomi.passport.accountmanager.MiAccountManager;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public final class ick {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Random f1182O000000o = new Random();

    public static void O000000o(String str, String str2, String str3, boolean z, ibh<Pair<AccountInfo, Long>, ExceptionError> ibh) {
        StringBuilder sb = new StringBuilder("loginMiByPasstokenSDK ");
        sb.append(str);
        sb.append(" ");
        final String str4 = str2;
        final String str5 = str3;
        final String str6 = str;
        final ibh<Pair<AccountInfo, Long>, ExceptionError> ibh2 = ibh;
        final boolean z2 = z;
        icn.O000000o(new Runnable() {
            /* class _m_j.ick.AnonymousClass1 */

            /* JADX INFO: additional move instructions added (1) to help type inference */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.xiaomi.accountsdk.request.InvalidResponseException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: com.xiaomi.accountsdk.account.exception.InvalidCredentialException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: com.xiaomi.accountsdk.request.AccessDeniedException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: com.xiaomi.accountsdk.request.AuthenticationFailureException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.xiaomi.accountsdk.account.exception.InvalidUserNameException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.xiaomi.accountsdk.account.exception.IllegalDeviceException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v12, resolved type: com.xiaomi.accountsdk.account.exception.NeedNotificationException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v15, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v22, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: java.io.IOException} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: java.io.IOException} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
            /* JADX WARNING: Removed duplicated region for block: B:31:0x00ca  */
            /* JADX WARNING: Removed duplicated region for block: B:39:0x00f1  */
            /* JADX WARNING: Removed duplicated region for block: B:41:0x00f9  */
            public final void run() {
                Exception exc;
                AccountInfo accountInfo;
                Exception exc2;
                ExceptionError exceptionError = null;
                try {
                    accountInfo = ekq.O000000o(CommonApplication.getAppContext(), new PassTokenLoginParams.Builder().userId(str4).passToken(str5).serviceId(str6).deviceId(gsa.O000000o(CommonApplication.getAppContext())).build());
                    exc = null;
                } catch (IOException e) {
                    e.printStackTrace();
                    exc2 = e;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (InvalidResponseException e2) {
                    e2.printStackTrace();
                    exc2 = e2;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (InvalidCredentialException e3) {
                    e3.printStackTrace();
                    exc2 = e3;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (AccessDeniedException e4) {
                    e4.printStackTrace();
                    exc2 = e4;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (AuthenticationFailureException e5) {
                    e5.printStackTrace();
                    exc2 = e5;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (InvalidUserNameException e6) {
                    e6.printStackTrace();
                    exc2 = e6;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (IllegalDeviceException e7) {
                    e7.printStackTrace();
                    exc2 = e7;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (NeedNotificationException e8) {
                    e8.printStackTrace();
                    exc2 = e8;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                } catch (Exception e9) {
                    e9.printStackTrace();
                    exc2 = e9;
                    exc = exc2;
                    accountInfo = null;
                    if (accountInfo != null) {
                    }
                    if (exceptionError == null) {
                    }
                }
                if (accountInfo != null) {
                    if (exc == null || !(exc instanceof IOException)) {
                        exceptionError = new ExceptionError(-1003, "accountInfo is null userId:" + str4 + " passToken:" + str5 + " sid:" + str6 + Log.getStackTraceString(exc));
                    } else {
                        exceptionError = new ExceptionError(-1007, "accountInfo is null userId:" + str4 + " passToken:" + str5 + " sid:" + str6 + Log.getStackTraceString(exc));
                    }
                } else if (TextUtils.isEmpty(accountInfo.getUserId()) || TextUtils.isEmpty(accountInfo.getSecurity()) || TextUtils.isEmpty(accountInfo.getServiceToken())) {
                    exceptionError = new ExceptionError(-1003, "accountInfo empty");
                }
                if (exceptionError == null) {
                    exceptionError.O00000o0 = exc;
                    ibh2.sendFailureMessage(exceptionError);
                    return;
                }
                long j = 0;
                if (z2) {
                    Pair<Long, Boolean> O00000Oo2 = ibm.f1156O000000o.O0000OoO.O00000Oo();
                    j = ((Long) O00000Oo2.first).longValue();
                    if (!((Boolean) O00000Oo2.second).booleanValue()) {
                        ibh2.sendFailureMessage(new ExceptionError(-1006, "获取timeDiff失败"));
                        return;
                    }
                }
                ibh2.sendSuccessMessage(new Pair(accountInfo, Long.valueOf(j)));
            }
        });
    }

    @SuppressLint({"StaticFieldLeak"})
    public static void O000000o(Context context, String str, ibh<MiServiceTokenInfo, ExceptionError> ibh) {
        gor.O000000o(new AsyncTask<Object, Object, Pair<MiServiceTokenInfo, ExceptionError>>(context, str, false, ibh) {
            /* class _m_j.ick.AnonymousClass2 */

            /* renamed from: O000000o  reason: collision with root package name */
            final /* synthetic */ Context f1184O000000o;
            final /* synthetic */ String O00000Oo;
            final /* synthetic */ ibh O00000o;
            final /* synthetic */ boolean O00000o0 = false;

            {
                this.f1184O000000o = r1;
                this.O00000Oo = r2;
                this.O00000o = r4;
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ void onPostExecute(Object obj) {
                Pair pair = (Pair) obj;
                MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) pair.first;
                ExceptionError exceptionError = (ExceptionError) pair.second;
                if (exceptionError != null) {
                    this.O00000o.onFailure(exceptionError);
                } else {
                    this.O00000o.onSuccess(miServiceTokenInfo);
                }
            }

            /* access modifiers changed from: protected */
            public final /* synthetic */ Object doInBackground(Object[] objArr) {
                MiAccountManager O00000Oo2 = MiAccountManager.O00000Oo(this.f1184O000000o);
                O00000Oo2.O00000oO();
                ServiceTokenResult serviceTokenResult = O00000Oo2.O000000o(this.f1184O000000o, this.O00000Oo).get();
                if (serviceTokenResult == null) {
                    return new Pair(null, new ExceptionError(-1, "serviceTokenResult is null"));
                }
                MiServiceTokenInfo miServiceTokenInfo = new MiServiceTokenInfo();
                if (TextUtils.isEmpty(serviceTokenResult.O00000Oo) || TextUtils.isEmpty(serviceTokenResult.O00000o0)) {
                    return new Pair(null, new ExceptionError(-1, "serviceTokenResult invalid"));
                }
                miServiceTokenInfo.O00000Oo = serviceTokenResult.O0000Oo;
                String str = this.O00000Oo;
                miServiceTokenInfo.f12086O000000o = str;
                miServiceTokenInfo.O00000oo = icr.O000000o(str);
                miServiceTokenInfo.O00000o0 = serviceTokenResult.O00000Oo;
                miServiceTokenInfo.O00000o = serviceTokenResult.O00000o0;
                if (!this.O00000o0) {
                    return new Pair(miServiceTokenInfo, null);
                }
                Pair<Long, Boolean> O00000Oo3 = ibm.f1156O000000o.O0000OoO.O00000Oo();
                miServiceTokenInfo.O00000oO = ((Long) O00000Oo3.first).longValue();
                if (((Boolean) O00000Oo3.second).booleanValue()) {
                    return new Pair(miServiceTokenInfo, null);
                }
                return new Pair(miServiceTokenInfo, new ExceptionError(-2, "get time diff fail"));
            }
        }, new Object[0]);
    }

    public static void O000000o(Context context, List<String> list, ibh<List<MiServiceTokenInfo>, ExceptionError> ibh) {
        ArrayList arrayList = new ArrayList();
        AtomicInteger atomicInteger = new AtomicInteger(0);
        for (String next : list) {
            final ArrayList arrayList2 = arrayList;
            final AtomicInteger atomicInteger2 = atomicInteger;
            final List<String> list2 = list;
            final ibh<List<MiServiceTokenInfo>, ExceptionError> ibh2 = ibh;
            final String str = next;
            O000000o(context, next, new ibh<MiServiceTokenInfo, ExceptionError>() {
                /* class _m_j.ick.AnonymousClass3 */

                public final /* synthetic */ void onFailure(Error error) {
                    ExceptionError exceptionError = (ExceptionError) error;
                    if (atomicInteger2.incrementAndGet() == list2.size()) {
                        ibh2.sendSuccessMessage(arrayList2);
                    }
                    if ("xiaomihome".equals(str) && exceptionError != null) {
                        LogType logType = LogType.LOGIN;
                        gsy.O00000o0(logType, "BaseLoginApi", "ServiceToken get failed with sid: " + str + " ; error: " + exceptionError.toString());
                    }
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    arrayList2.add((MiServiceTokenInfo) obj);
                    if (atomicInteger2.incrementAndGet() == list2.size()) {
                        ibh2.sendSuccessMessage(arrayList2);
                    }
                }
            });
        }
    }
}
