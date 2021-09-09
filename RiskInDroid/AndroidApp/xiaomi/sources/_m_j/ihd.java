package _m_j;

import android.support.v4.app.NotificationCompat;
import com.xiaomi.zxing.FormatException;
import com.xiaomi.zxing.qrcode.decoder.ErrorCorrectionLevel;

public final class ihd {
    private static final int[] O00000o = {31892, 34236, 39577, 42195, 48118, 51042, 55367, 58893, 63784, 68472, 70749, 76311, 79154, 84390, 87683, 92361, 96236, 102084, 102881, 110507, 110734, 117786, 119615, 126325, 127568, 133589, 136944, 141498, 145311, 150283, 152622, 158308, 161089, 167017};
    private static final ihd[] O00000oO = O00000Oo();

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1290O000000o;
    public final int[] O00000Oo;
    public final int O00000o0;
    private final O00000Oo[] O00000oo;

    private ihd(int i, int[] iArr, O00000Oo... o00000OoArr) {
        this.f1290O000000o = i;
        this.O00000Oo = iArr;
        this.O00000oo = o00000OoArr;
        int i2 = o00000OoArr[0].f1292O000000o;
        int i3 = 0;
        for (O000000o o000000o : o00000OoArr[0].O00000Oo) {
            i3 += o000000o.f1291O000000o * (o000000o.O00000Oo + i2);
        }
        this.O00000o0 = i3;
    }

    public final int O000000o() {
        return (this.f1290O000000o * 4) + 17;
    }

    public final O00000Oo O000000o(ErrorCorrectionLevel errorCorrectionLevel) {
        return this.O00000oo[errorCorrectionLevel.ordinal()];
    }

    public static ihd O000000o(int i) throws FormatException {
        if (i % 4 == 1) {
            try {
                return O00000Oo((i - 17) / 4);
            } catch (IllegalArgumentException unused) {
                throw FormatException.getFormatInstance();
            }
        } else {
            throw FormatException.getFormatInstance();
        }
    }

    public static ihd O00000Oo(int i) {
        if (i > 0 && i <= 40) {
            return O00000oO[i - 1];
        }
        throw new IllegalArgumentException();
    }

    static ihd O00000o0(int i) {
        int i2 = 0;
        int i3 = Integer.MAX_VALUE;
        int i4 = 0;
        while (true) {
            int[] iArr = O00000o;
            if (i2 < iArr.length) {
                int i5 = iArr[i2];
                if (i5 == i) {
                    return O00000Oo(i2 + 7);
                }
                int O000000o2 = ihb.O000000o(i, i5);
                if (O000000o2 < i3) {
                    i4 = i2 + 7;
                    i3 = O000000o2;
                }
                i2++;
            } else if (i3 <= 3) {
                return O00000Oo(i4);
            } else {
                return null;
            }
        }
    }

    public static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f1292O000000o;
        final O000000o[] O00000Oo;

        O00000Oo(int i, O000000o... o000000oArr) {
            this.f1292O000000o = i;
            this.O00000Oo = o000000oArr;
        }

        public final int O000000o() {
            int i = 0;
            for (O000000o o000000o : this.O00000Oo) {
                i += o000000o.f1291O000000o;
            }
            return i;
        }

        public final int O00000Oo() {
            return this.f1292O000000o * O000000o();
        }
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f1291O000000o;
        final int O00000Oo;

