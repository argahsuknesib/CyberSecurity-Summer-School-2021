package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing {
    private Hashing() {
    }

    static int smear(int i) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)) * 461845907);
    }

    static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }

    static int closedTableSize(int i, double d) {
        int max = Math.max(i, 2);
        int highestOneBit = Integer.highestOneBit(max);
        double d2 = (double) highestOneBit;
        Double.isNaN(d2);
        if (max <= ((int) (d * d2))) {
            return highestOneBit;
        }
        int i2 = highestOneBit << 1;
        if (i2 > 0) {
            return i2;
        }
        return 1073741824;
    }

    static boolean needsResizing(int i, int i2, double d) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        return ((double) i) > d * d2 && i2 < 1073741824;
    }
}
