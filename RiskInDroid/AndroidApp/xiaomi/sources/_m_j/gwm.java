package _m_j;

import android.text.TextUtils;
import android.util.Log;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.device.Device;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class gwm {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile gwm f18412O000000o;

    private gwm() {
    }

    public static gwm O000000o() {
        if (f18412O000000o == null) {
            synchronized (gwm.class) {
                if (f18412O000000o == null) {
                    f18412O000000o = new gwm();
                }
            }
        }
        return f18412O000000o;
    }

    public final Observable<List<O000000o>> O00000Oo() {
        Observable<R> cache = O00000o0().map($$Lambda$gwm$buxty5M4KnpHu0JUDLe7IGdQBWw.INSTANCE).cache();
        return Observable.zip(cache, cache.flatMap(new Function() {
            /* class _m_j.$$Lambda$gwm$L176aCuCf1o9W4GJ97IVgLXt7Dg */

            public final Object apply(Object obj) {
                return gwm.this.O000000o((Map) obj);
            }
        }), $$Lambda$gwm$e5dvKPf9lhhBMD_CTvCaFgoK4ng.INSTANCE).subscribeOn(Schedulers.io());
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Map O000000o(Set set) throws Exception {
        HashMap hashMap = new HashMap();
        for (Map.Entry<String, Device> value : fno.O000000o().O0000O0o().entrySet()) {
            Device device = (Device) value.getValue();
            if (device != null && !fno.O000000o().O00000o(device) && set.contains(device.model)) {
                hashMap.put(device.did, device);
            }
        }
        return hashMap;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ObservableSource O000000o(Map map) throws Exception {
        return O000000o(new ArrayList(map.keySet()));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ List O000000o(Map map, Map map2) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (String str : map2.keySet()) {
            Device device = (Device) map.get(str);
            if (device == null) {
                gsy.O000000o(6, "FacePrivacyApi", "map did to device lost did: ".concat(String.valueOf(str)));
            } else {
                arrayList.add(new O000000o(device, (Boolean) map2.get(str)));
            }
        }
        return arrayList;
    }

    private Observable<Map<String, Boolean>> O000000o(List<String> list) {
        if (list.isEmpty()) {
            gsy.O000000o(3, "FacePrivacyApi", "getSwitchStatus: empty parma dids");
            return Observable.just(Collections.emptyMap());
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("op_type", 1);
            jSONObject.put("dids", new JSONArray((Collection<?>) list));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/camera/get_switch").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss<Map<String, Boolean>>() {
            /* class _m_j.gwm.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("FacePrivacyApi", "getSwitchStatus parse: ".concat(String.valueOf(jSONObject)));
                JSONArray jSONArray = jSONObject.getJSONArray("result");
                HashMap hashMap = new HashMap(jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                    hashMap.put(jSONObject2.getString("did"), Boolean.valueOf(jSONObject2.getBoolean("open")));
                }
                return hashMap;
            }
        }).doOnError(new Consumer<Throwable>() {
            /* class _m_j.gwm.AnonymousClass1 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                gsy.O00000Oo("FacePrivacyApi", "getSwitchStatus: error " + Log.getStackTraceString((Throwable) obj));
            }
        });
    }

    private Observable<Set<String>> O00000o0() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("op_type", 1);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/camera/model_list").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss<Set<String>>() {
            /* class _m_j.gwm.AnonymousClass4 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("FacePrivacyApi", "getSupportModel parse: ".concat(String.valueOf(jSONObject)));
                HashSet hashSet = new HashSet();
                JSONArray jSONArray = jSONObject.getJSONArray("result");
                for (int i = 0; i < jSONArray.length(); i++) {
                    hashSet.add(jSONArray.getString(i));
                }
                return hashSet;
            }
        }).doOnError(new Consumer<Throwable>() {
            /* class _m_j.gwm.AnonymousClass3 */

            public final /* synthetic */ void accept(Object obj) throws Exception {
                gsy.O00000Oo("FacePrivacyApi", "getSupportModel: error " + Log.getStackTraceString((Throwable) obj));
            }
        });
    }

    public final Observable<Boolean> O000000o(String str, boolean z) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("op_type", 1);
            jSONObject.put("did", str);
            jSONObject.put("open", z);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/camera/detect_switch").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss<Boolean>() {
            /* class _m_j.gwm.AnonymousClass5 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("FacePrivacyApi", "toggleSwitch parse: ".concat(String.valueOf(jSONObject)));
                return Boolean.valueOf(TextUtils.equals(jSONObject.getString("message"), "ok"));
            }
        }).onErrorReturnItem(Boolean.FALSE);
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Device f18418O000000o;
        public final Boolean O00000Oo;

        public O000000o(Device device, Boolean bool) {
            this.f18418O000000o = device;
            this.O00000Oo = bool;
        }
    }
}
