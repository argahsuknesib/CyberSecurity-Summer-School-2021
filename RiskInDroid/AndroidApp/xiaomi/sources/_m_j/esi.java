package _m_j;

public final class esi extends esk {

    /* renamed from: O000000o  reason: collision with root package name */
    erx f15771O000000o;
    private int O00000Oo;

    public esi(int i) {
        this.f15771O000000o = new erx(i);
    }

    public final int O000000o(byte[] bArr, int i, int i2) {
        byte[] O000000o2 = this.f15771O000000o.O000000o();
        if (i2 > this.f15771O000000o.O00000Oo() - this.O00000Oo) {
            i2 = this.f15771O000000o.O00000Oo() - this.O00000Oo;
        }
        if (i2 > 0) {
            System.arraycopy(O000000o2, this.O00000Oo, bArr, i, i2);
            this.O00000Oo += i2;
        }
        return i2;
    }

    public final void O00000Oo(byte[] bArr, int i, int i2) {
        this.f15771O000000o.write(bArr, i, i2);
    }
}
