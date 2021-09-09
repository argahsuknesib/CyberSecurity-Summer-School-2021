package com.amap.api.location;

import _m_j.bvz;
import _m_j.bwd;
import _m_j.bwi;
import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import com.loc.o;

public class APSService extends Service {

    /* renamed from: a  reason: collision with root package name */
    APSServiceBase f3260a;
    int b = 0;
    boolean c = false;

    private boolean a() {
        if (bwi.O0000OoO(getApplicationContext())) {
            int i = -1;
            try {
                i = bwd.O00000Oo(getApplication().getBaseContext(), "checkSelfPermission", "android.permission.FOREGROUND_SERVICE");
            } catch (Throwable unused) {
            }
            if (i != 0) {
                return false;
            }
        }
        return true;
    }

    public IBinder onBind(Intent intent) {
        try {
            return this.f3260a.onBind(intent);
        } catch (Throwable th) {
            bvz.O000000o(th, "APSService", "onBind");
            return null;
        }
    }

    public void onCreate() {
        onCreate(this);
    }

    public void onCreate(Context context) {
        try {
            if (this.f3260a == null) {
                this.f3260a = new o(context);
            }
            this.f3260a.onCreate();
        } catch (Throwable th) {
            bvz.O000000o(th, "APSService", "onCreate");
        }
        super.onCreate();
    }

    public void onDestroy() {
        try {
            this.f3260a.onDestroy();
            if (this.c) {
                stopForeground(true);
            }
        } catch (Throwable th) {
            bvz.O000000o(th, "APSService", "onDestroy");
        }
        super.onDestroy();
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0050 */
    public int onStartCommand(Intent intent, int i, int i2) {
        if (intent != null) {
            if (a()) {
                int intExtra = intent.getIntExtra("g", 0);
                if (intExtra == 1) {
                    int intExtra2 = intent.getIntExtra("i", 0);
                    Notification notification = (Notification) intent.getParcelableExtra("h");
                    if (!(intExtra2 == 0 || notification == null)) {
                        startForeground(intExtra2, notification);
                        this.c = true;
                        this.b++;
                    }
                } else if (intExtra == 2) {
                    if (intent.getBooleanExtra("j", true) && this.b > 0) {
                        this.b--;
                    }
                    if (this.b <= 0) {
                        stopForeground(true);
                        this.c = false;
                    } else {
                        stopForeground(false);
                    }
                }
            }
        }
        try {
            return this.f3260a.onStartCommand(intent, i, i2);
        } catch (Throwable th) {
            bvz.O000000o(th, "APSService", "onStartCommand");
            return super.onStartCommand(intent, i, i2);
        }
    }
}
