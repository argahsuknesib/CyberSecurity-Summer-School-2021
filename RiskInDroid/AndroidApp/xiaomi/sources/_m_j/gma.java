package _m_j;

import android.os.Bundle;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleConnectResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleReadRssiResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleRequestMtuResponse;
import com.xiaomi.smarthome.library.bluetooth.connect.response.BleResponse;

public final class gma implements BleResponse<Bundle> {

    /* renamed from: O000000o  reason: collision with root package name */
    public BleResponse f18010O000000o;

    private gma(BleResponse bleResponse) {
        this.f18010O000000o = bleResponse;
    }

    public static gma O000000o(BleResponse bleResponse) {
        return new gma(bleResponse);
    }

    /* renamed from: O000000o */
    public final void onResponse(int i, Bundle bundle) {
        BleResponse bleResponse = this.f18010O000000o;
        if (bleResponse != null) {
            if (bleResponse instanceof BleConnectResponse) {
                bleResponse.onResponse(i, bundle);
                return;
            }
            byte[] bArr = null;
            if (bleResponse instanceof BleReadResponse) {
                if (bundle != null) {
                    bArr = bundle.getByteArray("key_bytes");
                }
                bleResponse.onResponse(i, bArr);
            } else if (bleResponse instanceof BleReadRssiResponse) {
                bleResponse.onResponse(i, Integer.valueOf(bundle != null ? bundle.getInt("key_rssi") : 0));
            } else if (bleResponse instanceof BleRequestMtuResponse) {
                bleResponse.onResponse(i, Integer.valueOf(bundle != null ? bundle.getInt("key_mtu") : 23));
            } else {
                bleResponse.onResponse(i, null);
            }
        }
    }
}
