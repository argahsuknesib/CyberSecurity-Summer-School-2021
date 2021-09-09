package _m_j;

public final class fii implements fhx {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte[] f16399O000000o;
    public fhx O00000Oo;

    public fii(fhx fhx, byte[] bArr) {
        this(fhx, bArr, bArr.length);
    }

    private fii(fhx fhx, byte[] bArr, int i) {
        this.f16399O000000o = new byte[i];
        this.O00000Oo = fhx;
        System.arraycopy(bArr, 0, this.f16399O000000o, 0, i);
    }
}
