package com.nostra13.universalimageloader.core.assist.deque;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class LinkedBlockingDeque<E> extends AbstractQueue<E> implements BlockingDeque<E>, Serializable {
    private static final long serialVersionUID = -387911632671998426L;
    private final int capacity;
    private transient int count;
    transient O00000o<E> first;
    transient O00000o<E> last;
    final ReentrantLock lock;
    private final Condition notEmpty;
    private final Condition notFull;

    static final class O00000o<E> {

        /* renamed from: O000000o  reason: collision with root package name */
        E f5364O000000o;
        O00000o<E> O00000Oo;
        O00000o<E> O00000o0;

        O00000o(E e) {
            this.f5364O000000o = e;
        }
    }

    public LinkedBlockingDeque() {
        this(Integer.MAX_VALUE);
    }

    public LinkedBlockingDeque(int i) {
        this.lock = new ReentrantLock();
        this.notEmpty = this.lock.newCondition();
        this.notFull = this.lock.newCondition();
        if (i > 0) {
            this.capacity = i;
            return;
        }
        throw new IllegalArgumentException();
    }

    public LinkedBlockingDeque(Collection<? extends E> collection) {
        this(Integer.MAX_VALUE);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (Object next : collection) {
                if (next == null) {
                    throw new NullPointerException();
                } else if (!linkLast(new O00000o(next))) {
                    throw new IllegalStateException("Deque full");
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    private boolean linkFirst(O00000o<E> o00000o) {
        if (this.count >= this.capacity) {
            return false;
        }
        O00000o<E> o00000o2 = this.first;
        o00000o.O00000o0 = o00000o2;
        this.first = o00000o;
        if (this.last == null) {
            this.last = o00000o;
        } else {
            o00000o2.O00000Oo = o00000o;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private boolean linkLast(O00000o<E> o00000o) {
        if (this.count >= this.capacity) {
            return false;
        }
        O00000o<E> o00000o2 = this.last;
        o00000o.O00000Oo = o00000o2;
        this.last = o00000o;
        if (this.first == null) {
            this.first = o00000o;
        } else {
            o00000o2.O00000o0 = o00000o;
        }
        this.count++;
        this.notEmpty.signal();
        return true;
    }

    private E unlinkFirst() {
        O00000o<E> o00000o = this.first;
        if (o00000o == null) {
            return null;
        }
        O00000o<E> o00000o2 = o00000o.O00000o0;
        E e = o00000o.f5364O000000o;
        o00000o.f5364O000000o = null;
        o00000o.O00000o0 = o00000o;
        this.first = o00000o2;
        if (o00000o2 == null) {
            this.last = null;
        } else {
            o00000o2.O00000Oo = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    private E unlinkLast() {
        O00000o<E> o00000o = this.last;
        if (o00000o == null) {
            return null;
        }
        O00000o<E> o00000o2 = o00000o.O00000Oo;
        E e = o00000o.f5364O000000o;
        o00000o.f5364O000000o = null;
        o00000o.O00000Oo = o00000o;
        this.last = o00000o2;
        if (o00000o2 == null) {
            this.first = null;
        } else {
            o00000o2.O00000o0 = null;
        }
        this.count--;
        this.notFull.signal();
        return e;
    }

    /* access modifiers changed from: package-private */
    public void unlink(O00000o<E> o00000o) {
        O00000o<E> o00000o2 = o00000o.O00000Oo;
        O00000o<E> o00000o3 = o00000o.O00000o0;
        if (o00000o2 == null) {
            unlinkFirst();
        } else if (o00000o3 == null) {
            unlinkLast();
        } else {
            o00000o2.O00000o0 = o00000o3;
            o00000o3.O00000Oo = o00000o2;
            o00000o.f5364O000000o = null;
            this.count--;
            this.notFull.signal();
        }
    }

    public void addFirst(E e) {
        if (!offerFirst(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public void addLast(E e) {
        if (!offerLast(e)) {
            throw new IllegalStateException("Deque full");
        }
    }

    public boolean offerFirst(E e) {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkFirst(o00000o);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public boolean offerLast(E e) {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                return linkLast(o00000o);
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new NullPointerException();
        }
    }

    public void putFirst(E e) throws InterruptedException {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkFirst(o00000o)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    public void putLast(E e) throws InterruptedException {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            while (!linkLast(o00000o)) {
                try {
                    this.notFull.await();
                } finally {
                    reentrantLock.unlock();
                }
            }
            return;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: finally extract failed */
    public boolean offerFirst(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkFirst(o00000o)) {
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
            reentrantLock.unlock();
            return true;
        }
        throw new NullPointerException();
    }

    /* JADX INFO: finally extract failed */
    public boolean offerLast(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        if (e != null) {
            O00000o o00000o = new O00000o(e);
            long nanos = timeUnit.toNanos(j);
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lockInterruptibly();
            while (!linkLast(o00000o)) {
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
            reentrantLock.unlock();
            return true;
        }
        throw new NullPointerException();
    }

    public E removeFirst() {
        E pollFirst = pollFirst();
        if (pollFirst != null) {
            return pollFirst;
        }
        throw new NoSuchElementException();
    }

    public E removeLast() {
        E pollLast = pollLast();
        if (pollLast != null) {
            return pollLast;
        }
        throw new NoSuchElementException();
    }

    public E pollFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkFirst();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E pollLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return unlinkLast();
        } finally {
            reentrantLock.unlock();
        }
    }

    public E takeFirst() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    return unlinkFirst;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public E takeLast() throws InterruptedException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    return unlinkLast;
                }
                this.notEmpty.await();
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public E pollFirst(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkFirst = unlinkFirst();
                if (unlinkFirst != null) {
                    reentrantLock.unlock();
                    return unlinkFirst;
                } else if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public E pollLast(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lockInterruptibly();
        while (true) {
            try {
                E unlinkLast = unlinkLast();
                if (unlinkLast != null) {
                    reentrantLock.unlock();
                    return unlinkLast;
                } else if (nanos <= 0) {
                    reentrantLock.unlock();
                    return null;
                } else {
                    nanos = this.notEmpty.awaitNanos(nanos);
                }
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    public E getFirst() {
        E peekFirst = peekFirst();
        if (peekFirst != null) {
            return peekFirst;
        }
        throw new NoSuchElementException();
    }

    public E getLast() {
        E peekLast = peekLast();
        if (peekLast != null) {
            return peekLast;
        }
        throw new NoSuchElementException();
    }

    public E peekFirst() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.first == null ? null : this.first.f5364O000000o;
        } finally {
            reentrantLock.unlock();
        }
    }

    public E peekLast() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.last == null ? null : this.last.f5364O000000o;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean removeFirstOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (O00000o<E> o00000o = this.first; o00000o != null; o00000o = o00000o.O00000o0) {
                if (obj.equals(o00000o.f5364O000000o)) {
                    unlink(o00000o);
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean removeLastOccurrence(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (O00000o<E> o00000o = this.last; o00000o != null; o00000o = o00000o.O00000Oo) {
                if (obj.equals(o00000o.f5364O000000o)) {
                    unlink(o00000o);
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public boolean add(E e) {
        addLast(e);
        return true;
    }

    public boolean offer(E e) {
        return offerLast(e);
    }

    public void put(E e) throws InterruptedException {
        putLast(e);
    }

    public boolean offer(E e, long j, TimeUnit timeUnit) throws InterruptedException {
        return offerLast(e, j, timeUnit);
    }

    public E remove() {
        return removeFirst();
    }

    public E poll() {
        return pollFirst();
    }

    public E take() throws InterruptedException {
        return takeFirst();
    }

    public E poll(long j, TimeUnit timeUnit) throws InterruptedException {
        return pollFirst(j, timeUnit);
    }

    public E element() {
        return getFirst();
    }

    public E peek() {
        return peekFirst();
    }

    public int remainingCapacity() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.capacity - this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    public int drainTo(Collection<? super E> collection) {
        return drainTo(collection, Integer.MAX_VALUE);
    }

    public int drainTo(Collection<? super E> collection, int i) {
        if (collection == null) {
            throw new NullPointerException();
        } else if (collection != this) {
            ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                int min = Math.min(i, this.count);
                for (int i2 = 0; i2 < min; i2++) {
                    collection.add(this.first.f5364O000000o);
                    unlinkFirst();
                }
                return min;
            } finally {
                reentrantLock.unlock();
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void push(E e) {
        addFirst(e);
    }

    public E pop() {
        return removeFirst();
    }

    public boolean remove(Object obj) {
        return removeFirstOccurrence(obj);
    }

    public int size() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            return this.count;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: finally extract failed */
    public boolean contains(Object obj) {
        if (obj == null) {
            return false;
        }
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            for (O00000o<E> o00000o = this.first; o00000o != null; o00000o = o00000o.O00000o0) {
                if (obj.equals(o00000o.f5364O000000o)) {
                    reentrantLock.unlock();
                    return true;
                }
            }
            reentrantLock.unlock();
            return false;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public Object[] toArray() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            Object[] objArr = new Object[this.count];
            int i = 0;
            O00000o<E> o00000o = this.first;
            while (o00000o != null) {
                int i2 = i + 1;
                objArr[i] = o00000o.f5364O000000o;
                o00000o = o00000o.O00000o0;
                i = i2;
            }
            return objArr;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX INFO: additional move instructions added (1) to help type inference */
    public <T> T[] toArray(T[] tArr) {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            int length = tArr.length;
            T[] tArr2 = tArr;
            if (length < this.count) {
                tArr2 = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), this.count);
            }
            int i = 0;
            O00000o<E> o00000o = this.first;
            while (o00000o != null) {
                tArr2[i] = o00000o.f5364O000000o;
                o00000o = o00000o.O00000o0;
                i++;
            }
            if (tArr2.length > i) {
                tArr2[i] = null;
            }
            return tArr2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public String toString() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            O00000o<E> o00000o = this.first;
            if (o00000o == null) {
                return "[]";
            }
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            while (true) {
                E e = o00000o.f5364O000000o;
                if (e == this) {
                    e = "(this Collection)";
                }
                sb.append((Object) e);
                o00000o = o00000o.O00000o0;
                if (o00000o == null) {
                    sb.append(']');
                    String sb2 = sb.toString();
                    reentrantLock.unlock();
                    return sb2;
                }
                sb.append(',');
                sb.append(' ');
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public void clear() {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            O00000o<E> o00000o = this.first;
            while (o00000o != null) {
                o00000o.f5364O000000o = null;
                O00000o<E> o00000o2 = o00000o.O00000o0;
                o00000o.O00000Oo = null;
                o00000o.O00000o0 = null;
                o00000o = o00000o2;
            }
            this.last = null;
            this.first = null;
            this.count = 0;
            this.notFull.signalAll();
        } finally {
            reentrantLock.unlock();
        }
    }

    public Iterator<E> iterator() {
        return new O00000o0(this, (byte) 0);
    }

    public Iterator<E> descendingIterator() {
        return new O00000Oo(this, (byte) 0);
    }

    abstract class O000000o implements Iterator<E> {

        /* renamed from: O000000o  reason: collision with root package name */
        O00000o<E> f5363O000000o;
        E O00000Oo;
        private O00000o<E> O00000o;

        /* access modifiers changed from: package-private */
        public abstract O00000o<E> O000000o();

        /* access modifiers changed from: package-private */
        public abstract O00000o<E> O000000o(O00000o<E> o00000o);

        O000000o() {
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                this.f5363O000000o = O000000o();
                this.O00000Oo = this.f5363O000000o == null ? null : this.f5363O000000o.f5364O000000o;
            } finally {
                reentrantLock.unlock();
            }
        }

        private void O00000Oo() {
            O00000o<E> O000000o2;
            E e;
            ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
            reentrantLock.lock();
            try {
                O00000o<E> o00000o = this.f5363O000000o;
                while (true) {
                    O000000o2 = O000000o(o00000o);
                    e = null;
                    if (O000000o2 == null) {
                        O000000o2 = null;
                        break;
                    } else if (O000000o2.f5364O000000o != null) {
                        break;
                    } else if (O000000o2 == o00000o) {
                        O000000o2 = O000000o();
                        break;
                    } else {
                        o00000o = O000000o2;
                    }
                }
                this.f5363O000000o = O000000o2;
                if (this.f5363O000000o != null) {
                    e = this.f5363O000000o.f5364O000000o;
                }
                this.O00000Oo = e;
            } finally {
                reentrantLock.unlock();
            }
        }

        public boolean hasNext() {
            return this.f5363O000000o != null;
        }

        public E next() {
            O00000o<E> o00000o = this.f5363O000000o;
            if (o00000o != null) {
                this.O00000o = o00000o;
                E e = this.O00000Oo;
                O00000Oo();
                return e;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            O00000o<E> o00000o = this.O00000o;
            if (o00000o != null) {
                this.O00000o = null;
                ReentrantLock reentrantLock = LinkedBlockingDeque.this.lock;
                reentrantLock.lock();
                try {
                    if (o00000o.f5364O000000o != null) {
                        LinkedBlockingDeque.this.unlink(o00000o);
                    }
                } finally {
                    reentrantLock.unlock();
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    class O00000o0 extends LinkedBlockingDeque<E>.O000000o {
        private O00000o0() {
            super();
        }

        /* synthetic */ O00000o0(LinkedBlockingDeque linkedBlockingDeque, byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final O00000o<E> O000000o() {
            return LinkedBlockingDeque.this.first;
        }

        /* access modifiers changed from: package-private */
        public final O00000o<E> O000000o(O00000o<E> o00000o) {
            return o00000o.O00000o0;
        }
    }

    class O00000Oo extends LinkedBlockingDeque<E>.O000000o {
        private O00000Oo() {
            super();
        }

        /* synthetic */ O00000Oo(LinkedBlockingDeque linkedBlockingDeque, byte b) {
            this();
        }

        /* access modifiers changed from: package-private */
        public final O00000o<E> O000000o() {
            return LinkedBlockingDeque.this.last;
        }

        /* access modifiers changed from: package-private */
        public final O00000o<E> O000000o(O00000o<E> o00000o) {
            return o00000o.O00000Oo;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ReentrantLock reentrantLock = this.lock;
        reentrantLock.lock();
        try {
            objectOutputStream.defaultWriteObject();
            for (O00000o<E> o00000o = this.first; o00000o != null; o00000o = o00000o.O00000o0) {
                objectOutputStream.writeObject(o00000o.f5364O000000o);
            }
            objectOutputStream.writeObject(null);
        } finally {
            reentrantLock.unlock();
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.count = 0;
        this.first = null;
        this.last = null;
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
