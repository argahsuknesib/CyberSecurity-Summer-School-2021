package com.xiaomi.smarthome.core.server.internal.bluetooth.channel;

import _m_j.fex;
import _m_j.fhe;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelReader;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;

public class SpecChannelManager$1 implements IBleChannelReader {
    final /* synthetic */ fex this$0;

    public IBinder asBinder() {
        return null;
    }

    public SpecChannelManager$1(fex fex) {
        this.this$0 = fex;
    }

    public void onRead(String str, byte[] bArr, int i) throws RemoteException {
        if (i == 0) {
            fhe.O00000Oo(str, bArr, new BleReadResponse(str) {
                /* class _m_j.fex.AnonymousClass1 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ String f16197O000000o;

                {
                    this.f16197O000000o = r2;
                }

                public final /* synthetic */ void onResponse(int i, Object obj) {
                    byte[] bArr = (byte[]) obj;
                    if (i == 0) {
                        gnk.O000000o("%s,decryptReceiveData success,value:%s", fex.O00000o, got.O00000o0(bArr));
                        fex.O000000o(this.f16197O000000o, bArr);
                        return;
                    }
                    gnk.O000000o("%s, decryptReceiveData fail,code %d", fex.O00000o, Integer.valueOf(i));
                }
            });
        }
    }
}
