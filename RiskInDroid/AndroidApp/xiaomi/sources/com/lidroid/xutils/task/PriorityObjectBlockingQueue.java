package com.lidroid.xutils.task;

import _m_j.brh;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PriorityObjectBlockingQueue<E> extends AbstractQueue<E> implements Serializable, BlockingQueue<E> {
    private static final long serialVersionUID = -6903933977591709194L;
    private final int capacity;
    private final AtomicInteger count;
    transient brh<E> head;
    private transient brh<E> last;
    private final Condition notEmpty;
    private final Condition notFull;
    private final ReentrantLock putLock;
    private final ReentrantLock takeLock;

    private void signalNotEmpty() {
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            this.notEmpty.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private void signalNotFull() {
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            this.notFull.signal();
        } finally {
            reentrantLock.unlock();
        }
    }

    private synchronized E opQueue(brh<E> brh) {
        if (brh == null) {
            return _dequeue();
        }
        _enqueue(brh);
        return null;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [_m_j.brh<E>, _m_j.brh, _m_j.brh<T>] */
    /* JADX WARNING: Unknown variable types count: 1 */
    private void _enqueue(brh<E> r5) {
        boolean z;
        brh brh = this.head;
        while (true) {
            if (brh.O00000Oo == null) {
                z = false;
                break;
            }
            brh<T> brh2 = brh.O00000Oo;
            if (brh2.f13217O000000o.f13218O000000o.ordinal() > r5.f13217O000000o.f13218O000000o.ordinal()) {
                brh.O00000Oo = r5;
                r5.O00000Oo = brh2;
                z = true;
                break;
            }
            brh = brh.O00000Oo;
        }
        if (!z) {
            this.last.O00000Oo = r5;
            this.last = r5;
        }
    }

    private E _dequeue() {
        brh brh = this.head;
        brh brh2 = brh.O00000Oo;
        brh.O00000Oo = brh;
        this.head = brh2;
        E O000000o2 = brh2.O000000o();
        brh2.O000000o(null);
        return O000000o2;
    }

    /* access modifiers changed from: package-private */
    public void fullyLock() {
        this.putLock.lock();
        this.takeLock.lock();
    }

    /* access modifiers changed from: package-private */
    public void fullyUnlock() {
        this.takeLock.unlock();
        this.putLock.unlock();
    }

    public PriorityObjectBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public PriorityObjectBlockingQueue(int i) {
        this.count = new AtomicInteger();
        this.takeLock = new ReentrantLock();
        this.notEmpty = this.takeLock.newCondition();
        this.putLock = new ReentrantLock();
        this.notFull = this.putLock.newCondition();
        if (i > 0) {
            this.capacity = i;
            brh<E> brh = new brh<>(null);
            this.head = brh;
            this.last = brh;
            return;
        }
        throw new IllegalArgumentException();
    }

    public PriorityObjectBlockingQueue(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        int i = 0;
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (i != this.capacity) {
                    opQueue(new brh(next));
                    i++;
                } else {
                    throw new IllegalStateException("Queue full");
                }
            }
            this.count.set(i);
        } finally {
            reentrantLock.unlock();
        }
    }

    public int size() {
        return this.count.get();
    }

    public int remainingCapacity() {
        return this.capacity - this.count.get();
    }

    public void put(E e) throws InterruptedException {
        if (e != null) {
            brh brh = new brh(e);
            ReentrantLock reentrantLock = this.putLock;
            AtomicInteger atomicInteger = this.count;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.capacity) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            opQueue(brh);
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.capacity) {
                this.notFull.signal();
            }
            if (andIncrement == 0) {
                signalNotEmpty();
                return;
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: finally extract failed */
    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e != null) {
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.putLock;
            AtomicInteger atomicInteger = this.count;
            reentrantLock.lockInterruptibly();
            while (atomicInteger.get() == this.capacity) {
                try {
                    if (nanos <= 0) {
                        reentrantLock.unlock();
                        return false;
                    }
                    nanos = this.notFull.awaitNanos(nanos);
                } catch (Throwable th) {
                    reentrantLock.unlock();
                    throw th;
                }
            }
            opQueue(new brh(e));
            int andIncrement = atomicInteger.getAndIncrement();
            if (andIncrement + 1 < this.capacity) {
                this.notFull.signal();
            }
            reentrantLock.unlock();
            if (andIncrement != 0) {
                return true;
            }
            signalNotEmpty();
            return true;
        }
        throw new NullPointerException();
    }

    public boolean offer(E e) {
        if (e != null) {
            AtomicInteger atomicInteger = this.count;
            if (atomicInteger.get() == this.capacity) {
                return false;
            }
            int i = -1;
            brh brh = new brh(e);
            ReentrantLock reentrantLock = this.putLock;
            reentrantLock.lock();
            try {
                if (atomicInteger.get() < this.capacity) {
                    opQueue(brh);
                    i = atomicInteger.getAndIncrement();
                    if (i + 1 < this.capacity) {
                        this.notFull.signal();
                    }
                }
                if (i == 0) {
                    signalNotEmpty();
                }
                if (i >= 0) {
                    return true;
                }
                return false;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    /* JADX INFO: finally extract failed */
    public E take() throws InterruptedException {
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                this.notEmpty.await();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        AtomicInteger atomicInteger = this.count;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lockInterruptibly();
        while (atomicInteger.get() == 0) {
            try {
                if (nanos <= 0) {
                    return null;
                }
                nanos = this.notEmpty.awaitNanos(nanos);
            } finally {
                reentrantLock.unlock();
            }
        }
        E opQueue = opQueue(null);
        int andDecrement = atomicInteger.getAndDecrement();
        if (andDecrement > 1) {
            this.notEmpty.signal();
        }
        reentrantLock.unlock();
        if (andDecrement == this.capacity) {
            signalNotFull();
        }
        return opQueue;
    }

    /* JADX INFO: finally extract failed */
    public E poll() {
        AtomicInteger atomicInteger = this.count;
        E e = null;
        if (atomicInteger.get() == 0) {
            return null;
        }
        int i = -1;
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            if (atomicInteger.get() > 0) {
                e = opQueue(null);
                i = atomicInteger.getAndDecrement();
                if (i > 1) {
                    this.notEmpty.signal();
                }
            }
            reentrantLock.unlock();
            if (i == this.capacity) {
                signalNotFull();
            }
            return e;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public E peek() {
        if (this.count.get() == 0) {
            return null;
        }
        ReentrantLock reentrantLock = this.takeLock;
        reentrantLock.lock();
        try {
            brh brh = this.head.O00000Oo;
            if (brh == null) {
                return null;
            }
            E O000000o2 = brh.O000000o();
            reentrantLock.unlock();
            return O000000o2;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* access modifiers changed from: package-private */
    public void unlink(brh<E> brh, brh<E> brh2) {
        brh.O000000o(null);
        brh2.O00000Oo = brh.O00000Oo;
        if (this.last == brh) {
            this.last = brh2;
        }
        if (this.count.getAndDecrement() == this.capacity) {
            this.notFull.signal();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean remove(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            brh brh = this.head;
            brh brh2 = brh.O00000Oo;
            while (true) {
                brh brh3 = brh2;
                brh brh4 = brh;
                brh = brh3;
                if (brh == null) {
                    fullyUnlock();
                    return false;
                } else if (obj.equals(brh.O000000o())) {
                    unlink(brh, brh4);
                    fullyUnlock();
                    return true;
                } else {
                    brh2 = brh.O00000Oo;
                }
            }
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        fullyLock();
        try {
            brh brh = this.head;
            do {
                brh = brh.O00000Oo;
                if (brh == null) {
                    fullyUnlock();
                    return false;
                }
            } while (!obj.equals(brh.O000000o()));
            fullyUnlock();
            return true;
        } catch (Throwable th) {
            fullyUnlock();
            throw th;
        }
    }

    public Object[] toArray() {
        fullyLock();
        try {
            Object[] objArr = new Object[this.count.get()];
            int i = 0;
            brh<T> brh = this.head.O00000Oo;
            while (brh != null) {
                int i2 = i + 1;
                objArr[i] = brh.O000000o();
                brh = brh.O00000Oo;
                i = i2;
            }
            return objArr;
        } finally {
            fullyUnlock();
        }
    }

    public <T> T[] toArray(T[] tArr) {
        fullyLock();
        try {
            int i = this.count.get();
            if (tArr.length < i) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
            }
            int i2 = 0;
            brh<T> brh = this.head.O00000Oo;
            while (brh != null) {
                int i3 = i2 + 1;
                tArr[i2] = brh.O000000o();
                brh = brh.O00000Oo;
                i2 = i3;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        } finally {
            fullyUnlock();
        }
    }

    public void clear() {
        fullyLock();
        try {
            brh brh = this.head;
            while (true) {
                brh brh2 = brh.O00000Oo;
                if (brh2 == null) {
                    break;
                }
                brh.O00000Oo = brh;
                brh2.O000000o(null);
                brh = brh2;
            }
            this.head = this.last;
            if (this.count.getAndSet(0) == this.capacity) {
                this.notFull.signal();
            }
        } finally {
            fullyUnlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        brh brh;
        int i2;
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection != this) {
            boolean z = false;
            if (i <= 0) {
                return 0;
            }
            ReentrantLock reentrantLock = this.takeLock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count.get());
                brh = this.head;
                i2 = 0;
                while (i2 < min) {
                    brh brh2 = brh.O00000Oo;
                    collection.add(brh2.O000000o());
                    brh2.O000000o(null);
                    brh.O00000Oo = brh;
                    i2++;
                    brh = brh2;
                }
                if (i2 > 0) {
                    this.head = brh;
                    if (this.count.getAndAdd(-i2) == this.capacity) {
                        z = true;
                    }
                }
                reentrantLock.unlock();
                if (z) {
                    signalNotFull();
                }
                return min;
            } catch (Throwable th) {
                reentrantLock.unlock();
                if (0 != 0) {
                    signalNotFull();
                }
                throw th;
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public Iterator<E> iterator() {
        return new O000000o();
    }

    class O000000o implements Iterator<E> {
        private brh<E> O00000Oo;
        private E O00000o;
        private brh<E> O00000o0;

        O000000o() {
            PriorityObjectBlockingQueue.this.fullyLock();
            try {
                this.O00000Oo = PriorityObjectBlockingQueue.this.head.O00000Oo;
                if (this.O00000Oo != null) {
                    this.O00000o = this.O00000Oo.O000000o();
                }
            } finally {
                PriorityObjectBlockingQueue.this.fullyUnlock();
            }
        }

        public final boolean hasNext() {
            return this.O00000Oo != null;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: _m_j.brh<E>} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v0, resolved type: _m_j.brh} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: _m_j.brh<E>} */
        /* JADX WARNING: Multi-variable type inference failed */
        private brh<E> O000000o(brh<E> brh) {
            brh brh2;
            while (true) {
                brh2 = brh.O00000Oo;
                if (brh2 == brh) {
                    return PriorityObjectBlockingQueue.this.head.O00000Oo;
                }
                if (brh2 == 0 || brh2.O000000o() != null) {
                    return brh2;
                }
                brh = brh2;
            }
            return brh2;
        }

        public final E next() {
            PriorityObjectBlockingQueue.this.fullyLock();
            try {
                if (this.O00000Oo != null) {
                    E e = this.O00000o;
                    this.O00000o0 = this.O00000Oo;
                    this.O00000Oo = O000000o(this.O00000Oo);
                    this.O00000o = this.O00000Oo == null ? null : this.O00000Oo.O000000o();
                    return e;
                }
                throw new NoSuchElementException();
            } finally {
                PriorityObjectBlockingQueue.this.fullyUnlock();
            }
        }

        public final void remove() {
            if (this.O00000o0 != null) {
                PriorityObjectBlockingQueue.this.fullyLock();
                try {
                    brh brh = this.O00000o0;
                    this.O00000o0 = null;
                    brh brh2 = PriorityObjectBlockingQueue.this.head;
                    brh brh3 = brh2.O00000Oo;
                    while (true) {
                        brh brh4 = brh3;
                        brh brh5 = brh2;
                        brh2 = brh4;
                        if (brh2 == null) {
                            break;
                        } else if (brh2 == brh) {
                            PriorityObjectBlockingQueue.this.unlink(brh2, brh5);
                            break;
                        } else {
                            brh3 = brh2.O00000Oo;
                        }
                    }
                } finally {
                    PriorityObjectBlockingQueue.this.fullyUnlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        fullyLock();
        try {
            objectOutputStream.defaultWriteObject();
            brh brh = this.head;
            while (true) {
                brh = brh.O00000Oo;
                if (brh == null) {
                    objectOutputStream.writeObject(null);
                    return;
                }
                objectOutputStream.writeObject(brh.O000000o());
            }
        } finally {
            fullyUnlock();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count.set(0);
        brh<E> brh = new brh<>(null);
        this.head = brh;
        this.last = brh;
        while (true) {
            Object readObject = objectInputStream.readObject();
            if (readObject != null) {
                add(readObject);
            } else {
                return;
            }
        }
    }
}
