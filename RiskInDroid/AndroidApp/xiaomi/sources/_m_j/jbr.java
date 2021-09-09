package _m_j;

import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;

public abstract class jbr implements jcn {

    /* renamed from: O000000o  reason: collision with root package name */
    private long f1744O000000o;
    private byte[] O00000Oo;
    private byte[] O00000o0;

    protected jbr() {
    }

    private void O00000oo() {
        byte[] bArr = this.O00000Oo;
        if (bArr != null) {
            this.O00000o0 = new byte[(bArr.length + 5)];
            this.O00000o0[0] = 1;
            System.arraycopy(ZipLong.O000000o(this.f1744O000000o), 0, this.O00000o0, 1, 4);
            byte[] bArr2 = this.O00000Oo;
            System.arraycopy(bArr2, 0, this.O00000o0, 5, bArr2.length);
        }
    }

    public final byte[] O000000o() {
        if (this.O00000o0 == null) {
            O00000oo();
        }
        byte[] bArr = this.O00000o0;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        return bArr2;
    }

    public final ZipShort O00000Oo() {
        if (this.O00000o0 == null) {
            O00000oo();
        }
        byte[] bArr = this.O00000o0;
        return new ZipShort(bArr != null ? bArr.length : 0);
    }

    public final byte[] O00000o0() {
        return O000000o();
    }

    public final ZipShort O00000o() {
        return O00000Oo();
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        if (i2 >= 5) {
            byte b = bArr[i];
            if (b == 1) {
                this.f1744O000000o = ZipLong.O000000o(bArr, i + 1);
                int i3 = i2 - 5;
                this.O00000Oo = new byte[i3];
                System.arraycopy(bArr, i + 5, this.O00000Oo, 0, i3);
                this.O00000o0 = null;
                return;
            }
            throw new ZipException("Unsupported version [" + ((int) b) + "] for UniCode path extra data.");
        }
        throw new ZipException("UniCode path extra data must have at least 5 bytes.");
    }
}
