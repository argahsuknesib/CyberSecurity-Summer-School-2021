package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Collection;

@GwtCompatible(emulated = true)
final class RegularContiguousSet<C extends Comparable> extends ContiguousSet<C> {
    private static final long serialVersionUID = 0;
    private final Range<C> range;

    public final boolean isEmpty() {
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    RegularContiguousSet(Range<C> range2, DiscreteDomain<C> discreteDomain) {
        super(discreteDomain);
        this.range = range2;
    }

    private ContiguousSet<C> intersectionInCurrentDomain(Range<C> range2) {
        return this.range.isConnected(range2) ? ContiguousSet.create(this.range.intersection(range2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    /* access modifiers changed from: package-private */
    public final ContiguousSet<C> headSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.upTo(c, BoundType.forBoolean(z)));
    }

    /* access modifiers changed from: package-private */
    /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Not class type: C
        	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
        	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
        	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
        	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
        	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
        	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:77)
        	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
        */
    public final com.google.common.collect.ContiguousSet<C> subSetImpl(C r2, boolean r3, C r4, boolean r5) {
        /*
            r1 = this;
            int r0 = r2.compareTo(r4)
            if (r0 != 0) goto L_0x0012
            if (r3 != 0) goto L_0x0012
            if (r5 != 0) goto L_0x0012
            com.google.common.collect.EmptyContiguousSet r2 = new com.google.common.collect.EmptyContiguousSet
            com.google.common.collect.DiscreteDomain r3 = r1.domain
            r2.<init>(r3)
            return r2
        L_0x0012:
            com.google.common.collect.BoundType r3 = com.google.common.collect.BoundType.forBoolean(r3)
            com.google.common.collect.BoundType r5 = com.google.common.collect.BoundType.forBoolean(r5)
            com.google.common.collect.Range r2 = com.google.common.collect.Range.range(r2, r3, r4, r5)
            com.google.common.collect.ContiguousSet r2 = r1.intersectionInCurrentDomain(r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.RegularContiguousSet.subSetImpl(java.lang.Comparable, boolean, java.lang.Comparable, boolean):com.google.common.collect.ContiguousSet");
    }

    /* access modifiers changed from: package-private */
    public final ContiguousSet<C> tailSetImpl(C c, boolean z) {
        return intersectionInCurrentDomain(Range.downTo(c, BoundType.forBoolean(z)));
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final int indexOf(Object obj) {
        if (contains(obj)) {
            return (int) this.domain.distance(first(), (Comparable) obj);
        }
        return -1;
    }

    public final UnmodifiableIterator<C> iterator() {
        return new AbstractSequentialIterator<C>(first()) {
            /* class com.google.common.collect.RegularContiguousSet.AnonymousClass1 */
            final C last = RegularContiguousSet.this.last();

            /* access modifiers changed from: protected */
            public C computeNext(C c) {
                if (RegularContiguousSet.equalsOrThrow(c, this.last)) {
                    return null;
                }
                return RegularContiguousSet.this.domain.next(c);
            }
        };
    }

    @GwtIncompatible
    public final UnmodifiableIterator<C> descendingIterator() {
        return new AbstractSequentialIterator<C>(last()) {
            /* class com.google.common.collect.RegularContiguousSet.AnonymousClass2 */
            final C first = RegularContiguousSet.this.first();

            /* access modifiers changed from: protected */
            public C computeNext(C c) {
                if (RegularContiguousSet.equalsOrThrow(c, this.first)) {
                    return null;
                }
                return RegularContiguousSet.this.domain.previous(c);
            }
        };
    }

    public static boolean equalsOrThrow(Comparable<?> comparable, Comparable<?> comparable2) {
        return comparable2 != null && Range.compareOrThrow(comparable, comparable2) == 0;
    }

    public final C first() {
        return this.range.lowerBound.leastValueAbove(this.domain);
    }

    public final C last() {
        return this.range.upperBound.greatestValueBelow(this.domain);
    }

    /* access modifiers changed from: package-private */
    public final ImmutableList<C> createAsList() {
        return this.domain.supportsFastOffset ? new ImmutableAsList<C>() {
            /* class com.google.common.collect.RegularContiguousSet.AnonymousClass3 */

            /* access modifiers changed from: package-private */
            public ImmutableSortedSet<C> delegateCollection() {
                return RegularContiguousSet.this;
            }

            public C get(int i) {
                Preconditions.checkElementIndex(i, size());
                return RegularContiguousSet.this.domain.offset(RegularContiguousSet.this.first(), (long) i);
            }
        } : super.createAsList();
    }

    public final int size() {
        long distance = this.domain.distance(first(), last());
        if (distance >= 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return ((int) distance) + 1;
    }

    public final boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        try {
            return this.range.contains((Comparable) obj);
        } catch (ClassCastException unused) {
            return false;
        }
    }

    public final boolean containsAll(Collection<?> collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    public final ContiguousSet<C> intersection(ContiguousSet<C> contiguousSet) {
        Preconditions.checkNotNull(contiguousSet);
        Preconditions.checkArgument(this.domain.equals(contiguousSet.domain));
        if (contiguousSet.isEmpty()) {
            return contiguousSet;
        }
        Comparable comparable = (Comparable) Ordering.natural().max(first(), contiguousSet.first());
        Comparable comparable2 = (Comparable) Ordering.natural().min(last(), contiguousSet.last());
        return comparable.compareTo(comparable2) <= 0 ? ContiguousSet.create(Range.closed(comparable, comparable2), this.domain) : new EmptyContiguousSet(this.domain);
    }

    public final Range<C> range() {
        BoundType boundType = BoundType.CLOSED;
        return range(boundType, boundType);
    }

    public final Range<C> range(BoundType boundType, BoundType boundType2) {
        return Range.create(this.range.lowerBound.withLowerBoundType(boundType, this.domain), this.range.upperBound.withUpperBoundType(boundType2, this.domain));
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof RegularContiguousSet) {
            RegularContiguousSet regularContiguousSet = (RegularContiguousSet) obj;
            if (this.domain.equals(regularContiguousSet.domain)) {
                if (!first().equals(regularContiguousSet.first()) || !last().equals(regularContiguousSet.last())) {
                    return false;
                }
                return true;
            }
        }
        return super.equals(obj);
    }

    public final int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    @GwtIncompatible
    static final class SerializedForm<C extends Comparable> implements Serializable {
        final DiscreteDomain<C> domain;
        final Range<C> range;

        private SerializedForm(Range<C> range2, DiscreteDomain<C> discreteDomain) {
            this.range = range2;
            this.domain = discreteDomain;
        }

        private Object readResolve() {
            return new RegularContiguousSet(this.range, this.domain);
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public final Object writeReplace() {
        return new SerializedForm(this.range, this.domain);
    }
}
