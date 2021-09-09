package _m_j;

import com.adobe.xmp.XMPException;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public final class ahf implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APP1);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        byte[] bArr = null;
        String str = null;
        for (byte[] next : iterable) {
            if (next.length >= 29 && ("http://ns.adobe.com/xap/1.0/\u0000".equalsIgnoreCase(new String(next, 0, 29)) || "XMP".equalsIgnoreCase(new String(next, 0, 3)))) {
                byte[] bArr2 = new byte[(next.length - 29)];
                System.arraycopy(next, 29, bArr2, 0, bArr2.length);
                O000000o(bArr2, xuVar, (xr) null);
                str = O000000o(xuVar);
            } else if (str != null && next.length >= 35 && "http://ns.adobe.com/xmp/extension/\u0000".equalsIgnoreCase(new String(next, 0, 35))) {
                bArr = O000000o(xuVar, next, str, bArr);
            }
        }
        if (bArr != null) {
            O000000o(bArr, xuVar, (xr) null);
        }
    }

    public static void O000000o(byte[] bArr, xu xuVar, xr xrVar) {
        O000000o(bArr, bArr.length, xuVar, xrVar);
    }

    public static void O000000o(byte[] bArr, int i, xu xuVar, xr xrVar) {
        mo moVar;
        ahe ahe = new ahe();
        if (xrVar != null) {
            ahe.O00000oO = xrVar;
        }
        try {
            if (i == bArr.length) {
                moVar = mp.O000000o(bArr);
            } else {
                moVar = mp.O000000o(new mt(bArr, 0, i).O000000o());
            }
            ahe.O000000o(moVar);
        } catch (XMPException e) {
            ahe.O000000o("Error processing XMP data: " + e.getMessage());
        }
        if (!ahe.O00000o0()) {
            xuVar.O000000o(ahe);
        }
    }

    private static String O000000o(xu xuVar) {
        Class<ahe> cls = ahe.class;
        ArrayList<ahe> arrayList = new ArrayList<>();
        for (xr next : xuVar.f2599O000000o) {
            if (cls.isAssignableFrom(next.getClass())) {
                arrayList.add(next);
            }
        }
        for (ahe ahe : arrayList) {
            if (ahe.O0000OOo == null) {
                ahe.O0000OOo = new nd();
            }
            try {
                mn O000000o2 = ahe.O0000OOo.O000000o("http://ns.adobe.com/xmp/note/");
                while (O000000o2.hasNext()) {
                    nt ntVar = (nt) O000000o2.next();
                    if ("xmpNote:HasExtendedXMP".equals(ntVar.O000000o())) {
                        return ntVar.O00000Oo();
                    }
                }
                continue;
            } catch (XMPException unused) {
            }
        }
        return null;
    }

    private static byte[] O000000o(xu xuVar, byte[] bArr, String str, byte[] bArr2) {
        int length = bArr.length;
        if (length >= 75) {
            try {
                xl xlVar = new xl(bArr);
                xlVar.O000000o(35L);
                if (str.equals(xlVar.O00000Oo(32))) {
                    int O0000O0o = (int) xlVar.O0000O0o();
                    int O0000O0o2 = (int) xlVar.O0000O0o();
                    if (bArr2 == null) {
                        bArr2 = new byte[O0000O0o];
                    }
                    if (bArr2.length == O0000O0o) {
                        System.arraycopy(bArr, 75, bArr2, O0000O0o2, length - 75);
                    } else {
                        ahe ahe = new ahe();
                        ahe.O000000o(String.format("Inconsistent length for the Extended XMP buffer: %d instead of %d", Integer.valueOf(O0000O0o), Integer.valueOf(bArr2.length)));
                        xuVar.O000000o(ahe);
                    }
                }
            } catch (IOException e) {
                ahe ahe2 = new ahe();
                ahe2.O000000o(e.getMessage());
                xuVar.O000000o(ahe2);
            }
        }
        return bArr2;
    }
}
