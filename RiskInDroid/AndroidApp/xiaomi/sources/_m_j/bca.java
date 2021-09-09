package _m_j;

import com.iheartradio.m3u8.PlaylistError;
import com.iheartradio.m3u8.data.MediaType;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public final class bca {

    /* renamed from: O000000o  reason: collision with root package name */
    final Set<PlaylistError> f12847O000000o;

    private bca(Set<PlaylistError> set) {
        this.f12847O000000o = Collections.unmodifiableSet(set);
    }

    public final String toString() {
        return "(PlaylistValidation valid=" + O000000o() + " errors=" + this.f12847O000000o + ")";
    }

    public final boolean O000000o() {
        return this.f12847O000000o.isEmpty();
    }

    public static bca O000000o(bcn bcn, bbx bbx) {
        HashSet hashSet = new HashSet();
        if (bcn == null) {
            hashSet.add(PlaylistError.NO_PLAYLIST);
            return new bca(hashSet);
        }
        if (bcn.O00000o <= 0) {
            hashSet.add(PlaylistError.COMPATIBILITY_TOO_LOW);
        }
        if (O000000o(bcn)) {
            hashSet.add(PlaylistError.NO_MASTER_OR_MEDIA);
        } else if (O00000Oo(bcn)) {
            hashSet.add(PlaylistError.BOTH_MASTER_AND_MEDIA);
        }
        if (bcn.O000000o()) {
            if (!bcn.O00000o0) {
                hashSet.add(PlaylistError.MASTER_NOT_EXTENDED);
            }
            O000000o(bcn.f12862O000000o, hashSet);
        }
        if (bcn.O00000Oo()) {
            O000000o(bcn.O00000Oo, hashSet, bcn.O00000o0, bbx);
        }
        return new bca(hashSet);
    }

    private static boolean O000000o(bcn bcn) {
        return !bcn.O000000o() && !bcn.O00000Oo();
    }

    private static boolean O00000Oo(bcn bcn) {
        return bcn.O000000o() && bcn.O00000Oo();
    }

    private static void O000000o(bcm bcm, Set<PlaylistError> set, boolean z, bbx bbx) {
        if (z && bcm.O000000o() && Float.isNaN(bcm.O0000OOo.f12867O000000o)) {
            set.add(PlaylistError.START_DATA_WITHOUT_TIME_OFFSET);
        }
        for (bct next : bcm.f12860O000000o) {
            if (next.f12871O000000o == null || next.f12871O000000o.isEmpty()) {
                set.add(PlaylistError.TRACK_DATA_WITHOUT_URI);
            }
            if (z && !next.O000000o()) {
                set.add(PlaylistError.EXTENDED_TRACK_DATA_WITHOUT_TRACK_INFO);
            }
            if (next.O00000Oo() && next.O00000o0.f12852O000000o == null) {
                set.add(PlaylistError.ENCRYPTION_DATA_WITHOUT_METHOD);
            }
            if (next.O000000o() && !bbx.O00000o && next.O00000Oo.f12873O000000o < 0.0f) {
                set.add(PlaylistError.TRACK_INFO_WITH_NEGATIVE_DURATION);
            }
        }
    }

    private static void O000000o(bck bck, Set<PlaylistError> set) {
        for (bco next : bck.f12856O000000o) {
            if (next.f12864O000000o == null || next.f12864O000000o.isEmpty()) {
                set.add(PlaylistError.PLAYLIST_DATA_WITHOUT_URI);
            }
            if (next.O000000o()) {
                if (next.O00000Oo.f12869O000000o == -1) {
                    set.add(PlaylistError.STREAM_INFO_WITH_NO_BANDWIDTH);
                }
                if (next.O00000Oo.O00000Oo < -1) {
                    set.add(PlaylistError.STREAM_INFO_WITH_INVALID_AVERAGE_BANDWIDTH);
                }
            }
        }
        for (bci next2 : bck.O00000Oo) {
            if (next2.O00000o0 == null || next2.O00000o0.isEmpty()) {
                set.add(PlaylistError.I_FRAME_STREAM_WITHOUT_URI);
            }
            if (next2.f12854O000000o == -1) {
                set.add(PlaylistError.I_FRAME_STREAM_WITH_NO_BANDWIDTH);
            }
            if (next2.O00000Oo < -1) {
                set.add(PlaylistError.I_FRAME_STREAM_WITH_INVALID_AVERAGE_BANDWIDTH);
            }
        }
        for (bcl next3 : bck.O00000o0) {
            if (next3.f12858O000000o == null) {
                set.add(PlaylistError.MEDIA_DATA_WITHOUT_TYPE);
            }
            if (next3.O00000o0 == null) {
                set.add(PlaylistError.MEDIA_DATA_WITHOUT_GROUP_ID);
            }
            if (next3.O00000oo == null) {
                set.add(PlaylistError.MEDIA_DATA_WITHOUT_NAME);
            }
            if (next3.f12858O000000o == MediaType.CLOSED_CAPTIONS) {
                if (next3.O000000o()) {
                    set.add(PlaylistError.CLOSE_CAPTIONS_WITH_URI);
                }
                if (next3.O0000Oo == null) {
                    set.add(PlaylistError.CLOSE_CAPTIONS_WITHOUT_IN_STREAM_ID);
                }
            } else if (!(next3.f12858O000000o == MediaType.CLOSED_CAPTIONS || next3.O0000Oo == null)) {
                set.add(PlaylistError.IN_STREAM_ID_WITHOUT_CLOSE_CAPTIONS);
            }
            if (next3.O0000O0o && !next3.O0000OOo) {
                set.add(PlaylistError.DEFAULT_WITHOUT_AUTO_SELECT);
            }
            if (next3.f12858O000000o != MediaType.SUBTITLES && next3.O0000Oo0) {
                set.add(PlaylistError.FORCED_WITHOUT_SUBTITLES);
            }
        }
    }
}
