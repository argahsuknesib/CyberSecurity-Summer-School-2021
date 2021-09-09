package androidx.lifecycle;

import _m_j.ew;
import _m_j.fa;
import _m_j.fh;
import _m_j.o0O00000;
import _m_j.o0OoO00O;
import androidx.lifecycle.Lifecycle;
import java.util.Iterator;
import java.util.Map;

public abstract class LiveData<T> {
    static final Object NOT_SET = new Object();
    int mActiveCount = 0;
    private volatile Object mData;
    final Object mDataLock = new Object();
    private boolean mDispatchInvalidated;
    private boolean mDispatchingValue;
    private o0OoO00O<fh<? super T>, LiveData<T>.O00000Oo> mObservers = new o0OoO00O<>();
    volatile Object mPendingData;
    private final Runnable mPostValueRunnable;
    private int mVersion;

    /* access modifiers changed from: protected */
    public void onActive() {
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
    }

    public LiveData() {
        Object obj = NOT_SET;
        this.mData = obj;
        this.mPendingData = obj;
        this.mVersion = -1;
        this.mPostValueRunnable = new Runnable() {
            /* class androidx.lifecycle.LiveData.AnonymousClass1 */

            public final void run() {
                Object obj;
                synchronized (LiveData.this.mDataLock) {
                    obj = LiveData.this.mPendingData;
                    LiveData.this.mPendingData = LiveData.NOT_SET;
                }
                LiveData.this.setValue(obj);
            }
        };
    }

    private void considerNotify(LiveData<T>.O00000Oo o00000Oo) {
        if (o00000Oo.O00000o) {
            if (!o00000Oo.O000000o()) {
                o00000Oo.O000000o(false);
                return;
            }
            int i = o00000Oo.O00000oO;
            int i2 = this.mVersion;
            if (i < i2) {
                o00000Oo.O00000oO = i2;
                o00000Oo.O00000o0.onChanged(this.mData);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void dispatchingValue(LiveData<T>.O00000Oo o00000Oo) {
        if (this.mDispatchingValue) {
            this.mDispatchInvalidated = true;
            return;
        }
        this.mDispatchingValue = true;
        do {
            this.mDispatchInvalidated = false;
            if (o00000Oo == null) {
                o0OoO00O<K, V>.O00000o O000000o2 = this.mObservers.O000000o();
                while (O000000o2.hasNext()) {
                    considerNotify((O00000Oo) ((Map.Entry) O000000o2.next()).getValue());
                    if (this.mDispatchInvalidated) {
                        break;
                    }
                }
            } else {
                considerNotify(o00000Oo);
                o00000Oo = null;
            }
        } while (this.mDispatchInvalidated);
        this.mDispatchingValue = false;
    }

    public void observe(fa faVar, fh<? super T> fhVar) {
        assertMainThread("observe");
        if (faVar.getLifecycle().O000000o() != Lifecycle.State.DESTROYED) {
            LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(faVar, fhVar);
            O00000Oo O000000o2 = this.mObservers.O000000o(fhVar, lifecycleBoundObserver);
            if (O000000o2 != null && !O000000o2.O000000o(faVar)) {
                throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
            } else if (O000000o2 == null) {
                faVar.getLifecycle().O000000o(lifecycleBoundObserver);
            }
        }
    }

    public void observeForever(fh<? super T> fhVar) {
        assertMainThread("observeForever");
        O000000o o000000o = new O000000o(fhVar);
        O00000Oo O000000o2 = this.mObservers.O000000o(fhVar, o000000o);
        if (O000000o2 != null && (O000000o2 instanceof LifecycleBoundObserver)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        } else if (O000000o2 == null) {
            o000000o.O000000o(true);
        }
    }

    public void removeObserver(fh<? super T> fhVar) {
        assertMainThread("removeObserver");
        O00000Oo O00000Oo2 = this.mObservers.O00000Oo(fhVar);
        if (O00000Oo2 != null) {
            O00000Oo2.O00000Oo();
            O00000Oo2.O000000o(false);
        }
    }

    public void removeObservers(fa faVar) {
        assertMainThread("removeObservers");
        Iterator<Map.Entry<fh<? super T>, LiveData<T>.O00000Oo>> it = this.mObservers.iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (((O00000Oo) next.getValue()).O000000o(faVar)) {
                removeObserver((fh) next.getKey());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void postValue(T t) {
        boolean z;
        synchronized (this.mDataLock) {
            z = this.mPendingData == NOT_SET;
            this.mPendingData = t;
        }
        if (z) {
            o0O00000.O000000o().O00000Oo(this.mPostValueRunnable);
        }
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        assertMainThread("setValue");
        this.mVersion++;
        this.mData = t;
        dispatchingValue(null);
    }

    public T getValue() {
        T t = this.mData;
        if (t != NOT_SET) {
            return t;
        }
        return null;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public boolean hasObservers() {
        return this.mObservers.O00000oO > 0;
    }

    public boolean hasActiveObservers() {
        return this.mActiveCount > 0;
    }

    class LifecycleBoundObserver extends LiveData<T>.O00000Oo implements ew {

        /* renamed from: O000000o  reason: collision with root package name */
        final fa f2882O000000o;

        LifecycleBoundObserver(fa faVar, fh<? super T> fhVar) {
            super(fhVar);
            this.f2882O000000o = faVar;
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return this.f2882O000000o.getLifecycle().O000000o().isAtLeast(Lifecycle.State.STARTED);
        }

        public final void O000000o(fa faVar, Lifecycle.Event event) {
            if (this.f2882O000000o.getLifecycle().O000000o() == Lifecycle.State.DESTROYED) {
                LiveData.this.removeObserver(this.O00000o0);
            } else {
                O000000o(O000000o());
            }
        }

        /* access modifiers changed from: package-private */
        public final boolean O000000o(fa faVar) {
            return this.f2882O000000o == faVar;
        }

        /* access modifiers changed from: package-private */
        public final void O00000Oo() {
            this.f2882O000000o.getLifecycle().O00000Oo(this);
        }
    }

    abstract class O00000Oo {
        boolean O00000o;
        final fh<? super T> O00000o0;
        int O00000oO = -1;

        /* access modifiers changed from: package-private */
        public abstract boolean O000000o();

        /* access modifiers changed from: package-private */
        public boolean O000000o(fa faVar) {
            return false;
        }

        /* access modifiers changed from: package-private */
        public void O00000Oo() {
        }

        O00000Oo(fh<? super T> fhVar) {
            this.O00000o0 = fhVar;
        }

        /* access modifiers changed from: package-private */
        public final void O000000o(boolean z) {
            if (z != this.O00000o) {
                this.O00000o = z;
                int i = 1;
                boolean z2 = LiveData.this.mActiveCount == 0;
                LiveData liveData = LiveData.this;
                int i2 = liveData.mActiveCount;
                if (!this.O00000o) {
                    i = -1;
                }
                liveData.mActiveCount = i2 + i;
                if (z2 && this.O00000o) {
                    LiveData.this.onActive();
                }
                if (LiveData.this.mActiveCount == 0 && !this.O00000o) {
                    LiveData.this.onInactive();
                }
                if (this.O00000o) {
                    LiveData.this.dispatchingValue(this);
                }
            }
        }
    }

    class O000000o extends LiveData<T>.O00000Oo {
        /* access modifiers changed from: package-private */
        public final boolean O000000o() {
            return true;
        }

        O000000o(fh<? super T> fhVar) {
            super(fhVar);
        }
    }

    private static void assertMainThread(String str) {
        if (!o0O00000.O000000o().f2228O000000o.O00000Oo()) {
            throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
        }
    }
}
