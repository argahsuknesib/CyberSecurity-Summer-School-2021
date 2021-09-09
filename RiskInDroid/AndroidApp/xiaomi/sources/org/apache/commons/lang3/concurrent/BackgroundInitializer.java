package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public abstract class BackgroundInitializer<T> {
    /* access modifiers changed from: protected */
    public abstract T O000000o() throws Exception;

    class InitializationTask implements Callable<T> {
        private final ExecutorService execFinally;

        public InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        public T call() throws Exception {
            try {
                return BackgroundInitializer.this.O000000o();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }
}
