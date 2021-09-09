package bolts;

import java.util.Locale;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public final class BoltsExecutors {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final BoltsExecutors f3056O000000o = new BoltsExecutors();
    private final ExecutorService O00000Oo;
    private final Executor O00000o;
    private final ScheduledExecutorService O00000o0;

    private BoltsExecutors() {
        boolean z;
        String property = System.getProperty("java.runtime.name");
        if (property == null) {
            z = false;
        } else {
            z = property.toLowerCase(Locale.US).contains("android");
        }
        this.O00000Oo = !z ? Executors.newCachedThreadPool() : AndroidExecutors.O000000o();
        this.O00000o0 = Executors.newSingleThreadScheduledExecutor();
        this.O00000o = new ImmediateExecutor();
    }

    public static ExecutorService O000000o() {
        return f3056O000000o.O00000Oo;
    }

    public static Executor O00000Oo() {
        return f3056O000000o.O00000o;
    }

    static class ImmediateExecutor implements Executor {
        private ThreadLocal<Integer> executionDepth;

        private ImmediateExecutor() {
            this.executionDepth = new ThreadLocal<>();
        }

        private int incrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() + 1;
            this.executionDepth.set(Integer.valueOf(intValue));
            return intValue;
        }

        private int decrementDepth() {
            Integer num = this.executionDepth.get();
            if (num == null) {
                num = 0;
            }
            int intValue = num.intValue() - 1;
            if (intValue == 0) {
                this.executionDepth.remove();
            } else {
                this.executionDepth.set(Integer.valueOf(intValue));
            }
            return intValue;
        }

        public void execute(Runnable runnable) {
            if (incrementDepth() <= 15) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    decrementDepth();
                    throw th;
                }
            } else {
                BoltsExecutors.O000000o().execute(runnable);
            }
            decrementDepth();
        }
    }
}
