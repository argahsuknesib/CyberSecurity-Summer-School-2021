package com.google.common.util.concurrent;

import com.google.auto.common.BasicAnnotationProcessor;
import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicates;
import com.google.common.base.Stopwatch;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableSetMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Multiset;
import com.google.common.collect.Ordering;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.UnmodifiableIterator;
import com.google.common.util.concurrent.ListenerCallQueue;
import com.google.common.util.concurrent.Monitor;
import com.google.common.util.concurrent.Service;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.logging.Level;
import java.util.logging.Logger;

@GwtIncompatible
@Beta
public final class ServiceManager {
    public static final ListenerCallQueue.Event<Listener> HEALTHY_EVENT = new ListenerCallQueue.Event<Listener>() {
        /* class com.google.common.util.concurrent.ServiceManager.AnonymousClass1 */

        public final String toString() {
            return "healthy()";
        }

        public final void call(Listener listener) {
            listener.healthy();
        }
    };
    public static final ListenerCallQueue.Event<Listener> STOPPED_EVENT = new ListenerCallQueue.Event<Listener>() {
        /* class com.google.common.util.concurrent.ServiceManager.AnonymousClass2 */

        public final String toString() {
            return "stopped()";
        }

        public final void call(Listener listener) {
            listener.stopped();
        }
    };
    public static final Logger logger = Logger.getLogger(ServiceManager.class.getName());
    private final ImmutableList<Service> services;
    private final ServiceManagerState state;

    @Beta
    public static abstract class Listener {
        public void failure(Service service) {
        }

        public void healthy() {
        }

        public void stopped() {
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, com.google.common.util.concurrent.ServiceManager$EmptyServiceManagerWarning]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    public ServiceManager(Iterable<? extends Service> iterable) {
        ImmutableList<Service> copyOf = ImmutableList.copyOf(iterable);
        if (copyOf.isEmpty()) {
            logger.log(Level.WARNING, "ServiceManager configured with no services.  Is your application configured properly?", (Throwable) new EmptyServiceManagerWarning());
            copyOf = ImmutableList.of(new NoOpService());
        }
        this.state = new ServiceManagerState(copyOf);
        this.services = copyOf;
        WeakReference weakReference = new WeakReference(this.state);
        UnmodifiableIterator<Service> it = copyOf.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            next.addListener(new ServiceListener(next, weakReference), MoreExecutors.directExecutor());
            Preconditions.checkArgument(next.state() == Service.State.NEW, "Can only manage NEW services, %s", next);
        }
        this.state.markReady();
    }

    public final void addListener(Listener listener, Executor executor) {
        this.state.addListener(listener, executor);
    }

