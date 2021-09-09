package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.FlowableSubscriber;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.functions.BooleanSupplier;
import io.reactivex.internal.functions.ObjectHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.BackpressureHelper;
import io.reactivex.internal.util.QueueDrainHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public final class FlowableBuffer<T, C extends Collection<? super T>> extends AbstractFlowableWithUpstream<T, C> {
    final Callable<C> bufferSupplier;
    final int size;
    final int skip;

    public FlowableBuffer(Flowable<T> flowable, int i, int i2, Callable<C> callable) {
        super(flowable);
        this.size = i;
        this.skip = i2;
        this.bufferSupplier = callable;
    }

    public final void subscribeActual(Subscriber<? super C> subscriber) {
        int i = this.size;
        int i2 = this.skip;
        if (i == i2) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferExactSubscriber(subscriber, this.size, this.bufferSupplier));
        } else if (i2 > i) {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferSkipSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        } else {
            this.source.subscribe((FlowableSubscriber) new PublisherBufferOverlappingSubscriber(subscriber, this.size, this.skip, this.bufferSupplier));
        }
    }

    static final class PublisherBufferExactSubscriber<T, C extends Collection<? super T>> implements FlowableSubscriber<T>, Subscription {
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        Subscription upstream;

        PublisherBufferExactSubscriber(Subscriber<? super C> subscriber, int i, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.bufferSupplier = callable;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                this.upstream.request(BackpressureHelper.multiplyCap(j, (long) this.size));
            }
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

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: C
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
        public final void onNext(T r3) {
            /*
                r2 = this;
                boolean r0 = r2.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                C r0 = r2.buffer
                if (r0 != 0) goto L_0x0025
                java.util.concurrent.Callable<C> r0 = r2.bufferSupplier     // Catch:{ Throwable -> 0x001a }
                java.lang.Object r0 = r0.call()     // Catch:{ Throwable -> 0x001a }
                java.lang.String r1 = "The bufferSupplier returned a null buffer"
                java.lang.Object r0 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, r1)     // Catch:{ Throwable -> 0x001a }
                java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Throwable -> 0x001a }
                r2.buffer = r0
                goto L_0x0025
            L_0x001a:
                r3 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r3)
                r2.cancel()
                r2.onError(r3)
                return
            L_0x0025:
                r0.add(r3)
                int r3 = r2.index
                int r3 = r3 + 1
                int r1 = r2.size
                if (r3 != r1) goto L_0x003c
                r3 = 0
                r2.index = r3
                r3 = 0
                r2.buffer = r3
                org.reactivestreams.Subscriber<? super C> r3 = r2.downstream
                r3.onNext(r0)
                return
            L_0x003c:
                r2.index = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferExactSubscriber.onNext(java.lang.Object):void");
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
                C c = this.buffer;
                if (c != null && !c.isEmpty()) {
                    this.downstream.onNext(c);
                }
                this.downstream.onComplete();
            }
        }
    }

    static final class PublisherBufferSkipSubscriber<T, C extends Collection<? super T>> extends AtomicInteger implements FlowableSubscriber<T>, Subscription {
        private static final long serialVersionUID = -5616169793639412593L;
        C buffer;
        final Callable<C> bufferSupplier;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferSkipSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        public final void request(long j) {
            if (!SubscriptionHelper.validate(j)) {
                return;
            }
            if (get() != 0 || !compareAndSet(0, 1)) {
                this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, j));
                return;
            }
            this.upstream.request(BackpressureHelper.addCap(BackpressureHelper.multiplyCap(j, (long) this.size), BackpressureHelper.multiplyCap((long) (this.skip - this.size), j - 1)));
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

        /*  JADX ERROR: JadxRuntimeException in pass: MethodInvokeVisitor
            jadx.core.utils.exceptions.JadxRuntimeException: Not class type: C
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
        public final void onNext(T r4) {
            /*
                r3 = this;
                boolean r0 = r3.done
                if (r0 == 0) goto L_0x0005
                return
            L_0x0005:
                C r0 = r3.buffer
                int r1 = r3.index
                int r2 = r1 + 1
                if (r1 != 0) goto L_0x0029
                java.util.concurrent.Callable<C> r0 = r3.bufferSupplier     // Catch:{ Throwable -> 0x001e }
                java.lang.Object r0 = r0.call()     // Catch:{ Throwable -> 0x001e }
                java.lang.String r1 = "The bufferSupplier returned a null buffer"
                java.lang.Object r0 = io.reactivex.internal.functions.ObjectHelper.requireNonNull(r0, r1)     // Catch:{ Throwable -> 0x001e }
                java.util.Collection r0 = (java.util.Collection) r0     // Catch:{ Throwable -> 0x001e }
                r3.buffer = r0
                goto L_0x0029
            L_0x001e:
                r4 = move-exception
                io.reactivex.exceptions.Exceptions.throwIfFatal(r4)
                r3.cancel()
                r3.onError(r4)
                return
            L_0x0029:
                if (r0 == 0) goto L_0x003e
                r0.add(r4)
                int r4 = r0.size()
                int r1 = r3.size
                if (r4 != r1) goto L_0x003e
                r4 = 0
                r3.buffer = r4
                org.reactivestreams.Subscriber<? super C> r4 = r3.downstream
                r4.onNext(r0)
            L_0x003e:
                int r4 = r3.skip
                if (r2 != r4) goto L_0x0043
                r2 = 0
            L_0x0043:
                r3.index = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.reactivex.internal.operators.flowable.FlowableBuffer.PublisherBufferSkipSubscriber.onNext(java.lang.Object):void");
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffer = null;
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                C c = this.buffer;
                this.buffer = null;
                if (c != null) {
                    this.downstream.onNext(c);
                }
                this.downstream.onComplete();
            }
        }
    }

    static final class PublisherBufferOverlappingSubscriber<T, C extends Collection<? super T>> extends AtomicLong implements FlowableSubscriber<T>, BooleanSupplier, Subscription {
        private static final long serialVersionUID = -7370244972039324525L;
        final Callable<C> bufferSupplier;
        final ArrayDeque<C> buffers = new ArrayDeque<>();
        volatile boolean cancelled;
        boolean done;
        final Subscriber<? super C> downstream;
        int index;
        final AtomicBoolean once = new AtomicBoolean();
        long produced;
        final int size;
        final int skip;
        Subscription upstream;

        PublisherBufferOverlappingSubscriber(Subscriber<? super C> subscriber, int i, int i2, Callable<C> callable) {
            this.downstream = subscriber;
            this.size = i;
            this.skip = i2;
            this.bufferSupplier = callable;
        }

        public final boolean getAsBoolean() {
            return this.cancelled;
        }

        public final void request(long j) {
            if (SubscriptionHelper.validate(j)) {
                if (!QueueDrainHelper.postCompleteRequest(j, this.downstream, this.buffers, this, this)) {
                    if (this.once.get() || !this.once.compareAndSet(false, true)) {
                        this.upstream.request(BackpressureHelper.multiplyCap((long) this.skip, j));
                        return;
                    }
                    this.upstream.request(BackpressureHelper.addCap((long) this.size, BackpressureHelper.multiplyCap((long) this.skip, j - 1)));
                }
            }
        }

        public final void cancel() {
            this.cancelled = true;
            this.upstream.cancel();
        }

        public final void onSubscribe(Subscription subscription) {
            if (SubscriptionHelper.validate(this.upstream, subscription)) {
                this.upstream = subscription;
                this.downstream.onSubscribe(this);
            }
        }

        public final void onNext(T t) {
            if (!this.done) {
                ArrayDeque<C> arrayDeque = this.buffers;
                int i = this.index;
                int i2 = i + 1;
                if (i == 0) {
                    try {
                        arrayDeque.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null buffer"));
                    } catch (Throwable th) {
                        Exceptions.throwIfFatal(th);
                        cancel();
                        onError(th);
                        return;
                    }
                }
                Collection collection = (Collection) arrayDeque.peek();
                if (collection != null && collection.size() + 1 == this.size) {
                    arrayDeque.poll();
                    collection.add(t);
                    this.produced++;
                    this.downstream.onNext(collection);
                }
                Iterator<C> it = arrayDeque.iterator();
                while (it.hasNext()) {
                    ((Collection) it.next()).add(t);
                }
                if (i2 == this.skip) {
                    i2 = 0;
                }
                this.index = i2;
            }
        }

        public final void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.buffers.clear();
            this.downstream.onError(th);
        }

        public final void onComplete() {
            if (!this.done) {
                this.done = true;
                long j = this.produced;
                if (j != 0) {
                    BackpressureHelper.produced(this, j);
                }
                QueueDrainHelper.postComplete(this.downstream, this.buffers, this, this);
            }
        }
    }
}
