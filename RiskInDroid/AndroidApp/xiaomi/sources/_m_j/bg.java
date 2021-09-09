package _m_j;

import java.io.PrintWriter;

public final class bg {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f12940O000000o = new Object();
    private static char[] O00000Oo = new char[24];

    private static int O000000o(char[] cArr, int i, char c, int i2, boolean z, int i3) {
        int i4;
        if (!z && i <= 0) {
            return i2;
        }
        if (i > 99) {
            int i5 = i / 100;
            cArr[i2] = (char) (i5 + 48);
            i4 = i2 + 1;
            i -= i5 * 100;
        } else {
            i4 = i2;
        }
        if (i > 9 || i2 != i4) {
            int i6 = i / 10;
            cArr[i4] = (char) (i6 + 48);
            i4++;
            i -= i6 * 10;
        }
        cArr[i4] = (char) (i + 48);
        int i7 = i4 + 1;
        cArr[i7] = c;
        return i7 + 1;
    }

    private static void O00000Oo(long j, PrintWriter printWriter) {
        char c;
        int i;
        int i2;
        int i3;
        int i4;
        synchronized (f12940O000000o) {
            if (O00000Oo.length < 0) {
                O00000Oo = new char[0];
            }
            char[] cArr = O00000Oo;
            int i5 = 1;
            if (j == 0) {
                cArr[0] = '0';
            } else {
                if (j > 0) {
                    c = '+';
                } else {
                    c = '-';
                    j = -j;
                }
                int i6 = (int) (j % 1000);
                int floor = (int) Math.floor((double) (j / 1000));
                if (floor > 86400) {
                    i = floor / 86400;
                    floor -= 86400 * i;
                } else {
                    i = 0;
                }
                if (floor > 3600) {
                    i2 = floor / 3600;
                    floor -= i2 * 3600;
                } else {
                    i2 = 0;
                }
                if (floor > 60) {
                    int i7 = floor / 60;
                    i4 = floor - (i7 * 60);
                    i3 = i7;
                } else {
                    i4 = floor;
                    i3 = 0;
                }
                cArr[0] = c;
                int O000000o2 = O000000o(cArr, i, 'd', 1, false, 0);
                int O000000o3 = O000000o(cArr, i2, 'h', O000000o2, O000000o2 != 1, 0);
                int O000000o4 = O000000o(cArr, i3, 'm', O000000o3, O000000o3 != 1, 0);
                int O000000o5 = O000000o(cArr, i6, 'm', O000000o(cArr, i4, 's', O000000o4, O000000o4 != 1, 0), true, 0);
                cArr[O000000o5] = 's';
                i5 = 1 + O000000o5;
            }
            printWriter.print(new String(O00000Oo, 0, i5));
        }
    }

    public static void O000000o(long j, PrintWriter printWriter) {
        O00000Oo(j, printWriter);
    }

    public static void O000000o(long j, long j2, PrintWriter printWriter) {
        if (j == 0) {
            printWriter.print("--");
        } else {
            O00000Oo(j - j2, printWriter);
        }
    }
}
