package com.xiaomi.mico.common.util;

import _m_j.bni;
import _m_j.bnj;
import _m_j.bnm;
import android.view.View;
import com.jakewharton.rxbinding.internal.Functions;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

public class RxUtil {
    public static Subscription debounceClick(View view, Action1<Void> action1) {
        return bnj.O000000o(view).throttleFirst(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(action1);
    }

    public static class RetryWithDelay implements Func1<Observable<? extends Throwable>, Observable<?>> {
        public int maxRetries;
        public int retryCount;
        public final int retryDelayMillis;
        public boolean stop;

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable<? extends Throwable>) ((Observable) obj));
        }

        public RetryWithDelay(int i) {
            this(i, Integer.MAX_VALUE);
        }

        public RetryWithDelay(int i, int i2) {
            this.stop = true;
            this.retryDelayMillis = i;
            this.maxRetries = i2;
            this.retryCount = 0;
        }

        public RetryWithDelay(int i, boolean z) {
            this.stop = true;
            this.retryDelayMillis = i;
            this.stop = z;
        }

        public synchronized void resetRetryCount() {
            this.retryCount = 0;
        }

        public Observable<?> call(Observable<? extends Throwable> observable) {
            return observable.flatMap(new Func1<Throwable, Observable<?>>() {
                /* class com.xiaomi.mico.common.util.RxUtil.RetryWithDelay.AnonymousClass1 */

                public Observable<?> call(Throwable th) {
                    synchronized (this) {
                        RetryWithDelay retryWithDelay = RetryWithDelay.this;
                        int i = retryWithDelay.retryCount + 1;
                        retryWithDelay.retryCount = i;
                        if (i > RetryWithDelay.this.maxRetries) {
                            if (RetryWithDelay.this.stop) {
                                Observable<?> error = Observable.error(th);
                                return error;
                            }
                        }
                        Observable<Long> timer = Observable.timer((long) RetryWithDelay.this.retryDelayMillis, TimeUnit.MILLISECONDS);
                        return timer;
                    }
                }
            });
        }
    }

    public static class RepeatWithDelay implements Func1<Observable<? extends Void>, Observable<?>> {
        private final int repeatDelayMillis;

        public /* bridge */ /* synthetic */ Object call(Object obj) {
            return call((Observable<? extends Void>) ((Observable) obj));
        }

        public RepeatWithDelay(int i) {
            this.repeatDelayMillis = i;
        }

        public Observable<?> call(Observable<? extends Void> observable) {
            return observable.delay((long) this.repeatDelayMillis, TimeUnit.MILLISECONDS);
        }
    }

    public static Subscription debounceLongClick(View view, Action1<Void> action1) {
        bni.O000000o(view, "view == null");
        return Observable.create(new bnm(view, Functions.f4502O000000o)).throttleFirst(200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(action1);
    }
}
