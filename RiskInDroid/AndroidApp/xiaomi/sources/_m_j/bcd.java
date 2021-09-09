package _m_j;

import _m_j.bct;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import java.util.List;

final class bcd implements bbl {
    bcd() {
    }

    public final void O000000o(String str, bbv bbv) throws ParseException {
        bct.O000000o o000000o = new bct.O000000o();
        bbs bbs = bbv.O00000o0;
        if (!bbv.O00000o || bbs.O0000O0o != null) {
            List<bct> list = bbs.f12814O000000o;
            o000000o.f12872O000000o = str;
            o000000o.O00000Oo = bbs.O0000O0o;
            o000000o.O00000o0 = bbs.O0000OOo;
            o000000o.O00000o = bbs.O0000Oo;
            o000000o.O00000oO = bbs.O0000Ooo;
            list.add(o000000o.O000000o());
            bbs.O0000O0o = null;
            bbs.O0000Oo = null;
            bbs.O0000Ooo = false;
            return;
        }
        throw ParseException.O000000o(ParseExceptionType.MISSING_TRACK_INFO, str);
    }
}
