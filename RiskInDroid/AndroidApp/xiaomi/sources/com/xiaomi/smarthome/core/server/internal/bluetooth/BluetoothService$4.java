package com.xiaomi.smarthome.core.server.internal.bluetooth;

import _m_j.fec;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;

public class BluetoothService$4 implements IBleMeshUpgradeResponse {
    final /* synthetic */ fec this$0;
    final /* synthetic */ String val$did;
    final /* synthetic */ IBleMeshUpgradeResponse val$response;
    final /* synthetic */ String val$version;

    public IBinder asBinder() {
        return null;
    }

    public BluetoothService$4(fec fec, IBleMeshUpgradeResponse iBleMeshUpgradeResponse, String str, String str2) {
        this.this$0 = fec;
        this.val$response = iBleMeshUpgradeResponse;
        this.val$did = str;
        this.val$version = str2;
    }

    public void onProgress(int i) throws RemoteException {
        IBleMeshUpgradeResponse iBleMeshUpgradeResponse = this.val$response;
        if (iBleMeshUpgradeResponse != null) {
            iBleMeshUpgradeResponse.onProgress(i);
        }
    }

    public void onResponse(int i, String str) throws RemoteException {
        IBleMeshUpgradeResponse iBleMeshUpgradeResponse = this.val$response;
        if (iBleMeshUpgradeResponse != null) {
            iBleMeshUpgradeResponse.onResponse(i, str);
        }
        if (i == 0 && !TextUtils.isEmpty(this.val$did)) {
            TextUtils.isEmpty(this.val$version);
        }
    }

    public boolean isMeshDevice() throws RemoteException {
        IBleMeshUpgradeResponse iBleMeshUpgradeResponse = this.val$response;
        if (iBleMeshUpgradeResponse == null) {
            return false;
        }
        return iBleMeshUpgradeResponse.isMeshDevice();
    }
}
