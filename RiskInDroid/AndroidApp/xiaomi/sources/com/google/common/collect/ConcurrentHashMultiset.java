package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.common.math.IntMath;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

@GwtIncompatible
public final class ConcurrentHashMultiset<E> extends AbstractMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;
    public final transient ConcurrentMap<E, AtomicInteger> countMap;

    public final /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    static class FieldSettersHolder {
        static final Serialization.FieldSetter<ConcurrentHashMultiset> COUNT_MAP_FIELD_SETTER = Serialization.getFieldSetter(ConcurrentHashMultiset.class, "countMap");

        private FieldSettersHolder() {
        }
    }

    public static <E> ConcurrentHashMultiset<E> create() {
        return new ConcurrentHashMultiset<>(new ConcurrentHashMap());
    }

    public static <E> ConcurrentHashMultiset<E> create(Iterable<? extends E> iterable) {
        ConcurrentHashMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    @Beta
    public static <E> ConcurrentHashMultiset<E> create(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        return new ConcurrentHashMultiset<>(concurrentMap);
    }

    @VisibleForTesting
    ConcurrentHashMultiset(ConcurrentMap<E, AtomicInteger> concurrentMap) {
        Preconditions.checkArgument(concurrentMap.isEmpty(), "the backing map (%s) must be empty", concurrentMap);
        this.countMap = concurrentMap;
    }

    public final int count(Object obj) {
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        return atomicInteger.get();
    }

    public final int size() {
        long j = 0;
        for (AtomicInteger atomicInteger : this.countMap.values()) {
            j += (long) atomicInteger.get();
        }
        return Ints.saturatedCast(j);
    }

    public final Object[] toArray() {
        return snapshot().toArray();
    }

    public final <T> T[] toArray(T[] tArr) {
        return snapshot().toArray(tArr);
    }

    private List<E> snapshot() {
        ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
        for (Multiset.Entry entry : entrySet()) {
            Object element = entry.getElement();
            for (int count = entry.getCount(); count > 0; count--) {
                newArrayListWithExpectedSize.add(element);
            }
        }
        return newArrayListWithExpectedSize;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0062, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x006c;
     */
    @CanIgnoreReturnValue
    public final int add(E e, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e);
        if (i == 0) {
            return count(e);
        }
        CollectPreconditions.checkPositive(i, "occurences");
        do {
            atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e);
            if (atomicInteger != null || (atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(i))) != null) {
                while (true) {
                    int i2 = atomicInteger.get();
                    if (i2 == 0) {
                        break;
                    }
                    try {
                        if (atomicInteger.compareAndSet(i2, IntMath.checkedAdd(i2, i))) {
                            return i2;
                        }
                    } catch (ArithmeticException unused) {
                        throw new IllegalArgumentException("Overflow adding " + i + " occurrences to a count of " + i2);
                    }
                }
            } else {
                return 0;
            }
        } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @CanIgnoreReturnValue
    public final int remove(Object obj, int i) {
        int i2;
        int max;
        if (i == 0) {
            return count(obj);
        }
        CollectPreconditions.checkPositive(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return 0;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 == 0) {
                return 0;
            }
            max = Math.max(0, i2 - i);
        } while (!atomicInteger.compareAndSet(i2, max));
        if (max == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public final boolean removeExactly(Object obj, int i) {
        int i2;
        int i3;
        if (i == 0) {
            return true;
        }
        CollectPreconditions.checkPositive(i, "occurences");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, obj);
        if (atomicInteger == null) {
            return false;
        }
        do {
            i2 = atomicInteger.get();
            if (i2 < i) {
                return false;
            }
            i3 = i2 - i;
        } while (!atomicInteger.compareAndSet(i2, i3));
        if (i3 == 0) {
            this.countMap.remove(obj, atomicInteger);
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002c, code lost:
        if (r6 != 0) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002f, code lost:
        r2 = new java.util.concurrent.atomic.AtomicInteger(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003a, code lost:
        if (r4.countMap.putIfAbsent(r5, r2) == null) goto L_0x0044;
     */
    @CanIgnoreReturnValue
    public final int setCount(E e, int i) {
        AtomicInteger atomicInteger;
        AtomicInteger atomicInteger2;
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(i, "count");
        do {
            atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e);
            if (atomicInteger == null && (i == 0 || (atomicInteger = this.countMap.putIfAbsent(e, new AtomicInteger(i))) == null)) {
                return 0;
            }
            while (true) {
                int i2 = atomicInteger.get();
                if (i2 == 0) {
                    break;
                } else if (atomicInteger.compareAndSet(i2, i)) {
                    if (i == 0) {
                        this.countMap.remove(e, atomicInteger);
                    }
                    return i2;
                }
            }
        } while (!this.countMap.replace(e, atomicInteger, atomicInteger2));
        return 0;
    }

    @CanIgnoreReturnValue
    public final boolean setCount(E e, int i, int i2) {
        Preconditions.checkNotNull(e);
        CollectPreconditions.checkNonnegative(i, "oldCount");
        CollectPreconditions.checkNonnegative(i2, "newCount");
        AtomicInteger atomicInteger = (AtomicInteger) Maps.safeGet(this.countMap, e);
        if (atomicInteger != null) {
            int i3 = atomicInteger.get();
            if (i3 == i) {
                if (i3 == 0) {
                    if (i2 == 0) {
                        this.countMap.remove(e, atomicInteger);
                        return true;
                    }
                    AtomicInteger atomicInteger2 = new AtomicInteger(i2);
                    return this.countMap.putIfAbsent(e, atomicInteger2) == null || this.countMap.replace(e, atomicInteger, atomicInteger2);
                } else if (atomicInteger.compareAndSet(i3, i2)) {
                    if (i2 == 0) {
                        this.countMap.remove(e, atomicInteger);
                    }
                    return true;
                }
            }
            return false;
        } else if (i != 0) {
            return false;
        } else {
            return i2 == 0 || this.countMap.putIfAbsent(e, new AtomicInteger(i2)) == null;
        }
    }

    /* access modifiers changed from: package-private */
    public final Set<E> createElementSet() {
        final Set<E> keySet = this.countMap.keySet();
        return new ForwardingSet<E>() {
            /* class com.google.common.collect.ConcurrentHashMultiset.AnonymousClass1 */

            /* access modifiers changed from: protected */
            public Set<E> delegate() {
                return keySet;
            }

            public boolean contains(Object obj) {
                return obj != null && Collections2.safeContains(keySet, obj);
            }

            public boolean containsAll(Collection<?> collection) {
                return standardContainsAll(collection);
            }

            public boolean remove(Object obj) {
                return obj != null && Collections2.safeRemove(keySet, obj);
            }

            public boolean removeAll(Collection<?> collection) {
                return standardRemoveAll(collection);
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Iterator<E> elementIterator() {
        throw new AssertionError("should never be called");
    }

    @Deprecated
    public final Set<Multiset.Entry<E>> createEntrySet() {
        return new EntrySet();
    }

    /* access modifiers changed from: package-private */
    public final int distinctElements() {
        return this.countMap.size();
    }

    public final boolean isEmpty() {
        return this.countMap.isEmpty();
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        final AnonymousClass2 r0 = new AbstractIterator<Multiset.Entry<E>>() {
            /* class com.google.common.collect.ConcurrentHashMultiset.AnonymousClass2 */
            private final Iterator<Map.Entry<E, AtomicInteger>> mapEntries = ConcurrentHashMultiset.this.countMap.entrySet().iterator();

            /* access modifiers changed from: protected */
            public Multiset.Entry<E> computeNext() {
                while (this.mapEntries.hasNext()) {
                    Map.Entry next = this.mapEntries.next();
                    int i = ((AtomicInteger) next.getValue()).get();
                    if (i != 0) {
                        return Multisets.immutableEntry(next.getKey(), i);
                    }
                }
                return (Multiset.Entry) endOfData();
            }
        };
        return new ForwardingIterator<Multiset.Entry<E>>() {
            /* class com.google.common.collect.ConcurrentHashMultiset.AnonymousClass3 */
            private Multiset.Entry<E> last;

            /* access modifiers changed from: protected */
            public Iterator<Multiset.Entry<E>> delegate() {
                return r0;
            }

            public Multiset.Entry<E> next() {
                this.last = (Multiset.Entry) super.next();
                return this.last;
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.last != null);
                ConcurrentHashMultiset.this.setCount(this.last.getElement(), 0);
                this.last = null;
            }
        };
    }

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public final void clear() {
        this.countMap.clear();
    }

    class EntrySet extends AbstractMultiset<E>.EntrySet {
        private EntrySet() {
            super();
        }

        /* access modifiers changed from: package-private */
        public ConcurrentHashMultiset<E> multiset() {
            return ConcurrentHashMultiset.this;
        }

        public Object[] toArray() {
            return snapshot().toArray();
        }

        public <T> T[] toArray(T[] tArr) {
            return snapshot().toArray(tArr);
        }

        private List<Multiset.Entry<E>> snapshot() {
            ArrayList newArrayListWithExpectedSize = Lists.newArrayListWithExpectedSize(size());
            Iterators.addAll(newArrayListWithExpectedSize, iterator());
            return newArrayListWithExpectedSize;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.countMap);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void
     arg types: [com.google.common.collect.ConcurrentHashMultiset, java.util.concurrent.ConcurrentMap]
     candidates:
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, int):void
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void */
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        FieldSettersHolder.COUNT_MAP_FIELD_SETTER.set((ImmutableMultimap) this, (Object) ((ConcurrentMap) objectInputStream.readObject()));
    }
}
