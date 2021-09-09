package com.xiaomi.smarthome.miio.camera.alarm;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fss;
import _m_j.gkv;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraAlarmNetUtils {
    private static volatile CameraAlarmNetUtils instance;

    private CameraAlarmNetUtils() {
    }

    public static CameraAlarmNetUtils getInstance() {
        if (instance == null) {
            synchronized (CameraAlarmNetUtils.class) {
                if (instance == null) {
                    instance = new CameraAlarmNetUtils();
                }
            }
        }
        return instance;
    }

    public void getAlarmStatus(String str, final ICameraAlarmCallback<JSONObject> iCameraAlarmCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/get/alarmSwitch").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.miio.camera.alarm.CameraAlarmNetUtils.AnonymousClass1 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.alarm.CameraAlarmNetUtils.AnonymousClass2 */

                public void onSuccess(JSONObject jSONObject) {
                    ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                    if (iCameraAlarmCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        iCameraAlarmCallback.onSuccess(jSONObject, null);
                    } else {
                        iCameraAlarmCallback.onFailure(-80002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                    if (iCameraAlarmCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCameraAlarmCallback.onFailure(i, fso.O00000Oo);
                        return;
                    }
                    iCameraAlarmCallback.onFailure(-80001, "FAIL_GENERAL");
                }
            });
        } else if (iCameraAlarmCallback != null) {
            iCameraAlarmCallback.onFailure(-80001, "params is empty");
        }
    }

    public void getAlarmList(String str, final ICameraAlarmCallback<JSONObject> iCameraAlarmCallback) {
        if (!TextUtils.isEmpty(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", str));
            CoreApi.O000000o().O000000o(gkv.f17949O000000o, new NetRequest.O000000o().O00000o0("business.smartcamera.").O000000o("GET").O00000Oo("/miot/camera/app/v1/alarm/playlist/limit").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class com.xiaomi.smarthome.miio.camera.alarm.CameraAlarmNetUtils.AnonymousClass3 */

                public JSONObject parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class com.xiaomi.smarthome.miio.camera.alarm.CameraAlarmNetUtils.AnonymousClass4 */

                public void onSuccess(JSONObject jSONObject) {
                    ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                    if (iCameraAlarmCallback == null) {
                        return;
                    }
                    if (jSONObject != null) {
                        iCameraAlarmCallback.onSuccess(jSONObject, null);
                    } else {
                        iCameraAlarmCallback.onFailure(-80002, "result is null");
                    }
                }

                public void onFailure(fso fso) {
                    ICameraAlarmCallback iCameraAlarmCallback = iCameraAlarmCallback;
                    if (iCameraAlarmCallback == null) {
                        return;
                    }
                    if (fso != null) {
                        int i = fso.f17063O000000o;
                        iCameraAlarmCallback.onFailure(i, fso.O00000Oo);
                        return;
                    }
                    iCameraAlarmCallback.onFailure(-80001, "FAIL_GENERAL");
                }
            });
        } else if (iCameraAlarmCallback != null) {
            iCameraAlarmCallback.onFailure(-80001, "params is empty");
        }
    }
}
