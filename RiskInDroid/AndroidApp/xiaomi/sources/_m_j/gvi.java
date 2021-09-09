package _m_j;

import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.multikey.PowerMultikeyBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class gvi {
    private static volatile gvi O00000o = null;
    private static final String O00000o0 = "gvi";

    /* renamed from: O000000o  reason: collision with root package name */
    public List<String> f18373O000000o = new ArrayList();
    public Map<String, List<String>> O00000Oo = new HashMap();

    public static gvi O000000o() {
        if (O00000o == null) {
            synchronized (gvi.class) {
                if (O00000o == null) {
                    O00000o = new gvi();
                }
            }
        }
        return O00000o;
    }

    private gvi() {
    }

    public final List<String> O000000o(String str, fsm<List<String>, fso> fsm, boolean z, String str2) {
        if (fsm == null) {
            Map<String, List<String>> map = this.O00000Oo;
            return map.get(str + str2);
        }
        if (z) {
            O000000o(str, fsm, str2);
        }
        Map<String, List<String>> map2 = this.O00000Oo;
        return map2.get(str + str2);
    }

    public final void O000000o(String str, List<String> list, fsm<JSONObject, fso> fsm, String str2, List<PowerMultikeyBean> list2) {
        final fsm<JSONObject, fso> fsm2 = fsm;
        final String str3 = str;
        final String str4 = str2;
        final List<String> list3 = list;
        DeviceApi.getInstance().updateDeviceAlias(str, list, new fsm<JSONObject, fso>() {
            /* class _m_j.gvi.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                fsm fsm = fsm2;
                if (fsm != null) {
                    fsm.onSuccess(jSONObject);
                }
                if (jSONObject != null && jSONObject.optInt("code") == 0) {
                    Map<String, List<String>> map = gvi.this.O00000Oo;
                    map.put(str3 + str4, list3);
                }
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm2;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        }, str2, list2);
    }

    private void O000000o(final String str, final fsm<List<String>, fso> fsm, final String str2) {
        DeviceApi.getInstance().getDeviceAlias(str, new fsm<JSONObject, fso>() {
            /* class _m_j.gvi.AnonymousClass3 */

            public final /* synthetic */ void onSuccess(Object obj) {
                fsm fsm;
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    fsm fsm2 = fsm;
                    if (fsm2 != null) {
                        fsm2.onFailure(new fso(-1, "response is null or result is null"));
                        return;
                    }
                    return;
                }
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    JSONArray optJSONArray = jSONObject.optJSONArray(next);
                    if (optJSONArray != null && optJSONArray.length() > 0) {
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            arrayList.add(optJSONArray.optString(i));
                        }
                        Map<String, List<String>> map = gvi.this.O00000Oo;
                        map.put(str + next, arrayList);
                    }
                }
                Map<String, List<String>> map2 = gvi.this.O00000Oo;
                List list = map2.get(str + str2);
                if (list != null || (fsm = fsm) == null) {
                    fsm fsm3 = fsm;
                    if (fsm3 != null) {
                        fsm3.onSuccess(list);
                        return;
                    }
                    return;
                }
                fsm.onFailure(new fso(-1, "result cannot cast to JSONArray"));
            }

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        });
    }
}
