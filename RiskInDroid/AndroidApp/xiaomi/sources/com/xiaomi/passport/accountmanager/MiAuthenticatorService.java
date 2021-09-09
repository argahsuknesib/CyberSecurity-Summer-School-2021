package com.xiaomi.passport.accountmanager;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.xiaomi.accountsdk.utils.AccountLog;

public class MiAuthenticatorService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    private LocalAccountAuthenticator f6197O000000o;

    public void onCreate() {
        super.onCreate();
        this.f6197O000000o = new LocalAccountAuthenticator(this);
    }

    public IBinder onBind(Intent intent) {
        AccountLog.v("LocalAuthenticatorSer", "return the AccountAuthenticator binder of package: " + getPackageName());
        return this.f6197O000000o.f5952O000000o.asBinder();
    }
}
