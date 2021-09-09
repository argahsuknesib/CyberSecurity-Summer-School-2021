package com.xiaomi.smarthome.core.server.internal.bluetooth.mesh;

import _m_j.ffq;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class MeshDfuManager$13 implements IBleResponse {
    final /* synthetic */ ffq this$0;
    final /* synthetic */ ffq.O0000O0o val$callback;

    public IBinder asBinder() {
        return null;
    }

    public MeshDfuManager$13(ffq ffq, ffq.O0000O0o o0000O0o) {
        this.this$0 = ffq;
        this.val$callback = o0000O0o;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        if (i != 0) {
            this.this$0.O0000OoO = null;
            this.val$callback.O000000o(ffq.O00000oO(i), "channel write failed");
        }
    }
}
