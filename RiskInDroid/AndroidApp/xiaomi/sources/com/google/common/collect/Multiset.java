package com.google.common.collect;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.CompatibleWith;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.ObjIntConsumer;

@GwtCompatible
public interface Multiset<E> extends Collection<E> {

    public interface Entry<E> {
        boolean equals(Object obj);

        int getCount();

        E getElement();

        int hashCode();

        String toString();
    }

    @CanIgnoreReturnValue
    int add(E e, int i);

    @CanIgnoreReturnValue
    boolean add(E e);

    boolean contains(Object obj);

    boolean containsAll(Collection<?> collection);

    int count(@CompatibleWith("E") Object obj);

    Set<E> elementSet();

    Set<Entry<E>> entrySet();

    boolean equals(Object obj);

    void forEach(Consumer<? super E> consumer);

    @Beta
    void forEachEntry(ObjIntConsumer<? super E> objIntConsumer);

    int hashCode();

    Iterator<E> iterator();

    @CanIgnoreReturnValue
    int remove(@CompatibleWith("E") Object obj, int i);

    @CanIgnoreReturnValue
    boolean remove(Object obj);

    @CanIgnoreReturnValue
    boolean removeAll(Collection<?> collection);

    @CanIgnoreReturnValue
    boolean retainAll(Collection<?> collection);

    @CanIgnoreReturnValue
    int setCount(E e, int i);

    @CanIgnoreReturnValue
    boolean setCount(E e, int i, int i2);

    int size();

    Spliterator<E> spliterator();

    String toString();

    /* renamed from: com.google.common.collect.Multiset$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        @Beta
        public static void $default$forEachEntry(Multiset _this, ObjIntConsumer objIntConsumer) {
            Preconditions.checkNotNull(objIntConsumer);
            _this.entrySet().forEach(new Consumer(objIntConsumer) {
                /* class com.google.common.collect.$$Lambda$Multiset$y63SmnatRR1Ke2x1fqDeFclRelQ */
                private final /* synthetic */ ObjIntConsumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    this.f$0.accept(((Multiset.Entry) obj).getElement(), ((Multiset.Entry) obj).getCount());
                }
            });
        }

        public static void $default$forEach(Multiset _this, Consumer consumer) {
            Preconditions.checkNotNull(consumer);
            _this.entrySet().forEach(new Consumer(consumer) {
                /* class com.google.common.collect.$$Lambda$Multiset$yTxkVZMQHaYOoZD4ry_up4hmmvA */
                private final /* synthetic */ Consumer f$0;

                {
                    this.f$0 = r1;
                }

                public final void accept(Object obj) {
                    Multiset.CC.lambda$forEach$1(this.f$0, (Multiset.Entry) obj);
                }
            });
        }

        public static /* synthetic */ void lambda$forEach$1(Consumer consumer, Entry entry) {
            Object element = entry.getElement();
            int count = entry.getCount();
            for (int i = 0; i < count; i++) {
                consumer.accept(element);
            }
        }

        public static Spliterator $default$spliterator(Multiset _this) {
            return Multisets.spliteratorImpl(_this);
        }
    }
}
