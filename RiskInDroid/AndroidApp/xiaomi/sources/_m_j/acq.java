package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class acq implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APP0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, short]
     candidates:
      _m_j.xr.O000000o(int, double):void
      _m_j.xr.O000000o(int, float):void
      _m_j.xr.O000000o(int, long):void
      _m_j.xr.O000000o(int, _m_j.xv):void
      _m_j.xr.O000000o(int, java.lang.Object):void
      _m_j.xr.O000000o(int, java.lang.String):void
      _m_j.xr.O000000o(int, boolean):void
      _m_j.xr.O000000o(int, byte[]):void
      _m_j.xr.O000000o(int, int):void */
    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 4 && "JFXX".equals(new String(next, 0, 4))) {
                xc xcVar = new xc(next);
                acp acp = new acp();
                xuVar.O000000o(acp);
                try {
                    acp.O000000o(5, (int) xcVar.O00000o0(5));
                } catch (IOException e) {
                    acp.O000000o(e.getMessage());
                }
            }
        }
    }
}
