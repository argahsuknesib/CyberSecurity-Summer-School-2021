package com.xiaomi.assemble.control;

import _m_j.dzl;
import _m_j.dzo;
import _m_j.ebb;
import _m_j.gsy;
import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.FirebaseInstanceId;
import com.xiaomi.mipush.sdk.e;
import java.io.IOException;

public class FCMPushManager implements dzl {

    /* renamed from: O000000o  reason: collision with root package name */
    private Context f5973O000000o;

    private FCMPushManager(Context context) {
        this.f5973O000000o = context;
    }

    public static FCMPushManager newInstance(Context context) {
        return new FCMPushManager(context);
    }

    public final void O000000o() {
        gsy.O000000o(4, "FCM-PUSH", "register fcm");
        FirebaseApp.initializeApp(this.f5973O000000o);
        String token = FirebaseInstanceId.getInstance().getToken();
        if (!TextUtils.isEmpty(token)) {
            gsy.O000000o(4, "FCM-PUSH", "directly register fcm success");
            dzo.O000000o(this.f5973O000000o, token);
        }
    }

    public final void O00000Oo() {
        gsy.O000000o(4, "FCM-PUSH", "unregister fcm");
        try {
            FirebaseInstanceId.getInstance().deleteInstanceId();
        } catch (IOException unused) {
        }
        ebb.O000000o(this.f5973O000000o, e.b);
    }
}
