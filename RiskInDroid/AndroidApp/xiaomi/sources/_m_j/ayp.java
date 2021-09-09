package _m_j;

import _m_j.ays;
import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.Subject;
import io.reactivex.subjects.UnicastSubject;
import java.util.ArrayList;
import java.util.List;

public abstract class ayp<V extends ays, VS> implements ayq<V, VS> {

    /* renamed from: O000000o  reason: collision with root package name */
    public O00000o0<V, VS> f12709O000000o;
    private final BehaviorSubject<VS> O00000Oo = BehaviorSubject.create();
    private List<ayp<V, VS>.O000000o<?>> O00000o = new ArrayList(4);
    private boolean O00000o0 = false;
    private CompositeDisposable O00000oO;
    private Disposable O00000oo;
    private Disposable O0000O0o;
    private boolean O0000OOo = true;

    public interface O00000Oo<V extends ays, I> {
        Observable<I> bind(V v);
    }

    public interface O00000o0<V extends ays, VS> {
        void accept(V v, VS vs);
    }

    /* access modifiers changed from: protected */
    public abstract void O00000o0();

    class O000000o<I> {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Subject<I> f12711O000000o;
        public final O00000Oo<V, I> O00000Oo;

        public O000000o(Subject<I> subject, O00000Oo<V, I> o00000Oo) {
            this.f12711O000000o = subject;
            this.O00000Oo = o00000Oo;
        }
    }

    public ayp() {
        O00000o();
    }

    public final void O000000o(final V v) {
        if (this.O0000OOo) {
            O00000o0();
        }
        O00000o0<V, VS> o00000o0 = this.f12709O000000o;
        if (o00000o0 != null) {
            if (v == null) {
                throw new NullPointerException("View is null");
            } else if (o00000o0 != null) {
                this.O00000oo = this.O00000Oo.subscribe(new Consumer<VS>() {
                    /* class _m_j.ayp.AnonymousClass1 */

                    public final void accept(VS vs) throws Exception {
                        ayp.this.f12709O000000o.accept(v, vs);
                    }
                });
            } else {
                throw new NullPointerException(O00000o0.class.getSimpleName() + " is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
            }
        }
        int size = this.O00000o.size();
        int i = 0;
        while (i < size) {
            O000000o o000000o = this.O00000o.get(i);
            if (v == null) {
                throw new NullPointerException("View is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
            } else if (o000000o != null) {
                Subject<I> subject = o000000o.f12711O000000o;
                if (subject != null) {
                    O00000Oo<V, I> o00000Oo = o000000o.O00000Oo;
                    if (o00000Oo != null) {
                        Observable<I> bind = o00000Oo.bind(v);
                        if (bind != null) {
                            if (this.O00000oO == null) {
                                this.O00000oO = new CompositeDisposable();
                            }
                            this.O00000oO.add((Disposable) bind.subscribeWith(new ayn(subject)));
                            i++;
                        } else {
                            throw new NullPointerException("Intent Observable returned from Binder " + o00000Oo + " is null");
                        }
                    } else {
                        throw new NullPointerException(O00000Oo.class.getSimpleName() + " is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
                    }
                } else {
                    throw new NullPointerException("IntentRelay from binderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
                }
            } else {
                throw new NullPointerException("IntentRelayBinderPair is null. This is a Mosby internal bug. Please file an issue at https://github.com/sockeqwe/mosby/issues");
            }
        }
        this.O0000OOo = false;
    }

    public final void O000000o() {
        Disposable disposable = this.O00000oo;
        if (disposable != null) {
            disposable.dispose();
            this.O00000oo = null;
        }
        CompositeDisposable compositeDisposable = this.O00000oO;
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
            this.O00000oO = null;
        }
    }

    public final void O00000Oo() {
        Disposable disposable = this.O0000O0o;
        if (disposable != null) {
            disposable.dispose();
        }
        O00000o();
    }

    private void O00000o() {
        this.O0000OOo = true;
        this.O00000o.clear();
        this.O00000o0 = false;
    }

    /* access modifiers changed from: protected */
    public final void O000000o(Observable<VS> observable, O00000o0<V, VS> o00000o0) {
        if (!this.O00000o0) {
            this.O00000o0 = true;
            if (observable == null) {
                throw new NullPointerException("ViewState Observable is null");
            } else if (o00000o0 != null) {
                this.f12709O000000o = o00000o0;
                this.O0000O0o = (Disposable) observable.subscribeWith(new ayo(this.O00000Oo));
            } else {
                throw new NullPointerException("ViewStateBinder is null");
            }
        } else {
            throw new IllegalStateException("subscribeViewState() method is only allowed to be called once");
        }
    }

    /* access modifiers changed from: protected */
    public final <I> Observable<I> O000000o(O00000Oo<V, I> o00000Oo) {
        UnicastSubject create = UnicastSubject.create();
        this.O00000o.add(new O000000o(create, o00000Oo));
        return create;
    }
}
