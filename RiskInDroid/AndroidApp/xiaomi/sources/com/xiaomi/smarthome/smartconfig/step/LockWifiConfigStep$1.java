package com.xiaomi.smarthome.smartconfig.step;

import _m_j.hwk;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;

public class LockWifiConfigStep$1 implements IBleChannelReader {
    final /* synthetic */ hwk this$0;

    public IBinder asBinder() {
        return null;
    }

    public void onRead(String str, byte[] bArr, int i) throws RemoteException {
    }

    public LockWifiConfigStep$1(hwk hwk) {
        this.this$0 = hwk;
    }
}
