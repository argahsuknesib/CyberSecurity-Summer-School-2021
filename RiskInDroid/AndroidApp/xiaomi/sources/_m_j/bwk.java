package _m_j;

import android.support.v4.app.NotificationCompat;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.util.Arrays;

public class bwk {
    static final Charset O00000o0 = Charset.forName("UTF-8");
    static final /* synthetic */ boolean O0000o0o = (!bwk.class.desiredAssertionStatus());

    /* renamed from: O000000o  reason: collision with root package name */
    public ByteBuffer f13337O000000o;
    public int O00000Oo;
    int O00000o;
    int[] O00000oO;
    int O00000oo;
    boolean O0000O0o;
    boolean O0000OOo;
    int[] O0000Oo;
    int O0000Oo0;
    int O0000OoO;
    int O0000Ooo;
    CharsetEncoder O0000o0;
    public boolean O0000o00;
    ByteBuffer O0000o0O;

    public bwk() {
        this(1024);
    }

    public bwk(int i) {
        this.O00000o = 1;
        this.O00000oO = null;
        this.O00000oo = 0;
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000Oo = new int[16];
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = false;
        this.O0000o0 = O00000o0.newEncoder();
        this.O00000Oo = 1024;
        this.f13337O000000o = O00000oO(1024);
    }

    public bwk(ByteBuffer byteBuffer) {
        this.O00000o = 1;
        this.O00000oO = null;
        this.O00000oo = 0;
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000Oo = new int[16];
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        this.O0000o00 = false;
        this.O0000o0 = O00000o0.newEncoder();
        O000000o(byteBuffer);
    }

    private static ByteBuffer O00000Oo(ByteBuffer byteBuffer) {
        int capacity = byteBuffer.capacity();
        if ((-1073741824 & capacity) == 0) {
            int i = capacity << 1;
            byteBuffer.position(0);
            ByteBuffer O00000oO2 = O00000oO(i);
            O00000oO2.position(i - capacity);
            O00000oO2.put(byteBuffer);
            return O00000oO2;
        }
        throw new AssertionError("FlatBuffers: cannot grow buffer beyond 2 gigabytes.");
    }

    private void O00000Oo(byte b) {
        ByteBuffer byteBuffer = this.f13337O000000o;
        int i = this.O00000Oo - 1;
        this.O00000Oo = i;
        byteBuffer.put(i, b);
    }

    private void O00000Oo(long j) {
        ByteBuffer byteBuffer = this.f13337O000000o;
        int i = this.O00000Oo - 8;
        this.O00000Oo = i;
        byteBuffer.putLong(i, j);
    }

    private int O00000o() {
        return this.f13337O000000o.capacity() - this.O00000Oo;
    }

    private static ByteBuffer O00000oO(int i) {
        ByteBuffer allocate = ByteBuffer.allocate(i);
        allocate.order(ByteOrder.LITTLE_ENDIAN);
        return allocate;
    }

    private void O00000oO() {
        if (this.O0000O0o) {
            throw new AssertionError("FlatBuffers: object serialization must not be nested.");
        }
    }

    private void O00000oo(int i) {
        for (int i2 = 0; i2 < i; i2++) {
            ByteBuffer byteBuffer = this.f13337O000000o;
            int i3 = this.O00000Oo - 1;
            this.O00000Oo = i3;
            byteBuffer.put(i3, (byte) 0);
        }
    }

    private void O0000O0o(int i) {
        ByteBuffer byteBuffer = this.f13337O000000o;
        int i2 = this.O00000Oo - 4;
        this.O00000Oo = i2;
        byteBuffer.putInt(i2, i);
    }

    private void O0000OOo(int i) {
        O000000o(4, 0);
        O0000O0o(i);
    }

    public final int O000000o() {
        if (this.O0000O0o) {
            this.O0000O0o = false;
            O0000O0o(this.O0000Ooo);
            return O00000o();
        }
        throw new AssertionError("FlatBuffers: endVector called without startVector");
    }

    public final bwk O000000o(ByteBuffer byteBuffer) {
        this.f13337O000000o = byteBuffer;
        this.f13337O000000o.clear();
        this.f13337O000000o.order(ByteOrder.LITTLE_ENDIAN);
        this.O00000o = 1;
        this.O00000Oo = this.f13337O000000o.capacity();
        this.O00000oo = 0;
        this.O0000O0o = false;
        this.O0000OOo = false;
        this.O0000Oo0 = 0;
        this.O0000OoO = 0;
        this.O0000Ooo = 0;
        return this;
    }

    public final void O000000o(byte b) {
        O000000o(1, 0);
        O00000Oo(b);
    }

    public final void O000000o(int i) {
        O000000o(4, 0);
        if (O0000o0o || i <= O00000o()) {
            O0000O0o((O00000o() - i) + 4);
            return;
        }
        throw new AssertionError();
    }

    public final void O000000o(int i, byte b) {
        if (this.O0000o00 || b != 0) {
            O000000o(b);
            O00000o0(i);
        }
    }

    public final void O000000o(int i, int i2) {
        if (i > this.O00000o) {
            this.O00000o = i;
        }
        int capacity = ((((this.f13337O000000o.capacity() - this.O00000Oo) + i2) ^ -1) + 1) & (i - 1);
        while (this.O00000Oo < capacity + i + i2) {
            int capacity2 = this.f13337O000000o.capacity();
            this.f13337O000000o = O00000Oo(this.f13337O000000o);
            this.O00000Oo += this.f13337O000000o.capacity() - capacity2;
        }
        O00000oo(capacity);
    }

    public final void O000000o(int i, int i2, int i3) {
        O00000oO();
        this.O0000Ooo = i2;
        int i4 = i * i2;
        O000000o(4, i4);
        O000000o(i3, i4);
        this.O0000O0o = true;
    }

