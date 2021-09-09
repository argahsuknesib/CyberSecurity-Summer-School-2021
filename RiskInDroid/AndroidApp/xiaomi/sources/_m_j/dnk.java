package _m_j;

import android.util.Log;

public class dnk extends dno {
    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, float f, float f2) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, float f, int i) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, float f, String str) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, int i, float f) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, int i, int i2) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, int i, String str) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, String str, float f) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, String str, int i) {
    }

    /* access modifiers changed from: protected */
    public void O000000o(dmx dmx, String str, String str2) {
    }

    /* access modifiers changed from: protected */
    public final int O000000o(dmx dmx, dmx dmx2) {
        if (this.O00000o.size() > 0) {
            for (Object next : this.O00000o) {
                Object O000000o2 = this.O0000Oo0.O000000o(next, this.O00000oO);
                if (O000000o2 != null) {
                    dmx dmx3 = new dmx();
                    if (O000000o2 instanceof Integer) {
                        int i = dmx2.O00000Oo;
                        if (i == 1) {
                            O000000o(dmx3, ((Integer) O000000o2).intValue(), dmx2.O000000o());
                        } else if (i == 2) {
                            O000000o(dmx3, ((Integer) O000000o2).intValue(), dmx2.O00000Oo());
                        } else if (i == 3) {
                            O000000o(dmx3, ((Integer) O000000o2).intValue(), dmx2.O00000o0());
                        }
                    } else if (O000000o2 instanceof Float) {
                        int i2 = dmx2.O00000Oo;
                        if (i2 == 1) {
                            O000000o(dmx3, ((Float) O000000o2).floatValue(), dmx2.O000000o());
                        } else if (i2 == 2) {
                            O000000o(dmx3, ((Float) O000000o2).floatValue(), dmx2.O00000Oo());
                        } else if (i2 == 3) {
                            O000000o(dmx3, ((Float) O000000o2).floatValue(), dmx2.O00000o0());
                        }
                    } else if (O000000o2 instanceof String) {
                        int i3 = dmx2.O00000Oo;
                        if (i3 == 1) {
                            O000000o(dmx3, (String) O000000o2, dmx2.O000000o());
                        } else if (i3 == 2) {
                            O000000o(dmx3, (String) O000000o2, dmx2.O00000Oo());
                        } else if (i3 == 3) {
                            O000000o(dmx3, (String) O000000o2, dmx2.O00000o0());
                        }
                    } else {
                        Log.e("ComEqExecutor_TMTEST", "var type invalidate:".concat(String.valueOf(O000000o2)));
                    }
                    this.O0000Oo0.O000000o(next, this.O00000oO, dmx3);
                } else {
                    Log.e("ComEqExecutor_TMTEST", "result value is empty:".concat(String.valueOf(O000000o2)));
                }
            }
            return 1;
        }
        Log.e("ComEqExecutor_TMTEST", "obj is empty");
        return 2;
    }
}
