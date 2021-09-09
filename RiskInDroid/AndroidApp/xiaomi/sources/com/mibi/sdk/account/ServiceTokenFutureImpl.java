package com.mibi.sdk.account;

import com.mibi.sdk.common.account.IServiceTokenFuture;
import com.mibi.sdk.common.account.IServiceTokenResult;
import com.xiaomi.passport.servicetoken.ServiceTokenFuture;
import java.util.concurrent.TimeUnit;

public class ServiceTokenFutureImpl implements IServiceTokenFuture {
    private ServiceTokenFuture mServiceTokenFuture;

    public ServiceTokenFutureImpl(ServiceTokenFuture serviceTokenFuture) {
        this.mServiceTokenFuture = serviceTokenFuture;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [java.util.concurrent.TimeUnit, java.lang.Long] */
    public IServiceTokenResult get() {
        ? r0 = 0;
        return get(r0.longValue(), r0);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.passport.servicetoken.ServiceTokenFuture.get(long, java.util.concurrent.TimeUnit):com.xiaomi.passport.servicetoken.ServiceTokenResult
     arg types: [long, java.util.concurrent.TimeUnit]
     candidates:
      com.xiaomi.passport.servicetoken.ServiceTokenFuture.get(long, java.util.concurrent.TimeUnit):java.lang.Object
      com.xiaomi.accountsdk.futureservice.ClientFuture.get(long, java.util.concurrent.TimeUnit):ClientDataType
      ClspMth{java.util.concurrent.FutureTask.get(long, java.util.concurrent.TimeUnit):V throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException}
      ClspMth{java.util.concurrent.Future.get(long, java.util.concurrent.TimeUnit):V throws java.util.concurrent.ExecutionException, java.lang.InterruptedException, java.util.concurrent.TimeoutException}
      com.xiaomi.passport.servicetoken.ServiceTokenFuture.get(long, java.util.concurrent.TimeUnit):com.xiaomi.passport.servicetoken.ServiceTokenResult */
    public IServiceTokenResult get(long j, TimeUnit timeUnit) {
        return new ServiceTokenResultImpl(this.mServiceTokenFuture.get(j, timeUnit));
    }

    public boolean isCancelled() {
        ServiceTokenFuture serviceTokenFuture = this.mServiceTokenFuture;
        return serviceTokenFuture != null && serviceTokenFuture.isCancelled();
    }

    public boolean isDone() {
        ServiceTokenFuture serviceTokenFuture = this.mServiceTokenFuture;
        return serviceTokenFuture != null && serviceTokenFuture.isDone();
    }
}
