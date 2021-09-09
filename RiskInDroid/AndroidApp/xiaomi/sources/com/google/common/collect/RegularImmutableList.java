package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import java.util.Spliterator;
import java.util.Spliterators;

@GwtCompatible(emulated = true, serializable = true)
class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> EMPTY = new RegularImmutableList(new Object[0]);
    @VisibleForTesting
    final transient Object[] array;

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public boolean isPartialView() {
        return false;
    }

    RegularImmutableList(Object[] objArr) {
        this.array = objArr;
    }

    public int size() {
        return this.array.length;
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return this.array;
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        return this.array.length;
    }

    /* access modifiers changed from: package-private */
    public int copyIntoArray(Object[] objArr, int i) {
        Object[] objArr2 = this.array;
        System.arraycopy(objArr2, 0, objArr, i, objArr2.length);
        return i + this.array.length;
    }

    public E get(int i) {
        return this.array[i];
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        Object[] objArr = this.array;
        return Iterators.forArray(objArr, 0, objArr.length, i);
    }

    public Spliterator<E> spliterator() {
        return Spliterators.spliterator(this.array, 1296);
    }
}
