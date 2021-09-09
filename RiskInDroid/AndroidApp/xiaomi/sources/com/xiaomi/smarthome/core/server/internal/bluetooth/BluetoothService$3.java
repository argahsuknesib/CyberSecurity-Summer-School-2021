package com.xiaomi.smarthome.core.server.internal.bluetooth;

import _m_j.fec;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleMeshUpgradeResponse;

public class BluetoothService$3 implements IBleMeshUpgradeResponse {
    final /* synthetic */ fec this$0;
    final /* synthetic */ IBleMeshUpgradeResponse val$response;

    public IBinder asBinder() {
        return null;
    }

    public BluetoothService$3(fec fec, IBleMeshUpgradeResponse iBleMeshUpgradeResponse) {
        this.this$0 = fec;
        this.val$response = iBleMeshUpgradeResponse;
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
    }

    public boolean isMeshDevice() throws RemoteException {
        IBleMeshUpgradeResponse iBleMeshUpgradeResponse = this.val$response;
        if (iBleMeshUpgradeResponse == null) {
            return false;
        }
        return iBleMeshUpgradeResponse.isMeshDevice();
    }
}
