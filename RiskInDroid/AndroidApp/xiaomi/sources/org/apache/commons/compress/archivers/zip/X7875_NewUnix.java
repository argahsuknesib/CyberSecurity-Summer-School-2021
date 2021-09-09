package org.apache.commons.compress.archivers.zip;

import _m_j.jcn;
import _m_j.jco;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.zip.ZipException;

public class X7875_NewUnix implements jcn, Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final ZipShort f15425O000000o = new ZipShort(30837);
    private static final ZipShort O00000Oo = new ZipShort(0);
    private static final BigInteger O00000o0 = BigInteger.valueOf(1000);
    private static final long serialVersionUID = 1;
    private BigInteger gid;
    private BigInteger uid;
    private int version = 1;

    public X7875_NewUnix() {
        O00000oo();
    }

    public final ZipShort O00000oO() {
        return f15425O000000o;
    }

    public final ZipShort O00000o() {
        return new ZipShort(O000000o(this.uid.toByteArray()).length + 3 + O000000o(this.gid.toByteArray()).length);
    }

    public final ZipShort O00000Oo() {
        return O00000Oo;
    }

    public final byte[] O00000o0() {
        byte[] byteArray = this.uid.toByteArray();
        byte[] byteArray2 = this.gid.toByteArray();
        byte[] O000000o2 = O000000o(byteArray);
        byte[] O000000o3 = O000000o(byteArray2);
        byte[] bArr = new byte[(O000000o2.length + 3 + O000000o3.length)];
        jco.O000000o(O000000o2);
        jco.O000000o(O000000o3);
        bArr[0] = jco.O000000o(this.version);
        bArr[1] = jco.O000000o(O000000o2.length);
        System.arraycopy(O000000o2, 0, bArr, 2, O000000o2.length);
        int length = O000000o2.length + 2;
        bArr[length] = jco.O000000o(O000000o3.length);
        System.arraycopy(O000000o3, 0, bArr, length + 1, O000000o3.length);
        return bArr;
    }

    public final byte[] O000000o() {
        return new byte[0];
    }

    public final void O000000o(byte[] bArr, int i, int i2) throws ZipException {
        O00000oo();
        int i3 = i + 1;
        this.version = jco.O000000o(bArr[i]);
        int i4 = i3 + 1;
        int O000000o2 = jco.O000000o(bArr[i3]);
        byte[] bArr2 = new byte[O000000o2];
        System.arraycopy(bArr, i4, bArr2, 0, O000000o2);
        int i5 = i4 + O000000o2;
        this.uid = new BigInteger(1, jco.O000000o(bArr2));
        int i6 = i5 + 1;
        int O000000o3 = jco.O000000o(bArr[i5]);
        byte[] bArr3 = new byte[O000000o3];
        System.arraycopy(bArr, i6, bArr3, 0, O000000o3);
        this.gid = new BigInteger(1, jco.O000000o(bArr3));
    }

    private void O00000oo() {
        BigInteger bigInteger = O00000o0;
        this.uid = bigInteger;
        this.gid = bigInteger;
    }

    public String toString() {
        return "0x7875 Zip Extra Field: UID=" + this.uid + " GID=" + this.gid;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public boolean equals(Object obj) {
        if (obj instanceof X7875_NewUnix) {
            X7875_NewUnix x7875_NewUnix = (X7875_NewUnix) obj;
            if (this.version != x7875_NewUnix.version || !this.uid.equals(x7875_NewUnix.uid) || !this.gid.equals(x7875_NewUnix.gid)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        return ((this.version * -1234567) ^ Integer.rotateLeft(this.uid.hashCode(), 16)) ^ this.gid.hashCode();
    }

    private static byte[] O000000o(byte[] bArr) {
        if (bArr == null) {
            return bArr;
        }
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length && bArr[i] == 0) {
            i2++;
            i++;
        }
        byte[] bArr2 = new byte[Math.max(1, bArr.length - i2)];
        int length2 = bArr2.length - (bArr.length - i2);
        System.arraycopy(bArr, i2, bArr2, length2, bArr2.length - length2);
        return bArr2;
    }
}
