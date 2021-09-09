package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.SortedLists;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collector;

@GwtIncompatible
@Beta
public class ImmutableRangeMap<K extends Comparable<?>, V> implements RangeMap<K, V>, Serializable {
    private static final ImmutableRangeMap<Comparable<?>, Object> EMPTY = new ImmutableRangeMap<>(ImmutableList.of(), ImmutableList.of());
    private static final long serialVersionUID = 0;
    public final transient ImmutableList<Range<K>> ranges;
    private final transient ImmutableList<V> values;

    @Beta
    public static <T, K extends Comparable<? super K>, V> Collector<T, ?, ImmutableRangeMap<K, V>> toImmutableRangeMap(Function<? super T, Range<K>> function, Function<? super T, ? extends V> function2) {
        return CollectCollectors.toImmutableRangeMap(function, function2);
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of() {
        return EMPTY;
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> of(Range<K> range, V v) {
        return new ImmutableRangeMap<>(ImmutableList.of(range), ImmutableList.of(v));
    }

    public static <K extends Comparable<?>, V> ImmutableRangeMap<K, V> copyOf(RangeMap<K, ? extends V> rangeMap) {
        if (rangeMap instanceof ImmutableRangeMap) {
            return (ImmutableRangeMap) rangeMap;
        }
        Map<Range<K>, ? extends V> asMapOfRanges = rangeMap.asMapOfRanges();
        ImmutableList.Builder builder = new ImmutableList.Builder(asMapOfRanges.size());
        ImmutableList.Builder builder2 = new ImmutableList.Builder(asMapOfRanges.size());
        for (Map.Entry next : asMapOfRanges.entrySet()) {
            builder.add(next.getKey());
            builder2.add(next.getValue());
        }
        return new ImmutableRangeMap<>(builder.build(), builder2.build());
    }

    public static <K extends Comparable<?>, V> Builder<K, V> builder() {
        return new Builder<>();
    }

    public static final class Builder<K extends Comparable<?>, V> {
        private final List<Map.Entry<Range<K>, V>> entries = Lists.newArrayList();

        @CanIgnoreReturnValue
        public final Builder<K, V> put(Range<K> range, V v) {
            Preconditions.checkNotNull(range);
            Preconditions.checkNotNull(v);
            Preconditions.checkArgument(!range.isEmpty(), "Range must not be empty, but was %s", range);
            this.entries.add(Maps.immutableEntry(range, v));
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<K, V> putAll(RangeMap<K, ? extends V> rangeMap) {
            for (Map.Entry next : rangeMap.asMapOfRanges().entrySet()) {
                put((Range) next.getKey(), next.getValue());
            }
            return this;
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public final Builder<K, V> combine(Builder<K, V> builder) {
            this.entries.addAll(builder.entries);
            return this;
        }

        public final ImmutableRangeMap<K, V> build() {
            Collections.sort(this.entries, Range.rangeLexOrdering().onKeys());
            ImmutableList.Builder builder = new ImmutableList.Builder(this.entries.size());
            ImmutableList.Builder builder2 = new ImmutableList.Builder(this.entries.size());
            for (int i = 0; i < this.entries.size(); i++) {
                Range range = (Range) this.entries.get(i).getKey();
                if (i > 0) {
                    Range range2 = (Range) this.entries.get(i - 1).getKey();
                    if (range.isConnected(range2) && !range.intersection(range2).isEmpty()) {
                        throw new IllegalArgumentException("Overlapping ranges: range " + range2 + " overlaps with entry " + range);
                    }
                }
                builder.add((Object) range);
                builder2.add(this.entries.get(i).getValue());
            }
            return new ImmutableRangeMap<>(builder.build(), builder2.build());
        }
    }

    ImmutableRangeMap(ImmutableList<Range<K>> immutableList, ImmutableList<V> immutableList2) {
        this.ranges = immutableList;
        this.values = immutableList2;
    }

    public V get(K k) {
        int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch != -1 && this.ranges.get(binarySearch).contains(k)) {
            return this.values.get(binarySearch);
        }
        return null;
    }

    public Map.Entry<Range<K>, V> getEntry(K k) {
        int binarySearch = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), Cut.belowValue(k), SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_LOWER);
        if (binarySearch == -1) {
            return null;
        }
        Range range = this.ranges.get(binarySearch);
        if (range.contains(k)) {
            return Maps.immutableEntry(range, this.values.get(binarySearch));
        }
        return null;
    }

    public Range<K> span() {
        if (!this.ranges.isEmpty()) {
            ImmutableList<Range<K>> immutableList = this.ranges;
            return Range.create(this.ranges.get(0).lowerBound, immutableList.get(immutableList.size() - 1).upperBound);
        }
        throw new NoSuchElementException();
    }

    @Deprecated
    public void put(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putCoalescing(Range<K> range, V v) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void putAll(RangeMap<K, V> rangeMap) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public void remove(Range<K> range) {
        throw new UnsupportedOperationException();
    }

    public ImmutableMap<Range<K>, V> asMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges, Range.rangeLexOrdering()), this.values);
    }

    public ImmutableMap<Range<K>, V> asDescendingMapOfRanges() {
        if (this.ranges.isEmpty()) {
            return ImmutableMap.of();
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(this.ranges.reverse(), Range.rangeLexOrdering().reverse()), this.values.reverse());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E>
     arg types: [int, int]
     candidates:
      com.google.common.collect.ImmutableList.subList(int, int):java.util.List
      ClspMth{java.util.List.subList(int, int):java.util.List<E>}
      com.google.common.collect.ImmutableList.subList(int, int):com.google.common.collect.ImmutableList<E> */
    public ImmutableRangeMap<K, V> subRangeMap(final Range<K> range) {
        if (((Range) Preconditions.checkNotNull(range)).isEmpty()) {
            return of();
        }
        if (this.ranges.isEmpty() || range.encloses(span())) {
            return this;
        }
        final int binarySearch = SortedLists.binarySearch(this.ranges, Range.upperBoundFn(), range.lowerBound, SortedLists.KeyPresentBehavior.FIRST_AFTER, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        int binarySearch2 = SortedLists.binarySearch(this.ranges, Range.lowerBoundFn(), range.upperBound, SortedLists.KeyPresentBehavior.ANY_PRESENT, SortedLists.KeyAbsentBehavior.NEXT_HIGHER);
        if (binarySearch >= binarySearch2) {
            return of();
        }
        final int i = binarySearch2 - binarySearch;
        final Range<K> range2 = range;
        return new ImmutableRangeMap<K, V>(new ImmutableList<Range<K>>() {
            /* class com.google.common.collect.ImmutableRangeMap.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public boolean isPartialView() {
                return true;
            }

            public int size() {
                return i;
            }

            public Range<K> get(int i) {
                Preconditions.checkElementIndex(i, i);
                if (i == 0 || i == i - 1) {
                    return ImmutableRangeMap.this.ranges.get(i + binarySearch).intersection(range);
                }
                return ImmutableRangeMap.this.ranges.get(i + binarySearch);
            }
        }, this.values.subList(binarySearch, binarySearch2)) {
            /* class com.google.common.collect.ImmutableRangeMap.AnonymousClass2 */

            public /* bridge */ /* synthetic */ Map asDescendingMapOfRanges() {
                return ImmutableRangeMap.super.asDescendingMapOfRanges();
            }

            public /* bridge */ /* synthetic */ Map asMapOfRanges() {
                return ImmutableRangeMap.super.asMapOfRanges();
            }

            public ImmutableRangeMap<K, V> subRangeMap(Range<K> range) {
                if (range2.isConnected(range)) {
                    return this.subRangeMap((Range) range.intersection(range2));
                }
                return ImmutableRangeMap.of();
            }
        };
    }

    public int hashCode() {
        return asMapOfRanges().hashCode();
    }

    public boolean equals(Object obj) {
        if (obj instanceof RangeMap) {
            return asMapOfRanges().equals(((RangeMap) obj).asMapOfRanges());
        }
        return false;
    }

    public String toString() {
        return asMapOfRanges().toString();
    }

    static class SerializedForm<K extends Comparable<?>, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final ImmutableMap<Range<K>, V> mapOfRanges;

        SerializedForm(ImmutableMap<Range<K>, V> immutableMap) {
            this.mapOfRanges = immutableMap;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            if (this.mapOfRanges.isEmpty()) {
                return ImmutableRangeMap.of();
            }
            return createRangeMap();
        }

        /* access modifiers changed from: package-private */
        public Object createRangeMap() {
            Builder builder = new Builder();
            UnmodifiableIterator<Map.Entry<Range<K>, V>> it = this.mapOfRanges.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry next = it.next();
                builder.put((Range) next.getKey(), next.getValue());
            }
            return builder.build();
        }
    }

    /* access modifiers changed from: package-private */
    public Object writeReplace() {
        return new SerializedForm(asMapOfRanges());
    }
}
