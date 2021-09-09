package com.xiaomi.smarthome.facebook.sdk;

import _m_j.fdb;
import _m_j.gsy;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.facebook.AccessTokenManager;
import com.facebook.FacebookSdk;
import com.xiaomi.smarthome.library.log.LogType;

public class CurrentAccessTokenExpirationBroadcastReceiverDelegate extends BroadcastReceiver {
    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fdb.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method
     arg types: [java.lang.Class, java.lang.String, java.lang.Class[]]
     candidates:
      _m_j.fdb.O000000o(java.lang.Object, java.lang.String, java.lang.Object):void
      _m_j.fdb.O000000o(java.lang.Class<?>, java.lang.String, java.lang.Class<?>[]):java.lang.reflect.Method */
    public void onReceive(Context context, Intent intent) {
        gsy.O00000Oo(LogType.GENERAL, "FB-Expir-RECE", "onReceive");
        if (!FacebookSdk.isInitialized()) {
            gsy.O00000Oo(LogType.GENERAL, "FB-Expir-RECE", "onReceive not initialized.");
        } else if ("com.facebook.sdk.ACTION_CURRENT_ACCESS_TOKEN_CHANGED".equals(intent.getAction())) {
            try {
                fdb.O000000o((Class<?>) AccessTokenManager.class, "currentAccessTokenChanged", (Class<?>[]) new Class[0]).invoke(fdb.O000000o((Class<?>) AccessTokenManager.class, "getInstance", (Class<?>[]) new Class[0]).invoke(null, new Object[0]), new Object[0]);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
