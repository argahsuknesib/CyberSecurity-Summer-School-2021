package _m_j;

import _m_j.dxr;
import _m_j.dya;
import android.os.Debug;
import java.util.Random;

public final class dyh extends dyo {

    /* renamed from: O000000o  reason: collision with root package name */
    public Runnable f15066O000000o = new Runnable() {
        /* class _m_j.dyh.AnonymousClass1 */

        public final void run() {
            if (dyh.this.O00000o0()) {
                if (!dzf.O000000o(dxr.O000000o.f15041O000000o.O00000Oo)) {
                    dzg.O000000o();
                    dzg.O000000o(dyh.this.f15066O000000o, 60000);
                } else if (dya.O000000o.f15057O000000o.O0000Oo0 == 0) {
                    Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
                    Debug.getMemoryInfo(memoryInfo);
                    dya.O000000o.f15057O000000o.O0000Oo0 = memoryInfo.getTotalPss();
                }
            }
        }
    };

    public final void O000000o() {
        try {
            super.O000000o();
            dzg.O000000o(this.f15066O000000o, (long) ((new Random().nextInt(5) + 1) * 60 * 1000));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
