package rx.android.plugins;

import rx.Scheduler;
import rx.functions.Action0;

public class RxAndroidSchedulersHook {
    private static final RxAndroidSchedulersHook DEFAULT_INSTANCE = new RxAndroidSchedulersHook();

    public Scheduler getMainThreadScheduler() {
        return null;
    }

    public Action0 onSchedule(Action0 action0) {
        return action0;
    }

    public static RxAndroidSchedulersHook getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }
}
