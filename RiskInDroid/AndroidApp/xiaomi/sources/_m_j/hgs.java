package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class hgs {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hgs f18916O000000o;
    private HashMap<String, hgt> O00000Oo = new HashMap<>();
    private boolean O00000o = false;
    private boolean O00000o0 = false;

    private hgs() {
    }

    public static hgs O000000o() {
        if (f18916O000000o == null) {
            synchronized (hgs.class) {
                if (f18916O000000o == null) {
                    ServiceApplication.getApplication();
                    f18916O000000o = new hgs();
                }
            }
        }
        return f18916O000000o;
    }

    public final fsn O000000o(String str, int i, List<String> list, fsm<hgt, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", Long.parseLong(str));
            jSONObject.put("timestamp", i);
            jSONObject.put("limit", 150);
            jSONObject.put("tag", 1);
            Home O00000o2 = ggb.O00000Oo().O00000o(str);
            if (O00000o2 != null && !O00000o2.isOwner()) {
                jSONObject.put("owner_id", O00000o2.getOwnerUid());
            }
            if (list != null && !list.isEmpty()) {
                jSONObject.put("prop_event_device", new JSONArray((Collection<?>) list));
            }
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/get_device_description").O000000o(arrayList).O000000o(), new fss<hgt>() {
            /* class _m_j.hgs.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return hgt.O000000o(jSONObject);
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O00000Oo(String str, int i, List<String> list, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("home_id", Long.parseLong(str));
            Home O00000o2 = ggb.O00000Oo().O00000o(str);
            if (O00000o2 != null && !O00000o2.isOwner()) {
                jSONObject.put("owner_id", O00000o2.getOwnerUid());
            }
            jSONObject.put("timestamp", i);
            if (list != null && !list.isEmpty()) {
                jSONObject.put("prop_event_device", new JSONArray((Collection<?>) list));
            }
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/get_env_data").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hgs.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(String str, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("homeid", Long.parseLong(str));
        } catch (JSONException unused) {
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/get_env_device").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hgs.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(String str, List<hgr> list, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("homeid", Long.parseLong(str));
            JSONArray jSONArray = new JSONArray();
            if (!list.isEmpty()) {
                for (int i = 0; i < list.size(); i++) {
                    hgr hgr = list.get(i);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("prop_name", hgr.f18915O000000o);
                    jSONObject2.put("did", hgr.O00000Oo);
                    jSONArray.put(jSONObject2);
                }
            }
            jSONObject.put("default_info", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/set_env_device").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.hgs.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }
}
