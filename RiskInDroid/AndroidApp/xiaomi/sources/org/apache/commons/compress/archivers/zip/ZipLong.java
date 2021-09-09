package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;

public final class ZipLong implements Serializable, Cloneable {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final ZipLong f15427O000000o = new ZipLong(33639248);
    public static final ZipLong O00000Oo = new ZipLong(67324752);
    static final ZipLong O00000o = new ZipLong(4294967295L);
    public static final ZipLong O00000o0 = new ZipLong(134695760);
    public static final ZipLong O00000oO = new ZipLong(808471376);
    public static final ZipLong O00000oo = new ZipLong(134630224);
    private static final long serialVersionUID = 1;
    public final long value;

    private ZipLong(long j) {
        this.value = j;
    }

    public ZipLong(byte[] bArr, int i) {
        this.value = O000000o(bArr, i);
    }

    public static byte[] O000000o(long j) {
        return new byte[]{(byte) ((int) (255 & j)), (byte) ((int) ((65280 & j) >> 8)), (byte) ((int) ((16711680 & j) >> 16)), (byte) ((int) ((j & 4278190080L) >> 24))};
    }

    public static long O000000o(byte[] bArr, int i) {
        return (((long) (bArr[i + 3] << 24)) & 4278190080L) + ((long) ((bArr[i + 2] << 16) & 16711680)) + ((long) ((bArr[i + 1] << 8) & 65280)) + ((long) (bArr[i] & 255));
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipLong) || this.value != ((ZipLong) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return (int) this.value;
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final String toString() {
        return "ZipLong value: " + this.value;
    }
}
