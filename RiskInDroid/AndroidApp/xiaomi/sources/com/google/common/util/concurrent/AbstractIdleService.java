package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@GwtIncompatible
@Beta
public abstract class AbstractIdleService implements Service {
    private final Service delegate = new DelegateService();
    public final Supplier<String> threadNameSupplier = new ThreadNameSupplier();

    /* access modifiers changed from: protected */
    public abstract void shutDown() throws Exception;

    /* access modifiers changed from: protected */
    public abstract void startUp() throws Exception;

    final class ThreadNameSupplier implements Supplier<String> {
        private ThreadNameSupplier() {
        }

        public final String get() {
            return AbstractIdleService.this.serviceName() + " " + AbstractIdleService.this.state();
        }
    }

    final class DelegateService extends AbstractService {
        private DelegateService() {
        }

        /* access modifiers changed from: protected */
        public final void doStart() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
                /* class com.google.common.util.concurrent.AbstractIdleService.DelegateService.AnonymousClass1 */

                public void run() {
                    try {
                        AbstractIdleService.this.startUp();
                        DelegateService.this.notifyStarted();
                    } catch (Throwable th) {
                        DelegateService.this.notifyFailed(th);
                    }
                }
            });
        }

        /* access modifiers changed from: protected */
        public final void doStop() {
            MoreExecutors.renamingDecorator(AbstractIdleService.this.executor(), AbstractIdleService.this.threadNameSupplier).execute(new Runnable() {
                /* class com.google.common.util.concurrent.AbstractIdleService.DelegateService.AnonymousClass2 */

                public void run() {
                    try {
                        AbstractIdleService.this.shutDown();
                        DelegateService.this.notifyStopped();
                    } catch (Throwable th) {
                        DelegateService.this.notifyFailed(th);
                    }
                }
            });
        }

        public final String toString() {
            return AbstractIdleService.this.toString();
        }
    }

    protected AbstractIdleService() {
    }

    /* access modifiers changed from: protected */
    public Executor executor() {
        return new Executor() {
            /* class com.google.common.util.concurrent.AbstractIdleService.AnonymousClass1 */

            public void execute(Runnable runnable) {
                MoreExecutors.newThread(AbstractIdleService.this.threadNameSupplier.get(), runnable).start();
            }
        };
    }

    public String toString() {
        return serviceName() + " [" + state() + "]";
    }

    public final boolean isRunning() {
        return this.delegate.isRunning();
    }

    public final Service.State state() {
        return this.delegate.state();
    }

    public final void addListener(Service.Listener listener, Executor executor) {
        this.delegate.addListener(listener, executor);
    }

    public final Throwable failureCause() {
        return this.delegate.failureCause();
    }

    @CanIgnoreReturnValue
    public final Service startAsync() {
        this.delegate.startAsync();
        return this;
    }

    @CanIgnoreReturnValue
    public final Service stopAsync() {
        this.delegate.stopAsync();
        return this;
    }

    public final void awaitRunning() {
        this.delegate.awaitRunning();
    }

    public final void awaitRunning(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitRunning(j, timeUnit);
    }

    public final void awaitTerminated() {
        this.delegate.awaitTerminated();
    }

    public final void awaitTerminated(long j, TimeUnit timeUnit) throws TimeoutException {
        this.delegate.awaitTerminated(j, timeUnit);
    }

    /* access modifiers changed from: protected */
    public String serviceName() {
        return getClass().getSimpleName();
    }
}
