package _m_j;

import java.util.Objects;

public final class bcq {

    /* renamed from: O000000o  reason: collision with root package name */
    public final float f12867O000000o;
    public final boolean O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public float f12868O000000o = Float.NaN;
        public boolean O00000Oo;
    }

    public bcq(float f, boolean z) {
        this.f12867O000000o = f;
        this.O00000Oo = z;
    }

    public final int hashCode() {
        return Objects.hash(Boolean.valueOf(this.O00000Oo), Float.valueOf(this.f12867O000000o));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcq)) {
            return false;
        }
        bcq bcq = (bcq) obj;
        if (this.O00000Oo == bcq.O00000Oo && this.f12867O000000o == bcq.f12867O000000o) {
            return true;
        }
        return false;
    }
}
