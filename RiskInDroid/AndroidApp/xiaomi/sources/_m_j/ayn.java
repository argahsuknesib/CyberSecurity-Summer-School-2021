package _m_j;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.Subject;

final class ayn<I> extends DisposableObserver<I> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Subject<I> f12707O000000o;

    public ayn(Subject<I> subject) {
        this.f12707O000000o = subject;
    }

    public final void onNext(I i) {
        this.f12707O000000o.onNext(i);
    }

    public final void onError(Throwable th) {
        throw new IllegalStateException("View intents must not throw errors", th);
    }

    public final void onComplete() {
        this.f12707O000000o.onComplete();
    }
}
