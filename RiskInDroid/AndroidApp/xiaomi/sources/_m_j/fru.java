package _m_j;

import _m_j.fsn;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.ErrorCode;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.api.model.UserInfo;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import com.xiaomi.smarthome.library.log.LogType;
import com.xiaomi.smarthome.mibrain.roomsetting.model.ControllableDevice;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import okhttp3.OkHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fru {

    /* renamed from: O000000o  reason: collision with root package name */
    private static final Object f16989O000000o = new Object();
    private static volatile fru O00000Oo;
    private OkHttpClient O00000o0 = gse.O000000o();

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

    private fru() {
    }

    public static fru O000000o() {
        if (O00000Oo == null) {
            synchronized (f16989O000000o) {
                if (O00000Oo == null) {
                    O00000Oo = new fru();
                }
            }
        }
        return O00000Oo;
    }

    public final fsn O000000o(Context context, final Map<String, Long> map, fsm<JSONArray, fso> fsm) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> it = map.keySet().iterator();
            if (it.hasNext()) {
                jSONObject.put("begin_at", map.get(it.next()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/message/v2/check_new_msg").O000000o(arrayList).O000000o(), new fss<JSONArray>() {
            /* class _m_j.fru.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                boolean optBoolean = jSONObject.optBoolean("result", false);
                JSONArray jSONArray = new JSONArray();
                for (String put : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", put);
                    jSONObject2.put("count", optBoolean ? 1 : 0);
                    jSONArray.put(jSONObject2);
                }
                return jSONArray;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, int i, String str, String[] strArr, fsm<Void, fso> fsm) {
        if (strArr == null || strArr.length == 0) {
            fsm.sendFailureMessage(new fso(-9999, ""));
            return new fsn(null);
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (String parseLong : strArr) {
            jSONArray.put(Long.parseLong(parseLong));
        }
        try {
            jSONObject.put("msg_ids", jSONArray);
            jSONObject.put("type", i);
            jSONObject.put("did", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/v2/delete").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, List<String> list, List<String> list2, fsm<Void, fso> fsm) {
        if (list.size() == 0 || list2.size() == 0 || list.size() != list2.size()) {
            fsm.sendFailureMessage(new fso(-9999, ""));
            return new fsn(null);
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            String str2 = list2.get(i);
            JSONObject jSONObject2 = new JSONObject();
            try {
                jSONObject2.put("msgId", str);
                jSONObject2.put("did", str2);
                jSONArray.put(jSONObject2);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        try {
            jSONObject.put("devList", jSONArray);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/batch_del_share_list").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, long j, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("timestamp", j);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/message/clear").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, List<String> list, List<String> list2, String str, fsm<JSONObject, fso> fsm) {
        if (list == null || list.size() == 0) {
            fsm.onFailure(new fso(ErrorCode.ERROR_UNKNOWN_ERROR.getCode(), ""));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray();
            for (String put : list) {
                jSONArray.put(put);
            }
            jSONObject.put("didList", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            for (String put2 : list2) {
                jSONArray2.put(put2);
            }
            jSONObject.put("receiver", jSONArray2);
            if (!TextUtils.isEmpty(str)) {
                jSONObject.put("type", str);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/share_request_batch").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fru.AnonymousClass21 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, String str2, String str3, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("command", "share_request");
            jSONObject.put("did", str);
            jSONObject.put("userid", str2);
            if (!TextUtils.isEmpty(str3)) {
                jSONObject.put("type", str3);
            }
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/share_request").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class _m_j.fru.AnonymousClass31 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, String str, String str2, int i, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("msg_id", str2);
            jSONObject.put("inv_id", i);
            jSONObject.put("value", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/share_response").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, String str, fsm<String, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userid", str);
        } catch (JSONException unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/receive_share_list").O000000o(arrayList).O000000o(), new fss<String>() {
            /* class _m_j.fru.AnonymousClass1 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject.toString();
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("command", "getSwitch");
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/switch").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fru.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public static fsn O000000o(Context context, JSONObject jSONObject, fsm<Void, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("command", "setSwitch");
            jSONObject2.put("param", jSONObject);
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/mipush/switch").O000000o(arrayList).O000000o(), (fss) null, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Home home, String str, List<String> list, fsm<JSONObject, fso> fsm, JSONObject jSONObject) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject2 = new JSONObject();
            if (home != null) {
                jSONObject2.put("owner_uid", home.getOwnerUid());
                jSONObject2.put("home_id", Long.parseLong(home.getId()));
            }
            if (!TextUtils.isEmpty(str)) {
                String str2 = str;
                jSONObject2.put("start_did", str);
            } else {
                String str3 = str;
            }
            jSONObject2.put("limit", 300);
            JSONArray jSONArray = new JSONArray();
            if (TextUtils.isEmpty(str) && list != null) {
                for (String put : list) {
                    jSONArray.put(put);
                }
                if (jSONArray.length() > 0) {
                    jSONObject2.put("addition_did", jSONArray);
                }
            }
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            NetRequest O000000o2 = new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/mipush/get_dev_msg_switch").O000000o(arrayList).O000000o();
            final fsm<JSONObject, fso> fsm2 = fsm;
            final JSONObject jSONObject3 = jSONObject;
            final NetRequest netRequest = O000000o2;
            final Home home2 = home;
            new fsn.O000000o().O000000o(CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), O000000o2, $$Lambda$fru$1N9fW6a47aTXVgUc6VqlRo55dd4.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
                /* class _m_j.fru.AnonymousClass3 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    JSONObject jSONObject = (JSONObject) obj;
                    if (jSONObject == null) {
                        fsm fsm = fsm2;
                        if (fsm != null) {
                            fsm.onFailure(new fso(-1, "getMiPushDeviceSwitch onFailure result null"));
                            return;
                        }
                        return;
                    }
                    if (!(jSONObject3 == null || netRequest == null || jSONObject.isNull("device_setting"))) {
                        JSONArray optJSONArray = jSONObject3.optJSONArray("device_setting");
                        JSONArray jSONArray = new JSONArray();
                        for (int i = 0; i < optJSONArray.length(); i++) {
                            if (!optJSONArray.isNull(i)) {
                                jSONArray.put(optJSONArray.opt(i));
                            }
                        }
                        JSONArray optJSONArray2 = jSONObject.optJSONArray("device_setting");
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            if (!optJSONArray2.isNull(i2)) {
                                jSONArray.put(optJSONArray2.opt(i2));
                            }
                        }
                        try {
                            jSONObject.put("device_setting", jSONArray);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    String optString = jSONObject.optString("next_start_did");
                    if (!jSONObject.optBoolean("has_more") || TextUtils.isEmpty(optString)) {
                        gsy.O00000Oo(LogType.NETWORK, "RemoteFamilyApi", "getMiPushDeviceSwitch onSuccess onepage");
                        fsm fsm2 = fsm2;
                        if (fsm2 != null) {
                            fsm2.onSuccess(jSONObject);
                            return;
                        }
                        return;
                    }
                    fru.this.O000000o(home2, optString, (List<String>) null, fsm2, jSONObject);
                }

                public final void onFailure(fso fso) {
                    fsm fsm = fsm2;
                    if (fsm != null) {
                        fsm.onFailure(fso);
                    }
                    gsy.O00000Oo(LogType.NETWORK, "RemoteFamilyApi", "getMiPushDeviceSwitch onFailure");
                }
            }));
            return null;
        } catch (Exception unused) {
            gsy.O00000Oo(LogType.NETWORK, "RemoteFamilyApi", "getMiPushDeviceSwitch onFailure");
            return null;
        }
    }

    public final fsn O00000Oo(Context context, String str, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sender", str);
            jSONObject.put("command", "querybysender");
        } catch (Exception unused) {
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/share/share_history_query").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fru.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(Context context, final Map<String, Long> map, long j, fsm<JSONArray, fso> fsm) {
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<String> it = map.keySet().iterator();
            if (it.hasNext()) {
                it.next();
                jSONObject.put("begin_at", j);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(context, new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/v2/check_new_msg").O000000o(arrayList).O000000o(), new fss<JSONArray>() {
            /* class _m_j.fru.AnonymousClass6 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                boolean optBoolean = jSONObject.optBoolean("result", false);
                JSONArray jSONArray = new JSONArray();
                for (String put : map.keySet()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("type", put);
                    jSONObject2.put("count", optBoolean ? 1 : 0);
                    jSONArray.put(jSONObject2);
                }
                return jSONArray;
            }
        }, Crypto.RC4, fsm);
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x004e A[Catch:{ JSONException -> 0x00b8 }, LOOP:0: B:11:0x0048->B:13:0x004e, LOOP_END] */
    public final fsn O000000o(Context context, ArrayList<String> arrayList, fsm<JSONObject, fso> fsm) {
        String str;
        Iterator<String> it;
        JSONObject jSONObject = new JSONObject();
        try {
            UserInfo O000000o2 = ggg.O000000o().O000000o(Long.parseLong(CoreApi.O000000o().O0000o0()));
            if (O000000o2 != null) {
                if (!TextUtils.isEmpty(O000000o2.O00000oO)) {
                    str = context.getResources().getString(R.string.user_name_home_suffix, O000000o2.O00000oO);
                    jSONObject.put("home_name", str);
                    JSONArray jSONArray = new JSONArray();
                    it = arrayList.iterator();
                    while (it.hasNext()) {
                        jSONArray.put(ggb.O00000oo(it.next()));
                    }
                    jSONObject.put("room", jSONArray);
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("bssid", "");
                    jSONObject2.put("type", "transfer");
                    jSONObject2.put("para", jSONObject);
                    ArrayList arrayList2 = new ArrayList();
                    arrayList2.add(new KeyValuePair("data", jSONObject2.toString()));
                    return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/addroom").O000000o(arrayList2).O000000o(), new fss<JSONObject>() {
                        /* class _m_j.fru.AnonymousClass7 */

                        public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            return jSONObject;
                        }
                    }, Crypto.RC4, fsm);
                }
            }
            str = "";
            jSONObject.put("home_name", str);
            JSONArray jSONArray2 = new JSONArray();
            it = arrayList.iterator();
            while (it.hasNext()) {
            }
            jSONObject.put("room", jSONArray2);
            JSONObject jSONObject22 = new JSONObject();
            jSONObject22.put("bssid", "");
            jSONObject22.put("type", "transfer");
            jSONObject22.put("para", jSONObject);
            ArrayList arrayList22 = new ArrayList();
            arrayList22.add(new KeyValuePair("data", jSONObject22.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/addroom").O000000o(arrayList22).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass7 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("bssid", "");
            jSONObject.put("type", "transfer");
            jSONObject.put("check", 1);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/addroom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass8 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(String str, String str2, List<String> list, String str3, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("type", "addroom");
            jSONObject.put("name", str);
            jSONObject.put("parent_id", str2);
            jSONObject.put("background", str3);
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    String str4 = list.get(i);
                    if (!TextUtils.isEmpty(str4)) {
                        jSONArray.put(str4);
                    }
                }
                jSONObject.put("did", jSONArray);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/addroom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass9 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Room room, List<String> list, List<String> list2, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("type", "set");
            jSONObject.put("id", room.getId());
            jSONObject.put("name", room.getName());
            jSONObject.put("icon", room.getIcon());
            jSONObject.put("background", room.getBackground());
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("add", jSONArray);
            }
            if (list2 != null && !list2.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    String str2 = list2.get(i2);
                    if (!TextUtils.isEmpty(str2)) {
                        jSONArray2.put(str2);
                    }
                }
                jSONObject.put("delete", jSONArray2);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/ctrroom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass10 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Home home, String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("id", home.getId());
            jSONObject.put("type", str);
            if (TextUtils.equals(str, "set")) {
                ggb.O00000Oo();
                jSONObject.put("name", ggb.O000000o(home));
                jSONObject.put("icon", home.getIcon());
                try {
                    if (!TextUtils.isEmpty(home.getLatitude())) {
                        jSONObject.put("latitude", Double.parseDouble(home.getLatitude()));
                    }
                    if (!TextUtils.isEmpty(home.getLongitude())) {
                        jSONObject.put("longitude", Double.parseDouble(home.getLongitude()));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                jSONObject.put("city_id", home.getLocationId());
                if (!TextUtils.isEmpty(home.getAddr())) {
                    jSONObject.put("address", home.getAddr());
                }
            } else if (TextUtils.equals(str, "generalize")) {
                jSONObject.put("background", home.getBackground());
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/ctrhome").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass11 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Home home, Room room, Device device, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("id", room == null ? home.getId() : room.getId());
            jSONObject.put("did", device.did);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/bind_device_to_room").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass12 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Home home, Room room, List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("id", home.getId());
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("dids", jSONArray);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/batch_device_to_room").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass13 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Room room, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("type", "delete");
            jSONObject.put("id", room.getId());
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/ctrroom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass14 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("ids", new JSONArray((Collection<?>) list));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/batchdelroom").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass15 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(Home home, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("bssid", home.getBssid());
            ggb.O00000Oo();
            jSONObject.put("name", ggb.O000000o(home));
            jSONObject.put("background", home.getBackground());
            jSONObject.put("icon", home.getIcon());
            jSONObject.put("city_id", home.getLocationId());
            jSONObject.put("address", home.getAddr());
            if (!TextUtils.isEmpty(home.getLatitude()) && !TextUtils.isEmpty(home.getLongitude()) && !TextUtils.equals("0", home.getLatitude()) && !TextUtils.equals("0", home.getLongitude())) {
                jSONObject.put("latitude", Double.parseDouble(home.getLatitude()));
                jSONObject.put("longitude", Double.parseDouble(home.getLongitude()));
            }
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < home.getRoomList().size(); i++) {
                String id = home.getRoomList().get(i).getId();
                if (!TextUtils.isEmpty(id)) {
                    jSONArray.put(id);
                }
            }
            jSONObject.put("roomid", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/homeroom/addhome").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass16 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000Oo(Home home, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("home_owner", home.getOwnerUid());
            jSONObject.put("home_id", Long.parseLong(home.getId()));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/member_list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass17 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(long j, String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("share_target", j);
            jSONObject.put("home_id", Long.parseLong(str));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/member_invite").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass18 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(List<Long> list, long j, long j2, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("home_owner", j);
            jSONObject.put("share_target", new JSONArray((Collection<?>) list));
            jSONObject.put("home_id", j2);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/member_remove").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass19 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
    public final fsn O00000Oo(fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("fetch_sended", true);
            jSONObject.put("fetch_received", true);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/invite_history").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass20 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(long j, long j2, final int i, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("home_owner", j);
            jSONObject.put("home_id", j2);
            jSONObject.put("status", i);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/member_response").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass22 */

                /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
                 method: _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void
                 arg types: [android.content.Context, java.lang.String, java.lang.String, int]
                 candidates:
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, float):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, int):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, java.lang.String):void
                  _m_j.gpy.O00000Oo(android.content.Context, java.lang.String, java.lang.String, boolean):void */
                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    if (jSONObject != null && TextUtils.equals("{}", jSONObject.toString()) && i == gha.O00000Oo) {
                        Context appContext = ServiceApplication.getAppContext();
                        gpy.O00000Oo(appContext, "home_room_manager_sp_" + grv.O000000o(CoreApi.O000000o().O0000o0()), "show_change_home_red_dot", true);
                        ggc.O000000o().O00000oo.onNext(Boolean.TRUE);
                    }
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static fsn O000000o(String str, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            jSONObject.put("home_id", Long.parseLong(str));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/wechat/member_invite").O000000o(arrayList).O000000o(), $$Lambda$fru$MNjP7tEmwjen9tdS2jiAFfVAgwo.INSTANCE, Crypto.RC4, fsm);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static fsn O00000Oo(String str, fsm<JSONObject, fso> fsm) {
        JSONObject jSONObject = new JSONObject();
        try {
            ArrayList arrayList = new ArrayList();
            jSONObject.put("share_key", str);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/homeroom/wechat/member_response").O000000o(arrayList).O000000o(), $$Lambda$fru$Lb4n7HvcI_JQsEJEKgQW5gJbC4.INSTANCE, Crypto.RC4, fsm);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000o0(fsm<JSONObject, fso> fsm) {
        try {
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/thirdcloud2cloud/group_list").O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass23 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(String str, String str2, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("group_ids", str);
            jSONObject.put("limit", 300);
            if (str2 != null) {
                jSONObject.put("start_did", str2);
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/thirdcloud2cloud/device_list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass25 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(String str, String str2, JSONObject jSONObject, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            if (fsm != null) {
                fsm.onFailure(new fso(Integer.MIN_VALUE, "empty did"));
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("did", str);
            jSONObject2.put("timezone", str2);
            boolean z = false;
            if (jSONObject != null) {
                z = jSONObject.optBoolean("sync_device");
            }
            jSONObject2.put("sync_device", z);
            arrayList.add(new KeyValuePair("data", jSONObject2.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/set_timezone").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass26 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception unused) {
            return null;
        }
    }

    public final fsn O00000o0(String str, fsm<ful, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            fsm.onFailure(new fso(Integer.MIN_VALUE, "empty did"));
            return null;
        }
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("did", str);
            JSONArray jSONArray = new JSONArray();
            jSONArray.put("timezone");
            jSONObject.put("keys", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/get_extra_data").O000000o(arrayList).O000000o(), new fss<ful>() {
                /* class _m_j.fru.AnonymousClass27 */

                public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    TimeZone timeZone;
                    ful ful = new ful();
                    JSONObject optJSONObject = jSONObject.optJSONObject("data");
                    if (!(optJSONObject == null || optJSONObject == JSONObject.NULL)) {
                        String optString = optJSONObject.optString("timezone");
                        ful.f17190O000000o = optString;
                        if (!TextUtils.isEmpty(optString) && (timeZone = TimeZone.getTimeZone(optString)) != null) {
                            ful.O00000Oo = fug.O000000o(optString, ServiceApplication.getAppContext());
                            if (Build.VERSION.SDK_INT >= 24) {
                                ful.O00000o0 = timeZone.getDisplayName(timeZone.observesDaylightTime(), 0);
                            } else {
                                ful.O00000o0 = timeZone.getDisplayName(false, 0);
                            }
                        }
                    }
                    return ful;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception unused) {
            return null;
        }
    }

    public final fsn O00000o(String str, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            fsm.onFailure(new fso(Integer.MIN_VALUE, "empty groupIds list"));
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("group_id", Long.parseLong(str));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/thirdcloud2cloud/sync").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass28 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000oO(String str, fsm<JSONObject, fso> fsm) {
        if (TextUtils.isEmpty(str)) {
            fsm.onFailure(new fso(Integer.MIN_VALUE, "empty groupIds list"));
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("group_id", Long.parseLong(str));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/thirdcloud2cloud/unbind").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass29 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000o(fsm<JSONObject, fso> fsm) {
        try {
            new ArrayList().add(new KeyValuePair("data", new JSONObject().toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/oauth/getstates").O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass30 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000Oo(List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                String str = list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("dids", jSONArray);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/home/removeunsetdids").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass32 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000o0(List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("uid", new Long(list.get(i)));
                jSONObject2.put("time_stamp", currentTimeMillis);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("info", jSONArray);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/share/add_sharelist_block_uid").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass33 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000o(List<Long> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            jSONObject.put("uids", new JSONArray((Collection<?>) list));
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/share/del_sharelist_block_uid").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass34 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000oO(fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/share/sharelist_block_list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass35 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000oO(List<String> list, fsm<JSONObject, fso> fsm) {
        if (list != null) {
            try {
                if (list.size() != 0) {
                    JSONObject jSONObject = new JSONObject();
                    JSONArray jSONArray = new JSONArray();
                    for (String put : list) {
                        jSONArray.put(put);
                    }
                    jSONObject.put("dids", jSONArray);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(new KeyValuePair("data", jSONObject.toString()));
                    return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/miotspec/voice_device_list").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                        /* class _m_j.fru.AnonymousClass36 */

                        public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                            return jSONObject;
                        }
                    }, Crypto.RC4, fsm);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        fsm.onFailure(new fso(-1, "no request data dids"));
        return null;
    }

    public final fsn O000000o(String str, List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("device_id", str);
            jSONObject.put("env", 0);
            jSONObject.put("tip_type", "name");
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    jSONArray.put(list.get(i));
                }
                jSONObject.put("ctrl_did", jSONArray);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/ai_device_tips").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass37 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000oo(String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", Long.parseLong(str));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/get_room_maindev").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass38 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(String str, String str2, boolean z, List<String> list, List<ControllableDevice> list2, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", Long.parseLong(str));
            if (list != null) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    String str3 = list.get(i);
                    if (!TextUtils.isEmpty(str3)) {
                        jSONArray.put(str3);
                    }
                }
                jSONObject.put("ctrl_dids", jSONArray);
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("intent", str2);
            jSONObject2.put("use_default", z);
            JSONArray jSONArray2 = new JSONArray();
            if (list2 != null) {
                for (int i2 = 0; i2 < list2.size(); i2++) {
                    ControllableDevice controllableDevice = list2.get(i2);
                    if (controllableDevice != null) {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put("did", controllableDevice.f9511O000000o);
                        jSONObject3.put("desc", controllableDevice.O00000Oo);
                        jSONArray2.put(jSONObject3);
                    }
                }
                jSONObject2.put("device_list", jSONArray2);
            }
            jSONObject.put("detail", jSONObject2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/set_room_maindev").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass39 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000Oo(String str, String str2, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("room_id", Long.parseLong(str));
            jSONObject.put("did", str2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/voicectrl/ai_cate_devlist").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass40 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(int i, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("msgType", i);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/get_msg_alert").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass41 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000oo(List<?> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            for (int i = 0; i < list.size(); i++) {
                String str = (String) list.get(i);
                if (!TextUtils.isEmpty(str)) {
                    jSONArray.put(str);
                }
            }
            jSONObject.put("msgIds", jSONArray);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/message/get_msg_by_ids").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass42 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O0000O0o(String str, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("homeId", Long.valueOf(str));
            Home O00000o = ggb.O00000Oo().O00000o(str);
            if (O00000o != null && !O00000o.isOwner()) {
                jSONObject.put("ownerId", O00000o.getOwnerUid());
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/room/device_descriptions_by_home").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass43 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
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
    public final fsn O00000oo(fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("fetch_own", true);
            jSONObject.put("fetch_share", true);
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/user/get_device_cnt").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass44 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O00000Oo(String str, List<String> list, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (list != null && list.size() > 0) {
                JSONArray jSONArray = new JSONArray();
                for (String put : list) {
                    jSONArray.put(put);
                }
                jSONObject.put("dids", jSONArray);
            }
            jSONObject.put("homeid", Long.parseLong(str));
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/device/enable_xiaoai_ble_switch").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass45 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final fsn O000000o(List<String> list, boolean z, fsm<JSONObject, fso> fsm) {
        try {
            JSONObject jSONObject = new JSONObject();
            if (list != null && !list.isEmpty()) {
                JSONArray jSONArray = new JSONArray();
                for (int i = 0; i < list.size(); i++) {
                    String str = list.get(i);
                    if (!TextUtils.isEmpty(str)) {
                        jSONArray.put(str);
                    }
                }
                jSONObject.put("dids", jSONArray);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo(z ? "/v2/home/freq_device_set" : "/v2/home/freq_device_del").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
                /* class _m_j.fru.AnonymousClass46 */

                public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                    return jSONObject;
                }
            }, Crypto.RC4, fsm);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
