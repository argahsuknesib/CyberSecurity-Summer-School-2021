package _m_j;

import io.reactivex.observers.DisposableObserver;
import io.reactivex.subjects.BehaviorSubject;

final class ayo<VS> extends DisposableObserver<VS> {

    /* renamed from: O000000o  reason: collision with root package name */
    private final BehaviorSubject<VS> f12708O000000o;

    public final void onComplete() {
    }

    public ayo(BehaviorSubject<VS> behaviorSubject) {
        this.f12708O000000o = behaviorSubject;
    }

    public final void onNext(VS vs) {
        this.f12708O000000o.onNext(vs);
    }

    public final void onError(Throwable th) {
        throw new IllegalStateException("ViewState observable must not reach error state - onError()", th);
    }
}
