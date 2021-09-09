package _m_j;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.accountsdk.futureservice.ClientFuture;
import com.xiaomi.accountsdk.futureservice.ServerServiceConnector;
import com.xiaomi.accountsdk.futureservice.SimpleClientFuture;
import com.xiaomi.accountsdk.utils.AccountLog;
import com.xiaomi.accountsdk.utils.MiuiOsBuildReflection;
import com.xiaomi.accountsdk.utils.MiuiVersionDev;
import com.xiaomi.accountsdk.utils.MiuiVersionStable;
import com.xiaomi.passport.IPassportServiceTokenService;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenUIErrorHandler$1;
import com.xiaomi.passport.servicetoken.ServiceTokenUIResponse;
import com.xiaomi.passport.servicetoken.data.XmAccountVisibility;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicBoolean;

final class efj extends efi {
    private static volatile AtomicBoolean O00000Oo = new AtomicBoolean(true);
    private static volatile Boolean O00000o0 = null;

    efj() {
    }

    public final ServiceTokenResult O00000o0(Context context, String str) {
        if (str != null && str.startsWith("weblogin:") && O000000o.O00000Oo()) {
            return O000000o().O000000o(context, str);
        }
        if (O00000Oo.get()) {
            ServiceTokenFuture serviceTokenFuture = new ServiceTokenFuture(null);
            final String str2 = str;
            final Context context2 = context;
            new O00000Oo(context, serviceTokenFuture) {
                /* class _m_j.efj.AnonymousClass1 */

                public final /* synthetic */ Object callServiceWork() throws RemoteException {
                    ServiceTokenResult serviceToken = ((IPassportServiceTokenService) getIService()).getServiceToken(str2);
                    Context context = context2;
                    if (!(context instanceof Activity)) {
                        return serviceToken;
                    }
                    Activity activity = (Activity) context;
                    if (activity.isFinishing() || serviceToken == null || serviceToken.O00000o != ServiceTokenResult.ErrorCode.ERROR_USER_INTERACTION_NEEDED || serviceToken.O0000O0o == null || !new efj().O00000o(activity)) {
                        return serviceToken;
                    }
                    ServiceTokenFuture serviceTokenFuture = new ServiceTokenFuture(null);
                    serviceToken.O0000O0o.putExtra("accountAuthenticatorResponse", new ServiceTokenUIResponse(new ServiceTokenUIErrorHandler$1(serviceToken, serviceTokenFuture)));
                    activity.startActivity(serviceToken.O0000O0o);
                    return serviceTokenFuture.get();
                }
            }.bind();
            if (O000000o(serviceTokenFuture)) {
                return serviceTokenFuture.get();
            }
            O00000Oo.set(false);
        }
        return O000000o().O000000o(context, str);
    }

    public final ServiceTokenResult O00000Oo(Context context, final ServiceTokenResult serviceTokenResult) {
        if (O00000Oo.get()) {
            ServiceTokenFuture serviceTokenFuture = new ServiceTokenFuture(null);
            new O00000Oo(context, serviceTokenFuture) {
                /* class _m_j.efj.AnonymousClass2 */

                public final /* synthetic */ Object callServiceWork() throws RemoteException {
                    ServiceTokenResult serviceTokenResult;
                    if (serviceTokenResult == null || !O000000o.O000000o()) {
                        serviceTokenResult = serviceTokenResult;
                    } else {
                        ServiceTokenResult serviceTokenResult2 = serviceTokenResult;
                        ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(serviceTokenResult2.f6200O000000o);
                        o000000o.O00000Oo = serviceTokenResult2.O00000Oo;
                        o000000o.O00000o0 = serviceTokenResult2.O00000o0;
                        o000000o.O00000oo = serviceTokenResult2.O00000o;
                        o000000o.O00000o = serviceTokenResult2.O00000oO;
                        o000000o.O00000oO = serviceTokenResult2.O00000oo;
                        o000000o.O0000O0o = serviceTokenResult2.O0000O0o;
                        o000000o.O0000OOo = serviceTokenResult2.O0000OOo;
                        o000000o.O0000Oo0 = serviceTokenResult2.O0000Oo0;
                        o000000o.O0000Oo = serviceTokenResult2.O0000Oo;
                        o000000o.O0000OoO = serviceTokenResult2.O0000OoO;
                        o000000o.O0000Ooo = serviceTokenResult2.O0000Ooo;
                        o000000o.O0000o00 = serviceTokenResult2.O0000o00;
                        o000000o.O0000Ooo = true;
                        serviceTokenResult = o000000o.O000000o();
                    }
                    return ((IPassportServiceTokenService) getIService()).invalidateServiceToken(serviceTokenResult);
                }
            }.bind();
            if (O000000o(serviceTokenFuture)) {
                return serviceTokenFuture.get();
            }
            O00000Oo.set(false);
        }
        return O000000o().O00000Oo(context, serviceTokenResult);
    }

    public final boolean O00000o(Context context) {
        if (!O00000Oo.get()) {
            return false;
        }
        SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
        new O00000o0<Boolean>(context, simpleClientFuture) {
            /* class _m_j.efj.AnonymousClass3 */

            public final /* synthetic */ Object callServiceWork() throws RemoteException {
                return Boolean.valueOf(((IPassportServiceTokenService) getIService()).supportServiceTokenUIResponse());
            }
        }.bind();
        try {
            return ((Boolean) simpleClientFuture.get()).booleanValue();
        } catch (InterruptedException e) {
            AccountLog.w("ServiceTokenUtilMiui", "", e);
            return false;
        } catch (ExecutionException e2) {
            AccountLog.w("ServiceTokenUtilMiui", "", e2);
            return false;
        }
    }

