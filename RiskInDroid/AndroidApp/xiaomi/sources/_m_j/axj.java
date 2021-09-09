package _m_j;

public class axj {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f12681O000000o;
    public final int O00000Oo;

    /* access modifiers changed from: protected */
    public String O000000o() {
        return "ItemDraggableRange";
    }

    public axj(int i, int i2) {
        if (i <= i2) {
            this.f12681O000000o = i;
            this.O00000Oo = i2;
            return;
        }
        throw new IllegalArgumentException("end position (= " + i2 + ") is smaller than start position (=" + i + ")");
    }

    public final boolean O000000o(int i) {
        return i >= this.f12681O000000o && i <= this.O00000Oo;
    }

    public String toString() {
        return O000000o() + "{mStart=" + this.f12681O000000o + ", mEnd=" + this.O00000Oo + '}';
    }
}
