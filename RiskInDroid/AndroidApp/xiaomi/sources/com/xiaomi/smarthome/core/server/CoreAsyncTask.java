package com.xiaomi.smarthome.core.server;

import _m_j.fcy;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.IServerHandle;

public abstract class CoreAsyncTask extends IServerHandle.Stub implements Runnable {
    public abstract void onCancel();

    public void execute() {
        fcy.O000000o();
        fcy.O000000o(this);
    }

    public final void cancel() throws RemoteException {
        onCancel();
    }
}
