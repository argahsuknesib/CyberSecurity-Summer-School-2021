package _m_j;

import java.io.IOException;
import java.math.BigInteger;

public final class fho extends fhr {

    /* renamed from: O000000o  reason: collision with root package name */
    private final byte[] f16386O000000o;

    public fho(BigInteger bigInteger) {
        this.f16386O000000o = bigInteger.toByteArray();
    }

    /* access modifiers changed from: package-private */
    public final int O00000Oo() {
        return fhv.O000000o(this.f16386O000000o.length) + 1 + this.f16386O000000o.length;
    }

    /* access modifiers changed from: package-private */
    public final void O000000o(fhq fhq) throws IOException {
        byte[] bArr = this.f16386O000000o;
        fhq.O00000Oo(2);
        fhq.O000000o(bArr.length);
        fhq.f16387O000000o.write(bArr);
    }

    public final int hashCode() {
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f16386O000000o;
            if (i == bArr.length) {
                return i2;
            }
            i2 ^= (bArr[i] & 255) << (i % 4);
            i++;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean O000000o(fhr fhr) {
        if (!(fhr instanceof fho)) {
            return false;
        }
        byte[] bArr = this.f16386O000000o;
        byte[] bArr2 = ((fho) fhr).f16386O000000o;
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr2 == null || bArr.length != bArr2.length) {
            return false;
        }
        for (int i = 0; i != bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public final String toString() {
        return new BigInteger(this.f16386O000000o).toString();
    }
}
