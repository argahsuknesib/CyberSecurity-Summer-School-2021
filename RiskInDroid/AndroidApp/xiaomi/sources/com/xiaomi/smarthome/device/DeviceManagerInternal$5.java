package com.xiaomi.smarthome.device;

import _m_j.exo;
import _m_j.fmj;
import _m_j.fso;
import _m_j.gpd;
import _m_j.gsy;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.client.IClientCallback;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.device.ScanState;
import com.xiaomi.smarthome.library.log.LogType;

public class DeviceManagerInternal$5 implements IClientCallback {
    final /* synthetic */ fmj this$0;
    final /* synthetic */ boolean val$useCache;

    public IBinder asBinder() {
        return null;
    }

    public DeviceManagerInternal$5(fmj fmj, boolean z) {
        this.this$0 = fmj;
        this.val$useCache = z;
    }

    public void onSuccess(Bundle bundle) throws RemoteException {
        bundle.setClassLoader(ScanState.class.getClassLoader());
        int i = bundle.getInt("result");
        gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "scanDeviceList onSuccess result=".concat(String.valueOf(i)));
        exo stateNotifier = ServiceApplication.getStateNotifier();
        if (stateNotifier != null && stateNotifier.f15923O000000o == 4) {
            gsy.O00000Oo(LogType.DEVICE_LIST, "DeviceManagerInternal", "scanDeviceList onSucces, result = ".concat(String.valueOf(i)));
            if (i == ScanState.LOAD_CACHE_SUCCESS.ordinal() || i == ScanState.SYNC_SERVER_SUCCESS.ordinal() || i == ScanState.SCAN_LOCAL_SUCCESS.ordinal()) {
                LogType logType = LogType.DEVICE_LIST;
                gsy.O00000Oo(logType, "DeviceManagerInternal", "scanDeviceList, useCache = " + this.val$useCache + ", mCacheDevicesDirty = " + this.this$0.O00000oO);
                LogType logType2 = LogType.DEVICE_LIST;
                gsy.O00000Oo(logType2, "DeviceManagerInternal", "performance:scan complete takes " + (System.currentTimeMillis() - this.this$0.O00oOooO) + "ms");
                this.this$0.O00000oO();
                return;
            } else if (i != ScanState.SYNC_SERVER_FAILED.ordinal()) {
                return;
            }
        }
        this.this$0.O00000o();
    }

    public void onFailure(Bundle bundle) throws RemoteException {
        bundle.setClassLoader(fso.class.getClassLoader());
        Error error = (Error) bundle.getParcelable("error");
        gsy.O00000o0(LogType.DEVICE_LIST, "DeviceManagerInternal", "scanDeviceList onFailure, error = ".concat(String.valueOf(new fso(error.f6718O000000o, error.O00000Oo))));
        gpd.O000000o();
        this.this$0.O00000oo.post(new Runnable() {
            /* class com.xiaomi.smarthome.device.DeviceManagerInternal$5.AnonymousClass1 */

            public final void run() {
                DeviceManagerInternal$5.this.this$0.O00000o();
            }
        });
    }
}
