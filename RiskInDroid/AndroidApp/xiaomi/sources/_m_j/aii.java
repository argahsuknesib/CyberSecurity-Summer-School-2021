package _m_j;

import android.support.v4.app.NotificationCompat;
import java.util.Arrays;

public final class aii {

    /* renamed from: O000000o  reason: collision with root package name */
    public final char[] f12388O000000o;
    final String O00000Oo;
    public final char O00000o;
    public final boolean O00000o0;
    public final int O00000oO;
    private final int[] O00000oo;
    private final byte[] O0000O0o;

    public aii(String str, String str2, boolean z, char c, int i) {
        this.O00000oo = new int[NotificationCompat.FLAG_HIGH_PRIORITY];
        this.f12388O000000o = new char[64];
        this.O0000O0o = new byte[64];
        this.O00000Oo = str;
        this.O00000o0 = z;
        this.O00000o = c;
        this.O00000oO = i;
        int length = str2.length();
        if (length == 64) {
            str2.getChars(0, length, this.f12388O000000o, 0);
            Arrays.fill(this.O00000oo, -1);
            for (int i2 = 0; i2 < length; i2++) {
                char c2 = this.f12388O000000o[i2];
                this.O0000O0o[i2] = (byte) c2;
                this.O00000oo[c2] = i2;
            }
            if (z) {
                this.O00000oo[c] = -2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Base64Alphabet length must be exactly 64 (was " + length + ")");
    }

    public aii(aii aii, String str) {
        this(aii, str, aii.O00000o0, aii.O00000o, Integer.MAX_VALUE);
    }

    public aii(aii aii, String str, boolean z, char c, int i) {
        this.O00000oo = new int[NotificationCompat.FLAG_HIGH_PRIORITY];
        this.f12388O000000o = new char[64];
        this.O0000O0o = new byte[64];
        this.O00000Oo = str;
        byte[] bArr = aii.O0000O0o;
        System.arraycopy(bArr, 0, this.O0000O0o, 0, bArr.length);
        char[] cArr = aii.f12388O000000o;
        System.arraycopy(cArr, 0, this.f12388O000000o, 0, cArr.length);
        int[] iArr = aii.O00000oo;
        System.arraycopy(iArr, 0, this.O00000oo, 0, iArr.length);
        this.O00000o0 = z;
        this.O00000o = c;
        this.O00000oO = i;
    }

    public final boolean O000000o(char c) {
        return c == this.O00000o;
    }

    public final boolean O000000o(int i) {
        return i == this.O00000o;
    }

    public final int O00000Oo(char c) {
        if (c <= 127) {
            return this.O00000oo[c];
        }
        return -1;
    }

    public final String O000000o(byte[] bArr, boolean z) {
        int length = bArr.length;
        StringBuilder sb = new StringBuilder((length >> 2) + length + (length >> 3));
        if (z) {
            sb.append('\"');
        }
        int i = this.O00000oO >> 2;
        int i2 = 0;
        int i3 = length - 3;
        while (i2 <= i3) {
            int i4 = i2 + 1;
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            byte b = (((bArr[i2] << 8) | (bArr[i4] & 255)) << 8) | (bArr[i5] & 255);
            sb.append(this.f12388O000000o[(b >> 18) & 63]);
            sb.append(this.f12388O000000o[(b >> 12) & 63]);
            sb.append(this.f12388O000000o[(b >> 6) & 63]);
            sb.append(this.f12388O000000o[b & 63]);
            i--;
            if (i <= 0) {
                sb.append('\\');
                sb.append('n');
                i = this.O00000oO >> 2;
            }
            i2 = i6;
        }
        int i7 = length - i2;
        if (i7 > 0) {
            int i8 = i2 + 1;
            int i9 = bArr[i2] << 16;
            if (i7 == 2) {
                i9 |= (bArr[i8] & 255) << 8;
            }
            sb.append(this.f12388O000000o[(i9 >> 18) & 63]);
            sb.append(this.f12388O000000o[(i9 >> 12) & 63]);
            if (this.O00000o0) {
                sb.append(i7 == 2 ? this.f12388O000000o[(i9 >> 6) & 63] : this.O00000o);
                sb.append(this.O00000o);
            } else if (i7 == 2) {
                sb.append(this.f12388O000000o[(i9 >> 6) & 63]);
            }
        }
        if (z) {
            sb.append('\"');
        }
        return sb.toString();
    }

    public final String toString() {
        return this.O00000Oo;
    }
}
