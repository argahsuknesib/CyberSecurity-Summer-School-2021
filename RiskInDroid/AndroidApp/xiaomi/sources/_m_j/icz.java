package _m_j;

public final class icz extends ida {
    private final ida O00000o0;

    public final byte[] O000000o(int i, byte[] bArr) {
        byte[] O000000o2 = this.O00000o0.O000000o(i, bArr);
        int i2 = this.f1206O000000o;
        for (int i3 = 0; i3 < i2; i3++) {
            O000000o2[i3] = (byte) (255 - (O000000o2[i3] & 255));
        }
        return O000000o2;
    }

    public final byte[] O000000o() {
        byte[] O000000o2 = this.O00000o0.O000000o();
        int i = this.f1206O000000o * this.O00000Oo;
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) (255 - (O000000o2[i2] & 255));
        }
        return bArr;
    }

    public final boolean O00000Oo() {
        return this.O00000o0.O00000Oo();
    }

    public final ida O00000o0() {
        return this.O00000o0;
    }

    public final ida O00000o() {
        return new icz(this.O00000o0.O00000o());
    }

    public icz(ida ida) {
        super(ida.f1206O000000o, ida.O00000Oo);
        this.O00000o0 = ida;
    }
}
