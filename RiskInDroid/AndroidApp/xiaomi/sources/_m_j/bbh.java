package _m_j;

import com.iheartradio.m3u8.Encoding;
import com.iheartradio.m3u8.ParseException;
import com.iheartradio.m3u8.PlaylistException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

final class bbh extends bcf {
    private List<bbj> O00000Oo = new ArrayList();

    public bbh(OutputStream outputStream, Encoding encoding) {
        super(outputStream, encoding);
        O000000o(bbf.f12764O000000o, bbf.O00000o0, bbu.O00000oo, bbu.O0000Ooo, bbu.O0000OOo, bbu.O0000O0o, bbu.O0000Oo0, bbu.O00000oO, bbr.O00000o, bbu.O0000Oo, bbr.O00000oo, bbr.O00000oO, bbu.O0000OoO, bbu.O00000o);
    }

    private void O000000o(bbj... bbjArr) {
        for (int i = 0; i < 14; i++) {
            this.O00000Oo.add(bbjArr[i]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(bcn bcn) throws IOException, ParseException, PlaylistException {
        for (bbj O000000o2 : this.O00000Oo) {
            O000000o2.O000000o(this.f12851O000000o, bcn);
        }
    }
}
