package com.xiaomi.push;

import _m_j.esa;
import _m_j.esb;
import _m_j.esc;
import _m_j.esd;
import _m_j.esf;
import _m_j.esg;
import _m_j.esk;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

public class jh extends esd {
    private static final esg O00000oo = new esg();

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f6451O000000o = false;
    protected boolean O00000Oo = true;
    protected boolean O00000o = false;
    protected int O00000o0;
    private byte[] O0000O0o = new byte[1];
    private byte[] O0000OOo = new byte[2];
    private byte[] O0000Oo = new byte[8];
    private byte[] O0000Oo0 = new byte[4];
    private byte[] O0000OoO = new byte[1];
    private byte[] O0000Ooo = new byte[2];
    private byte[] O0000o0 = new byte[8];
    private byte[] O0000o00 = new byte[4];

    public static class a implements jn {

        /* renamed from: a  reason: collision with root package name */
        protected int f6452a;

        /* renamed from: a  reason: collision with other field name */
        protected boolean f180a;
        protected boolean b;

        public a() {
            this((byte) 0);
        }

        public a(byte b2) {
            this(false, true, 0);
        }

        public a(boolean z, boolean z2, int i) {
            this.f180a = false;
            this.b = true;
            this.f180a = z;
            this.b = true;
            this.f6452a = i;
        }

        public esd O000000o(esk esk) {
            jh jhVar = new jh(esk, this.f180a, this.b);
            int i = this.f6452a;
            if (i != 0) {
                jhVar.O00000o0(i);
            }
            return jhVar;
        }
    }

    public jh(esk esk, boolean z, boolean z2) {
        super(esk);
        this.f6451O000000o = z;
        this.O00000Oo = z2;
    }

    private int O000000o(byte[] bArr, int i) {
        O00000o(i);
        return this.O00000oO.O00000o0(bArr, 0, i);
    }

    public final void O000000o() {
        O000000o((byte) 0);
    }

    public final void O000000o(byte b) {
        this.O0000O0o[0] = b;
        this.O00000oO.O00000Oo(this.O0000O0o, 0, 1);
    }

    public final void O000000o(int i) {
        byte[] bArr = this.O0000Oo0;
        bArr[0] = (byte) ((i >> 24) & 255);
        bArr[1] = (byte) ((i >> 16) & 255);
        bArr[2] = (byte) ((i >> 8) & 255);
        bArr[3] = (byte) (i & 255);
        this.O00000oO.O00000Oo(this.O0000Oo0, 0, 4);
    }

    public final void O000000o(long j) {
        byte[] bArr = this.O0000Oo;
        bArr[0] = (byte) ((int) ((j >> 56) & 255));
        bArr[1] = (byte) ((int) ((j >> 48) & 255));
        bArr[2] = (byte) ((int) ((j >> 40) & 255));
        bArr[3] = (byte) ((int) ((j >> 32) & 255));
        bArr[4] = (byte) ((int) ((j >> 24) & 255));
        bArr[5] = (byte) ((int) ((j >> 16) & 255));
        bArr[6] = (byte) ((int) ((j >> 8) & 255));
        bArr[7] = (byte) ((int) (j & 255));
        this.O00000oO.O00000Oo(this.O0000Oo, 0, 8);
    }

    public final void O000000o(esa esa) {
        O000000o(esa.O00000Oo);
        O000000o(esa.O00000o0);
    }

    public final void O000000o(esb esb) {
        O000000o(esb.f15765O000000o);
        O000000o(esb.O00000Oo);
    }

    public final void O000000o(esc esc) {
        O000000o(esc.f15766O000000o);
        O000000o(esc.O00000Oo);
        O000000o(esc.O00000o0);
    }

