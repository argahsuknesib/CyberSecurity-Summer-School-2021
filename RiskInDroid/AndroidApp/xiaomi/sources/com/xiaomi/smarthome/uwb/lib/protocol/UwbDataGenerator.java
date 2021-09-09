package com.xiaomi.smarthome.uwb.lib.protocol;

import android.util.Pair;
import com.xiaomi.idm.uwb.constant.UwbConst;
import com.xiaomi.smarthome.uwb.lib.mitv.parse.TVUwbDataBuilder;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Payload;
import com.xiaomi.smarthome.uwb.lib.protocol.format.Type;
import com.xiaomi.smarthome.uwb.lib.utils.RandomUtils;
import java.io.IOException;
import org.json.JSONObject;

public class UwbDataGenerator {
    public static Payload toPayload(UwbConst.AppId appId, Type type, String str, UwbConst.Target target) {
        try {
            return new Payload(appId, type, str.getBytes("UTF-8"), target);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Payload toPayload(UwbConst.AppId appId, Type type, byte[] bArr, UwbConst.Target target) {
        try {
            return new Payload(appId, type, bArr, target);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Payload generateMitvDidCmdPlayload() {
        return new Payload(UwbConst.AppId.MI_LINK, Type.JSON, TVUwbDataBuilder.buildRequestDataByteArray("reqTvKey", null), UwbConst.Target.SEND_DATA_TO_HID);
    }

    public static Pair<String, JSONObject> wrapWithIdHeader(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        if (!jSONObject.has("header")) {
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("data", jSONObject);
                JSONObject jSONObject3 = new JSONObject();
                String valueOf = String.valueOf(RandomUtils.nextInt(8388607, Integer.MAX_VALUE));
                jSONObject3.put("id", valueOf);
                jSONObject2.put("header", jSONObject3);
                return new Pair<>(valueOf, jSONObject2);
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("header");
            try {
                String valueOf2 = String.valueOf(RandomUtils.nextInt(8388607, Integer.MAX_VALUE));
                optJSONObject.put("id", valueOf2);
                jSONObject.put("header", optJSONObject);
                return new Pair<>(valueOf2, jSONObject);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }
}
