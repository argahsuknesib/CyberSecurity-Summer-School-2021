package _m_j;

import android.support.v4.app.NotificationCompat;
import java.io.UnsupportedEncodingException;

public final class mw {
    private static byte[] O000000o(byte b) {
        byte b2 = b & 255;
        if (b2 >= 128) {
            if (b2 == 129 || b2 == 141 || b2 == 143 || b2 == 144 || b2 == 157) {
                return new byte[]{32};
            }
            try {
                return new String(new byte[]{b}, "cp1252").getBytes("UTF-8");
            } catch (UnsupportedEncodingException unused) {
            }
        }
        return new byte[]{b};
    }

    public static mt O000000o(mt mtVar) {
        if (!"UTF-8".equals(mtVar.O00000Oo())) {
            return mtVar;
        }
        byte[] bArr = new byte[8];
        mt mtVar2 = new mt((mtVar.O00000Oo * 4) / 3);
        int i = 0;
        char c = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < mtVar.O00000Oo) {
            if (i < mtVar.O00000Oo) {
                byte b = mtVar.f2187O000000o[i] & 255;
                if (c == 11) {
                    if (i3 <= 0 || (b & 192) != 128) {
                        byte[] O000000o2 = O000000o(bArr[0]);
                        mtVar2.O000000o(O000000o2, O000000o2.length);
                        i -= i2;
                    } else {
                        int i4 = i2 + 1;
                        bArr[i2] = (byte) b;
                        i3--;
                        if (i3 == 0) {
                            mtVar2.O000000o(bArr, i4);
                        } else {
                            i2 = i4;
                        }
                    }
                    c = 0;
                    i2 = 0;
                } else if (b < Byte.MAX_VALUE) {
                    mtVar2.O000000o(mtVar2.O00000Oo + 1);
                    byte[] bArr2 = mtVar2.f2187O000000o;
                    int i5 = mtVar2.O00000Oo;
                    mtVar2.O00000Oo = i5 + 1;
                    bArr2[i5] = (byte) b;
                } else if (b >= 192) {
                    int i6 = -1;
                    int i7 = b;
                    while (i6 < 8 && (i7 & NotificationCompat.FLAG_HIGH_PRIORITY) == 128) {
                        i6++;
                        i7 <<= 1;
                    }
                    bArr[i2] = (byte) b;
                    i2++;
                    i3 = i6;
                    c = 11;
                } else {
                    byte[] O000000o3 = O000000o((byte) b);
                    mtVar2.O000000o(O000000o3, O000000o3.length);
                }
                i++;
            } else {
                throw new IndexOutOfBoundsException("The index exceeds the valid buffer area");
            }
        }
        if (c == 11) {
            for (int i8 = 0; i8 < i2; i8++) {
                byte[] O000000o4 = O000000o(bArr[i8]);
                mtVar2.O000000o(O000000o4, O000000o4.length);
            }
        }
        return mtVar2;
    }
}
