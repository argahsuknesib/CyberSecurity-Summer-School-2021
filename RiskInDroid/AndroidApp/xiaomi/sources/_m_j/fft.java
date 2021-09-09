package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.core.server.internal.bluetooth.recognizer.beacon.MiotBleAdvPacket;
import com.xiaomi.smarthome.library.bluetooth.search.BluetoothSearchResult;
import java.util.Iterator;

public final class fft implements ffz {
    fft() {
    }

    public final ffw O000000o(BluetoothSearchResult bluetoothSearchResult) {
        fgb fgb;
        MiotBleAdvPacket O000000o2;
        ffw ffw = new ffw();
        if (!(bluetoothSearchResult.O00000o0 == null || (O000000o2 = O000000o((fgb = new fgb(bluetoothSearchResult.O00000o0)))) == null)) {
            if (O000000o2.O00000Oo > 0) {
                ffr.O00000Oo(bluetoothSearchResult.O000000o(), O000000o2.O00000Oo);
            }
            if (!TextUtils.isEmpty(O000000o2.O00000o)) {
                ffr.O0000OOo(bluetoothSearchResult.O000000o(), O000000o2.O00000o);
            }
            if (O000000o2.O000000o() && !TextUtils.isEmpty(O000000o2.O00000oo)) {
                gnk.O00000o0("BluetoothBeaconRecognizer addCombo, comboKey = " + O000000o2.O00000oo + ", address = " + bluetoothSearchResult.O000000o() + ", pid = " + O000000o2.O00000Oo);
                fee.O000000o(O000000o2.O00000oo, bluetoothSearchResult.O000000o());
                ffr.O00000oO(bluetoothSearchResult.O000000o(), 1);
            }
            if (O000000o2.f6871O000000o != null || O000000o2.O00000Oo == 91) {
                ffw.f16248O000000o = fec.O00000o0().O000000o(O000000o2.O00000Oo);
            }
            if (O000000o2.O00000Oo == 5662) {
                ffw.f16248O000000o = "yeelink.uwb.tag1";
            }
            gnk.O00000o0("BluetoothBeaconRecognizer productId=" + O000000o2.O00000Oo + ",model=" + ffw.f16248O000000o);
            if (!TextUtils.isEmpty(ffw.f16248O000000o)) {
                ffw.O00000o0 = O000000o2;
                ffw.O00000Oo = bluetoothSearchResult.O00000Oo;
                String O000000o3 = fgb.O000000o();
                if (!TextUtils.isEmpty(O000000o3)) {
                    ffr.O00000o0(bluetoothSearchResult.O000000o(), O000000o3);
                }
            }
        }
        return ffw;
    }

    /* JADX WARNING: Removed duplicated region for block: B:5:0x000d A[Catch:{ Exception -> 0x0019 }] */
    private static MiotBleAdvPacket O000000o(fgb fgb) {
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
