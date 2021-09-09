package org.apache.commons.compress.archivers.zip;

import java.io.Serializable;

public final class ZipShort implements Serializable, Cloneable {
    private static final long serialVersionUID = 1;
    public final int value;

    public ZipShort(int i) {
        this.value = i;
    }

    public ZipShort(byte[] bArr, int i) {
        this.value = O000000o(bArr, i);
    }

    public final byte[] O000000o() {
        int i = this.value;
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static byte[] O000000o(int i) {
        return new byte[]{(byte) (i & 255), (byte) ((i & 65280) >> 8)};
    }

    public static int O000000o(byte[] bArr, int i) {
        return ((bArr[i + 1] << 8) & 65280) + (bArr[i] & 255);
    }

    public final boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ZipShort) || this.value != ((ZipShort) obj).value) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return this.value;
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final String toString() {
        return "ZipShort value: " + this.value;
    }
}
