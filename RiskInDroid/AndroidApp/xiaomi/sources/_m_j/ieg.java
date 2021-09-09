package _m_j;

import com.xiaomi.zxing.FormatException;

public final class ieg {
    private static final ieg[] O0000OOo = {new ieg(1, 10, 10, 8, 8, new O00000Oo(5, new O000000o(1, 3, (byte) 0), (byte) 0)), new ieg(2, 12, 12, 10, 10, new O00000Oo(7, new O000000o(1, 5, (byte) 0), (byte) 0)), new ieg(3, 14, 14, 12, 12, new O00000Oo(10, new O000000o(1, 8, (byte) 0), (byte) 0)), new ieg(4, 16, 16, 14, 14, new O00000Oo(12, new O000000o(1, 12, (byte) 0), (byte) 0)), new ieg(5, 18, 18, 16, 16, new O00000Oo(14, new O000000o(1, 18, (byte) 0), (byte) 0)), new ieg(6, 20, 20, 18, 18, new O00000Oo(18, new O000000o(1, 22, (byte) 0), (byte) 0)), new ieg(7, 22, 22, 20, 20, new O00000Oo(20, new O000000o(1, 30, (byte) 0), (byte) 0)), new ieg(8, 24, 24, 22, 22, new O00000Oo(24, new O000000o(1, 36, (byte) 0), (byte) 0)), new ieg(9, 26, 26, 24, 24, new O00000Oo(28, new O000000o(1, 44, (byte) 0), (byte) 0)), new ieg(10, 32, 32, 14, 14, new O00000Oo(36, new O000000o(1, 62, (byte) 0), (byte) 0)), new ieg(11, 36, 36, 16, 16, new O00000Oo(42, new O000000o(1, 86, (byte) 0), (byte) 0)), new ieg(12, 40, 40, 18, 18, new O00000Oo(48, new O000000o(1, 114, (byte) 0), (byte) 0)), new ieg(13, 44, 44, 20, 20, new O00000Oo(56, new O000000o(1, 144, (byte) 0), (byte) 0)), new ieg(14, 48, 48, 22, 22, new O00000Oo(68, new O000000o(1, 174, (byte) 0), (byte) 0)), new ieg(15, 52, 52, 24, 24, new O00000Oo(42, new O000000o(2, 102, (byte) 0), (byte) 0)), new ieg(16, 64, 64, 14, 14, new O00000Oo(56, new O000000o(2, 140, (byte) 0), (byte) 0)), new ieg(17, 72, 72, 16, 16, new O00000Oo(36, new O000000o(4, 92, (byte) 0), (byte) 0)), new ieg(18, 80, 80, 18, 18, new O00000Oo(48, new O000000o(4, 114, (byte) 0), (byte) 0)), new ieg(19, 88, 88, 20, 20, new O00000Oo(56, new O000000o(4, 144, (byte) 0), (byte) 0)), new ieg(20, 96, 96, 22, 22, new O00000Oo(68, new O000000o(4, 174, (byte) 0), (byte) 0)), new ieg(21, 104, 104, 24, 24, new O00000Oo(56, new O000000o(6, 136, (byte) 0), (byte) 0)), new ieg(22, 120, 120, 18, 18, new O00000Oo(68, new O000000o(6, 175, (byte) 0), (byte) 0)), new ieg(23, 132, 132, 20, 20, new O00000Oo(62, new O000000o(8, 163, (byte) 0), (byte) 0)), new ieg(24, 144, 144, 22, 22, new O00000Oo(new O000000o(8, 156, (byte) 0), new O000000o(2, 155, (byte) 0))), new ieg(25, 8, 18, 6, 16, new O00000Oo(7, new O000000o(1, 5, (byte) 0), (byte) 0)), new ieg(26, 8, 32, 6, 14, new O00000Oo(11, new O000000o(1, 10, (byte) 0), (byte) 0)), new ieg(27, 12, 26, 10, 24, new O00000Oo(14, new O000000o(1, 16, (byte) 0), (byte) 0)), new ieg(28, 12, 36, 10, 16, new O00000Oo(18, new O000000o(1, 22, (byte) 0), (byte) 0)), new ieg(29, 16, 36, 14, 16, new O00000Oo(24, new O000000o(1, 32, (byte) 0), (byte) 0)), new ieg(30, 16, 48, 14, 22, new O00000Oo(28, new O000000o(1, 49, (byte) 0), (byte) 0))};

    /* renamed from: O000000o  reason: collision with root package name */
    final int f1231O000000o;
    final int O00000Oo;
    final int O00000o;
    final int O00000o0;
    final int O00000oO;
    final O00000Oo O00000oo;
    final int O0000O0o;

    private ieg(int i, int i2, int i3, int i4, int i5, O00000Oo o00000Oo) {
        this.f1231O000000o = i;
        this.O00000Oo = i2;
        this.O00000o0 = i3;
        this.O00000o = i4;
        this.O00000oO = i5;
        this.O00000oo = o00000Oo;
        int i6 = o00000Oo.f1233O000000o;
        int i7 = 0;
        for (O000000o o000000o : o00000Oo.O00000Oo) {
            i7 += o000000o.f1232O000000o * (o000000o.O00000Oo + i6);
        }
        this.O0000O0o = i7;
    }

    public static ieg O000000o(int i, int i2) throws FormatException {
        if ((i & 1) == 0 && (i2 & 1) == 0) {
            for (ieg ieg : O0000OOo) {
                if (ieg.O00000Oo == i && ieg.O00000o0 == i2) {
                    return ieg;
                }
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    static final class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f1233O000000o;
        final O000000o[] O00000Oo;

        /* synthetic */ O00000Oo(int i, O000000o o000000o, byte b) {
            this(i, o000000o);
        }

        /* synthetic */ O00000Oo(O000000o o000000o, O000000o o000000o2) {
            this(62, o000000o, o000000o2);
        }

        private O00000Oo(int i, O000000o o000000o) {
            this.f1233O000000o = i;
            this.O00000Oo = new O000000o[]{o000000o};
        }

        private O00000Oo(int i, O000000o o000000o, O000000o o000000o2) {
            this.f1233O000000o = 62;
            this.O00000Oo = new O000000o[]{o000000o, o000000o2};
        }
    }

    static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        final int f1232O000000o;
        final int O00000Oo;

        /* synthetic */ O000000o(int i, int i2, byte b) {
            this(i, i2);
        }

        private O000000o(int i, int i2) {
            this.f1232O000000o = i;
            this.O00000Oo = i2;
        }
    }

    public final String toString() {
        return String.valueOf(this.f1231O000000o);
    }
}
