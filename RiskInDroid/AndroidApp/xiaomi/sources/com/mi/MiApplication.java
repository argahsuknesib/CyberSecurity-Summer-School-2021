package com.mi;

import _m_j.bxp;
import _m_j.ccr;
import _m_j.cdz;
import _m_j.ced;
import _m_j.cee;
import _m_j.cef;
import _m_j.cem;
import android.app.Application;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.os.Build;
import android.text.TextUtils;
import com.android.volley.toolbox.Volley;
import com.mi.util.Device;

public class MiApplication extends Application {
    public void onCreate() {
        super.onCreate();
        bxp.f13383O000000o = this;
        Device.O000000o(this, cem.O000000o(this, "android.permission.READ_PHONE_STATE"));
        boolean z = cdz.f13673O000000o;
        ccr.O000000o();
        cef.O000000o().O000000o(this);
        initNetwork();
        if (Build.VERSION.SDK_INT >= 26) {
            String O000000o2 = cee.O000000o("message");
            if (TextUtils.isEmpty(O000000o2)) {
                O000000o2 = "message";
            }
            ((NotificationManager) bxp.f13383O000000o.getSystemService("notification")).createNotificationChannel(new NotificationChannel("message", O000000o2, 3));
        }
    }

    /* access modifiers changed from: protected */
    public void initNetwork() {
        ced.f13683O000000o = Volley.newRequestQueue(this);
    }
}
