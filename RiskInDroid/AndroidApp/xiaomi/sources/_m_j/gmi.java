package _m_j;

import com.xiaomi.smarthome.library.bluetooth.connect.listener.ReadRssiListener;

public final class gmi extends gmj implements ReadRssiListener {
    public gmi(gma gma) {
        super(gma);
    }

    public final void O000000o() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            O00000Oo(-1);
        } else if (currentStatus == 2) {
            O00000Oo();
        } else if (currentStatus != 19) {
            O00000Oo(-1);
        } else {
            O00000Oo();
        }
    }

    private void O00000Oo() {
        if (!readRemoteRssi()) {
            O00000Oo(-1);
        } else {
            O00000o0();
        }
    }

    public final void onReadRemoteRssi(int i, int i2) {
        O00000o();
        if (i2 == 0) {
            O000000o("key_rssi", i);
            O00000Oo(0);
            return;
        }
        O00000Oo(-1);
    }
}
