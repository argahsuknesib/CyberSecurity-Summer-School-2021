package _m_j;

import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.library.log.LogType;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class gek extends gdy {
    private static gek O00000Oo;

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, ArrayList<WeakReference<ezm>>> f17597O000000o = new ConcurrentHashMap();

    public static gek O000000o() {
        if (O00000Oo == null) {
            O00000Oo = new gek();
        }
        return O00000Oo;
    }

    public final boolean onReceiveMessage(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gsy.O000000o(6, "DevicePushMsg", "onReceiveMessage--> messageId is empty or messageBody is empty");
        } else {
            gsy.O00000Oo("DevicePushMsg", "onReceiveMessage--> messageId: " + str + "    messageBody: " + str2);
        }
        O000000o(str2);
        if (!gfr.O0000Oo && !gfr.O0000OOo) {
            return true;
        }
        LogType logType = LogType.PUSH;
        gsy.O000000o(logType, "DevicePushListener", "DevicePushListener-->  messageId: " + str + "   messageBody: " + str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            gsy.O000000o(6, "DevicePushMsg", "onReceiveNotifiedMessage--> messageId is empty or messageBody is empty");
        } else {
            gsy.O00000Oo("DevicePushMsg", "onReceiveNotifiedMessage--> messageId: " + str + "    messageBody: " + str2);
        }
        O000000o(str2);
        return true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    private void O000000o(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("subtype");
            if (TextUtils.isEmpty(optString)) {
                String optString2 = jSONObject.optString("subid");
                String optString3 = jSONObject.optString("did");
                String optString4 = jSONObject.optString("model");
                JSONArray optJSONArray = jSONObject.optJSONArray("attrs");
                if (!TextUtils.isEmpty(optString2)) {
                    fre.O000000o().O000000o(optString2, optString3, optString4, optJSONArray);
                } else if (!TextUtils.isEmpty(optString3) && !TextUtils.isEmpty(optString4)) {
                    if (optJSONArray != null) {
                        ArrayList arrayList = this.f17597O000000o.get(optString3 + "_" + optString4);
                        if (arrayList != null) {
                            synchronized (arrayList) {
                                for (int size = arrayList.size() - 1; size >= 0; size--) {
                                    ezm ezm = (ezm) ((WeakReference) arrayList.get(size)).get();
                                    if (ezm != null) {
                                        ezm.O000000o(optJSONArray);
                                    } else {
                                        arrayList.remove(size);
                                    }
                                }
                            }
                        }
                    }
                }
            } else if (TextUtils.equals("routerChanged", optString)) {
                Bundle bundle = new Bundle();
                bundle.putString("message_record", jSONObject.toString());
                fvj.O000000o("/message/MessageCenterWifiChangePwdActivity", bundle, false, 67108864);
            }
        } catch (Exception | JSONException unused) {
        }
    }
}
