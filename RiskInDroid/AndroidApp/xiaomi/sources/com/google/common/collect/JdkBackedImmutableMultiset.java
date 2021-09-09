package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@GwtCompatible
final class JdkBackedImmutableMultiset<E> extends ImmutableMultiset<E> {
    private final Map<E, Integer> delegateMap;
    private transient ImmutableSet<E> elementSet;
    private final ImmutableList<Multiset.Entry<E>> entries;
    private final long size;

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    static <E> ImmutableMultiset<E> create(Collection<? extends Multiset.Entry<? extends E>> collection) {
        Multiset.Entry[] entryArr = (Multiset.Entry[]) collection.toArray(new Multiset.Entry[0]);
        HashMap newHashMapWithExpectedSize = Maps.newHashMapWithExpectedSize(entryArr.length);
        long j = 0;
        for (int i = 0; i < entryArr.length; i++) {
            Multiset.Entry entry = entryArr[i];
            int count = entry.getCount();
            j += (long) count;
            Object checkNotNull = Preconditions.checkNotNull(entry.getElement());
            newHashMapWithExpectedSize.put(checkNotNull, Integer.valueOf(count));
            if (!(entry instanceof Multisets.ImmutableEntry)) {
                entryArr[i] = Multisets.immutableEntry(checkNotNull, count);
            }
        }
        return new JdkBackedImmutableMultiset(newHashMapWithExpectedSize, ImmutableList.asImmutableList(entryArr), j);
    }

    private JdkBackedImmutableMultiset(Map<E, Integer> map, ImmutableList<Multiset.Entry<E>> immutableList, long j) {
        this.delegateMap = map;
        this.entries = immutableList;
        this.size = j;
    }

    public final int count(Object obj) {
        return this.delegateMap.getOrDefault(obj, 0).intValue();
    }

    public final ImmutableSet<E> elementSet() {
        ImmutableSet<E> immutableSet = this.elementSet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableMultiset.ElementSet elementSet2 = new ImmutableMultiset.ElementSet(this.entries, this);
        this.elementSet = elementSet2;
        return elementSet2;
    }

    /* access modifiers changed from: package-private */
    public final Multiset.Entry<E> getEntry(int i) {
        return this.entries.get(i);
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }
}
