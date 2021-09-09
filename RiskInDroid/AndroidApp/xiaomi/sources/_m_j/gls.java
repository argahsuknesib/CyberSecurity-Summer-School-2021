package _m_j;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.List;

public abstract class gls {
    public abstract String O000000o();

    public abstract byte[] O00000Oo();

    static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f17994O000000o;
        int O00000Oo;
        byte[] O00000o;
        int O00000o0;
        List<Short> O00000oO;

        private O00000Oo() {
            this.O00000oO = new ArrayList();
        }

        /* synthetic */ O00000Oo(byte b) {
            this();
        }
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        byte[] f17993O000000o;
        int O00000Oo;
        int O00000o0;

        O000000o(byte[] bArr) {
            this(bArr, 2, bArr.length);
        }

        O000000o(byte[] bArr, int i, int i2) {
            this.f17993O000000o = bArr;
            this.O00000Oo = i;
            this.O00000o0 = i2;
        }

        public final int O000000o() {
            return this.O00000o0 - this.O00000Oo;
        }
    }

    private static O00000Oo O00000Oo(byte[] bArr) throws BufferUnderflowException {
        O00000Oo o00000Oo = new O00000Oo((byte) 0);
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN);
        o00000Oo.f17994O000000o = order.getShort();
        o00000Oo.O00000o = bArr;
        if (o00000Oo.f17994O000000o == 0) {
            o00000Oo.O00000Oo = order.get();
            o00000Oo.O00000o0 = order.get();
            while (order.hasRemaining()) {
                try {
                    o00000Oo.O00000oO.add(Short.valueOf(order.getShort()));
                } catch (BufferUnderflowException unused) {
                }
            }
        }
        return o00000Oo;
    }

    public static gls O000000o(byte[] bArr) {
        O00000Oo o00000Oo;
        try {
            o00000Oo = O00000Oo(bArr);
        } catch (BufferUnderflowException e) {
            e.printStackTrace();
            o00000Oo = null;
        }
        if (o00000Oo == null) {
            return new glp();
        }
        if (o00000Oo.f17994O000000o != 0) {
            return new glo(o00000Oo.f17994O000000o, new O000000o(o00000Oo.O00000o));
        }
        List<Short> list = o00000Oo.O00000oO;
        int i = o00000Oo.O00000Oo;
        if (i == 0) {
            return new gln(list.get(0).shortValue(), o00000Oo.O00000o0);
        }
        if (i == 1) {
            return new glm(o00000Oo.O00000o0, list);
        }
        if (i == 2) {
            return new glu(o00000Oo.O00000o0, got.O0000Oo0(o00000Oo.O00000o));
        }
        if (i == 3) {
            return new glt(o00000Oo.O00000o0);
        }
        if (i == 4) {
            return new glr(o00000Oo.O00000o0, got.O0000Oo0(o00000Oo.O00000o));
        }
        if (i != 5) {
            return new glp();
        }
        return new glq(o00000Oo.O00000o0, got.O0000Oo0(o00000Oo.O00000o));
    }
}
