package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CopyOnWriteMultiset<E> implements Iterable<E> {
    private final Map<E, Integer> elementCounts = new HashMap();
    private Set<E> elementSet = Collections.emptySet();
    private List<E> elements = Collections.emptyList();
    private final Object lock = new Object();

    public final void add(E e) {
        synchronized (this.lock) {
            ArrayList arrayList = new ArrayList(this.elements);
            arrayList.add(e);
            this.elements = Collections.unmodifiableList(arrayList);
            Integer num = this.elementCounts.get(e);
            if (num == null) {
                HashSet hashSet = new HashSet(this.elementSet);
                hashSet.add(e);
                this.elementSet = Collections.unmodifiableSet(hashSet);
            }
            Map<E, Integer> map = this.elementCounts;
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            map.put(e, Integer.valueOf(i));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        return;
     */
    public final void remove(E e) {
        synchronized (this.lock) {
            Integer num = this.elementCounts.get(e);
            if (num != null) {
                ArrayList arrayList = new ArrayList(this.elements);
                arrayList.remove(e);
                this.elements = Collections.unmodifiableList(arrayList);
                if (num.intValue() == 1) {
                    this.elementCounts.remove(e);
                    HashSet hashSet = new HashSet(this.elementSet);
                    hashSet.remove(e);
                    this.elementSet = Collections.unmodifiableSet(hashSet);
                } else {
                    this.elementCounts.put(e, Integer.valueOf(num.intValue() - 1));
                }
            }
        }
    }

    public final Set<E> elementSet() {
        Set<E> set;
        synchronized (this.lock) {
            set = this.elementSet;
        }
        return set;
    }

    public final Iterator<E> iterator() {
        Iterator<E> it;
        synchronized (this.lock) {
            it = this.elements.iterator();
        }
        return it;
    }
}
