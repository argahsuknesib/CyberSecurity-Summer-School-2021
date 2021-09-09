package rx.internal.util;

import android.support.v4.app.NotificationCompat;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.Subscription;
import rx.functions.Func1;

public final class IndexedRingBuffer<E> implements Subscription {
    static final int SIZE;
    private final ElementSection<E> elements = new ElementSection<>();
    final AtomicInteger index = new AtomicInteger();
    private final IndexSection removed = new IndexSection();
    final AtomicInteger removedIndex = new AtomicInteger();

    public final boolean isUnsubscribed() {
        return false;
    }

    static {
        int i = PlatformDependent.isAndroid() ? 8 : NotificationCompat.FLAG_HIGH_PRIORITY;
        String property = System.getProperty("rx.indexed-ring-buffer.size");
        if (property != null) {
            try {
                i = Integer.parseInt(property);
            } catch (NumberFormatException e) {
                PrintStream printStream = System.err;
                printStream.println("Failed to set 'rx.indexed-ring-buffer.size' with value " + property + " => " + e.getMessage());
            }
        }
        SIZE = i;
    }

    public static <T> IndexedRingBuffer<T> getInstance() {
        return new IndexedRingBuffer<>();
    }

    public final void releaseToPool() {
        int i = this.index.get();
        ElementSection<E> elementSection = this.elements;
        int i2 = 0;
        loop0:
        while (elementSection != null) {
            int i3 = i2;
            int i4 = 0;
            while (i4 < SIZE) {
                if (i3 >= i) {
                    break loop0;
                }
                elementSection.array.set(i4, null);
                i4++;
                i3++;
            }
            elementSection = elementSection.next.get();
            i2 = i3;
        }
        this.index.set(0);
        this.removedIndex.set(0);
    }

    public final void unsubscribe() {
        releaseToPool();
    }

    IndexedRingBuffer() {
    }

    public final int add(E e) {
        int indexForAdd = getIndexForAdd();
        int i = SIZE;
        if (indexForAdd < i) {
            this.elements.array.set(indexForAdd, e);
            return indexForAdd;
        }
        getElementSection(indexForAdd).array.set(indexForAdd % i, e);
        return indexForAdd;
    }

    public final E remove(int i) {
        E e;
        int i2 = SIZE;
        if (i < i2) {
            e = this.elements.array.getAndSet(i, null);
        } else {
            e = getElementSection(i).array.getAndSet(i % i2, null);
        }
        pushRemovedIndex(i);
        return e;
    }

    private IndexSection getIndexSection(int i) {
        int i2 = SIZE;
        if (i < i2) {
            return this.removed;
        }
        int i3 = i / i2;
        IndexSection indexSection = this.removed;
        for (int i4 = 0; i4 < i3; i4++) {
            indexSection = indexSection.getNext();
        }
        return indexSection;
    }

    private ElementSection<E> getElementSection(int i) {
        int i2 = SIZE;
        if (i < i2) {
            return this.elements;
        }
        int i3 = i / i2;
        ElementSection<E> elementSection = this.elements;
        for (int i4 = 0; i4 < i3; i4++) {
            elementSection = elementSection.getNext();
        }
        return elementSection;
    }

    private synchronized int getIndexForAdd() {
        int i;
        int indexFromPreviouslyRemoved = getIndexFromPreviouslyRemoved();
        if (indexFromPreviouslyRemoved >= 0) {
            if (indexFromPreviouslyRemoved < SIZE) {
                i = this.removed.getAndSet(indexFromPreviouslyRemoved, -1);
            } else {
                i = getIndexSection(indexFromPreviouslyRemoved).getAndSet(indexFromPreviouslyRemoved % SIZE, -1);
            }
            if (i == this.index.get()) {
                this.index.getAndIncrement();
            }
        } else {
            i = this.index.getAndIncrement();
        }
        return i;
    }

    private synchronized int getIndexFromPreviouslyRemoved() {
        int i;
        int i2;
        do {
            i = this.removedIndex.get();
            if (i <= 0) {
                return -1;
            }
            i2 = i - 1;
        } while (!this.removedIndex.compareAndSet(i, i2));
        return i2;
    }

    private synchronized void pushRemovedIndex(int i) {
        int andIncrement = this.removedIndex.getAndIncrement();
        if (andIncrement < SIZE) {
            this.removed.set(andIncrement, i);
            return;
        }
        getIndexSection(andIncrement).set(andIncrement % SIZE, i);
    }

    public final int forEach(Func1<? super E, Boolean> func1) {
        return forEach(func1, 0);
    }

    public final int forEach(Func1<? super E, Boolean> func1, int i) {
        int forEach = forEach(func1, i, this.index.get());
        if (i > 0 && forEach == this.index.get()) {
            return forEach(func1, 0, i);
        }
        if (forEach == this.index.get()) {
            return 0;
        }
        return forEach;
    }

    private int forEach(Func1<? super E, Boolean> func1, int i, int i2) {
        int i3;
        int i4 = this.index.get();
        ElementSection<E> elementSection = this.elements;
        if (i >= SIZE) {
            elementSection = getElementSection(i);
            i3 = i;
            i %= SIZE;
        } else {
            i3 = i;
        }
        loop0:
        while (elementSection != null) {
            while (i < SIZE) {
                if (i3 >= i4 || i3 >= i2) {
                    break loop0;
                }
                E e = elementSection.array.get(i);
                if (e != null && !func1.call(e).booleanValue()) {
                    return i3;
                }
                i++;
                i3++;
            }
            elementSection = elementSection.next.get();
            i = 0;
        }
        return i3;
    }

    static final class ElementSection<E> {
        final AtomicReferenceArray<E> array = new AtomicReferenceArray<>(IndexedRingBuffer.SIZE);
        final AtomicReference<ElementSection<E>> next = new AtomicReference<>();

        ElementSection() {
        }

        /* access modifiers changed from: package-private */
        public final ElementSection<E> getNext() {
            if (this.next.get() != null) {
                return this.next.get();
            }
            ElementSection<E> elementSection = new ElementSection<>();
            if (this.next.compareAndSet(null, elementSection)) {
                return elementSection;
            }
            return this.next.get();
        }
    }

    static class IndexSection {
        private final AtomicReference<IndexSection> _next = new AtomicReference<>();
        private final AtomicIntegerArray unsafeArray = new AtomicIntegerArray(IndexedRingBuffer.SIZE);

        IndexSection() {
        }

        public int getAndSet(int i, int i2) {
            return this.unsafeArray.getAndSet(i, i2);
        }

        public void set(int i, int i2) {
            this.unsafeArray.set(i, i2);
        }

        /* access modifiers changed from: package-private */
        public IndexSection getNext() {
            if (this._next.get() != null) {
                return this._next.get();
            }
            IndexSection indexSection = new IndexSection();
            if (this._next.compareAndSet(null, indexSection)) {
                return indexSection;
            }
            return this._next.get();
        }
    }
}
