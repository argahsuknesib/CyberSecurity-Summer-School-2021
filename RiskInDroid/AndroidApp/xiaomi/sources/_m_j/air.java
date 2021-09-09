package _m_j;

import android.support.v4.app.NotificationCompat;
import java.util.Arrays;

public final class air {

    /* renamed from: O000000o  reason: collision with root package name */
    static final int[] f12392O000000o;
    static final int[] O00000Oo;
    static final int[] O00000o;
    static final int[] O00000o0;
    static final int[] O00000oO = new int[256];
    static final int[] O00000oo;
    static final int[] O0000O0o;
    private static final char[] O0000OOo;
    private static final byte[] O0000Oo0;

    static {
        char[] charArray = "0123456789ABCDEF".toCharArray();
        O0000OOo = charArray;
        int length = charArray.length;
        O0000Oo0 = new byte[length];
        for (int i = 0; i < length; i++) {
            O0000Oo0[i] = (byte) O0000OOo[i];
        }
        int[] iArr = new int[256];
        for (int i2 = 0; i2 < 32; i2++) {
            iArr[i2] = -1;
        }
        iArr[34] = 1;
        iArr[92] = 1;
        f12392O000000o = iArr;
        int[] iArr2 = new int[256];
        int[] iArr3 = f12392O000000o;
        System.arraycopy(iArr3, 0, iArr2, 0, iArr3.length);
        for (int i3 = NotificationCompat.FLAG_HIGH_PRIORITY; i3 < 256; i3++) {
            iArr2[i3] = (i3 & 224) == 192 ? 2 : (i3 & 240) == 224 ? 3 : (i3 & 248) == 240 ? 4 : -1;
        }
        O00000Oo = iArr2;
        int[] iArr4 = new int[256];
        Arrays.fill(iArr4, -1);
        for (int i4 = 33; i4 < 256; i4++) {
            if (Character.isJavaIdentifierPart((char) i4)) {
                iArr4[i4] = 0;
            }
        }
        iArr4[64] = 0;
        iArr4[35] = 0;
        iArr4[42] = 0;
        iArr4[45] = 0;
        iArr4[43] = 0;
        O00000o0 = iArr4;
        int[] iArr5 = new int[256];
        int[] iArr6 = O00000o0;
        System.arraycopy(iArr6, 0, iArr5, 0, iArr6.length);
        Arrays.fill(iArr5, (int) NotificationCompat.FLAG_HIGH_PRIORITY, (int) NotificationCompat.FLAG_HIGH_PRIORITY, 0);
        O00000o = iArr5;
        System.arraycopy(O00000Oo, NotificationCompat.FLAG_HIGH_PRIORITY, O00000oO, NotificationCompat.FLAG_HIGH_PRIORITY, NotificationCompat.FLAG_HIGH_PRIORITY);
        Arrays.fill(O00000oO, 0, 32, -1);
        int[] iArr7 = O00000oO;
        iArr7[9] = 0;
        iArr7[10] = 10;
        iArr7[13] = 13;
        iArr7[42] = 42;
        int[] iArr8 = new int[NotificationCompat.FLAG_HIGH_PRIORITY];
        for (int i5 = 0; i5 < 32; i5++) {
            iArr8[i5] = -1;
        }
        iArr8[34] = 34;
        iArr8[92] = 92;
        iArr8[8] = 98;
        iArr8[9] = 116;
        iArr8[12] = 102;
        iArr8[10] = 110;
        iArr8[13] = 114;
        O00000oo = iArr8;
        int[] iArr9 = new int[NotificationCompat.FLAG_HIGH_PRIORITY];
        O0000O0o = iArr9;
        Arrays.fill(iArr9, -1);
        for (int i6 = 0; i6 < 10; i6++) {
            O0000O0o[i6 + 48] = i6;
        }
        for (int i7 = 0; i7 < 6; i7++) {
            int[] iArr10 = O0000O0o;
            int i8 = i7 + 10;
            iArr10[i7 + 97] = i8;
            iArr10[i7 + 65] = i8;
        }
    }

    public static final int[] O000000o() {
        return f12392O000000o;
    }

    public static final int[] O00000Oo() {
        return O00000o0;
    }

    public static final int[] O00000o0() {
        return O00000oo;
    }

    public static int O000000o(int i) {
        if (i > 127) {
            return -1;
        }
        return O0000O0o[i];
    }

    public static void O000000o(StringBuilder sb, String str) {
        int[] iArr = O00000oo;
        int length = iArr.length;
        int length2 = str.length();
        for (int i = 0; i < length2; i++) {
            char charAt = str.charAt(i);
            if (charAt >= length || iArr[charAt] == 0) {
                sb.append(charAt);
            } else {
                sb.append('\\');
                int i2 = iArr[charAt];
                if (i2 < 0) {
                    sb.append('u');
                    sb.append('0');
                    sb.append('0');
                    int i3 = -(i2 + 1);
                    sb.append(O0000OOo[i3 >> 4]);
                    sb.append(O0000OOo[i3 & 15]);
                } else {
                    sb.append((char) i2);
                }
            }
        }
    }

    public static char[] O00000o() {
        return (char[]) O0000OOo.clone();
    }

    public static byte[] O00000oO() {
        return (byte[]) O0000Oo0.clone();
    }
}
