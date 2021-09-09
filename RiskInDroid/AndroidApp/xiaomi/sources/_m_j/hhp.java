package _m_j;

import android.util.SparseArray;
import android.util.SparseBooleanArray;

public final class hhp {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f18952O000000o;
    public int O00000Oo;
    public boolean O00000o;
    public int O00000o0;
    public O000000o O00000oO;
    private SparseBooleanArray O00000oo = new SparseBooleanArray();
    private SparseArray<Float> O0000O0o = new SparseArray<>();
    private int O0000OOo;
    private float O0000Oo0;

    public interface O000000o {
        void O000000o(int i, int i2);

        void O000000o(int i, int i2, float f, boolean z);

        void O00000Oo(int i, int i2);

        void O00000Oo(int i, int i2, float f, boolean z);
    }

    public final void O000000o(int i, float f) {
        boolean z;
        float f2 = ((float) i) + f;
        boolean z2 = this.O0000Oo0 <= f2;
        if (this.O00000o0 == 0) {
            for (int i2 = 0; i2 < this.f18952O000000o; i2++) {
                if (i2 != this.O00000Oo) {
                    if (!this.O00000oo.get(i2)) {
                        O00000o(i2);
                    }
                    if (this.O0000O0o.get(i2, Float.valueOf(0.0f)).floatValue() != 1.0f) {
                        O00000Oo(i2, 1.0f, false, true);
                    }
                }
            }
            O000000o(this.O00000Oo, 1.0f, false, true);
            O00000o0(this.O00000Oo);
        } else if (f2 != this.O0000Oo0) {
            int i3 = i + 1;
            if (f != 0.0f || !z2) {
                z = true;
            } else {
                i3 = i - 1;
                z = false;
            }
            for (int i4 = 0; i4 < this.f18952O000000o; i4++) {
                if (!(i4 == i || i4 == i3 || this.O0000O0o.get(i4, Float.valueOf(0.0f)).floatValue() == 1.0f)) {
                    O00000Oo(i4, 1.0f, z2, true);
                }
            }
            if (!z) {
                float f3 = 1.0f - f;
                O00000Oo(i3, f3, true, false);
                O000000o(i, f3, true, false);
            } else if (z2) {
                O00000Oo(i, f, true, false);
                O000000o(i3, f, true, false);
            } else {
                float f4 = 1.0f - f;
                O00000Oo(i3, f4, false, false);
                O000000o(i, f4, false, false);
            }
        } else {
            return;
        }
        this.O0000Oo0 = f2;
    }

    private void O000000o(int i, float f, boolean z, boolean z2) {
        if (this.O00000o || i == this.O00000Oo || this.O00000o0 == 1 || z2) {
            O000000o o000000o = this.O00000oO;
            if (o000000o != null) {
                o000000o.O000000o(i, this.f18952O000000o, f, z);
            }
            this.O0000O0o.put(i, Float.valueOf(1.0f - f));
        }
    }

    private void O00000Oo(int i, float f, boolean z, boolean z2) {
        if (!(this.O00000o || i == this.O0000OOo || this.O00000o0 == 1)) {
            int i2 = this.O00000Oo;
            if ((!(i == i2 - 1 || i == i2 + 1) || this.O0000O0o.get(i, Float.valueOf(0.0f)).floatValue() == 1.0f) && !z2) {
                return;
            }
        }
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O00000Oo(i, this.f18952O000000o, f, z);
        }
        this.O0000O0o.put(i, Float.valueOf(f));
    }

    private void O00000o0(int i) {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O000000o(i, this.f18952O000000o);
        }
        this.O00000oo.put(i, false);
    }

    private void O00000o(int i) {
        O000000o o000000o = this.O00000oO;
        if (o000000o != null) {
            o000000o.O00000Oo(i, this.f18952O000000o);
        }
        this.O00000oo.put(i, true);
    }

    public final void O000000o(int i) {
        this.O0000OOo = this.O00000Oo;
        this.O00000Oo = i;
        O00000o0(this.O00000Oo);
        for (int i2 = 0; i2 < this.f18952O000000o; i2++) {
            if (i2 != this.O00000Oo && !this.O00000oo.get(i2)) {
                O00000o(i2);
            }
        }
    }

    public final void O00000Oo(int i) {
        this.f18952O000000o = i;
        this.O00000oo.clear();
        this.O0000O0o.clear();
    }
}
