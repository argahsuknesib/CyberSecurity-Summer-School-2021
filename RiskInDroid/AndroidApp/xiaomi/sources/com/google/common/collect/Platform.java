package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@GwtCompatible(emulated = true)
final class Platform {
    static int reduceExponentIfGwt(int i) {
        return i;
    }

    static int reduceIterationsIfGwt(int i) {
        return i;
    }

    static <K, V> Map<K, V> newHashMapWithExpectedSize(int i) {
        return Maps.newHashMapWithExpectedSize(i);
    }

    static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return Maps.newLinkedHashMapWithExpectedSize(i);
    }

    static <E> Set<E> newHashSetWithExpectedSize(int i) {
        return Sets.newHashSetWithExpectedSize(i);
    }

    static <E> Set<E> newLinkedHashSetWithExpectedSize(int i) {
        return Sets.newLinkedHashSetWithExpectedSize(i);
    }

    static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return Maps.newLinkedHashMap();
    }

    static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return Sets.newLinkedHashSet();
    }

    static <T> T[] newArray(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }

    static <T> T[] copy(Object[] objArr, int i, int i2, T[] tArr) {
        return Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }

    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    private Platform() {
    }
}
