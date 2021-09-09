package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.ObjIntConsumer;
import java.util.function.ToIntFunction;
import java.util.stream.Collector;

@GwtCompatible(emulated = true, serializable = true)
public abstract class ImmutableMultiset<E> extends ImmutableMultisetGwtSerializationDependencies<E> implements Multiset<E> {
    @LazyInit
    private transient ImmutableList<E> asList;
    @LazyInit
    private transient ImmutableSet<Multiset.Entry<E>> entrySet;

    static /* synthetic */ int lambda$toImmutableMultiset$0(Object obj) {
        return 1;
    }

    public abstract ImmutableSet<E> elementSet();

    public /* synthetic */ void forEach(Consumer<? super E> consumer) {
        Multiset.CC.$default$forEach(this, consumer);
    }

    @Beta
    public /* synthetic */ void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Multiset.CC.$default$forEachEntry(this, objIntConsumer);
    }

    /* access modifiers changed from: package-private */
    public abstract Multiset.Entry<E> getEntry(int i);

    @Beta
    public static <E> Collector<E, ?, ImmutableMultiset<E>> toImmutableMultiset() {
        return toImmutableMultiset(Function.identity(), $$Lambda$ImmutableMultiset$JJf8NPYu83yBjje2WFshZ7ZBwE4.INSTANCE);
    }

    public static <T, E> Collector<T, ?, ImmutableMultiset<E>> toImmutableMultiset(Function<? super T, ? extends E> function, ToIntFunction<? super T> toIntFunction) {
        Preconditions.checkNotNull(function);
        Preconditions.checkNotNull(toIntFunction);
        return Collector.of($$Lambda$D3oviQ9ZA_OVdxA685lwkI5pkC8.INSTANCE, new BiConsumer(function, toIntFunction) {
            /* class com.google.common.collect.$$Lambda$ImmutableMultiset$cy0Z8rAObePzXL2euPXiCV274ho */
            private final /* synthetic */ Function f$0;
            private final /* synthetic */ ToIntFunction f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void accept(Object obj, Object obj2) {
                ((Multiset) obj).add(Preconditions.checkNotNull(this.f$0.apply(obj2)), this.f$1.applyAsInt(obj2));
            }
        }, $$Lambda$ImmutableMultiset$ndF2gsjcu9kVYBgBq_5wPZ70vMw.INSTANCE, $$Lambda$ImmutableMultiset$s1fzqZ423wPivj1TGcrW6ks4lo.INSTANCE, new Collector.Characteristics[0]);
    }

    public static <E> ImmutableMultiset<E> of() {
        return RegularImmutableMultiset.EMPTY;
    }

    public static <E> ImmutableMultiset<E> of(E e) {
        return copyFromElements(e);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2) {
        return copyFromElements(e, e2);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3) {
        return copyFromElements(e, e2, e3);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4) {
        return copyFromElements(e, e2, e3, e4);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5) {
        return copyFromElements(e, e2, e3, e4, e5);
    }

    public static <E> ImmutableMultiset<E> of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        return new Builder().add((Object) e).add((Object) e2).add((Object) e3).add((Object) e4).add((Object) e5).add((Object) e6).add((Object[]) eArr).build();
    }

    public static <E> ImmutableMultiset<E> copyOf(Object[] objArr) {
        return copyFromElements(objArr);
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterable iterable) {
        Multiset multiset;
        if (iterable instanceof ImmutableMultiset) {
            ImmutableMultiset<E> immutableMultiset = (ImmutableMultiset) iterable;
            if (!immutableMultiset.isPartialView()) {
                return immutableMultiset;
            }
        }
        if (iterable instanceof Multiset) {
            multiset = Multisets.cast(iterable);
        } else {
            multiset = LinkedHashMultiset.create(iterable);
        }
        return copyFromEntries(multiset.entrySet());
    }

    public static <E> ImmutableMultiset<E> copyOf(Iterator it) {
        LinkedHashMultiset create = LinkedHashMultiset.create();
        Iterators.addAll(create, it);
        return copyFromEntries(create.entrySet());
    }

    private static <E> ImmutableMultiset<E> copyFromElements(E... eArr) {
        LinkedHashMultiset create = LinkedHashMultiset.create();
        Collections.addAll(create, eArr);
        return copyFromEntries(create.entrySet());
    }

    /* access modifiers changed from: package-private */
    public static <E> ImmutableMultiset<E> copyFromEntries(Collection<? extends Multiset.Entry<? extends E>> collection) {
        if (collection.isEmpty()) {
            return of();
        }
        return RegularImmutableMultiset.create(collection);
    }

    ImmutableMultiset() {
    }

    public UnmodifiableIterator<E> iterator() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<E>() {
            /* class com.google.common.collect.ImmutableMultiset.AnonymousClass1 */
            E element;
            int remaining;

            public boolean hasNext() {
                return this.remaining > 0 || it.hasNext();
            }

            public E next() {
                if (this.remaining <= 0) {
                    Multiset.Entry entry = (Multiset.Entry) it.next();
                    this.element = entry.getElement();
                    this.remaining = entry.getCount();
                }
                this.remaining--;
                return this.element;
            }
        };
    }

    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> asList2 = super.asList();
        this.asList = asList2;
        return asList2;
    }

    public boolean contains(Object obj) {
        return count(obj) > 0;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final int add(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final int remove(Object obj, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final int setCount(E e, int i) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean setCount(E e, int i, int i2) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public int copyIntoArray(Object[] objArr, int i) {
        UnmodifiableIterator it = entrySet().iterator();
        while (it.hasNext()) {
            Multiset.Entry entry = (Multiset.Entry) it.next();
            Arrays.fill(objArr, i, entry.getCount() + i, entry.getElement());
            i += entry.getCount();
        }
        return i;
    }

    public boolean equals(Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    public int hashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    public String toString() {
        return entrySet().toString();
    }

    public ImmutableSet<Multiset.Entry<E>> entrySet() {
        ImmutableSet<Multiset.Entry<E>> immutableSet = this.entrySet;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet<Multiset.Entry<E>> createEntrySet = createEntrySet();
        this.entrySet = createEntrySet;
        return createEntrySet;
    }

    private ImmutableSet<Multiset.Entry<E>> createEntrySet() {
        return isEmpty() ? ImmutableSet.of() : new EntrySet();
    }

    final class EntrySet extends IndexedImmutableSet<Multiset.Entry<E>> {
        private static final long serialVersionUID = 0;

        private EntrySet() {
        }

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return ImmutableMultiset.this.isPartialView();
        }

        /* access modifiers changed from: package-private */
        public final Multiset.Entry<E> get(int i) {
            return ImmutableMultiset.this.getEntry(i);
        }

        public final int size() {
            return ImmutableMultiset.this.elementSet().size();
        }

        public final boolean contains(Object obj) {
            if (obj instanceof Multiset.Entry) {
                Multiset.Entry entry = (Multiset.Entry) obj;
                if (entry.getCount() > 0 && ImmutableMultiset.this.count(entry.getElement()) == entry.getCount()) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            return ImmutableMultiset.this.hashCode();
        }

        /* access modifiers changed from: package-private */
        @GwtIncompatible
        public final Object writeReplace() {
            return new EntrySetSerializedForm(ImmutableMultiset.this);
        }
    }

    @GwtIncompatible
    static class EntrySetSerializedForm<E> implements Serializable {
        final ImmutableMultiset<E> multiset;

        EntrySetSerializedForm(ImmutableMultiset<E> immutableMultiset) {
            this.multiset = immutableMultiset;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return this.multiset.entrySet();
        }
    }

    /* access modifiers changed from: package-private */
    @GwtIncompatible
    public Object writeReplace() {
        return new SerializedForm(this);
    }

    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    public static class Builder<E> extends ImmutableCollection.Builder<E> {
        final Multiset<E> contents;

        public Builder() {
            this(LinkedHashMultiset.create());
        }

        Builder(Multiset<E> multiset) {
            this.contents = multiset;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E e) {
            this.contents.add(Preconditions.checkNotNull(e));
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> add(E... eArr) {
            super.add((Object[]) eArr);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addCopies(E e, int i) {
            this.contents.add(Preconditions.checkNotNull(e), i);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> setCount(E e, int i) {
            this.contents.setCount(Preconditions.checkNotNull(e), i);
            return this;
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            if (iterable instanceof Multiset) {
                Multisets.cast(iterable).forEachEntry(new ObjIntConsumer() {
                    /* class com.google.common.collect.$$Lambda$ImmutableMultiset$Builder$0dZxvnrCmvkaP7ZFJlyDwgYrsIg */

                    public final void accept(Object obj, int i) {
                        ImmutableMultiset.Builder.this.lambda$addAll$0$ImmutableMultiset$Builder(obj, i);
                    }
                });
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        public /* synthetic */ void lambda$addAll$0$ImmutableMultiset$Builder(Object obj, int i) {
            this.contents.add(Preconditions.checkNotNull(obj), i);
        }

        @CanIgnoreReturnValue
        public Builder<E> addAll(Iterator<? extends E> it) {
            super.addAll((Iterator) it);
            return this;
        }

        public ImmutableMultiset<E> build() {
            return ImmutableMultiset.copyOf(this.contents);
        }

        /* access modifiers changed from: package-private */
        @VisibleForTesting
        public ImmutableMultiset<E> buildJdkBacked() {
            if (this.contents.isEmpty()) {
                return ImmutableMultiset.of();
            }
            return JdkBackedImmutableMultiset.create(this.contents.entrySet());
        }
    }

    static final class ElementSet<E> extends ImmutableSet.Indexed<E> {
        private final Multiset<E> delegate;
        private final List<Multiset.Entry<E>> entries;

        /* access modifiers changed from: package-private */
        public final boolean isPartialView() {
            return true;
        }

        ElementSet(List<Multiset.Entry<E>> list, Multiset<E> multiset) {
            this.entries = list;
            this.delegate = multiset;
        }

        /* access modifiers changed from: package-private */
        public final E get(int i) {
            return this.entries.get(i).getElement();
        }

        public final boolean contains(Object obj) {
            return this.delegate.contains(obj);
        }

        public final int size() {
            return this.entries.size();
        }
    }

    static final class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final int[] counts;
        final Object[] elements;

        SerializedForm(Multiset<?> multiset) {
            int size = multiset.entrySet().size();
            this.elements = new Object[size];
            this.counts = new int[size];
            int i = 0;
            for (Multiset.Entry next : multiset.entrySet()) {
                this.elements[i] = next.getElement();
                this.counts[i] = next.getCount();
                i++;
            }
        }

        /* access modifiers changed from: package-private */
        public final Object readResolve() {
            LinkedHashMultiset create = LinkedHashMultiset.create(this.elements.length);
            int i = 0;
            while (true) {
                Object[] objArr = this.elements;
                if (i >= objArr.length) {
                    return ImmutableMultiset.copyOf(create);
                }
                create.add(objArr[i], this.counts[i]);
                i++;
            }
        }
    }
}
