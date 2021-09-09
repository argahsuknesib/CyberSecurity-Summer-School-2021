package _m_j;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.xiaomi.smarthome.framework.plugin.rn.constants.RnApiErrorInfo;

public final class gbq {
    public static WritableMap O000000o(int i, String str) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("code", i);
        if (str == null) {
            str = "";
        }
        createMap.putString("message", str);
        return createMap;
    }

    public static WritableMap O000000o(RnApiErrorInfo rnApiErrorInfo, String str) {
        return O000000o(rnApiErrorInfo.getCode(), str);
    }

    public static WritableMap O000000o(int i, Object obj, String str) {
        WritableMap O000000o2 = O000000o(i, obj);
        O000000o2.putString("message", str);
        return O000000o2;
    }

    public static WritableMap O000000o(int i, Object obj) {
        WritableMap createMap = Arguments.createMap();
        createMap.putInt("code", i);
        if (obj == null) {
            createMap.putString("data", "");
        } else if (obj instanceof Boolean) {
            createMap.putBoolean("data", ((Boolean) obj).booleanValue());
        } else if (obj instanceof Double) {
            createMap.putDouble("data", ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            createMap.putInt("data", ((Integer) obj).intValue());
        } else if (obj instanceof WritableArray) {
            createMap.putArray("data", (WritableArray) obj);
        } else if (obj instanceof WritableMap) {
            createMap.putMap("data", (WritableMap) obj);
        } else {
            createMap.putString("data", obj.toString());
        }
        return createMap;
    }
}
