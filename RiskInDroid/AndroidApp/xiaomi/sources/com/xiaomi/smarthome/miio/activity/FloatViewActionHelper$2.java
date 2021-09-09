package com.xiaomi.smarthome.miio.activity;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fuj;
import _m_j.gns;
import _m_j.gsy;
import _m_j.gwk;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONObject;

public class FloatViewActionHelper$2 extends BroadcastReceiver {

    /* renamed from: O000000o  reason: collision with root package name */
    final /* synthetic */ gwk f9668O000000o;

    public FloatViewActionHelper$2(gwk gwk) {
        this.f9668O000000o = gwk;
    }

    public final void onReceive(Context context, Intent intent) {
        boolean z = ServiceApplication.getStateNotifier().f15923O000000o == 4;
        gns.O00000Oo(z);
        gsy.O00000o0(LogType.GENERAL, "zhudong_login_receiver", "isLogin:".concat(String.valueOf(z)));
        fuj.O000000o();
        fuj.O000000o(ServiceApplication.getAppContext(), Arrays.asList("miot_quickfeedback_access"), new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.miio.activity.FloatViewActionHelper$2.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    gsy.O00000o0(LogType.GENERAL, "zhudong2", "getCommonConfig ".concat(String.valueOf(jSONObject)));
                    JSONArray optJSONArray = jSONObject.optJSONArray("configInfos");
                    if (optJSONArray != null) {
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                            optJSONObject.optString("value");
                            if ("miot_quickfeedback_access".equals(optJSONObject.optString("key"))) {
                                gns.O000000o(optJSONObject.optInt("value", 1));
                            }
                        }
                    }
                } catch (Exception unused) {
                }
            }

            public final void onFailure(fso fso) {
                gsy.O00000o0(LogType.GENERAL, "zhudong2", "getUnitConfig onFailure ".concat(String.valueOf(fso)));
            }
        });
    }
}
