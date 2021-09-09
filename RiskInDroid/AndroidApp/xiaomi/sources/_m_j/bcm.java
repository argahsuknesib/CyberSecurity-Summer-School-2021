package _m_j;

import com.iheartradio.m3u8.data.PlaylistType;
import java.util.List;
import java.util.Objects;

public final class bcm {

    /* renamed from: O000000o  reason: collision with root package name */
    public final List<bct> f12860O000000o;
    public final List<String> O00000Oo;
    public final int O00000o;
    public final int O00000o0;
    public final boolean O00000oO;
    public final boolean O00000oo;
    public final PlaylistType O0000O0o;
    public final bcq O0000OOo;

    /* synthetic */ bcm(List list, List list2, int i, bcq bcq, int i2, boolean z, boolean z2, PlaylistType playlistType, byte b) {
        this(list, list2, i, bcq, i2, z, z2, playlistType);
    }

    private bcm(List<bct> list, List<String> list2, int i, bcq bcq, int i2, boolean z, boolean z2, PlaylistType playlistType) {
        this.f12860O000000o = bcg.O000000o(list);
        this.O00000Oo = bcg.O000000o(list2);
        this.O00000o0 = i;
        this.O00000o = i2;
        this.O00000oO = z;
        this.O00000oo = z2;
        this.O0000OOo = bcq;
        this.O0000O0o = playlistType;
    }

    public final boolean O000000o() {
        return this.O0000OOo != null;
    }

    public final int hashCode() {
        return Objects.hash(this.f12860O000000o, this.O00000Oo, Integer.valueOf(this.O00000o0), Integer.valueOf(this.O00000o), Boolean.valueOf(this.O00000oO), Boolean.valueOf(this.O00000oo), this.O0000O0o, this.O0000OOo);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof bcm)) {
            return false;
        }
        bcm bcm = (bcm) obj;
        if (!Objects.equals(this.f12860O000000o, bcm.f12860O000000o) || !Objects.equals(this.O00000Oo, bcm.O00000Oo) || this.O00000o0 != bcm.O00000o0 || this.O00000o != bcm.O00000o || this.O00000oO != bcm.O00000oO || this.O00000oo != bcm.O00000oo || !Objects.equals(this.O0000O0o, bcm.O0000O0o) || !Objects.equals(this.O0000OOo, bcm.O0000OOo)) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return "(MediaPlaylist mTracks=" + this.f12860O000000o + " mUnknownTags=" + this.O00000Oo + " mTargetDuration=" + this.O00000o0 + " mMediaSequenceNumber=" + this.O00000o + " mIsIframesOnly=" + this.O00000oO + " mIsOngoing=" + this.O00000oo + " mPlaylistType=" + this.O0000O0o + " mStartData=" + this.O0000OOo + ")";
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public List<bct> f12861O000000o;
        public List<String> O00000Oo;
        public int O00000o;
        public int O00000o0;
        public boolean O00000oO;
        public boolean O00000oo;
        public PlaylistType O0000O0o;
        public bcq O0000OOo;

        public final bcm O000000o() {
            return new bcm(this.f12861O000000o, this.O00000Oo, this.O00000o0, this.O0000OOo, this.O00000o, this.O00000oO, this.O00000oo, this.O0000O0o, (byte) 0);
        }
    }
}
