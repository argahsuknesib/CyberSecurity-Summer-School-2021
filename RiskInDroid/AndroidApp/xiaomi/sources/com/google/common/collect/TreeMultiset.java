package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    public final transient AvlNode<E> header;
    public final transient GeneralRange<E> range;
    private final transient Reference<AvlNode<E>> rootReference;

    enum Aggregate {
        SIZE {
            /* access modifiers changed from: package-private */
            public final int nodeAggregate(AvlNode<?> avlNode) {
                return avlNode.elemCount;
            }

            /* access modifiers changed from: package-private */
            public final long treeAggregate(AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.totalCount;
            }
        },
        DISTINCT {
            /* access modifiers changed from: package-private */
            public final int nodeAggregate(AvlNode<?> avlNode) {
                return 1;
            }

            /* access modifiers changed from: package-private */
            public final long treeAggregate(AvlNode<?> avlNode) {
                if (avlNode == null) {
                    return 0;
                }
                return (long) avlNode.distinctElements;
            }
        };

        /* access modifiers changed from: package-private */
        public abstract int nodeAggregate(AvlNode<?> avlNode);

        /* access modifiers changed from: package-private */
        public abstract long treeAggregate(AvlNode<?> avlNode);
    }

    public final /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    public final /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ SortedMultiset descendingMultiset() {
        return super.descendingMultiset();
    }

    public final /* bridge */ /* synthetic */ NavigableSet elementSet() {
        return super.elementSet();
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public final /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    public final /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    public final /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    public final /* bridge */ /* synthetic */ SortedMultiset subMultiset(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.subMultiset(obj, boundType, obj2, boundType2);
    }

    public static <E extends Comparable> TreeMultiset<E> create() {
        return new TreeMultiset<>(Ordering.natural());
    }

    public static <E> TreeMultiset<E> create(Comparator comparator) {
        return comparator == null ? new TreeMultiset<>(Ordering.natural()) : new TreeMultiset<>(comparator);
    }

    public static <E extends Comparable> TreeMultiset<E> create(Iterable iterable) {
        TreeMultiset<E> create = create();
        Iterables.addAll(create, iterable);
        return create;
    }

    TreeMultiset(Reference<AvlNode<E>> reference, GeneralRange<E> generalRange, AvlNode<E> avlNode) {
        super(generalRange.comparator());
        this.rootReference = reference;
        this.range = generalRange;
        this.header = avlNode;
    }

    TreeMultiset(Comparator<? super E> comparator) {
        super(comparator);
        this.range = GeneralRange.all(comparator);
        this.header = new AvlNode<>(null, 1);
        AvlNode<E> avlNode = this.header;
        successor(avlNode, avlNode);
        this.rootReference = new Reference<>();
    }

    private long aggregateForEntries(Aggregate aggregate) {
        AvlNode avlNode = this.rootReference.get();
        long treeAggregate = aggregate.treeAggregate(avlNode);
        if (this.range.hasLowerBound()) {
            treeAggregate -= aggregateBelowRange(aggregate, avlNode);
        }
        return this.range.hasUpperBound() ? treeAggregate - aggregateAboveRange(aggregate, avlNode) : treeAggregate;
    }

    private long aggregateBelowRange(Aggregate aggregate, AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateBelowRange;
        while (avlNode != null) {
            int compare = comparator().compare(this.range.getLowerEndpoint(), avlNode.elem);
            if (compare < 0) {
                avlNode = avlNode.left;
            } else {
                if (compare == 0) {
                    int i = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getLowerBoundType().ordinal()];
                    if (i == 1) {
                        treeAggregate = (long) aggregate.nodeAggregate(avlNode);
                        aggregateBelowRange = aggregate.treeAggregate(avlNode.left);
                    } else if (i == 2) {
                        return aggregate.treeAggregate(avlNode.left);
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    treeAggregate = aggregate.treeAggregate(avlNode.left) + ((long) aggregate.nodeAggregate(avlNode));
                    aggregateBelowRange = aggregateBelowRange(aggregate, avlNode.right);
                }
                return treeAggregate + aggregateBelowRange;
            }
        }
        return 0;
    }

    /* renamed from: com.google.common.collect.TreeMultiset$4  reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType = new int[BoundType.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        static {
            $SwitchMap$com$google$common$collect$BoundType[BoundType.OPEN.ordinal()] = 1;
            $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
        }
    }

    private long aggregateAboveRange(Aggregate aggregate, AvlNode<E> avlNode) {
        long treeAggregate;
        long aggregateAboveRange;
        while (avlNode != null) {
            int compare = comparator().compare(this.range.getUpperEndpoint(), avlNode.elem);
            if (compare > 0) {
                avlNode = avlNode.right;
            } else {
                if (compare == 0) {
                    int i = AnonymousClass4.$SwitchMap$com$google$common$collect$BoundType[this.range.getUpperBoundType().ordinal()];
                    if (i == 1) {
                        treeAggregate = (long) aggregate.nodeAggregate(avlNode);
                        aggregateAboveRange = aggregate.treeAggregate(avlNode.right);
                    } else if (i == 2) {
                        return aggregate.treeAggregate(avlNode.right);
                    } else {
                        throw new AssertionError();
                    }
                } else {
                    treeAggregate = aggregate.treeAggregate(avlNode.right) + ((long) aggregate.nodeAggregate(avlNode));
                    aggregateAboveRange = aggregateAboveRange(aggregate, avlNode.left);
                }
                return treeAggregate + aggregateAboveRange;
            }
        }
        return 0;
    }

    public final int size() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.SIZE));
    }

    /* access modifiers changed from: package-private */
    public final int distinctElements() {
        return Ints.saturatedCast(aggregateForEntries(Aggregate.DISTINCT));
    }

    static int distinctElements(AvlNode<?> avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return avlNode.distinctElements;
    }

    public final int count(Object obj) {
        try {
            AvlNode avlNode = this.rootReference.get();
            if (this.range.contains(obj)) {
                if (avlNode != null) {
                    return avlNode.count(comparator(), obj);
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public final int add(E e, int i) {
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        Preconditions.checkArgument(this.range.contains(e));
        AvlNode avlNode = this.rootReference.get();
        if (avlNode == null) {
            comparator().compare(e, e);
            AvlNode avlNode2 = new AvlNode(e, i);
            AvlNode<E> avlNode3 = this.header;
            successor(avlNode3, avlNode2, avlNode3);
            this.rootReference.checkAndSet(avlNode, avlNode2);
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.add(comparator(), e, i, iArr));
        return iArr[0];
    }

    @CanIgnoreReturnValue
    public final int remove(Object obj, int i) {
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        AvlNode avlNode = this.rootReference.get();
        int[] iArr = new int[1];
        try {
            if (this.range.contains(obj)) {
                if (avlNode != null) {
                    this.rootReference.checkAndSet(avlNode, avlNode.remove(comparator(), obj, i, iArr));
                    return iArr[0];
                }
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public final int setCount(E e, int i) {
        CollectPreconditions.checkNonnegative(i, "count");
        boolean z = true;
        if (!this.range.contains(e)) {
            if (i != 0) {
                z = false;
            }
            Preconditions.checkArgument(z);
            return 0;
        }
        AvlNode avlNode = this.rootReference.get();
        if (avlNode == null) {
            if (i > 0) {
                add(e, i);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e, i, iArr));
        return iArr[0];
    }

    @CanIgnoreReturnValue
    public final boolean setCount(E e, int i, int i2) {
        CollectPreconditions.checkNonnegative(i2, "newCount");
        CollectPreconditions.checkNonnegative(i, "oldCount");
        Preconditions.checkArgument(this.range.contains(e));
        AvlNode avlNode = this.rootReference.get();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.rootReference.checkAndSet(avlNode, avlNode.setCount(comparator(), e, i, i2, iArr));
            return iArr[0] == i;
        } else if (i != 0) {
            return false;
        } else {
            if (i2 > 0) {
                add(e, i2);
            }
            return true;
        }
    }

    public final void clear() {
        if (this.range.hasLowerBound() || this.range.hasUpperBound()) {
            Iterators.clear(entryIterator());
            return;
        }
        AvlNode<E> avlNode = this.header.succ;
        while (true) {
            AvlNode<E> avlNode2 = this.header;
            if (avlNode != avlNode2) {
                AvlNode<E> avlNode3 = avlNode.succ;
                avlNode.elemCount = 0;
                avlNode.left = null;
                avlNode.right = null;
                avlNode.pred = null;
                avlNode.succ = null;
                avlNode = avlNode3;
            } else {
                successor(avlNode2, avlNode2);
                this.rootReference.clear();
                return;
            }
        }
    }

    public final Multiset.Entry<E> wrapEntry(final AvlNode<E> avlNode) {
        return new Multisets.AbstractEntry<E>() {
            /* class com.google.common.collect.TreeMultiset.AnonymousClass1 */

            public E getElement() {
                return avlNode.getElement();
            }

            public int getCount() {
                int count = avlNode.getCount();
                return count == 0 ? TreeMultiset.this.count(getElement()) : count;
            }
        };
    }

    public final AvlNode<E> firstNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.hasLowerBound()) {
            E lowerEndpoint = this.range.getLowerEndpoint();
            avlNode = this.rootReference.get().ceiling(comparator(), lowerEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getLowerBoundType() == BoundType.OPEN && comparator().compare(lowerEndpoint, avlNode.getElement()) == 0) {
                avlNode = avlNode.succ;
            }
        } else {
            avlNode = this.header.succ;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    public final AvlNode<E> lastNode() {
        AvlNode<E> avlNode;
        if (this.rootReference.get() == null) {
            return null;
        }
        if (this.range.hasUpperBound()) {
            E upperEndpoint = this.range.getUpperEndpoint();
            avlNode = this.rootReference.get().floor(comparator(), upperEndpoint);
            if (avlNode == null) {
                return null;
            }
            if (this.range.getUpperBoundType() == BoundType.OPEN && comparator().compare(upperEndpoint, avlNode.getElement()) == 0) {
                avlNode = avlNode.pred;
            }
        } else {
            avlNode = this.header.pred;
        }
        if (avlNode == this.header || !this.range.contains(avlNode.getElement())) {
            return null;
        }
        return avlNode;
    }

    /* access modifiers changed from: package-private */
    public final Iterator<E> elementIterator() {
        return Multisets.elementIterator(entryIterator());
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new Iterator<Multiset.Entry<E>>() {
            /* class com.google.common.collect.TreeMultiset.AnonymousClass2 */
            AvlNode<E> current = TreeMultiset.this.firstNode();
            Multiset.Entry<E> prevEntry;

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooHigh(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                    this.prevEntry = wrapEntry;
                    if (this.current.succ == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.succ;
                    }
                    return wrapEntry;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Multiset.Entry<E>> descendingEntryIterator() {
        return new Iterator<Multiset.Entry<E>>() {
            /* class com.google.common.collect.TreeMultiset.AnonymousClass3 */
            AvlNode<E> current = TreeMultiset.this.lastNode();
            Multiset.Entry<E> prevEntry = null;

            public boolean hasNext() {
                if (this.current == null) {
                    return false;
                }
                if (!TreeMultiset.this.range.tooLow(this.current.getElement())) {
                    return true;
                }
                this.current = null;
                return false;
            }

            public Multiset.Entry<E> next() {
                if (hasNext()) {
                    Multiset.Entry<E> wrapEntry = TreeMultiset.this.wrapEntry(this.current);
                    this.prevEntry = wrapEntry;
                    if (this.current.pred == TreeMultiset.this.header) {
                        this.current = null;
                    } else {
                        this.current = this.current.pred;
                    }
                    return wrapEntry;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.prevEntry != null);
                TreeMultiset.this.setCount(this.prevEntry.getElement(), 0);
                this.prevEntry = null;
            }
        };
    }

    public final void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Preconditions.checkNotNull(objIntConsumer);
        AvlNode<E> firstNode = firstNode();
        while (firstNode != this.header && firstNode != null && !this.range.tooHigh(firstNode.getElement())) {
            objIntConsumer.accept(firstNode.getElement(), firstNode.getCount());
            firstNode = firstNode.succ;
        }
    }

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    public final SortedMultiset<E> headMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.upTo(comparator(), e, boundType)), this.header);
    }

    public final SortedMultiset<E> tailMultiset(E e, BoundType boundType) {
        return new TreeMultiset(this.rootReference, this.range.intersect(GeneralRange.downTo(comparator(), e, boundType)), this.header);
    }

    static final class Reference<T> {
        private T value;

        private Reference() {
        }

        public final T get() {
            return this.value;
        }

        public final void checkAndSet(T t, T t2) {
            if (this.value == t) {
                this.value = t2;
                return;
            }
            throw new ConcurrentModificationException();
        }

        /* access modifiers changed from: package-private */
        public final void clear() {
            this.value = null;
        }
    }

    static final class AvlNode<E> {
        public int distinctElements;
        public final E elem;
        public int elemCount;
        private int height;
        public AvlNode<E> left;
        public AvlNode<E> pred;
        public AvlNode<E> right;
        public AvlNode<E> succ;
        public long totalCount;

        AvlNode(E e, int i) {
            Preconditions.checkArgument(i > 0);
            this.elem = e;
            this.elemCount = i;
            this.totalCount = (long) i;
            this.distinctElements = 1;
            this.height = 1;
            this.left = null;
            this.right = null;
        }

        public final int count(Comparator<? super E> comparator, E e) {
            AvlNode avlNode = this;
            while (true) {
                int compare = comparator.compare(e, avlNode.elem);
                if (compare < 0) {
                    avlNode = avlNode.left;
                    if (avlNode == null) {
                        return 0;
                    }
                } else if (compare <= 0) {
                    return avlNode.elemCount;
                } else {
                    avlNode = avlNode.right;
                    if (avlNode == null) {
                        return 0;
                    }
                }
            }
        }

        private AvlNode<E> addRightChild(E e, int i) {
            this.right = new AvlNode<>(e, i);
            TreeMultiset.successor(this, this.right, this.succ);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) i;
            return this;
        }

        private AvlNode<E> addLeftChild(E e, int i) {
            this.left = new AvlNode<>(e, i);
            TreeMultiset.successor(this.pred, this.left, this);
            this.height = Math.max(2, this.height);
            this.distinctElements++;
            this.totalCount += (long) i;
            return this;
        }

        /* access modifiers changed from: package-private */
        public final AvlNode<E> add(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.elem);
            boolean z = true;
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return addLeftChild(e, i);
                }
                int i2 = avlNode.height;
                this.left = avlNode.add(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) i;
                return this.left.height == i2 ? this : rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return addRightChild(e, i);
                }
                int i3 = avlNode2.height;
                this.right = avlNode2.add(comparator, e, i, iArr);
                if (iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) i;
                return this.right.height == i3 ? this : rebalance();
            } else {
                int i4 = this.elemCount;
                iArr[0] = i4;
                long j = (long) i;
                if (((long) i4) + j > 2147483647L) {
                    z = false;
                }
                Preconditions.checkArgument(z);
                this.elemCount += i;
                this.totalCount += j;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public final AvlNode<E> remove(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.left = avlNode.remove(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.distinctElements--;
                        this.totalCount -= (long) iArr[0];
                    } else {
                        this.totalCount -= (long) i;
                    }
                }
                return iArr[0] == 0 ? this : rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.right = avlNode2.remove(comparator, e, i, iArr);
                if (iArr[0] > 0) {
                    if (i >= iArr[0]) {
                        this.distinctElements--;
                        this.totalCount -= (long) iArr[0];
                    } else {
                        this.totalCount -= (long) i;
                    }
                }
                return rebalance();
            } else {
                int i2 = this.elemCount;
                iArr[0] = i2;
                if (i >= i2) {
                    return deleteMe();
                }
                this.elemCount = i2 - i;
                this.totalCount -= (long) i;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public final AvlNode<E> setCount(Comparator<? super E> comparator, E e, int i, int[] iArr) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return i > 0 ? addLeftChild(e, i) : this;
                }
                this.left = avlNode.setCount(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.distinctElements--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (i - iArr[0]);
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return i > 0 ? addRightChild(e, i) : this;
                }
                this.right = avlNode2.setCount(comparator, e, i, iArr);
                if (i == 0 && iArr[0] != 0) {
                    this.distinctElements--;
                } else if (i > 0 && iArr[0] == 0) {
                    this.distinctElements++;
                }
                this.totalCount += (long) (i - iArr[0]);
                return rebalance();
            } else {
                int i2 = this.elemCount;
                iArr[0] = i2;
                if (i == 0) {
                    return deleteMe();
                }
                this.totalCount += (long) (i - i2);
                this.elemCount = i;
                return this;
            }
        }

        /* access modifiers changed from: package-private */
        public final AvlNode<E> setCount(Comparator<? super E> comparator, E e, int i, int i2, int[] iArr) {
            int compare = comparator.compare(e, this.elem);
            if (compare < 0) {
                AvlNode<E> avlNode = this.left;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : addLeftChild(e, i2);
                }
                this.left = avlNode.setCount(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.distinctElements--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (i2 - iArr[0]);
                }
                return rebalance();
            } else if (compare > 0) {
                AvlNode<E> avlNode2 = this.right;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return (i != 0 || i2 <= 0) ? this : addRightChild(e, i2);
                }
                this.right = avlNode2.setCount(comparator, e, i, i2, iArr);
                if (iArr[0] == i) {
                    if (i2 == 0 && iArr[0] != 0) {
                        this.distinctElements--;
                    } else if (i2 > 0 && iArr[0] == 0) {
                        this.distinctElements++;
                    }
                    this.totalCount += (long) (i2 - iArr[0]);
                }
                return rebalance();
            } else {
                int i3 = this.elemCount;
                iArr[0] = i3;
                if (i == i3) {
                    if (i2 == 0) {
                        return deleteMe();
                    }
                    this.totalCount += (long) (i2 - i3);
                    this.elemCount = i2;
                }
                return this;
            }
        }

        private AvlNode<E> deleteMe() {
            int i = this.elemCount;
            this.elemCount = 0;
            TreeMultiset.successor(this.pred, this.succ);
            AvlNode<E> avlNode = this.left;
            if (avlNode == null) {
                return this.right;
            }
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.height >= avlNode2.height) {
                AvlNode<E> avlNode3 = this.pred;
                avlNode3.left = avlNode.removeMax(avlNode3);
                avlNode3.right = this.right;
                avlNode3.distinctElements = this.distinctElements - 1;
                avlNode3.totalCount = this.totalCount - ((long) i);
                return avlNode3.rebalance();
            }
            AvlNode<E> avlNode4 = this.succ;
            avlNode4.right = avlNode2.removeMin(avlNode4);
            avlNode4.left = this.left;
            avlNode4.distinctElements = this.distinctElements - 1;
            avlNode4.totalCount = this.totalCount - ((long) i);
            return avlNode4.rebalance();
        }

        private AvlNode<E> removeMin(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.left;
            if (avlNode2 == null) {
                return this.right;
            }
            this.left = avlNode2.removeMin(avlNode);
            this.distinctElements--;
            this.totalCount -= (long) avlNode.elemCount;
            return rebalance();
        }

        private AvlNode<E> removeMax(AvlNode<E> avlNode) {
            AvlNode<E> avlNode2 = this.right;
            if (avlNode2 == null) {
                return this.left;
            }
            this.right = avlNode2.removeMax(avlNode);
            this.distinctElements--;
            this.totalCount -= (long) avlNode.elemCount;
            return rebalance();
        }

        private void recomputeMultiset() {
            this.distinctElements = TreeMultiset.distinctElements(this.left) + 1 + TreeMultiset.distinctElements(this.right);
            this.totalCount = ((long) this.elemCount) + totalCount(this.left) + totalCount(this.right);
        }

        private void recomputeHeight() {
            this.height = Math.max(height(this.left), height(this.right)) + 1;
        }

        private void recompute() {
            recomputeMultiset();
            recomputeHeight();
        }

        private AvlNode<E> rebalance() {
            int balanceFactor = balanceFactor();
            if (balanceFactor == -2) {
                if (this.right.balanceFactor() > 0) {
                    this.right = this.right.rotateRight();
                }
                return rotateLeft();
            } else if (balanceFactor != 2) {
                recomputeHeight();
                return this;
            } else {
                if (this.left.balanceFactor() < 0) {
                    this.left = this.left.rotateLeft();
                }
                return rotateRight();
            }
        }

        private int balanceFactor() {
            return height(this.left) - height(this.right);
        }

        private AvlNode<E> rotateLeft() {
            Preconditions.checkState(this.right != null);
            AvlNode<E> avlNode = this.right;
            this.right = avlNode.left;
            avlNode.left = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private AvlNode<E> rotateRight() {
            Preconditions.checkState(this.left != null);
            AvlNode<E> avlNode = this.left;
            this.left = avlNode.right;
            avlNode.right = this;
            avlNode.totalCount = this.totalCount;
            avlNode.distinctElements = this.distinctElements;
            recompute();
            avlNode.recomputeHeight();
            return avlNode;
        }

        private static long totalCount(AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.totalCount;
        }

        private static int height(AvlNode<?> avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.height;
        }

        public final AvlNode<E> ceiling(Comparator<? super E> comparator, E e) {
            AvlNode avlNode = this;
            do {
                int compare = comparator.compare(e, avlNode.elem);
                if (compare < 0) {
                    AvlNode<E> avlNode2 = avlNode.left;
                    return avlNode2 == null ? avlNode : (AvlNode) MoreObjects.firstNonNull(avlNode2.ceiling(comparator, e), avlNode);
                } else if (compare == 0) {
                    return avlNode;
                } else {
                    avlNode = avlNode.right;
                }
            } while (avlNode != null);
            return null;
        }

        public final AvlNode<E> floor(Comparator<? super E> comparator, E e) {
            AvlNode avlNode = this;
            do {
                int compare = comparator.compare(e, avlNode.elem);
                if (compare > 0) {
                    AvlNode<E> avlNode2 = avlNode.right;
                    return avlNode2 == null ? avlNode : (AvlNode) MoreObjects.firstNonNull(avlNode2.floor(comparator, e), avlNode);
                } else if (compare == 0) {
                    return avlNode;
                } else {
                    avlNode = avlNode.left;
                }
            } while (avlNode != null);
            return null;
        }

        /* access modifiers changed from: package-private */
        public final E getElement() {
            return this.elem;
        }

        /* access modifiers changed from: package-private */
        public final int getCount() {
            return this.elemCount;
        }

        public final String toString() {
            return Multisets.immutableEntry(getElement(), getCount()).toString();
        }
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [com.google.common.collect.TreeMultiset$AvlNode<E>, com.google.common.collect.TreeMultiset$AvlNode, com.google.common.collect.TreeMultiset$AvlNode<T>] */
    /* JADX WARN: Type inference failed for: r1v0, types: [com.google.common.collect.TreeMultiset$AvlNode<E>, com.google.common.collect.TreeMultiset$AvlNode, com.google.common.collect.TreeMultiset$AvlNode<T>] */
    /* JADX WARNING: Unknown variable types count: 2 */
    public static <T> void successor(AvlNode<T> r0, AvlNode<T> r1) {
        r0.succ = r1;
        r1.pred = r0;
    }

    public static <T> void successor(AvlNode<T> avlNode, AvlNode<T> avlNode2, AvlNode<T> avlNode3) {
        successor(avlNode, avlNode2);
        successor(avlNode2, avlNode3);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(elementSet().comparator());
        Serialization.writeMultiset(this, objectOutputStream);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void
     arg types: [com.google.common.collect.TreeMultiset, java.util.Comparator]
     candidates:
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, int):void
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void
     arg types: [com.google.common.collect.TreeMultiset, com.google.common.collect.GeneralRange]
     candidates:
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, int):void
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void
     arg types: [com.google.common.collect.TreeMultiset, com.google.common.collect.TreeMultiset$Reference]
     candidates:
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, int):void
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void */
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void
     arg types: [com.google.common.collect.TreeMultiset, com.google.common.collect.TreeMultiset$AvlNode]
     candidates:
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, int):void
      com.google.common.collect.Serialization.FieldSetter.set(com.google.common.collect.ImmutableMultimap, java.lang.Object):void */
    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        Comparator comparator = (Comparator) objectInputStream.readObject();
        Serialization.getFieldSetter(AbstractSortedMultiset.class, "comparator").set((ImmutableMultimap) this, (Object) comparator);
        Serialization.getFieldSetter(TreeMultiset.class, "range").set((ImmutableMultimap) this, (Object) GeneralRange.all(comparator));
        Serialization.getFieldSetter(TreeMultiset.class, "rootReference").set((ImmutableMultimap) this, (Object) new Reference());
        AvlNode avlNode = new AvlNode(null, 1);
        Serialization.getFieldSetter(TreeMultiset.class, "header").set((ImmutableMultimap) this, (Object) avlNode);
        successor(avlNode, avlNode);
        Serialization.populateMultiset(this, objectInputStream);
    }
}
