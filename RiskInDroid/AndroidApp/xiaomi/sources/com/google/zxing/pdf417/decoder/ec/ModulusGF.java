package com.google.zxing.pdf417.decoder.ec;

public final class ModulusGF {
    public static final ModulusGF PDF417_GF = new ModulusGF(929, 3);
    private final int[] expTable;
    private final int[] logTable;
    private final int modulus;
    private final ModulusPoly one;
    private final ModulusPoly zero;

    private ModulusGF(int i, int i2) {
        this.modulus = i;
        this.expTable = new int[i];
        this.logTable = new int[i];
        int i3 = 1;
        for (int i4 = 0; i4 < i; i4++) {
            this.expTable[i4] = i3;
            i3 = (i3 * i2) % i;
        }
        for (int i5 = 0; i5 < i - 1; i5++) {
            this.logTable[this.expTable[i5]] = i5;
        }
        this.zero = new ModulusPoly(this, new int[]{0});
        this.one = new ModulusPoly(this, new int[]{1});
    }

    /* access modifiers changed from: package-private */
    public final ModulusPoly getZero() {
        return this.zero;
    }

    /* access modifiers changed from: package-private */
    public final ModulusPoly getOne() {
        return this.one;
    }

    /* access modifiers changed from: package-private */
    public final ModulusPoly buildMonomial(int i, int i2) {
        if (i < 0) {
            throw new IllegalArgumentException();
        } else if (i2 == 0) {
            return this.zero;
        } else {
            int[] iArr = new int[(i + 1)];
            iArr[0] = i2;
            return new ModulusPoly(this, iArr);
        }
    }

    /* access modifiers changed from: package-private */
    public final int add(int i, int i2) {
        return (i + i2) % this.modulus;
    }

    /* access modifiers changed from: package-private */
    public final int subtract(int i, int i2) {
        int i3 = this.modulus;
        return ((i + i3) - i2) % i3;
    }

    /* access modifiers changed from: package-private */
    public final int exp(int i) {
        return this.expTable[i];
    }

    /* access modifiers changed from: package-private */
    public final int log(int i) {
        if (i != 0) {
            return this.logTable[i];
        }
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final int inverse(int i) {
        if (i != 0) {
            return this.expTable[(this.modulus - this.logTable[i]) - 1];
        }
        throw new ArithmeticException();
    }

    /* access modifiers changed from: package-private */
    public final int multiply(int i, int i2) {
        if (i == 0 || i2 == 0) {
            return 0;
        }
        int[] iArr = this.expTable;
        int[] iArr2 = this.logTable;
        return iArr[(iArr2[i] + iArr2[i2]) % (this.modulus - 1)];
    }

    /* access modifiers changed from: package-private */
    public final int getSize() {
        return this.modulus;
    }
}
