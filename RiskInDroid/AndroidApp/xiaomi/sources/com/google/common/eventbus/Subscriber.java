package com.google.common.eventbus;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.j2objc.annotations.Weak;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;

class Subscriber {
    @Weak
    public EventBus bus;
    private final Executor executor;
    private final Method method;
    @VisibleForTesting
    final Object target;

    static Subscriber create(EventBus eventBus, Object obj, Method method2) {
        return isDeclaredThreadSafe(method2) ? new Subscriber(eventBus, obj, method2) : new SynchronizedSubscriber(eventBus, obj, method2);
    }

    private Subscriber(EventBus eventBus, Object obj, Method method2) {
        this.bus = eventBus;
        this.target = Preconditions.checkNotNull(obj);
        this.method = method2;
        method2.setAccessible(true);
        this.executor = eventBus.executor();
    }

    /* access modifiers changed from: package-private */
    public final void dispatchEvent(final Object obj) {
        this.executor.execute(new Runnable() {
            /* class com.google.common.eventbus.Subscriber.AnonymousClass1 */

            public void run() {
                try {
                    Subscriber.this.invokeSubscriberMethod(obj);
                } catch (InvocationTargetException e) {
                    Subscriber.this.bus.handleSubscriberException(e.getCause(), Subscriber.this.context(obj));
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
        try {
            this.method.invoke(this.target, Preconditions.checkNotNull(obj));
        } catch (IllegalArgumentException e) {
            throw new Error("Method rejected target/argument: ".concat(String.valueOf(obj)), e);
        } catch (IllegalAccessException e2) {
            throw new Error("Method became inaccessible: ".concat(String.valueOf(obj)), e2);
        } catch (InvocationTargetException e3) {
            if (e3.getCause() instanceof Error) {
                throw ((Error) e3.getCause());
            }
            throw e3;
        }
    }

    public SubscriberExceptionContext context(Object obj) {
        return new SubscriberExceptionContext(this.bus, obj, this.target, this.method);
    }

    public final int hashCode() {
        return ((this.method.hashCode() + 31) * 31) + System.identityHashCode(this.target);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Subscriber) {
            Subscriber subscriber = (Subscriber) obj;
            if (this.target != subscriber.target || !this.method.equals(subscriber.method)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private static boolean isDeclaredThreadSafe(Method method2) {
        return method2.getAnnotation(AllowConcurrentEvents.class) != null;
    }

    @VisibleForTesting
    static final class SynchronizedSubscriber extends Subscriber {
        private SynchronizedSubscriber(EventBus eventBus, Object obj, Method method) {
            super(eventBus, obj, method);
        }

        /* access modifiers changed from: package-private */
        public final void invokeSubscriberMethod(Object obj) throws InvocationTargetException {
            synchronized (this) {
                Subscriber.super.invokeSubscriberMethod(obj);
            }
        }
    }
}
