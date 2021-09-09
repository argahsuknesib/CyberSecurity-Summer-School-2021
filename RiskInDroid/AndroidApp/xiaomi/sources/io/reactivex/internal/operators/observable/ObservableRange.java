package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

public final class ObservableRange extends Observable<Integer> {
    private final long end;
    private final int start;

    public ObservableRange(int i, int i2) {
        this.start = i;
        this.end = ((long) i) + ((long) i2);
    }

    public final void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, (long) this.start, this.end);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }

    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Integer> downstream;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Integer> observer, long j, long j2) {
            this.downstream = observer;
            this.index = j;
            this.end = j2;
        }

        /* access modifiers changed from: package-private */
        public final void run() {
            if (!this.fused) {
                Observer<? super Integer> observer = this.downstream;
                long j = this.end;
                for (long j2 = this.index; j2 != j && get() == 0; j2++) {
                    observer.onNext(Integer.valueOf((int) j2));
                }
                if (get() == 0) {
                    lazySet(1);
                    observer.onComplete();
                }
            }
        }

        @Nullable
        public final Integer poll() throws Exception {
            long j = this.index;
            if (j != this.end) {
                this.index = 1 + j;
                return Integer.valueOf((int) j);
            }
            lazySet(1);
            return null;
        }

        public final boolean isEmpty() {
            return this.index == this.end;
        }

        public final void clear() {
            this.index = this.end;
            lazySet(1);
        }

        public final void dispose() {
            set(1);
        }

        public final boolean isDisposed() {
            return get() != 0;
        }

        public final int requestFusion(int i) {
            if ((i & 1) == 0) {
                return 0;
            }
            this.fused = true;
            return 1;
        }
    }
}