    public final void addListener(Listener listener) {
        this.state.addListener(listener, MoreExecutors.directExecutor());
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void}
     arg types: [java.util.logging.Level, java.lang.String, java.lang.IllegalStateException]
     candidates:
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.Throwable, java.util.function.Supplier<java.lang.String>):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object[]):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Object):void}
      ClspMth{java.util.logging.Logger.log(java.util.logging.Level, java.lang.String, java.lang.Throwable):void} */
    @CanIgnoreReturnValue
    public final ServiceManager startAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            Service next = it.next();
            Service.State state2 = next.state();
            Preconditions.checkState(state2 == Service.State.NEW, "Service %s is %s, cannot start it.", next, state2);
        }
        UnmodifiableIterator<Service> it2 = this.services.iterator();
        while (it2.hasNext()) {
            Service next2 = it2.next();
            try {
                this.state.tryStartTiming(next2);
                next2.startAsync();
            } catch (IllegalStateException e) {
                logger.log(Level.WARNING, "Unable to start Service ".concat(String.valueOf(next2)), (Throwable) e);
            }
        }
        return this;
    }

    public final void awaitHealthy() {
        this.state.awaitHealthy();
    }

    public final void awaitHealthy(long j, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitHealthy(j, timeUnit);
    }

    @CanIgnoreReturnValue
    public final ServiceManager stopAsync() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            it.next().stopAsync();
        }
        return this;
    }

    public final void awaitStopped() {
        this.state.awaitStopped();
    }

    public final void awaitStopped(long j, TimeUnit timeUnit) throws TimeoutException {
        this.state.awaitStopped(j, timeUnit);
    }

    public final boolean isHealthy() {
        UnmodifiableIterator<Service> it = this.services.iterator();
        while (it.hasNext()) {
            if (!it.next().isRunning()) {
                return false;
            }
        }
        return true;
    }

    public final ImmutableMultimap<Service.State, Service> servicesByState() {
        return this.state.servicesByState();
    }

    public final ImmutableMap<Service, Long> startupTimes() {
        return this.state.startupTimes();
    }

    public final String toString() {
        return MoreObjects.toStringHelper((Class<?>) ServiceManager.class).add("services", Collections2.filter(this.services, Predicates.not(Predicates.instanceOf(NoOpService.class)))).toString();
    }

    static final class ServiceManagerState {
        final Monitor.Guard awaitHealthGuard = new AwaitHealthGuard();
        final ListenerCallQueue<Listener> listeners = new ListenerCallQueue<>();
        final Monitor monitor = new Monitor();
        final int numberOfServices;
        @GuardedBy("monitor")
        boolean ready;
        @GuardedBy("monitor")
        final SetMultimap<Service.State, Service> servicesByState = MultimapBuilder.enumKeys(Service.State.class).linkedHashSetValues().build();
        @GuardedBy("monitor")
        final Map<Service, Stopwatch> startupTimers = Maps.newIdentityHashMap();
        @GuardedBy("monitor")
        final Multiset<Service.State> states = this.servicesByState.keys();
        final Monitor.Guard stoppedGuard = new StoppedGuard();
        @GuardedBy("monitor")
        boolean transitioned;

        final class AwaitHealthGuard extends Monitor.Guard {
            AwaitHealthGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public final boolean isSatisfied() {
                return ServiceManagerState.this.states.count(Service.State.RUNNING) == ServiceManagerState.this.numberOfServices || ServiceManagerState.this.states.contains(Service.State.STOPPING) || ServiceManagerState.this.states.contains(Service.State.TERMINATED) || ServiceManagerState.this.states.contains(Service.State.FAILED);
            }
        }

        final class StoppedGuard extends Monitor.Guard {
            StoppedGuard() {
                super(ServiceManagerState.this.monitor);
            }

            @GuardedBy("ServiceManagerState.this.monitor")
            public final boolean isSatisfied() {
                return ServiceManagerState.this.states.count(Service.State.TERMINATED) + ServiceManagerState.this.states.count(Service.State.FAILED) == ServiceManagerState.this.numberOfServices;
            }
        }

        ServiceManagerState(ImmutableCollection<Service> immutableCollection) {
            this.numberOfServices = immutableCollection.size();
            this.servicesByState.putAll(Service.State.NEW, immutableCollection);
        }

        /* access modifiers changed from: package-private */
        public final void tryStartTiming(Service service) {
            this.monitor.enter();
            try {
                if (this.startupTimers.get(service) == null) {
                    this.startupTimers.put(service, Stopwatch.createStarted());
                }
            } finally {
                this.monitor.leave();
            }
        }

        /* access modifiers changed from: package-private */
        public final void markReady() {
            this.monitor.enter();
            try {
                if (!this.transitioned) {
                    this.ready = true;
                    return;
                }
                ArrayList newArrayList = Lists.newArrayList();
                UnmodifiableIterator<Service> it = servicesByState().values().iterator();
                while (it.hasNext()) {
                    Service next = it.next();
                    if (next.state() != Service.State.NEW) {
                        newArrayList.add(next);
                    }
                }
                throw new IllegalArgumentException("Services started transitioning asynchronously before the ServiceManager was constructed: ".concat(String.valueOf(newArrayList)));
            } finally {
                this.monitor.leave();
            }
        }

        /* access modifiers changed from: package-private */
        public final void addListener(Listener listener, Executor executor) {
            this.listeners.addListener(listener, executor);
        }

        /* access modifiers changed from: package-private */
        public final void awaitHealthy() {
            this.monitor.enterWhenUninterruptibly(this.awaitHealthGuard);
            try {
                checkHealthy();
            } finally {
                this.monitor.leave();
            }
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
         arg types: [com.google.common.collect.SetMultimap<com.google.common.util.concurrent.Service$State, com.google.common.util.concurrent.Service>, com.google.common.base.Predicate]
         candidates:
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.ListMultimap, com.google.common.base.Predicate):com.google.common.collect.ListMultimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
        /* access modifiers changed from: package-private */
        public final void awaitHealthy(long j, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (this.monitor.waitForUninterruptibly(this.awaitHealthGuard, j, timeUnit)) {
                    checkHealthy();
                    return;
                }
                throw new TimeoutException("Timeout waiting for the services to become healthy. The following services have not started: " + Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.in(ImmutableSet.of(Service.State.NEW, Service.State.STARTING))));
            } finally {
                this.monitor.leave();
            }
        }

        /* access modifiers changed from: package-private */
        public final void awaitStopped() {
            this.monitor.enterWhenUninterruptibly(this.stoppedGuard);
            this.monitor.leave();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
         arg types: [com.google.common.collect.SetMultimap<com.google.common.util.concurrent.Service$State, com.google.common.util.concurrent.Service>, com.google.common.base.Predicate]
         candidates:
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.ListMultimap, com.google.common.base.Predicate):com.google.common.collect.ListMultimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
        /* access modifiers changed from: package-private */
        public final void awaitStopped(long j, TimeUnit timeUnit) throws TimeoutException {
            this.monitor.enter();
            try {
                if (!this.monitor.waitForUninterruptibly(this.stoppedGuard, j, timeUnit)) {
                    throw new TimeoutException("Timeout waiting for the services to stop. The following services have not stopped: " + Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.not(Predicates.in(EnumSet.of(Service.State.TERMINATED, Service.State.FAILED)))));
                }
            } finally {
                this.monitor.leave();
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public final ImmutableMultimap<Service.State, Service> servicesByState() {
            ImmutableSetMultimap.Builder builder = ImmutableSetMultimap.builder();
            this.monitor.enter();
            try {
                for (Map.Entry next : this.servicesByState.entries()) {
                    if (!(next.getValue() instanceof NoOpService)) {
                        builder.put(next);
                    }
                }
                this.monitor.leave();
                return builder.build();
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: package-private */
        public final ImmutableMap<Service, Long> startupTimes() {
            this.monitor.enter();
            try {
                ArrayList newArrayListWithCapacity = Lists.newArrayListWithCapacity(this.startupTimers.size());
                for (Map.Entry next : this.startupTimers.entrySet()) {
                    Service service = (Service) next.getKey();
                    Stopwatch stopwatch = (Stopwatch) next.getValue();
                    if (!stopwatch.isRunning() && !(service instanceof NoOpService)) {
                        newArrayListWithCapacity.add(Maps.immutableEntry(service, Long.valueOf(stopwatch.elapsed(TimeUnit.MILLISECONDS))));
                    }
                }
                this.monitor.leave();
                Collections.sort(newArrayListWithCapacity, Ordering.natural().onResultOf(new Function<Map.Entry<Service, Long>, Long>() {
                    /* class com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass1 */

                    public /* bridge */ /* synthetic */ Object apply(Object obj) {
                        return apply((Map.Entry<Service, Long>) ((Map.Entry) obj));
                    }

                    public Long apply(Map.Entry<Service, Long> entry) {
                        return entry.getValue();
                    }
                }));
                return ImmutableMap.copyOf(newArrayListWithCapacity);
            } catch (Throwable th) {
                this.monitor.leave();
                throw th;
            }
        }

        /* access modifiers changed from: package-private */
        public final void transitionService(Service service, Service.State state, Service.State state2) {
            Preconditions.checkNotNull(service);
            Preconditions.checkArgument(state != state2);
            this.monitor.enter();
            try {
                this.transitioned = true;
                if (this.ready) {
                    Preconditions.checkState(this.servicesByState.remove(state, service), "Service %s not at the expected location in the state map %s", service, state);
                    Preconditions.checkState(this.servicesByState.put(state2, service), "Service %s in the state map unexpectedly at %s", service, state2);
                    Stopwatch stopwatch = this.startupTimers.get(service);
                    if (stopwatch == null) {
                        stopwatch = Stopwatch.createStarted();
                        this.startupTimers.put(service, stopwatch);
                    }
                    if (state2.compareTo((Enum) Service.State.RUNNING) >= 0 && stopwatch.isRunning()) {
                        stopwatch.stop();
                        if (!(service instanceof NoOpService)) {
                            ServiceManager.logger.log(Level.FINE, "Started {0} in {1}.", new Object[]{service, stopwatch});
                        }
                    }
                    if (state2 == Service.State.FAILED) {
                        enqueueFailedEvent(service);
                    }
                    if (this.states.count(Service.State.RUNNING) == this.numberOfServices) {
                        enqueueHealthyEvent();
                    } else if (this.states.count(Service.State.TERMINATED) + this.states.count(Service.State.FAILED) == this.numberOfServices) {
                        enqueueStoppedEvent();
                    }
                }
            } finally {
                this.monitor.leave();
                dispatchListenerEvents();
            }
        }

        /* access modifiers changed from: package-private */
        public final void enqueueStoppedEvent() {
            this.listeners.enqueue(ServiceManager.STOPPED_EVENT);
        }

        /* access modifiers changed from: package-private */
        public final void enqueueHealthyEvent() {
            this.listeners.enqueue(ServiceManager.HEALTHY_EVENT);
        }

        /* access modifiers changed from: package-private */
        public final void enqueueFailedEvent(final Service service) {
            this.listeners.enqueue(new ListenerCallQueue.Event<Listener>() {
                /* class com.google.common.util.concurrent.ServiceManager.ServiceManagerState.AnonymousClass2 */

                public void call(Listener listener) {
                    listener.failure(service);
                }

                public String toString() {
                    return "failed({service=" + service + "})";
                }
            });
        }

        /* access modifiers changed from: package-private */
        public final void dispatchListenerEvents() {
            Preconditions.checkState(!this.monitor.isOccupiedByCurrentThread(), "It is incorrect to execute listeners with the monitor held.");
            this.listeners.dispatch();
        }

        /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
         method: com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V>
         arg types: [com.google.common.collect.SetMultimap<com.google.common.util.concurrent.Service$State, com.google.common.util.concurrent.Service>, com.google.common.base.Predicate]
         candidates:
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.ListMultimap, com.google.common.base.Predicate):com.google.common.collect.ListMultimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.Multimap, com.google.common.base.Predicate):com.google.common.collect.Multimap<K, V>
          com.google.common.collect.Multimaps.filterKeys(com.google.common.collect.SetMultimap, com.google.common.base.Predicate):com.google.common.collect.SetMultimap<K, V> */
        /* access modifiers changed from: package-private */
        @GuardedBy("monitor")
        public final void checkHealthy() {
            if (this.states.count(Service.State.RUNNING) != this.numberOfServices) {
                IllegalStateException illegalStateException = new IllegalStateException("Expected to be healthy after starting. The following services are not running: " + Multimaps.filterKeys((SetMultimap) this.servicesByState, Predicates.not(Predicates.equalTo(Service.State.RUNNING))));
                for (Service failedService : this.servicesByState.get((BasicAnnotationProcessor.ProcessingStep) Service.State.FAILED)) {
                    illegalStateException.addSuppressed(new FailedService(failedService));
                }
                throw illegalStateException;
            }
        }
    }

    static final class ServiceListener extends Service.Listener {
        final Service service;
        final WeakReference<ServiceManagerState> state;

        ServiceListener(Service service2, WeakReference<ServiceManagerState> weakReference) {
            this.service = service2;
            this.state = weakReference;
        }

        public final void starting() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.NEW, Service.State.STARTING);
                if (!(this.service instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Starting {0}.", this.service);
                }
            }
        }

        public final void running() {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, Service.State.STARTING, Service.State.RUNNING);
            }
        }

        public final void stopping(Service.State state2) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                serviceManagerState.transitionService(this.service, state2, Service.State.STOPPING);
            }
        }

        public final void terminated(Service.State state2) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                if (!(this.service instanceof NoOpService)) {
                    ServiceManager.logger.log(Level.FINE, "Service {0} has terminated. Previous state was: {1}", new Object[]{this.service, state2});
                }
                serviceManagerState.transitionService(this.service, state2, Service.State.TERMINATED);
            }
        }

        public final void failed(Service.State state2, Throwable th) {
            ServiceManagerState serviceManagerState = this.state.get();
            if (serviceManagerState != null) {
                boolean z = true;
                boolean z2 = !(this.service instanceof NoOpService);
                if (state2 == Service.State.STARTING) {
                    z = false;
                }
                if (z2 && z) {
                    Logger logger = ServiceManager.logger;
                    Level level = Level.SEVERE;
                    logger.log(level, "Service " + this.service + " has failed in the " + state2 + " state.", th);
                }
                serviceManagerState.transitionService(this.service, state2, Service.State.FAILED);
            }
        }
    }

    static final class NoOpService extends AbstractService {
        private NoOpService() {
        }

        /* access modifiers changed from: protected */
        public final void doStart() {
            notifyStarted();
        }

        /* access modifiers changed from: protected */
        public final void doStop() {
            notifyStopped();
        }
    }

    static final class EmptyServiceManagerWarning extends Throwable {
        private EmptyServiceManagerWarning() {
        }
    }

    static final class FailedService extends Throwable {
        FailedService(Service service) {
            super(service.toString(), service.failureCause(), false, false);
        }
    }
}
