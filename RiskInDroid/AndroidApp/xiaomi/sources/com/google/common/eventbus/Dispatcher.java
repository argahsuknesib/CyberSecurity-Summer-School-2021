package com.google.common.eventbus;

import com.google.common.base.Preconditions;
import com.google.common.collect.Queues;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

abstract class Dispatcher {
    /* access modifiers changed from: package-private */
    public abstract void dispatch(Object obj, Iterator<Subscriber> it);

    Dispatcher() {
    }

    static Dispatcher perThreadDispatchQueue() {
        return new PerThreadQueuedDispatcher();
    }

    static Dispatcher legacyAsync() {
        return new LegacyAsyncDispatcher();
    }

    static Dispatcher immediate() {
        return ImmediateDispatcher.INSTANCE;
    }

    static final class PerThreadQueuedDispatcher extends Dispatcher {
        private final ThreadLocal<Boolean> dispatching;
        private final ThreadLocal<Queue<Event>> queue;

        private PerThreadQueuedDispatcher() {
            this.queue = new ThreadLocal<Queue<Event>>() {
                /* class com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.AnonymousClass1 */

                /* access modifiers changed from: protected */
                public Queue<Event> initialValue() {
                    return Queues.newArrayDeque();
                }
            };
            this.dispatching = new ThreadLocal<Boolean>() {
                /* class com.google.common.eventbus.Dispatcher.PerThreadQueuedDispatcher.AnonymousClass2 */

                /* access modifiers changed from: protected */
                public Boolean initialValue() {
                    return Boolean.FALSE;
                }
            };
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x004a A[SYNTHETIC] */
        /* JADX WARNING: Removed duplicated region for block: B:6:0x0034 A[Catch:{ all -> 0x0055 }, LOOP:1: B:6:0x0034->B:8:0x003c, LOOP_START] */
        public final void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            Preconditions.checkNotNull(it);
            Queue queue2 = this.queue.get();
            queue2.offer(new Event(obj, it));
            if (!this.dispatching.get().booleanValue()) {
                this.dispatching.set(Boolean.TRUE);
                while (true) {
                    try {
                        Event event = (Event) queue2.poll();
                        if (event == null) {
                            while (true) {
                                if (event.subscribers.hasNext()) {
                                    event.subscribers.next().dispatchEvent(event.event);
                                }
                            }
                            Event event2 = (Event) queue2.poll();
                            if (event2 == null) {
                                return;
                            }
                        }
                    } finally {
                        this.dispatching.remove();
                        this.queue.remove();
                    }
                }
            }
        }

        static final class Event {
            public final Object event;
            public final Iterator<Subscriber> subscribers;

            private Event(Object obj, Iterator<Subscriber> it) {
                this.event = obj;
                this.subscribers = it;
            }
        }
    }

    static final class LegacyAsyncDispatcher extends Dispatcher {
        private final ConcurrentLinkedQueue<EventWithSubscriber> queue;

        private LegacyAsyncDispatcher() {
            this.queue = Queues.newConcurrentLinkedQueue();
        }

        /* access modifiers changed from: package-private */
        public final void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                this.queue.add(new EventWithSubscriber(obj, it.next()));
            }
            while (true) {
                EventWithSubscriber poll = this.queue.poll();
                if (poll != null) {
                    poll.subscriber.dispatchEvent(poll.event);
                } else {
                    return;
                }
            }
        }

        static final class EventWithSubscriber {
            public final Object event;
            public final Subscriber subscriber;

            private EventWithSubscriber(Object obj, Subscriber subscriber2) {
                this.event = obj;
                this.subscriber = subscriber2;
            }
        }
    }

    static final class ImmediateDispatcher extends Dispatcher {
        public static final ImmediateDispatcher INSTANCE = new ImmediateDispatcher();

        private ImmediateDispatcher() {
        }

        /* access modifiers changed from: package-private */
        public final void dispatch(Object obj, Iterator<Subscriber> it) {
            Preconditions.checkNotNull(obj);
            while (it.hasNext()) {
                it.next().dispatchEvent(obj);
            }
        }
    }
}
