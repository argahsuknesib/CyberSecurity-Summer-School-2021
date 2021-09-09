package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import java.util.function.Consumer;

@GwtCompatible(emulated = true)
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    RegularImmutableAsList(ImmutableCollection immutableCollection, ImmutableList immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    RegularImmutableAsList(ImmutableCollection immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    /* access modifiers changed from: package-private */
    public ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    /* access modifiers changed from: package-private */
    public ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    public UnmodifiableListIterator<E> listIterator(int i) {
        return this.delegateList.listIterator(i);
    }

    @GwtIncompatible
    public void forEach(Consumer<? super E> consumer) {
        this.delegateList.forEach(consumer);
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i) {
        return this.delegateList.copyIntoArray(objArr, i);
    }

    /* access modifiers changed from: package-private */
    public Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    /* access modifiers changed from: package-private */
    public int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    /* access modifiers changed from: package-private */
    public int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    public E get(int i) {
        return this.delegateList.get(i);
    }
}
