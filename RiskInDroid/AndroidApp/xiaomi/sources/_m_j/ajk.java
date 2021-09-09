package _m_j;

import com.fasterxml.jackson.core.util.BufferRecycler;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;

public final class ajk extends OutputStream {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final byte[] f12404O000000o = new byte[0];
    private final BufferRecycler O00000Oo;
    private int O00000o;
    private final LinkedList<byte[]> O00000o0;
    private byte[] O00000oO;
    private int O00000oo;

    public final void close() {
    }

    public final void flush() {
    }

    public ajk() {
        this((byte) 0);
    }

    private ajk(byte b) {
        this(null, 500);
    }

    public ajk(char c) {
        this(null, 100);
    }

    private ajk(BufferRecycler bufferRecycler, int i) {
        this.O00000o0 = new LinkedList<>();
        this.O00000Oo = null;
        this.O00000oO = new byte[i];
    }

    public final void O000000o() {
        this.O00000o = 0;
        this.O00000oo = 0;
        if (!this.O00000o0.isEmpty()) {
            this.O00000o0.clear();
        }
    }

    public final void O000000o(int i) {
        if (this.O00000oo >= this.O00000oO.length) {
            O00000o0();
        }
        byte[] bArr = this.O00000oO;
        int i2 = this.O00000oo;
        this.O00000oo = i2 + 1;
        bArr[i2] = (byte) i;
    }

    public final void O00000Oo(int i) {
        int i2 = this.O00000oo;
        int i3 = i2 + 1;
        byte[] bArr = this.O00000oO;
        if (i3 < bArr.length) {
            this.O00000oo = i2 + 1;
            bArr[i2] = (byte) (i >> 8);
            int i4 = this.O00000oo;
            this.O00000oo = i4 + 1;
            bArr[i4] = (byte) i;
            return;
        }
        O000000o(i >> 8);
        O000000o(i);
    }

    public final void O00000o0(int i) {
        int i2 = this.O00000oo;
        int i3 = i2 + 2;
        byte[] bArr = this.O00000oO;
        if (i3 < bArr.length) {
            this.O00000oo = i2 + 1;
            bArr[i2] = (byte) (i >> 16);
            int i4 = this.O00000oo;
            this.O00000oo = i4 + 1;
            bArr[i4] = (byte) (i >> 8);
            int i5 = this.O00000oo;
            this.O00000oo = i5 + 1;
            bArr[i5] = (byte) i;
            return;
        }
        O000000o(i >> 16);
        O000000o(i >> 8);
        O000000o(i);
    }

    public final byte[] O00000Oo() {
        int i = this.O00000o + this.O00000oo;
        if (i == 0) {
            return f12404O000000o;
        }
        byte[] bArr = new byte[i];
        Iterator<byte[]> it = this.O00000o0.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            byte[] next = it.next();
            int length = next.length;
            System.arraycopy(next, 0, bArr, i2, length);
            i2 += length;
        }
        System.arraycopy(this.O00000oO, 0, bArr, i2, this.O00000oo);
        int i3 = i2 + this.O00000oo;
        if (i3 == i) {
            if (!this.O00000o0.isEmpty()) {
                O000000o();
            }
            return bArr;
        }
        throw new RuntimeException("Internal error: total len assumed to be " + i + ", copied " + i3 + " bytes");
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) {
        while (true) {
            int min = Math.min(this.O00000oO.length - this.O00000oo, i2);
            if (min > 0) {
                System.arraycopy(bArr, i, this.O00000oO, this.O00000oo, min);
                i += min;
                this.O00000oo += min;
                i2 -= min;
            }
            if (i2 > 0) {
                O00000o0();
            } else {
                return;
            }
        }
    }

    public final void write(int i) {
        O000000o(i);
    }

    private void O00000o0() {
        this.O00000o += this.O00000oO.length;
        int max = Math.max(this.O00000o >> 1, 1000);
        if (max > 262144) {
            max = 262144;
        }
        this.O00000o0.add(this.O00000oO);
        this.O00000oO = new byte[max];
        this.O00000oo = 0;
    }
}
