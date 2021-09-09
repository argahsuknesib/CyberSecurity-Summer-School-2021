package com.xiaomi.smarthome.core.server.internal.bluetooth.security.standardauth;

import _m_j.fis;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;

public class BleStandardAuthConnector$2 implements IBleChannelReader {
    final /* synthetic */ fis this$0;

    public IBinder asBinder() {
        return null;
    }

    public BleStandardAuthConnector$2(fis fis) {
        this.this$0 = fis;
    }

    public void onRead(String str, byte[] bArr, int i) throws RemoteException {
        this.this$0.O000000o(bArr, i);
    }
}
