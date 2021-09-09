package _m_j;

public abstract class ida {

    /* renamed from: O000000o  reason: collision with root package name */
    public final int f1206O000000o;
    public final int O00000Oo;

    public abstract byte[] O000000o();

    public abstract byte[] O000000o(int i, byte[] bArr);

    public boolean O00000Oo() {
        return false;
    }

    protected ida(int i, int i2) {
        this.f1206O000000o = i;
        this.O00000Oo = i2;
    }

    public ida O00000o0() {
        return new icz(this);
    }

    public ida O00000o() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        int i = this.f1206O000000o;
        StringBuilder sb = new StringBuilder(this.O00000Oo * (i + 1));
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < this.O00000Oo; i2++) {
            bArr = O000000o(i2, bArr);
            for (int i3 = 0; i3 < this.f1206O000000o; i3++) {
                byte b = bArr[i3] & 255;
                sb.append(b < 64 ? '#' : b < 128 ? '+' : b < 192 ? '.' : ' ');
            }
            sb.append(10);
        }
        return sb.toString();
    }
}
