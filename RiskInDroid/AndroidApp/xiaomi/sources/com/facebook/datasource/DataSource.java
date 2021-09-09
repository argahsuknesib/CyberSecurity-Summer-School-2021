package com.facebook.datasource;

import java.util.concurrent.Executor;

public interface DataSource<T> {
    boolean close();

    Throwable getFailureCause();

    float getProgress();

    T getResult();

    boolean hasFailed();

    boolean hasResult();

    boolean isClosed();

    boolean isFinished();

    void subscribe(DataSubscriber<T> dataSubscriber, Executor executor);
}
