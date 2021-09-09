package _m_j;

public final class elb {
    public static final elb O00000Oo = new elb(new byte[0]);

    /* renamed from: O000000o  reason: collision with root package name */
    public final byte[] f15603O000000o;
    private volatile int O00000o0 = 0;

    private elb(byte[] bArr) {
        this.f15603O000000o = bArr;
    }

    public static elb O000000o(byte[] bArr) {
        return O000000o(bArr, 0, bArr.length);
    }

    public static elb O000000o(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        return new elb(bArr2);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof elb)) {
            return false;
        }
        byte[] bArr = this.f15603O000000o;
        int length = bArr.length;
        byte[] bArr2 = ((elb) obj).f15603O000000o;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = this.O00000o0;
        if (i == 0) {
            int i2 = r1;
            for (byte b : this.f15603O000000o) {
                i2 = (i2 * 31) + b;
            }
            i = i2 == 0 ? 1 : i2;
            this.O00000o0 = i;
        }
        return i;
    }
}
