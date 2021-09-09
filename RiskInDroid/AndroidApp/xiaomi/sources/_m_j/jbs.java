package _m_j;

import java.util.zip.CRC32;
import java.util.zip.ZipException;
import org.apache.commons.compress.archivers.zip.ZipLong;
import org.apache.commons.compress.archivers.zip.ZipShort;

public class jbs implements jcn, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ZipShort f1745O000000o = new ZipShort(30062);
    private int O00000Oo = 0;
    private int O00000o = 0;
    private int O00000o0 = 0;
    private String O00000oO = "";
    private boolean O00000oo = false;
    private CRC32 O0000O0o = new CRC32();

    public final ZipShort O00000oO() {
        return f1745O000000o;
    }

    public final ZipShort O00000o() {
        return new ZipShort(this.O00000oO.getBytes().length + 14);
    }

    public final ZipShort O00000Oo() {
        return O00000o();
    }

    public final byte[] O00000o0() {
        byte[] bArr = new byte[(O00000o().value - 4)];
        System.arraycopy(ZipShort.O000000o(this.O00000Oo), 0, bArr, 0, 2);
        byte[] bytes = this.O00000oO.getBytes();
        System.arraycopy(ZipLong.O000000o((long) bytes.length), 0, bArr, 2, 4);
        System.arraycopy(ZipShort.O000000o(this.O00000o0), 0, bArr, 6, 2);
        System.arraycopy(ZipShort.O000000o(this.O00000o), 0, bArr, 8, 2);
        System.arraycopy(bytes, 0, bArr, 10, bytes.length);
        this.O0000O0o.reset();
        this.O0000O0o.update(bArr);
        long value = this.O0000O0o.getValue();
        byte[] bArr2 = new byte[(bArr.length + 4)];
        System.arraycopy(ZipLong.O000000o(value), 0, bArr2, 0, 4);
        System.arraycopy(bArr, 0, bArr2, 4, bArr.length);
        return bArr2;
    }

    public final byte[] O000000o() {
        return O00000o0();
    }

    private boolean O0000O0o() {
        return this.O00000oo && !O00000oo();
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        long O000000o2 = ZipLong.O000000o(bArr, i);
        int i3 = i2 - 4;
        byte[] bArr2 = new byte[i3];
        boolean z = false;
        System.arraycopy(bArr, i + 4, bArr2, 0, i3);
        this.O0000O0o.reset();
        this.O0000O0o.update(bArr2);
        long value = this.O0000O0o.getValue();
        if (O000000o2 == value) {
            int O000000o3 = ZipShort.O000000o(bArr2, 0);
            byte[] bArr3 = new byte[((int) ZipLong.O000000o(bArr2, 2))];
            this.O00000o0 = ZipShort.O000000o(bArr2, 6);
            this.O00000o = ZipShort.O000000o(bArr2, 8);
            if (bArr3.length == 0) {
                this.O00000oO = "";
            } else {
                System.arraycopy(bArr2, 10, bArr3, 0, bArr3.length);
                this.O00000oO = new String(bArr3);
            }
            if ((O000000o3 & 16384) != 0) {
                z = true;
            }
            this.O00000oo = z;
            this.O00000Oo = O000000o(this.O00000Oo);
            this.O00000Oo = O000000o(O000000o3);
            return;
        }
        throw new ZipException("bad CRC checksum " + Long.toHexString(O000000o2) + " instead of " + Long.toHexString(value));
    }

    private int O000000o(int i) {
        int i2;
        if (O00000oo()) {
            i2 = 40960;
        } else {
            i2 = O0000O0o() ? 16384 : 32768;
        }
        return (i & 4095) | i2;
    }

    public Object clone() {
        try {
            jbs jbs = (jbs) super.clone();
            jbs.O0000O0o = new CRC32();
            return jbs;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    private boolean O00000oo() {
        return this.O00000oO.length() != 0;
    }
}
