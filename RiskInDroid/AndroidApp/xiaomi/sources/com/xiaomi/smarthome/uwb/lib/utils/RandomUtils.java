package com.xiaomi.smarthome.uwb.lib.utils;

import java.util.Random;

public class RandomUtils {
    private static final Random RANDOM = new Random();

    public static byte[] nextBytes(int i) {
        byte[] bArr = new byte[i];
        RANDOM.nextBytes(bArr);
        return bArr;
    }

    public static int nextInt(int i, int i2) {
        return i == i2 ? i : i + RANDOM.nextInt(i2 - i);
    }

    public static long nextLong(long j, long j2) {
        return j == j2 ? j : (long) nextDouble((double) j, (double) j2);
    }

    public static double nextDouble(double d, double d2) {
        return d == d2 ? d : d + ((d2 - d) * RANDOM.nextDouble());
    }

    public static float nextFloat(float f, float f2) {
        return f == f2 ? f : f + ((f2 - f) * RANDOM.nextFloat());
    }
}
