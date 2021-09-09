package com.inuker.bluetooth.library.connect.response;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.inuker.bluetooth.library.IResponse;

public abstract class BluetoothResponse extends IResponse.Stub implements Handler.Callback {
    private Handler mHandler;

    /* access modifiers changed from: protected */
    public abstract void onAsyncResponse(int i, Bundle bundle);

    protected BluetoothResponse() {
        if (Looper.myLooper() != null) {
            this.mHandler = new Handler(Looper.myLooper(), this);
            return;
        }
        throw new RuntimeException();
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        this.mHandler.obtainMessage(1, i, 0, bundle).sendToTarget();
    }

    public boolean handleMessage(Message message) {
        if (message.what == 1) {
            onAsyncResponse(message.arg1, (Bundle) message.obj);
        }
        return true;
    }
}
