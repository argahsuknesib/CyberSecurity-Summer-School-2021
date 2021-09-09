package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

@GwtCompatible(emulated = true, serializable = true)
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    @GwtIncompatible
    private static final long serialVersionUID = 1;
    public transient ValueEntry<K, V> multimapHeaderEntry;
    @VisibleForTesting
    transient int valueSetCapacity = 2;

    interface ValueSetLink<K, V> {
        ValueSetLink<K, V> getPredecessorInValueSet();

        ValueSetLink<K, V> getSuccessorInValueSet();

        void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink);

        void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink);
    }

    public final /* bridge */ /* synthetic */ Map asMap() {
        return super.asMap();
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

    public final /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    public final /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public static <K, V> LinkedHashMultimap<K, V> create() {
        return new LinkedHashMultimap<>(16, 2);
    }

    public static <K, V> LinkedHashMultimap<K, V> create(int i, int i2) {
        return new LinkedHashMultimap<>(Maps.capacity(i), Maps.capacity(i2));
    }

    public static <K, V> LinkedHashMultimap<K, V> create(Multimap<? extends K, ? extends V> multimap) {
        LinkedHashMultimap<K, V> create = create(multimap.keySet().size(), 2);
        create.putAll(multimap);
        return create;
    }

    public static <K, V> void succeedsInValueSet(ValueSetLink<K, V> valueSetLink, ValueSetLink<K, V> valueSetLink2) {
        valueSetLink.setSuccessorInValueSet(valueSetLink2);
        valueSetLink2.setPredecessorInValueSet(valueSetLink);
    }

    public static <K, V> void succeedsInMultimap(ValueEntry<K, V> valueEntry, ValueEntry<K, V> valueEntry2) {
        valueEntry.setSuccessorInMultimap(valueEntry2);
        valueEntry2.setPredecessorInMultimap(valueEntry);
    }

    public static <K, V> void deleteFromValueSet(ValueSetLink<K, V> valueSetLink) {
        succeedsInValueSet(valueSetLink.getPredecessorInValueSet(), valueSetLink.getSuccessorInValueSet());
    }

    public static <K, V> void deleteFromMultimap(ValueEntry<K, V> valueEntry) {
        succeedsInMultimap(valueEntry.getPredecessorInMultimap(), valueEntry.getSuccessorInMultimap());
    }

    @VisibleForTesting
    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {
        ValueEntry<K, V> nextInValueBucket;
        ValueEntry<K, V> predecessorInMultimap;
        ValueSetLink<K, V> predecessorInValueSet;
        final int smearedValueHash;
        ValueEntry<K, V> successorInMultimap;
        ValueSetLink<K, V> successorInValueSet;

        ValueEntry(K k, V v, int i, ValueEntry<K, V> valueEntry) {
            super(k, v);
            this.smearedValueHash = i;
            this.nextInValueBucket = valueEntry;
        }

        /* access modifiers changed from: package-private */
        public final boolean matchesValue(Object obj, int i) {
            return this.smearedValueHash == i && Objects.equal(getValue(), obj);
        }

        public final ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.predecessorInValueSet;
        }

        public final ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.successorInValueSet;
        }

        public final void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.predecessorInValueSet = valueSetLink;
        }

        public final void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.successorInValueSet = valueSetLink;
        }

        public final ValueEntry<K, V> getPredecessorInMultimap() {
            return this.predecessorInMultimap;
        }

        public final ValueEntry<K, V> getSuccessorInMultimap() {
            return this.successorInMultimap;
        }

        public final void setSuccessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.successorInMultimap = valueEntry;
        }

        public final void setPredecessorInMultimap(ValueEntry<K, V> valueEntry) {
            this.predecessorInMultimap = valueEntry;
        }
    }

    private LinkedHashMultimap(int i, int i2) {
        super(Platform.newLinkedHashMapWithExpectedSize(i));
        CollectPreconditions.checkNonnegative(i2, "expectedValuesPerKey");
        this.valueSetCapacity = i2;
        this.multimapHeaderEntry = new ValueEntry<>(null, null, 0, null);
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    /* access modifiers changed from: package-private */
    public final Set<V> createCollection() {
        return Platform.newLinkedHashSetWithExpectedSize(this.valueSetCapacity);
    }

    /* access modifiers changed from: package-private */
    public final Collection<V> createCollection(K k) {
        return new ValueSet(k, this.valueSetCapacity);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
     arg types: [K, java.lang.Iterable<? extends V>]
     candidates:
      com.google.common.collect.LinkedHashMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection
      com.google.common.collect.AbstractMapBasedMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.AbstractMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.Multimap.replaceValues(com.google.auto.common.BasicAnnotationProcessor$ProcessingStep, java.lang.Iterable<? extends com.google.auto.common.BasicAnnotationProcessor$ElementName>):java.util.Collection<V>
      com.google.common.collect.AbstractSetMultimap.replaceValues(java.lang.Object, java.lang.Iterable):java.util.Collection */
    @CanIgnoreReturnValue
    public final Set<V> replaceValues(K k, Iterable<? extends V> iterable) {
        return super.replaceValues((Object) k, (Iterable) iterable);
    }

    public final Set<Map.Entry<K, V>> entries() {
        return super.entries();
    }

    public final Set<K> keySet() {
        return super.keySet();
    }

    public final Collection<V> values() {
        return super.values();
    }

    @VisibleForTesting
    final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {
        public ValueSetLink<K, V> firstEntry;
        @VisibleForTesting
        ValueEntry<K, V>[] hashTable;
        private final K key;
        private ValueSetLink<K, V> lastEntry;
        public int modCount = 0;
        private int size = 0;

        ValueSet(K k, int i) {
            this.key = k;
            this.firstEntry = this;
            this.lastEntry = this;
            this.hashTable = new ValueEntry[Hashing.closedTableSize(i, 1.0d)];
        }

        private int mask() {
            return this.hashTable.length - 1;
        }

        public final ValueSetLink<K, V> getPredecessorInValueSet() {
            return this.lastEntry;
        }

        public final ValueSetLink<K, V> getSuccessorInValueSet() {
            return this.firstEntry;
        }

        public final void setPredecessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.lastEntry = valueSetLink;
        }

        public final void setSuccessorInValueSet(ValueSetLink<K, V> valueSetLink) {
            this.firstEntry = valueSetLink;
        }

        public final Iterator<V> iterator() {
            return new Iterator<V>() {
                /* class com.google.common.collect.LinkedHashMultimap.ValueSet.AnonymousClass1 */
                int expectedModCount = ValueSet.this.modCount;
                ValueSetLink<K, V> nextEntry = ValueSet.this.firstEntry;
                ValueEntry<K, V> toRemove;

                private void checkForComodification() {
                    if (ValueSet.this.modCount != this.expectedModCount) {
                        throw new ConcurrentModificationException();
                    }
                }

                public boolean hasNext() {
                    checkForComodification();
                    return this.nextEntry != ValueSet.this;
                }

                public V next() {
                    if (hasNext()) {
                        ValueEntry<K, V> valueEntry = (ValueEntry) this.nextEntry;
                        V value = valueEntry.getValue();
                        this.toRemove = valueEntry;
                        this.nextEntry = valueEntry.getSuccessorInValueSet();
                        return value;
                    }
                    throw new NoSuchElementException();
                }

                public void remove() {
                    checkForComodification();
                    CollectPreconditions.checkRemove(this.toRemove != null);
                    ValueSet.this.remove(this.toRemove.getValue());
                    this.expectedModCount = ValueSet.this.modCount;
                    this.toRemove = null;
                }
            };
        }

        public final void forEach(Consumer<? super V> consumer) {
            Preconditions.checkNotNull(consumer);
            for (ValueSetLink<K, V> valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                consumer.accept(((ValueEntry) valueSetLink).getValue());
            }
        }

        public final int size() {
            return this.size;
        }

        public final boolean contains(Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            for (ValueEntry<K, V> valueEntry = this.hashTable[mask() & smearedHash]; valueEntry != null; valueEntry = valueEntry.nextInValueBucket) {
                if (valueEntry.matchesValue(obj, smearedHash)) {
                    return true;
                }
            }
            return false;
        }

        public final boolean add(V v) {
            int smearedHash = Hashing.smearedHash(v);
            int mask = mask() & smearedHash;
            ValueEntry<K, V> valueEntry = this.hashTable[mask];
            for (ValueEntry<K, V> valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.nextInValueBucket) {
                if (valueEntry2.matchesValue(v, smearedHash)) {
                    return false;
                }
            }
            ValueEntry<K, V> valueEntry3 = new ValueEntry<>(this.key, v, smearedHash, valueEntry);
            LinkedHashMultimap.succeedsInValueSet(this.lastEntry, valueEntry3);
            LinkedHashMultimap.succeedsInValueSet(valueEntry3, this);
            LinkedHashMultimap.succeedsInMultimap(LinkedHashMultimap.this.multimapHeaderEntry.getPredecessorInMultimap(), valueEntry3);
            LinkedHashMultimap.succeedsInMultimap(valueEntry3, LinkedHashMultimap.this.multimapHeaderEntry);
            this.hashTable[mask] = valueEntry3;
            this.size++;
            this.modCount++;
            rehashIfNecessary();
            return true;
        }

        /* JADX INFO: additional move instructions added (1) to help type inference */
        private void rehashIfNecessary() {
            if (Hashing.needsResizing(this.size, this.hashTable.length, 1.0d)) {
                ValueEntry<K, V>[] valueEntryArr = new ValueEntry[(this.hashTable.length * 2)];
                this.hashTable = valueEntryArr;
                int length = valueEntryArr.length - 1;
                for (ValueSetLink valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                    ValueEntry<K, V> valueEntry = (ValueEntry) valueSetLink;
                    int i = valueEntry.smearedValueHash & length;
                    valueEntry.nextInValueBucket = valueEntryArr[i];
                    valueEntryArr[i] = valueEntry;
                }
            }
        }

        @CanIgnoreReturnValue
        public final boolean remove(Object obj) {
            int smearedHash = Hashing.smearedHash(obj);
            int mask = mask() & smearedHash;
            ValueEntry<K, V> valueEntry = this.hashTable[mask];
            ValueEntry<K, V> valueEntry2 = null;
            while (true) {
                ValueEntry<K, V> valueEntry3 = valueEntry2;
                valueEntry2 = valueEntry;
                ValueEntry<K, V> valueEntry4 = valueEntry3;
                if (valueEntry2 == null) {
                    return false;
                }
                if (valueEntry2.matchesValue(obj, smearedHash)) {
                    if (valueEntry4 == null) {
                        this.hashTable[mask] = valueEntry2.nextInValueBucket;
                    } else {
                        valueEntry4.nextInValueBucket = valueEntry2.nextInValueBucket;
                    }
                    LinkedHashMultimap.deleteFromValueSet(valueEntry2);
                    LinkedHashMultimap.deleteFromMultimap(valueEntry2);
                    this.size--;
                    this.modCount++;
                    return true;
                }
                valueEntry = valueEntry2.nextInValueBucket;
            }
        }

        public final void clear() {
            Arrays.fill(this.hashTable, (Object) null);
            this.size = 0;
            for (ValueSetLink<K, V> valueSetLink = this.firstEntry; valueSetLink != this; valueSetLink = valueSetLink.getSuccessorInValueSet()) {
                LinkedHashMultimap.deleteFromMultimap((ValueEntry) valueSetLink);
            }
            LinkedHashMultimap.succeedsInValueSet(this, this);
            this.modCount++;
        }
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Map.Entry<K, V>> entryIterator() {
        return new Iterator<Map.Entry<K, V>>() {
            /* class com.google.common.collect.LinkedHashMultimap.AnonymousClass1 */
            ValueEntry<K, V> nextEntry = LinkedHashMultimap.this.multimapHeaderEntry.successorInMultimap;
            ValueEntry<K, V> toRemove;

            public boolean hasNext() {
                return this.nextEntry != LinkedHashMultimap.this.multimapHeaderEntry;
            }

            public Map.Entry<K, V> next() {
                if (hasNext()) {
                    ValueEntry<K, V> valueEntry = this.nextEntry;
                    this.toRemove = valueEntry;
                    this.nextEntry = valueEntry.successorInMultimap;
                    return valueEntry;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                CollectPreconditions.checkRemove(this.toRemove != null);
                LinkedHashMultimap.this.remove(this.toRemove.getKey(), this.toRemove.getValue());
                this.toRemove = null;
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<Map.Entry<K, V>> entrySpliterator() {
        return Spliterators.spliterator(entries(), 17);
    }

    /* access modifiers changed from: package-private */
    public final Iterator<V> valueIterator() {
        return Maps.valueIterator(entryIterator());
    }

    /* access modifiers changed from: package-private */
    public final Spliterator<V> valueSpliterator() {
        return CollectSpliterators.map(entrySpliterator(), $$Lambda$73uG8GvDFSgCg7ViZNTbzvdqilI.INSTANCE);
    }

    public final void clear() {
        super.clear();
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        for (Object writeObject : keySet()) {
            objectOutputStream.writeObject(writeObject);
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : entries()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.multimapHeaderEntry = new ValueEntry<>(null, null, 0, null);
        ValueEntry<K, V> valueEntry = this.multimapHeaderEntry;
        succeedsInMultimap(valueEntry, valueEntry);
        this.valueSetCapacity = 2;
        int readInt = objectInputStream.readInt();
        Map newLinkedHashMapWithExpectedSize = Platform.newLinkedHashMapWithExpectedSize(12);
        for (int i = 0; i < readInt; i++) {
            Object readObject = objectInputStream.readObject();
            newLinkedHashMapWithExpectedSize.put(readObject, createCollection(readObject));
        }
        int readInt2 = objectInputStream.readInt();
        for (int i2 = 0; i2 < readInt2; i2++) {
            Object readObject2 = objectInputStream.readObject();
            ((Collection) newLinkedHashMapWithExpectedSize.get(readObject2)).add(objectInputStream.readObject());
        }
        setMap(newLinkedHashMapWithExpectedSize);
    }
}
