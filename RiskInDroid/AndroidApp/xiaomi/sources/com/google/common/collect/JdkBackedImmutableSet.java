package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import java.util.Set;

@GwtCompatible(serializable = true)
final class JdkBackedImmutableSet<E> extends IndexedImmutableSet<E> {
    private final Set<?> delegate;
    private final ImmutableList<E> delegateList;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    JdkBackedImmutableSet(Set<?> set, ImmutableList<E> immutableList) {
        this.delegate = set;
        this.delegateList = immutableList;
    }

    /* access modifiers changed from: package-private */
    public final E get(int i) {
        return this.delegateList.get(i);
    }

    public final boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    public final int size() {
        return this.delegateList.size();
    }
}
