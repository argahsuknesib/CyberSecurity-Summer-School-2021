package com.google.android.gms.common.util;

import _m_j.o0O0OOO0;
import _m_j.o0O0OOOo;
import android.support.v4.app.NotificationCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CollectionUtils {
    private CollectionUtils() {
    }

    public static <K, V> Map<K, V> inOrderMapOf() {
        return mapOf();
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v) {
        return mapOf(k, v);
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2) {
        Map zzg = zzg(2, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        return Collections.unmodifiableMap(zzg);
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map zzg = zzg(3, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        return Collections.unmodifiableMap(zzg);
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map zzg = zzg(4, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        return Collections.unmodifiableMap(zzg);
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map zzg = zzg(5, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        zzg.put(k5, v5);
        return Collections.unmodifiableMap(zzg);
    }

    public static <K, V> Map<K, V> inOrderMapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map zzg = zzg(6, false);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        zzg.put(k4, v4);
        zzg.put(k5, v5);
        zzg.put(k6, v6);
        return Collections.unmodifiableMap(zzg);
    }

    public static <K, V> Map<K, V> inOrderMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int length = kArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableMap(zzb(length, false, kArr, vArr)) : inOrderMapOf(kArr[0], vArr[0]) : inOrderMapOf();
    }

    public static <T> Set<T> inOrderSetOf() {
        return setOf();
    }

    public static <T> Set<T> inOrderSetOf(T t) {
        return setOf(t);
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2) {
        Set zze = zze(2, false);
        zze.add(t);
        zze.add(t2);
        return Collections.unmodifiableSet(zze);
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2, T t3) {
        Set zze = zze(3, false);
        zze.add(t);
        zze.add(t2);
        zze.add(t3);
        return Collections.unmodifiableSet(zze);
    }

    public static <T> Set<T> inOrderSetOf(T t, T t2, T t3, T t4) {
        Set zze = zze(4, false);
        zze.add(t);
        zze.add(t2);
        zze.add(t3);
        zze.add(t4);
        return Collections.unmodifiableSet(zze);
    }

    public static <T> Set<T> inOrderSetOf(T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? length != 2 ? length != 3 ? length != 4 ? Collections.unmodifiableSet(zzb(tArr.length, false, tArr)) : inOrderSetOf(tArr[0], tArr[1], tArr[2], tArr[3]) : inOrderSetOf(tArr[0], tArr[1], tArr[2]) : inOrderSetOf(tArr[0], tArr[1]) : inOrderSetOf(tArr[0]) : inOrderSetOf();
    }

    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null) {
            return true;
        }
        return collection.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> map) {
        if (map == null) {
            return true;
        }
        return map.isEmpty();
    }

    @Deprecated
    public static <T> List<T> listOf() {
        return Collections.emptyList();
    }

    @Deprecated
    public static <T> List<T> listOf(T t) {
        return Collections.singletonList(t);
    }

    @Deprecated
    public static <T> List<T> listOf(T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableList(Arrays.asList(tArr)) : listOf(tArr[0]) : listOf();
    }

    public static <K, V> Map<K, V> mapOf() {
        return Collections.emptyMap();
    }

    public static <K, V> Map<K, V> mapOf(K k, V v) {
        return Collections.singletonMap(k, v);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2) {
        Map zzf = zzf(2, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        return Collections.unmodifiableMap(zzf);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3) {
        Map zzf = zzf(3, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        return Collections.unmodifiableMap(zzf);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        Map zzf = zzf(4, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        return Collections.unmodifiableMap(zzf);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        Map zzf = zzf(5, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        zzf.put(k5, v5);
        return Collections.unmodifiableMap(zzf);
    }

    public static <K, V> Map<K, V> mapOf(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5, K k6, V v6) {
        Map zzf = zzf(6, false);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        zzf.put(k4, v4);
        zzf.put(k5, v5);
        zzf.put(k6, v6);
        return Collections.unmodifiableMap(zzf);
    }

    public static <K, V> Map<K, V> mapOfKeyValueArrays(K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int length = kArr.length;
        return length != 0 ? length != 1 ? Collections.unmodifiableMap(zza(kArr.length, false, kArr, vArr)) : mapOf(kArr[0], vArr[0]) : mapOf();
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf() {
        return new LinkedHashMap();
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v) {
        return mutableInOrderMapOfWithSize(1, k, v);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v, K k2, V v2) {
        return mutableInOrderMapOfWithSize(2, k, v, k2, v2);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        return mutableInOrderMapOfWithSize(3, k, v, k2, v2, k3, v3);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int length = kArr.length;
        return length == 0 ? mutableInOrderMapOf() : zzb(length, true, kArr, vArr);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfKeyValueArraysWithSize(int i, K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int max = Math.max(i, kArr.length);
        return max == 0 ? mutableInOrderMapOf() : kArr.length == 0 ? mutableInOrderMapOfWithSize(max) : zzb(i, true, kArr, vArr);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i) {
        return i == 0 ? mutableInOrderMapOf() : zzg(i, true);
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i, K k, V v) {
        Map<K, V> zzg = zzg(Math.max(i, 1), true);
        zzg.put(k, v);
        return zzg;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i, K k, V v, K k2, V v2) {
        Map<K, V> zzg = zzg(Math.max(i, 2), true);
        zzg.put(k, v);
        zzg.put(k2, v2);
        return zzg;
    }

    public static <K, V> Map<K, V> mutableInOrderMapOfWithSize(int i, K k, V v, K k2, V v2, K k3, V v3) {
        Map<K, V> zzg = zzg(Math.max(i, 3), true);
        zzg.put(k, v);
        zzg.put(k2, v2);
        zzg.put(k3, v3);
        return zzg;
    }

    public static <T> Set<T> mutableInOrderSetOf() {
        return new LinkedHashSet();
    }

    public static <T> Set<T> mutableInOrderSetOf(T t) {
        return mutableInOrderSetOfWithSize(1, t);
    }

    public static <T> Set<T> mutableInOrderSetOf(T t, T t2) {
        return mutableInOrderSetOfWithSize(2, t, t2);
    }

    public static <T> Set<T> mutableInOrderSetOf(T... tArr) {
        return tArr.length == 0 ? mutableInOrderSetOf() : zzb(tArr.length, true, tArr);
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i) {
        return i == 0 ? mutableInOrderSetOf() : zze(i, true);
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i, T t) {
        Set<T> zze = zze(Math.max(i, 1), true);
        zze.add(t);
        return zze;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i, T t, T t2) {
        Set<T> zze = zze(Math.max(i, 2), true);
        zze.add(t);
        zze.add(t2);
        return zze;
    }

    public static <T> Set<T> mutableInOrderSetOfWithSize(int i, T... tArr) {
        int max = Math.max(i, tArr.length);
        return max == 0 ? mutableSetOf() : tArr.length == 0 ? mutableInOrderSetOfWithSize(i) : zzb(max, true, tArr);
    }

    public static <T> List<T> mutableListOf() {
        return new ArrayList();
    }

    public static <T> List<T> mutableListOf(T t) {
        return mutableListOfWithSize(1, t);
    }

    public static <T> List<T> mutableListOf(T t, T t2) {
        return mutableListOfWithSize(2, t, t2);
    }

    public static <T> List<T> mutableListOf(T... tArr) {
        return tArr.length == 0 ? mutableListOf() : new ArrayList(Arrays.asList(tArr));
    }

    public static <T> List<T> mutableListOfWithSize(int i) {
        return i == 0 ? mutableListOf() : zzc(i, true);
    }

    public static <T> List<T> mutableListOfWithSize(int i, T t) {
        List<T> zzc = zzc(Math.max(i, 1), true);
        zzc.add(t);
        return zzc;
    }

    public static <T> List<T> mutableListOfWithSize(int i, T t, T t2) {
        List<T> zzc = zzc(Math.max(i, 2), true);
        zzc.add(t);
        zzc.add(t2);
        return zzc;
    }

    public static <T> List<T> mutableListOfWithSize(int i, T... tArr) {
        int max = Math.max(i, tArr.length);
        if (max == 0) {
            return mutableListOf();
        }
        if (tArr.length == 0) {
            return mutableListOfWithSize(i);
        }
        if (tArr.length == max) {
            return new ArrayList(Arrays.asList(tArr));
        }
        List<T> zzc = zzc(max, true);
        zzc.addAll(Arrays.asList(tArr));
        return zzc;
    }

    public static <K, V> Map<K, V> mutableMapOf() {
        return new o0O0OOO0();
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v) {
        return mutableMapOfWithSize(1, k, v);
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v, K k2, V v2) {
        return mutableMapOfWithSize(2, k, v, k2, v2);
    }

    public static <K, V> Map<K, V> mutableMapOf(K k, V v, K k2, V v2, K k3, V v3) {
        return mutableMapOfWithSize(3, k, v, k2, v2, k3, v3);
    }

    public static <K, V> Map<K, V> mutableMapOfKeyValueArrays(K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int length = kArr.length;
        return length == 0 ? mutableMapOf() : zza(length, true, kArr, vArr);
    }

    public static <K, V> Map<K, V> mutableMapOfKeyValueArraysWithSize(int i, K[] kArr, V[] vArr) {
        zza(kArr, vArr);
        int max = Math.max(i, kArr.length);
        return max == 0 ? mutableMapOf() : kArr.length == 0 ? mutableMapOfWithSize(i) : zza(max, true, kArr, vArr);
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i) {
        return i == 0 ? mutableMapOf() : zzf(i, true);
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i, K k, V v) {
        Map<K, V> zzf = zzf(Math.max(i, 1), true);
        zzf.put(k, v);
        return zzf;
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i, K k, V v, K k2, V v2) {
        Map<K, V> zzf = zzf(Math.max(i, 2), true);
        zzf.put(k, v);
        zzf.put(k2, v2);
        return zzf;
    }

    public static <K, V> Map<K, V> mutableMapOfWithSize(int i, K k, V v, K k2, V v2, K k3, V v3) {
        Map<K, V> zzf = zzf(Math.max(i, 3), true);
        zzf.put(k, v);
        zzf.put(k2, v2);
        zzf.put(k3, v3);
        return zzf;
    }

    public static <T> Set<T> mutableSetOf() {
        return new o0O0OOOo();
    }

    public static <T> Set<T> mutableSetOf(T t) {
        return mutableSetOfWithSize(1, t);
    }

    public static <T> Set<T> mutableSetOf(T t, T t2) {
        return mutableSetOfWithSize(2, t, t2);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T>
     arg types: [int, int, T[]]
     candidates:
      com.google.android.gms.common.util.CollectionUtils.zza(java.util.Map, java.lang.Object[], java.lang.Object[]):void
      com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T> */
    public static <T> Set<T> mutableSetOf(T... tArr) {
        return tArr.length == 0 ? mutableSetOf() : zza(tArr.length, true, (Object[]) tArr);
    }

    public static <T> Set<T> mutableSetOfWithSize(int i) {
        return i == 0 ? mutableSetOf() : zzd(i, true);
    }

    public static <T> Set<T> mutableSetOfWithSize(int i, T t) {
        Set<T> zzd = zzd(Math.max(i, 1), true);
        zzd.add(t);
        return zzd;
    }

    public static <T> Set<T> mutableSetOfWithSize(int i, T t, T t2) {
        Set<T> zzd = zzd(Math.max(i, 2), true);
        zzd.add(t);
        zzd.add(t2);
        return zzd;
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T>
     arg types: [int, int, T[]]
     candidates:
      com.google.android.gms.common.util.CollectionUtils.zza(java.util.Map, java.lang.Object[], java.lang.Object[]):void
      com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T> */
    public static <T> Set<T> mutableSetOfWithSize(int i, T... tArr) {
        int max = Math.max(i, tArr.length);
        return max == 0 ? mutableSetOf() : tArr.length == 0 ? mutableSetOfWithSize(i) : zza(max, true, (Object[]) tArr);
    }

    @Deprecated
    public static <T> Set<T> setOf() {
        return Collections.emptySet();
    }

    @Deprecated
    public static <T> Set<T> setOf(T t) {
        return Collections.singleton(t);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2) {
        Set zzd = zzd(2, false);
        zzd.add(t);
        zzd.add(t2);
        return Collections.unmodifiableSet(zzd);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3) {
        Set zzd = zzd(3, false);
        zzd.add(t);
        zzd.add(t2);
        zzd.add(t3);
        return Collections.unmodifiableSet(zzd);
    }

    @Deprecated
    public static <T> Set<T> setOf(T t, T t2, T t3, T t4) {
        Set zzd = zzd(4, false);
        zzd.add(t);
        zzd.add(t2);
        zzd.add(t3);
        zzd.add(t4);
        return Collections.unmodifiableSet(zzd);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T>
     arg types: [int, int, T[]]
     candidates:
      com.google.android.gms.common.util.CollectionUtils.zza(java.util.Map, java.lang.Object[], java.lang.Object[]):void
      com.google.android.gms.common.util.CollectionUtils.zza(int, boolean, java.lang.Object[]):java.util.Set<T> */
    @Deprecated
    public static <T> Set<T> setOf(T... tArr) {
        int length = tArr.length;
        return length != 0 ? length != 1 ? length != 2 ? length != 3 ? length != 4 ? Collections.unmodifiableSet(zza(tArr.length, false, (Object[]) tArr)) : setOf(tArr[0], tArr[1], tArr[2], tArr[3]) : setOf(tArr[0], tArr[1], tArr[2]) : setOf(tArr[0], tArr[1]) : setOf(tArr[0]) : setOf();
    }

    private static <K, V> Map<K, V> zza(int i, boolean z, K[] kArr, V[] vArr) {
        Map<K, V> zzf = zzf(i, z);
        zza(zzf, kArr, vArr);
        return zzf;
    }

    private static <T> Set<T> zza(int i, boolean z, T[] tArr) {
        Set<T> zzd = zzd(i, z);
        Collections.addAll(zzd, tArr);
        return zzd;
    }

    private static <K, V> void zza(Map<K, V> map, K[] kArr, V[] vArr) {
        for (int i = 0; i < kArr.length; i++) {
            map.put(kArr[i], vArr[i]);
        }
    }

    private static <K, V> void zza(K[] kArr, V[] vArr) {
        if (kArr.length != vArr.length) {
            int length = kArr.length;
            int length2 = vArr.length;
            StringBuilder sb = new StringBuilder(66);
            sb.append("Key and values array lengths not equal: ");
            sb.append(length);
            sb.append(" != ");
            sb.append(length2);
            throw new IllegalArgumentException(sb.toString());
        }
    }

    private static <K, V> Map<K, V> zzb(int i, boolean z, K[] kArr, V[] vArr) {
        Map<K, V> zzg = zzg(i, z);
        zza(zzg, kArr, vArr);
        return zzg;
    }

    private static <T> Set<T> zzb(int i, boolean z, T[] tArr) {
        Set<T> zze = zze(i, z);
        Collections.addAll(zze, tArr);
        return zze;
    }

    private static <T> List<T> zzc(int i, boolean z) {
        return new ArrayList(i);
    }

    private static <T> Set<T> zzd(int i, boolean z) {
        return i <= (z ? NotificationCompat.FLAG_HIGH_PRIORITY : 256) ? new o0O0OOOo(i) : new HashSet(i, z ? 0.75f : 1.0f);
    }

    private static <T> Set<T> zze(int i, boolean z) {
        return new LinkedHashSet(i, z ? 0.75f : 1.0f);
    }

    private static <K, V> Map<K, V> zzf(int i, boolean z) {
        return i <= (z ? NotificationCompat.FLAG_HIGH_PRIORITY : 256) ? new o0O0OOO0(i) : new HashMap(i, z ? 0.75f : 1.0f);
    }

    private static <K, V> Map<K, V> zzg(int i, boolean z) {
        return new LinkedHashMap(i, z ? 0.75f : 1.0f);
    }
}
