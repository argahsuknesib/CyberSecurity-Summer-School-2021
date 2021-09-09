package _m_j;

import io.realm.OrderedRealmCollection;
import io.realm.internal.InvalidRow;
import io.realm.internal.OsResults;
import io.realm.internal.UncheckedRow;
import java.util.AbstractList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

abstract class irl<E> extends AbstractList<E> implements OrderedRealmCollection<E> {

    /* renamed from: O000000o  reason: collision with root package name */
    final irf f1587O000000o;
    final Class<E> O00000Oo;
    final OsResults O00000o;
    final String O00000o0;

    public boolean contains(Object obj) {
        if (!O000000o() || ((obj instanceof isg) && ((isg) obj).O000000o().O00000Oo == InvalidRow.INSTANCE)) {
            return false;
        }
        Iterator it = iterator();
        while (it.hasNext()) {
            if (it.next().equals(obj)) {
                return true;
            }
        }
        return false;
    }

    public E get(int i) {
        this.f1587O000000o.O00000o();
        return this.f1587O000000o.O000000o(this.O00000Oo, this.O00000o0, this.O00000o.O000000o(i));
    }

    public Iterator<E> iterator() {
        return new O000000o();
    }

    public ListIterator<E> listIterator() {
        return new O00000Oo(0);
    }

    public ListIterator<E> listIterator(int i) {
        return new O00000Oo(i);
    }

    public int size() {
        if (!O000000o()) {
            return 0;
        }
        long nativeSize = OsResults.nativeSize(this.O00000o.f15349O000000o);
        if (nativeSize > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) nativeSize;
    }

    @Deprecated
    public E remove(int i) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public E set(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean add(E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public void add(int i, E e) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    @Deprecated
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("This method is not supported by 'RealmResults' or 'OrderedRealmCollectionSnapshot'.");
    }

    class O000000o extends OsResults.O000000o<E> {
        O000000o() {
            super(irl.this.O00000o);
        }

        public final E O000000o(UncheckedRow uncheckedRow) {
            return irl.this.f1587O000000o.O000000o(irl.this.O00000Oo, irl.this.O00000o0, uncheckedRow);
        }
    }

    class O00000Oo extends OsResults.O00000Oo<E> {
        O00000Oo(int i) {
            super(irl.this.O00000o, i);
        }

        public final E O000000o(UncheckedRow uncheckedRow) {
            return irl.this.f1587O000000o.O000000o(irl.this.O00000Oo, irl.this.O00000o0, uncheckedRow);
        }
    }
}
