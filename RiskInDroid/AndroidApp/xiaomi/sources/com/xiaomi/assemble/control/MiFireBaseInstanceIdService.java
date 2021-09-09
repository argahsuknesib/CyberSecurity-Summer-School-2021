package com.xiaomi.assemble.control;

import _m_j.dzo;
import _m_j.gsy;
import android.text.TextUtils;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

public class MiFireBaseInstanceIdService extends FirebaseInstanceIdService {
    public void onTokenRefresh() {
        try {
            super.onTokenRefresh();
            gsy.O000000o(4, "FCM-PUSH", "onTokenRefresh");
            String token = FirebaseInstanceId.getInstance().getToken();
            if (!dzo.O000000o(getApplicationContext())) {
                gsy.O000000o(4, "FCM-PUSH", "fcm switch is closed but get refreshed token");
            } else if (!TextUtils.isEmpty(token)) {
                gsy.O000000o(4, "FCM-PUSH", "get fcm token success! ====> ".concat(String.valueOf(token)));
                dzo.O000000o(getApplicationContext(), token);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
