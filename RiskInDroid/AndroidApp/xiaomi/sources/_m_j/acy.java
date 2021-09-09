package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class acy implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.DNL);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            acx acx = (acx) xuVar.O000000o(acx.class);
            if (acx == null) {
                xs xsVar = new xs();
                xuVar.O000000o(xsVar);
                xsVar.O000000o("DNL segment found without SOFx - illegal JPEG format");
            } else {
                xl xlVar = new xl(next);
                try {
                    Integer O00000o0 = acx.O00000o0(1);
                    if (O00000o0 == null || O00000o0.intValue() == 0) {
                        acx.O000000o(1, xlVar.O00000oO());
                    }
                } catch (IOException e) {
                    acx.O000000o(e.getMessage());
                }
            }
        }
    }
}
