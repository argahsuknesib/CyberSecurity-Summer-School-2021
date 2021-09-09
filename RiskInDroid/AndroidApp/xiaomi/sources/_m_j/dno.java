package _m_j;

import android.util.Log;
import java.util.HashSet;
import java.util.Set;

public class dno extends dnh {
    protected Set<Object> O00000o = new HashSet();
    protected int O00000oO;

    public final void O000000o() {
        super.O000000o();
    }

    public final int O000000o(Object obj) {
        dmx dmx;
        int O000000o2 = super.O000000o(obj);
        byte O000000o3 = this.O0000Oo.O000000o();
        if (O000000o3 == 0) {
            O00000o0();
            dmx = O000000o(0);
            this.O00000Oo = this.O0000Oo.O000000o();
        } else if (O000000o3 == 1) {
            O00000o0();
            dmx = O000000o(1);
            this.O00000Oo = this.O0000Oo.O000000o();
        } else if (O000000o3 == 2) {
            O00000o0();
            dmx = O000000o(2);
            this.O00000Oo = this.O0000Oo.O000000o();
        } else if (O000000o3 == 3) {
            O00000o0();
            dmx = O000000o(3);
            this.O00000Oo = this.O0000Oo.O000000o();
        } else if (O000000o3 != 4) {
            dmx = null;
        } else {
            O00000o0();
            dmx = O000000o(4);
        }
        if (dmx == null) {
            return O000000o2;
        }
        dmx O000000o4 = this.O0000OoO.O000000o(this.O00000Oo);
        if (O000000o4 != null) {
            return O000000o(O000000o4, dmx);
        }
        Log.e("EqualExecutor_TMTEST", "result register is null");
        return O000000o2;
    }

    /* access modifiers changed from: protected */
    public int O000000o(dmx dmx, dmx dmx2) {
        dmx.O000000o(dmx2);
        if (this.O00000o.size() > 0) {
            for (Object O000000o2 : this.O00000o) {
                this.O0000Oo0.O000000o(O000000o2, this.O00000oO, dmx2);
            }
            return 1;
        }
        Log.e("EqualExecutor_TMTEST", "obj is empty");
        return 2;
    }

    private boolean O00000o0() {
        Set<Object> O00000Oo = O00000Oo();
        if (O00000Oo != null) {
            this.O00000o.clear();
            this.O00000o.addAll(O00000Oo);
            this.O00000oO = this.O0000Oo.O00000Oo();
            return true;
        }
        Log.e("EqualExecutor_TMTEST", "load var failed");
        return true;
    }
}
