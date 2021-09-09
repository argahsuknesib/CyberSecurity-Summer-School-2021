package com.ximalaya.ting.android.opensdk.player;

import _m_j.iis;
import _m_j.iit;
import _m_j.ikd;
import android.os.RemoteException;
import com.ximalaya.ting.android.opensdk.player.service.IXmTokenInvalidForSDKCallBack;

public class XmPlayerManager$2 extends IXmTokenInvalidForSDKCallBack.Stub {
    final /* synthetic */ ikd this$0;

    public XmPlayerManager$2(ikd ikd) {
        this.this$0 = ikd;
    }

    public void tokenInvalid() throws RemoteException {
        iit.O00000o0 o00000o0 = iit.O000000o().O0000Oo;
        if (o00000o0 == null) {
            iis.O000000o().O00000o0();
        } else if (!o00000o0.O00000Oo()) {
            o00000o0.O00000o0();
        }
    }
}
