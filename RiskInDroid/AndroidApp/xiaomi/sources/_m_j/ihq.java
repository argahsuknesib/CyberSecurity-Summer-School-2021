package _m_j;

public final class ihq {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte[] f1303O000000o = null;
    private int O00000Oo = -1;
    private int O00000o0 = 0;

    public ihq(byte[] bArr, int i, int i2, int i3) {
        int i4;
        this.O00000Oo = i2 - i;
        this.O00000o0 = i3;
        if (bArr != null && (i4 = this.O00000Oo) > 0 && bArr.length > 0 && i2 <= bArr.length && i >= 0) {
            this.f1303O000000o = new byte[i4];
            System.arraycopy(bArr, i, this.f1303O000000o, 0, i4);
        }
    }
}
