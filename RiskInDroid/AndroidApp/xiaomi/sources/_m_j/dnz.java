package _m_j;

import android.util.Log;

public final class dnz extends dnj {
    /* access modifiers changed from: protected */
    public final int O000000o(dmx dmx, int i, int i2) {
        if (i2 == 0) {
            Log.e("ModeExecutor_TMTEST", "div zero");
            return 2;
        }
        dmx.O000000o(i % i2);
        return 1;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(dmx dmx, int i, float f) {
        dmx.O000000o(((float) i) % f);
        return 1;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(dmx dmx, float f, int i) {
        if (i == 0) {
            Log.e("ModeExecutor_TMTEST", "div zero");
            return 2;
        }
        dmx.O000000o(f % ((float) i));
        return 1;
    }

    /* access modifiers changed from: protected */
    public final int O000000o(dmx dmx, float f, float f2) {
        dmx.O000000o(f % f2);
        return 1;
    }
}
