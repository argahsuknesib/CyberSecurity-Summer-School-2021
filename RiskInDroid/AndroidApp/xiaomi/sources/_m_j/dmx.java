package _m_j;

import android.util.Log;

public final class dmx {
    private static dnd O00000o0 = dnd.O000000o();

    /* renamed from: O000000o  reason: collision with root package name */
    public dnc f14798O000000o;
    public int O00000Oo = 0;

    private static void O000000o(int i, dnc dnc) {
        if (dnc == null) {
            return;
        }
        if (i == 1) {
            O00000o0.f14804O000000o.add((dmz) dnc);
        } else if (i == 2) {
            O00000o0.O00000Oo.add((dmy) dnc);
        } else if (i == 3) {
            O00000o0.O00000o0.add((dnb) dnc);
        } else if (i == 4) {
            O00000o0.O00000o.add((dna) dnc);
        }
    }

    public final boolean O000000o(Object obj) {
        if (obj instanceof Integer) {
            O000000o(((Integer) obj).intValue());
            return true;
        } else if (obj instanceof Float) {
            O000000o(((Float) obj).floatValue());
            return true;
        } else if (obj instanceof String) {
            O000000o((String) obj);
            return true;
        } else {
            O00000Oo(obj);
            return true;
        }
    }

    public final int O000000o() {
        if (1 == this.O00000Oo) {
            return ((dmz) this.f14798O000000o).f14800O000000o;
        }
        return 0;
    }

    public final float O00000Oo() {
        if (2 == this.O00000Oo) {
            return ((dmy) this.f14798O000000o).f14799O000000o;
        }
        return 0.0f;
    }

    public final String O00000o0() {
        if (3 == this.O00000Oo) {
            return ((dnb) this.f14798O000000o).f14803O000000o;
        }
        return null;
    }

    public final Object O00000o() {
        if (4 == this.O00000Oo) {
            return ((dna) this.f14798O000000o).f14802O000000o;
        }
        return null;
    }

    public final void O000000o(int i) {
        int i2 = this.O00000Oo;
        if (1 != i2) {
            O000000o(i2, this.f14798O000000o);
            this.O00000Oo = 1;
            this.f14798O000000o = O00000o0.O000000o(i);
            return;
        }
        ((dmz) this.f14798O000000o).f14800O000000o = i;
    }

    public final void O000000o(float f) {
        int i = this.O00000Oo;
        if (2 != i) {
            O000000o(i, this.f14798O000000o);
            this.O00000Oo = 2;
            this.f14798O000000o = O00000o0.O000000o(f);
            return;
        }
        ((dmy) this.f14798O000000o).f14799O000000o = f;
    }

    public final void O000000o(String str) {
        int i = this.O00000Oo;
        if (3 != i) {
            O000000o(i, this.f14798O000000o);
            this.O00000Oo = 3;
            this.f14798O000000o = O00000o0.O000000o(str);
            return;
        }
        ((dnb) this.f14798O000000o).f14803O000000o = str;
    }

    public final void O00000Oo(Object obj) {
        int i = this.O00000Oo;
        if (4 != i) {
            O000000o(i, this.f14798O000000o);
            this.O00000Oo = 4;
            this.f14798O000000o = O00000o0.O000000o(obj);
            return;
        }
        ((dna) this.f14798O000000o).f14802O000000o = obj;
    }

    public final void O000000o(dmx dmx) {
        if (dmx != null) {
            int i = dmx.O00000Oo;
            if (i == this.O00000Oo) {
                this.f14798O000000o.O000000o(dmx.f14798O000000o);
                return;
            }
            this.O00000Oo = i;
            this.f14798O000000o = dmx.f14798O000000o.clone();
            return;
        }
        Log.e("Data_TMTEST", "copy failed");
    }

    public final String toString() {
        int i = this.O00000Oo;
        if (i == 1) {
            return String.format("type:int value:" + this.f14798O000000o, new Object[0]);
        } else if (i == 2) {
            return String.format("type:float value:" + this.f14798O000000o, new Object[0]);
        } else if (i == 3) {
            return String.format("type:string value:" + this.f14798O000000o, new Object[0]);
        } else if (i != 4) {
            return "type:none";
        } else {
            return String.format("type:object value:" + this.f14798O000000o, new Object[0]);
        }
    }
}
