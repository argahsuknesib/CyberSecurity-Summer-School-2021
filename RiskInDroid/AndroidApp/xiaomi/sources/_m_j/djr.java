package _m_j;

public final class djr implements Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    int f14729O000000o;

    public djr(byte[] bArr) {
        this(bArr, (byte) 0);
    }

    private djr(byte[] bArr, byte b) {
        this.f14729O000000o = (bArr[1] << 8) & 65280;
        this.f14729O000000o += bArr[0] & 255;
    }

    public djr() {
        this.f14729O000000o = 38651;
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof djr) || this.f14729O000000o != ((djr) obj).f14729O000000o) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.f14729O000000o;
    }
}
