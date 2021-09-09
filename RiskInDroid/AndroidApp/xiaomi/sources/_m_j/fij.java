package _m_j;

import java.util.Iterator;
import java.util.NoSuchElementException;

public final class fij {
    public static boolean O000000o(byte[] bArr, byte[] bArr2) {
        if (bArr == bArr2) {
            return true;
        }
        if (bArr == null || bArr.length != bArr2.length) {
            return false;
        }
        byte b = 0;
        for (int i = 0; i != bArr.length; i++) {
            b |= bArr[i] ^ bArr2[i];
        }
        return b == 0;
    }

    public static void O000000o(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = 0;
        }
    }

    public static void O000000o(long[] jArr) {
        for (int i = 0; i < jArr.length; i++) {
            jArr[i] = 0;
        }
    }

    public static byte[] O00000Oo(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public static byte[] O00000o0(byte[] bArr) {
        byte[] bArr2 = new byte[12];
        if (bArr.length - 0 < 12) {
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 0);
        } else {
            System.arraycopy(bArr, 0, bArr2, 0, 12);
        }
        return bArr2;
    }

    public static class O000000o<T> implements Iterator<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        private final T[] f16400O000000o;
        private int O00000Oo = 0;

        public O000000o(T[] tArr) {
            this.f16400O000000o = tArr;
        }

        public final boolean hasNext() {
            return this.O00000Oo < this.f16400O000000o.length;
        }

        public final T next() {
            int i = this.O00000Oo;
            T[] tArr = this.f16400O000000o;
            if (i != tArr.length) {
                this.O00000Oo = i + 1;
                return tArr[i];
            }
            throw new NoSuchElementException("Out of elements: " + this.O00000Oo);
        }

        public final void remove() {
            throw new UnsupportedOperationException("Cannot remove element from an Array.");
        }
    }
}
