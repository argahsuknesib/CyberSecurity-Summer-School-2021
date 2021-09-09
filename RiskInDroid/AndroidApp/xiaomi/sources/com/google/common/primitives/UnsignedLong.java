package com.google.common.primitives;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.math.BigInteger;

@GwtCompatible(serializable = true)
public final class UnsignedLong extends Number implements Serializable, Comparable<UnsignedLong> {
    public static final UnsignedLong MAX_VALUE = new UnsignedLong(-1);
    public static final UnsignedLong ONE = new UnsignedLong(1);
    public static final UnsignedLong ZERO = new UnsignedLong(0);
    private final long value;

    private UnsignedLong(long j) {
        this.value = j;
    }

    public static UnsignedLong fromLongBits(long j) {
        return new UnsignedLong(j);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(long j) {
        Preconditions.checkArgument(j >= 0, "value (%s) is outside the range for an unsigned long value", j);
        return fromLongBits(j);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(BigInteger bigInteger) {
        Preconditions.checkNotNull(bigInteger);
        Preconditions.checkArgument(bigInteger.signum() >= 0 && bigInteger.bitLength() <= 64, "value (%s) is outside the range for an unsigned long value", bigInteger);
        return fromLongBits(bigInteger.longValue());
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str) {
        return valueOf(str, 10);
    }

    @CanIgnoreReturnValue
    public static UnsignedLong valueOf(String str, int i) {
        return fromLongBits(UnsignedLongs.parseUnsignedLong(str, i));
    }

    public final UnsignedLong plus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value + ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public final UnsignedLong minus(UnsignedLong unsignedLong) {
        return fromLongBits(this.value - ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public final UnsignedLong times(UnsignedLong unsignedLong) {
        return fromLongBits(this.value * ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value);
    }

    public final UnsignedLong dividedBy(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.divide(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public final UnsignedLong mod(UnsignedLong unsignedLong) {
        return fromLongBits(UnsignedLongs.remainder(this.value, ((UnsignedLong) Preconditions.checkNotNull(unsignedLong)).value));
    }

    public final int intValue() {
        return (int) this.value;
    }

    public final long longValue() {
        return this.value;
    }

    public final float floatValue() {
        long j = this.value;
        float f = (float) (Long.MAX_VALUE & j);
        return j < 0 ? f + 9.223372E18f : f;
    }

    public final double doubleValue() {
        long j = this.value;
        double d = (double) (Long.MAX_VALUE & j);
        if (j >= 0) {
            return d;
        }
        Double.isNaN(d);
        return d + 9.223372036854776E18d;
    }

    public final BigInteger bigIntegerValue() {
        BigInteger valueOf = BigInteger.valueOf(this.value & Long.MAX_VALUE);
        return this.value < 0 ? valueOf.setBit(63) : valueOf;
    }

    public final int compareTo(UnsignedLong unsignedLong) {
        Preconditions.checkNotNull(unsignedLong);
        return UnsignedLongs.compare(this.value, unsignedLong.value);
    }

    public final int hashCode() {
        return Longs.hashCode(this.value);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof UnsignedLong) || this.value != ((UnsignedLong) obj).value) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return UnsignedLongs.toString(this.value);
    }

    public final String toString(int i) {
        return UnsignedLongs.toString(this.value, i);
    }
}
