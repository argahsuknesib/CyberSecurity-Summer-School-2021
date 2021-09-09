package _m_j;

import android.support.v4.app.NotificationCompat;
import com.drew.imaging.jpeg.JpegSegmentType;
import java.io.IOException;
import java.util.Collections;

public final class acd implements wl {
    public final Iterable<JpegSegmentType> O000000o() {
        return Collections.singletonList(JpegSegmentType.APP2);
    }

    public final void O000000o(Iterable<byte[]> iterable, xu xuVar, JpegSegmentType jpegSegmentType) {
        byte[] bArr = null;
        for (byte[] next : iterable) {
            if (next.length >= 11 && "ICC_PROFILE".equalsIgnoreCase(new String(next, 0, 11))) {
                if (bArr == null) {
                    bArr = new byte[(next.length - 14)];
                    System.arraycopy(next, 14, bArr, 0, next.length - 14);
                } else {
                    byte[] bArr2 = new byte[((bArr.length + next.length) - 14)];
                    System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                    System.arraycopy(next, 14, bArr2, bArr.length, next.length - 14);
                    bArr = bArr2;
                }
            }
        }
        if (bArr != null) {
            O000000o(new xc(bArr), xuVar);
        }
    }

    public final void O000000o(xj xjVar, xu xuVar) {
        O000000o(xjVar, xuVar, (xr) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.acd.O000000o(_m_j.xr, _m_j.xj):void
     arg types: [_m_j.acc, _m_j.xj]
     candidates:
      _m_j.acd.O000000o(_m_j.acc, _m_j.xj):void
      _m_j.acd.O000000o(_m_j.xj, _m_j.xu):void
      _m_j.acd.O000000o(_m_j.xr, _m_j.xj):void */
    public static void O000000o(xj xjVar, xu xuVar, xr xrVar) {
        acc acc = new acc();
        if (xrVar != null) {
            acc.O00000oO = xrVar;
        }
        try {
            acc.O000000o(0, xjVar.O0000Oo0(0));
            O000000o(acc, 4, xjVar);
            O00000Oo(acc, 8, xjVar);
            O000000o(acc, 12, xjVar);
            O000000o(acc, 16, xjVar);
            O000000o(acc, 20, xjVar);
            O000000o(acc, xjVar);
            O000000o(acc, 36, xjVar);
            O000000o(acc, 40, xjVar);
            O00000Oo(acc, 44, xjVar);
            O000000o(acc, 48, xjVar);
            int O0000Oo0 = xjVar.O0000Oo0(52);
            if (O0000Oo0 != 0) {
                if (O0000Oo0 <= 538976288) {
                    acc.O000000o(52, O0000Oo0);
                } else {
                    acc.O000000o(52, O000000o(O0000Oo0));
                }
            }
            O00000Oo(acc, 64, xjVar);
            O000000o((xr) acc, xjVar);
            acc.O000000o(68, new float[]{xjVar.O0000OoO(68), xjVar.O0000OoO(72), xjVar.O0000OoO(76)});
            int O0000Oo02 = xjVar.O0000Oo0(NotificationCompat.FLAG_HIGH_PRIORITY);
            acc.O000000o((int) NotificationCompat.FLAG_HIGH_PRIORITY, O0000Oo02);
            for (int i = 0; i < O0000Oo02; i++) {
                int i2 = (i * 12) + 132;
                acc.O000000o(xjVar.O0000Oo0(i2), xjVar.O00000o0(xjVar.O0000Oo0(i2 + 4), xjVar.O0000Oo0(i2 + 8)));
            }
        } catch (IOException e) {
            acc.O000000o("Exception reading ICC profile: " + e.getMessage());
        }
        xuVar.O000000o(acc);
    }

    private static void O000000o(xr xrVar, int i, xj xjVar) throws IOException {
        int O0000Oo0 = xjVar.O0000Oo0(i);
        if (O0000Oo0 != 0) {
            xrVar.O000000o(i, O000000o(O0000Oo0));
        }
    }

    private static void O00000Oo(xr xrVar, int i, xj xjVar) throws IOException {
        int O0000Oo0 = xjVar.O0000Oo0(i);
        if (O0000Oo0 != 0) {
            xrVar.O000000o(i, O0000Oo0);
        }
    }

    private static void O000000o(xr xrVar, xj xjVar) throws IOException {
        long O0000Oo = xjVar.O0000Oo(56);
        if (O0000Oo != 0) {
            xrVar.O000000o(56, O0000Oo);
        }
    }

    private static void O000000o(acc acc, xj xjVar) throws IOException {
        int O00000oO = xjVar.O00000oO(24);
        int O00000oO2 = xjVar.O00000oO(26);
        int O00000oO3 = xjVar.O00000oO(28);
        int O00000oO4 = xjVar.O00000oO(30);
        int O00000oO5 = xjVar.O00000oO(32);
        int O00000oO6 = xjVar.O00000oO(34);
        if (!xg.O000000o(O00000oO, O00000oO2 - 1, O00000oO3) || !xg.O00000Oo(O00000oO4, O00000oO5, O00000oO6)) {
            acc.O000000o(String.format("ICC data describes an invalid date/time: year=%d month=%d day=%d hour=%d minute=%d second=%d", Integer.valueOf(O00000oO), Integer.valueOf(O00000oO2), Integer.valueOf(O00000oO3), Integer.valueOf(O00000oO4), Integer.valueOf(O00000oO5), Integer.valueOf(O00000oO6)));
            return;
        }
        acc.O000000o(24, String.format("%04d:%02d:%02d %02d:%02d:%02d", Integer.valueOf(O00000oO), Integer.valueOf(O00000oO2), Integer.valueOf(O00000oO3), Integer.valueOf(O00000oO4), Integer.valueOf(O00000oO5), Integer.valueOf(O00000oO6)));
    }

    public static String O000000o(int i) {
        return new String(new byte[]{(byte) ((-16777216 & i) >> 24), (byte) ((16711680 & i) >> 16), (byte) ((65280 & i) >> 8), (byte) (i & 255)});
    }
}
