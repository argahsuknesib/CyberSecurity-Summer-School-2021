package _m_j;

import _m_j.bcm;
import _m_j.bcn;
import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.ParseExceptionType;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.InputStream;

final class bbm extends bbc {
    bbm(InputStream inputStream, Encoding encoding) {
        super(inputStream, encoding);
    }

    public final bcn O00000Oo() throws IOException, ParseException, PlaylistException {
        O000000o();
        bbv bbv = new bbv(this.O00000Oo);
        bcd bcd = new bcd();
        try {
            bbv.O00000o0();
            while (this.f12760O000000o.f12765O000000o.hasNext()) {
                String O000000o2 = this.f12760O000000o.O000000o();
                if (!O000000o(O000000o2)) {
                    if (O000000o2.length() != O000000o2.trim().length()) {
                        ParseExceptionType parseExceptionType = ParseExceptionType.WHITESPACE_IN_TRACK;
                        StringBuilder sb = new StringBuilder();
                        sb.append(O000000o2.length());
                        throw ParseException.O000000o(parseExceptionType, O000000o2, sb.toString());
                    }
                }
                if (O000000o2.length() != 0 && !O000000o(O000000o2)) {
                    bcd.O000000o(O000000o2, bbv);
                }
            }
            bcn.O000000o o000000o = new bcn.O000000o();
            bcm.O000000o o000000o2 = new bcm.O000000o();
            o000000o2.f12861O000000o = bbv.O00000o0.f12814O000000o;
            o000000o.O00000Oo = o000000o2.O000000o();
            bcn O000000o3 = o000000o.O000000o();
            bca O000000o4 = bca.O000000o(O000000o3, bbx.f12842O000000o);
            if (O000000o4.O000000o()) {
                return O000000o3;
            }
            throw new PlaylistException(this.f12760O000000o.O00000Oo.toString(), O000000o4.f12847O000000o);
        } catch (ParseException e) {
            e.mInput = this.f12760O000000o.O00000Oo.toString();
            throw e;
        }
    }

    private static boolean O000000o(String str) {
        return str.indexOf("#") == 0;
    }
}
