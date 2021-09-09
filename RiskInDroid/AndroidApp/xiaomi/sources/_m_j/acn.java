package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class acn implements wl {
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
            if (next.length >= 4 && "JFIF".equals(new String(next, 0, 4))) {
                xc xcVar = new xc(next);
                acm acm = new acm();
                xuVar.O000000o(acm);
                try {
                    acm.O000000o(5, xcVar.O00000oO(5));
                    acm.O000000o(7, (int) xcVar.O00000o0(7));
                    acm.O000000o(8, xcVar.O00000oO(8));
                    acm.O000000o(10, xcVar.O00000oO(10));
                    acm.O000000o(12, (int) xcVar.O00000o0(12));
                    acm.O000000o(13, (int) xcVar.O00000o0(13));
                } catch (IOException e) {
                    acm.O000000o(e.getMessage());
                }
            }
        }
    }
}
