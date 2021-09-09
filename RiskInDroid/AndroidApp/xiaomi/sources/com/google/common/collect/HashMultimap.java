package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;

@GwtCompatible(emulated = true, serializable = true)
public final class HashMultimap<K, V> extends HashMultimapGwtSerializationDependencies<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    @VisibleForTesting
    transient int expectedValuesPerKey;

    public final /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
    }

    public final /* bridge */ /* synthetic */ void clear() {
        super.clear();
    }

    public final /* bridge */ /* synthetic */ boolean containsEntry(Object obj, Object obj2) {
        return super.containsEntry(obj, obj2);
    }

    public final /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    public final /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    public final /* bridge */ /* synthetic */ Set entries() {
        return super.entries();
    }

    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    public final /* bridge */ /* synthetic */ void forEach(BiConsumer biConsumer) {
        super.forEach(biConsumer);
    }

    public final /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        return super.keySet();
    }

    public final /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ boolean putAll(Multimap multimap) {
        return super.putAll(multimap);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ boolean putAll(Object obj, Iterable iterable) {
        return super.putAll(obj, iterable);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ Set removeAll(Object obj) {
        return super.removeAll(obj);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
     arg types: [java.lang.Object, java.lang.Iterable]
     candidates:
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
      com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection */
    @CanIgnoreReturnValue
    public final /* bridge */ /* synthetic */ Set replaceValues(Object obj, Iterable iterable) {
        return super.replaceValues(obj, iterable);
    }

    public final /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public final /* bridge */ /* synthetic */ Collection values() {
        return super.values();
    }

    public static <K, V> HashMultimap<K, V> create() {
        return new HashMultimap<>();
    }

    public static <K, V> HashMultimap<K, V> create(int i, int i2) {
        return new HashMultimap<>(i, i2);
    }

    public static <K, V> HashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        return new HashMultimap<>(multimap);
    }

    private HashMultimap() {
        this(12, 2);
    }

    private HashMultimap(int i, int i2) {
        super(Platform.newHashMapWithExpectedSize(i));
        this.expectedValuesPerKey = 2;
        Preconditions.checkArgument(i2 >= 0);
        this.expectedValuesPerKey = i2;
    }

    private HashMultimap(Multimap<? extends K, ? extends V> multimap) {
        super(Platform.newHashMapWithExpectedSize(multimap.keySet().size()));
        this.expectedValuesPerKey = 2;
        putAll(multimap);
    }

    /* access modifiers changed from: package-private */
    public final Set<V> createCollection() {
        return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        Serialization.writeMultimap(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.expectedValuesPerKey = 2;
        int readCount = Serialization.readCount(objectInputStream);
        setMap(Platform.newHashMapWithExpectedSize(12));
        Serialization.populateMultimap(this, objectInputStream, readCount);
    }
}
