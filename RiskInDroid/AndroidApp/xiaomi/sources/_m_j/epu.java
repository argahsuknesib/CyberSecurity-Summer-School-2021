package _m_j;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.GZIPInputStream;

public final class epu {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final byte[] f15712O000000o = {80, 85, 83, 72};
    private short O00000Oo;
    /* access modifiers changed from: private */
    public int O00000o;
    /* access modifiers changed from: private */
    public byte O00000o0;
    /* access modifiers changed from: private */
    public byte[] O00000oO;

    public interface O00000Oo {
        byte[] O000000o(byte[] bArr, int i);
    }

    public static final class O00000o implements O00000Oo {
        /* JADX WARNING: Removed duplicated region for block: B:15:0x001c A[SYNTHETIC, Splitter:B:15:0x001c] */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0022 A[SYNTHETIC, Splitter:B:21:0x0022] */
        public final byte[] O000000o(byte[] bArr, int i) {
            GZIPInputStream gZIPInputStream = null;
            try {
                GZIPInputStream gZIPInputStream2 = new GZIPInputStream(new ByteArrayInputStream(bArr), i);
                try {
                    byte[] bArr2 = new byte[i];
                    gZIPInputStream2.read(bArr2);
                    try {
                        gZIPInputStream2.close();
                    } catch (IOException unused) {
                    }
                    return bArr2;
                } catch (IOException unused2) {
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    return bArr;
                } catch (Throwable th) {
                    th = th;
                    gZIPInputStream = gZIPInputStream2;
                    if (gZIPInputStream != null) {
                    }
                    throw th;
                }
            } catch (IOException unused3) {
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused4) {
                    }
                }
                return bArr;
            } catch (Throwable th2) {
                th = th2;
                if (gZIPInputStream != null) {
                    try {
                        gZIPInputStream.close();
                    } catch (IOException unused5) {
                    }
                }
                throw th;
            }
        }
    }

    public static final class O00000o0 {
    }

    private epu(byte b, int i, byte[] bArr) {
        this(1, (byte) 0, i, bArr);
    }

    private epu(short s, byte b, int i, byte[] bArr) {
        this.O00000Oo = 1;
        this.O00000Oo = s;
        this.O00000o0 = b;
        this.O00000o = i;
        this.O00000oO = bArr;
    }

    private static boolean O000000o(byte[] bArr, byte[] bArr2, int i) {
        if (bArr.length < i || bArr2.length < i) {
            return false;
        }
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public static boolean O00000Oo(byte[] bArr) {
        byte[] bArr2 = f15712O000000o;
        return O000000o(bArr2, bArr, bArr2.length);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public static final O00000o0 f15713O000000o = new O00000o0();
        public static final O00000o O00000Oo = new O00000o();

        public static byte[] O000000o(byte[] bArr) {
            O00000o o00000o = O00000Oo;
            if (!epu.O00000Oo(bArr)) {
                return bArr;
            }
            epu O000000o2 = epu.O000000o(bArr);
            return (O000000o2.O00000o0 == 0 || O000000o2.O00000o0 != 2) ? O000000o2.O00000oO : o00000o.O000000o(O000000o2.O00000oO, O000000o2.O00000o);
        }
    }

    public static epu O000000o(byte[] bArr) {
        if (!O00000Oo(bArr)) {
            return new epu((byte) 0, bArr.length, bArr);
        }
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.BIG_ENDIAN);
        order.getInt();
        short s = order.getShort();
        byte b = order.get();
        int i = order.getInt();
        byte[] bArr2 = new byte[order.getInt()];
        order.get(bArr2);
        return new epu(s, b, i, bArr2);
    }
}
