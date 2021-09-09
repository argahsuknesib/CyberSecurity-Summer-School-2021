package com.xiaomi.passport.servicetoken;

import android.os.RemoteException;
import com.xiaomi.accountsdk.futureservice.ClientFuture;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ServiceTokenFuture extends ClientFuture<ServiceTokenResult, ServiceTokenResult> {
    /* access modifiers changed from: protected */
    public ServiceTokenResult convertServerDataToClientData(ServiceTokenResult serviceTokenResult) throws Throwable {
        return serviceTokenResult;
    }

    public ServiceTokenFuture(ClientFuture.ClientCallback<ServiceTokenResult> clientCallback) {
        super(clientCallback);
    }

    public void interpretExecutionException(ExecutionException executionException) throws Exception {
        throw new IllegalStateException("not going here");
    }

    public ServiceTokenResult get() {
        return getInternal(null, null);
    }

    public ServiceTokenResult get(long j, TimeUnit timeUnit) {
        return getInternal(Long.valueOf(j), timeUnit);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.accountsdk.futureservice.ClientFuture.get(long, java.util.concurrent.TimeUnit):ClientDataType
     arg types: [long, java.util.concurrent.TimeUnit]
     candidates:
      com.xiaomi.passport.servicetoken.ServiceTokenFuture.get(long, java.util.concurrent.TimeUnit):com.xiaomi.passport.servicetoken.ServiceTokenResult
      com.xiaomi.accountsdk.futureservice.ClientFuture.get(long, java.util.concurrent.TimeUnit):ClientDataType */
    private ServiceTokenResult getInternal(Long l, TimeUnit timeUnit) {
        if (l == null || timeUnit == null) {
            return (ServiceTokenResult) super.get();
        }
        try {
            return (ServiceTokenResult) super.get(l.longValue(), timeUnit);
        } catch (InterruptedException e) {
            ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(null);
            o000000o.O00000oo = ServiceTokenResult.ErrorCode.ERROR_CANCELLED;
            o000000o.O00000o = e.getMessage();
            return o000000o.O000000o();
        } catch (ExecutionException e2) {
            if (e2.getCause() instanceof RemoteException) {
                ServiceTokenResult.O000000o o000000o2 = new ServiceTokenResult.O000000o(null);
                o000000o2.O00000oo = ServiceTokenResult.ErrorCode.ERROR_REMOTE_EXCEPTION;
                o000000o2.O00000o = e2.getMessage();
                return o000000o2.O000000o();
            }
            String message = e2.getCause() != null ? e2.getCause().getMessage() : e2.getMessage();
            ServiceTokenResult.O000000o o000000o3 = new ServiceTokenResult.O000000o(null);
            o000000o3.O00000oo = ServiceTokenResult.ErrorCode.ERROR_UNKNOWN;
            o000000o3.O00000o = message;
            return o000000o3.O000000o();
        } catch (TimeoutException unused) {
            ServiceTokenResult.O000000o o000000o4 = new ServiceTokenResult.O000000o(null);
            o000000o4.O00000oo = ServiceTokenResult.ErrorCode.ERROR_TIME_OUT;
            o000000o4.O00000o = "time out after " + l + " " + timeUnit;
            return o000000o4.O000000o();
        }
    }
}