    public final boolean O00000Oo(Context context) {
        if (!O00000Oo.get()) {
            return false;
        }
        synchronized (efj.class) {
            if (O00000o0 != null) {
                boolean booleanValue = O00000o0.booleanValue();
                return booleanValue;
            }
            SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
            new O00000o0<Boolean>(context, simpleClientFuture) {
                /* class _m_j.efj.AnonymousClass4 */

                public final /* synthetic */ Object callServiceWork() throws RemoteException {
                    return Boolean.valueOf(((IPassportServiceTokenService) getIService()).fastCheckSlhPhCompatibility());
                }
            }.bind();
            try {
                Boolean bool = (Boolean) simpleClientFuture.get();
                synchronized (efj.class) {
                    O00000o0 = bool;
                }
                return bool.booleanValue();
            } catch (InterruptedException e) {
                AccountLog.w("ServiceTokenUtilMiui", "", e);
                return false;
            } catch (ExecutionException e2) {
                AccountLog.w("ServiceTokenUtilMiui", "", e2);
                return false;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final XmAccountVisibility O000000o(final Context context) {
        Account O000000o2 = new efc(new efb()).O000000o(context);
        if (O000000o2 != null) {
            return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_NONE, null).O000000o(O000000o2).O000000o();
        }
        SimpleClientFuture simpleClientFuture = new SimpleClientFuture();
        new O00000o0<XmAccountVisibility>(simpleClientFuture, context) {
            /* class _m_j.efj.AnonymousClass5 */

            public final /* synthetic */ Object callServiceWork() throws RemoteException {
                if (((IPassportServiceTokenService) getIService()).supportAccessAccount()) {
                    return ((IPassportServiceTokenService) getIService()).setAccountVisible(context.getPackageName());
                }
                if (Build.VERSION.SDK_INT < 26) {
                    return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_PRE_ANDROID_O, null).O000000o();
                }
                Intent newChooseAccountIntent = AccountManager.newChooseAccountIntent(null, null, new String[]{"com.xiaomi"}, null, null, null, null);
                XmAccountVisibility.O000000o o000000o = new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_NOT_SUPPORT, null);
                o000000o.O00000oo = newChooseAccountIntent;
                return o000000o.O000000o();
            }
        }.bind();
        try {
            return (XmAccountVisibility) simpleClientFuture.get();
        } catch (InterruptedException e) {
            AccountLog.e("ServiceTokenUtilMiui", "setSystemAccountVisible", e);
            return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_CANCELLED, null).O000000o();
        } catch (ExecutionException e2) {
            AccountLog.e("ServiceTokenUtilMiui", "setSystemAccountVisible", e2);
            return new XmAccountVisibility.O000000o(XmAccountVisibility.ErrorCode.ERROR_EXECUTION, e2.getMessage()).O000000o();
        }
    }

    private static efg O000000o() {
        return new efg(new efc(new efb()));
    }

    private static boolean O000000o(ServiceTokenFuture serviceTokenFuture) {
        return !serviceTokenFuture.isDone() || serviceTokenFuture.get().O00000o != ServiceTokenResult.ErrorCode.ERROR_REMOTE_EXCEPTION;
    }

    static abstract class O00000Oo extends O00000o0<ServiceTokenResult> {
        protected O00000Oo(Context context, ServiceTokenFuture serviceTokenFuture) {
            super(context, serviceTokenFuture);
        }
    }

    static abstract class O00000o0<T> extends ServerServiceConnector<IPassportServiceTokenService, T, T> {
        protected O00000o0(Context context, ClientFuture<T, T> clientFuture) {
            super(context, "com.xiaomi.account.action.SERVICE_TOKEN_OP", "com.xiaomi.account", clientFuture);
        }

        public /* synthetic */ Object binderToServiceType(IBinder iBinder) {
            return IPassportServiceTokenService.Stub.asInterface(iBinder);
        }
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        private static volatile Boolean f15220O000000o;
        private static volatile Boolean O00000Oo;

        static boolean O000000o() {
            if (f15220O000000o != null) {
                return f15220O000000o.booleanValue();
            }
            boolean z = true;
            if ((!MiuiOsBuildReflection.isStable(false) || !MiuiVersionStable.earlyThan(new MiuiVersionStable(8, 0), false)) && (!MiuiOsBuildReflection.isDevButNotAlpha(false) || !MiuiVersionDev.earlyThan(new MiuiVersionDev(6, 7, 1), false))) {
                z = false;
            }
            if (f15220O000000o == null) {
                f15220O000000o = Boolean.valueOf(z);
            }
            return f15220O000000o.booleanValue();
        }

        static boolean O00000Oo() {
            if (O00000Oo != null) {
                return O00000Oo.booleanValue();
            }
            boolean z = true;
            if ((!MiuiOsBuildReflection.isStable(false) || !MiuiVersionStable.earlyThan(new MiuiVersionStable(8, 2), false)) && (!MiuiOsBuildReflection.isDevButNotAlpha(false) || !MiuiVersionDev.earlyThan(new MiuiVersionDev(6, 11, 25), false))) {
                z = false;
            }
            if (O00000Oo == null) {
                O00000Oo = Boolean.valueOf(z);
            }
            return O00000Oo.booleanValue();
        }
    }
}
