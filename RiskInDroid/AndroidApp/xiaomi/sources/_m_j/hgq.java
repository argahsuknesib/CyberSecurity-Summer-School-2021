package _m_j;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.newui.roomenv.model.RoomEnvData;
import com.xiaomi.smarthome.newui.roomenv.model.RoomEnvDataItem;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class hgq {

    /* renamed from: O000000o  reason: collision with root package name */
    static final String f18912O000000o = "hgq";
    private static volatile hgq O00000o0;
    public volatile Map<String, Map<String, RoomEnvData>> O00000Oo = new ConcurrentHashMap();

    private hgq() {
        goq.O000000o(new Runnable() {
            /* class _m_j.hgq.AnonymousClass1 */

            public final void run() {
                JSONArray optJSONArray;
                JSONArray optJSONArray2;
                RoomEnvData O000000o2;
                hgq hgq = hgq.this;
                Context appContext = ServiceApplication.getAppContext();
                String string = appContext.getSharedPreferences("room_env_data_" + grv.O000000o(CoreApi.O000000o().O0000o0()), 0).getString("data", null);
                gsy.O00000Oo(hgq.f18912O000000o, "dumpFromStore:".concat(String.valueOf(string)));
                if (!TextUtils.isEmpty(string)) {
                    try {
                        JSONObject jSONObject = new JSONObject(string);
                        if (System.currentTimeMillis() - jSONObject.optLong("stored_ts") > 259200000 || (optJSONArray = jSONObject.optJSONArray("env_data")) == null) {
                            return;
                        }
                        if (optJSONArray.length() > 0) {
                            ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                                if (optJSONObject != null) {
                                    String optString = optJSONObject.optString("home_id");
                                    if (!(TextUtils.isEmpty(optString) || (optJSONArray2 = jSONObject.optJSONArray("data")) == null || optJSONArray2.length() == 0)) {
                                        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
                                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                                            JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                                            if (!(optJSONObject2 == null || (O000000o2 = RoomEnvData.O000000o(optJSONObject2)) == null)) {
                                                O000000o2.O00000o0 = optString;
                                                concurrentHashMap2.put(O000000o2.O00000Oo, O000000o2);
                                            }
                                        }
                                        if (!concurrentHashMap2.isEmpty()) {
                                            concurrentHashMap.put(optString, concurrentHashMap2);
                                        }
                                    }
                                }
                            }
                            if (!concurrentHashMap.isEmpty()) {
                                hgq.O00000Oo = concurrentHashMap;
                            }
                            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("room_env_data_updated"));
                            String str = hgq.f18912O000000o;
                            gsy.O00000Oo(str, "dumpFromStore map size:" + concurrentHashMap.size());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public static hgq O000000o() {
        if (O00000o0 == null) {
            synchronized (hgq.class) {
                if (O00000o0 == null) {
                    O00000o0 = new hgq();
                }
            }
        }
        return O00000o0;
    }

    public final void O00000Oo() {
        RoomEnvData roomEnvData;
        String str;
        Iterator<Map.Entry<String, Map<String, RoomEnvData>>> it;
        String str2;
        Iterator<Map.Entry<String, Map<String, RoomEnvData>>> it2;
        String str3 = "home_id";
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            Iterator<Map.Entry<String, Map<String, RoomEnvData>>> it3 = this.O00000Oo.entrySet().iterator();
            while (it3.hasNext()) {
                Map.Entry next = it3.next();
                if (next != null) {
                    String str4 = (String) next.getKey();
                    Map map = (Map) next.getValue();
                    if (map != null) {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put(str3, str4);
                        JSONArray jSONArray2 = new JSONArray();
                        for (Map.Entry entry : map.entrySet()) {
                            if (entry != null && (roomEnvData = (RoomEnvData) entry.getValue()) != null) {
                                JSONObject jSONObject3 = new JSONObject();
                                jSONObject3.put(str3, roomEnvData.O00000o0);
                                jSONObject3.put("room_id", roomEnvData.O00000Oo);
                                List<RoomEnvDataItem> list = roomEnvData.f10270O000000o;
                                if (list == null || list.isEmpty()) {
                                    str = str3;
                                    it = it3;
                                } else {
                                    JSONArray jSONArray3 = new JSONArray();
                                    int i = 0;
                                    while (i < list.size()) {
                                        RoomEnvDataItem roomEnvDataItem = list.get(i);
                                        if (roomEnvDataItem != null) {
                                            JSONObject jSONObject4 = new JSONObject();
                                            str2 = str3;
                                            jSONObject4.put("attr_type", roomEnvDataItem.O00000oO);
                                            jSONObject4.put("desc_name", roomEnvDataItem.f10271O000000o);
                                            jSONObject4.put("did", roomEnvDataItem.O00000oo);
                                            jSONObject4.put("prop", roomEnvDataItem.O00000o0);
                                            it2 = it3;
                                            jSONObject4.put("timestamp", roomEnvDataItem.O00000Oo);
                                            jSONObject4.put("value", roomEnvDataItem.O00000o);
                                            jSONArray3.put(jSONObject4);
                                        } else {
                                            str2 = str3;
                                            it2 = it3;
                                        }
                                        i++;
                                        it3 = it2;
                                        str3 = str2;
                                    }
                                    str = str3;
                                    it = it3;
                                    jSONObject3.put("desc_list", jSONArray3);
                                }
                                jSONArray2.put(jSONObject3);
                                it3 = it;
                                str3 = str;
                            }
                        }
                        jSONObject2.put("data", jSONArray2);
                        jSONArray.put(jSONObject2);
                        it3 = it3;
                        str3 = str3;
                    }
                }
            }
            jSONObject.put("env_data", jSONArray);
            jSONObject.put("stored_ts", System.currentTimeMillis());
            String jSONObject5 = jSONObject.toString();
            gsy.O00000Oo(f18912O000000o, "dumpToStore:".concat(String.valueOf(jSONObject5)));
            Context appContext = ServiceApplication.getAppContext();
            gpv.O00000o0(appContext.getSharedPreferences("room_env_data_" + grv.O000000o(CoreApi.O000000o().O0000o0()), 0), "data", jSONObject5);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
