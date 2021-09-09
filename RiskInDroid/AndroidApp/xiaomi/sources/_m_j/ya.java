package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class ya implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APPE);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.xr.O000000o(int, int):void
     arg types: [int, byte]
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
            if (next.length == 12 && "Adobe".equalsIgnoreCase(new String(next, 0, 5))) {
                xl xlVar = new xl(next);
                xz xzVar = new xz();
                xuVar.O000000o(xzVar);
                try {
                    xlVar.f2595O000000o = false;
                    if (!xlVar.O00000Oo(5).equals("Adobe")) {
                        xzVar.O000000o("Invalid Adobe JPEG data header.");
                    } else {
                        xzVar.O000000o(0, xlVar.O00000oO());
                        xzVar.O000000o(1, xlVar.O00000oO());
                        xzVar.O000000o(2, xlVar.O00000oO());
                        xzVar.O000000o(3, (int) xlVar.O00000Oo());
                    }
                } catch (IOException e) {
                    xzVar.O000000o("IO exception processing data: " + e.getMessage());
                }
            }
        }
    }
}
