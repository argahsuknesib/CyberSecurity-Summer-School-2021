package _m_j;

import android.content.SharedPreferences;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hrk {
    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000Oo(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O00000o0(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public static void O000000o(String str, fsm<JSONObject, fso> fsm) {
        try {
            CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/sleepmode/devicelist").O000000o(Collections.singletonList(new KeyValuePair("data", new JSONObject().put("app_type", grr.O00000oO() ? 1 : 0).put("home_id", str).toString()))).O000000o(), $$Lambda$hrk$VHpd3foRG1OUWCL8n4L6pMfooQ.INSTANCE, Crypto.RC4, fsm);
        } catch (JSONException unused) {
        }
    }

    public static void O000000o(String str, String str2, boolean z, String str3, String str4, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", str);
            jSONObject.put("did", str2);
            jSONObject.put("switch", z);
            jSONObject.put("start_time", str3);
            jSONObject.put("end_time", str4);
        } catch (JSONException unused) {
        }
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/sleepmode/set_dev_sync_switch").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), $$Lambda$hrk$G10U0qbzem9vfK5aMcdJ_Cq81y4.INSTANCE, Crypto.RC4, fsm);
    }

    public static void O000000o(String str, String str2, String str3, ArrayList<String> arrayList, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", str);
            jSONObject.put("start_time", str2);
            jSONObject.put("end_time", str3);
            if (arrayList != null) {
                JSONArray jSONArray = new JSONArray();
                Iterator<String> it = arrayList.iterator();
                while (it.hasNext()) {
                    jSONArray.put(new JSONObject().put("did", it.next()).put("start_time", str2).put("end_time", str3));
                }
                jSONObject.put("params", jSONArray);
            }
        } catch (JSONException unused) {
        }
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/sleepmode/sync_dev_time").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), $$Lambda$hrk$IMXkCIuoBoX8jV6Jk1XoqyIQnv8.INSTANCE, Crypto.RC4, fsm);
    }

    public static String O000000o(int i) {
        return String.format(Locale.ENGLISH, "%02d", Integer.valueOf(i));
    }

    public static SharedPreferences O000000o() {
        return CommonApplication.getAppContext().getSharedPreferences("SleepModeApi", 0);
    }
}
