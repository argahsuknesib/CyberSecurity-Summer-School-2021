package _m_j;

import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.List;

public class fny {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final String f16729O000000o = "fny";
    private static volatile fny O00000o0;
    public O000000o O00000Oo = new O000000o(this, (byte) 0);
    private volatile boolean O00000o = false;
    private int O00000oO = 3;

    private fny() {
    }

    public static fny O000000o() {
        if (O00000o0 == null) {
            synchronized (fny.class) {
                if (O00000o0 == null) {
                    O00000o0 = new fny();
                }
            }
        }
        return O00000o0;
    }

    public static boolean O000000o(String str) {
        Device O000000o2;
        PluginDeviceInfo O00000oO2;
        if (ftn.O00000Oo(CoreApi.O000000o().O0000ooO()) || (O000000o2 = fno.O000000o().O000000o(str)) == null || (O00000oO2 = CoreApi.O000000o().O00000oO(O000000o2.model)) == null) {
            return false;
        }
        if (O00000oO2.O0000ooo() == 1 || O00000oO2.O0000ooo() == 2) {
            return true;
        }
        return false;
    }

    public class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<fnx> f16730O000000o;

        private O000000o() {
            this.f16730O000000o = new ArrayList();
        }

        /* synthetic */ O000000o(fny fny, byte b) {
            this();
        }
    }
}
