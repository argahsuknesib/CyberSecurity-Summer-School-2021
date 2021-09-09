package _m_j;

import _m_j.gti;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gtg {
    private static gtg O0000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    public frd f18232O000000o;
    public HashMap<String, List<gtn>> O00000Oo = new HashMap<>();
    public Map<String, Map<String, Object>> O00000o = new ConcurrentHashMap();
    public HashMap<String, List<gtn>> O00000o0 = new HashMap<>();
    public Map<String, Map<String, Object>> O00000oO = new ConcurrentHashMap();
    public Map<String, Object> O00000oo = new ConcurrentHashMap();
    public Map<String, Object> O0000O0o = new ConcurrentHashMap();
    public Map<String, Object> O0000OOo = new ConcurrentHashMap();
    public Map<String, Long> O0000Oo = new ConcurrentHashMap();
    public Map<String, Object> O0000Oo0 = new ConcurrentHashMap();
    public Map<String, Long> O0000OoO = new ConcurrentHashMap();
    public SharedPreferences O0000Ooo;
    public Handler O0000o00 = new Handler(Looper.getMainLooper()) {
        /* class _m_j.gtg.AnonymousClass1 */

        public final void handleMessage(Message message) {
            O000000o o000000o;
            if (message.what == 1 && (o000000o = (O000000o) message.obj) != null) {
                gtg.this.O00000o0.clear();
                gtg.this.O00000o0.putAll(o000000o.f18237O000000o);
                gtg.this.O0000OoO.clear();
                gtg.this.O0000OoO.putAll(o000000o.O00000o0);
                gtg.this.O0000Oo0.clear();
                gtg.this.O0000Oo0.putAll(o000000o.O00000Oo);
                gtg.this.O0000O0o.clear();
                gtg.this.O0000O0o.putAll(o000000o.O00000o);
            }
        }
    };
    private Map<String, WeakReference<Runnable>> O0000o0O = new ConcurrentHashMap();

    public static gtg O000000o() {
        if (O0000o0 == null) {
            O0000o0 = new gtg();
        }
        return O0000o0;
    }

    private gtg() {
        Context context = gkv.f17949O000000o;
        this.O0000Ooo = context.getSharedPreferences("camera_op_" + CoreApi.O000000o().O0000o0(), 0);
    }

    static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        HashMap<String, List<gtn>> f18237O000000o = new HashMap<>();
        Map<String, Object> O00000Oo = new ConcurrentHashMap();
        Map<String, Object> O00000o = new HashMap();
        Map<String, Long> O00000o0 = new ConcurrentHashMap();

        private O000000o() {
        }
    }

    public final Map<String, Object> O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00000o.get(str);
    }

    private static JSONObject O000000o(Device device, List<gtn> list) {
        JSONObject jSONObject = new JSONObject();
        HashSet hashSet = new HashSet();
        for (int i = 0; i < list.size(); i++) {
            gtn gtn = list.get(i);
            if (device.model.startsWith("lumi.sensor_magnet.")) {
                hashSet.add("event.open");
                hashSet.add("event.close");
            } else if (!TextUtils.isEmpty(gtn.O000000o())) {
                hashSet.add(gtn.O000000o());
            }
        }
        if (hashSet.size() > 0) {
            try {
                jSONObject.put("did", device.did);
                JSONArray jSONArray = new JSONArray();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    String str = (String) it.next();
                    if (device.model.startsWith("rockrobo.vacuum.v1")) {
                        jSONArray.put("event.".concat(String.valueOf(str)));
                    } else {
                        jSONArray.put("prop.".concat(String.valueOf(str)));
                    }
                }
                jSONObject.put("props", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public final void O000000o(final List<Device> list, final fsm<Void, fso> fsm) {
        List list2;
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            Device device = list.get(i);
            if (!(device == null || (list2 = this.O00000Oo.get(device.model)) == null)) {
                jSONArray.put(O000000o(device, list2));
            }
        }
        if (jSONArray.length() > 0) {
            DevicelibApi.batchGetDeviceProps(gkv.f17949O000000o, jSONArray, new fsm<String, fso>() {
                /* class _m_j.gtg.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str = (String) obj;
                    ArrayList arrayList = new ArrayList();
                    for (Device device : list) {
                        arrayList.add(device.did);
                    }
                    gtg.this.O000000o(str, arrayList);
                    fsm.onSuccess(null);
                }

                public final void onFailure(fso fso) {
                    fsm.onSuccess(null);
                }
            }, gtg.class.getSimpleName());
        } else {
            fsm.onSuccess(null);
        }
    }

    private void O00000Oo() {
        String str;
        Set<String> keySet = this.O00000o.keySet();
        JSONArray jSONArray = new JSONArray();
        for (String next : keySet) {
            JSONObject jSONObject = new JSONObject();
            try {
                Map map = this.O00000o.get(next);
                if (map != null) {
                    Set<String> keySet2 = map.keySet();
                    JSONObject jSONObject2 = new JSONObject();
                    for (String str2 : keySet2) {
                        jSONObject2.put(str2, map.get(str2));
                    }
                    jSONObject.put(next, jSONObject2);
                    jSONArray.put(jSONObject);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        SharedPreferences.Editor edit = this.O0000Ooo.edit();
        if (CoreApi.O000000o().O0000Ooo()) {
            str = CoreApi.O000000o().O0000o0() + "_device_prop_config";
        } else {
            str = "device_prop_config";
        }
        edit.putString(str, jSONArray.toString());
        edit.commit();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, List<String> list) {
        Device O00000o02;
        Map<String, Map<String, Object>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (list.size() > 0) {
                concurrentHashMap = this.O00000o;
            }
            while (keys.hasNext()) {
                String next = keys.next();
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null) {
                    HashMap hashMap = new HashMap();
                    Iterator<String> keys2 = optJSONObject.keys();
                    while (keys2.hasNext()) {
                        String next2 = keys2.next();
                        Object obj = optJSONObject.get(next2);
                        if (next2.startsWith("prop.")) {
                            next2 = next2.substring(5);
                        } else if (next2.startsWith("event.")) {
                            next2 = next2.substring(6);
                        }
                        if (obj != null && !obj.toString().equals("null")) {
                            hashMap.put(next2, String.valueOf(obj));
                        }
                    }
                    gsy.O000000o(6, "device_rpc", "get props, did - " + next + ", " + hashMap.toString());
                    concurrentHashMap.put(next, hashMap);
                }
            }
            this.O00000o = concurrentHashMap;
            HashSet hashSet = new HashSet();
            HashMap hashMap2 = new HashMap();
            ArrayList<gti.O000000o> arrayList = gti.O000000o().O00000o0;
            if (arrayList != null) {
                for (gti.O000000o o000000o : arrayList) {
                    for (gti.O000000o.C0109O000000o next3 : o000000o.O00000oO) {
                        if (!hashMap2.containsKey(next3.f18249O000000o) && (O00000o02 = fno.O000000o().O00000o0(next3.f18249O000000o)) != null) {
                            hashMap2.put(next3.f18249O000000o, O00000o02);
                        }
                    }
                }
                hashSet.addAll(hashMap2.values());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(hashSet);
                hashSet.clear();
                if (this.f18232O000000o == null) {
                    this.f18232O000000o = new frd();
                }
                this.f18232O000000o.init(arrayList2, new frf() {
                    /* class _m_j.gtg.AnonymousClass4 */

                    public final List<String> O000000o(String str) {
                        Map<String, Object> O000000o2 = gtg.this.O000000o(str);
                        if (O000000o2 == null || O000000o2.size() == 0) {
                            return null;
                        }
                        return new ArrayList(O000000o2.keySet());
                    }

                    public final void O000000o(String str, JSONArray jSONArray) {
                        gtg gtg = gtg.this;
                        gsy.O000000o(6, "device_rpc", str + " prop changed, " + jSONArray.toString());
                        Map map = gtg.O00000o.get(str);
                        if (map == null) {
                            map = new HashMap();
                            gtg.O00000o.put(str, map);
                        }
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null && !optJSONObject.isNull("key") && !optJSONObject.isNull("value")) {
                                String optString = optJSONObject.optString("key");
                                if (!TextUtils.isEmpty(optString) && optString.startsWith("prop.")) {
                                    String substring = optString.substring(5);
                                    Object opt = optJSONObject.opt("value");
                                    if ((opt instanceof JSONArray) && ((JSONArray) opt).length() > 0) {
                                        try {
                                            opt = ((JSONArray) opt).get(0);
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                    map.put(substring, opt);
                                }
                            }
                        }
                        ft.O000000o(gkv.f17949O000000o).O000000o(new Intent("refresh_list"));
                    }

                    public final JSONArray O00000Oo(String str) {
                        JSONArray jSONArray = new JSONArray();
                        Map<String, Object> O000000o2 = gtg.this.O000000o(str);
                        if (O000000o2 != null) {
                            for (Map.Entry next : O000000o2.entrySet()) {
                                JSONObject jSONObject = new JSONObject();
                                try {
                                    jSONObject.put((String) next.getKey(), next.getValue());
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                                jSONArray.put(jSONObject);
                            }
                        }
                        return jSONArray;
                    }
                });
                O00000Oo();
            }
        } catch (JSONException unused) {
        }
    }
}
