package com.drew.lang;

import java.io.IOException;

public final class BufferBoundsException extends IOException {
    private static final long serialVersionUID = 2911102837808946396L;

    public BufferBoundsException(int i, int i2, long j) {
        super(getMessage(i, i2, j));
    }

    public BufferBoundsException(String str) {
        super(str);
    }

    private static String getMessage(int i, int i2, long j) {
        if (i < 0) {
            return String.format("Attempt to read from buffer using a negative index (%d)", Integer.valueOf(i));
        } else if (i2 < 0) {
            return String.format("Number of requested bytes cannot be negative (%d)", Integer.valueOf(i2));
        } else if ((((long) i) + ((long) i2)) - 1 > 2147483647L) {
            return String.format("Number of requested bytes summed with starting index exceed maximum range of signed 32 bit integers (requested index: %d, requested count: %d)", Integer.valueOf(i), Integer.valueOf(i2));
        } else {
            return String.format("Attempt to read from beyond end of underlying data source (requested index: %d, requested count: %d, max index: %d)", Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(j - 1));
        }
    }
}