    public final void O000000o(int i, long j) {
        if (this.O0000o00 || j != 0) {
            O000000o(j);
            O00000o0(i);
        }
    }

    public final void O000000o(int i, short s) {
        if (this.O0000o00 || s != 0) {
            O000000o(s);
            O00000o0(i);
        }
    }

    public final void O000000o(long j) {
        O000000o(8, 0);
        O00000Oo(j);
    }

    public final int O00000Oo() {
        int i;
        if (this.O00000oO == null || !this.O0000O0o) {
            throw new AssertionError("FlatBuffers: endObject called without startObject");
        }
        O0000OOo(0);
        int O00000o2 = O00000o();
        for (int i2 = this.O00000oo - 1; i2 >= 0; i2--) {
            int[] iArr = this.O00000oO;
            O000000o((short) (iArr[i2] != 0 ? O00000o2 - iArr[i2] : 0));
        }
        O000000o((short) (O00000o2 - this.O0000Oo0));
        O000000o((short) ((this.O00000oo + 2) * 2));
        int i3 = 0;
        loop1:
        while (true) {
            if (i3 >= this.O0000OoO) {
                i = 0;
                break;
            }
            int capacity = this.f13337O000000o.capacity() - this.O0000Oo[i3];
            int i4 = this.O00000Oo;
            short s = this.f13337O000000o.getShort(capacity);
            if (s == this.f13337O000000o.getShort(i4)) {
                int i5 = 2;
                while (i5 < s) {
                    if (this.f13337O000000o.getShort(capacity + i5) == this.f13337O000000o.getShort(i4 + i5)) {
                        i5 += 2;
                    }
                }
                i = this.O0000Oo[i3];
                break loop1;
            }
            i3++;
        }
        if (i != 0) {
            this.O00000Oo = this.f13337O000000o.capacity() - O00000o2;
            this.f13337O000000o.putInt(this.O00000Oo, i - O00000o2);
        } else {
            int i6 = this.O0000OoO;
            int[] iArr2 = this.O0000Oo;
            if (i6 == iArr2.length) {
                this.O0000Oo = Arrays.copyOf(iArr2, i6 * 2);
            }
            int[] iArr3 = this.O0000Oo;
            int i7 = this.O0000OoO;
            this.O0000OoO = i7 + 1;
            iArr3[i7] = O00000o();
            ByteBuffer byteBuffer = this.f13337O000000o;
            byteBuffer.putInt(byteBuffer.capacity() - O00000o2, O00000o() - O00000o2);
        }
        this.O0000O0o = false;
        return O00000o2;
    }

    public final void O00000Oo(int i) {
        O00000oO();
        int[] iArr = this.O00000oO;
        if (iArr == null || iArr.length < i) {
            this.O00000oO = new int[i];
        }
        this.O00000oo = i;
        Arrays.fill(this.O00000oO, 0, this.O00000oo, 0);
        this.O0000O0o = true;
        this.O0000Oo0 = O00000o();
    }

    public final void O00000Oo(int i, int i2) {
        if (this.O0000o00 || i2 != 0) {
            O0000OOo(i2);
            O00000o0(i);
        }
    }

    public final void O00000o(int i) {
        O000000o(this.O00000o, 4);
        O000000o(i);
        this.f13337O000000o.position(this.O00000Oo);
        this.O0000OOo = true;
    }

    public final void O00000o0(int i) {
        this.O00000oO[i] = O00000o();
    }

    public final void O00000o0(int i, int i2) {
        if (this.O0000o00 || i2 != 0) {
            O000000o(i2);
            O00000o0(i);
        }
    }

    public final byte[] O00000o0() {
        return O00000o(this.O00000Oo, this.f13337O000000o.capacity() - this.O00000Oo);
    }

    private void O000000o(short s) {
        O000000o(2, 0);
        ByteBuffer byteBuffer = this.f13337O000000o;
        int i = this.O00000Oo - 2;
        this.O00000Oo = i;
        byteBuffer.putShort(i, s);
    }

    public int O000000o(CharSequence charSequence) {
        int length = (int) (((float) charSequence.length()) * this.O0000o0.maxBytesPerChar());
        ByteBuffer byteBuffer = this.O0000o0O;
        if (byteBuffer == null || byteBuffer.capacity() < length) {
            this.O0000o0O = ByteBuffer.allocate(Math.max((int) NotificationCompat.FLAG_HIGH_PRIORITY, length));
        }
        this.O0000o0O.clear();
        CoderResult encode = this.O0000o0.encode(charSequence instanceof CharBuffer ? (CharBuffer) charSequence : CharBuffer.wrap(charSequence), this.O0000o0O, true);
        if (encode.isError()) {
            try {
                encode.throwException();
            } catch (CharacterCodingException e) {
                throw new Error(e);
            }
        }
        this.O0000o0O.flip();
        ByteBuffer byteBuffer2 = this.O0000o0O;
        int remaining = byteBuffer2.remaining();
        O000000o((byte) 0);
        O000000o(1, remaining, 1);
        ByteBuffer byteBuffer3 = this.f13337O000000o;
        int i = this.O00000Oo - remaining;
        this.O00000Oo = i;
        byteBuffer3.position(i);
        this.f13337O000000o.put(byteBuffer2);
        return O000000o();
    }

    private byte[] O00000o(int i, int i2) {
        if (this.O0000OOo) {
            byte[] bArr = new byte[i2];
            this.f13337O000000o.position(i);
            this.f13337O000000o.get(bArr);
            return bArr;
        }
        throw new AssertionError("FlatBuffers: you can only access the serialized buffer after it has been finished by FlatBufferBuilder.finish().");
    }
}
