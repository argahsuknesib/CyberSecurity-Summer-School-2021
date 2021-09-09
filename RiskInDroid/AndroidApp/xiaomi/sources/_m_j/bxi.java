package _m_j;

import android.support.v4.app.NotificationCompat;
import java.util.Arrays;

public final class bxi {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final char[] f13378O000000o = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};
    private static final byte[] O00000Oo;

    static {
        byte[] bArr = new byte[NotificationCompat.FLAG_HIGH_PRIORITY];
        O00000Oo = bArr;
        Arrays.fill(bArr, Byte.MAX_VALUE);
        int i = 0;
        while (true) {
            char[] cArr = f13378O000000o;
            if (i < cArr.length) {
                O00000Oo[cArr[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    public static byte[] O000000o(String str) {
        char[] cArr = new char[4];
        byte[] bArr = new byte[(((str.length() / 4) * 3) + 3)];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            if (charAt != '$') {
                byte[] bArr2 = O00000Oo;
                if (charAt < bArr2.length) {
                    if (bArr2[charAt] == Byte.MAX_VALUE) {
                    }
                }
            }
            int i4 = i2 + 1;
            cArr[i2] = charAt;
            if (i4 == 4) {
                int i5 = 2;
                char c = cArr[3] == '$' ? (char) 2 : 3;
                if (cArr[2] == '$') {
                    c = 1;
                }
                byte[] bArr3 = O00000Oo;
                byte b = bArr3[cArr[0]];
                byte b2 = bArr3[cArr[1]];
                byte b3 = bArr3[cArr[2]];
                byte b4 = bArr3[cArr[3]];
                if (c == 2) {
                    bArr[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                    bArr[i + 1] = (byte) (((b2 << 4) & 240) | ((b3 >> 2) & 15));
                } else if (c != 3) {
                    bArr[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                    i5 = 1;
                } else {
                    int i6 = i + 1;
                    bArr[i] = (byte) (((b << 2) & 252) | ((b2 >> 4) & 3));
                    bArr[i6] = (byte) (((b2 << 4) & 240) | ((b3 >> 2) & 15));
                    bArr[i6 + 1] = (byte) (((b3 << 6) & 192) | (b4 & 63));
                    i5 = 3;
                }
                i += i5;
                i2 = 0;
            } else {
                i2 = i4;
            }
        }
        if (i == bArr.length) {
            return bArr;
        }
        byte[] bArr4 = new byte[i];
        System.arraycopy(bArr, 0, bArr4, 0, i);
        return bArr4;
    }

    public static String O000000o(byte[] bArr) {
        int length = bArr.length;
        if (length <= 0) {
            return "";
        }
        char[] cArr = new char[(((length / 3) * 4) + 4)];
        int i = length - 0;
        int i2 = 0;
        int i3 = 0;
        while (i >= 3) {
            int i4 = ((bArr[i2] & 255) << 16) + ((bArr[i2 + 1] & 255) << 8) + (bArr[i2 + 2] & 255);
            int i5 = i3 + 1;
            char[] cArr2 = f13378O000000o;
            cArr[i3] = cArr2[i4 >> 18];
            int i6 = i5 + 1;
            cArr[i5] = cArr2[(i4 >> 12) & 63];
            int i7 = i6 + 1;
            cArr[i6] = cArr2[(i4 >> 6) & 63];
            i3 = i7 + 1;
            cArr[i7] = cArr2[i4 & 63];
            i2 += 3;
            i -= 3;
        }
        if (i == 1) {
            byte b = bArr[i2] & 255;
            int i8 = i3 + 1;
            char[] cArr3 = f13378O000000o;
            cArr[i3] = cArr3[b >> 2];
            int i9 = i8 + 1;
            cArr[i8] = cArr3[(b << 4) & 63];
            int i10 = i9 + 1;
            cArr[i9] = '$';
            i3 = i10 + 1;
            cArr[i10] = '$';
        } else if (i == 2) {
            int i11 = ((bArr[i2] & 255) << 8) + (bArr[i2 + 1] & 255);
            int i12 = i3 + 1;
            char[] cArr4 = f13378O000000o;
            cArr[i3] = cArr4[i11 >> 10];
            int i13 = i12 + 1;
            cArr[i12] = cArr4[(i11 >> 4) & 63];
            int i14 = i13 + 1;
            cArr[i13] = cArr4[(i11 << 2) & 63];
            i3 = i14 + 1;
            cArr[i14] = '$';
        }
        return new String(cArr, 0, i3);
    }
}
