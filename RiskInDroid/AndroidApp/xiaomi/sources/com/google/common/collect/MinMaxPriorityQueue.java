package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.math.IntMath;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.j2objc.annotations.Weak;
import java.util.AbstractQueue;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;

@GwtCompatible
@Beta
public final class MinMaxPriorityQueue<E> extends AbstractQueue<E> {
    private final MinMaxPriorityQueue<E>.Heap maxHeap;
    @VisibleForTesting
    final int maximumSize;
    private final MinMaxPriorityQueue<E>.Heap minHeap;
    public int modCount;
    public Object[] queue;
    public int size;

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create() {
        return new Builder(Ordering.natural()).create();
    }

    public static <E extends Comparable<E>> MinMaxPriorityQueue<E> create(Iterable<? extends E> iterable) {
        return new Builder(Ordering.natural()).create(iterable);
    }

    public static <B> Builder<B> orderedBy(Comparator<B> comparator) {
        return new Builder<>(comparator);
    }

    public static Builder<Comparable> expectedSize(int i) {
        return new Builder(Ordering.natural()).expectedSize(i);
    }

    public static Builder<Comparable> maximumSize(int i) {
        return new Builder(Ordering.natural()).maximumSize(i);
    }

    @Beta
    public static final class Builder<B> {
        private final Comparator<B> comparator;
        private int expectedSize;
        public int maximumSize;

        private Builder(Comparator<B> comparator2) {
            this.expectedSize = -1;
            this.maximumSize = Integer.MAX_VALUE;
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator2);
        }

        @CanIgnoreReturnValue
        public final Builder<B> expectedSize(int i) {
            Preconditions.checkArgument(i >= 0);
            this.expectedSize = i;
            return this;
        }

        @CanIgnoreReturnValue
        public final Builder<B> maximumSize(int i) {
            Preconditions.checkArgument(i > 0);
            this.maximumSize = i;
            return this;
        }

        public final <T extends B> MinMaxPriorityQueue<T> create() {
            return create(Collections.emptySet());
        }

        public final <T extends B> MinMaxPriorityQueue<T> create(Iterable<? extends T> iterable) {
            MinMaxPriorityQueue<T> minMaxPriorityQueue = new MinMaxPriorityQueue<>(this, MinMaxPriorityQueue.initialQueueSize(this.expectedSize, this.maximumSize, iterable));
            for (Object offer : iterable) {
                minMaxPriorityQueue.offer(offer);
            }
            return minMaxPriorityQueue;
        }

