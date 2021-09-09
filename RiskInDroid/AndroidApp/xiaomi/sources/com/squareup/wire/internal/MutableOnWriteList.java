package com.squareup.wire.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;
import java.util.RandomAccess;

final class MutableOnWriteList<T> extends AbstractList<T> implements Serializable, RandomAccess {
    private final List<T> immutableList;
    List<T> mutableList;

    MutableOnWriteList(List<T> list) {
        this.immutableList = list;
        this.mutableList = list;
    }

    public final T get(int i) {
        return this.mutableList.get(i);
    }

    public final int size() {
        return this.mutableList.size();
    }

    public final T set(int i, T t) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        return this.mutableList.set(i, t);
    }

    public final void add(int i, T t) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        this.mutableList.add(i, t);
    }

    public final T remove(int i) {
        List<T> list = this.mutableList;
        List<T> list2 = this.immutableList;
        if (list == list2) {
            this.mutableList = new ArrayList(list2);
        }
        return this.mutableList.remove(i);
    }

    private Object writeReplace() throws ObjectStreamException {
        return new ArrayList(this.mutableList);
    }
}
