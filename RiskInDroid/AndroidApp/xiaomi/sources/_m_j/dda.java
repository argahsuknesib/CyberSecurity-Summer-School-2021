package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.device.BleDevice;
import java.util.Iterator;

public final class dda {
    public static boolean O000000o(BleDevice bleDevice) {
        if (bleDevice == null || bleDevice.O00000Oo() == null || bleDevice.O00000Oo().f6871O000000o == null || ((!TextUtils.equals(bleDevice.model, "ninebot.scooter.v1") && !TextUtils.equals(bleDevice.model, "ninebot.scooter.v2")) || bleDevice.O00000Oo().f6871O000000o.O0000Oo0 < 5)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x0012 A[Catch:{ Exception -> 0x001e }] */
    public static MiotBleAdvPacket O000000o(byte[] bArr) {
        fgb fgb = new fgb(bArr);
        MiotBleAdvPacket miotBleAdvPacket = null;
        try {
            Iterator<fga> it = fgb.f16254O000000o.iterator();
            while (it.hasNext() && (miotBleAdvPacket = fgc.O000000o(it.next())) == null) {
                while (it.hasNext()) {
                    while (it.hasNext()) {
                    }
                }
            }
        } catch (Exception unused) {
        }
        return miotBleAdvPacket;
    }
}
