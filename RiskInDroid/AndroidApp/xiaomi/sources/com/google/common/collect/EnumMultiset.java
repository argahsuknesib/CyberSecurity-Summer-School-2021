package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.Enum;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.function.ObjIntConsumer;

@GwtCompatible(emulated = true)
public final class EnumMultiset<E extends Enum<E>> extends AbstractMultiset<E> implements Serializable {
    @GwtIncompatible
    private static final long serialVersionUID = 0;
    public transient int[] counts = new int[this.enumConstants.length];
    public transient int distinctElements;
    public transient E[] enumConstants;
    public transient long size;
    private transient Class<E> type;

    public final /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    public final /* bridge */ /* synthetic */ Set elementSet() {
        return super.elementSet();
    }

    public final /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    public final /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Class<E> cls) {
        return new EnumMultiset<>(cls);
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable) {
        Iterator<E> it = iterable.iterator();
        Preconditions.checkArgument(it.hasNext(), "EnumMultiset constructor passed empty Iterable");
        EnumMultiset<E> enumMultiset = new EnumMultiset<>(((Enum) it.next()).getDeclaringClass());
        Iterables.addAll(enumMultiset, iterable);
        return enumMultiset;
    }

    public static <E extends Enum<E>> EnumMultiset<E> create(Iterable<E> iterable, Class<E> cls) {
        EnumMultiset<E> create = create(cls);
        Iterables.addAll(create, iterable);
        return create;
    }

    private EnumMultiset(Class<E> cls) {
        this.type = cls;
        Preconditions.checkArgument(cls.isEnum());
        this.enumConstants = (Enum[]) cls.getEnumConstants();
    }

    private boolean isActuallyE(Object obj) {
        if (obj instanceof Enum) {
            E e = (Enum) obj;
            int ordinal = e.ordinal();
            E[] eArr = this.enumConstants;
            if (ordinal >= eArr.length || eArr[ordinal] != e) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void checkIsE(Object obj) {
        Preconditions.checkNotNull(obj);
        if (!isActuallyE(obj)) {
            throw new ClassCastException("Expected an " + this.type + " but got " + obj);
        }
    }

    /* access modifiers changed from: package-private */
    public final int distinctElements() {
        return this.distinctElements;
    }

    public final int size() {
        return Ints.saturatedCast(this.size);
    }

    public final int count(Object obj) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        return this.counts[((Enum) obj).ordinal()];
    }

    @CanIgnoreReturnValue
    public final int add(E e, int i) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(e);
        }
        int ordinal = e.ordinal();
        int i2 = this.counts[ordinal];
        long j = (long) i;
        long j2 = ((long) i2) + j;
        Preconditions.checkArgument(j2 <= 2147483647L, "too many occurrences: %s", j2);
        this.counts[ordinal] = (int) j2;
        if (i2 == 0) {
            this.distinctElements++;
        }
        this.size += j;
        return i2;
    }

    @CanIgnoreReturnValue
    public final int remove(Object obj, int i) {
        if (obj == null || !isActuallyE(obj)) {
            return 0;
        }
        Enum enumR = (Enum) obj;
        CollectPreconditions.checkNonnegative(i, "occurrences");
        if (i == 0) {
            return count(obj);
        }
        int ordinal = enumR.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        if (i2 == 0) {
            return 0;
        }
        if (i2 <= i) {
            iArr[ordinal] = 0;
            this.distinctElements--;
            this.size -= (long) i2;
        } else {
            iArr[ordinal] = i2 - i;
            this.size -= (long) i;
        }
        return i2;
    }

    @CanIgnoreReturnValue
    public final int setCount(E e, int i) {
        checkIsE(e);
        CollectPreconditions.checkNonnegative(i, "count");
        int ordinal = e.ordinal();
        int[] iArr = this.counts;
        int i2 = iArr[ordinal];
        iArr[ordinal] = i;
        this.size += (long) (i - i2);
        if (i2 == 0 && i > 0) {
            this.distinctElements++;
        } else if (i2 > 0 && i == 0) {
            this.distinctElements--;
        }
        return i2;
    }

    public final void clear() {
        Arrays.fill(this.counts, 0);
        this.size = 0;
        this.distinctElements = 0;
    }

    abstract class Itr<T> implements Iterator<T> {
        int index = 0;
        int toRemove = -1;

        /* access modifiers changed from: package-private */
        public abstract T output(int i);

        Itr() {
        }

        public boolean hasNext() {
            while (this.index < EnumMultiset.this.enumConstants.length) {
                int[] iArr = EnumMultiset.this.counts;
                int i = this.index;
                if (iArr[i] > 0) {
                    return true;
                }
                this.index = i + 1;
            }
            return false;
        }

        public T next() {
            if (hasNext()) {
                T output = output(this.index);
                int i = this.index;
                this.toRemove = i;
                this.index = i + 1;
                return output;
            }
            throw new NoSuchElementException();
        }

        public void remove() {
            CollectPreconditions.checkRemove(this.toRemove >= 0);
            if (EnumMultiset.this.counts[this.toRemove] > 0) {
                EnumMultiset.this.distinctElements--;
                EnumMultiset.this.size -= (long) EnumMultiset.this.counts[this.toRemove];
                EnumMultiset.this.counts[this.toRemove] = 0;
            }
            this.toRemove = -1;
        }
    }

    /* access modifiers changed from: package-private */
    public final Iterator<E> elementIterator() {
        return new EnumMultiset<E>.Itr<E>() {
            /* class com.google.common.collect.EnumMultiset.AnonymousClass1 */

            /* access modifiers changed from: package-private */
            public E output(int i) {
                return EnumMultiset.this.enumConstants[i];
            }
        };
    }

    /* access modifiers changed from: package-private */
    public final Iterator<Multiset.Entry<E>> entryIterator() {
        return new EnumMultiset<E>.Itr<Multiset.Entry<E>>() {
            /* class com.google.common.collect.EnumMultiset.AnonymousClass2 */

            /* access modifiers changed from: package-private */
            public Multiset.Entry<E> output(final int i) {
                return new Multisets.AbstractEntry<E>() {
                    /* class com.google.common.collect.EnumMultiset.AnonymousClass2.AnonymousClass1 */

                    public E getElement() {
                        return EnumMultiset.this.enumConstants[i];
                    }

                    public int getCount() {
                        return EnumMultiset.this.counts[i];
                    }
                };
            }
        };
    }

    public final void forEachEntry(ObjIntConsumer<? super E> objIntConsumer) {
        Preconditions.checkNotNull(objIntConsumer);
        int i = 0;
        while (true) {
            E[] eArr = this.enumConstants;
            if (i < eArr.length) {
                int[] iArr = this.counts;
                if (iArr[i] > 0) {
                    objIntConsumer.accept(eArr[i], iArr[i]);
                }
                i++;
            } else {
                return;
            }
        }
    }

    public final Iterator<E> iterator() {
        return Multisets.iteratorImpl(this);
    }

    @GwtIncompatible
    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.type);
        Serialization.writeMultiset(this, objectOutputStream);
    }

    @GwtIncompatible
    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.type = (Class) objectInputStream.readObject();
        this.enumConstants = (Enum[]) this.type.getEnumConstants();
        this.counts = new int[this.enumConstants.length];
        Serialization.populateMultiset(this, objectInputStream);
    }
}
