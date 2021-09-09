package com.google.android.gms.common.util;

import _m_j.jdn;
import com.google.android.gms.common.internal.Objects;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

@VisibleForTesting
public final class ArrayUtils {

    static class zza {
        HashMap<Object, zza> zzzb;

        zza(int i) {
            this.zzzb = new HashMap<>(i);
        }

        private final zza zzd(Object obj) {
            zza zza = this.zzzb.get(obj);
            if (zza != null) {
                return zza;
            }
            zza zza2 = new zza();
            this.zzzb.put(obj, zza2);
            return zza2;
        }

        /* access modifiers changed from: package-private */
        public final void zzb(Object obj) {
            zzd(obj).count++;
        }

        /* access modifiers changed from: package-private */
        public final void zzc(Object obj) {
            zza zzd = zzd(obj);
            zzd.count--;
        }
    }

    private ArrayUtils() {
    }

    public static int[] appendToArray(int[] iArr, int i) {
        int[] copyOf = (iArr == null || iArr.length == 0) ? new int[1] : Arrays.copyOf(iArr, iArr.length + 1);
        copyOf[copyOf.length - 1] = i;
        return copyOf;
    }

    public static <T> T[] appendToArray(T[] tArr, T t) {
        if (tArr == null && t == null) {
            throw new IllegalArgumentException("Cannot generate array of generic type w/o class info");
        }
        T[] copyOf = tArr == null ? (Object[]) Array.newInstance(t.getClass(), 1) : Arrays.copyOf(tArr, tArr.length + 1);
        copyOf[copyOf.length - 1] = t;
        return copyOf;
    }

    public static <T> T[] concat(T[]... tArr) {
        if (tArr.length == 0) {
            return (Object[]) Array.newInstance(tArr.getClass(), 0);
        }
        int i = 0;
        for (T[] length : tArr) {
            i += length.length;
        }
        T[] copyOf = Arrays.copyOf(tArr[0], i);
        int length2 = tArr[0].length;
        for (int i2 = 1; i2 < tArr.length; i2++) {
            T[] tArr2 = tArr[i2];
            System.arraycopy(tArr2, 0, copyOf, length2, tArr2.length);
            length2 += tArr2.length;
        }
        return copyOf;
    }

