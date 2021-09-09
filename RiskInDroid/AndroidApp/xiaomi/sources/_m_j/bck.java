package _m_j;

import java.util.List;
import java.util.Objects;

public final class bck {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<bco> f12856O000000o;
    public final List<bci> O00000Oo;
    public final List<String> O00000o;
    public final List<bcl> O00000o0;

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<bco> f12857O000000o;
        public List<bci> O00000Oo;
        public List<String> O00000o;
        public List<bcl> O00000o0;
    }

    public /* synthetic */ bck(List list, List list2, List list3, List list4, byte b) {
        this(list, list2, list3, list4);
    }

    private bck(List<bco> list, List<bci> list2, List<bcl> list3, List<String> list4) {
        this.f12856O000000o = bcg.O000000o(list);
        this.O00000Oo = bcg.O000000o(list2);
        this.O00000o0 = bcg.O000000o(list3);
        this.O00000o = bcg.O000000o(list4);
    }

    public final int hashCode() {
        return Objects.hash(this.O00000o0, this.f12856O000000o, this.O00000Oo, this.O00000o);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bck)) {
            return false;
        }
        bck bck = (bck) obj;
        if (!Objects.equals(this.O00000o0, bck.O00000o0) || !Objects.equals(this.f12856O000000o, bck.f12856O000000o) || !Objects.equals(this.O00000Oo, bck.O00000Oo) || !Objects.equals(this.O00000o, bck.O00000o)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "(MasterPlaylist mPlaylists=" + this.f12856O000000o.toString() + " mIFramePlaylists=" + this.O00000Oo.toString() + " mMediaData=" + this.O00000o0.toString() + " mUnknownTags=" + this.O00000o.toString() + ")";
    }
}
