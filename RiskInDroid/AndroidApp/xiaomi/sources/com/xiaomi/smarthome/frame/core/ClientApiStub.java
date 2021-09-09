package com.xiaomi.smarthome.frame.core;

import _m_j.ft;
import _m_j.ftb;
import _m_j.gfr;
import _m_j.gsy;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.client.IClientApi;
import com.xiaomi.smarthome.core.entity.message.CoreMessageType;
import com.xiaomi.smarthome.core.server.IServerCallback;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.server_compact.ServerBean;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Locale;

public class ClientApiStub extends IClientApi.Stub {
    public static volatile long sOnCoreReadyTime;
    private Context mAppContext;
    private ftb mCoreHostApi;

    public ClientApiStub(Context context, ftb ftb) {
        this.mAppContext = context;
        this.mCoreHostApi = ftb;
    }

    public void onAccountReady(boolean z, String str) throws RemoteException {
        if (gfr.O0000Ooo) {
            gsy.O00000Oo(LogType.STARTUP, "login", "ClientApiStub onAccountReady isMiLoggedIn=".concat(String.valueOf(z)));
        }
        CoreApi O000000o2 = CoreApi.O000000o();
        if (gfr.O0000Ooo) {
            LogType logType = LogType.STARTUP;
            gsy.O00000Oo(logType, "login", "CoreApi onAccountReady isMiLoggedIn=" + z + "," + str);
        }
        synchronized (O000000o2.O0000o0o) {
            O000000o2.O0000o = Boolean.valueOf(z);
        }
        synchronized (O000000o2.O0000oO0) {
            O000000o2.O0000oO = str;
        }
        synchronized (CoreApi.f7432O000000o) {
            O000000o2.O0000Oo = true;
        }
        ft O000000o3 = ft.O000000o(this.mAppContext);
        Intent intent = new Intent("CoreApi.onAccountReadyInternal");
        intent.putExtra("isMiLoggedIn", z);
        intent.putExtra("miId", str);
        O000000o3.O000000o(intent);
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O000000o();
        }
    }

    public void onGlobalDynamicSettingReady() throws RemoteException {
        CoreApi O000000o2 = CoreApi.O000000o();
        synchronized (CoreApi.f7432O000000o) {
            O000000o2.O0000OoO = true;
        }
        ft.O000000o(this.mAppContext).O000000o(new Intent("CoreApi.onGlobalDynamicSettingReadyInternal"));
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O00000Oo();
        }
    }

    public void onStatisticReady() throws RemoteException {
        CoreApi O000000o2 = CoreApi.O000000o();
        synchronized (CoreApi.f7432O000000o) {
            O000000o2.O0000Ooo = true;
        }
        ft.O000000o(this.mAppContext).O000000o(new Intent("CoreApi.onStatisticReadyInternal"));
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O00000o0();
        }
    }

    public void onPluginReady() throws RemoteException {
        CoreApi O000000o2 = CoreApi.O000000o();
        synchronized (CoreApi.f7432O000000o) {
            O000000o2.O0000o00 = true;
        }
        ft.O000000o(this.mAppContext).O000000o(new Intent("CoreApi.onPluginReadyInternal"));
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O00000o();
        }
    }

    public void onCoreReady() throws RemoteException {
        gsy.O00000Oo("ClientApiStub", "onCoreReady");
        sOnCoreReadyTime = System.currentTimeMillis();
        CoreApi O000000o2 = CoreApi.O000000o();
        if (gfr.O0000Ooo) {
            LogType logType = LogType.STARTUP;
            gsy.O00000Oo(logType, "CoreApi", "onCoreReady isMain=" + gfr.O00oOooO);
        }
        synchronized (CoreApi.f7432O000000o) {
            CoreApi.O0000o0 = true;
            if (!O000000o2.O0000oo0.isEmpty()) {
                new Handler(Looper.getMainLooper()).post(new Runnable(System.currentTimeMillis()) {
                    /* class com.xiaomi.smarthome.frame.core.CoreApi.AnonymousClass16 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ long f7440O000000o;

                    {
                        this.f7440O000000o = r2;
                    }

                    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0032, code lost:
                        r0 = r8.O00000Oo.O0000oo0.size() - 1;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003c, code lost:
                        if (r0 < 0) goto L_0x0050;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003e, code lost:
                        r1 = r8.O00000Oo.O0000oo0.get(r0);
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
                        if (r1 == null) goto L_0x004d;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004a, code lost:
                        r1.onCoreReady();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
                        r0 = r0 - 1;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
                        r8.O00000Oo.O0000oo0.clear();
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0059, code lost:
                        if (_m_j.gfr.O00oOooO == false) goto L_?;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005d, code lost:
                        if (_m_j.gfr.O0000Ooo == false) goto L_?;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:23:0x005f, code lost:
                        _m_j.gsy.O00000Oo(com.xiaomi.smarthome.library.log.LogType.STARTUP, "CoreApi", "notifyCoreReadyCallback handler run end main");
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:34:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
                        return;
                     */
                    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
                        return;
                     */
                    public final void run() {
                        synchronized (CoreApi.f7432O000000o) {
                            if (gfr.O00oOooO && gfr.O0000Ooo) {
                                gsy.O00000Oo(LogType.STARTUP, "CoreApi", "notifyCoreReadyCallback handler in main " + (System.currentTimeMillis() - this.f7440O000000o));
                            }
                            if (!CoreApi.this.O0000O0o()) {
                            }
                        }
                    }
                });
            }
        }
        ft.O000000o(this.mAppContext).O000000o(new Intent("CoreApi.onCoreReadyInternal"));
        CoreApi O000000o3 = CoreApi.O000000o();
        synchronized (CoreApi.f7432O000000o) {
            O000000o3.O0000o0O = true;
        }
        ft.O000000o(this.mAppContext).O000000o(new Intent("CoreApi.onPluginCacheReadyInternal"));
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O00000oO();
        }
    }

    public void refreshServiceToken(String str, String str2, boolean z, String str3, IServerCallback iServerCallback) throws RemoteException {
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O000000o(str, str2, z, str3, iServerCallback);
        }
    }

    public void onUnAuthorized() throws RemoteException {
        CoreApi.O000000o().O0000o00();
        CoreApi.O000000o().O0000o0o();
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O00000oo();
        }
    }

    public void onCoreMessage(CoreMessageType coreMessageType, Bundle bundle) throws RemoteException {
        if (coreMessageType.ordinal() == CoreMessageType.UPDATE_DEVICE_LIST.ordinal()) {
            Intent intent = new Intent("update_device_list_action");
            bundle.setClassLoader(Device.class.getClassLoader());
            intent.putExtra("params", bundle);
            ft.O000000o(this.mAppContext).O000000o(intent);
        }
    }

    public void onServerChanged(ServerBean serverBean, ServerBean serverBean2) throws RemoteException {
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O0000O0o();
        }
    }

    public void onLocaleChanged(Bundle bundle, Bundle bundle2) throws RemoteException {
        if (this.mCoreHostApi != null) {
            this.mCoreHostApi.O000000o((Locale) bundle.getSerializable("result"), (Locale) bundle2.getSerializable("result"));
        }
    }

    public void onPluginChanged(boolean z, boolean z2, String str) throws RemoteException {
        CoreApi.O000000o();
        CoreApi.O000000o(z, z2, str);
    }

    public void onActivityResume(int i, int i2, String str) throws RemoteException {
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O000000o(i, i2, str);
        }
    }

    public void onBleCharacterChanged(Bundle bundle) {
        ftb ftb = this.mCoreHostApi;
        if (ftb != null) {
            ftb.O000000o(bundle);
        }
    }
}
