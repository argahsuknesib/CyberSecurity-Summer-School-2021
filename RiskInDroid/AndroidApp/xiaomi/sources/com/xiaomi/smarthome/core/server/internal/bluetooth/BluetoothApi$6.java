package com.xiaomi.smarthome.core.server.internal.bluetooth;

import _m_j.fdy;
import _m_j.ffr;
import android.os.RemoteException;
import com.xiaomi.smarthome.core.server.bluetooth.IBleChannelWriter;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.ChannelManager;
import com.xiaomi.smarthome.core.server.internal.bluetooth.channel.IPCChannelManager;
import com.xiaomi.smarthome.device.bluetooth.security.BLECipher;

public class BluetoothApi$6 extends ChannelManager.BleChannelReader {
    public final void onRead(String str, byte[] bArr, int i) throws RemoteException {
        if (i == 0) {
            byte[] O000000o2 = BLECipher.O000000o(ffr.O0000o0o(str), bArr);
            IBleChannelWriter O00000o = IPCChannelManager.O00000Oo().O00000o(str);
            if (O00000o != null) {
                fdy.O000000o(str, O000000o2, O00000o);
            }
        }
    }
}
