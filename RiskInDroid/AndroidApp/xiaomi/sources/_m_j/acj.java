package _m_j;

import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Collections;

public final class acj implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APPD);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        for (byte[] next : iterable) {
            if (next.length != 0 && next[0] == 28) {
                O000000o(new xl(next), xuVar, (long) next.length, null);
            }
        }
    }

    public static void O000000o(xm xmVar, xu xuVar, long j, xr xrVar) {
        aci aci = new aci();
        xuVar.O000000o(aci);
        if (xrVar != null) {
            aci.O00000oO = xrVar;
        }
        int i = 0;
        while (((long) i) < j) {
            try {
                short O00000o = xmVar.O00000o();
                int i2 = i + 1;
                if (O00000o != 28) {
                    if (((long) i2) != j) {
                        StringBuilder sb = new StringBuilder("Invalid IPTC tag marker at offset ");
                        sb.append(i2 - 1);
                        sb.append(". Expected '0x");
                        sb.append(Integer.toHexString(28));
                        sb.append("' but got '0x");
                        sb.append(Integer.toHexString(O00000o));
                        sb.append("'.");
                        aci.O000000o(sb.toString());
                        return;
                    }
                    return;
                } else if (((long) (i2 + 4)) > j) {
                    aci.O000000o("Too few bytes remain for a valid IPTC tag");
                    return;
                } else {
                    try {
                        short O00000o2 = xmVar.O00000o();
                        short O00000o3 = xmVar.O00000o();
                        int O00000oO = xmVar.O00000oO();
                        if (O00000oO > 32767) {
                            O00000oO = ((O00000oO & 32767) << 16) | xmVar.O00000oO();
                            i2 += 2;
                        }
                        i = i2 + 4 + O00000oO;
                        if (((long) i) > j) {
                            aci.O000000o("Data for tag extends beyond end of IPTC segment");
                            return;
                        }
                        try {
                            O000000o(xmVar, aci, O00000o2, O00000o3, O00000oO);
                        } catch (IOException unused) {
                            aci.O000000o("Error processing IPTC tag");
                            return;
                        }
                    } catch (IOException unused2) {
                        aci.O000000o("IPTC data segment ended mid-way through tag descriptor");
                        return;
                    }
                }
            } catch (IOException unused3) {
                aci.O000000o("Unable to read starting byte of IPTC tag");
                return;
            }
        }
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
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
        if (r5 != 582) goto L_0x0059;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a5  */
    private static void O000000o(xm xmVar, xr xrVar, int i, int i2, int i3) throws IOException {
        Charset charset;
        xv xvVar;
        xv[] xvVarArr;
        int i4 = (i << 8) | i2;
        if (i3 == 0) {
            xrVar.O000000o(i4, "");
            return;
        }
        if (!(i4 == 256 || i4 == 278)) {
            if (i4 == 346) {
                byte[] O000000o2 = xmVar.O000000o(i3);
                String O000000o3 = ack.O000000o(O000000o2);
                if (O000000o3 == null) {
                    O000000o3 = new String(O000000o2);
                }
                xrVar.O000000o(i4, O000000o3);
                return;
            } else if (!(i4 == 378 || i4 == 512)) {
                if (i4 == 522) {
                    xrVar.O000000o(i4, (int) xmVar.O00000o());
                    xmVar.O000000o((long) (i3 - 1));
                    return;
                }
            }
        }
        if (i3 >= 2) {
            int O00000oO = xmVar.O00000oO();
            xmVar.O000000o((long) (i3 - 2));
            xrVar.O000000o(i4, O00000oO);
            return;
        }
        String O0000o0 = xrVar.O0000o0(346);
        if (O0000o0 != null) {
            try {
                charset = Charset.forName(O0000o0);
            } catch (Throwable unused) {
            }
            if (O0000o0 == null) {
                xvVar = xmVar.O000000o(i3, charset);
            } else {
                byte[] O000000o4 = xmVar.O000000o(i3);
                Charset O00000Oo = ack.O00000Oo(O000000o4);
                xvVar = O00000Oo != null ? new xv(O000000o4, O00000Oo) : new xv(O000000o4, null);
            }
            if (!xrVar.O000000o(i4)) {
                xv[] O00000oO2 = xrVar.O00000oO(i4);
                if (O00000oO2 == null) {
                    xvVarArr = new xv[1];
                } else {
                    xv[] xvVarArr2 = new xv[(O00000oO2.length + 1)];
                    System.arraycopy(O00000oO2, 0, xvVarArr2, 0, O00000oO2.length);
                    xvVarArr = xvVarArr2;
                }
                xvVarArr[xvVarArr.length - 1] = xvVar;
                xrVar.O00000Oo(i4, xvVarArr);
                return;
            }
            xrVar.O000000o(i4, xvVar);
            return;
        }
        charset = null;
        if (O0000o0 == null) {
        }
        if (!xrVar.O000000o(i4)) {
        }
    }
}
