package _m_j;

public final class fin {

    /* renamed from: O000000o  reason: collision with root package name */
    private final byte[] f16402O000000o;
    private final byte[] O00000Oo;

    public fin(byte[] bArr, byte[] bArr2) {
        this.f16402O000000o = bArr;
        this.O00000Oo = bArr2;
    }

    public final byte[] O000000o() {
        byte[] bArr = this.f16402O000000o;
        byte[] bArr2 = new byte[(bArr.length + this.O00000Oo.length)];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        byte[] bArr3 = this.O00000Oo;
        System.arraycopy(bArr3, 0, bArr2, this.f16402O000000o.length, bArr3.length);
        return bArr2;
    }
}
