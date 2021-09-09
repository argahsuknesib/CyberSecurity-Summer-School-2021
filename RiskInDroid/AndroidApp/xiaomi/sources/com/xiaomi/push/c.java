package com.xiaomi.push;

import _m_j.elb;
import _m_j.eor;
import _m_j.epn;
import android.support.v4.app.NotificationCompat;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class c {

    /* renamed from: O000000o  reason: collision with root package name */
    public final OutputStream f6372O000000o;
    private final byte[] O00000Oo;
    private int O00000o;
    private final int O00000o0;

    public static class a extends IOException {
        a() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    public c(OutputStream outputStream, byte[] bArr) {
        this.f6372O000000o = outputStream;
        this.O00000Oo = bArr;
        this.O00000o = 0;
        this.O00000o0 = 4096;
    }

    private c(byte[] bArr, int i, int i2) {
        this.f6372O000000o = null;
        this.O00000Oo = bArr;
        this.O00000o = i;
        this.O00000o0 = i + i2;
    }

    public static int O000000o(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return O00000oO(bytes.length) + bytes.length;
        } catch (UnsupportedEncodingException unused) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    public static c O000000o(byte[] bArr, int i, int i2) {
        return new c(bArr, i, i2);
    }

    private void O000000o(byte b) {
        if (this.O00000o == this.O00000o0) {
            O000000o();
        }
        byte[] bArr = this.O00000Oo;
        int i = this.O00000o;
        this.O00000o = i + 1;
        bArr[i] = b;
    }

    private void O000000o(byte[] bArr, int i) {
        int i2 = this.O00000o0;
        int i3 = this.O00000o;
        if (i2 - i3 >= i) {
            System.arraycopy(bArr, 0, this.O00000Oo, i3, i);
            this.O00000o += i;
            return;
        }
        int i4 = i2 - i3;
        System.arraycopy(bArr, 0, this.O00000Oo, i3, i4);
        int i5 = i4 + 0;
        int i6 = i - i4;
        this.O00000o = this.O00000o0;
        O000000o();
        if (i6 <= this.O00000o0) {
            System.arraycopy(bArr, i5, this.O00000Oo, 0, i6);
            this.O00000o = i6;
            return;
        }
        this.f6372O000000o.write(bArr, i5, i6);
    }

    public static int O00000Oo(int i, String str) {
        return O00000o0(i) + O000000o(str);
    }

    public static int O00000o0(int i) {
        return O00000oO(epn.O000000o(i, 0));
    }

    private static int O00000o0(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        return (j & Long.MIN_VALUE) == 0 ? 9 : 10;
    }

    private static int O00000oO(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public final void O000000o() {
        OutputStream outputStream = this.f6372O000000o;
        if (outputStream != null) {
            outputStream.write(this.O00000Oo, 0, this.O00000o);
            this.O00000o = 0;
            return;
        }
        throw new a();
    }

    public final void O00000o0(int i, int i2) {
        O00000o(epn.O000000o(i, i2));
    }

    public final void O000000o(int i, long j) {
        O00000o0(i, 0);
        O00000Oo(j);
    }

    public final void O000000o(int i, int i2) {
        O00000o0(i, 0);
        if (i2 >= 0) {
            O00000o(i2);
        } else {
            O00000Oo((long) i2);
        }
    }

    public final void O000000o(int i, boolean z) {
        O00000o0(i, 0);
        O000000o(z ? (byte) 1 : 0);
    }

    public final void O000000o(int i, String str) {
        O00000o0(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        O00000o(bytes.length);
        O000000o(bytes, bytes.length);
    }

    public final void O000000o(int i, eor eor) {
        O00000o0(i, 2);
        O00000o(eor.O000000o());
        eor.O000000o(this);
    }

    public final void O000000o(elb elb) {
        O00000o0(1, 2);
        int length = elb.f15603O000000o.length;
        byte[] bArr = new byte[length];
        System.arraycopy(elb.f15603O000000o, 0, bArr, 0, length);
        O00000o(length);
        O000000o(bArr, bArr.length);
    }

    public final void O000000o(int i) {
        O00000o0(1, 0);
        O00000o(i);
    }

    public static int O00000Oo(int i, long j) {
        return O00000o0(i) + O00000o0(j);
    }

    public static int O000000o(long j) {
        return O00000o0(2) + O00000o0(j);
    }

    public static int O00000Oo(int i, int i2) {
        return O00000o0(i) + (i2 >= 0 ? O00000oO(i2) : 10);
    }

    public static int O00000Oo(int i, eor eor) {
        int O00000o02 = O00000o0(i);
        int O00000Oo2 = eor.O00000Oo();
        return O00000o02 + O00000oO(O00000Oo2) + O00000Oo2;
    }

    public static int O00000Oo(elb elb) {
        return O00000o0(1) + O00000oO(elb.f15603O000000o.length) + elb.f15603O000000o.length;
    }

    public static int O00000Oo(int i) {
        return O00000o0(1) + O00000oO(i);
    }

    public final void O00000Oo() {
        if (this.f6372O000000o != null) {
            throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
        } else if (this.O00000o0 - this.O00000o != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    private void O00000o(int i) {
        while ((i & -128) != 0) {
            O000000o((byte) ((i & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
            i >>>= 7;
        }
        O000000o((byte) i);
    }

    public final void O00000Oo(long j) {
        while ((-128 & j) != 0) {
            O000000o((byte) ((((int) j) & 127) | NotificationCompat.FLAG_HIGH_PRIORITY));
            j >>>= 7;
        }
        O000000o((byte) ((int) j));
    }
}
