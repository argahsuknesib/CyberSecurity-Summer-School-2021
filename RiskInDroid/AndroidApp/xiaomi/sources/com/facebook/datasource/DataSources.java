package com.facebook.datasource;

import com.facebook.common.internal.Supplier;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;

public class DataSources {
    private DataSources() {
    }

    public static <T> DataSource<T> immediateFailedDataSource(Throwable th) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setFailure(th);
        return create;
    }

    public static <T> DataSource<T> immediateDataSource(T t) {
        SimpleDataSource create = SimpleDataSource.create();
        create.setResult(t);
        return create;
    }

    public static <T> Supplier<DataSource<T>> getFailedDataSourceSupplier(final Throwable th) {
        return new Supplier<DataSource<T>>() {
            /* class com.facebook.datasource.DataSources.AnonymousClass1 */

            public final DataSource<T> get() {
                return DataSources.immediateFailedDataSource(th);
            }
        };
    }

    public static <T> T waitForFinalResult(DataSource<T> dataSource) throws Throwable {
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        final ValueHolder valueHolder = new ValueHolder();
        final ValueHolder valueHolder2 = new ValueHolder();
        dataSource.subscribe(new DataSubscriber<T>() {
            /* class com.facebook.datasource.DataSources.AnonymousClass2 */

            public final void onProgressUpdate(DataSource<T> dataSource) {
            }

            public final void onNewResult(DataSource<T> dataSource) {
                if (dataSource.isFinished()) {
                    try {
                        valueHolder.value = dataSource.getResult();
                    } finally {
                        countDownLatch.countDown();
                    }
                }
            }

            public final void onFailure(DataSource<T> dataSource) {
                try {
                    valueHolder2.value = dataSource.getFailureCause();
                } finally {
                    countDownLatch.countDown();
                }
            }

            public final void onCancellation(DataSource<T> dataSource) {
                countDownLatch.countDown();
            }
        }, new Executor() {
            /* class com.facebook.datasource.DataSources.AnonymousClass3 */

            public final void execute(Runnable runnable) {
                runnable.run();
            }
        });
        countDownLatch.await();
        if (valueHolder2.value == null) {
            return valueHolder.value;
        }
        throw ((Throwable) valueHolder2.value);
    }

    static class ValueHolder<T> {
        public T value;

        private ValueHolder() {
            this.value = null;
        }
    }
}
