package com.ximalaya.ting.android.opensdk.player;

import _m_j.ikd;
import android.os.Message;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.track.Track;
import com.ximalaya.ting.android.opensdk.player.service.IXmPlayerEventDispatcher;
import com.ximalaya.ting.android.opensdk.player.service.XmPlayerException;

public class XmPlayerManager$5 extends IXmPlayerEventDispatcher.Stub {
    final /* synthetic */ ikd this$0;

    public XmPlayerManager$5(ikd ikd) {
        this.this$0 = ikd;
    }

    public void onSoundPrepared() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(5).sendToTarget();
    }

    public void onPlayStop() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(3).sendToTarget();
    }

    public void onPlayStart() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(1).sendToTarget();
    }

    public void onPlayProgress(int i, int i2) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(7);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.sendToTarget();
    }

    public void onPlayPause() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(2).sendToTarget();
    }

    public void onSoundPlayComplete() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(4).sendToTarget();
    }

    public void onError(XmPlayerException xmPlayerException) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(10);
        obtainMessage.obj = xmPlayerException;
        obtainMessage.sendToTarget();
    }

    public void onBufferProgress(int i) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(9);
        obtainMessage.arg1 = i;
        obtainMessage.sendToTarget();
    }

    public void onBufferingStart() throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(6);
        obtainMessage.obj = Boolean.TRUE;
        obtainMessage.sendToTarget();
    }

    public void onBufferingStop() throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(6);
        obtainMessage.obj = Boolean.FALSE;
        obtainMessage.sendToTarget();
    }

    public void onSoundSwitch(Track track, Track track2) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(8);
        obtainMessage.obj = new Object[]{track, track2};
        obtainMessage.sendToTarget();
    }
}
