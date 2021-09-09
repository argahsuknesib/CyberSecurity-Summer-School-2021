package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhi;
import _m_j.fte;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.bluetooth.XmBluetoothManager;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class BleSecurityChipRegister$4$1$1$1 implements IBleResponse {
    final /* synthetic */ fhi.AnonymousClass4.AnonymousClass1.AnonymousClass1 this$3;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipRegister$4$1$1$1(fhi.AnonymousClass4.AnonymousClass1.AnonymousClass1 r1) {
        this.this$3 = r1;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        fte.O00000Oo(" sendWifiConfig onResponse: " + XmBluetoothManager.Code.toString(i));
        r4.onResponse(i, bundle);
    }
}
