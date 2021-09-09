package _m_j;

import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public final class wj {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Iterable<wl> f2576O000000o = Arrays.asList(new acz(), new acu(), new acn(), new acq(), new yr(), new ahf(), new acd(), new agn(), new agj(), new acj(), new ya(), new acw(), new acy());

    private static void O000000o(xu xuVar, Iterable<wl> iterable, wk wkVar) {
        for (wl next : iterable) {
            for (JpegSegmentType next2 : next.O000000o()) {
                Iterable iterable2 = wkVar.f2577O000000o.get(Byte.valueOf(next2.byteValue));
                if (iterable2 == null) {
                    iterable2 = new ArrayList();
                }
                next.O000000o(iterable2, xuVar, next2);
            }
        }
    }

    public static xu O000000o(InputStream inputStream) throws JpegProcessingException, IOException {
        xu xuVar = new xu();
        Iterable<wl> iterable = f2576O000000o;
        HashSet hashSet = new HashSet();
        for (wl O000000o2 : iterable) {
            for (JpegSegmentType add : O000000o2.O000000o()) {
                hashSet.add(add);
            }
        }
        O000000o(xuVar, iterable, wm.O000000o(new xn(inputStream), hashSet));
        return xuVar;
    }
}
