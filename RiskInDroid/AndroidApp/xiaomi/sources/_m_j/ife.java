package _m_j;

public final class ife {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1257O000000o;
    public final int[] O00000Oo;
    public final idg[] O00000o0;

    public ife(int i, int[] iArr, int i2, int i3, int i4) {
        this.f1257O000000o = i;
        this.O00000Oo = iArr;
        float f = (float) i4;
        this.O00000o0 = new idg[]{new idg((float) i2, f), new idg((float) i3, f)};
    }

    public final boolean equals(Object obj) {
        if ((obj instanceof ife) && this.f1257O000000o == ((ife) obj).f1257O000000o) {
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return this.f1257O000000o;
    }
}
