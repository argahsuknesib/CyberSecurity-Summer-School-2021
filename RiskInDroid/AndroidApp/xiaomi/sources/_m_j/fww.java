package _m_j;

import android.os.HandlerThread;
import java.util.HashMap;

public final class fww {
    private static fww O00000oO;

    /* renamed from: O000000o  reason: collision with root package name */
    public HashMap<String, Object> f17335O000000o = new HashMap<>();
    HandlerThread O00000Oo = new HandlerThread("rn_camera_frame_receiver");
    public boolean O00000o = true;
    public int O00000o0 = 1;

    public static fww O000000o() {
        if (O00000oO == null) {
            O00000oO = new fww();
        }
        return O00000oO;
    }

    private fww() {
        this.O00000Oo.start();
    }

    public final void O000000o(gci gci) {
        gci.O000000o(this.O00000o);
        if (gci.O000000o()) {
            gci.O000000o(this.O00000o0);
            return;
        }
        gci.O000000o(this.O00000o0);
        gci.O00000Oo();
    }
}
