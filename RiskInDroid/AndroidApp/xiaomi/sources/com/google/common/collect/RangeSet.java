package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.lang.Comparable;
import java.util.Iterator;
import java.util.Set;

@GwtIncompatible
@Beta
public interface RangeSet<C extends Comparable> {
    void add(Range<C> range);

    void addAll(RangeSet rangeSet);

    void addAll(Iterable<Range<C>> iterable);

    Set<Range<C>> asDescendingSetOfRanges();

    Set<Range<C>> asRanges();

    void clear();

    RangeSet<C> complement();

    boolean contains(C c);

    boolean encloses(Range<C> range);

    boolean enclosesAll(RangeSet rangeSet);

    boolean enclosesAll(Iterable iterable);

    boolean equals(Object obj);

    int hashCode();

    boolean intersects(Range<C> range);

    boolean isEmpty();

    Range<C> rangeContaining(C c);

    void remove(Range<C> range);

    void removeAll(RangeSet rangeSet);

    void removeAll(Iterable iterable);

    Range<C> span();

    RangeSet<C> subRangeSet(Range range);

    String toString();

    /* renamed from: com.google.common.collect.RangeSet$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$enclosesAll(RangeSet _this, Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                if (!_this.encloses((Range) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public static void $default$addAll(RangeSet _this, Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                _this.add((Range) it.next());
            }
        }

        public static void $default$removeAll(RangeSet _this, Iterable iterable) {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                _this.remove((Range) it.next());
            }
        }
    }
}
