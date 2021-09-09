package com.xiaomi.smarthome.frame.core;

import _m_j.fcx;
import _m_j.fju;
import _m_j.fkl;
import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fsp;
import _m_j.fsr;
import _m_j.fss;
import _m_j.fst;
import _m_j.fsu;
import _m_j.fsx;
import _m_j.fsy;
import _m_j.ft;
import _m_j.ftf;
import _m_j.ftg;
import _m_j.ftm;
import _m_j.ftn;
import _m_j.gfr;
import _m_j.glc;
import _m_j.gle;
import _m_j.gnk;
import _m_j.gpq;
import _m_j.gpr;
import _m_j.gsy;
import _m_j.gsz;
import _m_j.hxe;
import _m_j.izb;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Parcel;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.account.AccountType;
import com.xiaomi.smarthome.core.entity.account.OAuthAccount;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchRequest;
import com.xiaomi.smarthome.core.entity.bluetooth.SearchResult;
import com.xiaomi.smarthome.core.entity.device.DeviceListResult;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.core.entity.plugin.DownloadPluginResult;
import com.xiaomi.smarthome.core.entity.plugin.DownloadRnSdkResult;
import com.xiaomi.smarthome.core.entity.plugin.InstallPluginResult;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.core.entity.plugin.PluginDownloadTask;
import com.xiaomi.smarthome.core.entity.plugin.PluginError;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.core.entity.plugin.UpdatePluginConfigResult;
import com.xiaomi.smarthome.core.entity.statistic.StatType;
import com.xiaomi.smarthome.core.server.ICoreApi;
import com.xiaomi.smarthome.core.server.IServerHandle;
import com.xiaomi.smarthome.core.server.MiHomeMemoryFile;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.bluetooth.IClassicBtRequest;
import com.xiaomi.smarthome.core.server.bluetooth.SearchResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.BluetoothResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions;
import com.xiaomi.smarthome.core.server.internal.bluetooth.security.combo.BleComboWifiConfig;
import com.xiaomi.smarthome.core.server.internal.device.BatchRpcParam;
import com.xiaomi.smarthome.core.server.internal.homeroom.HomeDeviceInfo;
import com.xiaomi.smarthome.core.server.internal.plugin.PluginDeviceManager;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DeviceStat;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.rn.debugmock.MockRnDevicePluginManager;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.youpin.login.entity.account.LoginMiAccount;
import com.xiaomi.youpin.login.entity.account.MiServiceTokenInfo;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class CoreApi {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Object f7432O000000o = new Object();
    public static volatile boolean O0000o0;
    public static boolean O0000oOo = false;
    private static volatile CoreApi O0000oo;
    gpq O00000Oo = new gpq("CoreApiWorker");
    Handler O00000o;
    public Handler O00000o0;
    List<O000O0OO> O00000oO = new CopyOnWriteArrayList();
    List<O000O00o> O00000oo = new CopyOnWriteArrayList();
    Random O0000O0o = new Random();
    public volatile boolean O0000OOo = true;
    public boolean O0000Oo;
    public volatile ICoreApi O0000Oo0;
    public boolean O0000OoO;
    public boolean O0000Ooo;
    Boolean O0000o = null;
    public boolean O0000o00;
    public boolean O0000o0O;
    Object O0000o0o = new Object();
    String O0000oO = "";
    Object O0000oO0 = new Object();
    public ServerBean O0000oOO = null;
    public List<O0000o0> O0000oo0 = new ArrayList();
    private Object O0000ooO = new Object();
    private volatile Object O0000ooo = new Object();
    private volatile Locale O00oOooO = null;
    private volatile boolean O00oOooo = false;

    public interface O000000o {
    }

    public interface O00000o {
    }

    public static abstract class O00000o0 {
        public abstract void O000000o();

        public abstract void O000000o(String str);

        public abstract void O00000Oo();

        public abstract void O00000Oo(String str);

        public abstract void O00000o0(String str);
    }

    public interface O0000O0o {
        void O000000o();

        void O000000o(PluginError pluginError);

        void O000000o(String str);

        void O000000o(String str, float f);

        void O000000o(List<PluginDownloadTask> list);

        void O00000Oo(List<PluginDownloadTask> list);
    }

    public interface O0000OOo {
        void onCancel();

        void onDownInfoSuccess(String str, PluginDownloadTask pluginDownloadTask);

        void onFailure(PluginError pluginError);

        void onProgress(String str, float f);

        void onStart(String str, PluginDownloadTask pluginDownloadTask);

        void onSuccess(String str);
    }

    public interface O0000Oo {
        void onFailure(PluginError pluginError);

        void onStart(String str);

        void onSuccess(String str);
    }

    public interface O0000Oo0 {
        void onFailure(DownloadRnSdkResult downloadRnSdkResult);

        void onSuccess(DownloadRnSdkResult downloadRnSdkResult);
    }

    public interface O0000o {
        void onPluginCacheReady();
    }

    public interface O0000o0 {
        void onCoreReady();
    }

    public interface O0000o00 {
        void onAccountReady(boolean z, String str);
    }

    public interface O000O0o {
        void onScanResult(String str);
    }

    public interface O000O0o0 {
        void O000000o(boolean z);
    }

    public interface O00oOooO {
        void O000000o();
    }

    static abstract class ClientCallback extends IClientCallback.Stub {
        fsm mCallback;

        ClientCallback(fsm fsm) {
            this.mCallback = fsm;
        }
    }

    private CoreApi() {
        this.O00000Oo.start();
        this.O00000o0 = new Handler(this.O00000Oo.getLooper());
        this.O00000o = new Handler(Looper.getMainLooper());
        this.O0000OOo = ftm.O000000o(CommonApplication.getAppContext());
        gsy.O000000o(3, "CoreApi", "initMiJiaLog");
        try {
            CommonApplication.getAppContext().registerReceiver(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass1 */

                public final void onReceive(Context context, Intent intent) {
                    CoreApi.O0000oOo = intent.getBooleanExtra("showlog", false);
                }
            }, new IntentFilter("mijia_log_greydeveloper"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        gsy.O000000o(new gsz() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass9 */

            public final boolean O000000o() {
                return gfr.O0000OOo;
            }

            public final boolean O00000Oo() {
                return gfr.O0000Oo;
            }

            public final boolean O00000o0() {
                return gfr.O0000Ooo;
            }

            public final boolean O00000o() {
                return gfr.O0000o0o;
            }

            public final boolean O00000oO() {
                return CoreApi.O0000oOo;
            }

            public final void O000000o(int i, String str, String str2, String str3) {
                CoreApi coreApi = CoreApi.this;
                try {
                    if (!ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                        if (gfr.O00oOooO) {
                            ftf.O000000o().O000000o(i, str, str2, str3);
                        } else {
                            coreApi.O00000Oo().writeLog(i, str, str2, str3);
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }

            public final void O00000oo() {
                CoreApi coreApi = CoreApi.this;
                try {
                    if (!ftn.O00000o(CoreApi.O000000o().O0000ooO())) {
                        if (gfr.O00oOooO) {
                            ftf.O000000o().O00000o();
                        } else {
                            coreApi.O00000Oo().flushLog();
                        }
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public static CoreApi O000000o() {
        if (O0000oo == null) {
            synchronized (f7432O000000o) {
                if (O0000oo == null) {
                    O0000oo = new CoreApi();
                }
            }
        }
        return O0000oo;
    }

    public final ICoreApi O00000Oo() throws CoreNotReadyException {
        ICoreApi iCoreApi = this.O0000Oo0;
        boolean z = O0000o0;
        if (iCoreApi == null) {
            throw new CoreNotReadyException("apiProxy null" + ftm.O00000o0(fsp.O000000o().O00000Oo));
        } else if (z) {
            return iCoreApi;
        } else {
            throw new CoreNotReadyException("isCoreReady false");
        }
    }

    public static ICoreApi O000000o(IBinder iBinder) {
        ICoreApi asInterface = ICoreApi.Stub.asInterface(iBinder);
        if (!gfr.O00oOooO) {
            return asInterface;
        }
        return (ICoreApi) Proxy.newProxyInstance(ICoreApi.class.getClassLoader(), new Class[]{ICoreApi.class}, new O00000Oo(asInterface));
    }

    public static class O00000Oo implements InvocationHandler {

        /* renamed from: O000000o  reason: collision with root package name */
        private ICoreApi f7517O000000o;

        public O00000Oo(ICoreApi iCoreApi) {
            this.f7517O000000o = iCoreApi;
        }

        public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            return method.invoke(this.f7517O000000o, objArr);
        }
    }

    public final void O000000o(ICoreApi iCoreApi) {
        if (gfr.O0000Ooo) {
            LogType logType = LogType.STARTUP;
            gsy.O00000Oo(logType, "CoreApi", "setCoreApiProxy isMain=" + gfr.O00oOooO);
        }
        synchronized (f7432O000000o) {
            this.O0000Oo0 = iCoreApi;
        }
    }

    public final boolean O00000o0() {
        boolean z;
        synchronized (f7432O000000o) {
            if (gfr.O00oOooO) {
                z = this.O0000Oo;
            } else {
                z = this.O0000Oo0 != null && this.O0000Oo;
            }
        }
        return z;
    }

    public final void O000000o(Context context, final O0000o00 o0000o00) {
        gsy.O00000Oo(LogType.GENERAL, "login", "CoreApi isAccountReady ".concat(String.valueOf(context)));
        if (context != null) {
            if (O00000o0()) {
                if (gfr.O0000Ooo) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "login", "CoreApi isAccountReady true, will callback " + O0000Ooo());
                }
                if (o0000o00 == null) {
                    return;
                }
                if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                    o0000o00.onAccountReady(O0000Ooo(), O0000o0());
                } else {
                    new Handler(Looper.getMainLooper()).post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass22 */

                        public final void run() {
                            o0000o00.onAccountReady(CoreApi.this.O0000Ooo(), CoreApi.this.O0000o0());
                        }
                    });
                }
            } else {
                if (gfr.O0000Ooo) {
                    gsy.O00000Oo(LogType.GENERAL, "login", "CoreApi isAccountReady false, will reg receiver");
                }
                final WeakReference weakReference = new WeakReference(context);
                IntentFilter intentFilter = new IntentFilter("CoreApi.onAccountReadyInternal");
                final gpr gpr = new gpr(o0000o00);
                ft.O000000o(context.getApplicationContext()).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass23 */

                    public final void onReceive(Context context, Intent intent) {
                        Context context2 = (Context) weakReference.get();
                        if (context2 != null) {
                            ft.O000000o(context2.getApplicationContext()).O000000o(this);
                        }
                        boolean booleanExtra = intent.getBooleanExtra("isMiLoggedIn", false);
                        String stringExtra = intent.getStringExtra("miId");
                        O0000o00 o0000o00 = (O0000o00) gpr.f18128O000000o;
                        gpr.f18128O000000o = null;
                        if (o0000o00 != null) {
                            o0000o00.onAccountReady(booleanExtra, stringExtra);
                        }
                    }
                }, intentFilter);
            }
        }
    }

    public final boolean O00000o() {
        boolean z;
        synchronized (f7432O000000o) {
            z = this.O0000Oo0 != null && this.O0000OoO;
        }
        return z;
    }

    public final boolean O00000oO() {
        boolean z;
        synchronized (f7432O000000o) {
            z = this.O0000Oo0 != null && this.O0000Ooo;
        }
        return z;
    }

    public final boolean O00000oo() {
        boolean z;
        synchronized (f7432O000000o) {
            z = this.O0000Oo0 != null && this.O0000o00;
        }
        return z;
    }

    public final void O000000o(final Context context, final O00oOooO o00oOooO) {
        if (context != null) {
            if (!O00000oo()) {
                IntentFilter intentFilter = new IntentFilter("CoreApi.onPluginReadyInternal");
                ft.O000000o(context.getApplicationContext()).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass3 */

                    public final void onReceive(Context context, Intent intent) {
                        ft.O000000o(context.getApplicationContext()).O000000o(this);
                        O00oOooO o00oOooO = o00oOooO;
                        if (o00oOooO != null) {
                            o00oOooO.O000000o();
                        }
                    }
                }, intentFilter);
            } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                o00oOooO.O000000o();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass2 */

                    public final void run() {
                        o00oOooO.O000000o();
                    }
                });
            }
        }
    }

    public final boolean O0000O0o() {
        boolean z;
        synchronized (f7432O000000o) {
            z = this.O0000Oo0 != null && O0000o0;
        }
        return z;
    }

    public final void O000000o(List<O0000o0> list) {
        synchronized (f7432O000000o) {
            for (int i = 0; i < list.size(); i++) {
                this.O0000oo0.remove(list.get(i));
            }
        }
    }

    public final void O000000o(Context context, final O0000o0 o0000o0) {
        if (context == null) {
            o0000o0.onCoreReady();
        } else if (!O0000O0o()) {
            synchronized (f7432O000000o) {
                if (!O0000O0o()) {
                    this.O0000oo0.add(o0000o0);
                } else if (o0000o0 != null) {
                    if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                        o0000o0.onCoreReady();
                    } else {
                        new Handler(Looper.getMainLooper()).post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass5 */

                            public final void run() {
                                o0000o0.onCoreReady();
                            }
                        });
                    }
                }
            }
            IntentFilter intentFilter = new IntentFilter("CoreApi.onCoreReadyInternal");
            final WeakReference weakReference = new WeakReference(context);
            ft.O000000o(context.getApplicationContext()).O000000o(new BroadcastReceiver() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass6 */

                public final void onReceive(Context context, Intent intent) {
                    Context context2 = (Context) weakReference.get();
                    if (context2 != null) {
                        ft.O000000o(context2.getApplicationContext()).O000000o(this);
                    }
                }
            }, intentFilter);
        } else if (o0000o0 == null) {
        } else {
            if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                o0000o0.onCoreReady();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass4 */

                    public final void run() {
                        o0000o0.onCoreReady();
                    }
                });
            }
        }
    }

    public final boolean O0000OOo() {
        boolean z;
        synchronized (f7432O000000o) {
            z = this.O0000Oo0 != null && this.O0000o0O;
        }
        return z;
    }

    public final void O000000o(final Context context, final O0000o o0000o) {
        if (context != null) {
            if (!O0000OOo()) {
                IntentFilter intentFilter = new IntentFilter("CoreApi.onPluginCacheReadyInternal");
                ft.O000000o(context.getApplicationContext()).O000000o(new BroadcastReceiver() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass8 */

                    public final void onReceive(Context context, Intent intent) {
                        ft.O000000o(context.getApplicationContext()).O000000o(this);
                        O0000o o0000o = o0000o;
                        if (o0000o != null) {
                            o0000o.onPluginCacheReady();
                        }
                    }
                }, intentFilter);
            } else if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
                o0000o.onPluginCacheReady();
            } else {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass7 */

                    public final void run() {
                        o0000o.onPluginCacheReady();
                    }
                });
            }
        }
    }

    public final void O0000Oo0() {
        if (fsr.O0000O0o || fsr.O0000Oo0) {
            try {
                O00000Oo().gc();
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (CoreNotReadyException e2) {
                e2.printStackTrace();
            }
        }
    }

    public final AccountType O0000Oo() {
        try {
            return O00000Oo().getAccountType();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final boolean O0000OoO() {
        try {
            return O00000Oo().isBooleanValue("KEY.IS_DEVELOPER");
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final void O000000o(String str, boolean z) {
        try {
            ICoreApi O00000Oo2 = O00000Oo();
            O00000Oo2.updateBooleanValue(str + "#KEY.IS_UPGRADING_FIRMWARE", z);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    @Deprecated
    public final boolean O0000Ooo() {
        Boolean bool;
        if (this.O0000OOo) {
            try {
                return O00000Oo().isMiLoggedIn();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        synchronized (this.O0000o0o) {
            bool = this.O0000o;
            if (bool == null) {
                try {
                    bool = Boolean.valueOf(O00000Oo().isMiLoggedIn());
                    this.O0000o = bool;
                } catch (RemoteException e2) {
                    e2.printStackTrace();
                } catch (CoreNotReadyException e3) {
                    e3.printStackTrace();
                }
            }
        }
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        return bool.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final void O0000o00() {
        synchronized (this.O0000o0o) {
            this.O0000o = null;
        }
    }

    public final String O0000o0() {
        String str;
        synchronized (this.O0000oO0) {
            str = this.O0000oO;
            if (TextUtils.isEmpty(str) || TextUtils.equals(str, "0")) {
                try {
                    str = O00000Oo().getMiId();
                    this.O0000oO = str;
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    public final String O0000o0O() {
        String str;
        synchronized (this.O0000oO0) {
            str = null;
            try {
                str = O00000Oo().getMiId();
                this.O0000oO = str;
            } catch (RemoteException e) {
                e.printStackTrace();
            } catch (CoreNotReadyException e2) {
                e2.printStackTrace();
            }
        }
        return TextUtils.isEmpty(str) ? "0" : str;
    }

    /* access modifiers changed from: package-private */
    public final void O0000o0o() {
        synchronized (this.O0000oO0) {
            this.O0000oO = "";
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    public final String O0000o() {
        String str;
        try {
            LoginMiAccount miAccount = O00000Oo().getMiAccount();
            if (!(miAccount == null || miAccount.O000000o("passportapi") == null)) {
                str = miAccount.O000000o("passportapi").O00000Oo;
                if (!TextUtils.isEmpty(str)) {
                    return "0";
                }
                return str;
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
        }
        str = "0";
        if (!TextUtils.isEmpty(str)) {
        }
    }

    public final boolean O0000oO0() {
        try {
            LoginMiAccount miAccount = O00000Oo().getMiAccount();
            if (miAccount != null) {
                return miAccount.O00000Oo();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final String O0000oO() {
        try {
            LoginMiAccount miAccount = O00000Oo().getMiAccount();
            if (miAccount != null) {
                return miAccount.O00000o0();
            }
            return "";
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final MiServiceTokenInfo O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            LoginMiAccount miAccount = O00000Oo().getMiAccount();
            if (miAccount != null) {
                return miAccount.O000000o(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final List<MiServiceTokenInfo> O0000oOO() {
        ArrayList arrayList = new ArrayList();
        try {
            LoginMiAccount miAccount = O00000Oo().getMiAccount();
            if (miAccount != null) {
                return miAccount.O00000o();
            }
            return arrayList;
        } catch (Throwable th) {
            th.printStackTrace();
            return arrayList;
        }
    }

    public final fsn O000000o(LoginMiAccount loginMiAccount, final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().setMiAccount(loginMiAccount, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass17 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(-1, ""));
                    }
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                }
            });
        } catch (Throwable th) {
            fsm.sendFailureMessage(new fso(-2, th.toString()));
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    public final fsn O000000o(MiServiceTokenInfo miServiceTokenInfo, final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().setMiServiceTokenTmp(miServiceTokenInfo, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass18 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
                    }
                }
            });
        } catch (Throwable unused) {
            if (fsm != null) {
                fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
            }
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    public final fsn O000000o(OAuthAccount oAuthAccount, final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().setOAuthAccount(oAuthAccount, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass19 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
                    }
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                }
            });
        } catch (Throwable th) {
            fsm.sendFailureMessage(new fso(-9999, th.getMessage()));
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    public final LoginMiAccount O0000oOo() {
        try {
            return O00000Oo().getMiAccount();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        fsp.O000000o().O00000oo.O000000o("---start clearAccount---");
        fsp.O000000o().O00000oo.O000000o(Log.getStackTraceString(new Exception()));
        fsp.O000000o().O00000oo.O000000o("---end clearAccount---");
        try {
            iServerHandle = O00000Oo().clearAccount(new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass20 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    CoreApi.this.O0000o00();
                    CoreApi.this.O0000o0o();
                    fso fso = new fso(ErrorCode.INVALID.getCode(), "");
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                }
            });
        } catch (Throwable th) {
            fsm.sendFailureMessage(new fso(-9999, th.getMessage()));
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn
     arg types: [android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, java.lang.String, boolean, _m_j.fss, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, int, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm, boolean):_m_j.fsn */
    public final <R> fsn O000000o(Context context, NetRequest netRequest, fss fss, Crypto crypto, fsm fsm) {
        return O000000o(context, netRequest, fss, crypto, fsm, false);
    }

    public final <R> fsn O000000o(Context context, NetRequest netRequest, fss fss, Crypto crypto, fsm fsm, boolean z) {
        int i;
        IServerHandle iServerHandle;
        NetRequest netRequest2 = netRequest;
        Crypto crypto2 = crypto;
        fsm fsm2 = fsm;
        if (context != null) {
            i = context.hashCode();
        } else {
            i = 0;
        }
        long nextLong = this.O0000O0o.nextLong();
        final fss fss2 = fss;
        final boolean z2 = z;
        final Context context2 = context;
        final NetRequest netRequest3 = netRequest;
        int i2 = i;
        AnonymousClass21 r13 = r1;
        final long j = nextLong;
        AnonymousClass21 r1 = new ClientCallback(fsm) {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass21 */

            public void onSuccess(Bundle bundle) throws RemoteException {
                Looper mainLooper;
                MiHomeMemoryFile miHomeMemoryFile;
                bundle.setClassLoader(NetResult.class.getClassLoader());
                NetResult netResult = (NetResult) bundle.getParcelable("result");
                if (netResult == null && (miHomeMemoryFile = (MiHomeMemoryFile) bundle.getParcelable("result_file")) != null) {
                    Parcel O000000o2 = miHomeMemoryFile.O000000o();
                    netResult = (NetResult) O000000o2.readParcelable(NetResult.class.getClassLoader());
                    O000000o2.recycle();
                }
                fsx.O000000o().O000000o(netResult, fss2, this.mCallback, z2);
                try {
                    if ((fsr.O0000O0o || fsr.O0000Oo0) && netResult != null && !TextUtils.isEmpty(netResult.O00000o0)) {
                        JSONObject jSONObject = new JSONObject(netResult.O00000o0);
                        if (!jSONObject.isNull("code") && jSONObject.optInt("code") == -1 && !jSONObject.isNull("message") && TextUtils.equals(jSONObject.optString("message"), "no permit") && (mainLooper = Looper.getMainLooper()) != null) {
                            new Handler(mainLooper).post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass21.AnonymousClass1 */

                                public final void run() {
                                    if (context2 != null) {
                                        Context context = context2;
                                        izb.O000000o(context, netRequest3.toString() + "no permit", 0).show();
                                        gsy.O00000Oo(LogType.GENERAL, "no permit", netRequest3.toString());
                                    }
                                }
                            });
                        }
                    }
                } catch (Exception e) {
                    LogType logType = LogType.GENERAL;
                    gsy.O00000Oo(logType, "ExceptionTAG", "onSuccess: " + e.toString());
                    e.printStackTrace();
                }
                if (!netResult.O00000Oo) {
                    if (this.mCallback == null || !(this.mCallback instanceof fsy)) {
                        CoreApi.this.O000000o(j);
                    }
                    this.mCallback = null;
                }
            }

            public void onFailure(Bundle bundle) throws RemoteException {
                fso fso;
                bundle.setClassLoader(fso.class.getClassLoader());
                NetError netError = (NetError) bundle.getParcelable("error");
                if (!TextUtils.isEmpty(netError.O00000o0)) {
                    fso = new fso(netError.f6718O000000o, netError.O00000Oo, netError.O00000o0);
                } else {
                    fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                }
                if (this.mCallback != null) {
                    this.mCallback.sendFailureMessage(fso);
                }
                if (this.mCallback == null || !(this.mCallback instanceof fsy)) {
                    CoreApi.this.O000000o(j);
                }
                this.mCallback = null;
                ftg.O000000o(netRequest3, fso);
            }
        };
        boolean z3 = fsm2 instanceof fsy;
        if (z3) {
            try {
                ((fsy) fsm2).setUseSyncLockMode();
                Object syncLock = ((fsy) fsm2).getSyncLock();
                synchronized (syncLock) {
                    iServerHandle = O00000Oo().sendSmartHomeRequest(netRequest2, crypto2, r13);
                    syncLock.wait();
                }
                fsy fsy = (fsy) fsm2;
                if (fsy.isSuccess()) {
                    fsm2.onSuccess(fsy.getResult());
                } else {
                    fsm2.onFailure(fsy.getError());
                }
            } catch (Throwable th) {
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th.getMessage()));
                }
                return new fsn(null);
            }
        } else {
            try {
                iServerHandle = O00000Oo().sendSmartHomeRequest(netRequest2, crypto2, r13);
            } catch (Throwable th2) {
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th2.getMessage()));
                }
                return new fsn(null);
            }
        }
        fsn fsn = new fsn(iServerHandle);
        if (!z3) {
            final long j2 = nextLong;
            final fsn fsn2 = fsn;
            final int i3 = i2;
            this.O00000o0.post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass10 */

                public final void run() {
                    O000O0OO o000o0oo = new O000O0OO(CoreApi.this, (byte) 0);
                    o000o0oo.f7519O000000o = j2;
                    o000o0oo.O00000o0 = new WeakReference<>(fsn2);
                    o000o0oo.O00000Oo = i3;
                    CoreApi.this.O00000oO.add(o000o0oo);
                }
            });
        }
        return fsn;
    }

    public final void O000000o(final long j) {
        this.O00000o0.post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass11 */

            public final void run() {
                int i = 0;
                while (i < CoreApi.this.O00000oO.size()) {
                    if (CoreApi.this.O00000oO.get(i).f7519O000000o == j) {
                        CoreApi.this.O00000oO.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        });
    }

    public final void O00000Oo(final long j) {
        this.O00000o0.post(new Runnable() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass14 */

            public final void run() {
                int i = 0;
                while (i < CoreApi.this.O00000oo.size()) {
                    if (CoreApi.this.O00000oo.get(i).f7518O000000o == j) {
                        CoreApi.this.O00000oo.remove(i);
                        i--;
                    }
                    i++;
                }
            }
        });
    }

    public final <R> fsn O000000o(final NetRequest netRequest, final fss fss, final fsm fsm) {
        try {
            return new fsn(O00000Oo().sendMiRechargeRequest(netRequest, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass28 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(NetResult.class.getClassLoader());
                    fst.O000000o().O000000o((NetResult) bundle.getParcelable("result"), fss, fsm);
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    NetError netError = (NetError) bundle.getParcelable("error");
                    fso fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o(netRequest, fso);
                }
            }));
        } catch (Throwable th) {
            fsm.sendFailureMessage(new fso(-9999, th.getMessage()));
            return new fsn(null);
        }
    }

    public final <R> fsn O000000o(Context context, NetRequest netRequest, String str, boolean z, fss fss, fsm fsm) {
        int i;
        IServerHandle iServerHandle;
        NetRequest netRequest2 = netRequest;
        String str2 = str;
        boolean z2 = z;
        fsm fsm2 = fsm;
        if (context != null) {
            i = context.hashCode();
        } else {
            i = 0;
        }
        long nextLong = this.O0000O0o.nextLong();
        final fss fss2 = fss;
        final fsm fsm3 = fsm;
        final long j = nextLong;
        final NetRequest netRequest3 = netRequest;
        AnonymousClass30 r1 = new IClientCallback.Stub() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass30 */

            public void onSuccess(Bundle bundle) throws RemoteException {
                bundle.setClassLoader(NetResult.class.getClassLoader());
                NetResult netResult = (NetResult) bundle.getParcelable("result");
                fsu O000000o2 = fsu.O000000o();
                fss fss = fss2;
                fsm fsm = fsm3;
                if (netResult != null) {
                    O000000o2.f17074O000000o.submit(new Runnable(netResult, fss, fsm) {
                        /* class _m_j.fsu.AnonymousClass1 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ NetResult f17075O000000o;
                        final /* synthetic */ fss O00000Oo;
                        final /* synthetic */ fsm O00000o0;

                        {
                            this.f17075O000000o = r2;
                            this.O00000Oo = r3;
                            this.O00000o0 = r4;
                        }

                        public final void run() {
                            try {
                                JSONObject jSONObject = new JSONObject(this.f17075O000000o.O00000o0);
                                int optInt = jSONObject.optInt("code");
                                if (optInt == 0) {
                                    Object obj = null;
                                    if (this.O00000Oo != null) {
                                        obj = this.O00000Oo.parse(jSONObject);
                                    }
                                    if (this.O00000o0 != null) {
                                        this.O00000o0.sendSuccessMessage(obj);
                                    }
                                } else if (this.O00000o0 != null) {
                                    this.O00000o0.sendFailureMessage(new fso(optInt, ""));
                                }
                            } catch (Exception unused) {
                                fsm fsm = this.O00000o0;
                                if (fsm != null) {
                                    fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), "wrong response format"));
                                }
                            }
                        }
                    });
                } else if (fsm != null) {
                    fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), ""));
                }
                if (!(fsm3 instanceof fsy)) {
                    CoreApi.this.O00000Oo(j);
                }
            }

            public void onFailure(Bundle bundle) throws RemoteException {
                bundle.setClassLoader(fso.class.getClassLoader());
                NetError netError = (NetError) bundle.getParcelable("error");
                fso fso = new fso(netError.f6718O000000o, netError.O00000Oo);
                fsm fsm = fsm3;
                if (fsm != null) {
                    fsm.sendFailureMessage(fso);
                }
                if (!(fsm3 instanceof fsy)) {
                    CoreApi.this.O00000Oo(j);
                }
                ftg.O000000o(netRequest3, fso);
            }
        };
        boolean z3 = fsm2 instanceof fsy;
        if (z3) {
            try {
                ((fsy) fsm2).setUseSyncLockMode();
                Object syncLock = ((fsy) fsm2).getSyncLock();
                synchronized (syncLock) {
                    iServerHandle = O00000Oo().sendRouterRequest(netRequest2, str2, z2, r1);
                    syncLock.wait();
                }
                fsy fsy = (fsy) fsm2;
                if (fsy.isSuccess()) {
                    fsm2.onSuccess(fsy.getResult());
                } else {
                    fsm2.onFailure(fsy.getError());
                }
            } catch (Throwable th) {
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th.getMessage()));
                }
                return new fsn(null);
            }
        } else {
            try {
                iServerHandle = O00000Oo().sendRouterRequest(netRequest2, str2, z2, r1);
            } catch (Throwable th2) {
                if (fsm2 != null) {
                    fsm2.sendFailureMessage(new fso(-9999, th2.getMessage()));
                }
                return new fsn(null);
            }
        }
        fsn fsn = new fsn(iServerHandle);
        if (!z3) {
            final long j2 = nextLong;
            final fsn fsn2 = fsn;
            final int i2 = i;
            this.O00000o0.post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass13 */

                public final void run() {
                    O000O00o o000O00o = new O000O00o(CoreApi.this, (byte) 0);
                    o000O00o.f7518O000000o = j2;
                    o000O00o.O00000o0 = new WeakReference<>(fsn2);
                    o000O00o.O00000Oo = i2;
                    CoreApi.this.O00000oo.add(o000O00o);
                }
            });
        }
        return fsn;
    }

    public final fsn O000000o(final List<BatchRpcParam> list, final fsm<JSONObject, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().batchRpcAsync(list, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass32 */

                /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
                /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
                public void onSuccess(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                    String string = bundle.getString("result");
                    JSONObject jSONObject = new JSONObject();
                    if (string != null && !TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string);
                            try {
                                int optInt = jSONObject2.optInt("code");
                                if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                                    if (optJSONObject == null) {
                                        optJSONObject = jSONObject2;
                                    }
                                    if (fsm != null) {
                                        fsm.sendSuccessMessage(optJSONObject);
                                    }
                                } else if (fsm != null) {
                                    fsm.sendFailureMessage(new fso(optInt, jSONObject2.optString("message")));
                                }
                            } catch (JSONException unused) {
                                jSONObject = jSONObject2;
                                if (fsm == null) {
                                    fsm.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                                }
                            }
                        } catch (JSONException unused2) {
                            if (fsm == null) {
                            }
                        }
                    } else if (fsm != null) {
                        fsm.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("batchRpcAsync fail " + Arrays.toString(list.toArray()), fso);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O000000o(String str, String str2, String str3, fsm<JSONObject, fso> fsm, boolean z) {
        IServerHandle iServerHandle;
        final boolean z2 = z;
        final fsm<JSONObject, fso> fsm2 = fsm;
        final String str4 = str;
        final String str5 = str3;
        try {
            iServerHandle = O00000Oo().rpcAsyncToCloud(str, str2, str3, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass33 */

                /* JADX WARNING: Removed duplicated region for block: B:26:0x0060  */
                /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
                public void onSuccess(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                    String string = bundle.getString("result");
                    JSONObject jSONObject = new JSONObject();
                    if (string != null && !TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string);
                            try {
                                int optInt = jSONObject2.optInt("code");
                                if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                                    if (optJSONObject == null || z2) {
                                        optJSONObject = jSONObject2;
                                    }
                                    if (fsm2 != null) {
                                        fsm2.sendSuccessMessage(optJSONObject);
                                    }
                                } else if (fsm2 != null) {
                                    fsm2.sendFailureMessage(new fso(optInt, jSONObject2.optString("message")));
                                }
                            } catch (JSONException unused) {
                                jSONObject = jSONObject2;
                                if (fsm2 == null) {
                                    fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                                }
                            }
                        } catch (JSONException unused2) {
                            if (fsm2 == null) {
                            }
                        }
                    } else if (fsm2 != null) {
                        fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("rpcAsyncToCloud fail " + str4 + ":" + str5, fso);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O000000o(String str, String str2, String str3, fsm<JSONObject, fso> fsm) {
        return O00000Oo(str, str2, str3, fsm, false);
    }

    public final fsn O00000Oo(String str, String str2, String str3, fsm<JSONObject, fso> fsm, boolean z) {
        IServerHandle iServerHandle;
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean z2 = z;
        final fsm<JSONObject, fso> fsm2 = fsm;
        final String str4 = str3;
        final String str5 = str;
        try {
            iServerHandle = O00000Oo().rpcAsync(str, str2, str3, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass34 */

                /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
                /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
                /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                public void onSuccess(Bundle bundle) throws RemoteException {
                    long abs = Math.abs(System.currentTimeMillis() - currentTimeMillis);
                    bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                    String string = bundle.getString("result");
                    JSONObject jSONObject = new JSONObject();
                    if (string != null && !TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string);
                            try {
                                int optInt = jSONObject2.optInt("code");
                                if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                                    if (optJSONObject == null || z2) {
                                        optJSONObject = jSONObject2;
                                    }
                                    if (fsm2 != null) {
                                        fsm2.sendSuccessMessage(optJSONObject);
                                    }
                                } else if (fsm2 != null) {
                                    fsm2.sendFailureMessage(new fso(optInt, jSONObject2.optString("message")));
                                }
                            } catch (JSONException unused) {
                                jSONObject = jSONObject2;
                                if (fsm2 != null) {
                                    fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                                }
                                if (abs > 3000) {
                                }
                            }
                        } catch (JSONException unused2) {
                            if (fsm2 != null) {
                            }
                            if (abs > 3000) {
                            }
                        }
                    } else if (fsm2 != null) {
                        fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                    }
                    if (abs > 3000) {
                        String str = str4;
                        String str2 = str5;
                        hxe.O000000o(abs, str, str2, true, CoreApi.O00000Oo(str2));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    long abs = Math.abs(System.currentTimeMillis() - currentTimeMillis);
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("rpcAsync fail " + str5 + ":" + str4, fso);
                    if (abs > 3000) {
                        String str = str4;
                        String str2 = str5;
                        hxe.O000000o(abs, str, str2, false, CoreApi.O00000Oo(str2));
                    }
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O00000o0(String str, String str2, String str3, fsm<JSONObject, fso> fsm, boolean z) {
        IServerHandle iServerHandle;
        final long currentTimeMillis = System.currentTimeMillis();
        final boolean z2 = z;
        final fsm<JSONObject, fso> fsm2 = fsm;
        final String str4 = str3;
        final String str5 = str;
        try {
            iServerHandle = O00000Oo().rpcAsyncToLocal(str, str2, str3, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass35 */

                /* JADX WARNING: Removed duplicated region for block: B:26:0x006b  */
                /* JADX WARNING: Removed duplicated region for block: B:32:0x0092  */
                /* JADX WARNING: Removed duplicated region for block: B:34:? A[RETURN, SYNTHETIC] */
                public void onSuccess(Bundle bundle) throws RemoteException {
                    long abs = Math.abs(System.currentTimeMillis() - currentTimeMillis);
                    bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                    String string = bundle.getString("result");
                    JSONObject jSONObject = new JSONObject();
                    if (string != null && !TextUtils.isEmpty(string)) {
                        try {
                            JSONObject jSONObject2 = new JSONObject(string);
                            try {
                                int optInt = jSONObject2.optInt("code");
                                if (ErrorCode.valueof(optInt) == ErrorCode.SUCCESS) {
                                    JSONObject optJSONObject = jSONObject2.optJSONObject("result");
                                    if (optJSONObject == null || z2) {
                                        optJSONObject = jSONObject2;
                                    }
                                    if (fsm2 != null) {
                                        fsm2.sendSuccessMessage(optJSONObject);
                                    }
                                } else if (fsm2 != null) {
                                    fsm2.sendFailureMessage(new fso(optInt, jSONObject2.optString("message")));
                                }
                            } catch (JSONException unused) {
                                jSONObject = jSONObject2;
                                if (fsm2 != null) {
                                    fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                                }
                                if (abs > 3000) {
                                }
                            }
                        } catch (JSONException unused2) {
                            if (fsm2 != null) {
                            }
                            if (abs > 3000) {
                            }
                        }
                    } else if (fsm2 != null) {
                        fsm2.sendFailureMessage(new fso(-999, jSONObject.optString("message")));
                    }
                    if (abs > 3000) {
                        String str = str4;
                        String str2 = str5;
                        hxe.O000000o(abs, str, str2, true, CoreApi.O00000Oo(str2));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    long abs = Math.abs(System.currentTimeMillis() - currentTimeMillis);
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("rpcAsync fail " + str5 + ":" + str4, fso);
                    if (abs > 3000) {
                        String str = str4;
                        String str2 = str5;
                        hxe.O000000o(abs, str, str2, false, CoreApi.O00000Oo(str2));
                    }
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O000000o(String str, String str2, final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().renameDevice(str, str2, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass36 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("renameDevice fail", fso);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O00000Oo(List<String> list, final fsm<String, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().delDeviceBatch(list, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass37 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    if (fsm != null) {
                        bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                        fsm.sendSuccessMessage(bundle.getString("result"));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("delDeviceBatch request", fso);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O00000o0(List<String> list, final fsm<List<Device>, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().updateDeviceBatch(list, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass38 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    if (fsm != null) {
                        bundle.setClassLoader(DeviceListResult.class.getClassLoader());
                        fsm.sendSuccessMessage(bundle.getParcelableArrayList("result"));
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fso fso = new fso(error.f6718O000000o, error.O00000Oo);
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(fso);
                    }
                    ftg.O000000o("updateDeviceBatch fail", fso);
                }
            });
        } catch (RemoteException e) {
            e.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            iServerHandle = null;
            return new fsn(iServerHandle);
        }
        return new fsn(iServerHandle);
    }

    public final fsn O00000Oo(final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().setGlobalSettingCTA(false, true, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass41 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(Error.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    public final boolean O0000oo0() {
        return ftn.O00000Oo(O0000ooO());
    }

    public final boolean O0000oo() {
        String O00oOooO2 = O00oOooO();
        return !TextUtils.isEmpty(O00oOooO2) && O00oOooO2.equalsIgnoreCase("preview");
    }

    public final ServerBean O0000ooO() {
        ServerBean serverBean;
        synchronized (this.O0000ooO) {
            serverBean = this.O0000oOO;
            if (serverBean == null) {
                try {
                    if (this.O0000OOo) {
                        serverBean = fju.O000000o().O00000o();
                    } else {
                        serverBean = O00000Oo().getGlobalSettingServer();
                    }
                    this.O0000oOO = serverBean;
                } catch (RemoteException e) {
                    e.printStackTrace();
                } catch (CoreNotReadyException e2) {
                    e2.printStackTrace();
                }
            }
        }
        return serverBean;
    }

    public final fsn O000000o(ServerBean serverBean, final fsm<Void, fso> fsm) {
        IServerHandle iServerHandle;
        try {
            iServerHandle = O00000Oo().setGlobalSettingServer(serverBean, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass42 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                    CoreApi.this.O0000ooo();
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(Error.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                    }
                    CoreApi.this.O0000ooo();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            iServerHandle = null;
        }
        return new fsn(iServerHandle);
    }

    public final void O0000ooo() {
        synchronized (this.O0000ooO) {
            this.O0000oOO = null;
        }
    }

    public final String O00oOooO() {
        try {
            return O00000Oo().getGlobalSettingServerEnv();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final fsn O00000o0(String str) {
        IServerHandle iServerHandle = null;
        try {
            iServerHandle = O00000Oo().setGlobalSettingServerEnv(str, new IClientCallback.Stub(null) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass43 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    fsm fsm = null;
                    if (fsm != null) {
                        fsm.sendSuccessMessage(null);
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(Error.class.getClassLoader());
                    Error error = (Error) bundle.getParcelable("error");
                    fsm fsm = null;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new fsn(iServerHandle);
    }

    public final Locale O00oOooo() {
        Locale locale = this.O00oOooO;
        if (locale == null && !this.O00oOooo) {
            synchronized (this.O0000ooo) {
                if (locale == null) {
                    if (!this.O00oOooo) {
                        try {
                            Bundle globalSettingLocale = O00000Oo().getGlobalSettingLocale();
                            if (globalSettingLocale != null) {
                                locale = (Locale) globalSettingLocale.getSerializable("result");
                            }
                            this.O00oOooO = locale;
                            this.O00oOooo = true;
                        } catch (Throwable th) {
                            th.printStackTrace();
                        }
                    }
                }
            }
        }
        return locale;
    }

    public final fsn O000000o(Locale locale, final fsm<Void, fso> fsm) {
        AnonymousClass44 r0 = new IClientCallback.Stub() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass44 */

            public void onSuccess(Bundle bundle) throws RemoteException {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.sendSuccessMessage(null);
                }
                CoreApi.this.O000O00o();
            }

            public void onFailure(Bundle bundle) throws RemoteException {
                bundle.setClassLoader(Error.class.getClassLoader());
                Error error = (Error) bundle.getParcelable("error");
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.sendFailureMessage(new fso(error.f6718O000000o, error.O00000Oo));
                }
                CoreApi.this.O000O00o();
            }
        };
        try {
            Bundle bundle = new Bundle();
            if (locale != null) {
                bundle.putSerializable("result", locale);
            }
            O00000Oo().setGlobalSettingLocale(bundle, r0);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return new fsn(null);
    }

    public final void O000O00o() {
        synchronized (this.O0000ooo) {
            this.O00oOooo = false;
            this.O00oOooO = null;
        }
    }

    public final void O000000o(int i) {
        try {
            O00000Oo().setScanTimePeriod(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000O0OO() {
        try {
            O00000Oo().stopScan();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(boolean z, final O000O0o0 o000O0o0) {
        final Handler handler = new Handler(Looper.getMainLooper());
        try {
            O00000Oo().updatePluginConfig(z, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass47 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(UpdatePluginConfigResult.class.getClassLoader());
                    final UpdatePluginConfigResult updatePluginConfigResult = (UpdatePluginConfigResult) bundle.getParcelable("result");
                    if (o000O0o0 != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass47.AnonymousClass1 */

                            public final void run() {
                                o000O0o0.O000000o(updatePluginConfigResult.f6740O000000o);
                            }
                        });
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    final PluginError pluginError = (PluginError) bundle.getParcelable("error");
                    if (o000O0o0 != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass47.AnonymousClass2 */

                            public final void run() {
                            }
                        });
                    }
                    ftg.O000000o("updatePluginConfig fail", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final boolean O00000o(String str) {
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (MockRnDevicePluginManager.getInstance().modelIsMockModel(str)) {
            return true;
        }
        if (this.O0000OOo) {
            if (O0000O0o()) {
                if (PluginDeviceManager.instance.getPluginInfo(str) != null) {
                    z = true;
                }
                if (!z) {
                    gsy.O00000o0(LogType.GENERAL, "CoreApi", "isPluginDevice: PluginManager does not contain the model:".concat(String.valueOf(str)));
                }
                return z;
            }
            gsy.O00000o0(LogType.GENERAL, "CoreApi", "isPluginDevice: core not ready!");
            return false;
        } else if (O00000oO(str) != null) {
            return true;
        } else {
            return false;
        }
    }

    public final PluginDeviceInfo O00000oO(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (MockRnDevicePluginManager.getInstance().modelIsMockModel(str)) {
            return MockRnDevicePluginManager.getInstance().getMockPluginDeviceInfo(str);
        }
        if (!this.O0000OOo) {
            try {
                return O00000Oo().getPluginInfo(str);
            } catch (Throwable th) {
                gsy.O00000o0(LogType.PLUGIN, "CoreApi", Log.getStackTraceString(th));
            }
        } else if (O0000O0o()) {
            return PluginDeviceManager.instance.getPluginInfo(str);
        }
        return null;
    }

    public final PluginDeviceInfo O00000oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (MockRnDevicePluginManager.getInstance().modelIsMockModel(str)) {
            return MockRnDevicePluginManager.getInstance().getMockPluginDeviceInfo(str);
        }
        if (!this.O0000OOo) {
            try {
                return O00000Oo().getExtraPluginInfo(str);
            } catch (Throwable th) {
                gsy.O00000o0(LogType.PLUGIN, "CoreApi", Log.getStackTraceString(th));
            }
        } else if (O0000O0o()) {
            return PluginDeviceManager.instance.getExtraPluginInfo(str);
        }
        return null;
    }

    static void O000000o(boolean z, boolean z2, String str) {
        LogType logType = LogType.PLUGIN;
        gsy.O00000o0(logType, "CoreApi", "onPluginChanged " + z + " " + z2 + " " + str);
        if (z) {
            ft.O000000o(CommonApplication.getAppContext()).O000000o(new Intent("force_update_data"));
        }
    }

    public final String O00000Oo(int i) {
        try {
            return O00000Oo().getModelByProductId(i);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final int O0000O0o(String str) {
        try {
            return O00000Oo().getProductIdByModel(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public final String O0000OOo(String str) {
        try {
            return O00000Oo().getModelBySSID(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public final boolean O0000Oo0(String str) {
        if (TextUtils.isEmpty(str) || MockRnDevicePluginManager.getInstance().modelIsMockModel(str)) {
            return false;
        }
        try {
            return O00000Oo().isPluginForceUpdating(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final void O000000o(final String str, boolean z, final O0000OOo o0000OOo) {
        O000000o(Collections.singletonList(str), z, new O0000O0o() {
            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass24 */

            public final void O000000o(List<PluginDownloadTask> list) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onStart(str, list.get(0));
                }
            }

            public final void O00000Oo(List<PluginDownloadTask> list) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onDownInfoSuccess(str, list.get(0));
                }
            }

            public final void O000000o(String str, float f) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onProgress(str, f);
                }
            }

            public final void O000000o(String str) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onSuccess(str);
                }
            }

            public final void O000000o(PluginError pluginError) {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onFailure(pluginError);
                }
            }

            public final void O000000o() {
                O0000OOo o0000OOo = o0000OOo;
                if (o0000OOo != null) {
                    o0000OOo.onCancel();
                }
            }
        });
    }

    public final void O000000o(List<String> list, boolean z, final O0000O0o o0000O0o) {
        final Handler handler = new Handler(Looper.getMainLooper());
        if (list == null || list.size() == 0) {
            handler.post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass25 */

                public final void run() {
                    PluginError pluginError = new PluginError(-98, "model is null");
                    o0000O0o.O000000o(pluginError);
                    ftg.O000000o("downloadPlugin fail1", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }
            });
            return;
        }
        final gpr gpr = new gpr(o0000O0o);
        try {
            O00000Oo().downloadPlugin(list, z, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass52 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    if (gpr.f18128O000000o != null) {
                        bundle.setClassLoader(DownloadPluginResult.class.getClassLoader());
                        DownloadPluginResult downloadPluginResult = (DownloadPluginResult) bundle.getParcelable("result");
                        if (downloadPluginResult.f6733O000000o == 1) {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$cWTXakZLKKod0pMqV2rWv_QSzyE */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$0(gpr.this, this.f$1);
                                }
                            });
                        } else if (downloadPluginResult.f6733O000000o == 7) {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$G1mZAXtQ4p50JtgTsBL4KO6yWyk */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$1(gpr.this, this.f$1);
                                }
                            });
                        } else if (downloadPluginResult.f6733O000000o == 3) {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$QLIKRaVFdM0NMizaepwdy_bW6Mg */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$2(gpr.this, this.f$1);
                                }
                            });
                        } else if (downloadPluginResult.f6733O000000o == 4) {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$NhL4Rz1krP4UEwTarsI5yfhI6E */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$3(gpr.this, this.f$1);
                                }
                            });
                        } else if (downloadPluginResult.f6733O000000o == 6) {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$2Z7T3NA1QhaqGCxs5A_c58v60 */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$4(gpr.this, this.f$1);
                                }
                            });
                        } else {
                            handler.post(new Runnable(downloadPluginResult) {
                                /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$VJ0wioa4mOgOPDHSosQ5T6FHgNg */
                                private final /* synthetic */ DownloadPluginResult f$1;

                                {
                                    this.f$1 = r2;
                                }

                                public final void run() {
                                    CoreApi.AnonymousClass52.lambda$onSuccess$5(gpr.this, this.f$1);
                                }
                            });
                        }
                    }
                }

                static /* synthetic */ void lambda$onSuccess$0(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O000000o(downloadPluginResult.O00000o);
                    }
                }

                static /* synthetic */ void lambda$onSuccess$1(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O00000Oo(downloadPluginResult.O00000o);
                    }
                }

                static /* synthetic */ void lambda$onSuccess$2(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O000000o(downloadPluginResult.O00000o0, downloadPluginResult.O00000oO);
                    }
                }

                static /* synthetic */ void lambda$onSuccess$3(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O000000o(downloadPluginResult.O00000o0);
                    }
                    gpr.f18128O000000o = null;
                }

                static /* synthetic */ void lambda$onSuccess$4(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O000000o();
                    }
                    gpr.f18128O000000o = null;
                }

                static /* synthetic */ void lambda$onSuccess$5(gpr gpr, DownloadPluginResult downloadPluginResult) {
                    PluginError pluginError = new PluginError(-1, "unknown error");
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (o0000O0o != null) {
                        o0000O0o.O000000o(pluginError);
                    }
                    gpr.f18128O000000o = null;
                    ftg.O000000o("downloadPlugin fail3", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(PluginError.class.getClassLoader());
                    PluginError pluginError = (PluginError) bundle.getParcelable("error");
                    DownloadPluginResult downloadPluginResult = (DownloadPluginResult) bundle.getParcelable("result");
                    if (gpr.f18128O000000o != null) {
                        handler.post(new Runnable(downloadPluginResult, pluginError) {
                            /* class com.xiaomi.smarthome.frame.core.$$Lambda$CoreApi$52$EoJddkDl8SZujfQRuW0IpXdiCM */
                            private final /* synthetic */ DownloadPluginResult f$1;
                            private final /* synthetic */ PluginError f$2;

                            {
                                this.f$1 = r2;
                                this.f$2 = r3;
                            }

                            public final void run() {
                                CoreApi.AnonymousClass52.lambda$onFailure$6(gpr.this, this.f$1, this.f$2);
                            }
                        });
                    }
                    ftg.O000000o("downloadPlugin fail4", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }

                static /* synthetic */ void lambda$onFailure$6(gpr gpr, DownloadPluginResult downloadPluginResult, PluginError pluginError) {
                    O0000O0o o0000O0o = (O0000O0o) gpr.f18128O000000o;
                    if (!(o0000O0o == null || downloadPluginResult == null)) {
                        o0000O0o.O000000o(pluginError);
                    }
                    gpr.f18128O000000o = null;
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(String str, boolean z, final O0000Oo o0000Oo) {
        final Handler handler = new Handler(Looper.getMainLooper());
        if (TextUtils.isEmpty(str)) {
            handler.post(new Runnable() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass26 */

                public final void run() {
                    PluginError pluginError = new PluginError(-98, "model is null");
                    o0000Oo.onFailure(pluginError);
                    ftg.O000000o("installPlugin fail1", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }
            });
            return;
        }
        try {
            O00000Oo().installPlugin(str, z, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    if (o0000Oo != null) {
                        bundle.setClassLoader(DownloadPluginResult.class.getClassLoader());
                        final InstallPluginResult installPluginResult = (InstallPluginResult) bundle.getParcelable("result");
                        if (installPluginResult.f6735O000000o == 1) {
                            handler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54.AnonymousClass1 */

                                public final void run() {
                                    o0000Oo.onStart(installPluginResult.O00000Oo);
                                }
                            });
                        } else if (installPluginResult.f6735O000000o == 2) {
                            handler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54.AnonymousClass2 */

                                public final void run() {
                                    o0000Oo.onSuccess(installPluginResult.O00000Oo);
                                }
                            });
                        } else if (installPluginResult.f6735O000000o == 4) {
                            handler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54.AnonymousClass3 */

                                public final void run() {
                                    PluginError pluginError = new PluginError(-6, "");
                                    o0000Oo.onFailure(pluginError);
                                    ftg.O000000o("installPlugin fail3", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                                }
                            });
                        } else {
                            handler.post(new Runnable() {
                                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54.AnonymousClass4 */

                                public final void run() {
                                    PluginError pluginError = new PluginError(-1, "unknown error");
                                    o0000Oo.onFailure(pluginError);
                                    ftg.O000000o("installPlugin fail4", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                                }
                            });
                        }
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(PluginError.class.getClassLoader());
                    final PluginError pluginError = (PluginError) bundle.getParcelable("error");
                    if (o0000Oo != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass54.AnonymousClass5 */

                            public final void run() {
                                o0000Oo.onFailure(pluginError);
                                ftg.O000000o("installPlugin fail5", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                            }
                        });
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(O0000Oo0 o0000Oo0) {
        final Handler handler = new Handler(Looper.getMainLooper());
        final gpr gpr = new gpr(o0000Oo0);
        try {
            O00000Oo().updateRnSdk(10058, new IClientCallback.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass55 */

                public void onSuccess(final Bundle bundle) throws RemoteException {
                    if (gpr.f18128O000000o != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass55.AnonymousClass1 */

                            public final void run() {
                                bundle.setClassLoader(DownloadRnSdkResult.class.getClassLoader());
                                ((O0000Oo0) gpr.f18128O000000o).onSuccess((DownloadRnSdkResult) bundle.getParcelable("result"));
                            }
                        });
                    }
                }

                public void onFailure(final Bundle bundle) throws RemoteException {
                    if (gpr.f18128O000000o != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass55.AnonymousClass2 */

                            public final void run() {
                                bundle.setClassLoader(DownloadRnSdkResult.class.getClassLoader());
                                ((O0000Oo0) gpr.f18128O000000o).onFailure((DownloadRnSdkResult) bundle.getParcelable("error"));
                            }
                        });
                    }
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(String str, PluginDownloadTask pluginDownloadTask) {
        final Handler handler = new Handler(Looper.getMainLooper());
        try {
            O00000Oo().cancelPluginDownload(str, pluginDownloadTask, new IClientCallback.Stub(null) {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass57 */

                public void onSuccess(Bundle bundle) throws RemoteException {
                    if (null != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass57.AnonymousClass1 */

                            public final void run() {
                            }
                        });
                    }
                }

                public void onFailure(Bundle bundle) throws RemoteException {
                    bundle.setClassLoader(fso.class.getClassLoader());
                    final PluginError pluginError = (PluginError) bundle.getParcelable("error");
                    if (null != null) {
                        handler.post(new Runnable() {
                            /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass57.AnonymousClass2 */

                            public final void run() {
                            }
                        });
                    }
                    ftg.O000000o("cancelPluginDownload fail", new fso(pluginError.f6718O000000o, pluginError.O00000Oo));
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final PluginPackageInfo O0000Oo(String str) {
        if (MockRnDevicePluginManager.getInstance().modelIsMockModel(str)) {
            return MockRnDevicePluginManager.getInstance().getMockPluginPackageInfo(str);
        }
        if (this.O0000OOo) {
            return fkl.O000000o().O00000Oo(str);
        }
        try {
            return O00000Oo().getInstallPackageInfo(str);
        } catch (Throwable th) {
            gsy.O00000o0(LogType.DEVICE_LIST, "CoreApi", Log.getStackTraceString(th));
            return null;
        }
    }

    public final PluginPackageInfo O00000o0(long j) {
        try {
            return O00000Oo().getPluginInstalledPackageInfo(j);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final PluginPackageInfo O0000OoO(String str) {
        if (this.O0000OOo) {
            return fkl.O000000o().O00000o0(str);
        }
        try {
            return O00000Oo().getDownloadPackageInfo(str);
        } catch (Throwable th) {
            gsy.O00000o0(LogType.DEVICE_LIST, "CoreApi", Log.getStackTraceString(th));
            return null;
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public final void O000000o(String str, String str2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("referer", str2);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(StatType.EVENT, "page_start", jSONObject.toString(), (String) null, false);
        O000000o(StatType.EVENT, "PageStart", jSONObject.toString(), (String) null, false);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void
     arg types: [com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, ?[OBJECT, ARRAY], int]
     candidates:
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, boolean, long, long):int
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(android.content.Context, com.xiaomi.smarthome.core.entity.net.NetRequest, _m_j.fss, com.xiaomi.smarthome.core.entity.net.Crypto, _m_j.fsm):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, _m_j.fsm<org.json.JSONObject, _m_j.fso>, boolean):_m_j.fsn
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String, com.xiaomi.smarthome.core.server.internal.bluetooth.security.SecureConnectOptions, _m_j.gle):com.xiaomi.smarthome.core.server.internal.bluetooth.security.ISecureConnectHandler
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(java.lang.String, java.lang.String, java.lang.String[], boolean, com.xiaomi.smarthome.core.client.IClientCallback):void
      com.xiaomi.smarthome.frame.core.CoreApi.O000000o(com.xiaomi.smarthome.core.entity.statistic.StatType, java.lang.String, java.lang.String, java.lang.String, boolean):void */
    public final void O000000o(String str, String str2, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("name", str);
            jSONObject.put("referer", str2);
            jSONObject.put("starttime", i);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        O000000o(StatType.EVENT, "page_end", jSONObject.toString(), (String) null, false);
        O000000o(StatType.EVENT, "PageEnd", jSONObject.toString(), (String) null, false);
    }

    public final void O000000o(StatType statType, String str, String str2, String str3, boolean z) {
        O000000o(statType, "mihome", str, str2, str3, z);
    }

    public final boolean O00000Oo(String str, boolean z) {
        try {
            return O00000Oo().postStatRecord(str, z);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final String O000000o(long j, long j2) {
        try {
            return O00000Oo().takeStatSession(j, j2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void O000000o(StatType statType, String str, String str2, String str3, String str4, boolean z) {
        try {
            O00000Oo().addStatRecord(statType, str, str2, str3, str4, z);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000O0Oo() {
        try {
            O00000Oo().uploadStat();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O00oOoOo() {
        try {
            O00000Oo().forceUpdateScene();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000O0o0() {
        try {
            O00000Oo().resetCore();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(SearchRequest searchRequest, final SearchResponse searchResponse) {
        try {
            O00000Oo().searchBluetoothDevice(searchRequest, new SearchResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass60 */

                public void onSearchStarted() throws RemoteException {
                    CoreApi.this.O00000o.post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass60.AnonymousClass1 */

                        public final void run() {
                            try {
                                if (searchResponse != null) {
                                    searchResponse.onSearchStarted();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                public void onDeviceFounded(final SearchResult searchResult) throws RemoteException {
                    CoreApi.this.O00000o.post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass60.AnonymousClass2 */

                        public final void run() {
                            try {
                                if (searchResponse != null) {
                                    searchResponse.onDeviceFounded(searchResult);
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                public void onSearchStopped() throws RemoteException {
                    CoreApi.this.O00000o.post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass60.AnonymousClass3 */

                        public final void run() {
                            try {
                                if (searchResponse != null) {
                                    searchResponse.onSearchStopped();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }

                public void onSearchCanceled() throws RemoteException {
                    CoreApi.this.O00000o.post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass60.AnonymousClass4 */

                        public final void run() {
                            try {
                                if (searchResponse != null) {
                                    searchResponse.onSearchCanceled();
                                }
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000O0o() {
        try {
            O00000Oo().stopSearchBluetoothDevice();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(String str, int i, Bundle bundle, final IBleResponse iBleResponse) {
        try {
            O00000Oo().callBluetoothApi(str, i, bundle, new BluetoothResponse() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass62 */

                public void onResponse(final int i, final Bundle bundle) throws RemoteException {
                    CoreApi.this.O00000o.post(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass62.AnonymousClass1 */

                        public final void run() {
                            if (iBleResponse != null) {
                                try {
                                    if (bundle != null) {
                                        bundle.setClassLoader(getClass().getClassLoader());
                                    }
                                    iBleResponse.onResponse(i, bundle);
                                } catch (Throwable th) {
                                    gnk.O00000Oo(gnk.O00000Oo(th));
                                }
                            }
                        }
                    });
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final String O000O0oO() {
        try {
            return O00000Oo().getBluetoothGatewayDevices();
        } catch (RemoteException e) {
            e.printStackTrace();
            return new JSONArray().toString();
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return new JSONArray().toString();
        }
    }

    public final byte[] O000000o(String str, byte[] bArr) {
        try {
            return O00000Oo().miotBleEncryptSync(str, bArr);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
            return null;
        }
    }

    public final byte[] O00000Oo(String str, byte[] bArr) {
        try {
            return O00000Oo().miotBleDecryptSync(str, bArr);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
            return null;
        }
    }

    public final IBleChannelWriter O000000o(String str, IBleChannelReader iBleChannelReader) throws RemoteException {
        try {
            return O00000Oo().registerSecureAuthChannelReader(str, iBleChannelReader);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
            return null;
        }
    }

    public final ISecureConnectHandler O000000o(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().secureConnect(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass65 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass65.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass65.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass65.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass65.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O00000Oo(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().securityChipConnect(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass66 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass66.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass66.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass66.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass66.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O000000o(String str, String str2, String str3, int i, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().securityChipPincodeConnect(str, str2, str3, i, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass67 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass67.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass67.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass67.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass67.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O00000o0(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().securityChipSharedDeviceConnect(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass68 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass68.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass68.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass68.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass68.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O00000o(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().bleMeshBind(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass69 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass69.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass69.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass69.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass69.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O000000o(String str, String str2, String str3, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().bleMeshConnect(str, str2, str3, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass70 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass70.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass70.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass70.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass70.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O00000oO(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().bleStandardAuthBind(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass71 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass71.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass71.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass71.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass71.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O00000oo(String str, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().bleStandardAuthConnect(str, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass72 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass72.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass72.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass72.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass72.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final ISecureConnectHandler O000000o(String str, BleComboWifiConfig bleComboWifiConfig, SecureConnectOptions secureConnectOptions, final gle gle) {
        try {
            return O00000Oo().bleComboStandardAuth(str, bleComboWifiConfig, secureConnectOptions, new ISecureConnectResponse.Stub() {
                /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass73 */

                public void onConnectResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass73.AnonymousClass1 */

                        public final void run() {
                            try {
                                gle.O000000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onAuthResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass73.AnonymousClass2 */

                        public final void run() {
                            try {
                                gle.O00000Oo(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onBindResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass73.AnonymousClass3 */

                        public final void run() {
                            try {
                                gle.O00000o0(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }

                public void onLastResponse(final int i, final Bundle bundle) throws RemoteException {
                    if (bundle != null) {
                        bundle.setClassLoader(getClass().getClassLoader());
                    }
                    glc.O000000o(new Runnable() {
                        /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass73.AnonymousClass4 */

                        public final void run() {
                            try {
                                gle.O00000o(i, bundle);
                            } catch (Throwable th) {
                                gnk.O00000Oo(gnk.O00000Oo(th));
                            }
                        }
                    }, 0);
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void O000000o(String str, int i, Bundle bundle) {
        try {
            O00000Oo().getBluetoothCache(str, i, bundle);
            bundle.setClassLoader(getClass().getClassLoader());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O00000Oo(String str, int i, Bundle bundle) {
        try {
            O00000Oo().setBluetoothCache(str, i, bundle);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void O000000o(String str, String str2, String[] strArr, boolean z, IClientCallback iClientCallback) {
        try {
            O00000Oo().uploadLogFile(str, str2, strArr, z, iClientCallback);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
        }
    }

    public static class CoreNotReadyException extends Exception {
        public CoreNotReadyException(String str) {
            super(str);
        }
    }

    class O000O0OO {

        /* renamed from: O000000o  reason: collision with root package name */
        long f7519O000000o;
        int O00000Oo;
        WeakReference<fsn> O00000o0;

        private O000O0OO() {
        }

        /* synthetic */ O000O0OO(CoreApi coreApi, byte b) {
            this();
        }
    }

    class O000O00o {

        /* renamed from: O000000o  reason: collision with root package name */
        long f7518O000000o;
        int O00000Oo;
        WeakReference<fsn> O00000o0;

        private O000O00o() {
        }

        /* synthetic */ O000O00o(CoreApi coreApi, byte b) {
            this();
        }
    }

    public final boolean O000000o(String str, int i, boolean z) {
        try {
            return O00000Oo().setAlertConfigs(str, i, z);
        } catch (Throwable th) {
            gnk.O00000Oo(gnk.O00000Oo(th));
            return false;
        }
    }

    public final IClassicBtRequest O000O0oo() {
        try {
            return O00000Oo().getClassicBtRequestImpl();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final HomeDeviceInfo O0000Ooo(String str) {
        try {
            return O00000Oo().getSharedHomeDeviceInfo(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final String O00000o0(int i) {
        try {
            return O00000Oo().finishProcess(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return "";
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public final int O00000o(int i) {
        try {
            return O00000Oo().startAction(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public final int O000000o(String str, String str2, boolean z, long j, long j2) {
        try {
            O00000Oo().downloadCloudVideoIntoCloudSetting(str, str2, z, j, j2);
            return 0;
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static boolean O000OO00() {
        return O0000o0;
    }

    public final boolean O0000o00(String str) {
        try {
            return O00000Oo().is6OptimizeBleLoginConnectModel(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final int O0000o0(String str) {
        try {
            return O00000Oo().get6OptimizeBleLoginConnectRetryDelay(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 2000;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return 2000;
        }
    }

    public final boolean O0000o0O(String str) {
        try {
            return O00000Oo().is13OptimizeBleLoginConnectModel(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final int O0000o0o(String str) {
        try {
            return O00000Oo().get13OptimizeBleLoginConnectRetryDelay(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 2000;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return 2000;
        }
    }

    public final boolean O0000o(String str) {
        try {
            return O00000Oo().needSecurityChipCheck(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public final int O000OO0o() {
        try {
            return O00000Oo().getOptimizeBleLoginConnectRetryTimes();
        } catch (RemoteException e) {
            e.printStackTrace();
            return 1;
        } catch (CoreNotReadyException e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    public static String O00000Oo(String str) {
        DeviceStat O00000o2 = fcx.f16092O000000o.O00000o(str);
        if (O00000o2 != null) {
            return O00000o2.model;
        }
        return null;
    }
}
