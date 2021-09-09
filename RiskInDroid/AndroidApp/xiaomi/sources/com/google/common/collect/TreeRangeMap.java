package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Maps;
import java.lang.Comparable;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NoSuchElementException;
import java.util.Set;

@GwtIncompatible
@Beta
public final class TreeRangeMap<K extends Comparable, V> implements RangeMap<K, V> {
    private static final RangeMap EMPTY_SUB_RANGE_MAP = new RangeMap() {
        /* class com.google.common.collect.TreeRangeMap.AnonymousClass1 */

        public final void clear() {
        }

        public final Object get(Comparable comparable) {
            return null;
        }

        public final Map.Entry<Range, Object> getEntry(Comparable comparable) {
            return null;
        }

        public final Range span() {
            throw new NoSuchElementException();
        }

        public final void put(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public final void putCoalescing(Range range, Object obj) {
            Preconditions.checkNotNull(range);
            throw new IllegalArgumentException("Cannot insert range " + range + " into an empty subRangeMap");
        }

        public final void putAll(RangeMap rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                throw new IllegalArgumentException("Cannot putAll(nonEmptyRangeMap) into an empty subRangeMap");
            }
        }

        public final void remove(Range range) {
            Preconditions.checkNotNull(range);
        }

        public final Map<Range, Object> asMapOfRanges() {
            return Collections.emptyMap();
        }

        public final Map<Range, Object> asDescendingMapOfRanges() {
            return Collections.emptyMap();
        }

        public final RangeMap subRangeMap(Range range) {
            Preconditions.checkNotNull(range);
            return this;
        }
    };
    public final NavigableMap<Cut<K>, RangeMapEntry<K, V>> entriesByLowerBound = Maps.newTreeMap();

    public static <K extends Comparable, V> TreeRangeMap<K, V> create() {
        return new TreeRangeMap<>();
    }

    private TreeRangeMap() {
    }

    static final class RangeMapEntry<K extends Comparable, V> extends AbstractMapEntry<Range<K>, V> {
        private final Range<K> range;
        private final V value;

        RangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
            this(Range.create(cut, cut2), v);
        }

        RangeMapEntry(Range<K> range2, V v) {
            this.range = range2;
            this.value = v;
        }

        public final Range<K> getKey() {
            return this.range;
        }

        public final V getValue() {
            return this.value;
        }

        public final boolean contains(K k) {
            return this.range.contains(k);
        }

        /* access modifiers changed from: package-private */
        public final Cut<K> getLowerBound() {
            return this.range.lowerBound;
        }

