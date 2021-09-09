package com.xiaomi.passport.servicetoken;

import android.os.Bundle;
import android.os.RemoteException;
import com.xiaomi.passport.servicetoken.IServiceTokenUIResponse;
import com.xiaomi.passport.servicetoken.ServiceTokenResult;

public class ServiceTokenUIErrorHandler$1 extends IServiceTokenUIResponse.Stub {
    final /* synthetic */ ServiceTokenFuture val$future;
    final /* synthetic */ ServiceTokenResult val$previousResult;

    public ServiceTokenUIErrorHandler$1(ServiceTokenResult serviceTokenResult, ServiceTokenFuture serviceTokenFuture) {
        this.val$previousResult = serviceTokenResult;
        this.val$future = serviceTokenFuture;
    }

    public final void onResult(Bundle bundle) throws RemoteException {
        this.val$future.setServerData(AMAuthTokenConverter.O000000o(bundle, this.val$previousResult.f6200O000000o));
    }

    public final void onRequestContinued() throws RemoteException {
        this.val$future.setServerData(this.val$previousResult);
    }

    public final void onError(int i, String str) throws RemoteException {
        if (i == 4) {
            ServiceTokenFuture serviceTokenFuture = this.val$future;
            ServiceTokenResult.O000000o o000000o = new ServiceTokenResult.O000000o(this.val$previousResult.f6200O000000o);
            o000000o.O00000oo = ServiceTokenResult.ErrorCode.ERROR_CANCELLED;
            serviceTokenFuture.setServerData(o000000o.O000000o());
            return;
        }
        this.val$future.setServerData(this.val$previousResult);
    }
}
