package _m_j;

import android.support.v4.app.NotificationCompat;

public final class bdn {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final char[] f12885O000000o = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    public static final boolean[] O00000Oo = new boolean[256];
    public static final boolean[] O00000o = new boolean[NotificationCompat.FLAG_HIGH_PRIORITY];
    public static final boolean[] O00000o0 = new boolean[256];
    public static final boolean[] O00000oO = new boolean[NotificationCompat.FLAG_HIGH_PRIORITY];
    public static final char[] O00000oo = new char[NotificationCompat.FLAG_HIGH_PRIORITY];
    public static final char[] O0000O0o = {'0', '0', '0', '1', '0', '2', '0', '3', '0', '4', '0', '5', '0', '6', '0', '7', '0', '8', '0', '9', '0', 'A', '0', 'B', '0', 'C', '0', 'D', '0', 'E', '0', 'F', '1', '0', '1', '1', '1', '2', '1', '3', '1', '4', '1', '5', '1', '6', '1', '7', '1', '8', '1', '9', '1', 'A', '1', 'B', '1', 'C', '1', 'D', '1', 'E', '1', 'F', '2', '0', '2', '1', '2', '2', '2', '3', '2', '4', '2', '5', '2', '6', '2', '7', '2', '8', '2', '9', '2', 'A', '2', 'B', '2', 'C', '2', 'D', '2', 'E', '2', 'F'};

    static {
        char c = 0;
        while (true) {
            boolean[] zArr = O00000Oo;
            if (c >= zArr.length) {
                break;
            }
            if (c >= 'A' && c <= 'Z') {
                zArr[c] = true;
            } else if (c >= 'a' && c <= 'z') {
                O00000Oo[c] = true;
            } else if (c == '_') {
                O00000Oo[c] = true;
            }
            c = (char) (c + 1);
        }
        char c2 = 0;
        while (true) {
            boolean[] zArr2 = O00000o0;
            if (c2 < zArr2.length) {
                if (c2 >= 'A' && c2 <= 'Z') {
                    zArr2[c2] = true;
                } else if (c2 >= 'a' && c2 <= 'z') {
                    O00000o0[c2] = true;
                } else if (c2 == '_') {
                    O00000o0[c2] = true;
                } else if (c2 >= '0' && c2 <= '9') {
                    O00000o0[c2] = true;
                }
                c2 = (char) (c2 + 1);
            } else {
                boolean[] zArr3 = O00000o;
                zArr3[0] = true;
                zArr3[1] = true;
                zArr3[2] = true;
                zArr3[3] = true;
                zArr3[4] = true;
                zArr3[5] = true;
                zArr3[6] = true;
                zArr3[7] = true;
                zArr3[8] = true;
                zArr3[9] = true;
                zArr3[10] = true;
                zArr3[11] = true;
                zArr3[12] = true;
                zArr3[13] = true;
                zArr3[34] = true;
                zArr3[92] = true;
                boolean[] zArr4 = O00000oO;
                zArr4[0] = true;
                zArr4[1] = true;
                zArr4[2] = true;
                zArr4[3] = true;
                zArr4[4] = true;
                zArr4[5] = true;
                zArr4[6] = true;
                zArr4[7] = true;
                zArr4[8] = true;
                zArr4[9] = true;
                zArr4[10] = true;
                zArr4[11] = true;
                zArr4[12] = true;
                zArr4[13] = true;
                zArr4[39] = true;
                zArr4[92] = true;
                char[] cArr = O00000oo;
                cArr[0] = '0';
                cArr[1] = '1';
                cArr[2] = '2';
                cArr[3] = '3';
                cArr[4] = '4';
                cArr[5] = '5';
                cArr[6] = '6';
                cArr[7] = '7';
                cArr[8] = 'b';
                cArr[9] = 't';
                cArr[10] = 'n';
                cArr[11] = 'v';
                cArr[12] = 'f';
                cArr[13] = 'r';
                cArr[34] = '\"';
                cArr[39] = '\'';
                cArr[47] = '/';
                cArr[92] = '\\';
                return;
            }
        }
    }
}
