package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.metadata.jpeg.JpegComponent;
import java.io.IOException;
import java.util.Arrays;

public final class acz implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Arrays.asList(JpegSegmentType.SOF0, JpegSegmentType.SOF1, JpegSegmentType.SOF2, JpegSegmentType.SOF3, JpegSegmentType.SOF5, JpegSegmentType.SOF6, JpegSegmentType.SOF7, JpegSegmentType.SOF9, JpegSegmentType.SOF10, JpegSegmentType.SOF11, JpegSegmentType.SOF13, JpegSegmentType.SOF14, JpegSegmentType.SOF15);
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
        for (byte[] xlVar : iterable) {
            acx acx = new acx();
            xuVar.O000000o(acx);
            acx.O000000o(-3, jpegSegmentType.byteValue - JpegSegmentType.SOF0.byteValue);
            xl xlVar2 = new xl(xlVar);
            try {
                acx.O000000o(0, (int) xlVar2.O00000o());
                acx.O000000o(1, xlVar2.O00000oO());
                acx.O000000o(3, xlVar2.O00000oO());
                short O00000o = xlVar2.O00000o();
                acx.O000000o(5, (int) O00000o);
                for (int i = 0; i < O00000o; i++) {
                    acx.O000000o(i + 6, new JpegComponent(xlVar2.O00000o(), xlVar2.O00000o(), xlVar2.O00000o()));
                }
            } catch (IOException e) {
                acx.O000000o(e.getMessage());
            }
        }
    }
}