        O000000o(int i, int i2) {
            this.f1291O000000o = i;
            this.O00000Oo = i2;
        }
    }

    public final String toString() {
        return String.valueOf(this.f1290O000000o);
    }

    private static ihd[] O00000Oo() {
        return new ihd[]{new ihd(1, new int[0], new O00000Oo(7, new O000000o(1, 19)), new O00000Oo(10, new O000000o(1, 16)), new O00000Oo(13, new O000000o(1, 13)), new O00000Oo(17, new O000000o(1, 9))), new ihd(2, new int[]{6, 18}, new O00000Oo(10, new O000000o(1, 34)), new O00000Oo(16, new O000000o(1, 28)), new O00000Oo(22, new O000000o(1, 22)), new O00000Oo(28, new O000000o(1, 16))), new ihd(3, new int[]{6, 22}, new O00000Oo(15, new O000000o(1, 55)), new O00000Oo(26, new O000000o(1, 44)), new O00000Oo(18, new O000000o(2, 17)), new O00000Oo(22, new O000000o(2, 13))), new ihd(4, new int[]{6, 26}, new O00000Oo(20, new O000000o(1, 80)), new O00000Oo(18, new O000000o(2, 32)), new O00000Oo(26, new O000000o(2, 24)), new O00000Oo(16, new O000000o(4, 9))), new ihd(5, new int[]{6, 30}, new O00000Oo(26, new O000000o(1, 108)), new O00000Oo(24, new O000000o(2, 43)), new O00000Oo(18, new O000000o(2, 15), new O000000o(2, 16)), new O00000Oo(22, new O000000o(2, 11), new O000000o(2, 12))), new ihd(6, new int[]{6, 34}, new O00000Oo(18, new O000000o(2, 68)), new O00000Oo(16, new O000000o(4, 27)), new O00000Oo(24, new O000000o(4, 19)), new O00000Oo(28, new O000000o(4, 15))), new ihd(7, new int[]{6, 22, 38}, new O00000Oo(20, new O000000o(2, 78)), new O00000Oo(18, new O000000o(4, 31)), new O00000Oo(18, new O000000o(2, 14), new O000000o(4, 15)), new O00000Oo(26, new O000000o(4, 13), new O000000o(1, 14))), new ihd(8, new int[]{6, 24, 42}, new O00000Oo(24, new O000000o(2, 97)), new O00000Oo(22, new O000000o(2, 38), new O000000o(2, 39)), new O00000Oo(22, new O000000o(4, 18), new O000000o(2, 19)), new O00000Oo(26, new O000000o(4, 14), new O000000o(2, 15))), new ihd(9, new int[]{6, 26, 46}, new O00000Oo(30, new O000000o(2, 116)), new O00000Oo(22, new O000000o(3, 36), new O000000o(2, 37)), new O00000Oo(20, new O000000o(4, 16), new O000000o(4, 17)), new O00000Oo(24, new O000000o(4, 12), new O000000o(4, 13))), new ihd(10, new int[]{6, 28, 50}, new O00000Oo(18, new O000000o(2, 68), new O000000o(2, 69)), new O00000Oo(26, new O000000o(4, 43), new O000000o(1, 44)), new O00000Oo(24, new O000000o(6, 19), new O000000o(2, 20)), new O00000Oo(28, new O000000o(6, 15), new O000000o(2, 16))), new ihd(11, new int[]{6, 30, 54}, new O00000Oo(20, new O000000o(4, 81)), new O00000Oo(30, new O000000o(1, 50), new O000000o(4, 51)), new O00000Oo(28, new O000000o(4, 22), new O000000o(4, 23)), new O00000Oo(24, new O000000o(3, 12), new O000000o(8, 13))), new ihd(12, new int[]{6, 32, 58}, new O00000Oo(24, new O000000o(2, 92), new O000000o(2, 93)), new O00000Oo(22, new O000000o(6, 36), new O000000o(2, 37)), new O00000Oo(26, new O000000o(4, 20), new O000000o(6, 21)), new O00000Oo(28, new O000000o(7, 14), new O000000o(4, 15))), new ihd(13, new int[]{6, 34, 62}, new O00000Oo(26, new O000000o(4, 107)), new O00000Oo(22, new O000000o(8, 37), new O000000o(1, 38)), new O00000Oo(24, new O000000o(8, 20), new O000000o(4, 21)), new O00000Oo(22, new O000000o(12, 11), new O000000o(4, 12))), new ihd(14, new int[]{6, 26, 46, 66}, new O00000Oo(30, new O000000o(3, 115), new O000000o(1, 116)), new O00000Oo(24, new O000000o(4, 40), new O000000o(5, 41)), new O00000Oo(20, new O000000o(11, 16), new O000000o(5, 17)), new O00000Oo(24, new O000000o(11, 12), new O000000o(5, 13))), new ihd(15, new int[]{6, 26, 48, 70}, new O00000Oo(22, new O000000o(5, 87), new O000000o(1, 88)), new O00000Oo(24, new O000000o(5, 41), new O000000o(5, 42)), new O00000Oo(30, new O000000o(5, 24), new O000000o(7, 25)), new O00000Oo(24, new O000000o(11, 12), new O000000o(7, 13))), new ihd(16, new int[]{6, 26, 50, 74}, new O00000Oo(24, new O000000o(5, 98), new O000000o(1, 99)), new O00000Oo(28, new O000000o(7, 45), new O000000o(3, 46)), new O00000Oo(24, new O000000o(15, 19), new O000000o(2, 20)), new O00000Oo(30, new O000000o(3, 15), new O000000o(13, 16))), new ihd(17, new int[]{6, 30, 54, 78}, new O00000Oo(28, new O000000o(1, 107), new O000000o(5, 108)), new O00000Oo(28, new O000000o(10, 46), new O000000o(1, 47)), new O00000Oo(28, new O000000o(1, 22), new O000000o(15, 23)), new O00000Oo(28, new O000000o(2, 14), new O000000o(17, 15))), new ihd(18, new int[]{6, 30, 56, 82}, new O00000Oo(30, new O000000o(5, 120), new O000000o(1, 121)), new O00000Oo(26, new O000000o(9, 43), new O000000o(4, 44)), new O00000Oo(28, new O000000o(17, 22), new O000000o(1, 23)), new O00000Oo(28, new O000000o(2, 14), new O000000o(19, 15))), new ihd(19, new int[]{6, 30, 58, 86}, new O00000Oo(28, new O000000o(3, 113), new O000000o(4, 114)), new O00000Oo(26, new O000000o(3, 44), new O000000o(11, 45)), new O00000Oo(26, new O000000o(17, 21), new O000000o(4, 22)), new O00000Oo(26, new O000000o(9, 13), new O000000o(16, 14))), new ihd(20, new int[]{6, 34, 62, 90}, new O00000Oo(28, new O000000o(3, 107), new O000000o(5, 108)), new O00000Oo(26, new O000000o(3, 41), new O000000o(13, 42)), new O00000Oo(30, new O000000o(15, 24), new O000000o(5, 25)), new O00000Oo(28, new O000000o(15, 15), new O000000o(10, 16))), new ihd(21, new int[]{6, 28, 50, 72, 94}, new O00000Oo(28, new O000000o(4, 116), new O000000o(4, 117)), new O00000Oo(26, new O000000o(17, 42)), new O00000Oo(28, new O000000o(17, 22), new O000000o(6, 23)), new O00000Oo(30, new O000000o(19, 16), new O000000o(6, 17))), new ihd(22, new int[]{6, 26, 50, 74, 98}, new O00000Oo(28, new O000000o(2, 111), new O000000o(7, 112)), new O00000Oo(28, new O000000o(17, 46)), new O00000Oo(30, new O000000o(7, 24), new O000000o(16, 25)), new O00000Oo(24, new O000000o(34, 13))), new ihd(23, new int[]{6, 30, 54, 78, 102}, new O00000Oo(30, new O000000o(4, 121), new O000000o(5, 122)), new O00000Oo(28, new O000000o(4, 47), new O000000o(14, 48)), new O00000Oo(30, new O000000o(11, 24), new O000000o(14, 25)), new O00000Oo(30, new O000000o(16, 15), new O000000o(14, 16))), new ihd(24, new int[]{6, 28, 54, 80, 106}, new O00000Oo(30, new O000000o(6, 117), new O000000o(4, 118)), new O00000Oo(28, new O000000o(6, 45), new O000000o(14, 46)), new O00000Oo(30, new O000000o(11, 24), new O000000o(16, 25)), new O00000Oo(30, new O000000o(30, 16), new O000000o(2, 17))), new ihd(25, new int[]{6, 32, 58, 84, 110}, new O00000Oo(26, new O000000o(8, 106), new O000000o(4, 107)), new O00000Oo(28, new O000000o(8, 47), new O000000o(13, 48)), new O00000Oo(30, new O000000o(7, 24), new O000000o(22, 25)), new O00000Oo(30, new O000000o(22, 15), new O000000o(13, 16))), new ihd(26, new int[]{6, 30, 58, 86, 114}, new O00000Oo(28, new O000000o(10, 114), new O000000o(2, 115)), new O00000Oo(28, new O000000o(19, 46), new O000000o(4, 47)), new O00000Oo(28, new O000000o(28, 22), new O000000o(6, 23)), new O00000Oo(30, new O000000o(33, 16), new O000000o(4, 17))), new ihd(27, new int[]{6, 34, 62, 90, 118}, new O00000Oo(30, new O000000o(8, 122), new O000000o(4, 123)), new O00000Oo(28, new O000000o(22, 45), new O000000o(3, 46)), new O00000Oo(30, new O000000o(8, 23), new O000000o(26, 24)), new O00000Oo(30, new O000000o(12, 15), new O000000o(28, 16))), new ihd(28, new int[]{6, 26, 50, 74, 98, 122}, new O00000Oo(30, new O000000o(3, 117), new O000000o(10, 118)), new O00000Oo(28, new O000000o(3, 45), new O000000o(23, 46)), new O00000Oo(30, new O000000o(4, 24), new O000000o(31, 25)), new O00000Oo(30, new O000000o(11, 15), new O000000o(31, 16))), new ihd(29, new int[]{6, 30, 54, 78, 102, 126}, new O00000Oo(30, new O000000o(7, 116), new O000000o(7, 117)), new O00000Oo(28, new O000000o(21, 45), new O000000o(7, 46)), new O00000Oo(30, new O000000o(1, 23), new O000000o(37, 24)), new O00000Oo(30, new O000000o(19, 15), new O000000o(26, 16))), new ihd(30, new int[]{6, 26, 52, 78, 104, 130}, new O00000Oo(30, new O000000o(5, 115), new O000000o(10, 116)), new O00000Oo(28, new O000000o(19, 47), new O000000o(10, 48)), new O00000Oo(30, new O000000o(15, 24), new O000000o(25, 25)), new O00000Oo(30, new O000000o(23, 15), new O000000o(25, 16))), new ihd(31, new int[]{6, 30, 56, 82, 108, 134}, new O00000Oo(30, new O000000o(13, 115), new O000000o(3, 116)), new O00000Oo(28, new O000000o(2, 46), new O000000o(29, 47)), new O00000Oo(30, new O000000o(42, 24), new O000000o(1, 25)), new O00000Oo(30, new O000000o(23, 15), new O000000o(28, 16))), new ihd(32, new int[]{6, 34, 60, 86, 112, 138}, new O00000Oo(30, new O000000o(17, 115)), new O00000Oo(28, new O000000o(10, 46), new O000000o(23, 47)), new O00000Oo(30, new O000000o(10, 24), new O000000o(35, 25)), new O00000Oo(30, new O000000o(19, 15), new O000000o(35, 16))), new ihd(33, new int[]{6, 30, 58, 86, 114, 142}, new O00000Oo(30, new O000000o(17, 115), new O000000o(1, 116)), new O00000Oo(28, new O000000o(14, 46), new O000000o(21, 47)), new O00000Oo(30, new O000000o(29, 24), new O000000o(19, 25)), new O00000Oo(30, new O000000o(11, 15), new O000000o(46, 16))), new ihd(34, new int[]{6, 34, 62, 90, 118, 146}, new O00000Oo(30, new O000000o(13, 115), new O000000o(6, 116)), new O00000Oo(28, new O000000o(14, 46), new O000000o(23, 47)), new O00000Oo(30, new O000000o(44, 24), new O000000o(7, 25)), new O00000Oo(30, new O000000o(59, 16), new O000000o(1, 17))), new ihd(35, new int[]{6, 30, 54, 78, 102, 126, 150}, new O00000Oo(30, new O000000o(12, 121), new O000000o(7, 122)), new O00000Oo(28, new O000000o(12, 47), new O000000o(26, 48)), new O00000Oo(30, new O000000o(39, 24), new O000000o(14, 25)), new O00000Oo(30, new O000000o(22, 15), new O000000o(41, 16))), new ihd(36, new int[]{6, 24, 50, 76, 102, NotificationCompat.FLAG_HIGH_PRIORITY, 154}, new O00000Oo(30, new O000000o(6, 121), new O000000o(14, 122)), new O00000Oo(28, new O000000o(6, 47), new O000000o(34, 48)), new O00000Oo(30, new O000000o(46, 24), new O000000o(10, 25)), new O00000Oo(30, new O000000o(2, 15), new O000000o(64, 16))), new ihd(37, new int[]{6, 28, 54, 80, 106, 132, 158}, new O00000Oo(30, new O000000o(17, 122), new O000000o(4, 123)), new O00000Oo(28, new O000000o(29, 46), new O000000o(14, 47)), new O00000Oo(30, new O000000o(49, 24), new O000000o(10, 25)), new O00000Oo(30, new O000000o(24, 15), new O000000o(46, 16))), new ihd(38, new int[]{6, 32, 58, 84, 110, 136, 162}, new O00000Oo(30, new O000000o(4, 122), new O000000o(18, 123)), new O00000Oo(28, new O000000o(13, 46), new O000000o(32, 47)), new O00000Oo(30, new O000000o(48, 24), new O000000o(14, 25)), new O00000Oo(30, new O000000o(42, 15), new O000000o(32, 16))), new ihd(39, new int[]{6, 26, 54, 82, 110, 138, 166}, new O00000Oo(30, new O000000o(20, 117), new O000000o(4, 118)), new O00000Oo(28, new O000000o(40, 47), new O000000o(7, 48)), new O00000Oo(30, new O000000o(43, 24), new O000000o(22, 25)), new O00000Oo(30, new O000000o(10, 15), new O000000o(67, 16))), new ihd(40, new int[]{6, 30, 58, 86, 114, 142, 170}, new O00000Oo(30, new O000000o(19, 118), new O000000o(6, 119)), new O00000Oo(28, new O000000o(18, 47), new O000000o(31, 48)), new O00000Oo(30, new O000000o(34, 24), new O000000o(34, 25)), new O00000Oo(30, new O000000o(20, 15), new O000000o(61, 16)))};
    }
}
