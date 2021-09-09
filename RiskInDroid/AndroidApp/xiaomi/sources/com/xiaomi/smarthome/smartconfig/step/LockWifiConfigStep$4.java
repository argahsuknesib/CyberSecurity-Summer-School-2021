package com.xiaomi.smarthome.smartconfig.step;

import _m_j.gmc;
import _m_j.hwk;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class LockWifiConfigStep$4 implements IBleResponse {
    final /* synthetic */ hwk this$0;

    public IBinder asBinder() {
        return null;
    }

    public LockWifiConfigStep$4(hwk hwk) {
        this.this$0 = hwk;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Handler x_;
        hwk hwk = this.this$0;
        hwk.O000000o(" sendWifiConfig onResponse: " + gmc.O000000o(i), new Object[0]);
        if (i != 0 && (x_ = this.this$0.x_()) != null) {
            x_.removeMessages(114);
            x_.sendEmptyMessageDelayed(114, 5000);
        }
    }
}