        public final <T extends B> Ordering<T> ordering() {
            return Ordering.from(this.comparator);
        }
    }

    private MinMaxPriorityQueue(Builder<? super E> builder, int i) {
        Ordering<T> ordering = builder.ordering();
        this.minHeap = new Heap(ordering);
        this.maxHeap = new Heap(ordering.reverse());
        MinMaxPriorityQueue<E>.Heap heap = this.minHeap;
        MinMaxPriorityQueue<E>.Heap heap2 = this.maxHeap;
        heap.otherHeap = heap2;
        heap2.otherHeap = heap;
        this.maximumSize = builder.maximumSize;
        this.queue = new Object[i];
    }

    public final int size() {
        return this.size;
    }

    @CanIgnoreReturnValue
    public final boolean add(E e) {
        offer(e);
        return true;
    }

    @CanIgnoreReturnValue
    public final boolean addAll(Collection<? extends E> collection) {
        boolean z = false;
        for (Object offer : collection) {
            offer(offer);
            z = true;
        }
        return z;
    }

    @CanIgnoreReturnValue
    public final boolean offer(E e) {
        Preconditions.checkNotNull(e);
        this.modCount++;
        int i = this.size;
        this.size = i + 1;
        growIfNeeded();
        heapForIndex(i).bubbleUp(i, e);
        if (this.size <= this.maximumSize || pollLast() != e) {
            return true;
        }
        return false;
    }

    @CanIgnoreReturnValue
    public final E poll() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(0);
    }

    /* access modifiers changed from: package-private */
    public final E elementData(int i) {
        return this.queue[i];
    }

    public final E peek() {
        if (isEmpty()) {
            return null;
        }
        return elementData(0);
    }

    private int getMaxElementIndex() {
        int i = this.size;
        if (i != 1) {
            return (i == 2 || this.maxHeap.compareElements(1, 2) <= 0) ? 1 : 2;
        }
        return 0;
    }

    @CanIgnoreReturnValue
    public final E pollFirst() {
        return poll();
    }

    @CanIgnoreReturnValue
    public final E removeFirst() {
        return remove();
    }

    public final E peekFirst() {
        return peek();
    }

    @CanIgnoreReturnValue
    public final E pollLast() {
        if (isEmpty()) {
            return null;
        }
        return removeAndGet(getMaxElementIndex());
    }

    @CanIgnoreReturnValue
    public final E removeLast() {
        if (!isEmpty()) {
            return removeAndGet(getMaxElementIndex());
        }
        throw new NoSuchElementException();
    }

    public final E peekLast() {
        if (isEmpty()) {
            return null;
        }
        return elementData(getMaxElementIndex());
    }

    /* access modifiers changed from: package-private */
    @CanIgnoreReturnValue
    @VisibleForTesting
    public final MoveDesc<E> removeAt(int i) {
        Preconditions.checkPositionIndex(i, this.size);
        this.modCount++;
        this.size--;
        int i2 = this.size;
        if (i2 == i) {
            this.queue[i2] = null;
            return null;
        }
        Object elementData = elementData(i2);
        int swapWithConceptuallyLastElement = heapForIndex(this.size).swapWithConceptuallyLastElement(elementData);
        if (swapWithConceptuallyLastElement == i) {
            this.queue[this.size] = null;
            return null;
        }
        Object elementData2 = elementData(this.size);
        this.queue[this.size] = null;
        MoveDesc<E> fillHole = fillHole(i, elementData2);
        if (swapWithConceptuallyLastElement >= i) {
            return fillHole;
        }
        if (fillHole == null) {
            return new MoveDesc<>(elementData, elementData2);
        }
        return new MoveDesc<>(elementData, fillHole.replaced);
    }

    private MoveDesc<E> fillHole(int i, E e) {
        MinMaxPriorityQueue<E>.Heap heapForIndex = heapForIndex(i);
        int fillHoleAt = heapForIndex.fillHoleAt(i);
        int bubbleUpAlternatingLevels = heapForIndex.bubbleUpAlternatingLevels(fillHoleAt, e);
        if (bubbleUpAlternatingLevels == fillHoleAt) {
            return heapForIndex.tryCrossOverAndBubbleUp(i, fillHoleAt, e);
        }
        if (bubbleUpAlternatingLevels < i) {
            return new MoveDesc<>(e, elementData(i));
        }
        return null;
    }

    static class MoveDesc<E> {
        final E replaced;
        final E toTrickle;

        MoveDesc(E e, E e2) {
            this.toTrickle = e;
            this.replaced = e2;
        }
    }

    private E removeAndGet(int i) {
        E elementData = elementData(i);
        removeAt(i);
        return elementData;
    }

    private MinMaxPriorityQueue<E>.Heap heapForIndex(int i) {
        return isEvenLevel(i) ? this.minHeap : this.maxHeap;
    }

    @VisibleForTesting
    static boolean isEvenLevel(int i) {
        int i2 = ((i + 1) ^ -1) ^ -1;
        Preconditions.checkState(i2 > 0, "negative index");
        return (1431655765 & i2) > (i2 & -1431655766);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final boolean isIntact() {
        for (int i = 1; i < this.size; i++) {
            if (!heapForIndex(i).verifyIndex(i)) {
                return false;
            }
        }
        return true;
    }

    class Heap {
        final Ordering<E> ordering;
        @Weak
        MinMaxPriorityQueue<E>.Heap otherHeap;

        private int getLeftChildIndex(int i) {
            return (i * 2) + 1;
        }

        private int getRightChildIndex(int i) {
            return (i * 2) + 2;
        }

        Heap(Ordering<E> ordering2) {
            this.ordering = ordering2;
        }

        /* access modifiers changed from: package-private */
        public int compareElements(int i, int i2) {
            return this.ordering.compare(MinMaxPriorityQueue.this.elementData(i), MinMaxPriorityQueue.this.elementData(i2));
        }

        /* access modifiers changed from: package-private */
        public MoveDesc<E> tryCrossOverAndBubbleUp(int i, int i2, E e) {
            Object obj;
            int crossOver = crossOver(i2, e);
            if (crossOver == i2) {
                return null;
            }
            if (crossOver < i) {
                obj = MinMaxPriorityQueue.this.elementData(i);
            } else {
                obj = MinMaxPriorityQueue.this.elementData(getParentIndex(i));
            }
            if (this.otherHeap.bubbleUpAlternatingLevels(crossOver, e) < i) {
                return new MoveDesc<>(e, obj);
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void bubbleUp(int i, E e) {
            Heap heap;
            int crossOverUp = crossOverUp(i, e);
            if (crossOverUp == i) {
                crossOverUp = i;
                heap = this;
            } else {
                heap = this.otherHeap;
            }
            heap.bubbleUpAlternatingLevels(crossOverUp, e);
        }

        /* access modifiers changed from: package-private */
        @CanIgnoreReturnValue
        public int bubbleUpAlternatingLevels(int i, E e) {
            while (i > 2) {
                int grandparentIndex = getGrandparentIndex(i);
                Object elementData = MinMaxPriorityQueue.this.elementData(grandparentIndex);
                if (this.ordering.compare(elementData, e) <= 0) {
                    break;
                }
                MinMaxPriorityQueue.this.queue[i] = elementData;
                i = grandparentIndex;
            }
            MinMaxPriorityQueue.this.queue[i] = e;
            return i;
        }

        /* access modifiers changed from: package-private */
        public int findMin(int i, int i2) {
            if (i >= MinMaxPriorityQueue.this.size) {
                return -1;
            }
            Preconditions.checkState(i > 0);
            int min = Math.min(i, MinMaxPriorityQueue.this.size - i2) + i2;
            for (int i3 = i + 1; i3 < min; i3++) {
                if (compareElements(i3, i) < 0) {
                    i = i3;
                }
            }
            return i;
        }

        /* access modifiers changed from: package-private */
        public int findMinChild(int i) {
            return findMin(getLeftChildIndex(i), 2);
        }

        /* access modifiers changed from: package-private */
        public int findMinGrandChild(int i) {
            int leftChildIndex = getLeftChildIndex(i);
            if (leftChildIndex < 0) {
                return -1;
            }
            return findMin(getLeftChildIndex(leftChildIndex), 4);
        }

        /* access modifiers changed from: package-private */
        public int crossOverUp(int i, E e) {
            int rightChildIndex;
            if (i == 0) {
                MinMaxPriorityQueue.this.queue[0] = e;
                return 0;
            }
            int parentIndex = getParentIndex(i);
            Object elementData = MinMaxPriorityQueue.this.elementData(parentIndex);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData2 = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData2, elementData) < 0) {
                    parentIndex = rightChildIndex;
                    elementData = elementData2;
                }
            }
            if (this.ordering.compare(elementData, e) < 0) {
                MinMaxPriorityQueue.this.queue[i] = elementData;
                MinMaxPriorityQueue.this.queue[parentIndex] = e;
                return parentIndex;
            }
            MinMaxPriorityQueue.this.queue[i] = e;
            return i;
        }

        /* access modifiers changed from: package-private */
        public int swapWithConceptuallyLastElement(E e) {
            int rightChildIndex;
            int parentIndex = getParentIndex(MinMaxPriorityQueue.this.size);
            if (!(parentIndex == 0 || (rightChildIndex = getRightChildIndex(getParentIndex(parentIndex))) == parentIndex || getLeftChildIndex(rightChildIndex) < MinMaxPriorityQueue.this.size)) {
                Object elementData = MinMaxPriorityQueue.this.elementData(rightChildIndex);
                if (this.ordering.compare(elementData, e) < 0) {
                    MinMaxPriorityQueue.this.queue[rightChildIndex] = e;
                    MinMaxPriorityQueue.this.queue[MinMaxPriorityQueue.this.size] = elementData;
                    return rightChildIndex;
                }
            }
            return MinMaxPriorityQueue.this.size;
        }

        /* access modifiers changed from: package-private */
        public int crossOver(int i, E e) {
            int findMinChild = findMinChild(i);
            if (findMinChild <= 0 || this.ordering.compare(MinMaxPriorityQueue.this.elementData(findMinChild), e) >= 0) {
                return crossOverUp(i, e);
            }
            MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.elementData(findMinChild);
            MinMaxPriorityQueue.this.queue[findMinChild] = e;
            return findMinChild;
        }

        /* access modifiers changed from: package-private */
        public int fillHoleAt(int i) {
            while (true) {
                int findMinGrandChild = findMinGrandChild(i);
                if (findMinGrandChild <= 0) {
                    return i;
                }
                MinMaxPriorityQueue.this.queue[i] = MinMaxPriorityQueue.this.elementData(findMinGrandChild);
                i = findMinGrandChild;
            }
        }

        public boolean verifyIndex(int i) {
            if (getLeftChildIndex(i) < MinMaxPriorityQueue.this.size && compareElements(i, getLeftChildIndex(i)) > 0) {
                return false;
            }
            if (getRightChildIndex(i) < MinMaxPriorityQueue.this.size && compareElements(i, getRightChildIndex(i)) > 0) {
                return false;
            }
            if (i > 0 && compareElements(i, getParentIndex(i)) > 0) {
                return false;
            }
            if (i <= 2 || compareElements(getGrandparentIndex(i), i) <= 0) {
                return true;
            }
            return false;
        }

        private int getParentIndex(int i) {
            return (i - 1) / 2;
        }

        private int getGrandparentIndex(int i) {
            return getParentIndex(getParentIndex(i));
        }
    }

    class QueueIterator implements Iterator<E> {
        private boolean canRemove;
        private int cursor;
        private int expectedModCount;
        private Queue<E> forgetMeNot;
        private E lastFromForgetMeNot;
        private int nextCursor;
        private List<E> skipMe;

        private QueueIterator() {
            this.cursor = -1;
            this.nextCursor = -1;
            this.expectedModCount = MinMaxPriorityQueue.this.modCount;
        }

        public boolean hasNext() {
            Queue<E> queue;
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size() || ((queue = this.forgetMeNot) != null && !queue.isEmpty())) {
                return true;
            }
            return false;
        }

        public E next() {
            checkModCount();
            nextNotInSkipMe(this.cursor + 1);
            if (this.nextCursor < MinMaxPriorityQueue.this.size()) {
                this.cursor = this.nextCursor;
                this.canRemove = true;
                return MinMaxPriorityQueue.this.elementData(this.cursor);
            }
            if (this.forgetMeNot != null) {
                this.cursor = MinMaxPriorityQueue.this.size();
                this.lastFromForgetMeNot = this.forgetMeNot.poll();
                E e = this.lastFromForgetMeNot;
                if (e != null) {
                    this.canRemove = true;
                    return e;
                }
            }
            throw new NoSuchElementException("iterator moved past last element in queue.");
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.canRemove);
            checkModCount();
            this.canRemove = false;
            this.expectedModCount++;
            if (this.cursor < MinMaxPriorityQueue.this.size()) {
                MoveDesc removeAt = MinMaxPriorityQueue.this.removeAt(this.cursor);
                if (removeAt != null) {
                    if (this.forgetMeNot == null) {
                        this.forgetMeNot = new ArrayDeque();
                        this.skipMe = new ArrayList(3);
                    }
                    if (!foundAndRemovedExactReference(this.skipMe, removeAt.toTrickle)) {
                        this.forgetMeNot.add(removeAt.toTrickle);
                    }
                    if (!foundAndRemovedExactReference(this.forgetMeNot, removeAt.replaced)) {
                        this.skipMe.add(removeAt.replaced);
                    }
                }
                this.cursor--;
                this.nextCursor--;
                return;
            }
            Preconditions.checkState(removeExact(this.lastFromForgetMeNot));
            this.lastFromForgetMeNot = null;
        }

        private boolean foundAndRemovedExactReference(Iterable<E> iterable, E e) {
            Iterator<E> it = iterable.iterator();
            while (it.hasNext()) {
                if (it.next() == e) {
                    it.remove();
                    return true;
                }
            }
            return false;
        }

        private boolean removeExact(Object obj) {
            for (int i = 0; i < MinMaxPriorityQueue.this.size; i++) {
                if (MinMaxPriorityQueue.this.queue[i] == obj) {
                    MinMaxPriorityQueue.this.removeAt(i);
                    return true;
                }
            }
            return false;
        }

        private void checkModCount() {
            if (MinMaxPriorityQueue.this.modCount != this.expectedModCount) {
                throw new ConcurrentModificationException();
            }
        }

        private void nextNotInSkipMe(int i) {
            if (this.nextCursor < i) {
                if (this.skipMe != null) {
                    while (i < MinMaxPriorityQueue.this.size() && foundAndRemovedExactReference(this.skipMe, MinMaxPriorityQueue.this.elementData(i))) {
                        i++;
                    }
                }
                this.nextCursor = i;
            }
        }
    }

    public final Iterator<E> iterator() {
        return new QueueIterator();
    }

    public final void clear() {
        for (int i = 0; i < this.size; i++) {
            this.queue[i] = null;
        }
        this.size = 0;
    }

    public final Object[] toArray() {
        int i = this.size;
        Object[] objArr = new Object[i];
        System.arraycopy(this.queue, 0, objArr, 0, i);
        return objArr;
    }

    public final Comparator<? super E> comparator() {
        return this.minHeap.ordering;
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int capacity() {
        return this.queue.length;
    }

    @VisibleForTesting
    static int initialQueueSize(int i, int i2, Iterable<?> iterable) {
        if (i == -1) {
            i = 11;
        }
        if (iterable instanceof Collection) {
            i = Math.max(i, ((Collection) iterable).size());
        }
        return capAtMaximumSize(i, i2);
    }

    private void growIfNeeded() {
        if (this.size > this.queue.length) {
            Object[] objArr = new Object[calculateNewCapacity()];
            Object[] objArr2 = this.queue;
            System.arraycopy(objArr2, 0, objArr, 0, objArr2.length);
            this.queue = objArr;
        }
    }

    private int calculateNewCapacity() {
        int i;
        int length = this.queue.length;
        if (length < 64) {
            i = (length + 1) * 2;
        } else {
            i = IntMath.checkedMultiply(length / 2, 3);
        }
        return capAtMaximumSize(i, this.maximumSize);
    }

    private static int capAtMaximumSize(int i, int i2) {
        return Math.min(i - 1, i2) + 1;
    }
}
