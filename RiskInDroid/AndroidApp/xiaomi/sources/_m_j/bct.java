package _m_j;

import java.util.Objects;

public final class bct {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12871O000000o;
    public final bcu O00000Oo;
    public final boolean O00000o;
    public final bch O00000o0;
    private final String O00000oO;

    /* synthetic */ bct(String str, bcu bcu, bch bch, String str2, boolean z, byte b) {
        this(str, bcu, bch, str2, z);
    }

    private bct(String str, bcu bcu, bch bch, String str2, boolean z) {
        this.f12871O000000o = str;
        this.O00000Oo = bcu;
        this.O00000o0 = bch;
        this.O00000oO = str2;
        this.O00000o = z;
    }

    public final boolean O000000o() {
        return this.O00000Oo != null;
    }

    public final boolean O00000Oo() {
        return this.O00000o0 != null;
    }

    public final int hashCode() {
        return Objects.hash(this.f12871O000000o, this.O00000o0, this.O00000Oo, Boolean.valueOf(this.O00000o));
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bct)) {
            return false;
        }
        bct bct = (bct) obj;
        if (!Objects.equals(this.f12871O000000o, bct.f12871O000000o) || !Objects.equals(this.O00000Oo, bct.O00000Oo) || !Objects.equals(this.O00000o0, bct.O00000o0) || !Objects.equals(this.O00000oO, bct.O00000oO) || !Objects.equals(Boolean.valueOf(this.O00000o), Boolean.valueOf(bct.O00000o))) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "(TrackData mUri=" + this.f12871O000000o + " mTrackInfo=" + this.O00000Oo + " mEncryptionData=" + this.O00000o0 + " mProgramDateTime=" + this.O00000oO + " mHasDiscontinuity=" + this.O00000o + ")";
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f12872O000000o;
        public bcu O00000Oo;
        public String O00000o;
        public bch O00000o0;
        public boolean O00000oO;

        public final bct O000000o() {
            return new bct(this.f12872O000000o, this.O00000Oo, this.O00000o0, this.O00000o, this.O00000oO, (byte) 0);
        }
    }
}
