package _m_j;

import _m_j.gsj;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.device.api.spec.instance.SpecProperty;
import com.xiaomi.smarthome.device.api.spec.instance.SpecService;
import com.xiaomi.smarthome.device.api.spec.operation.PropertyParam;
import com.xiaomi.smarthome.devicelistswitch.model.ModelOperations;
import com.xiaomi.smarthome.devicelistswitch.model.Operation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.ref.WeakReference;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import okhttp3.Call;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fra {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile fra f16942O000000o = null;
    private static final String O0000Ooo = "fra";
    public fqz O00000Oo = new fqz();
    public Map<String, Boolean> O00000o = new ConcurrentHashMap();
    protected Map<String, Map<String, String>> O00000o0 = new ConcurrentHashMap();
    public frd O00000oO;
    public Handler O00000oo = new Handler(Looper.getMainLooper()) {
        /* class _m_j.fra.AnonymousClass1 */

        public final void handleMessage(Message message) {
            if (message.what == 1) {
                fra fra = fra.this;
                String string = ServiceApplication.getAppContext().getSharedPreferences("sp_device_list_switch_config", 0).getString("content", "");
                if (!TextUtils.isEmpty(string)) {
                    try {
                        fra.O00000Oo = fqz.O000000o(new JSONObject(string));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
                fra.O00000o();
            }
        }
    };
    public volatile boolean O0000O0o = false;
    public AtomicBoolean O0000OOo = new AtomicBoolean(false);
    frd O0000Oo;
    public AtomicBoolean O0000Oo0 = new AtomicBoolean(false);
    public Map<String, WeakReference<Runnable>> O0000OoO = new ConcurrentHashMap();
    private long O0000o00 = 0;

    private fra() {
    }

    public static fra O000000o() {
        if (f16942O000000o == null) {
            synchronized (fra.class) {
                if (f16942O000000o == null) {
                    f16942O000000o = new fra();
                }
            }
        }
        return f16942O000000o;
    }

    public final void O00000Oo() {
        if (this.O0000O0o) {
            ArrayList<Device> arrayList = new ArrayList<>();
            arrayList.addAll(fno.O000000o().O0000O0o().values());
            arrayList.addAll(fno.O000000o().O00000Oo().values());
            ArrayList arrayList2 = new ArrayList();
            HashSet hashSet = new HashSet();
            for (Device device : arrayList) {
                hashSet.add(device.did);
                if (!this.O00000o0.containsKey(device.did)) {
                    arrayList2.add(device);
                }
            }
            if (!arrayList2.isEmpty()) {
                O00000Oo(arrayList2);
            }
            for (String str : new ArrayList(this.O00000o0.keySet())) {
                if (!hashSet.contains(str)) {
                    this.O00000o0.remove(str);
                }
            }
            return;
        }
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O0000O0o2 != null && O0000O0o2.size() != 0) {
            if (!this.O0000OOo.getAndSet(true)) {
                this.O00000oo.sendEmptyMessage(1);
            } else {
                this.O0000Oo0.set(true);
            }
        }
    }

    public final Map<String, ModelOperations> O00000o0() {
        Map<String, ModelOperations> map = this.O00000Oo.O00000Oo;
        if (map.isEmpty()) {
            O00000o();
        }
        return map;
    }

    public final void O00000o() {
        this.O00000oo.removeMessages(1);
        O0000Oo0();
        O000000o((List<String>) null);
    }

    public static void O000000o(JSONObject jSONObject) {
        SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences("sp_device_list_switch_config", 0);
        sharedPreferences.edit().putString("content", jSONObject.toString()).commit();
        sharedPreferences.edit().putLong("timestamp", System.currentTimeMillis()).commit();
    }

    public final int O000000o(Device device) {
        ModelOperations modelOperations;
        if (this.O0000O0o && this.O00000Oo.f16941O000000o && device.isBinded() && !this.O00000o0.isEmpty() && this.O00000o0.containsKey(device.did) && (modelOperations = this.O00000Oo.O00000Oo.get(device.model)) != null && modelOperations.O00000Oo != null && modelOperations.O00000Oo.length != 0) {
            Operation operation = modelOperations.O00000Oo[0];
            Map<String, Map<String, String>> map = this.O00000o0;
            if (!map.isEmpty() && map.containsKey(device.did)) {
                Map map2 = map.get(device.did);
                if (!map2.isEmpty() && map2.containsKey(operation.f7304O000000o)) {
                    String str = (String) map2.get(operation.f7304O000000o);
                    for (Operation operation2 : modelOperations.O00000Oo) {
                        if (TextUtils.equals(operation2.f7304O000000o, operation.f7304O000000o) && TextUtils.equals(operation2.O00000Oo, str)) {
                            return 1;
                        }
                    }
                }
            }
        }
        return 3;
    }

    public static void O00000oO() {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("switch_refresh_success"));
    }

    public static void O00000oo() {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("switch_refresh_failed"));
    }

    public final void O000000o(final List<String> list) {
        ModelOperations modelOperations;
        Operation[] operationArr;
        O0000OOo();
        Map<String, ModelOperations> map = this.O00000Oo.O00000Oo;
        if (map.isEmpty()) {
            this.O0000OOo.set(false);
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        arrayList.addAll(fno.O000000o().O00000Oo().values());
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            Device device = (Device) arrayList.get(i);
            if (!(device == null || ((list != null && !list.contains(device.did)) || (modelOperations = map.get(device.model)) == null || (operationArr = modelOperations.O00000Oo) == null || operationArr.length == 0))) {
                jSONArray.put(O000000o(device, operationArr));
            }
        }
        if (jSONArray.length() > 0) {
            AnonymousClass5 r0 = new fsm<String, fso>() {
                /* class _m_j.fra.AnonymousClass5 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    fra.this.O000000o((String) obj, list);
                    fra fra = fra.this;
                    fra.O0000O0o = true;
                    fra.O00000oo.post(new Runnable() {
                        /* class _m_j.fra.AnonymousClass5.AnonymousClass1 */

                        public final void run() {
                            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                            fra.O00000oO();
                        }
                    });
                    fra.this.O0000OOo.set(false);
                    if (fra.this.O0000Oo0.getAndSet(false)) {
                        fra.this.O000000o((List<String>) null);
                    }
                }

                public final void onFailure(fso fso) {
                    fra.this.O0000OOo.set(false);
                    fra.this.O0000Oo0.set(false);
                    fra.O00000oo();
                }
            };
            Context appContext = ServiceApplication.getAppContext();
            DevicelibApi.batchGetDeviceProps(appContext, jSONArray, r0, fra.class.getSimpleName() + "-updateDeviceProps");
            return;
        }
        this.O0000OOo.set(false);
        O00000oO();
    }

    private void O0000OOo() {
        Pair<SpecService, SpecProperty> checkSupportPower;
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(fno.O000000o().O0000O0o().values());
        arrayList.addAll(fno.O000000o().O00000Oo().values());
        arrayList.addAll(fno.O000000o().O00000o0());
        final ArrayList arrayList2 = new ArrayList();
        final ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Device device = (Device) it.next();
            if (device.isOnline && (checkSupportPower = faw.O000000o().checkSupportPower(device)) != null && !((SpecProperty) checkSupportPower.second).getPropertyDefinition().readable()) {
                arrayList2.add(new PropertyParam(device.did, (SpecProperty) checkSupportPower.second));
                arrayList3.add(device);
            }
        }
        faw.O00000o().getDeviceSpecProp(ServiceApplication.getAppContext(), arrayList2, new fsm<List<PropertyParam>, fso>() {
            /* class _m_j.fra.AnonymousClass6 */

            public final void onFailure(fso fso) {
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                HashMap hashMap = new HashMap();
                for (PropertyParam propertyParam : (List) obj) {
                    if (propertyParam.getResultCode() == 0) {
                        if (propertyParam.getValue() instanceof Boolean) {
                            hashMap.put(propertyParam.getDid(), (Boolean) propertyParam.getValue());
                        } else if (propertyParam.getValue() instanceof Integer) {
                            hashMap.put(propertyParam.getDid(), Boolean.valueOf(((Integer) propertyParam.getValue()).intValue() != 0));
                        }
                    }
                }
                fra fra = fra.this;
                fra.O00000o = hashMap;
                List list = arrayList3;
                List list2 = arrayList2;
                if (fra.O0000Oo == null) {
                    fra.O0000Oo = new frd();
                }
                fra.O0000Oo.init(list, new frf(list2) {
                    /* class _m_j.fra.AnonymousClass7 */

                    /* renamed from: O000000o  reason: collision with root package name */
                    final /* synthetic */ List f16951O000000o;

                    {
                        this.f16951O000000o = r2;
                    }

                    public final List<String> O000000o(String str) {
                        ArrayList arrayList = new ArrayList();
                        for (PropertyParam propertyParam : this.f16951O000000o) {
                            if (propertyParam.getDid().equals(str)) {
                                arrayList.add("prop." + propertyParam.getSiid() + "." + propertyParam.getPiid());
                                return arrayList;
                            }
                        }
                        return null;
                    }

                    public final void O000000o(final String str, JSONArray jSONArray) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject optJSONObject = jSONArray.optJSONObject(i);
                            if (optJSONObject != null && !optJSONObject.isNull("key")) {
                                Object opt = optJSONObject.opt("value");
                                if ((opt instanceof JSONArray) && ((JSONArray) opt).length() > 0) {
                                    try {
                                        opt = ((JSONArray) opt).get(0);
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                                if (opt instanceof Boolean) {
                                    fra.this.O00000o.put(str, (Boolean) opt);
                                } else if (opt instanceof Integer) {
                                    fra.this.O00000o.put(str, Boolean.valueOf(((Integer) opt).intValue() != 0));
                                }
                                ArrayList arrayList = new ArrayList();
                                arrayList.add(str);
                                fno.O000000o().O000000o(arrayList, new fsm<List<Device>, fso>() {
                                    /* class _m_j.fra.AnonymousClass7.AnonymousClass1 */

                                    public final void onFailure(fso fso) {
                                    }

                                    public final /* synthetic */ void onSuccess(Object obj) {
                                        fno.O000000o().O00000o0(fno.O000000o().O000000o(str));
                                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                                    }
                                });
                            }
                        }
                    }

                    public final JSONArray O00000Oo(String str) {
                        JSONArray jSONArray = new JSONArray();
                        JSONObject jSONObject = new JSONObject();
                        Boolean bool = fra.this.O00000o.get(str);
                        for (PropertyParam propertyParam : this.f16951O000000o) {
                            if (propertyParam.getDid().equals(str)) {
                                try {
                                    jSONObject.put(propertyParam.getSiid() + "." + propertyParam.getPiid(), bool);
                                    jSONArray.put(jSONObject);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                        return jSONArray;
                    }
                });
                fra.this.O00000oo.post($$Lambda$fra$6$fkkZ9K2IDCzyZc8pYORkXnEjsgg.INSTANCE);
            }
        });
    }

    public final void O00000Oo(final List<Device> list) {
        ModelOperations modelOperations;
        Operation[] operationArr;
        Map<String, ModelOperations> map = this.O00000Oo.O00000Oo;
        if (map.isEmpty()) {
            this.O0000OOo.set(false);
            return;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < list.size(); i++) {
            Device device = list.get(i);
            if (!(device == null || (modelOperations = map.get(device.model)) == null || (operationArr = modelOperations.O00000Oo) == null || operationArr.length == 0)) {
                jSONArray.put(O000000o(device, operationArr));
            }
        }
        if (jSONArray.length() > 0) {
            AnonymousClass8 r0 = new fsm<String, fso>() {
                /* class _m_j.fra.AnonymousClass8 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    String str = (String) obj;
                    ArrayList arrayList = new ArrayList();
                    for (Device device : list) {
                        arrayList.add(device.did);
                    }
                    fra.this.O000000o(str, arrayList);
                    fra fra = fra.this;
                    fra.O0000O0o = true;
                    fra.O00000oo.post(new Runnable() {
                        /* class _m_j.fra.AnonymousClass8.AnonymousClass1 */

                        public final void run() {
                            ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                            fra.O00000oO();
                        }
                    });
                    fra.this.O0000OOo.set(false);
                    if (fra.this.O0000Oo0.getAndSet(false)) {
                        fra.this.O000000o((List<String>) null);
                    }
                }

                public final void onFailure(fso fso) {
                    fra.this.O0000OOo.set(false);
                    fra.this.O0000Oo0.set(false);
                    fra.O00000oo();
                }
            };
            Context appContext = ServiceApplication.getAppContext();
            DevicelibApi.batchGetDeviceProps(appContext, jSONArray, r0, fra.class.getSimpleName() + "-updateDevicePropsByDevice");
            return;
        }
        this.O0000OOo.set(false);
        O00000oO();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(String str, final List<String> list) {
        Map<String, Map<String, String>> concurrentHashMap = new ConcurrentHashMap<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            Iterator<String> keys = jSONObject.keys();
            if (list != null && list.size() > 0) {
                concurrentHashMap = this.O00000o0;
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
                        }
                        if (obj != null) {
                            hashMap.put(next2, String.valueOf(obj));
                        }
                    }
                    concurrentHashMap.put(next, hashMap);
                }
            }
            this.O00000o0 = concurrentHashMap;
            if (list == null || list.size() <= 0) {
                this.O00000oo.post(new Runnable() {
                    /* class _m_j.fra.AnonymousClass10 */

                    public final void run() {
                        fno.O000000o().f16707O000000o.refreshDeviceAll();
                    }
                });
                HashSet hashSet = new HashSet();
                hashSet.addAll(fno.O000000o().O0000O0o().values());
                hashSet.addAll(fno.O000000o().O00000Oo().values());
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(hashSet);
                hashSet.clear();
                if (this.O00000oO == null) {
                    this.O00000oO = new frd();
                }
                this.O00000oO.init(arrayList, new frf() {
                    /* class _m_j.fra.AnonymousClass2 */

                    public final List<String> O000000o(String str) {
                        Map<String, String> O000000o2 = fra.this.O000000o(str);
                        if (O000000o2 == null || O000000o2.size() == 0) {
                            return null;
                        }
                        return new ArrayList(O000000o2.keySet());
                    }

                    public final void O000000o(String str, JSONArray jSONArray) {
                        fra.this.O000000o(str, jSONArray);
                    }

                    public final JSONArray O00000Oo(String str) {
                        JSONArray jSONArray = new JSONArray();
                        Map<String, String> O000000o2 = fra.this.O000000o(str);
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
                return;
            }
            this.O00000oo.post(new Runnable() {
                /* class _m_j.fra.AnonymousClass9 */

                public final void run() {
                    for (String O000000o2 : list) {
                        fno.O000000o().O00000o0(fno.O000000o().O000000o(O000000o2));
                    }
                }
            });
        } catch (JSONException unused) {
        }
    }

    private static JSONObject O000000o(Device device, Operation[] operationArr) {
        JSONObject jSONObject = new JSONObject();
        HashSet hashSet = new HashSet();
        for (Operation operation : operationArr) {
            if (device.model.startsWith("lumi.sensor_magnet.")) {
                hashSet.add("event.open");
                hashSet.add("event.close");
            } else if (!TextUtils.isEmpty(operation.f7304O000000o)) {
                hashSet.add(operation.f7304O000000o);
            }
        }
        if (hashSet.size() > 0) {
            try {
                jSONObject.put("did", device.did);
                JSONArray jSONArray = new JSONArray();
                Iterator it = hashSet.iterator();
                while (it.hasNext()) {
                    jSONArray.put("prop.".concat(String.valueOf((String) it.next())));
                }
                jSONObject.put("props", jSONArray);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    private void O0000Oo0() {
        if (Math.abs(System.currentTimeMillis() - this.O0000o00) >= 1800000) {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("lang", "zh_CN");
                StringBuilder sb = new StringBuilder("shortcut_card_device_config");
                sb.append(gfr.O0000oo0 ? "_preview" : "");
                jSONObject.put("name", sb.toString());
                jSONObject.put("version", "1");
            } catch (Exception unused) {
            }
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            gsj gsj = null;
            try {
                gsj.O000000o o000000o = new gsj.O000000o();
                o000000o.f18212O000000o = "GET";
                gsj = o000000o.O00000Oo(O00000Oo(jSONObject)).O000000o();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            if (gsj != null) {
                gsg.O00000Oo(gsj, new gsl() {
                    /* class _m_j.fra.AnonymousClass3 */

                    public final void onSuccess(Object obj, Response response) {
                    }

                    public final void processFailure(Call call, IOException iOException) {
                    }

                    public final void processResponse(Response response) {
                        JSONObject optJSONObject;
                        JSONObject jSONObject;
                        try {
                            fra.this.O0000O0o = true;
                            String string = response.body().string();
                            if (!TextUtils.isEmpty(string)) {
                                JSONObject jSONObject2 = new JSONObject(string);
                                if (jSONObject2.isNull("result") || (optJSONObject = jSONObject2.optJSONObject("result")) == null) {
                                    return;
                                }
                                if (!optJSONObject.isNull("content")) {
                                    Object obj = optJSONObject.get("content");
                                    if (obj instanceof JSONObject) {
                                        jSONObject = (JSONObject) obj;
                                    } else {
                                        jSONObject = obj instanceof String ? new JSONObject((String) obj) : null;
                                    }
                                    fra.this.O00000Oo = fqz.O000000o(jSONObject);
                                    if (!jSONObject.isNull("data")) {
                                        fra.O000000o(jSONObject);
                                        if (fra.this.O00000o0.isEmpty()) {
                                            fra.this.O000000o((List<String>) null);
                                        }
                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }

                    public final void onFailure(gsf gsf, Exception exc, Response response) {
                        fra.this.O0000O0o = true;
                    }
                });
            }
        }
    }

    private static String O00000Oo(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(ServiceApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    public static void O0000O0o() {
        ArrayList<Device> arrayList = new ArrayList<>();
        Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
        Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
        if (O00000Oo2 != null) {
            arrayList.addAll(O00000Oo2.values());
        }
        if (O0000O0o2 != null) {
            arrayList.addAll(O0000O0o2.values());
        }
        for (Device device : arrayList) {
            if (!(device == null || device.property == null)) {
                device.property.putString("device_list_switch_subtitle", "");
            }
        }
    }

    public final Map<String, String> O000000o(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00000o0.get(str);
    }

    public final void O000000o(final String str, JSONArray jSONArray) {
        if (!TextUtils.isEmpty(str) && jSONArray != null && jSONArray.length() != 0) {
            Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
            Map<String, Device> O00000Oo2 = fno.O000000o().O00000Oo();
            ArrayList arrayList = new ArrayList(O0000O0o2.values());
            arrayList.addAll(O00000Oo2.values());
            if (arrayList.size() != 0) {
                for (int i = 0; i < arrayList.size(); i++) {
                    Device device = (Device) arrayList.get(i);
                    if (device != null) {
                        TextUtils.equals(str, device.did);
                    }
                }
                Map map = this.O00000o0.get(str);
                if (map == null) {
                    map = new HashMap();
                    this.O00000o0.put(str, map);
                }
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i2);
                    if (optJSONObject != null && !optJSONObject.isNull("key") && !optJSONObject.isNull("value")) {
                        String optString = optJSONObject.optString("key");
                        if (!TextUtils.isEmpty(optString) && optString.startsWith("prop.")) {
                            String substring = optString.substring(5);
                            Object opt = optJSONObject.opt("value");
                            if ((opt instanceof JSONArray) && ((JSONArray) opt).length() > 0) {
                                try {
                                    opt = ((JSONArray) opt).getString(0);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                            String str2 = O0000Ooo;
                            gsy.O000000o(3, str2, "did=" + str + ",key=" + substring + ",value=" + opt.toString());
                            map.put(substring, opt.toString());
                        }
                    }
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(str);
                fno.O000000o().O000000o(arrayList2, new fsm<List<Device>, fso>() {
                    /* class _m_j.fra.AnonymousClass4 */

                    public final void onFailure(fso fso) {
                    }

                    public final /* synthetic */ void onSuccess(Object obj) {
                        fno.O000000o().O00000o0(fno.O000000o().O000000o(str));
                        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent("com.smarthome.refresh_list_view"));
                    }
                });
            }
        }
    }
}
