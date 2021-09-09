package _m_j;

import java.util.Objects;

public final class bcn {

    /* renamed from: O000000o  reason: collision with root package name */
    public final bck f12862O000000o;
    public final bcm O00000Oo;
    public final int O00000o;
    public final boolean O00000o0;

    /* synthetic */ bcn(bck bck, bcm bcm, boolean z, int i, byte b) {
        this(bck, bcm, z, i);
    }

    private bcn(bck bck, bcm bcm, boolean z, int i) {
        this.f12862O000000o = bck;
        this.O00000Oo = bcm;
        this.O00000o0 = z;
        this.O00000o = i;
    }

    public final boolean O000000o() {
        return this.f12862O000000o != null;
    }

    public final boolean O00000Oo() {
        return this.O00000Oo != null;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.O00000o), Boolean.valueOf(this.O00000o0), this.f12862O000000o, this.O00000Oo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcn)) {
            return false;
        }
        bcn bcn = (bcn) obj;
        if (!Objects.equals(this.f12862O000000o, bcn.f12862O000000o) || !Objects.equals(this.O00000Oo, bcn.O00000Oo) || this.O00000o0 != bcn.O00000o0 || this.O00000o != bcn.O00000o) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "(Playlist mMasterPlaylist=" + this.f12862O000000o + " mMediaPlaylist=" + this.O00000Oo + " mIsExtended=" + this.O00000o0 + " mCompatibilityVersion=" + this.O00000o + ")";
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public bck f12863O000000o;
        public bcm O00000Oo;
        public int O00000o = 1;
        public boolean O00000o0;

        public final bcn O000000o() {
            return new bcn(this.f12863O000000o, this.O00000Oo, this.O00000o0, this.O00000o, (byte) 0);
        }
    }
}
