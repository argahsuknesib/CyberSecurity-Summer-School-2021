package _m_j;

import com.xiaomi.smarthome.core.entity.device.RouterDevice;

public final class fji {

    /* renamed from: O000000o  reason: collision with root package name */
    public static int f16477O000000o = 2;
    public static final String[] O00000Oo = {"xiaomi.router.v1", "xiaomi.router.mv1", "xiaomi.router.v2", "xiaomi.router.lv1", "xiaomi.router.v3", "xiaomi.router.lv3"};
    private static Object O00000oO = new Object();
    private static volatile fji O00000oo;
    volatile boolean O00000o = false;
    volatile RouterDevice O00000o0 = null;

    public static fji O000000o() {
        if (O00000oo == null) {
            synchronized (O00000oO) {
                if (O00000oo == null) {
                    O00000oo = new fji();
                }
            }
        }
        return O00000oo;
    }

    public final synchronized void O00000Oo() {
        if (!fdc.O000000o().O0000o0()) {
            if (!this.O00000o) {
                this.O00000o = true;
                this.O00000o = false;
                if (this.O00000o0 != null) {
                    fjd.O000000o().O00000Oo(this.O00000o0);
                }
                this.O00000o0 = null;
            }
        }
    }
}
