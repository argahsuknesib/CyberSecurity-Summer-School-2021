package com.miui.tsmclientsdk;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public interface MiTsmFuture<V> {
    boolean cancel(boolean z);

    V getResult() throws OperationCanceledException, IOException, ExecutionException;

    V getResult(long j, TimeUnit timeUnit) throws OperationCanceledException, IOException, ExecutionException;

    boolean isCancelled();

    boolean isDone();
}