    public static byte[] concatByteArrays(byte[]... bArr) {
        if (bArr.length == 0) {
            return new byte[0];
        }
        int i = 0;
        for (byte[] length : bArr) {
            i += length.length;
        }
        byte[] copyOf = Arrays.copyOf(bArr[0], i);
        int length2 = bArr[0].length;
        for (int i2 = 1; i2 < bArr.length; i2++) {
            byte[] bArr2 = bArr[i2];
            System.arraycopy(bArr2, 0, copyOf, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return copyOf;
    }

    public static boolean contains(byte[] bArr, byte b) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (b2 == b) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(char[] cArr, char c) {
        if (cArr == null) {
            return false;
        }
        for (char c2 : cArr) {
            if (c2 == c) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(double[] dArr, double d) {
        if (dArr == null) {
            return false;
        }
        for (double d2 : dArr) {
            if (d2 == d) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(float[] fArr, float f, float f2) {
        if (fArr == null) {
            return false;
        }
        float f3 = f - f2;
        float f4 = f + f2;
        for (float f5 : fArr) {
            if (f3 <= f5 && f5 <= f4) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static <T> boolean contains(Object[] objArr, Object obj) {
        return indexOf(objArr, obj) >= 0;
    }

    public static boolean contains(short[] sArr, short s) {
        if (sArr == null) {
            return false;
        }
        for (short s2 : sArr) {
            if (s2 == s) {
                return true;
            }
        }
        return false;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        if (zArr == null) {
            return false;
        }
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsIgnoreCase(String[] strArr, String str) {
        if (strArr == null) {
            return false;
        }
        for (String str2 : strArr) {
            if (str2 == str) {
                return true;
            }
            if (str2 != null && str2.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean equalsAnyOrder(Object[] objArr, Object[] objArr2) {
        if (objArr == objArr2) {
            return true;
        }
        int length = objArr == null ? 0 : objArr.length;
        int length2 = objArr2 == null ? 0 : objArr2.length;
        if (length == 0 && length2 == 0) {
            return true;
        }
        if (length != length2) {
            return false;
        }
        zza zza2 = new zza(length);
        for (Object zzb : objArr) {
            zza2.zzb(zzb);
        }
        for (Object zzc : objArr2) {
            zza2.zzc(zzc);
        }
        for (zza zza3 : zza2.zzzb.values()) {
            if (zza3.count != 0) {
                return false;
            }
        }
        return true;
    }

    public static <T> int indexOf(T[] tArr, T t) {
        int length = tArr != null ? tArr.length : 0;
        for (int i = 0; i < length; i++) {
            if (Objects.equal(tArr[i], t)) {
                return i;
            }
        }
        return -1;
    }

    public static <T> ArrayList<T> newArrayList() {
        return new ArrayList<>();
    }

    public static <T> int rearrange(T[] tArr, Predicate<T> predicate) {
        if (tArr == null || tArr.length == 0) {
            return 0;
        }
        int length = tArr.length;
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            if (predicate.apply(tArr[i2])) {
                if (i != i2) {
                    T t = tArr[i];
                    tArr[i] = tArr[i2];
                    tArr[i2] = t;
                }
                i++;
            }
        }
        return i;
    }

    public static int[] removeAll(int[] iArr, int... iArr2) {
        int i;
        if (iArr == null) {
            return null;
        }
        if (iArr2 == null || iArr2.length == 0) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        int[] iArr3 = new int[iArr.length];
        if (iArr2.length == 1) {
            i = 0;
            for (int i2 : iArr) {
                if (iArr2[0] != i2) {
                    iArr3[i] = i2;
                    i++;
                }
            }
        } else {
            i = 0;
            for (int i3 : iArr) {
                if (!contains(iArr2, i3)) {
                    iArr3[i] = i3;
                    i++;
                }
            }
        }
        return resize(iArr3, i);
    }

    public static <T> T[] removeAll(T[] tArr, T... tArr2) {
        int i;
        if (tArr == null) {
            return null;
        }
        if (tArr2 == null || tArr2.length == 0) {
            return Arrays.copyOf(tArr, tArr.length);
        }
        Object[] objArr = (Object[]) Array.newInstance(tArr2.getClass().getComponentType(), tArr.length);
        if (tArr2.length == 1) {
            i = 0;
            for (T t : tArr) {
                if (!Objects.equal(tArr2[0], t)) {
                    objArr[i] = t;
                    i++;
                }
            }
        } else {
            i = 0;
            for (T t2 : tArr) {
                if (!contains(tArr2, t2)) {
                    objArr[i] = t2;
                    i++;
                }
            }
        }
        return resize(objArr, i);
    }

    public static int[] resize(int[] iArr, int i) {
        if (iArr == null) {
            return null;
        }
        return i != iArr.length ? Arrays.copyOf(iArr, i) : iArr;
    }

    public static <T> T[] resize(T[] tArr, int i) {
        if (tArr == null) {
            return null;
        }
        return i != tArr.length ? Arrays.copyOf(tArr, i) : tArr;
    }

    public static <T> ArrayList<T> toArrayList(Collection<T> collection) {
        if (collection == null) {
            return null;
        }
        return new ArrayList<>(collection);
    }

    public static <T> ArrayList<T> toArrayList(T[] tArr) {
        ArrayList<T> arrayList = new ArrayList<>(r0);
        for (T add : tArr) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public static long[] toLongArray(Collection<Long> collection) {
        int i = 0;
        if (collection == null || collection.size() == 0) {
            return new long[0];
        }
        long[] jArr = new long[collection.size()];
        for (Long longValue : collection) {
            jArr[i] = longValue.longValue();
            i++;
        }
        return jArr;
    }

    public static long[] toLongArray(Long[] lArr) {
        if (lArr == null) {
            return new long[0];
        }
        long[] jArr = new long[lArr.length];
        for (int i = 0; i < lArr.length; i++) {
            jArr[i] = lArr[i].longValue();
        }
        return jArr;
    }

    public static int[] toPrimitiveArray(Collection<Integer> collection) {
        int i = 0;
        if (collection == null || collection.size() == 0) {
            return new int[0];
        }
        int[] iArr = new int[collection.size()];
        for (Integer intValue : collection) {
            iArr[i] = intValue.intValue();
            i++;
        }
        return iArr;
    }

    public static int[] toPrimitiveArray(Integer[] numArr) {
        if (numArr == null) {
            return new int[0];
        }
        int[] iArr = new int[numArr.length];
        for (int i = 0; i < numArr.length; i++) {
            iArr[i] = numArr[i].intValue();
        }
        return iArr;
    }

    public static String[] toStringArray(Collection<String> collection) {
        return (collection == null || collection.size() == 0) ? new String[0] : (String[]) collection.toArray(new String[collection.size()]);
    }

    public static Boolean[] toWrapperArray(boolean[] zArr) {
        if (zArr == null) {
            return null;
        }
        int length = zArr.length;
        Boolean[] boolArr = new Boolean[length];
        for (int i = 0; i < length; i++) {
            boolArr[i] = Boolean.valueOf(zArr[i]);
        }
        return boolArr;
    }

    public static Byte[] toWrapperArray(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        Byte[] bArr2 = new Byte[length];
        for (int i = 0; i < length; i++) {
            bArr2[i] = Byte.valueOf(bArr[i]);
        }
        return bArr2;
    }

    public static Character[] toWrapperArray(char[] cArr) {
        if (cArr == null) {
            return null;
        }
        int length = cArr.length;
        Character[] chArr = new Character[length];
        for (int i = 0; i < length; i++) {
            chArr[i] = Character.valueOf(cArr[i]);
        }
        return chArr;
    }

    public static Double[] toWrapperArray(double[] dArr) {
        if (dArr == null) {
            return null;
        }
        int length = dArr.length;
        Double[] dArr2 = new Double[length];
        for (int i = 0; i < length; i++) {
            dArr2[i] = Double.valueOf(dArr[i]);
        }
        return dArr2;
    }

    public static Float[] toWrapperArray(float[] fArr) {
        if (fArr == null) {
            return null;
        }
        int length = fArr.length;
        Float[] fArr2 = new Float[length];
        for (int i = 0; i < length; i++) {
            fArr2[i] = Float.valueOf(fArr[i]);
        }
        return fArr2;
    }

    public static Integer[] toWrapperArray(int[] iArr) {
        if (iArr == null) {
            return null;
        }
        int length = iArr.length;
        Integer[] numArr = new Integer[length];
        for (int i = 0; i < length; i++) {
            numArr[i] = Integer.valueOf(iArr[i]);
        }
        return numArr;
    }

    public static Long[] toWrapperArray(long[] jArr) {
        if (jArr == null) {
            return null;
        }
        int length = jArr.length;
        Long[] lArr = new Long[length];
        for (int i = 0; i < length; i++) {
            lArr[i] = Long.valueOf(jArr[i]);
        }
        return lArr;
    }

    public static Short[] toWrapperArray(short[] sArr) {
        if (sArr == null) {
            return null;
        }
        int length = sArr.length;
        Short[] shArr = new Short[length];
        for (int i = 0; i < length; i++) {
            shArr[i] = Short.valueOf(sArr[i]);
        }
        return shArr;
    }

    public static void writeArray(StringBuilder sb, double[] dArr) {
        int length = dArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Double.toString(dArr[i]));
        }
    }

    public static void writeArray(StringBuilder sb, float[] fArr) {
        int length = fArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Float.toString(fArr[i]));
        }
    }

    public static void writeArray(StringBuilder sb, int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Integer.toString(iArr[i]));
        }
    }

    public static void writeArray(StringBuilder sb, long[] jArr) {
        int length = jArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Long.toString(jArr[i]));
        }
    }

    public static <T> void writeArray(StringBuilder sb, T[] tArr) {
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(tArr[i].toString());
        }
    }

    public static void writeArray(StringBuilder sb, boolean[] zArr) {
        int length = zArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(Boolean.toString(zArr[i]));
        }
    }

    public static void writeStringArray(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(",");
            }
            sb.append(jdn.f1779O000000o);
            sb.append(strArr[i]);
            sb.append(jdn.f1779O000000o);
        }
    }
}
