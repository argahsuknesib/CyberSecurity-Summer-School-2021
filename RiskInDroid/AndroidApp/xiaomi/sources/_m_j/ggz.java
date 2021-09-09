package _m_j;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ggz<E> implements List<E> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final List<E> f17768O000000o;

    public ggz(List<E> list) {
        this.f17768O000000o = list;
    }

    public int size() {
        return this.f17768O000000o.size();
    }

    public boolean isEmpty() {
        return this.f17768O000000o.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.f17768O000000o.contains(obj);
    }

    public Iterator<E> iterator() {
        return this.f17768O000000o.iterator();
    }

    public Object[] toArray() {
        return this.f17768O000000o.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.f17768O000000o.toArray(tArr);
    }

    public boolean add(E e) {
        return this.f17768O000000o.add(e);
    }

    public boolean remove(Object obj) {
        return this.f17768O000000o.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.f17768O000000o.containsAll(collection);
    }

    public boolean addAll(Collection<? extends E> collection) {
        return this.f17768O000000o.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends E> collection) {
        return this.f17768O000000o.addAll(i, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.f17768O000000o.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.f17768O000000o.retainAll(collection);
    }

    public void clear() {
        this.f17768O000000o.clear();
    }

    public E get(int i) {
        return this.f17768O000000o.get(i);
    }

    public E set(int i, E e) {
        return this.f17768O000000o.set(i, e);
    }

    public void add(int i, E e) {
        this.f17768O000000o.add(i, e);
    }

    public E remove(int i) {
        return this.f17768O000000o.remove(i);
    }

    public int indexOf(Object obj) {
        return this.f17768O000000o.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.f17768O000000o.lastIndexOf(obj);
    }

    public ListIterator<E> listIterator() {
        return this.f17768O000000o.listIterator();
    }

    public ListIterator<E> listIterator(int i) {
        return this.f17768O000000o.listIterator(i);
    }

    public List<E> subList(int i, int i2) {
        return this.f17768O000000o.subList(i, i2);
    }
}
