package _m_j;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

public class wm {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f2578O000000o = (!wm.class.desiredAssertionStatus());

    public static wk O000000o(xm xmVar, Iterable<JpegSegmentType> iterable) throws JpegProcessingException, IOException {
        Object obj;
        if (f2578O000000o || xmVar.f2595O000000o) {
            int O00000oO = xmVar.O00000oO();
            if (O00000oO == 65496) {
                HashSet hashSet = new HashSet();
                for (JpegSegmentType jpegSegmentType : iterable) {
                    hashSet.add(Byte.valueOf(jpegSegmentType.byteValue));
                }
                wk wkVar = new wk();
                while (true) {
                    byte O00000Oo = xmVar.O00000Oo();
                    byte O00000Oo2 = xmVar.O00000Oo();
                    while (true) {
                        if (O00000Oo == -1 && O00000Oo2 != -1 && O00000Oo2 != 0) {
                            break;
                        }
                        byte b = O00000Oo2;
                        O00000Oo2 = xmVar.O00000Oo();
                        O00000Oo = b;
                    }
                    if (O00000Oo2 == -38 || O00000Oo2 == -39) {
                        return wkVar;
                    }
                    int O00000oO2 = xmVar.O00000oO() - 2;
                    if (O00000oO2 < 0) {
                        throw new JpegProcessingException("JPEG segment size would be less than zero");
                    } else if (hashSet.contains(Byte.valueOf(O00000Oo2))) {
                        byte[] O000000o2 = xmVar.O000000o(O00000oO2);
                        if (f2578O000000o || O00000oO2 == O000000o2.length) {
                            if (wkVar.f2577O000000o.containsKey(Byte.valueOf(O00000Oo2))) {
                                obj = wkVar.f2577O000000o.get(Byte.valueOf(O00000Oo2));
                            } else {
                                obj = new ArrayList();
                                wkVar.f2577O000000o.put(Byte.valueOf(O00000Oo2), obj);
                            }
                            obj.add(O000000o2);
                        } else {
                            throw new AssertionError();
                        }
                    } else if (!xmVar.O00000Oo((long) O00000oO2)) {
                        return wkVar;
                    }
                }
            } else {
                throw new JpegProcessingException("JPEG data is expected to begin with 0xFFD8 (ÿØ) not 0x" + Integer.toHexString(O00000oO));
            }
        } else {
            throw new AssertionError();
        }
    }

    private wm() throws Exception {
        throw new Exception("Not intended for instantiation.");
    }
}
