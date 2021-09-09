package io.reactivex.internal.operators.parallel;

import io.reactivex.exceptions.CompositeException;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;
import io.reactivex.internal.fuseable.ConditionalSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.parallel.ParallelFailureHandling;
import io.reactivex.parallel.ParallelFlowable;
import io.reactivex.plugins.RxJavaPlugins;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class ParallelDoOnNextTry<T> extends ParallelFlowable<T> {
    final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
    final Consumer<? super T> onNext;
    final ParallelFlowable<T> source;

    public ParallelDoOnNextTry(ParallelFlowable<T> parallelFlowable, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
        this.source = parallelFlowable;
        this.onNext = consumer;
        this.errorHandler = biFunction;
    }

    public final void subscribe(Subscriber<? super T>[] subscriberArr) {
        if (validate(subscriberArr)) {
            int length = subscriberArr.length;
            Subscriber[] subscriberArr2 = new Subscriber[length];
            for (int i = 0; i < length; i++) {
                Subscriber<? super T> subscriber = subscriberArr[i];
                if (subscriber instanceof ConditionalSubscriber) {
                    subscriberArr2[i] = new ParallelDoOnNextConditionalSubscriber((ConditionalSubscriber) subscriber, this.onNext, this.errorHandler);
                } else {
                    subscriberArr2[i] = new ParallelDoOnNextSubscriber(subscriber, this.onNext, this.errorHandler);
                }
            }
            this.source.subscribe(subscriberArr2);
        }
    }

    public final int parallelism() {
        return this.source.parallelism();
    }

    static final class ParallelDoOnNextSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final Subscriber<? super T> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription upstream;

        ParallelDoOnNextSubscriber(Subscriber<? super T> subscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.downstream = subscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        public final void request(long j) {
            this.upstream.request(j);
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!tryOnNext(t)) {
                this.upstream.request(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:16:0x003a  */
        public final boolean tryOnNext(T t) {
            int i;
            if (this.done) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.onNext.accept(t);
                    this.downstream.onNext(t);
                    return true;
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(new CompositeException(th, th));
                    return false;
                }
            } while (i != 1);
            if (i != 2) {
                if (i != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }

    /* renamed from: io.reactivex.internal.operators.parallel.ParallelDoOnNextTry$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$reactivex$parallel$ParallelFailureHandling = new int[ParallelFailureHandling.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|8) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        static {
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.RETRY.ordinal()] = 1;
            $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.SKIP.ordinal()] = 2;
            try {
                $SwitchMap$io$reactivex$parallel$ParallelFailureHandling[ParallelFailureHandling.STOP.ordinal()] = 3;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    static final class ParallelDoOnNextConditionalSubscriber<T> implements ConditionalSubscriber<T>, Subscription {
        boolean done;
        final ConditionalSubscriber<? super T> downstream;
        final BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> errorHandler;
        final Consumer<? super T> onNext;
        Subscription upstream;

        ParallelDoOnNextConditionalSubscriber(ConditionalSubscriber<? super T> conditionalSubscriber, Consumer<? super T> consumer, BiFunction<? super Long, ? super Throwable, ParallelFailureHandling> biFunction) {
            this.downstream = conditionalSubscriber;
            this.onNext = consumer;
            this.errorHandler = biFunction;
        }

        public final void request(long j) {
            this.upstream.request(j);
        }

        public final void cancel() {
            this.upstream.cancel();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!tryOnNext(t) && !this.done) {
                this.upstream.request(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:15:0x003b  */
        public final boolean tryOnNext(T t) {
            int i;
            if (this.done) {
                return false;
            }
            long j = 0;
            do {
                try {
                    this.onNext.accept(t);
                    return this.downstream.tryOnNext(t);
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    cancel();
                    onError(new CompositeException(th, th));
                    return false;
                }
            } while (i != 1);
            if (i != 2) {
                if (i != 3) {
                    cancel();
                    onError(th);
                    return false;
                }
                cancel();
                onComplete();
            }
            return false;
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                this.downstream.onComplete();
            }
        }
    }
}
