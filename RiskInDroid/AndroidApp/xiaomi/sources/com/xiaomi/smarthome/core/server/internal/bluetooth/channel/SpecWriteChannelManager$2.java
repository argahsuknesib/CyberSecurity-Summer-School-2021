package com.xiaomi.smarthome.core.server.internal.bluetooth.channel;

import _m_j.fez;
import _m_j.gnk;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;

public class SpecWriteChannelManager$2 implements IBleResponse {
    final /* synthetic */ fez this$0;
    final /* synthetic */ String val$mac;
    final /* synthetic */ byte[] val$originValue;

    public IBinder asBinder() {
        return null;
    }

    public SpecWriteChannelManager$2(fez fez, String str, byte[] bArr) {
        this.this$0 = fez;
        this.val$mac = str;
        this.val$originValue = bArr;
    }

    public void onResponse(int i, Bundle bundle) throws RemoteException {
        Object[] objArr = new Object[3];
        objArr[0] = "SpecChannelManager";
        objArr[1] = Integer.valueOf(i);
        objArr[2] = bundle == null ? null : bundle.toString();
        gnk.O000000o("%s, send onResponse,code %d, data=%s", objArr);
        fez.O000000o(this.val$mac, this.val$originValue, i);
    }
}
