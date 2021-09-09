package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public static <T> TestSubject<T> create(TestScheduler testScheduler) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        subjectSubscriptionManager.onAdded = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            /* class rx.subjects.TestSubject.AnonymousClass1 */

            public final void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onTerminated = subjectSubscriptionManager.onAdded;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    protected TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
        this.innerScheduler = testScheduler.createWorker();
    }

    public final void onCompleted() {
        onCompleted(0);
    }

    /* access modifiers changed from: package-private */
    public final void internalOnCompleted() {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver onCompleted : this.state.terminate(NotificationLite.completed())) {
                onCompleted.onCompleted();
            }
        }
    }

    public final void onCompleted(long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass2 */

            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public final void onError(Throwable th) {
        onError(th, 0);
    }

    /* access modifiers changed from: package-private */
    public final void internalOnError(Throwable th) {
        if (this.state.active) {
            for (SubjectSubscriptionManager.SubjectObserver onError : this.state.terminate(NotificationLite.error(th))) {
                onError.onError(th);
            }
        }
    }

    public final void onError(final Throwable th, long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass3 */

            public void call() {
                TestSubject.this.internalOnError(th);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public final void onNext(T t) {
        onNext(t, 0);
    }

    /* access modifiers changed from: package-private */
    public final void internalOnNext(T t) {
        for (SubjectSubscriptionManager.SubjectObserver onNext : this.state.observers()) {
            onNext.onNext(t);
        }
    }

    public final void onNext(final T t, long j) {
        this.innerScheduler.schedule(new Action0() {
            /* class rx.subjects.TestSubject.AnonymousClass4 */

            public void call() {
                TestSubject.this.internalOnNext(t);
            }
        }, j, TimeUnit.MILLISECONDS);
    }

    public final boolean hasObservers() {
        return this.state.observers().length > 0;
    }
}
