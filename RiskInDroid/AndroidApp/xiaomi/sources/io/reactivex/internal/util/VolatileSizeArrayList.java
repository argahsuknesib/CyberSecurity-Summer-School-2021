package io.reactivex.internal.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import java.util.concurrent.atomic.AtomicInteger;

public final class VolatileSizeArrayList<T> extends AtomicInteger implements List<T>, RandomAccess {
    private static final long serialVersionUID = 3972397474470203923L;
    final ArrayList<T> list;

    public VolatileSizeArrayList() {
        this.list = new ArrayList<>();
    }

    public VolatileSizeArrayList(int i) {
        this.list = new ArrayList<>(i);
    }

    public final int size() {
        return get();
    }

    public final boolean isEmpty() {
        return get() == 0;
    }

    public final boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public final Iterator<T> iterator() {
        return this.list.iterator();
    }

    public final Object[] toArray() {
        return this.list.toArray();
    }

    public final <E> E[] toArray(E[] eArr) {
        return this.list.toArray(eArr);
    }

    public final boolean add(T t) {
        boolean add = this.list.add(t);
        lazySet(this.list.size());
        return add;
    }

    public final boolean remove(Object obj) {
        boolean remove = this.list.remove(obj);
        lazySet(this.list.size());
        return remove;
    }

    public final boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public final boolean addAll(Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(collection);
        lazySet(this.list.size());
        return addAll;
    }

    public final boolean addAll(int i, Collection<? extends T> collection) {
        boolean addAll = this.list.addAll(i, collection);
        lazySet(this.list.size());
        return addAll;
    }

    public final boolean removeAll(Collection<?> collection) {
        boolean removeAll = this.list.removeAll(collection);
        lazySet(this.list.size());
        return removeAll;
    }

    public final boolean retainAll(Collection<?> collection) {
        boolean retainAll = this.list.retainAll(collection);
        lazySet(this.list.size());
        return retainAll;
    }

    public final void clear() {
        this.list.clear();
        lazySet(0);
    }

    public final T get(int i) {
        return this.list.get(i);
    }

    public final T set(int i, T t) {
        return this.list.set(i, t);
    }

    public final void add(int i, T t) {
        this.list.add(i, t);
        lazySet(this.list.size());
    }

    public final T remove(int i) {
        T remove = this.list.remove(i);
        lazySet(this.list.size());
        return remove;
    }

    public final int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public final int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public final ListIterator<T> listIterator() {
        return this.list.listIterator();
    }

    public final ListIterator<T> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public final List<T> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof VolatileSizeArrayList) {
            return this.list.equals(((VolatileSizeArrayList) obj).list);
        }
        return this.list.equals(obj);
    }

    public final int hashCode() {
        return this.list.hashCode();
    }

    public final String toString() {
        return this.list.toString();
    }
}
