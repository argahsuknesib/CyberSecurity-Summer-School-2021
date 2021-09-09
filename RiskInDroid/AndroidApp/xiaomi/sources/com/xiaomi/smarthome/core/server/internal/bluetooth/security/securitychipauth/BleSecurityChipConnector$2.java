package com.xiaomi.smarthome.core.server.internal.bluetooth.security.securitychipauth;

import _m_j.fhd;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;

public class BleSecurityChipConnector$2 implements IBleChannelReader {
    final /* synthetic */ fhd this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleSecurityChipConnector$2(fhd fhd) {
        this.this$0 = fhd;
    }

    public void onRead(String str, byte[] bArr, int i) throws RemoteException {
        this.this$0.O000000o(bArr, i);
    }
}
