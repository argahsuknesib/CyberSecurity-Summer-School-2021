package _m_j;

import org.apache.commons.compress.archivers.zip.ZipShort;

public final class jcb implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ZipShort f1756O000000o = new ZipShort(44225);
    private byte[] O00000Oo;
    private byte[] O00000o0;

    public final ZipShort O00000oO() {
        return f1756O000000o;
    }

    public final ZipShort O00000o() {
        byte[] bArr = this.O00000Oo;
        return new ZipShort(bArr == null ? 0 : bArr.length);
    }

    public final ZipShort O00000Oo() {
        byte[] bArr = this.O00000o0;
        return bArr == null ? O00000o() : new ZipShort(bArr.length);
    }

    public final byte[] O00000o0() {
        return jco.O00000Oo(this.O00000Oo);
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O00000o0;
        return bArr == null ? jco.O00000Oo(this.O00000Oo) : jco.O00000Oo(bArr);
    }

    public final void O000000o(byte[] bArr, int i, int i2) {
        this.O00000Oo = new byte[i2];
        System.arraycopy(bArr, i, this.O00000Oo, 0, i2);
    }
}
