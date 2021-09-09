package _m_j;

import java.util.Date;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jcd implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ZipShort f1758O000000o = new ZipShort(10);
    private static final ZipShort O00000Oo = new ZipShort(1);
    private static final ZipShort O00000o0 = new ZipShort(24);
    private ZipEightByteInteger O00000o = ZipEightByteInteger.f15426O000000o;
    private ZipEightByteInteger O00000oO = ZipEightByteInteger.f15426O000000o;
    private ZipEightByteInteger O00000oo = ZipEightByteInteger.f15426O000000o;

    public final ZipShort O00000oO() {
        return f1758O000000o;
    }

    public final ZipShort O00000o() {
        return new ZipShort(32);
    }

    public final ZipShort O00000Oo() {
        return O00000o();
    }

    public final byte[] O00000o0() {
        byte[] bArr = new byte[O00000o().value];
        System.arraycopy(O00000Oo.O000000o(), 0, bArr, 4, 2);
        System.arraycopy(O00000o0.O000000o(), 0, bArr, 6, 2);
        System.arraycopy(ZipEightByteInteger.O000000o(this.O00000o.value), 0, bArr, 8, 8);
        System.arraycopy(ZipEightByteInteger.O000000o(this.O00000oO.value), 0, bArr, 16, 8);
        System.arraycopy(ZipEightByteInteger.O000000o(this.O00000oo.value), 0, bArr, 24, 8);
        return bArr;
    }

    public final byte[] O000000o() {
        return O00000o0();
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        int i3 = i2 + i;
        int i4 = i + 4;
        while (i4 + 4 <= i3) {
            ZipShort zipShort = new ZipShort(bArr, i4);
            int i5 = i4 + 2;
            if (!zipShort.equals(O00000Oo)) {
                i4 = i5 + new ZipShort(bArr, i5).value + 2;
            } else if (i3 - i5 >= 26) {
                if (O00000o0.equals(new ZipShort(bArr, i5))) {
                    int i6 = i5 + 2;
                    this.O00000o = new ZipEightByteInteger(bArr, i6);
                    int i7 = i6 + 8;
                    this.O00000oO = new ZipEightByteInteger(bArr, i7);
                    this.O00000oo = new ZipEightByteInteger(bArr, i7 + 8);
                    return;
                }
                return;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "0x000A Zip Extra Field: Modify:[" + O000000o(this.O00000o) + "]  Access:[" + O000000o(this.O00000oO) + "]  Create:[" + O000000o(this.O00000oo) + "] ";
    }

    public boolean equals(Object obj) {
        ZipEightByteInteger zipEightByteInteger;
        ZipEightByteInteger zipEightByteInteger2;
        if (!(obj instanceof jcd)) {
            return false;
        }
        jcd jcd = (jcd) obj;
        ZipEightByteInteger zipEightByteInteger3 = this.O00000o;
        ZipEightByteInteger zipEightByteInteger4 = jcd.O00000o;
        if ((zipEightByteInteger3 == zipEightByteInteger4 || (zipEightByteInteger3 != null && zipEightByteInteger3.equals(zipEightByteInteger4))) && ((zipEightByteInteger = this.O00000oO) == (zipEightByteInteger2 = jcd.O00000oO) || (zipEightByteInteger != null && zipEightByteInteger.equals(zipEightByteInteger2)))) {
            ZipEightByteInteger zipEightByteInteger5 = this.O00000oo;
            ZipEightByteInteger zipEightByteInteger6 = jcd.O00000oo;
            if (zipEightByteInteger5 == zipEightByteInteger6) {
                return true;
            }
            if (zipEightByteInteger5 == null || !zipEightByteInteger5.equals(zipEightByteInteger6)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        ZipEightByteInteger zipEightByteInteger = this.O00000o;
        int i = -123;
        if (zipEightByteInteger != null) {
            i = -123 ^ zipEightByteInteger.hashCode();
        }
        ZipEightByteInteger zipEightByteInteger2 = this.O00000oO;
        if (zipEightByteInteger2 != null) {
            i ^= Integer.rotateLeft(zipEightByteInteger2.hashCode(), 11);
        }
        ZipEightByteInteger zipEightByteInteger3 = this.O00000oo;
        return zipEightByteInteger3 != null ? i ^ Integer.rotateLeft(zipEightByteInteger3.hashCode(), 22) : i;
    }

    private static Date O000000o(ZipEightByteInteger zipEightByteInteger) {
        if (zipEightByteInteger == null || ZipEightByteInteger.f15426O000000o.equals(zipEightByteInteger)) {
            return null;
        }
        return new Date((zipEightByteInteger.value.longValue() - 116444736000000000L) / 10000);
    }
}
