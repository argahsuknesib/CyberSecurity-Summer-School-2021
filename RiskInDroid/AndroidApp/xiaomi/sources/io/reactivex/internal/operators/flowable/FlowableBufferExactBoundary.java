package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.queue.MpscLinkedQueue;
import io.reactivex.internal.subscribers.QueueDrainSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.subscribers.DisposableSubscriber;
import io.reactivex.subscribers.SerializedSubscriber;
import java.util.Collection;
import java.util.concurrent.Callable;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBufferExactBoundary<T, U extends Collection<? super T>, B> extends AbstractFlowableWithUpstream<T, U> {
    final Publisher<B> boundary;
    final Callable<U> bufferSupplier;

    public FlowableBufferExactBoundary(Flowable<T> flowable, Publisher<B> publisher, Callable<U> callable) {
        super(flowable);
        this.boundary = publisher;
        this.bufferSupplier = callable;
    }

    public final void subscribeActual(Subscriber<? super U> subscriber) {
        this.source.subscribe((FlowableSubscriber) new BufferExactBoundarySubscriber(new SerializedSubscriber(subscriber), this.bufferSupplier, this.boundary));
    }

    static final class BufferExactBoundarySubscriber<T, U extends Collection<? super T>, B> extends QueueDrainSubscriber<T, U, U> implements FlowableSubscriber<T>, Disposable, Subscription {
        final Publisher<B> boundary;
        U buffer;
        final Callable<U> bufferSupplier;
        Disposable other;
        Subscription upstream;

        BufferExactBoundarySubscriber(Subscriber<? super U> subscriber, Callable<U> callable, Publisher<B> publisher) {
            super(subscriber, new MpscLinkedQueue());
            this.bufferSupplier = callable;
            this.boundary = publisher;
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                try {
                    this.buffer = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                    BufferBoundarySubscriber bufferBoundarySubscriber = new BufferBoundarySubscriber(this);
                    this.other = bufferBoundarySubscriber;
                    this.downstream.onSubscribe(this);
                    if (!this.cancelled) {
                        subscription.request(Long.MAX_VALUE);
                        this.boundary.subscribe(bufferBoundarySubscriber);
                    }
                } catch (Throwable th) {
                    Exceptions.throwIfFatal(th);
                    this.cancelled = true;
                    subscription.cancel();
                    EmptySubscription.error(th, this.downstream);
                }
            }
        }

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: U
            	at jadx.core.dex.info.ClassInfo.checkClassType(ClassInfo.java:60)
            	at jadx.core.dex.info.ClassInfo.fromType(ClassInfo.java:31)
            	at jadx.core.dex.nodes.DexNode.resolveClass(DexNode.java:143)
            	at jadx.core.dex.nodes.RootNode.resolveClass(RootNode.java:183)
            	at jadx.core.dex.nodes.utils.MethodUtils.processMethodArgsOverloaded(MethodUtils.java:75)
            	at jadx.core.dex.nodes.utils.MethodUtils.collectOverloadedMethods(MethodUtils.java:54)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processOverloaded(MethodInvokeVisitor.java:108)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInvoke(MethodInvokeVisitor.java:101)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.processInsn(MethodInvokeVisitor.java:72)
            	at jadx.core.dex.visitors.MethodInvokeVisitor.visit(MethodInvokeVisitor.java:65)
            */
        public final void onNext(T r2) {
            /*
                r1 = this;
                monitor-enter(r1)
                U r0 = r1.buffer     // Catch:{ all -> 0x000c }
                if (r0 != 0) goto L_0x0007
                monitor-exit(r1)     // Catch:{ all -> 0x000c }
                return
            L_0x0007:
                r0.add(r2)     // Catch:{ all -> 0x000c }
                monitor-exit(r1)     // Catch:{ all -> 0x000c }
                return
            L_0x000c:
                r2 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x000c }
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBufferExactBoundary.BufferExactBoundarySubscriber.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            cancel();
            this.downstream.onError(th);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
            io.reactivex.internal.util.QueueDrainHelper.drainMaxLoop(r3.queue, r3.downstream, false, r3, r3);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:8:0x000b, code lost:
            r3.queue.offer(r0);
            r3.done = true;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
            if (enter() == false) goto L_?;
         */
        public final void onComplete() {
            synchronized (this) {
                U u = this.buffer;
                if (u != null) {
                    this.buffer = null;
                }
            }
        }

        public final void request(long j) {
            requested(j);
        }

        public final void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                this.other.dispose();
                this.upstream.cancel();
                if (enter()) {
                    this.queue.clear();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public final void next() {
            try {
                U u = (Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The buffer supplied is null");
                synchronized (this) {
                    U u2 = this.buffer;
                    if (u2 != null) {
                        this.buffer = u;
                        fastPathEmitMax(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                cancel();
                this.downstream.onError(th);
            }
        }

        public final void dispose() {
            cancel();
        }

        public final boolean isDisposed() {
            return this.cancelled;
        }

        public final boolean accept(Subscriber<? super U> subscriber, U u) {
            this.downstream.onNext(u);
            return true;
        }
    }

    static final class BufferBoundarySubscriber<T, U extends Collection<? super T>, B> extends DisposableSubscriber<B> {
        final BufferExactBoundarySubscriber<T, U, B> parent;

        BufferBoundarySubscriber(BufferExactBoundarySubscriber<T, U, B> bufferExactBoundarySubscriber) {
            this.parent = bufferExactBoundarySubscriber;
        }

        public final void onNext(B b) {
            this.parent.next();
        }

        public final void onError(Throwable th) {
            this.parent.onError(th);
        }

        public final void onComplete() {
            this.parent.onComplete();
        }
    }
}
