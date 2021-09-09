package _m_j;

import _m_j.fnw;
import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.authorization.page.DeviceAuthFragment;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fmh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fmh f16624O000000o;
    private static final Object O00000Oo = new Object();

    private fmh() {
    }

    public static fmh O000000o() {
        if (f16624O000000o == null) {
            synchronized (O00000Oo) {
                if (f16624O000000o == null) {
                    f16624O000000o = new fmh();
                }
            }
        }
        return f16624O000000o;
    }

    public final fsn O000000o(Context context, String str, fnz fnz) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            Device O000000o2 = fno.O000000o().O000000o(str);
            jSONObject.put("voice_did", str);
            jSONObject.put("voice_model", O000000o2.model);
            jSONObject.put("auth_type", DeviceAuthFragment.O00000Oo);
            jSONObject.put("auth_all_room", fnz.O00000oO);
            jSONObject.put("ctrl_share_device", fnz.O00000oo);
            jSONObject.put("ctrl_othercloud_device", fnz.O0000O0o);
            jSONObject.put("home", fnz.O0000OOo);
            jSONObject.put("rooms", new JSONArray((Collection<?>) fnz.O0000Oo0));
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/update_voice_device_auth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fmh.AnonymousClass1 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, (fsm) null);
    }

    public final fsn O000000o(Context context, String str, List<fnw.O000000o> list, fnx fnx) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            Device O000000o2 = fno.O000000o().O000000o(str);
            jSONObject.put("voice_did", str);
            jSONObject.put("voice_model", O000000o2.model);
            jSONObject.put("auth_type", DeviceAuthFragment.f7054O000000o);
            jSONObject.put("auth_all_device", fnx.O00000oo.get());
            if (!fnx.O00000oo.get()) {
                jSONObject.put("auto_auth_switch", fnx.O0000O0o);
                JSONArray jSONArray = new JSONArray();
                for (fnw.O000000o next : list) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("ctrlable", Integer.parseInt(next.O00000Oo));
                    jSONObject2.put("did", next.f16728O000000o);
                    jSONArray.put(jSONObject2);
                }
                jSONObject.put("ctrl_devices", jSONArray);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/update_voice_device_auth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fmh.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, (fsm) null);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject
     arg types: [java.lang.String, int]
     candidates:
      org.json.JSONObject.put(java.lang.String, double):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, float):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, int):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, long):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.lang.Object):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Collection<?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, java.util.Map<?, ?>):org.json.JSONObject
      org.json.JSONObject.put(java.lang.String, boolean):org.json.JSONObject */
    public final fsn O000000o(Context context, List<String> list, fsm<fnw, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        if (list.size() > 0) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (String next : list) {
                Device O000000o2 = fno.O000000o().O000000o(next);
                if (O000000o2 != null) {
                    sb.append(next);
                    sb.append(",");
                    sb2.append(O000000o2.model);
                    sb2.append(",");
                }
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            try {
                jSONObject.put("voice_did", sb.toString());
                jSONObject.put("voice_model", sb2.toString());
                jSONObject.put("ctrl_device_detail", true);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/get_voice_device_auth").O000000o(arrayList).O000000o(), new fss<fnw>() {
            /* class _m_j.fmh.AnonymousClass3 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return O000000o(jSONObject);
            }

            private static fnw O000000o(JSONObject jSONObject) throws JSONException {
                JSONArray optJSONArray;
                JSONArray optJSONArray2;
                String optString = jSONObject.optString("auth_type", "");
                int i = 0;
                if (TextUtils.equals(optString, DeviceAuthFragment.f7054O000000o)) {
                    fnx fnx = new fnx();
                    if (!jSONObject.isNull("voice_did")) {
                        fnx.f16727O000000o = jSONObject.optString("voice_did");
                    }
                    if (!jSONObject.isNull("valid_till")) {
                        fnx.O00000oO = jSONObject.optInt("valid_till");
                    }
                    if (!jSONObject.isNull("ctrl_devices") && (optJSONArray2 = jSONObject.optJSONArray("ctrl_devices")) != null && optJSONArray2.length() > 0) {
                        fnx.O00000o0.clear();
                        while (i < optJSONArray2.length()) {
                            JSONObject optJSONObject = optJSONArray2.optJSONObject(i);
                            if (!optJSONObject.isNull("did") && !optJSONObject.isNull("ctrlable")) {
                                fnw.O000000o o000000o = new fnw.O000000o();
                                o000000o.O0000Oo0 = i;
                                o000000o.f16728O000000o = optJSONObject.optString("did");
                                o000000o.O00000Oo = optJSONObject.optString("ctrlable");
                                o000000o.O00000o0 = optJSONObject.optString("name");
                                o000000o.O00000o = optJSONObject.optString("model");
                                fnx.O00000o0.add(o000000o);
                            }
                            i++;
                        }
                    }
                    if (!jSONObject.isNull("auth_all_device")) {
                        fnx.O00000oo.set(jSONObject.optBoolean("auth_all_device"));
                    }
                    if (!jSONObject.isNull("auto_auth_switch")) {
                        fnx.O0000O0o = jSONObject.optBoolean("auto_auth_switch");
                    }
                    fnx.O00000Oo = optString;
                    fnx.O000000o();
                    return fnx;
                } else if (!TextUtils.equals(optString, DeviceAuthFragment.O00000Oo)) {
                    return null;
                } else {
                    fnz fnz = new fnz();
                    if (!jSONObject.isNull("voice_did")) {
                        fnz.f16727O000000o = jSONObject.optString("voice_did");
                    }
                    if (!jSONObject.isNull("ctrl_devices") && (optJSONArray = jSONObject.optJSONArray("ctrl_devices")) != null && optJSONArray.length() > 0) {
                        fnz.O00000o0.clear();
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                            if (!optJSONObject2.isNull("did") && !optJSONObject2.isNull("ctrlable")) {
                                fnw.O000000o o000000o2 = new fnw.O000000o(optJSONObject2.optString("did"), optJSONObject2.optString("ctrlable"), i2);
                                o000000o2.O00000o0 = optJSONObject2.optString("name");
                                o000000o2.O00000o = optJSONObject2.optString("model");
                                fnz.O00000o0.add(o000000o2);
                            }
                        }
                    }
                    if (!jSONObject.isNull("auth_all_room")) {
                        fnz.O00000oO = jSONObject.optBoolean("auth_all_room");
                    }
                    if (!jSONObject.isNull("ctrl_share_device")) {
                        fnz.O00000oo = jSONObject.optBoolean("ctrl_share_device");
                    }
                    if (!jSONObject.isNull("ctrl_othercloud_device")) {
                        fnz.O0000O0o = jSONObject.optBoolean("ctrl_othercloud_device");
                    }
                    if (!jSONObject.isNull("home")) {
                        fnz.O0000OOo = jSONObject.optString("home");
                    }
                    if (fnz.O00000oO) {
                        Home O00000o = ggb.O00000Oo().O00000o(fnz.O0000OOo);
                        if (!(O00000o == null || O00000o.getRoomList() == null)) {
                            for (Room id : O00000o.getRoomList()) {
                                fnz.O0000Oo0.add(id.getId());
                            }
                        }
                    } else if (!jSONObject.isNull("rooms")) {
                        JSONArray optJSONArray3 = jSONObject.optJSONArray("rooms");
                        while (i < optJSONArray3.length()) {
                            String optString2 = optJSONArray3.optString(i);
                            Room O00000o0 = ggb.O00000Oo().O00000o0(optString2);
                            if (O00000o0 != null && TextUtils.equals(O00000o0.getParentid(), fnz.O0000OOo)) {
                                fnz.O0000Oo0.add(optString2);
                            }
                            i++;
                        }
                    }
                    fnz.O00000Oo = optString;
                    fnz.O000000o();
                    return fnz;
                }
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, long j, fsm<List<gxu>, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            jSONObject.put("time", j);
            jSONObject.put("limit", 50);
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/device/get_opt_log").O000000o(arrayList).O000000o(), new fss<List<gxu>>() {
            /* class _m_j.fmh.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                JSONObject optJSONObject;
                JSONObject jSONObject2 = jSONObject;
                ArrayList arrayList = new ArrayList();
                if (!jSONObject2.isNull("logs") && (optJSONObject = jSONObject2.optJSONObject("logs")) != null) {
                    Iterator<String> keys = optJSONObject.keys();
                    TreeMap treeMap = new TreeMap(new Comparator<Long>() {
                        /* class _m_j.gxu.AnonymousClass1 */

                        public final /* synthetic */ int compare(Object obj, Object obj2) {
                            Long l = (Long) obj;
                            Long l2 = (Long) obj2;
                            if (l.longValue() < l2.longValue()) {
                                return 1;
                            }
                            return l.longValue() > l2.longValue() ? -1 : 0;
                        }
                    });
                    while (keys.hasNext()) {
                        String next = keys.next();
                        treeMap.put(Long.valueOf(Long.parseLong(next)), optJSONObject.optJSONObject(next));
                    }
                    gxu gxu = null;
                    for (Long longValue : treeMap.keySet()) {
                        long longValue2 = longValue.longValue();
                        JSONObject jSONObject3 = (JSONObject) treeMap.get(Long.valueOf(longValue2));
                        if (jSONObject3 != null) {
                            if (gxu == null) {
                                gxu = new gxu();
                                gxu.O000000o(longValue2);
                                gxu.O00000oO.add(gxs.O000000o(longValue2, jSONObject3.optString("status"), "", jSONObject3.optString("trigger")));
                                arrayList.add(gxu);
                            } else {
                                if (!(new Date(longValue2).getTime() / 86400000 == new Date(gxu.O00000o).getTime() / 86400000)) {
                                    gxu = new gxu();
                                    gxu.O000000o(longValue2);
                                    arrayList.add(gxu);
                                }
                                gxu.O00000oO.add(gxs.O000000o(longValue2, jSONObject3.optString("status"), "", jSONObject3.optString("trigger")));
                            }
                        }
                    }
                }
                return arrayList;
            }
        }, Crypto.RC4, fsm);
    }
}
