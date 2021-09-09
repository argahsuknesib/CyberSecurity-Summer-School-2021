package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import rx.functions.Func0;
import rx.internal.util.RxThreadFactory;
import rx.plugins.RxJavaHooks;

enum GenericScheduledExecutorServiceFactory {
    ;
    
    static final RxThreadFactory THREAD_FACTORY = new RxThreadFactory("RxScheduledExecutorPool-");

    static ThreadFactory threadFactory() {
        return THREAD_FACTORY;
    }

    public static ScheduledExecutorService create() {
        Func0<? extends ScheduledExecutorService> onGenericScheduledExecutorService = RxJavaHooks.getOnGenericScheduledExecutorService();
        if (onGenericScheduledExecutorService == null) {
            return createDefault();
        }
        return (ScheduledExecutorService) onGenericScheduledExecutorService.call();
    }

    static ScheduledExecutorService createDefault() {
        return Executors.newScheduledThreadPool(1, threadFactory());
    }
}
