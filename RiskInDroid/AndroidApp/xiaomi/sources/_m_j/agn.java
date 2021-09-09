package _m_j;

import com.drew.imaging.ImageProcessingException;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.util.Arrays;
import java.util.Collections;

public final class agn implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APPD);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length >= 14 && "Photoshop 3.0".equals(new String(next, 0, 13))) {
                O000000o(new xl(next, 14), (next.length - 13) - 1, xuVar);
            }
        }
    }

    public static void O000000o(xm xmVar, int i, xu xuVar) {
        int i2;
        agm agm = new agm();
        xuVar.O000000o(agm);
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            try {
                String O00000Oo = xmVar.O00000Oo(4);
                int O00000oO = xmVar.O00000oO();
                short O00000o = xmVar.O00000o();
                int i5 = i3 + 4 + 2 + 1;
                if (O00000o < 0 || (i2 = O00000o + i5) > i) {
                    throw new ImageProcessingException("Invalid string length");
                }
                StringBuilder sb = new StringBuilder();
                short s = (short) i2;
                while (i5 < s) {
                    sb.append((char) xmVar.O00000o());
                    i5++;
                }
                if (i5 % 2 != 0) {
                    xmVar.O000000o(1L);
                    i5++;
                }
                int O0000OOo = xmVar.O0000OOo();
                byte[] O000000o2 = xmVar.O000000o(O0000OOo);
                i3 = i5 + 4 + O0000OOo;
                if (i3 % 2 != 0) {
                    xmVar.O000000o(1L);
                    i3++;
                }
                if (O00000Oo.equals("8BIM")) {
                    if (O00000oO == 1028) {
                        new acj();
                        acj.O000000o(new xl(O000000o2), xuVar, (long) O000000o2.length, agm);
                    } else if (O00000oO == 1039) {
                        new acd();
                        acd.O000000o(new xc(O000000o2), xuVar, agm);
                    } else {
                        if (O00000oO != 1058) {
                            if (O00000oO != 1059) {
                                if (O00000oO == 1060) {
                                    new ahf();
                                    ahf.O000000o(O000000o2, xuVar, agm);
                                } else if (O00000oO < 2000 || O00000oO > 2998) {
                                    agm.O000000o(O00000oO, O000000o2);
                                } else {
                                    i4++;
                                    byte[] copyOf = Arrays.copyOf(O000000o2, O000000o2.length + sb.length() + 1);
                                    for (int length = (copyOf.length - sb.length()) - 1; length < copyOf.length; length++) {
                                        if (length % (((copyOf.length - sb.length()) - 1) + sb.length()) == 0) {
                                            copyOf[length] = (byte) sb.length();
                                        } else {
                                            copyOf[length] = (byte) sb.charAt(length - ((copyOf.length - sb.length()) - 1));
                                        }
                                    }
                                    int i6 = i4 + 1999;
                                    agm.O0000O0o.put(Integer.valueOf(i6), "Path Info ".concat(String.valueOf(i4)));
                                    agm.O000000o(i6, copyOf);
                                }
                            }
                        }
                        new yr();
                        yr.O000000o(new xc(O000000o2), xuVar, 0, agm);
                    }
                    if (O00000oO >= 4000 && O00000oO <= 4999) {
                        agm.O0000O0o.put(Integer.valueOf(O00000oO), String.format("Plug-in %d Data", Integer.valueOf((O00000oO - 4000) + 1)));
                    }
                }
            } catch (Exception e) {
                agm.O000000o(e.getMessage());
                return;
            }
        }
    }
}
