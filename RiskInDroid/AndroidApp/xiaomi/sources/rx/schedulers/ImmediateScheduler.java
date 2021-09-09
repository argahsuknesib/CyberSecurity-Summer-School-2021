package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class ImmediateScheduler extends Scheduler {
    public final Scheduler.Worker createWorker() {
        return null;
    }

    private ImmediateScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
