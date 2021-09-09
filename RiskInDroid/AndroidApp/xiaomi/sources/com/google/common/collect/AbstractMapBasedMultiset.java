package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
abstract class AbstractMapBasedMultiset<E> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = -2250766705698539974L;
    public transient Map<E, Count> backingMap;
    public transient long size;

    protected AbstractMapBasedMultiset(Map<E, Count> map) {
        Preconditions.checkArgument(map.isEmpty());
        this.backingMap = map;
    }

    /* access modifiers changed from: package-private */
    public void setBackingMap(Map<E, Count> map) {
        this.backingMap = map;
    }

    public Set<Multiset.Entry<E>> entrySet() {
        return super.entrySet();
    }

    /* access modifiers changed from: package-private */
    public Iterator<E> elementIterator() {
        final Iterator<Map.Entry<E, Count>> it = this.backingMap.entrySet().iterator();
        return new Iterator<E>() {
            /* class com.google.common.collect.AbstractMapBasedMultiset.AnonymousClass1 */
            Map.Entry<E, Count> toRemove;

            public boolean hasNext() {
                return it.hasNext();
            }

            public E next() {
                Map.Entry<E, Count> entry = (Map.Entry) it.next();
                this.toRemove = entry;
                return entry.getKey();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset.this.size -= (long) this.toRemove.getValue().getAndSet(0);
                it.remove();
                this.toRemove = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public Iterator<Multiset.Entry<E>> entryIterator() {
        final Iterator<Map.Entry<E, Count>> it = this.backingMap.entrySet().iterator();
        return new Iterator<Multiset.Entry<E>>() {
            /* class com.google.common.collect.AbstractMapBasedMultiset.AnonymousClass2 */
            Map.Entry<E, Count> toRemove;

            public boolean hasNext() {
                return it.hasNext();
            }

            public Multiset.Entry<E> next() {
                final Map.Entry<E, Count> entry = (Map.Entry) it.next();
                this.toRemove = entry;
                return new Multisets.AbstractEntry<E>() {
                    /* class com.google.common.collect.AbstractMapBasedMultiset.AnonymousClass2.AnonymousClass1 */

                    public E getElement() {
                        return entry.getKey();
                    }

                    public int getCount() {
                        Count count;
                        Count count2 = (Count) entry.getValue();
                        if ((count2 == null || count2.get() == 0) && (count = AbstractMapBasedMultiset.this.backingMap.get(getElement())) != null) {
                            return count.get();
                        }
                        if (count2 == null) {
                            return 0;
                        }
                        return count2.get();
                    }
                };
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                AbstractMapBasedMultiset.this.size -= (long) this.toRemove.getValue().getAndSet(0);
                it.remove();
                this.toRemove = null;
            }
        };
    }

    public void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Preconditions.checkNotNull(objIntConsumer);
        this.backingMap.forEach(new BiConsumer(objIntConsumer) {
            /* class com.google.common.collect.$$Lambda$AbstractMapBasedMultiset$m2yDvYDYgczp8OZsVZqPAKIDCQ */
            private final /* synthetic */ ObjIntConsumer f$0;

            {
                this.f$0 = r1;
            }

            public final void accept(Object obj, Object obj2) {
                this.f$0.accept(obj, ((Count) obj2).get());
            }
        });
    }

    public void clear() {
        for (Count count : this.backingMap.values()) {
            count.set(0);
        }
        this.backingMap.clear();
        this.size = 0;
    }

    /* access modifiers changed from: package-private */
    public int distinctElements() {
        return this.backingMap.size();
    }

    public int size() {
        return Ints.saturatedCast(this.size);
    }

    public Iterator<E> iterator() {
        return new MapBasedMultisetIterator();
    }

    class MapBasedMultisetIterator implements Iterator<E> {
        boolean canRemove;
        Map.Entry<E, Count> currentEntry;
        final Iterator<Map.Entry<E, Count>> entryIterator;
        int occurrencesLeft;

        MapBasedMultisetIterator() {
            this.entryIterator = AbstractMapBasedMultiset.this.backingMap.entrySet().iterator();
        }

        public boolean hasNext() {
            return this.occurrencesLeft > 0 || this.entryIterator.hasNext();
        }

        public E next() {
            if (this.occurrencesLeft == 0) {
                this.currentEntry = this.entryIterator.next();
                this.occurrencesLeft = this.currentEntry.getValue().get();
            }
            this.occurrencesLeft--;
            this.canRemove = true;
            return this.currentEntry.getKey();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            if (this.currentEntry.getValue().get() > 0) {
                if (this.currentEntry.getValue().addAndGet(-1) == 0) {
                    this.entryIterator.remove();
                }
                AbstractMapBasedMultiset.this.size--;
                this.canRemove = false;
                return;
            }
            throw new ConcurrentModificationException();
        }
    }

    public int count(Object obj) {
        Count count = (Count) Maps.safeGet(this.backingMap, obj);
        if (count == null) {
            return 0;
        }
        return count.get();
    }

    @CanIgnoreReturnValue
    public int add(E e, int i) {
        int i2;
        if (i == 0) {
            return count(e);
        }
        boolean z = true;
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.backingMap.get(e);
        if (count == null) {
            this.backingMap.put(e, new Count(i));
            i2 = 0;
        } else {
            i2 = count.get();
            long j = ((long) i2) + ((long) i);
            if (j > 2147483647L) {
                z = false;
            }
            Preconditions.checkArgument(z, "too many occurrences: %s", j);
            count.add(i);
        }
        this.size += (long) i;
        return i2;
    }

    @CanIgnoreReturnValue
    public int remove(Object obj, int i) {
        if (i == 0) {
            return count(obj);
        }
        Preconditions.checkArgument(i > 0, "occurrences cannot be negative: %s", i);
        Count count = this.backingMap.get(obj);
        if (count == null) {
            return 0;
        }
        int i2 = count.get();
        if (i2 <= i) {
            this.backingMap.remove(obj);
            i = i2;
        }
        count.add(-i);
        this.size -= (long) i;
        return i2;
    }

    @CanIgnoreReturnValue
    public int setCount(E e, int i) {
        int i2;
        CollectPreconditions.checkNonnegative(i, "count");
        if (i == 0) {
            i2 = getAndSet(this.backingMap.remove(e), i);
        } else {
            Count count = this.backingMap.get(e);
            int andSet = getAndSet(count, i);
            if (count == null) {
                this.backingMap.put(e, new Count(i));
            }
            i2 = andSet;
        }
        this.size += (long) (i - i2);
        return i2;
    }

    private static int getAndSet(Count count, int i) {
        if (count == null) {
            return 0;
        }
        return count.getAndSet(i);
    }

    @GwtIncompatible
    private void readObjectNoData() throws ObjectStreamException {
        throw new InvalidObjectException("Stream data required");
    }
}
