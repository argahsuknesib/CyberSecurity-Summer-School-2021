package _m_j;

import android.util.Log;

public final class dnl extends dnk {
    /* access modifiers changed from: protected */
    public final void O000000o(dmx dmx, int i, int i2) {
        if (i2 == 0) {
            Log.e("DivEqExecutor", "div zero");
        }
        dmx.O000000o(i / i2);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(dmx dmx, int i, float f) {
        dmx.O000000o(((float) i) / f);
    }

    /* access modifiers changed from: protected */
    public final void O000000o(dmx dmx, float f, int i) {
        if (i == 0) {
            Log.e("DivEqExecutor", "div zero");
        }
        dmx.O000000o(f / ((float) i));
    }

    /* access modifiers changed from: protected */
    public final void O000000o(dmx dmx, float f, float f2) {
        dmx.O000000o(f / f2);
    }
}
