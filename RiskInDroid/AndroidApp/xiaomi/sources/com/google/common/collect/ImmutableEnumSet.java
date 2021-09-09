package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Spliterator;
import java.util.function.Consumer;

@GwtCompatible(emulated = true, serializable = true)
final class ImmutableEnumSet<E extends Enum<E>> extends ImmutableSet<E> {
    private final transient EnumSet<E> delegate;
    @LazyInit
    private transient int hashCode;

    /* access modifiers changed from: package-private */
    public final boolean isHashCodeFast() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean isPartialView() {
        return false;
    }

    static ImmutableSet asImmutable(EnumSet enumSet) {
        int size = enumSet.size();
        if (size == 0) {
            return ImmutableSet.of();
        }
        if (size != 1) {
            return new ImmutableEnumSet(enumSet);
        }
        return ImmutableSet.of(Iterables.getOnlyElement(enumSet));
    }

    private ImmutableEnumSet(EnumSet<E> enumSet) {
        this.delegate = enumSet;
    }

    public final UnmodifiableIterator<E> iterator() {
        return Iterators.unmodifiableIterator(this.delegate.iterator());
    }

    public final Spliterator<E> spliterator() {
        return this.delegate.spliterator();
    }

    public final void forEach(Consumer<? super E> consumer) {
        this.delegate.forEach(consumer);
    }

    public final int size() {
        return this.delegate.size();
    }

    public final boolean contains(Object obj) {
        return this.delegate.contains(obj);
    }

    public final boolean containsAll(Collection<?> collection) {
        if (collection instanceof ImmutableEnumSet) {
            collection = ((ImmutableEnumSet) collection).delegate;
        }
        return this.delegate.containsAll(collection);
    }

    public final boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof ImmutableEnumSet) {
            obj = ((ImmutableEnumSet) obj).delegate;
        }
        return this.delegate.equals(obj);
    }

    public final int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode2 = this.delegate.hashCode();
        this.hashCode = hashCode2;
        return hashCode2;
    }

    public final String toString() {
        return this.delegate.toString();
    }

    /* access modifiers changed from: package-private */
    public final Object writeReplace() {
        return new EnumSerializedForm(this.delegate);
    }

    static class EnumSerializedForm<E extends Enum<E>> implements Serializable {
        private static final long serialVersionUID = 0;
        final EnumSet<E> delegate;

        EnumSerializedForm(EnumSet<E> enumSet) {
            this.delegate = enumSet;
        }

        /* access modifiers changed from: package-private */
        public Object readResolve() {
            return new ImmutableEnumSet(this.delegate.clone());
        }
    }
}
