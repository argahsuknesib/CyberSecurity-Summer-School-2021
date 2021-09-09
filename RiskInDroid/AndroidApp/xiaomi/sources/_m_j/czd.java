package _m_j;

import android.annotation.TargetApi;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Consumer;

public final class czd<T> extends AbstractList<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    public final LinkedList<O000000o<T>> f14396O000000o;
    private final int O00000Oo;

    private czd() {
        this.f14396O000000o = new LinkedList<>();
        this.O00000Oo = 0;
    }

    public czd(byte b) {
        this();
    }

    public final boolean O000000o(T t, int i) {
        O000000o o000000o = new O000000o(t, i);
        if (this.f14396O000000o.isEmpty()) {
            this.f14396O000000o.add(o000000o);
            return true;
        }
        ListIterator<O000000o<T>> listIterator = this.f14396O000000o.listIterator();
        while (listIterator.hasNext()) {
            if (listIterator.next().f14397O000000o < i) {
                listIterator.previous();
                listIterator.add(o000000o);
                return true;
            }
        }
        this.f14396O000000o.addLast(o000000o);
        return true;
    }

    @Deprecated
    public final void add(int i, T t) {
        throw new UnsupportedOperationException("不支持添加到指定位置");
    }

    public final boolean add(T t) {
        return O000000o(t, this.O00000Oo);
    }

    public final boolean remove(Object obj) {
        Iterator<O000000o<T>> it = this.f14396O000000o.iterator();
        while (it.hasNext()) {
            if (it.next().O00000Oo == obj) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public final int size() {
        return this.f14396O000000o.size();
    }

    public final T get(int i) {
        return this.f14396O000000o.get(i).O00000Oo;
    }

    public final T set(int i, T t) {
        O000000o o000000o = this.f14396O000000o.get(i);
        T t2 = o000000o.O00000Oo;
        o000000o.O00000Oo = t;
        return t2;
    }

    public final Iterator<T> iterator() {
        return new O00000Oo(this);
    }

    static class O000000o<T> {

        /* renamed from: O000000o  reason: collision with root package name */
        int f14397O000000o;
        T O00000Oo;

        O000000o(T t, int i) {
            this.O00000Oo = t;
            this.f14397O000000o = i;
        }
    }

    class O00000Oo implements Iterator<T> {
        private final ListIterator<O000000o<T>> O00000Oo;

        public O00000Oo(czd czd) {
            this((byte) 0);
        }

        private O00000Oo(byte b) {
            this.O00000Oo = czd.this.f14396O000000o.listIterator(0);
        }

        public final boolean hasNext() {
            return this.O00000Oo.hasNext();
        }

        public final T next() {
            return this.O00000Oo.next().O00000Oo;
        }

        public final void remove() {
            this.O00000Oo.remove();
        }

        @TargetApi(24)
        public final void forEachRemaining(final Consumer<? super T> consumer) {
            this.O00000Oo.forEachRemaining(new Consumer<O000000o<T>>() {
                /* class _m_j.czd.O00000Oo.AnonymousClass1 */

                public final /* bridge */ /* synthetic */ void accept(Object obj) {
                    consumer.accept(((O000000o) obj).O00000Oo);
                }
            });
        }
    }
}
