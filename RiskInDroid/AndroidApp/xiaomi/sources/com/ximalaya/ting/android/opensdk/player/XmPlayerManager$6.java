package com.ximalaya.ting.android.opensdk.player;

import _m_j.ikd;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.IXmDataCallback;
import java.util.List;

public class XmPlayerManager$6 extends IXmDataCallback.Stub {
    final /* synthetic */ ikd this$0;

    public XmPlayerManager$6(ikd ikd) {
        this.this$0 = ikd;
    }

    public void onDataReady(List<Track> list, boolean z, boolean z2) throws RemoteException {
        if (this.this$0.O0000oOO != null) {
            this.this$0.O0000oOO.onDataReady(list, z, z2);
        }
    }

    public void onError(int i, String str, boolean z) throws RemoteException {
        if (this.this$0.O0000oOO != null) {
            this.this$0.O0000oOO.onError(i, str, z);
        }
    }
}
