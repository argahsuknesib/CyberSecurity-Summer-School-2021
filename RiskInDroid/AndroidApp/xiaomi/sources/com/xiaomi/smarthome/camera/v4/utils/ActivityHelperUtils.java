package com.xiaomi.smarthome.camera.v4.utils;

import _m_j.cle;
import _m_j.clf;
import _m_j.gsy;
import _m_j.hxi;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Locale;
import org.json.JSONObject;

public class ActivityHelperUtils {
    private static ActivityHelperUtils activityHelperUtils;

    private ActivityHelperUtils() {
    }

    public static ActivityHelperUtils getInstance() {
        if (activityHelperUtils == null) {
            synchronized (ActivityHelperUtils.class) {
                if (activityHelperUtils == null) {
                    activityHelperUtils = new ActivityHelperUtils();
                }
            }
        }
        return activityHelperUtils;
    }

    public void statProfileBabyCrySwitch(cle cle, final String str, String str2) {
        if (cle != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("did", str2);
                jSONObject.put("region", Locale.getDefault().getCountry());
                clf.O000000o().O000000o(str, jSONObject.toString(), new Callback<JSONObject>(str, new cle.O000000o() {
                    /* class com.xiaomi.smarthome.camera.v4.utils.ActivityHelperUtils.AnonymousClass1 */

                    public void onSuccess(Object obj, Object obj2) {
                        JSONObject optJSONObject;
                        JSONObject jSONObject = (JSONObject) obj;
                        if (jSONObject != null && jSONObject.optInt("code") == 0 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            hxi.O00000o.f952O000000o.O000000o("BabyCry_Setting_Status", "type", Integer.valueOf(optJSONObject.optBoolean("babyCrySwitch", false) ? 1 : 2));
                        }
                    }

                    public void onFailure(int i, String str) {
                        LogType logType = LogType.CAMERA;
                        String str2 = str;
                        gsy.O000000o(logType, str2, 6, "ActivityHelperUtils", "getAlarmConfig2 i:" + i + " s:" + str);
                    }
                }) {
                    /* class _m_j.cle.AnonymousClass11 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ String f14023O000000o;
                    final /* synthetic */ O000000o O00000Oo;

                    {
                        this.f14023O000000o = r2;
                        this.O00000Oo = r3;
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        JSONObject jSONObject = (JSONObject) obj;
                        LogType logType = LogType.CAMERA;
                        String str = this.f14023O000000o;
                        gsy.O00000o0(logType, str, "AlarmManagerV2", "getAlarmConfig2(" + cle.this.O00000oO.getDid() + "):" + jSONObject.toString());
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            o000000o.onSuccess(jSONObject, null);
                        }
                    }

                    public final void onFailure(int i, String str) {
                        LogType logType = LogType.CAMERA;
                        String str2 = this.f14023O000000o;
                        gsy.O000000o(logType, str2, 6, "AlarmManagerV2", "getAlarmConfig2 i:" + i + " s:" + str);
                        O000000o o000000o = this.O00000Oo;
                        if (o000000o != null) {
                            o000000o.onFailure(i, str);
                        }
                    }
                });
            } catch (Exception unused) {
            }
        }
    }
}
