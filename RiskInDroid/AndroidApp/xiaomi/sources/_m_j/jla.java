package _m_j;

import java.nio.ByteBuffer;

public final class jla {

    /* renamed from: O000000o  reason: collision with root package name */
    static final /* synthetic */ boolean f1915O000000o = (!jla.class.desiredAssertionStatus());

    public static void O000000o(ByteBuffer byteBuffer, long j) {
        if (f1915O000000o || j >= 0) {
            byteBuffer.putLong(j);
            return;
        }
        throw new AssertionError("The given long is negative");
    }

    public static void O00000Oo(ByteBuffer byteBuffer, long j) {
        if (f1915O000000o || (j >= 0 && j <= 4294967296L)) {
            byteBuffer.putInt((int) j);
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    public static void O00000o0(ByteBuffer byteBuffer, long j) {
        if (f1915O000000o || (j >= 0 && j <= 4294967296L)) {
            O00000o0(byteBuffer, ((int) j) & 65535);
            O00000o0(byteBuffer, (int) ((j >> 16) & 65535));
            return;
        }
        throw new AssertionError("The given long is not in the range of uint32 (" + j + ")");
    }

    public static void O000000o(ByteBuffer byteBuffer, int i) {
        int i2 = i & 16777215;
        O00000Oo(byteBuffer, i2 >> 8);
        O00000o(byteBuffer, i2);
    }

    public static void O00000o(ByteBuffer byteBuffer, long j) {
        long j2 = j & 281474976710655L;
        O00000Oo(byteBuffer, (int) (j2 >> 32));
        O00000Oo(byteBuffer, j2 & 4294967295L);
    }

    public static void O00000Oo(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        O00000o(byteBuffer, i2 >> 8);
        O00000o(byteBuffer, i2 & 255);
    }

    public static void O00000o0(ByteBuffer byteBuffer, int i) {
        int i2 = i & 65535;
        O00000o(byteBuffer, i2 & 255);
        O00000o(byteBuffer, i2 >> 8);
    }

    public static void O00000o(ByteBuffer byteBuffer, int i) {
        byteBuffer.put((byte) (i & 255));
    }

    public static void O000000o(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 65536.0d);
        byteBuffer.put((byte) ((-16777216 & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    public static void O00000Oo(ByteBuffer byteBuffer, double d) {
        int i = (int) (d * 1.073741824E9d);
        byteBuffer.put((byte) ((-16777216 & i) >> 24));
        byteBuffer.put((byte) ((16711680 & i) >> 16));
        byteBuffer.put((byte) ((65280 & i) >> 8));
        byteBuffer.put((byte) (i & 255));
    }

    public static void O00000o0(ByteBuffer byteBuffer, double d) {
        short s = (short) ((int) (d * 256.0d));
        byteBuffer.put((byte) ((65280 & s) >> 8));
        byteBuffer.put((byte) (s & 255));
    }

    public static void O000000o(ByteBuffer byteBuffer, String str) {
        if (str.getBytes().length == 3) {
            int i = 0;
            for (int i2 = 0; i2 < 3; i2++) {
                i += (str.getBytes()[i2] - 96) << ((2 - i2) * 5);
            }
            O00000Oo(byteBuffer, i);
            return;
        }
        throw new IllegalArgumentException(jdn.f1779O000000o + str + "\" language string isn't exactly 3 characters long!");
    }

    public static void O00000Oo(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(jli.O000000o(str));
        O00000o(byteBuffer, 0);
    }

    public static void O00000o0(ByteBuffer byteBuffer, String str) {
        byteBuffer.put(jli.O000000o(str));
        O00000o(byteBuffer, 0);
    }
}
