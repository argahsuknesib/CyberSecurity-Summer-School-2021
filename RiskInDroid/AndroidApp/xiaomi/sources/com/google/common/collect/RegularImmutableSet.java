package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Spliterator;
import java.util.Spliterators;

@GwtCompatible(emulated = true, serializable = true)
final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> EMPTY = new RegularImmutableSet<>(new Object[0], 0, null, 0);
    private final transient Object[] elements;
    private final transient int hashCode;
    private final transient int mask;
    @VisibleForTesting
    final transient Object[] table;

    /* access modifiers changed from: package-private */
    public final int internalArrayStart() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2) {
        this.elements = objArr;
        this.table = objArr2;
        this.mask = i2;
        this.hashCode = i;
    }

    public final boolean contains(Object obj) {
        Object[] objArr = this.table;
        if (obj == null || objArr == null) {
            return false;
        }
        int smearedHash = Hashing.smearedHash(obj);
        while (true) {
            int i = smearedHash & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            smearedHash = i + 1;
        }
    }

    public final int size() {
        return this.elements.length;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.forArray(this.elements);
    }

    public final Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.elements, 1297);
    }

    /* access modifiers changed from: package-private */
    public final Object[] internalArray() {
        return this.elements;
    }

    /* access modifiers changed from: package-private */
    public final int internalArrayEnd() {
        return this.elements.length;
    }

    /* access modifiers changed from: package-private */
    public final int copyIntoArray(Object[] objArr, int i) {
        Object[] objArr2 = this.elements;
        System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        return i + this.elements.length;
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<E> createAsList() {
        return this.table == null ? ImmutableList.of() : new RegularImmutableAsList(this, this.elements);
    }

    public final int hashCode() {
        return this.hashCode;
    }
}
