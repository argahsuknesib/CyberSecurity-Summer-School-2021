package rx.schedulers;

import rx.Scheduler;

@Deprecated
public final class NewThreadScheduler extends Scheduler {
    public final Scheduler.Worker createWorker() {
        return null;
    }

    private NewThreadScheduler() {
        throw new IllegalStateException("No instances!");
    }
}
