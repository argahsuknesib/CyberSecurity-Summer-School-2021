package _m_j;

import org.apache.commons.compress.archivers.zip.ZipShort;

public final class jcc implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    ZipShort f1757O000000o;
    private byte[] O00000Oo;
    private byte[] O00000o0;

    public final ZipShort O00000oO() {
        return this.f1757O000000o;
    }

    public final ZipShort O00000o() {
        byte[] bArr = this.O00000Oo;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public final byte[] O00000o0() {
        return jco.O00000Oo(this.O00000Oo);
    }

    public final ZipShort O00000Oo() {
        byte[] bArr = this.O00000o0;
        if (bArr != null) {
            return new ZipShort(bArr.length);
        }
        return O00000o();
    }

    public final byte[] O000000o() {
        byte[] bArr = this.O00000o0;
        if (bArr != null) {
            return jco.O00000Oo(bArr);
        }
        return jco.O00000Oo(this.O00000Oo);
    }

    public final void O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        this.O00000Oo = jco.O00000Oo(bArr2);
    }
}
