package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import rx.Observable;
import rx.Producer;
import rx.Subscriber;

public final class OnSubscribeRange implements Observable.OnSubscribe<Integer> {
    private final int endIndex;
    private final int startIndex;

    public final /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber<? super Integer>) ((Subscriber) obj));
    }

    public OnSubscribeRange(int i, int i2) {
        this.startIndex = i;
        this.endIndex = i2;
    }

    public final void call(Subscriber<? super Integer> subscriber) {
        subscriber.setProducer(new RangeProducer(subscriber, this.startIndex, this.endIndex));
    }

    static final class RangeProducer extends AtomicLong implements Producer {
        private static final long serialVersionUID = 4114392207069098388L;
        private final Subscriber<? super Integer> childSubscriber;
        private long currentIndex;
        private final int endOfRange;

        RangeProducer(Subscriber<? super Integer> subscriber, int i, int i2) {
            this.childSubscriber = subscriber;
            this.currentIndex = (long) i;
            this.endOfRange = i2;
        }

        public final void request(long j) {
            if (get() != Long.MAX_VALUE) {
                if (j == Long.MAX_VALUE && compareAndSet(0, Long.MAX_VALUE)) {
                    fastPath();
                } else if (j > 0 && BackpressureUtils.getAndAddRequest(this, j) == 0) {
                    slowPath(j);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void slowPath(long j) {
            long j2 = ((long) this.endOfRange) + 1;
            long j3 = this.currentIndex;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            long j4 = j3;
            long j5 = j;
            do {
                long j6 = 0;
                while (true) {
                    if (j6 == j5 || j4 == j2) {
                        if (!subscriber.isUnsubscribed()) {
                            if (j4 == j2) {
                                subscriber.onCompleted();
                                return;
                            }
                            j5 = get();
                            if (j5 == j6) {
                                this.currentIndex = j4;
                                j5 = addAndGet(-j6);
                            }
                        } else {
                            return;
                        }
                    } else if (!subscriber.isUnsubscribed()) {
                        subscriber.onNext(Integer.valueOf((int) j4));
                        j4++;
                        j6++;
                    } else {
                        return;
                    }
                }
            } while (j5 != 0);
        }

        /* access modifiers changed from: package-private */
        public final void fastPath() {
            long j = ((long) this.endOfRange) + 1;
            Subscriber<? super Integer> subscriber = this.childSubscriber;
            long j2 = this.currentIndex;
            while (j2 != j) {
                if (!subscriber.isUnsubscribed()) {
                    subscriber.onNext(Integer.valueOf((int) j2));
                    j2++;
                } else {
                    return;
                }
            }
            if (!subscriber.isUnsubscribed()) {
                subscriber.onCompleted();
            }
        }
    }
}
