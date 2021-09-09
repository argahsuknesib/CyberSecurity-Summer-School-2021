package com.ximalaya.ting.android.opensdk.player;

import _m_j.ikd;
import android.os.Message;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.model.advertis.Advertis;
import com.ximalaya.ting.android.opensdk.model.advertis.AdvertisList;
import com.ximalaya.ting.android.opensdk.player.service.IXmAdsEventDispatcher;

public class XmPlayerManager$4 extends IXmAdsEventDispatcher.Stub {
    final /* synthetic */ ikd this$0;

    public XmPlayerManager$4(ikd ikd) {
        this.this$0 = ikd;
    }

    public void onStartPlayAds(Advertis advertis, int i) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(16);
        obtainMessage.arg1 = i;
        obtainMessage.obj = advertis;
        obtainMessage.sendToTarget();
    }

    public void onStartGetAdsInfo() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(12).sendToTarget();
    }

    public void onGetAdsInfo(AdvertisList advertisList) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(13);
        obtainMessage.obj = advertisList;
        obtainMessage.sendToTarget();
    }

    public void onError(int i, int i2) throws RemoteException {
        Message obtainMessage = this.this$0.O00000oO.obtainMessage(18);
        obtainMessage.arg1 = i;
        obtainMessage.arg2 = i2;
        obtainMessage.sendToTarget();
    }

    public void onCompletePlayAds() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(17).sendToTarget();
    }

    public void onAdsStopBuffering() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(15).sendToTarget();
    }

    public void onAdsStartBuffering() throws RemoteException {
        this.this$0.O00000oO.obtainMessage(14).sendToTarget();
    }
}
