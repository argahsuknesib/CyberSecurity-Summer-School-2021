package com.xiaomi.smarthome.core.server.internal.bluetooth.channel;

import _m_j.glh;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.bluetooth.IBleResponse;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;

class ChannelManager$BleChannel$1 extends IBleChannelWriter.Stub {
    final /* synthetic */ ChannelManager.O000000o this$0;

    ChannelManager$BleChannel$1(ChannelManager.O000000o o000000o) {
        this.this$0 = o000000o;
    }

    public void write(byte[] bArr, int i, final IBleResponse iBleResponse) throws RemoteException {
        this.this$0.O000000o(bArr, i, new glh() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager$BleChannel$1.AnonymousClass1 */

            public final void O000000o(int i) {
                try {
                    if (iBleResponse != null) {
                        iBleResponse.onResponse(i, null);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public void writeWithOpCode(int i, byte[] bArr, int i2, final IBleResponse iBleResponse) throws RemoteException {
        this.this$0.O000000o(i, bArr, i2, new glh() {
            /* class com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager$BleChannel$1.AnonymousClass2 */

            public final void O000000o(int i) {
                try {
                    if (iBleResponse != null) {
                        iBleResponse.onResponse(i, null);
                    }
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
