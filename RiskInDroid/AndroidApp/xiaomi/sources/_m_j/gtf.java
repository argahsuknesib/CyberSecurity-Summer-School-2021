package _m_j;

import android.text.TextUtils;
import android.util.SparseArray;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.BleMeshFirmwareUpdateInfoV2;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.frame.plugin.host.PluginHostApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gtf {
    public static final String[] O00000Oo = {"1", "3", "0"};
    private static volatile gtf O00000o;
    public static final String[] O00000o0 = {"on", "brightness", "color-temperature", "color"};

    /* renamed from: O000000o  reason: collision with root package name */
    public Map<String, List<String>> f18230O000000o = new ConcurrentHashMap();

    private gtf() {
    }

    public static gtf O000000o() {
        if (O00000o == null) {
            synchronized (gtf.class) {
                if (O00000o == null) {
                    O00000o = new gtf();
                }
            }
        }
        return O00000o;
    }

    public final void O00000Oo() {
        DevicelibApi.defLightGroup(CommonApplication.getAppContext(), new fsm<JSONObject, fso>() {
            /* class _m_j.gtf.AnonymousClass1 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                try {
                    gtf.this.f18230O000000o.clear();
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        JSONArray optJSONArray = jSONObject.optJSONArray(next);
                        if (optJSONArray.length() > 0) {
                            ArrayList arrayList = new ArrayList();
                            for (int i = 0; i < optJSONArray.length(); i++) {
                                arrayList.add(optJSONArray.optString(i));
                            }
                            gtf.this.f18230O000000o.put(next, arrayList);
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public static void O000000o(Set<String> set, fsm<SparseArray<List<String>>, fso> fsm) {
        DevicelibApi.queryModelFunction(CommonApplication.getAppContext(), O00000o0, set, fsm);
    }

    public final boolean O000000o(Device device) {
        if (device == null || TextUtils.isEmpty(device.model) || !device.isOwner()) {
            return false;
        }
        for (List<String> contains : this.f18230O000000o.values()) {
            if (contains.contains(device.model)) {
                return true;
            }
        }
        return false;
    }

    public final boolean O000000o(Device device, String str) {
        List list;
        if (device == null || TextUtils.isEmpty(str) || !device.isOwner() || (list = this.f18230O000000o.get(str)) == null || list.size() <= 0) {
            return false;
        }
        return list.contains(device.model);
    }

    public static boolean O00000Oo(Device device) {
        return device != null && device.pid == Device.PID_VIRTUAL_GROUP;
    }

    public final String O000000o(String str) {
        for (Map.Entry next : this.f18230O000000o.entrySet()) {
            if (((List) next.getValue()).contains(str)) {
                return (String) next.getKey();
            }
        }
        return "";
    }

    public static void O000000o(String str, List<String> list, Callback<List<BleMeshFirmwareUpdateInfoV2>> callback) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        try {
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("dids", jSONArray);
            PluginHostApi.instance().callSmartHomeApi(str, "/v2/device/batch_get_latest_ver", jSONObject, callback, $$Lambda$gtf$ElPG7ZBe9BHbtwnLrwrLiETu3Q.INSTANCE);
        } catch (JSONException e) {
            callback.onFailure(-1, e.toString());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O00000Oo(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        ArrayList arrayList = new ArrayList();
        if (jSONObject.has("list")) {
            JSONObject optJSONObject = jSONObject.optJSONObject("list");
            Iterator<String> keys = optJSONObject.keys();
            while (keys.hasNext()) {
                BleMeshFirmwareUpdateInfoV2 bleMeshFirmwareUpdateInfoV2 = new BleMeshFirmwareUpdateInfoV2();
                bleMeshFirmwareUpdateInfoV2.did = keys.next();
                JSONObject optJSONObject2 = optJSONObject.optJSONObject(bleMeshFirmwareUpdateInfoV2.did);
                if (!optJSONObject2.optBoolean("isLatest")) {
                    String optString = optJSONObject2.optString("current");
                    if (!TextUtils.isEmpty(optString)) {
                        String[] strArr = new String[2];
                        if (!TextUtils.isEmpty(optString)) {
                            if (optString.length() >= 6) {
                                String substring = optString.substring(optString.length() - 5);
                                String substring2 = optString.substring(optString.length() - 4);
                                if (substring.startsWith(".") && substring2.matches("^[0-9]+$")) {
                                    strArr[0] = optString.substring(0, optString.length() - 5);
                                    strArr[1] = substring2;
                                }
                            }
                            strArr[0] = optString;
                        }
                        bleMeshFirmwareUpdateInfoV2.currentVersion = strArr[0];
                        bleMeshFirmwareUpdateInfoV2.currentMcuVersion = strArr[1];
                    }
                    String optString2 = optJSONObject2.optString("latest");
                    if (jSONObject.has("detail")) {
                        JSONObject optJSONObject3 = jSONObject.optJSONObject("detail");
                        if (optJSONObject3.has("info")) {
                            JSONObject optJSONObject4 = optJSONObject3.optJSONObject("info");
                            if (optJSONObject4.has(optString2)) {
                                JSONObject optJSONObject5 = optJSONObject4.optJSONObject(optString2);
                                bleMeshFirmwareUpdateInfoV2.version = optJSONObject5.optString("version");
                                bleMeshFirmwareUpdateInfoV2.url = optJSONObject5.optString("url");
                                bleMeshFirmwareUpdateInfoV2.safeUrl = optJSONObject5.optString("safe_url");
                                bleMeshFirmwareUpdateInfoV2.mcuVersion = optJSONObject5.optString("mcu_version");
                                bleMeshFirmwareUpdateInfoV2.mcuSafeUrl = optJSONObject5.optString("mcu_safe_url");
                                bleMeshFirmwareUpdateInfoV2.changeLog = optJSONObject5.optString("changeLog");
                                bleMeshFirmwareUpdateInfoV2.md5 = optJSONObject5.optString("md5");
                                bleMeshFirmwareUpdateInfoV2.timeout = jSONObject.optInt("time_out", 30);
                                bleMeshFirmwareUpdateInfoV2.uploadTime = optJSONObject5.optString("upload_time");
                                arrayList.add(bleMeshFirmwareUpdateInfoV2);
                            }
                        }
                    }
                }
            }
        }
        return arrayList;
    }
}
