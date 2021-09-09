package _m_j;

import rx.Observable;
import rx.functions.Func1;
import rx.functions.Func2;

public final class dru<T, R> implements drr<T> {

    /* renamed from: O000000o  reason: collision with root package name */
    final Observable<R> f14882O000000o;
    final Func1<R, R> O00000Oo;

    public final /* synthetic */ Object call(Object obj) {
        Observable<R> observable = this.f14882O000000o;
        return ((Observable) obj).takeUntil(Observable.combineLatest(observable.take(1).map(this.O00000Oo), observable.skip(1), new Func2<T, T, Boolean>() {
            /* class _m_j.drt.AnonymousClass2 */

            public final /* synthetic */ Object call(Object obj, Object obj2) {
                return Boolean.valueOf(obj2.equals(obj));
            }
        }).onErrorReturn(drq.f14880O000000o).takeFirst(drq.O00000Oo));
    }

    public dru(Observable<R> observable, Func1<R, R> func1) {
        this.f14882O000000o = observable;
        this.O00000Oo = func1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        dru dru = (dru) obj;
        if (!this.f14882O000000o.equals(dru.f14882O000000o)) {
            return false;
        }
        return this.O00000Oo.equals(dru.O00000Oo);
    }

    public final int hashCode() {
        return (this.f14882O000000o.hashCode() * 31) + this.O00000Oo.hashCode();
    }

    public final String toString() {
        return "UntilCorrespondingEventObservableTransformer{sharedLifecycle=" + this.f14882O000000o + ", correspondingEvents=" + this.O00000Oo + '}';
    }
}
