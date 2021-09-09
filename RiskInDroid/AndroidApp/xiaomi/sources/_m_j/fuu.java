package _m_j;

import android.content.Intent;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.bugly.crashreport.CrashReport;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.account.RefreshServiceTokenResult;
import com.xiaomi.smarthome.core.server.IServerCallback;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.DeviceRouterFactory;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.PluginApi;
import com.xiaomi.smarthome.framework.page.ActivityStack;
import com.xiaomi.smarthome.framework.redpoint.ServerTimerManager;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.Error;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import com.xiaomi.youpin.login.entity.error.ExceptionError;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

public final class fuu extends ftb {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f17208O000000o = new Object();
    private static volatile fuu O00000Oo;

    interface O000000o {
        void O000000o();
    }

    private fuu() {
    }

    public static fuu O0000OOo() {
        if (O00000Oo == null) {
            synchronized (f17208O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fuu();
                }
            }
        }
        return O00000Oo;
    }

    public final void O000000o() throws RemoteException {
        if (gfr.O0000Ooo) {
            gsy.O00000Oo(LogType.LOGIN, "login", "CoreHostApiImpl onAccountReady, will send ACTION_ON_ACCOUNT_READY");
        }
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onAccountReady"));
    }

    public final void O00000Oo() throws RemoteException {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onGlobalDynamicSettingReady"));
    }

    public final void O00000o0() throws RemoteException {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onStatisticReady"));
    }

    public final void O00000o() throws RemoteException {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onPluginReady"));
    }

    public final void O00000oO() throws RemoteException {
        ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onCoreReady"));
    }

    public final void O000000o(String str, String str2, boolean z, String str3, IServerCallback iServerCallback) throws RemoteException {
        final boolean z2 = z;
        final String str4 = str;
        final IServerCallback iServerCallback2 = iServerCallback;
        final String str5 = str2;
        final String str6 = str3;
        O000000o(new O000000o() {
            /* class _m_j.fuu.AnonymousClass1 */

            public final void O000000o() {
                CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                    /* class _m_j.fuu.AnonymousClass1.AnonymousClass1 */

                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
                     arg types: [java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, int, _m_j.fuu$1$1$1]
                     candidates:
                      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
                      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
                    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                     method: _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
                     arg types: [java.lang.String, java.lang.String, java.lang.String, int, _m_j.fuu$1$1$2]
                     candidates:
                      _m_j.ibm.O000000o(java.lang.String, java.lang.String, com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void
                      _m_j.ibm.O000000o(java.lang.String, java.lang.String, java.lang.String, boolean, _m_j.ibh<com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo, com.xiaomi.youpin.login.entity.error.ExceptionError>):void */
                    public final void run() {
                        if (z2) {
                            MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o(str4);
                            if (O000000o2 == null) {
                                gsy.O000000o(6, "CoreHostApiImpl", "miServiceTokenInfo is null, sid " + str4);
                                if (iServerCallback2 != null) {
                                    try {
                                        iServerCallback2.onFailure(new Bundle());
                                    } catch (RemoteException e) {
                                        e.printStackTrace();
                                    }
                                }
                            } else {
                                ibm.O000000o(str4, str5, O000000o2, true, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
                                    /* class _m_j.fuu.AnonymousClass1.AnonymousClass1.AnonymousClass1 */

                                    public final /* synthetic */ void onFailure(Error error) {
                                        ExceptionError exceptionError = (ExceptionError) error;
                                        fuu.O000000o(str4, z2, exceptionError);
                                        if (iServerCallback2 != null) {
                                            try {
                                                Bundle bundle = new Bundle();
                                                bundle.putParcelable("error", new com.xiaomi.smarthome.core.entity.Error(exceptionError.f12083O000000o, exceptionError.O00000Oo));
                                                iServerCallback2.onFailure(bundle);
                                            } catch (RemoteException unused) {
                                            }
                                        }
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                                        if (iServerCallback2 != null) {
                                            Bundle bundle = new Bundle();
                                            RefreshServiceTokenResult refreshServiceTokenResult = new RefreshServiceTokenResult();
                                            refreshServiceTokenResult.f6720O000000o = str5;
                                            refreshServiceTokenResult.O00000Oo = miServiceTokenInfo.O00000Oo;
                                            refreshServiceTokenResult.O00000o = miServiceTokenInfo.O00000o0;
                                            refreshServiceTokenResult.O00000oO = miServiceTokenInfo.O00000o;
                                            refreshServiceTokenResult.O00000oo = miServiceTokenInfo.O00000oO;
                                            bundle.putParcelable("result", refreshServiceTokenResult);
                                            try {
                                                iServerCallback2.onSuccess(bundle);
                                            } catch (RemoteException unused) {
                                            }
                                        }
                                    }
                                });
                            }
                        } else {
                            ibm.O000000o(str4, str5, str6, true, (ibh<MiServiceTokenInfo, ExceptionError>) new ibh<MiServiceTokenInfo, ExceptionError>() {
                                /* class _m_j.fuu.AnonymousClass1.AnonymousClass1.AnonymousClass2 */

                                public final /* synthetic */ void onFailure(Error error) {
                                    ExceptionError exceptionError = (ExceptionError) error;
                                    fuu.O000000o(str4, z2, exceptionError);
                                    if (iServerCallback2 != null) {
                                        try {
                                            Bundle bundle = new Bundle();
                                            bundle.putParcelable("error", new com.xiaomi.smarthome.core.entity.Error(exceptionError.f12083O000000o, exceptionError.O00000Oo));
                                            iServerCallback2.onFailure(bundle);
                                        } catch (RemoteException unused) {
                                        }
                                    }
                                }

                                public final /* synthetic */ void onSuccess(Object obj) {
                                    MiServiceTokenInfo miServiceTokenInfo = (MiServiceTokenInfo) obj;
                                    if (iServerCallback2 != null) {
                                        Bundle bundle = new Bundle();
                                        RefreshServiceTokenResult refreshServiceTokenResult = new RefreshServiceTokenResult();
                                        refreshServiceTokenResult.f6720O000000o = str5;
                                        refreshServiceTokenResult.O00000o0 = str6;
                                        refreshServiceTokenResult.O00000Oo = miServiceTokenInfo.O00000Oo;
                                        refreshServiceTokenResult.O00000o = miServiceTokenInfo.O00000o0;
                                        refreshServiceTokenResult.O00000oO = miServiceTokenInfo.O00000o;
                                        refreshServiceTokenResult.O00000oo = miServiceTokenInfo.O00000oO;
                                        bundle.putParcelable("result", refreshServiceTokenResult);
                                        try {
                                            iServerCallback2.onSuccess(bundle);
                                        } catch (RemoteException unused) {
                                        }
                                    }
                                }
                            });
                        }
                    }
                });
            }
        });
    }

    public static void O000000o(String str, boolean z, ExceptionError exceptionError) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = str;
        MiServiceTokenInfo O000000o2 = CoreApi.O000000o().O000000o(str8);
        StringBuilder sb = new StringBuilder();
        sb.append(CoreApi.O000000o().O0000Ooo());
        String sb2 = sb.toString();
        CoreApi.O000000o().O0000o0();
        String O0000o = CoreApi.O000000o().O0000o();
        CoreApi.O000000o().O0000oO();
        StringBuilder sb3 = new StringBuilder();
        sb3.append(CoreApi.O000000o().O0000oO0());
        String sb4 = sb3.toString();
        String O000000o3 = fln.O000000o(CommonApplication.getAppContext());
        StringBuilder sb5 = new StringBuilder();
        sb5.append(ServerTimerManager.O000000o(CommonApplication.getAppContext()).O00000Oo());
        String sb6 = sb5.toString();
        gsy.O00000o0(LogType.NETWORK, "", "-----------------mijia 401 refresh----------------- ");
        gsy.O00000o0(LogType.NETWORK, "sid", str8);
        gsy.O00000o0(LogType.NETWORK, "isLogin", sb2);
        gsy.O00000o0(LogType.NETWORK, "cUserId", O0000o);
        gsy.O00000o0(LogType.NETWORK, "ua", O000000o3);
        gsy.O00000o0(LogType.NETWORK, "timediff", sb6);
        LogType logType = LogType.NETWORK;
        if (O000000o2 == null) {
            str3 = "serviceToken is null ";
            str2 = str3;
        } else {
            str3 = O000000o2.toString();
            str2 = "serviceToken is null ";
        }
        gsy.O00000o0(logType, "serviceToken", str3);
        gsy.O00000o0(LogType.NETWORK, "isSystemAccount", sb4);
        String str9 = "serviceToken";
        MiServiceTokenInfo miServiceTokenInfo = O000000o2;
        gsy.O00000o0(LogType.NETWORK, "log_isSystemAccount", String.valueOf(z));
        LogType logType2 = LogType.NETWORK;
        String str10 = "error is null";
        if (exceptionError == null) {
            str5 = "log_isSystemAccount";
            str4 = str10;
        } else {
            str4 = str10;
            str10 = exceptionError.toString();
            str5 = "log_isSystemAccount";
        }
        gsy.O00000o0(logType2, "error", str10);
        gsy.O00000o0(LogType.NETWORK, "", "-----------------mijia 401 end-----------------");
        String str11 = "";
        dgn.O000000o("mijia", "-----------------mijia 401 start-----------------");
        dgn.O000000o("sid", str8);
        dgn.O000000o("isLogin", sb2);
        dgn.O000000o("ua", O000000o3);
        dgn.O000000o("cUserId", O0000o);
        dgn.O000000o("timediff", sb6);
        dgn.O000000o("isSystemAccount", sb4);
        dgn.O000000o(str5, String.valueOf(z));
        if (exceptionError == null) {
            str6 = str4;
        } else {
            str6 = exceptionError.toString();
        }
        dgn.O000000o("error", str6);
        if (miServiceTokenInfo == null) {
            str7 = str2;
        } else {
            str7 = miServiceTokenInfo.toString();
        }
        dgn.O000000o(str9, str7);
        LoginMiAccount O0000oOo = CoreApi.O000000o().O0000oOo();
        if (O0000oOo != null) {
            for (MiServiceTokenInfo next : O0000oOo.O00000o()) {
                dgn.O000000o(next.f12086O000000o != null ? next.f12086O000000o : str11, next.O00000o0 != null ? next.O00000o0 : str11);
                dgn.O000000o(next.f12086O000000o != null ? next.f12086O000000o : str11, next.O00000oo != null ? next.O00000oo : str11);
            }
        }
        dgn.O000000o("mijia", "-----------------mijia 401 end-----------------");
        CrashReport.O000000o(new Throwable("smarthome 401&refresh fail"));
    }

    public final void O00000oo() throws RemoteException {
        LogType logType = LogType.LOGIN;
        gsy.O00000o0(logType, "CoreHostApiImpl", "onUnAuthorized stack:" + Log.getStackTraceString(new Exception()));
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            O000000o(new O000000o() {
                /* class _m_j.fuu.AnonymousClass2 */

                public final void O000000o() {
                    CommonApplication.getGlobalHandler().post(new Runnable() {
                        /* class _m_j.fuu.AnonymousClass2.AnonymousClass1 */

                        public final void run() {
                            ezo.O000000o().clearRegedPushIDAndDeviceID();
                            try {
                                CoreApi.O000000o().O00000Oo().clearPluginConfig(null);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("action_on_logout"));
                            ServiceApplication.getStateNotifier().O0000O0o();
                            HashSet<fut> hashSet = new HashSet<>();
                            Iterator<fut> it = ActivityStack.instance.getActivityListeners().iterator();
                            while (it.hasNext()) {
                                fut next = it.next();
                                try {
                                    next.onUnauthorized();
                                } catch (Exception unused) {
                                    hashSet.add(next);
                                }
                            }
                            for (fut unregisterActivityListener : hashSet) {
                                ActivityStack.instance.unregisterActivityListener(unregisterActivityListener);
                            }
                            CommonApplication.getAppContext().sendBroadcast(new Intent("ClientApiStub.onUnAuthorized"));
                        }
                    });
                }
            });
        }
    }

    public final void O0000O0o() throws RemoteException {
        CoreApi.O000000o().O0000ooo();
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            O000000o(new O000000o() {
                /* class _m_j.fuu.AnonymousClass3 */

                public final void O000000o() {
                    CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                        /* class _m_j.fuu.AnonymousClass3.AnonymousClass1 */

                        public final void run() {
                            fnn.O000000o().O00000Oo().O00000o();
                            gwq.O000000o().O00000Oo();
                            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("ClientApiStub.onServerChanged"));
                        }
                    });
                }
            });
        }
    }

    public final void O000000o(final Locale locale, final Locale locale2) throws RemoteException {
        CoreApi.O000000o().O000O00o();
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            O000000o(new O000000o() {
                /* class _m_j.fuu.AnonymousClass4 */

                public final void O000000o() {
                    CommonApplication.getGlobalWorkerHandler().post(new Runnable() {
                        /* class _m_j.fuu.AnonymousClass4.AnonymousClass1 */

                        public final void run() {
                            ft O000000o2 = ft.O000000o(CommonApplication.getAppContext());
                            Intent intent = new Intent("ClientApiStub.onLocaleChanged");
                            intent.putExtra("old_locale", locale);
                            intent.putExtra("new_locale", locale2);
                            O000000o2.O000000o(intent);
                        }
                    });
                }
            });
        }
    }

    public final void O000000o(final int i, final int i2, final String str) throws RemoteException {
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            O000000o(new O000000o() {
                /* class _m_j.fuu.AnonymousClass5 */

                public final void O000000o() {
                    CommonApplication.getGlobalHandler().post(new Runnable() {
                        /* class _m_j.fuu.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            HashSet<fut> hashSet = new HashSet<>();
                            Iterator<fut> it = ActivityStack.instance.getActivityListeners().iterator();
                            while (it.hasNext()) {
                                fut next = it.next();
                                try {
                                    next.onActivityResume(i, i2, str);
                                } catch (Exception unused) {
                                    hashSet.add(next);
                                }
                            }
                            for (fut unregisterActivityListener : hashSet) {
                                ActivityStack.instance.unregisterActivityListener(unregisterActivityListener);
                            }
                        }
                    });
                }
            });
        }
    }

    public final void O000000o(Bundle bundle) {
        Device O00000o0;
        Bundle bundle2 = bundle;
        if (ftm.O000000o(CommonApplication.getAppContext())) {
            String string = bundle2.getString("key_device_address");
            UUID uuid = (UUID) bundle2.getSerializable("key_service_uuid");
            UUID uuid2 = (UUID) bundle2.getSerializable("key_character_uuid");
            byte[] byteArray = bundle2.getByteArray("key_character_value");
            String O000000o2 = foc.O000000o(string);
            if (!TextUtils.isEmpty(O000000o2) && (O00000o0 = fno.O000000o().O00000o0(O000000o2)) != null && CoreApi.O000000o().O00000o(O00000o0.model)) {
                Intent intent = new Intent();
                intent.putExtra("key_device_address", string);
                intent.putExtra("key_service_uuid", uuid);
                intent.putExtra("key_character_uuid", uuid2);
                intent.putExtra("key_character_value", byteArray);
                PluginApi.getInstance().sendMessage(CommonApplication.getAppContext(), O00000o0.model, 22, intent, DeviceRouterFactory.getDeviceWrapper().newDeviceStat(O00000o0), null, false, null);
            }
        }
    }

    private void O000000o(final O000000o o000000o) {
        CommonApplication.getGlobalHandler().post(new Runnable() {
            /* class _m_j.fuu.AnonymousClass6 */

            public final void run() {
                CommonApplication.getApplication().onApplicationLifeCycleStart();
                O000000o o000000o = o000000o;
                if (o000000o != null) {
                    o000000o.O000000o();
                }
            }
        });
    }
}
