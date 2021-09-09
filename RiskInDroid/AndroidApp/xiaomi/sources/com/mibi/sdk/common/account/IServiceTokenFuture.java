package com.mibi.sdk.common.account;

import java.util.concurrent.TimeUnit;

public interface IServiceTokenFuture {
    IServiceTokenResult get();

    IServiceTokenResult get(long j, TimeUnit timeUnit);

    boolean isCancelled();

    boolean isDone();
}
