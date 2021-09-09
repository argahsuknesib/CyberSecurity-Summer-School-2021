package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.miio.consumables.Consumable;
import com.xiaomi.smarthome.miio.consumables.DeviceConsumble;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gww {
    public static DeviceConsumble O000000o(Context context, JSONObject jSONObject) {
        JSONArray optJSONArray;
        DeviceConsumble deviceConsumble = new DeviceConsumble();
        String str = null;
        if (jSONObject == null) {
            return null;
        }
        deviceConsumble.did = jSONObject.optString("did");
        Device O000000o2 = fno.O000000o().O000000o(deviceConsumble.did);
        if (O000000o2 != null) {
            str = O000000o2.model;
        }
        if (jSONObject.has("details") && (optJSONArray = jSONObject.optJSONArray("details")) != null) {
            for (int i = 0; i < optJSONArray.length(); i++) {
                Consumable parseFrom = Consumable.parseFrom(context, optJSONArray.optJSONObject(i));
                parseFrom.parentPos = i;
                if (!TextUtils.isEmpty(str)) {
                    parseFrom.model = str;
                }
                deviceConsumble.consumables.add(parseFrom);
            }
        }
        if (jSONObject.has("skip_rpc")) {
            deviceConsumble.isSkipRpc = jSONObject.optBoolean("skip_rpc");
        }
        if (jSONObject.has("ble_gateway")) {
            deviceConsumble.isBleGateway = jSONObject.optBoolean("ble_gateway");
        }
        if (jSONObject.has("isOnline")) {
            deviceConsumble.isOnline = jSONObject.optBoolean("isOnline");
        }
        deviceConsumble.childSize = deviceConsumble.consumables.size();
        return deviceConsumble;
    }

    public static JSONObject O000000o(DeviceConsumble deviceConsumble) {
        if (deviceConsumble == null) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            if (deviceConsumble.did != null) {
                jSONObject.put("did", deviceConsumble.did);
            }
            if (deviceConsumble.consumables != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < deviceConsumble.consumables.size(); i++) {
                    JSONObject json = Consumable.toJson(deviceConsumble.consumables.get(i));
                    if (json != null) {
                        jSONArray.put(json);
                    }
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("details", jSONArray);
                }
                jSONObject.put("skip_rpc", deviceConsumble.isSkipRpc);
                jSONObject.put("ble_gateway", deviceConsumble.isBleGateway);
                jSONObject.put("childSize", O000000o(deviceConsumble.consumables));
                jSONObject.put("isOnline", deviceConsumble.isOnline);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static int O000000o(Object obj) {
        int i = 0;
        if (obj == null) {
            return 0;
        }
        if (obj instanceof Map) {
            return ((Map) obj).size();
        }
        if (obj instanceof Collection) {
            return ((Collection) obj).size();
        }
        if (obj instanceof Iterator) {
            Iterator it = (Iterator) obj;
            while (it.hasNext()) {
                i++;
                it.next();
            }
        } else if (obj instanceof Enumeration) {
            Enumeration enumeration = (Enumeration) obj;
            while (enumeration.hasMoreElements()) {
                i++;
                enumeration.nextElement();
            }
        } else {
            try {
                return Array.getLength(obj);
            } catch (IllegalArgumentException unused) {
                throw new IllegalArgumentException("Unsupported object type: " + obj.getClass().getName());
            }
        }
        return i;
    }
}
