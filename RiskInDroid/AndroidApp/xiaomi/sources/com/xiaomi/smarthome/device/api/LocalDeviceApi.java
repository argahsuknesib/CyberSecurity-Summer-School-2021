package com.xiaomi.smarthome.device.api;

import _m_j.dxe;
import _m_j.fno;
import _m_j.fsm;
import _m_j.fso;
import _m_j.gsy;
import android.text.TextUtils;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class LocalDeviceApi {
    private static volatile LocalDeviceApi sInstance;
    private static final Object sLock = new Object();

    private LocalDeviceApi() {
    }

    public static LocalDeviceApi getInstance() {
        if (sInstance == null) {
            synchronized (sLock) {
                if (sInstance == null) {
                    sInstance = new LocalDeviceApi();
                }
            }
        }
        return sInstance;
    }

    public static void parseRpcResponse(String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            if (AnonymousClass2.$SwitchMap$com$xiaomi$smarthome$frame$ErrorCode[ErrorCode.valueof(optInt).ordinal()] == 1) {
                JSONObject optJSONObject = jSONObject.optJSONObject("result");
                if (optJSONObject == null) {
                    optJSONObject = jSONObject;
                }
                if (fsm != null) {
                    fsm.sendSuccessMessage(optJSONObject);
                }
            } else if (fsm != null) {
                fsm.sendFailureMessage(new fso(optInt, ""));
            }
        } catch (JSONException unused) {
            if (fsm != null) {
                fsm.sendFailureMessage(new fso(ErrorCode.ERROR_RESPONSE_JSON_FAIL.getCode(), ""));
            }
        }
    }

    /* renamed from: com.xiaomi.smarthome.device.api.LocalDeviceApi$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$xiaomi$smarthome$frame$ErrorCode = new int[ErrorCode.values().length];

        static {
            try {
                $SwitchMap$com$xiaomi$smarthome$frame$ErrorCode[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    public void rpcAsync(String str, String str2, final fsm<JSONObject, fso> fsm) {
        gsy.O000000o(LogType.KUAILIAN, "", "localApi ".concat(String.valueOf(str2)));
        String ipByDid = getIpByDid(str);
        if (TextUtils.isEmpty(ipByDid)) {
            gsy.O000000o(LogType.KUAILIAN, "", "ip is empty");
            fsm.sendFailureMessage(new fso(ErrorCode.ERROR_NETWORK_ERROR.getCode(), "ip is empty"));
            return;
        }
        MiioLocalAPI.O000000o(ipByDid, str2, new dxe() {
            /* class com.xiaomi.smarthome.device.api.LocalDeviceApi.AnonymousClass1 */

            public void onResponse(String str) {
                LocalDeviceApi.parseRpcResponse(str, fsm);
            }
        });
    }

    private String getIpByDid(String str) {
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (device.did != null && device.did.equalsIgnoreCase(str)) {
                return device.ip;
            }
        }
        return null;
    }
}
