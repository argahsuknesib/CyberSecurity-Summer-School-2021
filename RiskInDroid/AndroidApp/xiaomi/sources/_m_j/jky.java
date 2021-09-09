package _m_j;

import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public final class jky {
    public static int O000000o(byte b) {
        return b < 0 ? b + 256 : b;
    }

    public static long O000000o(ByteBuffer byteBuffer) {
        long j = (long) byteBuffer.getInt();
        return j < 0 ? j + 4294967296L : j;
    }

    public static int O00000Oo(ByteBuffer byteBuffer) {
        return (O00000o0(byteBuffer) << 8) + 0 + O000000o(byteBuffer.get());
    }

    public static int O00000o0(ByteBuffer byteBuffer) {
        return (O000000o(byteBuffer.get()) << 8) + 0 + O000000o(byteBuffer.get());
    }

    public static int O00000o(ByteBuffer byteBuffer) {
        return O000000o(byteBuffer.get()) + 0 + (O000000o(byteBuffer.get()) << 8);
    }

    public static String O00000oO(ByteBuffer byteBuffer) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            byte b = byteBuffer.get();
            if (b == 0) {
                return jli.O000000o(byteArrayOutputStream.toByteArray());
            }
            byteArrayOutputStream.write(b);
        }
    }

    public static String O000000o(ByteBuffer byteBuffer, int i) {
        byte[] bArr = new byte[i];
        byteBuffer.get(bArr);
        return jli.O000000o(bArr);
    }

    public static long O00000oo(ByteBuffer byteBuffer) {
        long O000000o2 = (O000000o(byteBuffer) << 32) + 0;
        if (O000000o2 >= 0) {
            return O000000o2 + O000000o(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }

    public static double O0000O0o(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 65536.0d;
    }

    public static double O0000OOo(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        double d = (double) (0 | ((bArr[0] << 24) & -16777216) | ((bArr[1] << 16) & 16711680) | ((bArr[2] << 8) & 65280) | (bArr[3] & 255));
        Double.isNaN(d);
        return d / 1.073741824E9d;
    }

    public static float O0000Oo0(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[2];
        byteBuffer.get(bArr);
        return ((float) ((short) (((short) (0 | ((bArr[0] << 8) & 65280))) | (bArr[1] & 255)))) / 256.0f;
    }

    public static String O0000Oo(ByteBuffer byteBuffer) {
        int O00000o0 = O00000o0(byteBuffer);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            sb.append((char) (((O00000o0 >> ((2 - i) * 5)) & 31) + 96));
        }
        return sb.toString();
    }

    public static String O0000OoO(ByteBuffer byteBuffer) {
        byte[] bArr = new byte[4];
        byteBuffer.get(bArr);
        try {
            return new String(bArr, "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public static long O0000Ooo(ByteBuffer byteBuffer) {
        long O00000o0 = ((long) O00000o0(byteBuffer)) << 32;
        if (O00000o0 >= 0) {
            return O00000o0 + O000000o(byteBuffer);
        }
        throw new RuntimeException("I don't know how to deal with UInt64! long is not sufficient and I don't want to use BigInt");
    }
}
