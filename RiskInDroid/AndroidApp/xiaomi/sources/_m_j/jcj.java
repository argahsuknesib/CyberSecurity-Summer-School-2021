package _m_j;

import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipEightByteInteger;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jcj implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    static final ZipShort f1760O000000o = new ZipShort(1);
    private static final byte[] O00000Oo = new byte[0];
    private ZipEightByteInteger O00000o;
    private ZipEightByteInteger O00000o0;
    private ZipEightByteInteger O00000oO;
    private ZipLong O00000oo;

    public final ZipShort O00000oO() {
        return f1760O000000o;
    }

    public final ZipShort O00000o() {
        return new ZipShort(this.O00000o0 != null ? 16 : 0);
    }

    public final ZipShort O00000Oo() {
        int i = 8;
        int i2 = 0;
        int i3 = (this.O00000o0 != null ? 8 : 0) + (this.O00000o != null ? 8 : 0);
        if (this.O00000oO == null) {
            i = 0;
        }
        int i4 = i3 + i;
        if (this.O00000oo != null) {
            i2 = 4;
        }
        return new ZipShort(i4 + i2);
    }

    public final byte[] O00000o0() {
        if (this.O00000o0 == null && this.O00000o == null) {
            return O00000Oo;
        }
        if (this.O00000o0 == null || this.O00000o == null) {
            throw new IllegalArgumentException("Zip64 extended information must contain both size values in the local file header.");
        }
        byte[] bArr = new byte[16];
        O000000o(bArr);
        return bArr;
    }

    public final byte[] O000000o() {
        byte[] bArr = new byte[O00000Oo().value];
        int O000000o2 = O000000o(bArr);
        ZipEightByteInteger zipEightByteInteger = this.O00000oO;
        if (zipEightByteInteger != null) {
            System.arraycopy(ZipEightByteInteger.O000000o(zipEightByteInteger.value), 0, bArr, O000000o2, 8);
            O000000o2 += 8;
        }
        ZipLong zipLong = this.O00000oo;
        if (zipLong != null) {
            System.arraycopy(ZipLong.O000000o(zipLong.value), 0, bArr, O000000o2, 4);
        }
        return bArr;
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 != 0) {
            if (i2 >= 16) {
                this.O00000o0 = new ZipEightByteInteger(bArr, i);
                int i3 = i + 8;
                this.O00000o = new ZipEightByteInteger(bArr, i3);
                int i4 = i3 + 8;
                int i5 = i2 - 16;
                if (i5 >= 8) {
                    this.O00000oO = new ZipEightByteInteger(bArr, i4);
                    i4 += 8;
                    i5 -= 8;
                }
                if (i5 >= 4) {
                    this.O00000oo = new ZipLong(bArr, i4);
                    return;
                }
                return;
            }
            throw new ZipException("Zip64 extended information must contain both size values in the local file header.");
        }
    }

    private int O000000o(byte[] bArr) {
        int i;
        ZipEightByteInteger zipEightByteInteger = this.O00000o0;
        if (zipEightByteInteger != null) {
            System.arraycopy(ZipEightByteInteger.O000000o(zipEightByteInteger.value), 0, bArr, 0, 8);
            i = 8;
        } else {
            i = 0;
        }
        ZipEightByteInteger zipEightByteInteger2 = this.O00000o;
        if (zipEightByteInteger2 == null) {
            return i;
        }
        System.arraycopy(ZipEightByteInteger.O000000o(zipEightByteInteger2.value), 0, bArr, i, 8);
        return i + 8;
    }
}
