package com.xiaomi.smarthome.device.api;

import _m_j.fsm;
import _m_j.fsn;
import _m_j.fso;
import _m_j.fss;
import _m_j.gse;
import _m_j.gsi;
import _m_j.gst;
import android.content.Context;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;

public class CameraApi {
    private static volatile CameraApi sInstance;
    private static final Object sLock = new Object();

    private CameraApi() {
    }

    public static CameraApi getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new CameraApi();
                }
            }
        }
        return sInstance;
    }

    public fsn bindCameraWsDevice(Context context, String str, int i, String str2, fsm<Integer, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("pid", i);
            jSONObject.put("verify_code", str2);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/home/binddevice").O000000o(arrayList).O000000o(), new fss<Integer>() {
            /* class com.xiaomi.smarthome.device.api.CameraApi.AnonymousClass1 */

            public Integer parse(JSONObject jSONObject) throws JSONException {
                return Integer.valueOf(jSONObject.getInt("ret"));
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getBindKey(Context context, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_bindkey").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class com.xiaomi.smarthome.device.api.CameraApi.AnonymousClass2 */

            public String parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.optString("bindkey");
            }
        }, Crypto.RC4, fsm);
    }

    public fsn getBindKeyAndExpireTime(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", new JSONObject().toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/get_bindkey").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.CameraApi.AnonymousClass3 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn checkBindKey(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("bindkey", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/user/check_bindkey").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class com.xiaomi.smarthome.device.api.CameraApi.AnonymousClass4 */

            public JSONObject parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public fsn dotriggleCameraAudioToken(Device device, fsm<Void, fso> fsm) {
        return httpRequestAsync(CommonApplication.getAppContext(), String.format("http://%s/cgi-bin/start_bind_xm.cgi", device.ip), null, fsm);
    }

    public fsn doBindCameraSuscess(Device device, fsm<Void, fso> fsm) {
        return httpRequestAsync(CommonApplication.getAppContext(), String.format("http://%s/cgi-bin/bind_success_xm.cgi", device.ip), null, fsm);
    }

    private fsn httpRequestAsync(Context context, String str, List<gsi> list, final fsm<Void, fso> fsm) {
        Call newCall = gse.O000000o().newCall(new Request.Builder().url(gst.O000000o(str, list)).tag(context).build());
        newCall.enqueue(new Callback() {
            /* class com.xiaomi.smarthome.device.api.CameraApi.AnonymousClass5 */

            public void onFailure(Call call, IOException iOException) {
                String str;
                fsm fsm = fsm;
                if (fsm != null) {
                    int code = ErrorCode.INVALID.getCode();
                    if (iOException == null) {
                        str = "request failure";
                    } else {
                        str = iOException.getMessage();
                    }
                    fsm.sendFailureMessage(new fso(code, str));
                }
            }

            public void onResponse(Call call, Response response) throws IOException {
                if (response == null) {
                    fsm fsm = fsm;
                    if (fsm != null) {
                        fsm.sendFailureMessage(new fso(ErrorCode.INVALID.getCode(), "response is null"));
                    }
                } else if (response.isSuccessful()) {
                    fsm fsm2 = fsm;
                    if (fsm2 != null) {
                        fsm2.sendSuccessMessage(null);
                    }
                } else {
                    fsm fsm3 = fsm;
                    if (fsm3 != null) {
                        fsm3.sendFailureMessage(new fso(response.code(), "request failure"));
                    }
                }
            }
        });
        return new fsn(newCall);
    }
}
