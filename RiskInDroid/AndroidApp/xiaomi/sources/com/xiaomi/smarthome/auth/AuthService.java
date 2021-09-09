package com.xiaomi.smarthome.auth;

import _m_j.fak;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.authlib.ICallAuth;

public class AuthService extends Service {

    /* renamed from: O000000o  reason: collision with root package name */
    ICallAuth.Stub f4265O000000o = new ICallAuth.Stub() {
        /* class com.xiaomi.smarthome.auth.AuthService.AnonymousClass1 */

        public void callAuth(int i, Bundle bundle, IAuthCallBack iAuthCallBack) throws RemoteException {
            AuthService.this.startLocalActivity(i, bundle, iAuthCallBack);
        }
    };

    public IBinder onBind(Intent intent) {
        return this.f4265O000000o;
    }

    public void startLocalActivity(int i, Bundle bundle, IAuthCallBack iAuthCallBack) {
        fak.O000000o();
        fak.O00000o();
        fak.O000000o().O00000oO = iAuthCallBack;
        Intent intent = new Intent(this, AuthCheckActivity.class);
        bundle.putInt("request_auth_code", i);
        fak.O000000o().O00000oo = bundle;
        fak.O000000o().O0000O0o = i;
        intent.putExtras(bundle);
        intent.addFlags(268435456);
        startActivity(intent);
    }
}
