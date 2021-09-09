package rx.android.plugins;

import java.util.concurrent.atomic.AtomicReference;
import rx.annotations.Experimental;

public final class RxAndroidPlugins {
    private static final RxAndroidPlugins INSTANCE = new RxAndroidPlugins();
    private final AtomicReference<RxAndroidSchedulersHook> schedulersHook = new AtomicReference<>();

    public static RxAndroidPlugins getInstance() {
        return INSTANCE;
    }

    RxAndroidPlugins() {
    }

    @Experimental
    public final void reset() {
        this.schedulersHook.set(null);
    }

    public final RxAndroidSchedulersHook getSchedulersHook() {
        if (this.schedulersHook.get() == null) {
            this.schedulersHook.compareAndSet(null, RxAndroidSchedulersHook.getDefaultInstance());
        }
        return this.schedulersHook.get();
    }

    public final void registerSchedulersHook(RxAndroidSchedulersHook rxAndroidSchedulersHook) {
        if (!this.schedulersHook.compareAndSet(null, rxAndroidSchedulersHook)) {
            throw new IllegalStateException("Another strategy was already registered: " + this.schedulersHook.get());
        }
    }
}
