package _m_j;

import com.xiaomi.smarthome.library.bluetooth.connect.listener.RequestMtuListener;

public final class gmk extends gmj implements RequestMtuListener {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f18017O000000o;

    public gmk(int i, gma gma) {
        super(gma);
        this.f18017O000000o = i;
    }

    public final void O000000o() {
        int currentStatus = getCurrentStatus();
        if (currentStatus == 0) {
            O00000Oo(-1);
        } else if (currentStatus == 2) {
            O00000o0(this.f18017O000000o);
        } else if (currentStatus != 19) {
            O00000Oo(-1);
        } else {
            O00000o0(this.f18017O000000o);
        }
    }

    private void O00000o0(int i) {
        if (!requestMtu(i)) {
            O00000Oo(-1);
        } else {
            O00000o0();
        }
    }

    public final void onMtuChanged(int i, int i2) {
        O00000o();
        if (i2 == 0) {
            O000000o("key_mtu", i);
            O00000Oo(0);
            return;
        }
        O00000Oo(-1);
    }
}
