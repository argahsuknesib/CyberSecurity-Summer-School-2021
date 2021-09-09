package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class agj implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APPC);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 5 && "Ducky".equals(new String(next, 0, 5))) {
                O000000o(new xl(next, 5), xuVar);
            }
        }
    }

    private static void O000000o(xm xmVar, xu xuVar) {
        agi agi = new agi();
        xuVar.O000000o(agi);
        while (true) {
            try {
                int O00000oO = xmVar.O00000oO();
                if (O00000oO != 0) {
                    int O00000oO2 = xmVar.O00000oO();
                    if (O00000oO != 1) {
                        if (O00000oO == 2 || O00000oO == 3) {
                            xmVar.O000000o(4L);
                            agi.O000000o(O00000oO, xmVar.O000000o(O00000oO2 - 4, xf.O00000oO));
                        } else {
                            agi.O000000o(O00000oO, xmVar.O000000o(O00000oO2));
                        }
                    } else if (O00000oO2 != 4) {
                        agi.O000000o("Unexpected length for the quality tag");
                        return;
                    } else {
                        agi.O000000o(O00000oO, xmVar.O0000OOo());
                    }
                } else {
                    return;
                }
            } catch (IOException e) {
                agi.O000000o(e.getMessage());
                return;
            }
        }
    }
}
