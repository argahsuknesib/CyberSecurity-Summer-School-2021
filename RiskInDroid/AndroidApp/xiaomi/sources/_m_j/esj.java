package _m_j;

public final class esj extends esk {

    /* renamed from: O000000o  reason: collision with root package name */
    private byte[] f15772O000000o;
    private int O00000Oo;
    private int O00000o0;

    public final int O000000o(byte[] bArr, int i, int i2) {
        int O00000o02 = O00000o0();
        if (i2 > O00000o02) {
            i2 = O00000o02;
        }
        if (i2 > 0) {
            System.arraycopy(this.f15772O000000o, this.O00000Oo, bArr, i, i2);
            O000000o(i2);
        }
        return i2;
    }

    public final void O000000o(int i) {
        this.O00000Oo += i;
    }

    /* access modifiers changed from: package-private */
    public void O000000o(byte[] bArr, int i) {
        this.f15772O000000o = bArr;
        this.O00000Oo = 0;
        this.O00000o0 = i + 0;
    }

    public final byte[] O000000o() {
        return this.f15772O000000o;
    }

    public final int O00000Oo() {
        return this.O00000Oo;
    }

    public final void O00000Oo(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    public final int O00000o0() {
        return this.O00000o0 - this.O00000Oo;
    }
}
