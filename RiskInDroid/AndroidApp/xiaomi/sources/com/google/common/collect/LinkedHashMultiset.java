package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultiset<E> extends AbstractMapBasedMultiset<E> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ int add(Object obj, int i) {
        return super.add(obj, i);
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ int count(Object obj) {
        return super.count(obj);
    }

    public final /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final /* bridge */ /* synthetic */ void forEachEntry(ObjIntConsumer objIntConsumer) {
        super.forEachEntry(objIntConsumer);
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public final /* bridge */ /* synthetic */ Iterator iterator() {
        return super.iterator();
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ int remove(Object obj, int i) {
        return super.remove(obj, i);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ int setCount(Object obj, int i) {
        return super.setCount(obj, i);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ boolean setCount(Object obj, int i, int i2) {
        return super.setCount(obj, i, i2);
    }

    public final /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public static <E> LinkedHashMultiset<E> create() {
        return new LinkedHashMultiset<>();
    }

    public static <E> LinkedHashMultiset<E> create(int i) {
        return new LinkedHashMultiset<>(i);
    }

    public static <E> LinkedHashMultiset<E> create(Iterable<? extends E> iterable) {
        LinkedHashMultiset<E> create = create(Multisets.inferDistinctElements(iterable));
        Iterables.addAll(create, iterable);
        return create;
    }

    private LinkedHashMultiset() {
        super(new LinkedHashMap());
    }

    private LinkedHashMultiset(int i) {
        super(Maps.newLinkedHashMapWithExpectedSize(i));
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int readCount = Serialization.readCount(objectInputStream);
        setBackingMap(new LinkedHashMap());
        Serialization.populateMultiset(this, objectInputStream, readCount);
    }
}
