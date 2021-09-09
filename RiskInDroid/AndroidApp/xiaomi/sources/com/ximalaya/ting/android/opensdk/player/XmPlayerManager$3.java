package com.ximalaya.ting.android.opensdk.player;

import _m_j.ikd;
import android.os.Message;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.IXmCommonBusinessDispatcher;

public class XmPlayerManager$3 extends IXmCommonBusinessDispatcher.Stub {
    final /* synthetic */ ikd this$0;

    public XmPlayerManager$3(ikd ikd) {
        this.this$0 = ikd;
    }

    public String getDownloadPlayPath(Track track) throws RemoteException {
        if (this.this$0.O0000o != null) {
            return this.this$0.O0000o.O000000o();
        }
        return null;
    }

    public void isOldTrackDownload(Track track) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(19);
        obtainMessage.obj = track;
        obtainMessage.sendToTarget();
    }

    public void closeApp() throws RemoteException {
        this.this$0.O00000oO.removeCallbacksAndMessages(null);
        this.this$0.O00000oO.obtainMessage(20).sendToTarget();
    }
}
