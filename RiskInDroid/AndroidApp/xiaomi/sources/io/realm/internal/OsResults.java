package io.realm.internal;

import _m_j.iro;
import _m_j.irz;
import _m_j.isb;
import _m_j.isc;
import _m_j.ise;
import io.realm.internal.ObservableCollection;
import io.realm.internal.OsObject;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class OsResults implements isc, ObservableCollection {
    private static final long O0000O0o = nativeGetFinalizerPtr();

    /* renamed from: O000000o  reason: collision with root package name */
    public final long f15349O000000o;
    public final OsSharedRealm O00000Oo;
    protected boolean O00000o;
    final Table O00000o0;
    public boolean O00000oO = false;
    protected final ise<ObservableCollection.O00000Oo> O00000oo = new ise<>();
    private final isb O0000OOo;

    private static native Object nativeAggregate(long j, long j2, byte b);

    private static native void nativeClear(long j);

    private static native boolean nativeContains(long j, long j2);

    protected static native long nativeCreateResults(long j, long j2, SortDescriptor sortDescriptor, SortDescriptor sortDescriptor2);

    private static native long nativeCreateResultsFromBacklinks(long j, long j2, long j3, long j4);

    private static native long nativeCreateSnapshot(long j);

    private static native void nativeDelete(long j, long j2);

    private static native boolean nativeDeleteFirst(long j);

    private static native boolean nativeDeleteLast(long j);

    private static native long nativeDistinct(long j, SortDescriptor sortDescriptor);

    private static native void nativeEvaluateQueryIfNeeded(long j, boolean z);

    static native long nativeFirstRow(long j);

    private static native long nativeGetFinalizerPtr();

    private static native byte nativeGetMode(long j);

    private static native long nativeGetRow(long j, int i);

    private static native long nativeIndexOf(long j, long j2);

    static native boolean nativeIsValid(long j);

    private static native long nativeLastRow(long j);

    public static native long nativeSize(long j);

    private static native long nativeSort(long j, SortDescriptor sortDescriptor);

    private native void nativeStartListening(long j);

    private native void nativeStopListening(long j);

    private static native long nativeWhere(long j);

    public static abstract class O000000o<T> implements Iterator<T> {
        OsResults O00000Oo;
        protected int O00000o0 = -1;

        /* access modifiers changed from: protected */
        public abstract T O000000o(UncheckedRow uncheckedRow);

        public O000000o(OsResults osResults) {
            if (!osResults.O00000Oo.isClosed()) {
                this.O00000Oo = osResults;
                if (!osResults.O00000oO) {
                    if (osResults.O00000Oo.isInTransaction()) {
                        O000000o();
                    } else {
                        this.O00000Oo.O00000Oo.addIterator(this);
                    }
                }
            } else {
                throw new IllegalStateException("This Realm instance has already been closed, making it unusable.");
            }
        }

        public boolean hasNext() {
            O00000Oo();
            return ((long) (this.O00000o0 + 1)) < OsResults.nativeSize(this.O00000Oo.f15349O000000o);
        }

        public T next() {
            O00000Oo();
            this.O00000o0++;
            if (((long) this.O00000o0) < OsResults.nativeSize(this.O00000Oo.f15349O000000o)) {
                return O000000o(this.O00000o0);
            }
            throw new NoSuchElementException("Cannot access index " + this.O00000o0 + " when size is " + OsResults.nativeSize(this.O00000Oo.f15349O000000o) + ". Remember to check hasNext() before using next().");
        }

        @Deprecated
        public void remove() {
            throw new UnsupportedOperationException("remove() is not supported by RealmResults iterators.");
        }

        /* access modifiers changed from: package-private */
        public final void O000000o() {
            this.O00000Oo = this.O00000Oo.O000000o();
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            if (this.O00000Oo == null) {
                throw new ConcurrentModificationException("No outside changes to a Realm is allowed while iterating a living Realm collection.");
            }
        }

        /* access modifiers changed from: package-private */
        public final T O000000o(int i) {
            return O000000o(this.O00000Oo.O000000o(i));
        }
    }

    public static abstract class O00000Oo<T> extends O000000o<T> implements ListIterator<T> {
        public O00000Oo(OsResults osResults, int i) {
            super(osResults);
            if (i < 0 || ((long) i) > OsResults.nativeSize(this.O00000Oo.f15349O000000o)) {
                throw new IndexOutOfBoundsException("Starting location must be a valid index: [0, " + (OsResults.nativeSize(this.O00000Oo.f15349O000000o) - 1) + "]. Yours was " + i);
            }
            this.O00000o0 = i - 1;
        }

        @Deprecated
        public void add(T t) {
            throw new UnsupportedOperationException("Adding an element is not supported. Use Realm.createObject() instead.");
        }

        public boolean hasPrevious() {
            O00000Oo();
            return this.O00000o0 >= 0;
        }

        public int nextIndex() {
            O00000Oo();
            return this.O00000o0 + 1;
        }

        public T previous() {
            O00000Oo();
            try {
                this.O00000o0--;
                return O000000o(this.O00000o0);
            } catch (IndexOutOfBoundsException unused) {
                throw new NoSuchElementException("Cannot access index less than zero. This was " + this.O00000o0 + ". Remember to check hasPrevious() before using previous().");
            }
        }

        public int previousIndex() {
            O00000Oo();
            return this.O00000o0;
        }

        @Deprecated
        public void set(T t) {
            throw new UnsupportedOperationException("Replacing an element is not supported.");
        }
    }

    public enum Mode {
        EMPTY,
        TABLE,
        QUERY,
        LINKVIEW,
        TABLEVIEW;

        static Mode getByValue(byte b) {
            if (b == 0) {
                return EMPTY;
            }
            if (b == 1) {
                return TABLE;
            }
            if (b == 2) {
                return QUERY;
            }
            if (b == 3) {
                return LINKVIEW;
            }
            if (b == 4) {
                return TABLEVIEW;
            }
            throw new IllegalArgumentException("Invalid value: ".concat(String.valueOf((int) b)));
        }
    }

    private OsResults(OsSharedRealm osSharedRealm, Table table, long j) {
        boolean z = false;
        this.O00000Oo = osSharedRealm;
        this.O0000OOo = osSharedRealm.context;
        this.O00000o0 = table;
        this.f15349O000000o = j;
        this.O0000OOo.O000000o(this);
        this.O00000o = Mode.getByValue(nativeGetMode(this.f15349O000000o)) != Mode.QUERY ? true : z;
    }

    public final OsResults O000000o() {
        if (this.O00000oO) {
            return this;
        }
        OsResults osResults = new OsResults(this.O00000Oo, this.O00000o0, nativeCreateSnapshot(this.f15349O000000o));
        osResults.O00000oO = true;
        return osResults;
    }

    public long getNativePtr() {
        return this.f15349O000000o;
    }

    public long getNativeFinalizerPtr() {
        return O0000O0o;
    }

    public final UncheckedRow O000000o(int i) {
        return this.O00000o0.O00000o(nativeGetRow(this.f15349O000000o, i));
    }

    public final <T> void O000000o(T t, iro<T> iro) {
        this.O00000oo.O000000o(t, new ObservableCollection.O00000o0(iro));
        if (this.O00000oo.O000000o()) {
            nativeStopListening(this.f15349O000000o);
        }
    }

    public void notifyChangeListeners(long j) {
        OsCollectionChangeSet osCollectionChangeSet;
        if (j == 0) {
            osCollectionChangeSet = new irz(this.O00000Oo.isPartial());
        } else {
            osCollectionChangeSet = new OsCollectionChangeSet(j, !this.O00000o, null, this.O00000Oo.isPartial());
        }
        if (!osCollectionChangeSet.O0000O0o() || !this.O00000o) {
            this.O00000o = true;
            this.O00000oo.O000000o((ise.O000000o<OsObject.O00000Oo>) new ObservableCollection.O000000o(osCollectionChangeSet));
        }
    }

    public final boolean O00000Oo() {
        return this.O00000o;
    }
}
