package _m_j;

import java.lang.reflect.Array;

public final class jdd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final Object[] f1774O000000o = new Object[0];
    public static final Class<?>[] O00000Oo = new Class[0];
    public static final long[] O00000o = new long[0];
    public static final String[] O00000o0 = new String[0];
    public static final Long[] O00000oO = new Long[0];
    public static final int[] O00000oo = new int[0];
    public static final Integer[] O0000O0o = new Integer[0];
    public static final short[] O0000OOo = new short[0];
    public static final byte[] O0000Oo = new byte[0];
    public static final Short[] O0000Oo0 = new Short[0];
    public static final Byte[] O0000OoO = new Byte[0];
    public static final double[] O0000Ooo = new double[0];
    public static final Boolean[] O0000o = new Boolean[0];
    public static final float[] O0000o0 = new float[0];
    public static final Double[] O0000o00 = new Double[0];
    public static final Float[] O0000o0O = new Float[0];
    public static final boolean[] O0000o0o = new boolean[0];
    public static final Character[] O0000oO = new Character[0];
    public static final char[] O0000oO0 = new char[0];

    private static int O000000o(Object obj) {
        if (obj == null) {
            return 0;
        }
        return Array.getLength(obj);
    }

    public static boolean O000000o(char[] cArr) {
        return O000000o(cArr) == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0031  */
    public static <T> T[] O000000o(T[] tArr, Object obj) {
        int i;
        if (tArr != null) {
            if (obj == null) {
                i = 0;
                while (true) {
                    if (i >= tArr.length) {
                        break;
                    } else if (tArr[i] == null) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (i != -1) {
                    int O000000o2 = O000000o(tArr);
                    if (i < 0 || i >= O000000o2) {
                        throw new IndexOutOfBoundsException("Index: " + i + ", Length: " + O000000o2);
                    }
                    int i2 = O000000o2 - 1;
                    Object newInstance = Array.newInstance(tArr.getClass().getComponentType(), i2);
                    System.arraycopy(tArr, 0, newInstance, 0, i);
                    if (i < i2) {
                        System.arraycopy(tArr, i + 1, newInstance, i, (O000000o2 - i) - 1);
                    }
                    return (Object[]) newInstance;
                } else if (tArr == null) {
                    return null;
                } else {
                    return (Object[]) tArr.clone();
                }
            } else {
                int i3 = 0;
                while (true) {
                    if (i3 >= tArr.length) {
                        break;
                    } else if (obj.equals(tArr[i3])) {
                        i = i3;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (i != -1) {
                }
            }
        }
        i = -1;
        if (i != -1) {
        }
    }
}
