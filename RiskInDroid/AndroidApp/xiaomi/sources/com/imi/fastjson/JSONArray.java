package com.imi.fastjson;

import _m_j.bdf;
import _m_j.bdg;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class JSONArray extends bdf implements bdg, Serializable, Cloneable, List<Object>, RandomAccess {
    private static final long serialVersionUID = 1;
    protected transient Object O00000oO;
    protected transient Type O00000oo;
    private final List<Object> list;

    public JSONArray() {
        this.list = new ArrayList(10);
    }

    private JSONArray(List<Object> list2) {
        this.list = list2;
    }

    public JSONArray(int i) {
        this.list = new ArrayList(i);
    }

    public final Object O00000Oo() {
        return this.O00000oO;
    }

    public final void O00000o0(Object obj) {
        this.O00000oO = obj;
    }

    public final Type O00000o0() {
        return this.O00000oo;
    }

    public final void O000000o(Type type) {
        this.O00000oo = type;
    }

    public int size() {
        return this.list.size();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public boolean contains(Object obj) {
        return this.list.contains(obj);
    }

    public Iterator<Object> iterator() {
        return this.list.iterator();
    }

    public Object[] toArray() {
        return this.list.toArray();
    }

    public <T> T[] toArray(T[] tArr) {
        return this.list.toArray(tArr);
    }

    public boolean add(Object obj) {
        return this.list.add(obj);
    }

    public boolean remove(Object obj) {
        return this.list.remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return this.list.containsAll(collection);
    }

    public boolean addAll(Collection<? extends Object> collection) {
        return this.list.addAll(collection);
    }

    public boolean addAll(int i, Collection<? extends Object> collection) {
        return this.list.addAll(i, collection);
    }

    public boolean removeAll(Collection<?> collection) {
        return this.list.removeAll(collection);
    }

    public boolean retainAll(Collection<?> collection) {
        return this.list.retainAll(collection);
    }

    public void clear() {
        this.list.clear();
    }

    public Object set(int i, Object obj) {
        return this.list.set(i, obj);
    }

    public void add(int i, Object obj) {
        this.list.add(i, obj);
    }

    public Object remove(int i) {
        return this.list.remove(i);
    }

    public int indexOf(Object obj) {
        return this.list.indexOf(obj);
    }

    public int lastIndexOf(Object obj) {
        return this.list.lastIndexOf(obj);
    }

    public ListIterator<Object> listIterator() {
        return this.list.listIterator();
    }

    public ListIterator<Object> listIterator(int i) {
        return this.list.listIterator(i);
    }

    public List<Object> subList(int i, int i2) {
        return this.list.subList(i, i2);
    }

    public Object get(int i) {
        return this.list.get(i);
    }

    public Object clone() {
        return new JSONArray(new ArrayList(this.list));
    }

    public boolean equals(Object obj) {
        return this.list.equals(obj);
    }

    public int hashCode() {
        return this.list.hashCode();
    }
}
