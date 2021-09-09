package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import com.drew.imaging.tiff.TiffProcessingException;
import java.io.IOException;
import java.util.Collections;

public class yr implements wl {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2605O000000o = (!yr.class.desiredAssertionStatus());

    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APP1);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        if (f2605O000000o || jpegSegmentType == JpegSegmentType.APP1) {
            for (byte[] next : iterable) {
                if (next.length >= 6 && new String(next, 0, 6).equals("Exif\u0000\u0000")) {
                    O000000o(new xc(next), xuVar, 6, null);
                }
            }
            return;
        }
        throw new AssertionError();
    }

    public static void O000000o(xj xjVar, xu xuVar, int i, xr xrVar) {
        yw ywVar = new yw(xuVar, xrVar);
        try {
            new xb();
            xb.O000000o(xjVar, ywVar, i);
        } catch (TiffProcessingException e) {
            ywVar.O00000Oo("Exception processing TIFF data: " + e.getMessage());
            e.printStackTrace(System.err);
        } catch (IOException e2) {
            ywVar.O00000Oo("Exception processing TIFF data: " + e2.getMessage());
            e2.printStackTrace(System.err);
        }
    }
}
