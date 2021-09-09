package _m_j;

import java.util.Objects;

public final class bco {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12864O000000o;
    public final bcr O00000Oo;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f12865O000000o;
        public bcr O00000Oo;
    }

    public /* synthetic */ bco(String str, bcr bcr, byte b) {
        this(str, bcr);
    }

    private bco(String str, bcr bcr) {
        this.f12864O000000o = str;
        this.O00000Oo = bcr;
    }

    public final boolean O000000o() {
        return this.O00000Oo != null;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(super.hashCode()), this.O00000Oo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bco)) {
            return false;
        }
        bco bco = (bco) obj;
        if (!super.equals(bco) || !Objects.equals(this.O00000Oo, bco.O00000Oo)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "PlaylistData [mStreamInfo=" + this.O00000Oo + ", mUri=" + this.f12864O000000o + "]";
    }
}