        /* access modifiers changed from: package-private */
        public final Cut<K> getUpperBound() {
            return this.range.upperBound;
        }
    }

    public final V get(K k) {
        Map.Entry entry = getEntry(k);
        if (entry == null) {
            return null;
        }
        return entry.getValue();
    }

    public final Map.Entry<Range<K>, V> getEntry(K k) {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> floorEntry = this.entriesByLowerBound.floorEntry(Cut.belowValue(k));
        if (floorEntry == null || !floorEntry.getValue().contains(k)) {
            return null;
        }
        return floorEntry.getValue();
    }

    public final void put(Range<K> range, V v) {
        if (!range.isEmpty()) {
            Preconditions.checkNotNull(v);
            remove(range);
            this.entriesByLowerBound.put(range.lowerBound, new RangeMapEntry(range, v));
        }
    }

    public final void putCoalescing(Range<K> range, V v) {
        if (this.entriesByLowerBound.isEmpty()) {
            put(range, v);
        } else {
            put(coalescedRange(range, Preconditions.checkNotNull(v)), v);
        }
    }

    public final Range<K> coalescedRange(Range<K> range, V v) {
        return coalesce(coalesce(range, v, this.entriesByLowerBound.lowerEntry(range.lowerBound)), v, this.entriesByLowerBound.floorEntry(range.upperBound));
    }

    private static <K extends Comparable, V> Range<K> coalesce(Range<K> range, V v, Map.Entry<Cut<K>, RangeMapEntry<K, V>> entry) {
        return (entry == null || !entry.getValue().getKey().isConnected(range) || !entry.getValue().getValue().equals(v)) ? range : range.span(entry.getValue().getKey());
    }

    public final void putAll(RangeMap<K, V> rangeMap) {
        for (Map.Entry next : rangeMap.asMapOfRanges().entrySet()) {
            put((Range) next.getKey(), next.getValue());
        }
    }

    public final void clear() {
        this.entriesByLowerBound.clear();
    }

    public final Range<K> span() {
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> firstEntry = this.entriesByLowerBound.firstEntry();
        Map.Entry<Cut<K>, RangeMapEntry<K, V>> lastEntry = this.entriesByLowerBound.lastEntry();
        if (firstEntry != null) {
            return Range.create(firstEntry.getValue().getKey().lowerBound, lastEntry.getValue().getKey().upperBound);
        }
        throw new NoSuchElementException();
    }

    private void putRangeMapEntry(Cut<K> cut, Cut<K> cut2, V v) {
        this.entriesByLowerBound.put(cut, new RangeMapEntry(cut, cut2, v));
    }

    public final void remove(Range<K> range) {
        if (!range.isEmpty()) {
            Map.Entry<K, V> lowerEntry = this.entriesByLowerBound.lowerEntry(range.lowerBound);
            if (lowerEntry != null) {
                RangeMapEntry rangeMapEntry = (RangeMapEntry) lowerEntry.getValue();
                if (rangeMapEntry.getUpperBound().compareTo((Cut) range.lowerBound) > 0) {
                    if (rangeMapEntry.getUpperBound().compareTo((Cut) range.upperBound) > 0) {
                        putRangeMapEntry(range.upperBound, rangeMapEntry.getUpperBound(), ((RangeMapEntry) lowerEntry.getValue()).getValue());
                    }
                    putRangeMapEntry(rangeMapEntry.getLowerBound(), range.lowerBound, ((RangeMapEntry) lowerEntry.getValue()).getValue());
                }
            }
            Map.Entry<K, V> lowerEntry2 = this.entriesByLowerBound.lowerEntry(range.upperBound);
            if (lowerEntry2 != null) {
                RangeMapEntry rangeMapEntry2 = (RangeMapEntry) lowerEntry2.getValue();
                if (rangeMapEntry2.getUpperBound().compareTo((Cut) range.upperBound) > 0) {
                    putRangeMapEntry(range.upperBound, rangeMapEntry2.getUpperBound(), ((RangeMapEntry) lowerEntry2.getValue()).getValue());
                }
            }
            this.entriesByLowerBound.subMap(range.lowerBound, range.upperBound).clear();
        }
    }

    public final Map<Range<K>, V> asMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.values());
    }

    public final Map<Range<K>, V> asDescendingMapOfRanges() {
        return new AsMapOfRanges(this.entriesByLowerBound.descendingMap().values());
    }

    final class AsMapOfRanges extends Maps.IteratorBasedAbstractMap<Range<K>, V> {
        final Iterable<Map.Entry<Range<K>, V>> entryIterable;

        AsMapOfRanges(Iterable<RangeMapEntry<K, V>> iterable) {
            this.entryIterable = iterable;
        }

        public final boolean containsKey(Object obj) {
            return get(obj) != null;
        }

        public final V get(Object obj) {
            if (!(obj instanceof Range)) {
                return null;
            }
            Range range = (Range) obj;
            RangeMapEntry rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
            if (rangeMapEntry == null || !rangeMapEntry.getKey().equals(range)) {
                return null;
            }
            return rangeMapEntry.getValue();
        }

        public final int size() {
            return TreeRangeMap.this.entriesByLowerBound.size();
        }

        /* access modifiers changed from: package-private */
        public final Iterator<Map.Entry<Range<K>, V>> entryIterator() {
            return this.entryIterable.iterator();
        }
    }

    public final RangeMap<K, V> subRangeMap(Range<K> range) {
        if (range.equals(Range.all())) {
            return this;
        }
        return new SubRangeMap(range);
    }

    public final RangeMap<K, V> emptySubRangeMap() {
        return EMPTY_SUB_RANGE_MAP;
    }

    class SubRangeMap implements RangeMap<K, V> {
        public final Range<K> subRange;

        SubRangeMap(Range<K> range) {
            this.subRange = range;
        }

        public V get(K k) {
            if (this.subRange.contains(k)) {
                return TreeRangeMap.this.get(k);
            }
            return null;
        }

        public Map.Entry<Range<K>, V> getEntry(K k) {
            Map.Entry entry;
            if (!this.subRange.contains(k) || (entry = TreeRangeMap.this.getEntry(k)) == null) {
                return null;
            }
            return Maps.immutableEntry(((Range) entry.getKey()).intersection(this.subRange), entry.getValue());
        }

        public Range<K> span() {
            Cut cut;
            Object obj;
            Map.Entry<K, V> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(this.subRange.lowerBound);
            if (floorEntry == null || floorEntry.getValue().getUpperBound().compareTo((Cut) this.subRange.lowerBound) <= 0) {
                cut = TreeRangeMap.this.entriesByLowerBound.ceilingKey(this.subRange.lowerBound);
                if (cut == null || cut.compareTo((Cut) this.subRange.upperBound) >= 0) {
                    throw new NoSuchElementException();
                }
            } else {
                cut = this.subRange.lowerBound;
            }
            Map.Entry<K, V> lowerEntry = TreeRangeMap.this.entriesByLowerBound.lowerEntry(this.subRange.upperBound);
            if (lowerEntry != null) {
                if (lowerEntry.getValue().getUpperBound().compareTo((Cut) this.subRange.upperBound) >= 0) {
                    obj = this.subRange.upperBound;
                } else {
                    obj = lowerEntry.getValue().getUpperBound();
                }
                return Range.create(cut, obj);
            }
            throw new NoSuchElementException();
        }

        public void put(Range<K> range, V v) {
            Preconditions.checkArgument(this.subRange.encloses(range), "Cannot put range %s into a subRangeMap(%s)", range, this.subRange);
            TreeRangeMap.this.put(range, v);
        }

        public void putCoalescing(Range<K> range, V v) {
            if (TreeRangeMap.this.entriesByLowerBound.isEmpty() || range.isEmpty() || !this.subRange.encloses(range)) {
                put(range, v);
            } else {
                put(TreeRangeMap.this.coalescedRange(range, Preconditions.checkNotNull(v)).intersection(this.subRange), v);
            }
        }

        public void putAll(RangeMap<K, V> rangeMap) {
            if (!rangeMap.asMapOfRanges().isEmpty()) {
                Range<K> span = rangeMap.span();
                Preconditions.checkArgument(this.subRange.encloses(span), "Cannot putAll rangeMap with span %s into a subRangeMap(%s)", span, this.subRange);
                TreeRangeMap.this.putAll(rangeMap);
            }
        }

        public void clear() {
            TreeRangeMap.this.remove(this.subRange);
        }

        public void remove(Range<K> range) {
            if (range.isConnected(this.subRange)) {
                TreeRangeMap.this.remove(range.intersection(this.subRange));
            }
        }

        public RangeMap<K, V> subRangeMap(Range<K> range) {
            if (!range.isConnected(this.subRange)) {
                return TreeRangeMap.this.emptySubRangeMap();
            }
            return TreeRangeMap.this.subRangeMap(range.intersection(this.subRange));
        }

        public Map<Range<K>, V> asMapOfRanges() {
            return new SubRangeMapAsMap();
        }

        /* JADX WARN: Type inference failed for: r0v0, types: [java.util.Map<com.google.common.collect.Range<K>, V>, com.google.common.collect.TreeRangeMap$SubRangeMap$1] */
        public Map<Range<K>, V> asDescendingMapOfRanges() {
            return new TreeRangeMap<K, V>.SubRangeMap.SubRangeMapAsMap() {
                /* class com.google.common.collect.TreeRangeMap.SubRangeMap.AnonymousClass1 */

                /* access modifiers changed from: package-private */
                public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                    if (SubRangeMap.this.subRange.isEmpty()) {
                        return Iterators.emptyIterator();
                    }
                    final Iterator<V> it = TreeRangeMap.this.entriesByLowerBound.headMap(SubRangeMap.this.subRange.upperBound, false).descendingMap().values().iterator();
                    return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                        /* class com.google.common.collect.TreeRangeMap.SubRangeMap.AnonymousClass1.AnonymousClass1 */

                        /* access modifiers changed from: protected */
                        public Map.Entry<Range<K>, V> computeNext() {
                            if (!it.hasNext()) {
                                return (Map.Entry) endOfData();
                            }
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                            if (rangeMapEntry.getUpperBound().compareTo((Cut) SubRangeMap.this.subRange.lowerBound) <= 0) {
                                return (Map.Entry) endOfData();
                            }
                            return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                        }
                    };
                }
            };
        }

        public boolean equals(Object obj) {
            if (obj instanceof RangeMap) {
                return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
            }
            return false;
        }

        public int hashCode() {
            return asMapOfRanges().hashCode();
        }

        public String toString() {
            return asMapOfRanges().toString();
        }

        class SubRangeMapAsMap extends AbstractMap<Range<K>, V> {
            SubRangeMapAsMap() {
            }

            public boolean containsKey(Object obj) {
                return get(obj) != null;
            }

            public V get(Object obj) {
                RangeMapEntry rangeMapEntry;
                try {
                    if (obj instanceof Range) {
                        Range range = (Range) obj;
                        if (SubRangeMap.this.subRange.encloses(range)) {
                            if (!range.isEmpty()) {
                                if (range.lowerBound.compareTo((Cut) SubRangeMap.this.subRange.lowerBound) == 0) {
                                    Map.Entry<K, V> floorEntry = TreeRangeMap.this.entriesByLowerBound.floorEntry(range.lowerBound);
                                    rangeMapEntry = floorEntry != null ? (RangeMapEntry) floorEntry.getValue() : null;
                                } else {
                                    rangeMapEntry = (RangeMapEntry) TreeRangeMap.this.entriesByLowerBound.get(range.lowerBound);
                                }
                                if (rangeMapEntry != null && rangeMapEntry.getKey().isConnected(SubRangeMap.this.subRange) && rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange).equals(range)) {
                                    return rangeMapEntry.getValue();
                                }
                            }
                        }
                    }
                } catch (ClassCastException unused) {
                }
                return null;
            }

            public V remove(Object obj) {
                V v = get(obj);
                if (v == null) {
                    return null;
                }
                TreeRangeMap.this.remove((Range) obj);
                return v;
            }

            public void clear() {
                SubRangeMap.this.clear();
            }

            public boolean removeEntryIf(Predicate<? super Map.Entry<Range<K>, V>> predicate) {
                ArrayList<Range> newArrayList = Lists.newArrayList();
                for (Map.Entry entry : entrySet()) {
                    if (predicate.apply(entry)) {
                        newArrayList.add(entry.getKey());
                    }
                }
                for (Range remove : newArrayList) {
                    TreeRangeMap.this.remove(remove);
                }
                return !newArrayList.isEmpty();
            }

            public Set<Range<K>> keySet() {
                return new Maps.KeySet<Range<K>, V>(this) {
                    /* class com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass1 */

                    public boolean remove(Object obj) {
                        return SubRangeMapAsMap.this.remove(obj) != null;
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.keyFunction()));
                    }
                };
            }

            public Set<Map.Entry<Range<K>, V>> entrySet() {
                return new Maps.EntrySet<Range<K>, V>() {
                    /* class com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass2 */

                    /* access modifiers changed from: package-private */
                    public Map<Range<K>, V> map() {
                        return SubRangeMapAsMap.this;
                    }

                    public Iterator<Map.Entry<Range<K>, V>> iterator() {
                        return SubRangeMapAsMap.this.entryIterator();
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.not(Predicates.in(collection)));
                    }

                    public int size() {
                        return Iterators.size(iterator());
                    }

                    public boolean isEmpty() {
                        return !iterator().hasNext();
                    }
                };
            }

            /* access modifiers changed from: package-private */
            public Iterator<Map.Entry<Range<K>, V>> entryIterator() {
                if (SubRangeMap.this.subRange.isEmpty()) {
                    return Iterators.emptyIterator();
                }
                final Iterator<RangeMapEntry<K, V>> it = TreeRangeMap.this.entriesByLowerBound.tailMap((Cut) MoreObjects.firstNonNull(TreeRangeMap.this.entriesByLowerBound.floorKey(SubRangeMap.this.subRange.lowerBound), SubRangeMap.this.subRange.lowerBound), true).values().iterator();
                return new AbstractIterator<Map.Entry<Range<K>, V>>() {
                    /* class com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass3 */

                    /* access modifiers changed from: protected */
                    public Map.Entry<Range<K>, V> computeNext() {
                        while (it.hasNext()) {
                            RangeMapEntry rangeMapEntry = (RangeMapEntry) it.next();
                            if (rangeMapEntry.getLowerBound().compareTo((Cut) SubRangeMap.this.subRange.upperBound) >= 0) {
                                return (Map.Entry) endOfData();
                            }
                            if (rangeMapEntry.getUpperBound().compareTo((Cut) SubRangeMap.this.subRange.lowerBound) > 0) {
                                return Maps.immutableEntry(rangeMapEntry.getKey().intersection(SubRangeMap.this.subRange), rangeMapEntry.getValue());
                            }
                        }
                        return (Map.Entry) endOfData();
                    }
                };
            }

            public Collection<V> values() {
                return new Maps.Values<Range<K>, V>(this) {
                    /* class com.google.common.collect.TreeRangeMap.SubRangeMap.SubRangeMapAsMap.AnonymousClass4 */

                    public boolean removeAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.in(collection), Maps.valueFunction()));
                    }

                    public boolean retainAll(Collection<?> collection) {
                        return SubRangeMapAsMap.this.removeEntryIf(Predicates.compose(Predicates.not(Predicates.in(collection)), Maps.valueFunction()));
                    }
                };
            }
        }
    }

    public final boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public final int hashCode() {
        return asMapOfRanges().hashCode();
    }

    public final String toString() {
        return this.entriesByLowerBound.values().toString();
    }
}