    public final void O000000o(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            O000000o(bytes.length);
            this.O00000oO.O00000Oo(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new jf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public final void O000000o(ByteBuffer byteBuffer) {
        int limit = (byteBuffer.limit() - byteBuffer.position()) - byteBuffer.arrayOffset();
        O000000o(limit);
        this.O00000oO.O00000Oo(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), limit);
    }

    public final void O000000o(short s) {
        byte[] bArr = this.O0000OOo;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.O00000oO.O00000Oo(this.O0000OOo, 0, 2);
    }

    public final void O000000o(boolean z) {
        O000000o(z ? (byte) 1 : 0);
    }

    public final esa O00000Oo() {
        byte O0000O0o2 = O0000O0o();
        return new esa("", O0000O0o2, O0000O0o2 == 0 ? 0 : O0000OOo());
    }

    public final String O00000Oo(int i) {
        try {
            O00000o(i);
            byte[] bArr = new byte[i];
            this.O00000oO.O00000o0(bArr, 0, i);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new jf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public esb O00000o() {
        return new esb(O0000O0o(), O0000Oo0());
    }

    /* access modifiers changed from: protected */
    public final void O00000o(int i) {
        if (i < 0) {
            throw new jf("Negative length: ".concat(String.valueOf(i)));
        } else if (this.O00000o) {
            this.O00000o0 -= i;
            if (this.O00000o0 < 0) {
                throw new jf("Message length exceeded: ".concat(String.valueOf(i)));
            }
        }
    }

    public esc O00000o0() {
        return new esc(O0000O0o(), O0000O0o(), O0000Oo0());
    }

    public final void O00000o0(int i) {
        this.O00000o0 = i;
        this.O00000o = true;
    }

    public esf O00000oO() {
        return new esf(O0000O0o(), O0000Oo0());
    }

    public final boolean O00000oo() {
        return O0000O0o() == 1;
    }

    public final byte O0000O0o() {
        if (this.O00000oO.O00000o0() > 0) {
            byte b = this.O00000oO.O000000o()[this.O00000oO.O00000Oo()];
            this.O00000oO.O000000o(1);
            return b;
        }
        O000000o(this.O0000OoO, 1);
        return this.O0000OoO[0];
    }

    public final short O0000OOo() {
        int i;
        byte[] bArr = this.O0000Ooo;
        if (this.O00000oO.O00000o0() >= 2) {
            bArr = this.O00000oO.O000000o();
            i = this.O00000oO.O00000Oo();
            this.O00000oO.O000000o(2);
        } else {
            O000000o(this.O0000Ooo, 2);
            i = 0;
        }
        return (short) ((bArr[i + 1] & 255) | ((bArr[i] & 255) << 8));
    }

    public final long O0000Oo() {
        int i;
        byte[] bArr = this.O0000o0;
        if (this.O00000oO.O00000o0() >= 8) {
            bArr = this.O00000oO.O000000o();
            i = this.O00000oO.O00000Oo();
            this.O00000oO.O000000o(8);
        } else {
            O000000o(this.O0000o0, 8);
            i = 0;
        }
        return ((long) (bArr[i + 7] & 255)) | (((long) (bArr[i] & 255)) << 56) | (((long) (bArr[i + 1] & 255)) << 48) | (((long) (bArr[i + 2] & 255)) << 40) | (((long) (bArr[i + 3] & 255)) << 32) | (((long) (bArr[i + 4] & 255)) << 24) | (((long) (bArr[i + 5] & 255)) << 16) | (((long) (bArr[i + 6] & 255)) << 8);
    }

    public final int O0000Oo0() {
        int i;
        byte[] bArr = this.O0000o00;
        if (this.O00000oO.O00000o0() >= 4) {
            bArr = this.O00000oO.O000000o();
            i = this.O00000oO.O00000Oo();
            this.O00000oO.O000000o(4);
        } else {
            O000000o(this.O0000o00, 4);
            i = 0;
        }
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public final double O0000OoO() {
        return Double.longBitsToDouble(O0000Oo());
    }

    public String O0000Ooo() {
        int O0000Oo02 = O0000Oo0();
        if (this.O00000oO.O00000o0() < O0000Oo02) {
            return O00000Oo(O0000Oo02);
        }
        try {
            String str = new String(this.O00000oO.O000000o(), this.O00000oO.O00000Oo(), O0000Oo02, "UTF-8");
            this.O00000oO.O000000o(O0000Oo02);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new jf("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ByteBuffer O0000o00() {
        int O0000Oo02 = O0000Oo0();
        O00000o(O0000Oo02);
        if (this.O00000oO.O00000o0() >= O0000Oo02) {
            ByteBuffer wrap = ByteBuffer.wrap(this.O00000oO.O000000o(), this.O00000oO.O00000Oo(), O0000Oo02);
            this.O00000oO.O000000o(O0000Oo02);
            return wrap;
        }
        byte[] bArr = new byte[O0000Oo02];
        this.O00000oO.O00000o0(bArr, 0, O0000Oo02);
        return ByteBuffer.wrap(bArr);
    }
}
