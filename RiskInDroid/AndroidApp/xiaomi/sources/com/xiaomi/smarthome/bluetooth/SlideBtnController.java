package com.xiaomi.smarthome.bluetooth;

import android.os.RemoteException;
import android.text.TextUtils;
import com.xiaomi.smarthome.bluetooth.ISlideBtnController;

public abstract class SlideBtnController extends ISlideBtnController.Stub {
    private ISlideBtnViewer mSlideBtnViewer;

    public final void attachSlideBtnViewer(ISlideBtnViewer iSlideBtnViewer) throws RemoteException {
        this.mSlideBtnViewer = iSlideBtnViewer;
    }

    public final void detachSlideBtnViewer() throws RemoteException {
        this.mSlideBtnViewer = null;
    }

    public void setChecked(String str, boolean z) {
        if (this.mSlideBtnViewer != null && !TextUtils.isEmpty(str)) {
            try {
                this.mSlideBtnViewer.setChecked(str, z);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }
}
