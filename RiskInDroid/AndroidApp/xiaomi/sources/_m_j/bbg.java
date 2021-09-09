package _m_j;

import _m_j.bck;
import _m_j.bcm;
import _m_j.bcn;
import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

final class bbg extends bbc {
    private final Map<String, bbi> O00000o = new HashMap();
    private final bbx O00000o0;

    bbg(InputStream inputStream, Encoding encoding, bbx bbx) {
        super(inputStream, encoding);
        this.O00000o0 = bbx;
        O000000o(bbe.f12762O000000o, bbe.O00000o0, bbt.O00000o0, bbt.O00000o, bbt.O0000OoO, bbt.O00000oo, bbt.O00000oO, bbt.O0000O0o, bbt.O00000Oo, bbq.f12767O000000o, bbt.O0000OOo, bbq.O00000o0, bbq.O00000Oo, bbt.O0000Oo0, bbt.f12815O000000o, bbt.O0000Oo);
    }

    public final bcn O00000Oo() throws IOException, ParseException, PlaylistException {
        int i;
        int i2;
        String str;
        O000000o();
        bbv bbv = new bbv(this.O00000Oo);
        bby bby = new bby();
        bcd bcd = new bcd();
        while (true) {
            try {
                i = 1;
                if (!this.f12760O000000o.f12765O000000o.hasNext()) {
                    break;
                }
                String O000000o2 = this.f12760O000000o.O000000o();
                if (!O000000o(O000000o2)) {
                    if (O000000o2.length() != O000000o2.trim().length()) {
                        throw ParseException.O000000o(ParseExceptionType.WHITESPACE_IN_TRACK, O000000o2);
                    }
                }
                if (O000000o2.length() != 0 && !O000000o(O000000o2)) {
                    if (O000000o2.startsWith("#EXT")) {
                        int indexOf = O000000o2.indexOf(":");
                        if (indexOf == -1) {
                            str = O000000o2.substring(1);
                        } else {
                            str = O000000o2.substring(1, indexOf);
                        }
                        bbi bbi = this.O00000o.get(str);
                        if (bbi == null) {
                            if (this.O00000o0.O00000o0) {
                                bbi = bbe.O00000Oo;
                            } else {
                                throw ParseException.O000000o(ParseExceptionType.UNSUPPORTED_EXT_TAG_DETECTED, str, O000000o2);
                            }
                        }
                        bbi.O000000o(O000000o2, bbv);
                        if (bbv.O00000Oo()) {
                            if (bbv.O00000o0.O0000OoO) {
                                break;
                            }
                        } else {
                            continue;
                        }
                    } else if (bbv.O000000o()) {
                        bby.O000000o(O000000o2, bbv);
                    } else if (bbv.O00000Oo()) {
                        bcd.O000000o(O000000o2, bbv);
                    } else {
                        throw ParseException.O000000o(ParseExceptionType.UNKNOWN_PLAYLIST_TYPE, O000000o2);
                    }
                }
            } catch (ParseException e) {
                e.mInput = this.f12760O000000o.O00000Oo.toString();
                throw e;
            }
        }
        bcn.O000000o o000000o = new bcn.O000000o();
        if (bbv.O000000o()) {
            bbp bbp = bbv.O00000Oo;
            bck.O000000o o000000o2 = new bck.O000000o();
            o000000o2.f12857O000000o = bbp.f12766O000000o;
            o000000o2.O00000Oo = bbp.O00000Oo;
            o000000o2.O00000o0 = bbp.O00000o0;
            o000000o2.O00000o = bbp.O00000o;
            o000000o.f12863O000000o = new bck(o000000o2.f12857O000000o, o000000o2.O00000Oo, o000000o2.O00000o0, o000000o2.O00000o, (byte) 0);
            o000000o.O00000o0 = true;
        } else if (bbv.O00000Oo()) {
            bbs bbs = bbv.O00000o0;
            bcm.O000000o o000000o3 = new bcm.O000000o();
            o000000o3.f12861O000000o = bbs.f12814O000000o;
            o000000o3.O00000Oo = bbs.O00000Oo;
            int i3 = 0;
            if (bbs.O00000o0 == null) {
                float f = 0.0f;
                for (bct next : bbs.f12814O000000o) {
                    if (next.O000000o()) {
                        f = Math.max(f, next.O00000Oo.f12873O000000o);
                    }
                }
                i2 = 0;
            } else {
                i2 = bbs.O00000o0.intValue();
            }
            o000000o3.O00000o0 = i2;
            o000000o3.O00000oO = bbs.O00000oO != null;
            o000000o3.O00000oo = !bbs.O0000OoO;
            o000000o3.O0000OOo = bbs.O0000Oo0;
            if (bbs.O00000o != null) {
                i3 = bbs.O00000o.intValue();
            }
            o000000o3.O00000o = i3;
            o000000o3.O0000O0o = bbs.O00000oo;
            o000000o.O00000Oo = o000000o3.O000000o();
            o000000o.O00000o0 = bbv.O00000o;
        } else {
            throw new ParseException(ParseExceptionType.UNKNOWN_PLAYLIST_TYPE);
        }
        if (bbv.O00000oO != -1) {
            i = bbv.O00000oO;
        }
        o000000o.O00000o = i;
        bcn O000000o3 = o000000o.O000000o();
        bca O000000o4 = bca.O000000o(O000000o3, this.O00000o0);
        if (O000000o4.O000000o()) {
            return O000000o3;
        }
        throw new PlaylistException(this.f12760O000000o.O00000Oo.toString(), O000000o4.f12847O000000o);
    }

    private void O000000o(bbi... bbiArr) {
        for (int i = 0; i < 16; i++) {
            bbi bbi = bbiArr[i];
            this.O00000o.put(bbi.O000000o(), bbi);
        }
    }

    private static boolean O000000o(String str) {
        return str.startsWith("#") && !str.startsWith("#EXT");
    }
}
