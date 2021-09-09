package _m_j;

public final class bnt {

    /* renamed from: O000000o  reason: collision with root package name */
    public byte[] f13148O000000o;
    public int O00000Oo;
    public int O00000o0;

    public bnt() {
        this.f13148O000000o = null;
        this.O00000Oo = 0;
        this.O00000o0 = 0;
    }

    public bnt(byte[] bArr, int i, int i2) {
        this.f13148O000000o = bArr;
        this.O00000Oo = i;
        this.O00000o0 = this.O00000Oo + i2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("start pos:" + this.O00000Oo + "  endPos:" + this.O00000o0 + "  [");
        for (int i = this.O00000Oo; i < this.O00000o0; i++) {
            sb.append(((int) this.f13148O000000o[i]) + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    public final /* synthetic */ Object clone() throws CloneNotSupportedException {
        if (this.f13148O000000o == null) {
            return null;
        }
        int i = this.O00000o0 - this.O00000Oo;
        bnt bnt = new bnt();
        bnt.f13148O000000o = new byte[i];
        bnt.O00000Oo = 0;
        bnt.O00000o0 = i;
        for (int i2 = 0; i2 < i; i2++) {
            bnt.f13148O000000o[i2] = this.f13148O000000o[i2];
        }
        return bnt;
    }
}
