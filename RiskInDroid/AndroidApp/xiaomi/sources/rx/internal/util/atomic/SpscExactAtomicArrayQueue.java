package rx.internal.util.atomic;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.internal.util.unsafe.Pow2;

public final class SpscExactAtomicArrayQueue<T> extends AtomicReferenceArray<T> implements Queue<T> {
    private static final long serialVersionUID = 6210984603741293445L;
    final int capacitySkip;
    final AtomicLong consumerIndex = new AtomicLong();
    final int mask;
    final AtomicLong producerIndex = new AtomicLong();

    public SpscExactAtomicArrayQueue(int i) {
        super(Pow2.roundToPowerOfTwo(i));
        int length = length();
        this.mask = length - 1;
        this.capacitySkip = length - i;
    }

    public final boolean offer(T t) {
        if (t != null) {
            long j = this.producerIndex.get();
            int i = this.mask;
            if (get(((int) (((long) this.capacitySkip) + j)) & i) != null) {
                return false;
            }
            this.producerIndex.lazySet(j + 1);
            lazySet(i & ((int) j), t);
            return true;
        }
        throw new NullPointerException();
    }

    public final T poll() {
        long j = this.consumerIndex.get();
        int i = ((int) j) & this.mask;
        T t = get(i);
        if (t == null) {
            return null;
        }
        this.consumerIndex.lazySet(j + 1);
        lazySet(i, null);
        return t;
    }

    public final T peek() {
        return get(this.mask & ((int) this.consumerIndex.get()));
    }

    public final void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public final boolean isEmpty() {
        return this.producerIndex == this.consumerIndex;
    }

    public final int size() {
        long j = this.consumerIndex.get();
        while (true) {
            long j2 = this.producerIndex.get();
            long j3 = this.consumerIndex.get();
            if (j == j3) {
                return (int) (j2 - j3);
            }
            j = j3;
        }
    }

    public final boolean contains(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final Iterator<T> iterator() {
        throw new UnsupportedOperationException();
    }

    public final Object[] toArray() {
        throw new UnsupportedOperationException();
    }

    public final <E> E[] toArray(E[] eArr) {
        throw new UnsupportedOperationException();
    }

    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public final boolean containsAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean addAll(Collection<? extends T> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    public final boolean add(T t) {
        throw new UnsupportedOperationException();
    }

    public final T remove() {
        throw new UnsupportedOperationException();
    }

    public final T element() {
        throw new UnsupportedOperationException();
    }
}
