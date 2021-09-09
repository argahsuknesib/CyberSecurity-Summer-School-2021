package _m_j;

import _m_j.fno;
import _m_j.fui;
import _m_j.ggb;
import _m_j.gts;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.device.RouterDevice;
import com.xiaomi.smarthome.device.api.Callback;
import com.xiaomi.smarthome.device.api.DevicelibApi;
import com.xiaomi.smarthome.device.utils.DeviceTagInterface;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.homeroom.model.Home;
import com.xiaomi.smarthome.homeroom.model.Room;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fqv implements DeviceTagInterface<Device> {

    /* renamed from: O000000o  reason: collision with root package name */
    public static boolean f16910O000000o = true;
    public static final int[] O00000Oo = {R.string.tag_recommend_bedroom, R.string.tag_recommend_livingroom, R.string.tag_recommend_kitchen, R.string.tag_recommend_washroom, R.string.tag_recommend_office};
    public static Map<String, Integer> O00000o;
    public static final HashMap<String, String> O00000o0 = new HashMap<>();
    public int O00000oO = 0;
    public boolean O00000oo = false;
    public long O0000O0o = 0;
    public boolean O0000OOo = false;
    public boolean O0000Oo = false;
    public boolean O0000Oo0 = false;
    public boolean O0000OoO = false;
    public List<Object> O0000Ooo = new ArrayList();
    private long O0000o = 0;
    public volatile boolean O0000o0 = false;
    public Handler O0000o00 = new Handler(Looper.getMainLooper());
    fno.O000000o O0000o0O = new fno.O000000o() {
        /* class _m_j.fqv.AnonymousClass1 */

        public final void onRefreshClientDeviceChanged(int i, Device device) {
        }

        public final void onRefreshClientDeviceSuccess(int i) {
            if (i == 3) {
                fqv fqv = fqv.this;
                fqv.O0000o0 = true;
                fqv.O0000oO0();
            }
        }
    };
    public Map<String, DeviceTagInterface.Category> O0000o0o = new HashMap();
    private String O0000oO;
    private int O0000oO0 = -1;
    private String O0000oOO;
    private List<Device> O0000oOo;
    private Map<String, String> O0000oo = new ConcurrentHashMap();
    private Map<String, O00000o> O0000oo0 = new ConcurrentHashMap();
    private long O0000ooO = 0;
    private Set<Integer> O0000ooo;
    private Map<Integer, List<String>> O000O00o;
    private String O000O0OO;
    private Map<String, String> O000O0Oo;
    private Map<String, DeviceTagInterface.Category> O00oOoOo = new HashMap();
    private Map<Integer, Map<String, Set<String>>> O00oOooO = new ConcurrentHashMap();
    private List<Integer> O00oOooo;

    public final /* synthetic */ List O000000o(Object obj) {
        Map<String, Set<String>> O000000o2;
        Device device = (Device) obj;
        List<String> O00000Oo2 = O00000Oo();
        if (device == null || TextUtils.isEmpty(device.bssid) || TextUtils.isEmpty(device.did) || (O000000o2 = O000000o(4)) == null || O000000o2.isEmpty()) {
            return O00000Oo2;
        }
        ArrayList arrayList = new ArrayList();
        String O0000o0O2 = O0000o0O(device.bssid);
        Map<String, Set<String>> O000000o3 = O000000o(2);
        Set<String> set = O000000o3.get(O0000o0O2);
        List<String> O0000oo02 = O0000oo0();
        if (O000000o3 != null && !O000000o3.isEmpty() && set != null && !set.isEmpty()) {
            for (String O000000o4 : set) {
                List<String> O000000o5 = O000000o(4, O000000o4);
                if (O000000o5 != null && !O000000o5.isEmpty()) {
                    for (String next : O000000o5) {
                        if (O000000o2.containsKey(next)) {
                            arrayList.add(next);
                            O000000o2.remove(next);
                        }
                    }
                }
            }
        }
        if (O0000oo02 != null && !O0000oo02.isEmpty()) {
            for (String next2 : O0000oo02) {
                if (O000000o2.containsKey(next2)) {
                    arrayList.add(next2);
                    O000000o2.remove(next2);
                }
            }
        }
        if (!O000000o2.isEmpty()) {
            arrayList.addAll(O000000o2.keySet());
        }
        HashSet hashSet = new HashSet();
        hashSet.addAll(arrayList);
        for (String next3 : O00000Oo2) {
            if (!hashSet.contains(next3)) {
                arrayList.add(next3);
            }
        }
        return arrayList;
    }

    static {
        HashMap hashMap = new HashMap();
        O00000o = hashMap;
        hashMap.put("switch", Integer.valueOf((int) R.string.tag_capability_switch));
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16934O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public String O00000oO;

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("province", this.f16934O000000o);
                jSONObject.put("city", this.O00000Oo);
                jSONObject.put("township", this.O00000o);
                jSONObject.put("addr", this.O00000oO);
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public final void O000000o(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.f16934O000000o = jSONObject.optString("province");
                this.O00000Oo = jSONObject.optString("city");
                this.O00000o0 = jSONObject.optString("district");
                this.O00000o = jSONObject.optString("township");
                this.O00000oO = jSONObject.optString("addr");
            }
        }

        public final String O00000Oo() {
            if (!gqb.O000000o(this.O00000o)) {
                return this.O00000o;
            }
            if (!gqb.O000000o(this.O00000o0)) {
                return this.O00000o0;
            }
            return this.f16934O000000o;
        }
    }

    public static class O00000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public String f16936O000000o;
        public String O00000Oo;
        public String O00000o;
        public String O00000o0;
        public O000000o O00000oO;
        public int O00000oo;

        public final JSONObject O000000o() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("bssid", this.f16936O000000o);
                if (!gqb.O000000o(this.O00000Oo)) {
                    jSONObject.put("pair_bssid", this.O00000Oo);
                }
                jSONObject.put("ssid", this.O00000o0);
                if (!gqb.O000000o(this.O00000o)) {
                    jSONObject.put("remark", this.O00000o);
                }
                if (this.O00000oO != null) {
                    jSONObject.put("location", this.O00000oO.O000000o());
                }
            } catch (JSONException unused) {
            }
            return jSONObject;
        }

        public final void O000000o(JSONObject jSONObject) {
            if (gqb.O000000o(this.f16936O000000o)) {
                this.f16936O000000o = jSONObject.optString("bssid");
            }
            if (gqb.O000000o(this.O00000Oo)) {
                this.O00000Oo = jSONObject.optString("pair_bssid");
            }
            if (gqb.O000000o(this.O00000o0)) {
                this.O00000o0 = jSONObject.optString("ssid");
            }
            this.O00000o = jSONObject.optString("remark");
            if (this.O00000oO == null) {
                this.O00000oO = new O000000o();
            }
            this.O00000oO.O000000o(jSONObject.optJSONObject("location"));
        }

        public final String O00000Oo() {
            O000000o o000000o = this.O00000oO;
            if (o000000o == null) {
                return null;
            }
            return o000000o.O00000Oo();
        }
    }

    class O00000o0 {

        /* renamed from: O000000o  reason: collision with root package name */
        int f16937O000000o;
        long O00000Oo;
        Map<String, O00000o> O00000o;
        long O00000o0;
        Map<String, Set<String>> O00000oO;
        Set<Integer> O00000oo;
        List<Integer> O0000O0o;
        Map<Integer, List<String>> O0000OOo;

        private O00000o0() {
        }

        /* synthetic */ O00000o0(fqv fqv, byte b) {
            this();
        }
    }

    class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        int f16935O000000o;
        long O00000Oo;
        int O00000o;
        int O00000o0;
        int O00000oO;
        int O00000oo;
        int O0000O0o;
        int O0000OOo;

        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(fqv fqv, byte b) {
            this();
        }
    }

    public final synchronized void O0000OoO() {
        this.O0000oO = null;
        this.O0000oOO = null;
        this.O0000oOo = null;
        this.O0000oo0.clear();
        this.O0000oo.clear();
        this.O0000ooO = 0;
        this.O0000O0o = 0;
        this.O0000OOo = false;
        this.O0000Oo0 = false;
        this.O0000Oo = false;
        this.O0000OoO = false;
        this.O0000ooo = null;
        this.O00oOooO = new HashMap();
        this.O00oOooo = null;
        this.O000O00o = null;
        this.O00000oO = 0;
        this.O0000o0 = false;
        fno.O000000o().O00000Oo(this.O0000o0O);
        this.O0000o0o.clear();
        this.O00oOoOo.clear();
        O00000o0(this.O0000oO, this.O0000oOO);
        if (ggb.O00000Oo().O00000oO()) {
            ggb.O00000Oo().O0000Ooo();
        }
    }

    private static void O00000o0(String str, String str2) {
        Intent intent = new Intent("device_tag_updated_action");
        if (!gqb.O000000o(str)) {
            intent.putExtra("device_tag_param", str);
        }
        if (!gqb.O000000o(str2)) {
            intent.putExtra("router_bssid_param", str2);
        }
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
    }

    public static String O0000Ooo() {
        if (!CoreApi.O000000o().O0000Ooo()) {
            return "device_tag_shared_prefs";
        }
        return gpp.O00000Oo(CoreApi.O000000o().O0000o0()) + "_device_tag_shared_prefs";
    }

    public final String O0000Oo() {
        if (ggb.O00000Oo().O00000oO()) {
            ggb O00000Oo2 = ggb.O00000Oo();
            if (O00000Oo2.O0000O0o == -1) {
                return "";
            }
            if (O00000Oo2.O0000O0o == 2) {
                return O00000Oo2.O00000oo;
            }
            return O00000Oo2.O00000oO;
        }
        int i = this.O0000oO0;
        if (i == -1) {
            return "";
        }
        if (i == 2) {
            return this.O0000oOO;
        }
        return this.O0000oO;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x006f, code lost:
        return;
     */
    public final synchronized void O00000o0() {
        if (CoreApi.O000000o().O0000Ooo()) {
            if (!this.O0000OoO) {
                fno.O000000o().O000000o(this.O0000o0O);
                this.O0000OoO = true;
                if (this.O0000o0o.isEmpty()) {
                    O0000o00(fcb.O000000o().O00000o("category_pref_category_data_key"));
                }
                DevicelibApi.getDeviceCategoryV2(ServiceApplication.getAppContext(), new fsm<JSONObject, fso>() {
                    /* class _m_j.fqv.AnonymousClass7 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        final JSONObject jSONObject = (JSONObject) obj;
                        goq.O000000o(new Runnable() {
                            /* class _m_j.fqv.AnonymousClass7.AnonymousClass1 */

                            public final void run() {
                                String optString = jSONObject.optString("catgory_info");
                                if (!TextUtils.isEmpty(optString)) {
                                    try {
                                        if (fqv.this.O000000o(new JSONArray(optString))) {
                                            fcb.O000000o().O000000o("category_pref_category_data_key", jSONObject.toString());
                                            Locale O00oOooo = CoreApi.O000000o().O00oOooo();
                                            if (O00oOooo == null) {
                                                O00oOooo = Locale.getDefault();
                                            }
                                            fcb.O000000o().O000000o("category_pref_category_locale_key", flk.O000000o(O00oOooo));
                                            fcb.O000000o().O000000o("category_pref_category_time_key", System.currentTimeMillis());
                                        }
                                    } catch (JSONException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        });
                    }

                    public final void onFailure(fso fso) {
                        fqv.this.O0000o00(fcb.O000000o().O00000o("category_pref_category_data_key"));
                    }
                });
                if (this.O0000Oo) {
                    O0000oO();
                    gts O000000o2 = gts.O000000o();
                    if (!O000000o2.O00000Oo) {
                        gsy.O000000o(3, "LiteDeviceManager", "loadFromServer");
                        fuj.O000000o().O000000o(CommonApplication.getApplication(), new String[]{"5"}, new fsm<ArrayList<fui>, fso>(null) {
                            /* class _m_j.gts.AnonymousClass1 */

                            /* renamed from: O000000o  reason: collision with root package name */
                            final /* synthetic */ Callback f18270O000000o = null;

                            public final /* synthetic */ void onSuccess(Object obj) {
                                fui fui;
                                ArrayList arrayList = (ArrayList) obj;
                                gts gts = gts.this;
                                gts.f18269O000000o = true;
                                gts.O00000Oo = true;
                                if (arrayList == null || arrayList.size() <= 0) {
                                    fui = null;
                                } else {
                                    fui = (fui) arrayList.get(0);
                                    fuj.O000000o().O000000o(fui);
                                }
                                gts gts2 = gts.this;
                                gts2.O00000o = gts2.O000000o(fui);
                                if (fsr.O0000O0o) {
                                    for (int i = 0; i < gts.this.O00000o.size(); i++) {
                                        O000000o o000000o = gts.this.O00000o.get(i);
                                        if (o000000o != null) {
                                            gsy.O000000o(3, "LiteDeviceManager", Arrays.toString(o000000o.O00000Oo.toArray()));
                                        }
                                    }
                                }
                                Callback callback = this.f18270O000000o;
                                if (callback != null) {
                                    callback.onSuccess(null);
                                }
                            }

                            public final void onFailure(fso fso) {
                                Callback callback = this.f18270O000000o;
                                if (callback != null) {
                                    callback.onFailure(fso.f17063O000000o, fso.O00000Oo);
                                }
                            }
                        });
                    }
                } else {
                    gor.O000000o(new AsyncTask<Object, Object, O00000o0>() {
                        /* class _m_j.fqv.AnonymousClass8 */

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ void onPostExecute(Object obj) {
                            fqv.this.O000000o((O00000o0) obj);
                            fqv.this.O0000Oo = true;
                        }

                        /* access modifiers changed from: protected */
                        public final /* synthetic */ Object doInBackground(Object[] objArr) {
                            SharedPreferences sharedPreferences = ServiceApplication.getAppContext().getSharedPreferences(fqv.O0000Ooo(), 0);
                            String string = sharedPreferences.getString("custom_tag_version_info", null);
                            if (string == null) {
                                return fqv.this.O0000Ooo(sharedPreferences.getString("router_info", null));
                            }
                            return fqv.this.O000000o(string, sharedPreferences.getString("custom_tag_router_info", null), sharedPreferences.getString("custom_tag_info", null), sharedPreferences.getString("custom_tag_order_info", null));
                        }
                    }, new Object[0]);
                }
            }
        }
    }

    public final synchronized void O000000o(O00000o0 o00000o0) {
        if (o00000o0 == null) {
            O0000oO();
            return;
        }
        O00000Oo(o00000o0);
        O0000oO();
    }

    public final synchronized void O00000Oo(O00000o0 o00000o0) {
        if (o00000o0 != null) {
            if (o00000o0.O00000Oo > 0) {
                this.O0000ooO = o00000o0.O00000Oo;
            }
            if (o00000o0.O00000o0 > 0) {
                this.O0000O0o = o00000o0.O00000o0;
            }
            this.O00000oO = o00000o0.f16937O000000o;
            if (o00000o0.O00000o != null && !o00000o0.O00000o.isEmpty()) {
                for (String next : o00000o0.O00000o.keySet()) {
                    O00000o o00000o = o00000o0.O00000o.get(next);
                    O00000o o00000o2 = this.O0000oo0.get(O000000o(next, o00000o.O00000o0, 3));
                    if (o00000o2 == null) {
                        this.O0000oo0.put(next, o00000o);
                    } else {
                        if (TextUtils.isEmpty(o00000o2.f16936O000000o)) {
                            o00000o2.f16936O000000o = o00000o.f16936O000000o;
                        }
                        if (TextUtils.isEmpty(o00000o2.O00000Oo)) {
                            o00000o2.O00000Oo = o00000o.O00000Oo;
                        }
                        if (TextUtils.isEmpty(o00000o2.O00000o0)) {
                            o00000o2.O00000o0 = o00000o.O00000o0;
                        }
                        o00000o2.O00000o = o00000o.O00000o;
                        o00000o2.O00000oO = o00000o.O00000oO;
                    }
                }
            }
            if (o00000o0.O00000oO != null) {
                this.O00oOooO.put(4, o00000o0.O00000oO);
            }
            this.O0000ooo = o00000o0.O00000oo;
            this.O00oOooo = o00000o0.O0000O0o;
            this.O000O00o = o00000o0.O0000OOo;
            O0000o0("tag_info_updated_action");
        }
    }

    public final O00000o0 O0000Ooo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            O00000o0 o00000o0 = new O00000o0(this, (byte) 0);
            JSONObject jSONObject = new JSONObject(str);
            o00000o0.O00000Oo = jSONObject.optLong("router_location_last_time");
            JSONArray optJSONArray = jSONObject.optJSONArray("router_info");
            if (optJSONArray != null) {
                o00000o0.O00000o = new ConcurrentHashMap();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    String optString = optJSONObject.optString("bssid");
                    String optString2 = optJSONObject.optString("ssid");
                    if (!gqb.O000000o(optString) && !gqb.O000000o(optString2)) {
                        O00000o o00000o = new O00000o();
                        o00000o.O000000o(optJSONObject);
                        if (O0000o0o(o00000o.f16936O000000o)) {
                            o00000o0.O00000o.put(optString, o00000o);
                        }
                    }
                }
            }
            O000000o(o00000o0, jSONObject.optJSONArray("custom_tag_info"));
            JSONObject optJSONObject2 = jSONObject.optJSONObject("order");
            if (optJSONObject2 != null) {
                O00000Oo(o00000o0, optJSONObject2.optJSONArray("dt"));
                O00000o0(o00000o0, optJSONObject2.optJSONArray("dto"));
                O00000o(o00000o0, optJSONObject2.optJSONArray("o"));
            }
            o00000o0.O00000o0 = jSONObject.optLong("custom_tag_last_time");
            return o00000o0;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public final O00000o0 O000000o(String str, String str2, String str3, String str4) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            O00000o0 o00000o0 = new O00000o0(this, (byte) 0);
            JSONObject jSONObject = new JSONObject(str);
            o00000o0.f16937O000000o = jSONObject.optInt("ver");
            o00000o0.O00000o0 = jSONObject.optLong("custom_tag_last_time");
            O000000o(str2, o00000o0);
            O00000Oo(str3, o00000o0);
            O00000o0(str4, o00000o0);
            return o00000o0;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static void O0000o0(String str) {
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(new Intent(str));
    }

    private static void O000000o(O00000o0 o00000o0, JSONArray jSONArray) {
        if (jSONArray != null) {
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (!(optJSONObject == null || optJSONObject == null)) {
                    String optString = optJSONObject.optString("did");
                    JSONArray optJSONArray = optJSONObject.optJSONArray("tag");
                    if (optJSONArray != null) {
                        int length2 = optJSONArray.length();
                        for (int i2 = 0; i2 < length2; i2++) {
                            String optString2 = optJSONArray.optString(i2);
                            if (!TextUtils.isEmpty(optString2)) {
                                if (o00000o0.O00000oO == null) {
                                    o00000o0.O00000oO = new ConcurrentHashMap();
                                }
                                Object obj = o00000o0.O00000oO.get(optString2);
                                if (obj == null) {
                                    obj = new HashSet();
                                    o00000o0.O00000oO.put(optString2, obj);
                                }
                                if (!TextUtils.isEmpty(optString)) {
                                    obj.add(optString);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private synchronized void O00000Oo(O00000o0 o00000o0, JSONArray jSONArray) {
        if (jSONArray != null) {
            o00000o0.O00000oo = new HashSet();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    o00000o0.O00000oo.add(Integer.valueOf(optJSONObject.optInt("t")));
                }
            }
        }
    }

    private static void O00000o0(O00000o0 o00000o0, JSONArray jSONArray) {
        if (jSONArray != null) {
            o00000o0.O0000O0o = new ArrayList();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    o00000o0.O0000O0o.add(Integer.valueOf(optJSONObject.optInt("t")));
                }
            }
        }
    }

    private static void O00000o(O00000o0 o00000o0, JSONArray jSONArray) {
        JSONArray optJSONArray;
        if (jSONArray != null) {
            o00000o0.O0000OOo = new ConcurrentHashMap();
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = jSONArray.optJSONObject(i);
                int optInt = optJSONObject.optInt("t");
                if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("o")) == null)) {
                    ArrayList arrayList = new ArrayList();
                    int length2 = optJSONArray.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        JSONObject optJSONObject2 = optJSONArray.optJSONObject(i2);
                        if (optJSONObject2 != null) {
                            String optString = optJSONObject2.optString("tag");
                            if (!TextUtils.isEmpty(optString)) {
                                arrayList.add(optString);
                            }
                        }
                    }
                    o00000o0.O0000OOo.put(Integer.valueOf(optInt), arrayList);
                }
            }
        }
    }

    public static void O000000o(int i, int i2, JSONArray jSONArray) {
        if (i2 > 0 && i > 0) {
            for (int i3 = i; i3 < i + i2; i3++) {
                jSONArray.put(i3);
            }
        }
    }

    static String O000000o(int i, int i2, Map<Integer, fui.O00000Oo> map) {
        int i3 = i2 + i;
        String str = "";
        while (i < i3) {
            fui.O00000Oo o00000Oo = map.get(Integer.valueOf(i));
            if (o00000Oo == null) {
                return null;
            }
            str = str + o00000Oo.O00000o0;
            i++;
        }
        return str;
    }

    private void O0000oO() {
        ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.fqv.AnonymousClass12 */

            public final void run() {
                JSONArray jSONArray = new JSONArray();
                jSONArray.put(1000);
                jSONArray.put(3001);
                jSONArray.put(1001);
                jSONArray.put(2001);
                fuj.O000000o().O000000o(ServiceApplication.getAppContext(), 0, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>() {
                    /* class _m_j.fqv.AnonymousClass12.AnonymousClass1 */

                    public final /* synthetic */ void onSuccess(Object obj) {
                        Map map = (Map) obj;
                        if (map == null || map.size() <= 0) {
                            ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
                                /* class _m_j.fqv.AnonymousClass9 */

                                public final void run() {
                                    fuj.O000000o().O000000o(ServiceApplication.getAppContext(), new String[]{"2"}, new fsm<ArrayList<fui>, fso>() {
                                        /* class _m_j.fqv.AnonymousClass9.AnonymousClass1 */

                                        public final /* synthetic */ void onSuccess(Object obj) {
                                            O00000o0 o00000o0;
                                            fui fui;
                                            ArrayList arrayList = (ArrayList) obj;
                                            fqv fqv = fqv.this;
                                            if (arrayList != null && arrayList.size() > 0 && (fui = (fui) arrayList.get(0)) != null && fui.O00000o0 != null && fui.O00000o0.size() > 0 && "router_info".equals(fui.O00000o0.get(0).f17182O000000o)) {
                                                String str = fui.O00000o0.get(0).O00000Oo;
                                                if (!gqb.O000000o(str)) {
                                                    o00000o0 = fqv.O0000Ooo(str);
                                                    if (o00000o0 == null) {
                                                        return;
                                                    }
                                                    fqv.O0000o00.post(new Runnable(o00000o0) {
                                                        /* class _m_j.fqv.AnonymousClass14 */

                                                        /* renamed from: O000000o  reason: collision with root package name */
                                                        final /* synthetic */ O00000o0 f16919O000000o;

                                                        {
                                                            this.f16919O000000o = r2;
                                                        }

                                                        public final void run() {
                                                            fqv fqv = fqv.this;
                                                            fqv.O0000OoO = false;
                                                            fqv.O0000Oo0 = true;
                                                            if (this.f16919O000000o == null) {
                                                                return;
                                                            }
                                                            if (!fqv.O0000Oo0 || this.f16919O000000o.O00000o0 <= 0 || this.f16919O000000o.O00000o0 > fqv.this.O0000O0o) {
                                                                fqv.this.O00000Oo(this.f16919O000000o);
                                                                fqv.this.O0000o00();
                                                                return;
                                                            }
                                                            fqv.this.O0000o00();
                                                        }
                                                    });
                                                }
                                            }
                                            o00000o0 = null;
                                            fqv.O0000o00.post(new Runnable(o00000o0) {
                                                /* class _m_j.fqv.AnonymousClass14 */

                                                /* renamed from: O000000o  reason: collision with root package name */
                                                final /* synthetic */ O00000o0 f16919O000000o;

                                                {
                                                    this.f16919O000000o = r2;
                                                }

                                                public final void run() {
                                                    fqv fqv = fqv.this;
                                                    fqv.O0000OoO = false;
                                                    fqv.O0000Oo0 = true;
                                                    if (this.f16919O000000o == null) {
                                                        return;
                                                    }
                                                    if (!fqv.O0000Oo0 || this.f16919O000000o.O00000o0 <= 0 || this.f16919O000000o.O00000o0 > fqv.this.O0000O0o) {
                                                        fqv.this.O00000Oo(this.f16919O000000o);
                                                        fqv.this.O0000o00();
                                                        return;
                                                    }
                                                    fqv.this.O0000o00();
                                                }
                                            });
                                        }

                                        public final void onFailure(fso fso) {
                                            fqv.this.O0000o00.post(new Runnable() {
                                                /* class _m_j.fqv.AnonymousClass9.AnonymousClass1.AnonymousClass1 */

                                                public final void run() {
                                                    fqv.this.O0000OoO = false;
                                                }
                                            });
                                        }
                                    });
                                }
                            });
                            return;
                        }
                        fqv fqv = fqv.this;
                        if (map != null && !map.isEmpty()) {
                            try {
                                O00000Oo o00000Oo = new O00000Oo(fqv, (byte) 0);
                                fui.O00000Oo o00000Oo2 = (fui.O00000Oo) map.get(1000);
                                if (o00000Oo2 != null && !TextUtils.isEmpty(o00000Oo2.O00000o0)) {
                                    JSONObject jSONObject = new JSONObject(o00000Oo2.O00000o0);
                                    o00000Oo.f16935O000000o = jSONObject.optInt("ver");
                                    o00000Oo.O00000Oo = jSONObject.optLong("custom_tag_last_time");
                                }
                                fui.O00000Oo o00000Oo3 = (fui.O00000Oo) map.get(3001);
                                if (o00000Oo3 != null) {
                                    if (!TextUtils.isEmpty(o00000Oo3.O00000o0)) {
                                        JSONObject jSONObject2 = new JSONObject(o00000Oo3.O00000o0);
                                        o00000Oo.O00000o0 = jSONObject2.optInt("ts");
                                        o00000Oo.O00000o = jSONObject2.optInt("tc");
                                    }
                                }
                                fui.O00000Oo o00000Oo4 = (fui.O00000Oo) map.get(1001);
                                if (o00000Oo4 != null && !TextUtils.isEmpty(o00000Oo4.O00000o0)) {
                                    JSONObject jSONObject3 = new JSONObject(o00000Oo4.O00000o0);
                                    o00000Oo.O00000oO = jSONObject3.optInt("ts");
                                    o00000Oo.O00000oo = jSONObject3.optInt("tc");
                                }
                                fui.O00000Oo o00000Oo5 = (fui.O00000Oo) map.get(2001);
                                if (o00000Oo5 != null && !TextUtils.isEmpty(o00000Oo5.O00000o0)) {
                                    JSONObject jSONObject4 = new JSONObject(o00000Oo5.O00000o0);
                                    o00000Oo.O0000O0o = jSONObject4.optInt("ts");
                                    o00000Oo.O0000OOo = jSONObject4.optInt("tc");
                                }
                                fqv.O0000o00.post(new Runnable(o00000Oo) {
                                    /* class _m_j.fqv.AnonymousClass13 */

                                    /* renamed from: O000000o  reason: collision with root package name */
                                    final /* synthetic */ O00000Oo f16918O000000o;

                                    {
                                        this.f16918O000000o = r2;
                                    }

                                    public final void run() {
                                        if (fqv.this.O00000oO < this.f16918O000000o.f16935O000000o || (fqv.this.O00000oO == this.f16918O000000o.f16935O000000o && fqv.this.O0000O0o < this.f16918O000000o.O00000Oo)) {
                                            fqv fqv = fqv.this;
                                            O00000Oo o00000Oo = this.f16918O000000o;
                                            if (o00000Oo != null) {
                                                ServiceApplication.getGlobalWorkerHandler().post(new Runnable(o00000Oo) {
                                                    /* class _m_j.fqv.AnonymousClass10 */

                                                    /* renamed from: O000000o  reason: collision with root package name */
                                                    final /* synthetic */ O00000Oo f16912O000000o;

                                                    {
                                                        this.f16912O000000o = r2;
                                                    }

                                                    public final void run() {
                                                        JSONArray jSONArray = new JSONArray();
                                                        fqv.O000000o(this.f16912O000000o.O00000o0, this.f16912O000000o.O00000o, jSONArray);
                                                        fqv.O000000o(this.f16912O000000o.O00000oO, this.f16912O000000o.O00000oo, jSONArray);
                                                        fqv.O000000o(this.f16912O000000o.O0000O0o, this.f16912O000000o.O0000OOo, jSONArray);
                                                        fuj.O000000o().O000000o(ServiceApplication.getAppContext(), 0, jSONArray, new fsm<Map<Integer, fui.O00000Oo>, fso>() {
                                                            /* class _m_j.fqv.AnonymousClass10.AnonymousClass1 */

                                                            public final /* synthetic */ void onSuccess(Object obj) {
                                                                Map map = (Map) obj;
                                                                fqv fqv = fqv.this;
                                                                O00000Oo o00000Oo = AnonymousClass10.this.f16912O000000o;
                                                                if (map != null && !map.isEmpty()) {
                                                                    String O000000o2 = fqv.O000000o(o00000Oo.O00000o0, o00000Oo.O00000o, map);
                                                                    String O000000o3 = fqv.O000000o(o00000Oo.O00000oO, o00000Oo.O00000oo, map);
                                                                    String O000000o4 = fqv.O000000o(o00000Oo.O0000O0o, o00000Oo.O0000OOo, map);
                                                                    O00000o0 o00000o0 = new O00000o0(fqv, (byte) 0);
                                                                    fqv.O000000o(O000000o2, o00000o0);
                                                                    fqv.O00000Oo(O000000o3, o00000o0);
                                                                    fqv.O00000o0(O000000o4, o00000o0);
                                                                    o00000o0.O00000o0 = o00000Oo.O00000Oo;
                                                                    o00000o0.f16937O000000o = o00000Oo.f16935O000000o;
                                                                    try {
                                                                        JSONObject jSONObject = new JSONObject();
                                                                        jSONObject.put("ver", o00000Oo.f16935O000000o);
                                                                        jSONObject.put("custom_tag_last_time", o00000Oo.O00000Oo);
                                                                        SharedPreferences.Editor edit = ServiceApplication.getAppContext().getSharedPreferences(fqv.O0000Ooo(), 0).edit();
                                                                        edit.putString("custom_tag_version_info", jSONObject.toString());
                                                                        edit.putString("custom_tag_router_info", O000000o2);
                                                                        edit.putString("custom_tag_info", O000000o3);
                                                                        edit.putString("custom_tag_order_info", O000000o4);
                                                                        edit.apply();
                                                                    } catch (JSONException e) {
                                                                        e.printStackTrace();
                                                                    }
                                                                    fqv.O0000o00.post(new Runnable(o00000o0) {
                                                                        /* class _m_j.fqv.AnonymousClass11 */

                                                                        /* renamed from: O000000o  reason: collision with root package name */
                                                                        final /* synthetic */ O00000o0 f16914O000000o;

                                                                        {
                                                                            this.f16914O000000o = r2;
                                                                        }

                                                                        public final void run() {
                                                                            fqv.this.O00000Oo(this.f16914O000000o);
                                                                            fqv fqv = fqv.this;
                                                                            fqv.O0000Oo0 = true;
                                                                            fqv.O0000OoO = false;
                                                                        }
                                                                    });
                                                                }
                                                                for (int i = 0; i < fqv.this.O0000Ooo.size(); i++) {
                                                                    if (fqv.this.O0000Ooo.get(i) != null) {
                                                                        fqv.this.O0000Ooo.get(i);
                                                                    }
                                                                }
                                                            }

                                                            public final void onFailure(fso fso) {
                                                                fqv.this.O0000OoO = false;
                                                            }
                                                        });
                                                    }
                                                });
                                                return;
                                            }
                                            return;
                                        }
                                        fqv fqv2 = fqv.this;
                                        fqv2.O0000Oo0 = true;
                                        fqv2.O0000OoO = false;
                                        for (int i = 0; i < fqv.this.O0000Ooo.size(); i++) {
                                            if (fqv.this.O0000Ooo.get(i) != null) {
                                                fqv.this.O0000Ooo.get(i);
                                            }
                                        }
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                                fqv.O0000OoO = false;
                            }
                        }
                    }

                    public final void onFailure(fso fso) {
                        fqv.this.O0000o00.post(new Runnable() {
                            /* class _m_j.fqv.AnonymousClass12.AnonymousClass1.AnonymousClass1 */

                            public final void run() {
                                fqv.this.O0000OoO = false;
                            }
                        });
                    }
                });
            }
        });
    }

    public final synchronized void O0000o00() {
        if (this.O0000Oo0) {
            final JSONObject O0000oOO2 = O0000oOO();
            final JSONObject O0000o02 = O0000o0();
            final JSONObject O0000o0O2 = O0000o0O();
            this.O00000oO = 1;
            goq.O000000o(new Runnable() {
                /* class _m_j.fqv.AnonymousClass15 */

                public final void run() {
                    try {
                        JSONObject O0000o0o = fqv.this.O0000o0o();
                        SharedPreferences.Editor edit = ServiceApplication.getAppContext().getSharedPreferences(fqv.O0000Ooo(), 0).edit();
                        edit.putString("custom_tag_version_info", O0000o0o.toString());
                        if (O0000oOO2 != null) {
                            edit.putString("custom_tag_router_info", O0000oOO2.toString());
                        }
                        if (O0000o02 != null) {
                            edit.putString("custom_tag_info", O0000o02.toString());
                        }
                        if (O0000o0O2 != null) {
                            edit.putString("custom_tag_order_info", O0000o0O2.toString());
                        }
                        edit.apply();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            ServiceApplication.getGlobalWorkerHandler().post(new Runnable(O0000oOO2, O0000o02, O0000o0O2, 1) {
                /* class _m_j.fqv.AnonymousClass2 */

                /* renamed from: O000000o  reason: collision with root package name */
                final /* synthetic */ JSONObject f16921O000000o;
                final /* synthetic */ JSONObject O00000Oo;
                final /* synthetic */ int O00000o = 1;
                final /* synthetic */ JSONObject O00000o0;

                {
                    this.f16921O000000o = r2;
                    this.O00000Oo = r3;
                    this.O00000o0 = r4;
                }

                public final void run() {
                    try {
                        JSONArray jSONArray = new JSONArray();
                        fqv.O000000o(this.f16921O000000o, 3001, jSONArray);
                        fqv.O000000o(this.O00000Oo, 1001, jSONArray);
                        fqv.O000000o(this.O00000o0, 2001, jSONArray);
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("ver", this.O00000o);
                        jSONObject.put("custom_tag_last_time", fqv.this.O0000O0o);
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("component_id", 0);
                        jSONObject2.put("key", "1000");
                        jSONObject2.put("data", jSONObject);
                        jSONArray.put(jSONObject2);
                        fuj.O000000o().O000000o(ServiceApplication.getAppContext(), jSONArray, new fsm<JSONObject, fso>() {
                            /* class _m_j.fqv.AnonymousClass2.AnonymousClass1 */

                            public final void onFailure(fso fso) {
                            }

                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    private synchronized JSONObject O0000oOO() {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        for (String str : this.O0000oo0.keySet()) {
            jSONArray.put(this.O0000oo0.get(str).O000000o());
        }
        jSONObject = new JSONObject();
        try {
            jSONObject.put("router_info", jSONArray);
            jSONObject.put("router_location_last_time", this.O0000ooO);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static void O000000o(String str, O00000o0 o00000o0) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("router_info");
                if (optJSONArray != null) {
                    o00000o0.O00000Oo = jSONObject.optLong("router_location_last_time");
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            O00000o o00000o = new O00000o();
                            o00000o.O000000o(optJSONObject);
                            if (O0000o0o(o00000o.f16936O000000o)) {
                                if (o00000o0.O00000o == null) {
                                    o00000o0.O00000o = new ConcurrentHashMap();
                                }
                                o00000o0.O00000o.put(o00000o.f16936O000000o, o00000o);
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final JSONObject O0000o0() {
        JSONArray jSONArray = new JSONArray();
        Map<String, Set<String>> O000000o2 = O000000o(4);
        if (O000000o2 != null && !O000000o2.isEmpty()) {
            for (String next : O000000o2.keySet()) {
                jSONArray.put(O000000o(next, O000000o2.get(next)));
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("tag", jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    private static JSONObject O000000o(String str, Set<String> set) {
        JSONArray jSONArray = new JSONArray();
        if (set != null && set.size() > 0) {
            for (String put : set) {
                jSONArray.put(put);
            }
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(str, jSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static void O00000Oo(String str, O00000o0 o00000o0) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONArray optJSONArray = new JSONObject(str).optJSONArray("tag");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            Iterator<String> keys = optJSONObject.keys();
                            if (keys.hasNext()) {
                                String next = keys.next();
                                if (!TextUtils.isEmpty(next)) {
                                    Set<String> O00000Oo2 = O00000Oo(optJSONObject.optJSONArray(next));
                                    if (o00000o0.O00000oO == null) {
                                        o00000o0.O00000oO = new ConcurrentHashMap();
                                    }
                                    o00000o0.O00000oO.put(next, O00000Oo2);
                                }
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static Set<String> O00000Oo(JSONArray jSONArray) {
        HashSet hashSet = new HashSet();
        if (jSONArray == null) {
            return hashSet;
        }
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
        }
        return hashSet;
    }

    /* access modifiers changed from: package-private */
    public final synchronized JSONObject O0000o0O() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            if (this.O0000ooo != null) {
                JSONArray jSONArray = new JSONArray();
                for (Integer put : this.O0000ooo) {
                    jSONArray.put(put);
                }
                jSONObject.put("dt", jSONArray);
            }
            if (this.O00oOooo != null && !this.O00oOooo.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (Integer put2 : this.O00oOooo) {
                    jSONArray2.put(put2);
                }
                jSONObject.put("dto", jSONArray2);
            }
            if (this.O000O00o != null && !this.O000O00o.isEmpty()) {
                JSONArray jSONArray3 = new JSONArray();
                for (Integer intValue : this.O000O00o.keySet()) {
                    int intValue2 = intValue.intValue();
                    List<String> list = this.O000O00o.get(Integer.valueOf(intValue2));
                    if (list != null && !list.isEmpty()) {
                        JSONArray jSONArray4 = new JSONArray();
                        for (String put3 : list) {
                            jSONArray4.put(put3);
                        }
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.put("t", intValue2);
                        jSONObject2.put("o", jSONArray4);
                        jSONArray3.put(jSONObject2);
                    }
                }
                jSONObject.put("o", jSONArray3);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }

    static void O00000o0(String str, O00000o0 o00000o0) {
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONArray optJSONArray = jSONObject.optJSONArray("dt");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        int optInt = optJSONArray.optInt(i);
                        if (o00000o0.O00000oo == null) {
                            o00000o0.O00000oo = new HashSet();
                        }
                        o00000o0.O00000oo.add(Integer.valueOf(optInt));
                    }
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("dto");
                if (optJSONArray2 != null) {
                    int length2 = optJSONArray2.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        int optInt2 = optJSONArray2.optInt(i2);
                        if (o00000o0.O0000O0o == null) {
                            o00000o0.O0000O0o = new ArrayList();
                        }
                        o00000o0.O0000O0o.add(Integer.valueOf(optInt2));
                    }
                }
                JSONArray optJSONArray3 = jSONObject.optJSONArray("o");
                if (optJSONArray3 != null) {
                    int length3 = optJSONArray3.length();
                    for (int i3 = 0; i3 < length3; i3++) {
                        JSONObject optJSONObject = optJSONArray3.optJSONObject(i3);
                        if (optJSONObject != null) {
                            int optInt3 = optJSONObject.optInt("t");
                            JSONArray optJSONArray4 = optJSONObject.optJSONArray("o");
                            if (optJSONArray4 != null) {
                                if (o00000o0.O0000OOo == null) {
                                    o00000o0.O0000OOo = new ConcurrentHashMap();
                                }
                                o00000o0.O0000OOo.put(Integer.valueOf(optInt3), O00000o0(optJSONArray4));
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private static ArrayList<String> O00000o0(JSONArray jSONArray) {
        ArrayList<String> arrayList = new ArrayList<>();
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            String optString = jSONArray.optString(i);
            if (!TextUtils.isEmpty(optString)) {
                arrayList.add(optString);
            }
        }
        return arrayList;
    }

    public final synchronized JSONObject O0000o0o() throws JSONException {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        jSONObject.put("ver", this.O00000oO > 0 ? this.O00000oO : 1);
        jSONObject.put("custom_tag_last_time", this.O0000O0o);
        return jSONObject;
    }

    public static void O000000o(JSONObject jSONObject, int i, JSONArray jSONArray) throws JSONException {
        int i2;
        String jSONObject2 = jSONObject.toString();
        int length = jSONObject2.length();
        if (length > 2048) {
            int i3 = length / 2048;
            i2 = length % 2048 != 0 ? i3 + 1 : i3;
        } else {
            i2 = 1;
        }
        if (i2 + 1 <= 1000) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("component_id", 0);
            jSONObject3.put("key", String.valueOf(i));
            int i4 = i + 1;
            JSONObject jSONObject4 = new JSONObject();
            jSONObject4.put("ts", i4);
            jSONObject4.put("tc", i2);
            jSONObject3.put("data", jSONObject4.toString());
            jSONArray.put(jSONObject3);
            int i5 = i4;
            int i6 = 0;
            for (int i7 = 0; i7 < i2; i7++) {
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("component_id", 0);
                jSONObject5.put("key", String.valueOf(i5));
                if (i7 == i2 - 1) {
                    jSONObject5.put("data", jSONObject2.substring(i6));
                } else {
                    jSONObject5.put("data", jSONObject2.substring(i6, i6 + 2048));
                }
                jSONArray.put(jSONObject5);
                i6 += 2048;
                i5++;
            }
        }
    }

    public final boolean O000000o() {
        return ggb.O00000Oo().O00000oO() ? ggb.O00000Oo().O0000O0o != -1 : this.O0000oO0 != -1;
    }

    public final synchronized void O000000o(List<Device> list) {
        if (this.O00oOooO != null) {
            this.O00oOooO.remove(2);
            this.O00oOooO.remove(0);
        }
        for (Device O000000o2 : list) {
            O000000o(O000000o2);
        }
        O00000o0(list);
    }

    public final synchronized void O000000o(Map<String, Device> map) {
        if (map != null) {
            for (Map.Entry<String, Device> value : map.entrySet()) {
                O000000o((Device) value.getValue());
            }
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0103, code lost:
        return;
     */
    private synchronized void O00000o0(List<Device> list) {
        int i;
        if (CoreApi.O000000o().O0000Ooo()) {
            if (this.O0000oO0 != -1 && !gqb.O000000o(this.O0000oO)) {
                if (!this.O0000oO.equals(ServiceApplication.getAppContext().getString(R.string.tag_all_devices))) {
                    String str = this.O0000oO;
                    if (this.O0000oO0 == 2) {
                        str = this.O0000oOO;
                    }
                    Map map = this.O00oOooO.get(Integer.valueOf(this.O0000oO0));
                    int i2 = 0;
                    if (map == null || map.isEmpty() || !map.containsKey(str)) {
                        i = 0;
                    } else {
                        Set<String> set = (Set) map.get(str);
                        if (set == null || set.isEmpty()) {
                            i = 0;
                        } else {
                            HashSet hashSet = new HashSet();
                            if (list != null && !list.isEmpty()) {
                                for (Device next : list) {
                                    if (!TextUtils.isEmpty(next.did)) {
                                        hashSet.add(next.did);
                                    }
                                }
                            }
                            for (String contains : set) {
                                if (hashSet.contains(contains)) {
                                    i2++;
                                }
                            }
                            i = i2;
                        }
                        i2 = 1;
                    }
                    if (i2 == 0) {
                        this.O0000oO0 = -1;
                        this.O0000oO = null;
                        this.O0000oOO = null;
                        this.O0000oOo = null;
                    }
                    Intent intent = new Intent("device_tag_selected_action");
                    intent.putExtra("param_device_tag_type", this.O0000oO0);
                    intent.putExtra("tag_selected_param", true);
                    if (!TextUtils.isEmpty(this.O0000oO)) {
                        intent.putExtra("device_tag_param", this.O0000oO);
                    }
                    if (this.O0000oO0 == 2 && !gqb.O000000o(this.O0000oOO)) {
                        intent.putExtra("router_bssid_param", this.O0000oOO);
                    }
                    if (i > 0) {
                        intent.putExtra("param_device_count", i);
                    }
                    ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
                }
            }
        }
    }

    private synchronized void O000000o(Device device) {
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
        if (O00000oO2 != null) {
            String O0000oO2 = O00000oO2.O0000oO();
            if (!TextUtils.isEmpty(O0000oO2)) {
                O000000o(0, O0000oO2, device.did);
            }
        }
        String str = device.bssid;
        String str2 = device.ssid;
        int i = !device.isOnline;
        if (TextUtils.isEmpty(str2) && (device instanceof RouterDevice)) {
            str2 = device.name;
            i = 2;
        }
        if (!gqb.O000000o(str) && !gqb.O000000o(str2)) {
            String upperCase = str.toUpperCase();
            if (O0000o0o(upperCase)) {
                O000000o(2, O000000o(upperCase, str2, i), device.did);
            }
        }
    }

    private synchronized void O000000o(int i, String str, String str2) {
        Map map = this.O00oOooO.get(Integer.valueOf(i));
        if (map == null) {
            map = new HashMap();
            this.O00oOooO.put(Integer.valueOf(i), map);
        }
        Object obj = (Set) map.get(str);
        if (obj == null) {
            obj = new HashSet();
            map.put(str, obj);
        }
        if (!TextUtils.isEmpty(str2)) {
            obj.add(str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:67:0x011b, code lost:
        return;
     */
    public final synchronized void O000000o(Set<String> set, String str, boolean z, ggb.O00000o o00000o) {
        if (ggb.O00000Oo().O00000oO()) {
            ggb.O00000Oo().O000000o(set, str, o00000o);
        } else if (set != null) {
            if (!set.isEmpty()) {
                String next = set.iterator().next();
                if (!TextUtils.isEmpty(next)) {
                    Map map = this.O00oOooO.get(4);
                    if (map == null) {
                        map = new HashMap();
                        this.O00oOooO.put(4, map);
                        if (z) {
                            this.O000O0OO = next;
                        }
                    } else if (!TextUtils.isEmpty(str)) {
                        boolean z2 = false;
                        for (Map.Entry entry : map.entrySet()) {
                            if (TextUtils.equals((CharSequence) entry.getKey(), next)) {
                                if (entry.getValue() != null) {
                                    if (!((Set) entry.getValue()).isEmpty()) {
                                        z2 = true;
                                    }
                                }
                                if (z) {
                                    this.O000O0OO = next;
                                }
                            }
                            if (entry.getValue() != null && ((Set) entry.getValue()).contains(str)) {
                                ((Set) entry.getValue()).remove(str);
                            }
                        }
                        if (!z2 && z) {
                            this.O000O0OO = next;
                        }
                    }
                    for (String next2 : set) {
                        Set set2 = null;
                        if (map.containsKey(next2)) {
                            set2 = (Set) map.get(next2);
                        } else {
                            if (this.O000O00o == null) {
                                this.O000O00o = new HashMap();
                            }
                            Object obj = this.O000O00o.get(4);
                            if (obj == null) {
                                obj = new ArrayList();
                                this.O000O00o.put(4, obj);
                            }
                            obj.add(next2);
                        }
                        if (set2 == null) {
                            set2 = new HashSet();
                            map.put(next2, set2);
                        }
                        if (!TextUtils.isEmpty(str)) {
                            set2.add(str);
                        }
                    }
                    O0000o0("tag_info_edited_new_action");
                    O0000oOo();
                }
            }
        }
    }

    private synchronized boolean O00000Oo(int i, String str) {
        Map map = this.O00oOooO.get(4);
        if (map != null) {
            if (!map.isEmpty()) {
                return map.containsKey(str);
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ed, code lost:
        return;
     */
    public final synchronized void O000000o(String str) {
        if (ggb.O00000Oo().O00000oO()) {
            ggb.O00000Oo().O0000o(str);
            return;
        }
        Map map = this.O00oOooO.get(4);
        if (map != null) {
            map.remove(str);
            gts O000000o2 = gts.O000000o();
            if (!TextUtils.isEmpty(str) && O000000o2.O00000o != null) {
                Iterator<gts.O000000o> it = O000000o2.O00000o.iterator();
                while (true) {
                    if (it.hasNext()) {
                        gts.O000000o next = it.next();
                        if (str.equals(next.f18272O000000o)) {
                            O000000o2.O00000o.remove(next);
                            O000000o2.O00000o0 = true;
                            break;
                        }
                    } else {
                        String O0000Oo2 = fnn.O000000o().O00000Oo().O0000Oo();
                        ArrayList arrayList = new ArrayList();
                        for (int i = 0; i < O000000o2.O0000O0o.size(); i++) {
                            arrayList.add(((gtq) O000000o2.O0000O0o.get(i)).f18268O000000o);
                        }
                        O000000o2.O000000o(O0000Oo2, arrayList);
                        fui O000000o3 = gts.O000000o(O000000o2.O00000o);
                        fuj.O000000o().O000000o(O000000o3);
                        if (O000000o2.O00000Oo && O000000o2.O00000o0) {
                            fuj.O000000o().O000000o(CommonApplication.getApplication(), O000000o3, new fsm<Void, fso>() {
                                /* class _m_j.gts.AnonymousClass2 */

                                public final void onFailure(fso fso) {
                                }

                                public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                    gts.this.O00000o0 = false;
                                }
                            });
                        }
                    }
                }
            }
            if (this.O000O00o == null) {
                this.O000O00o = new HashMap();
            }
            List list = this.O000O00o.get(4);
            if (list == null) {
                list = new ArrayList();
                this.O000O00o.put(4, list);
            }
            list.remove(str);
            if (TextUtils.equals(str, this.O0000oO)) {
                this.O0000oO = null;
                this.O0000oO0 = -1;
                O00000o0((String) null, (String) null);
            }
            O0000o0("tag_info_edited_action");
            O0000oOo();
        }
    }

    public final Map<String, Set<String>> O000000o(int i) {
        HashSet hashSet;
        HashMap hashMap = new HashMap();
        Map map = this.O00oOooO.get(Integer.valueOf(i));
        if (map != null && map.size() > 0) {
            for (String str : map.keySet()) {
                try {
                    Set set = (Set) map.get(str);
                    if (set == null) {
                        hashSet = new HashSet();
                    } else {
                        hashSet = new HashSet(set);
                    }
                    hashMap.put(str, hashSet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return (i != 4 || !ggb.O00000Oo().O00000oO()) ? hashMap : ggb.O00000Oo().O0000OoO();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cb, code lost:
        return r0;
     */
    public final synchronized Map<String, List<String>> O0000Oo(String str) {
        HashSet<String> hashSet;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        ArrayList<Pair> arrayList = new ArrayList<>();
        Map map = f16910O000000o ? this.O00oOooO.get(8) : this.O00oOooO.get(0);
        if (map != null && map.size() > 0) {
            try {
                HashMap hashMap = new HashMap(map);
                Home O00000o2 = ggb.O00000Oo().O00000o(str);
                List<String> O000000o2 = ggb.O00000Oo().O000000o(str, new boolean[0]);
                if (!(O00000o2 == null || O000000o2 == null)) {
                    if (!O000000o2.isEmpty()) {
                        for (Map.Entry entry : hashMap.entrySet()) {
                            String str2 = (String) entry.getKey();
                            Set set = (Set) entry.getValue();
                            if (set == null) {
                                hashSet = new HashSet<>();
                            } else {
                                hashSet = new HashSet<>(set);
                            }
                            LinkedList linkedList = new LinkedList();
                            for (String str3 : hashSet) {
                                Device O000000o3 = fno.O000000o().O000000o(str3);
                                if (O000000o3 != null && O000000o2.contains(str3)) {
                                    if (!fno.O000000o().O00000o(O000000o3) || O000000o3.isHomeShared()) {
                                        linkedList.add(str3);
                                    }
                                }
                            }
                            if (!linkedList.isEmpty()) {
                                arrayList.add(Pair.create(str2, linkedList));
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Collections.sort(arrayList, new Comparator<Pair<String, List<String>>>() {
            /* class _m_j.fqv.AnonymousClass3 */

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                int i;
                int i2;
                DeviceTagInterface.Category O00000o = fqv.this.O00000o((String) ((Pair) obj).first);
                DeviceTagInterface.Category O00000o2 = fqv.this.O00000o((String) ((Pair) obj2).first);
                if (O00000o == null || O00000o2 == null) {
                    return 0;
                }
                if (fqv.f16910O000000o) {
                    DeviceTagInterface.Category category = fqv.this.O0000o0o.get(O00000o.parentId);
                    DeviceTagInterface.Category category2 = fqv.this.O0000o0o.get(O00000o2.parentId);
                    if (category == null || category2 == null) {
                        return 0;
                    }
                    if (!TextUtils.equals(category.id, category2.id)) {
                        i = category.rank;
                        i2 = category2.rank;
                        return i - i2;
                    }
                }
                i = O00000o.rank;
                i2 = O00000o2.rank;
                return i - i2;
            }
        });
        for (Pair pair : arrayList) {
            linkedHashMap.put(pair.first, pair.second);
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0096, code lost:
        return r0;
     */
    public final synchronized Set<String> O000000o(String str, String str2) {
        HashSet hashSet;
        HashSet<String> hashSet2;
        hashSet = new HashSet();
        try {
            if (TextUtils.isEmpty(str2)) {
                return new HashSet();
            }
            Map map = f16910O000000o ? this.O00oOooO.get(8) : this.O00oOooO.get(0);
            if (map != null && map.size() > 0) {
                Set set = (Set) map.get(str2);
                if (set == null) {
                    hashSet2 = new HashSet<>();
                } else {
                    hashSet2 = new HashSet<>(set);
                }
                List<String> O000000o2 = ggb.O00000Oo().O000000o(str, new boolean[0]);
                if (O000000o2 != null) {
                    if (!O000000o2.isEmpty()) {
                        for (String str3 : hashSet2) {
                            Device O000000o3 = fno.O000000o().O000000o(str3);
                            if (O000000o3 != null && O000000o2.contains(str3)) {
                                if (!fno.O000000o().O00000o(O000000o3) || O000000o3.isHomeShared()) {
                                    hashSet.add(str3);
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hashSet;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0035, code lost:
        return null;
     */
    public final synchronized Set<String> O0000O0o(String str) {
        Set set;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = this.O00oOooO.get(4);
        if (map != null && map.size() > 0 && (set = (Set) map.get(str)) != null && set.size() > 0) {
            return new HashSet(set);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002e, code lost:
        return r3;
     */
    private synchronized String O000000o(String str, String str2, int i) {
        if (this.O0000oo0.get(str) != null) {
            O00000o0(str, str2, i);
            return str;
        } else if (this.O0000oo.containsKey(str)) {
            String str3 = this.O0000oo.get(str);
            O00000o o00000o = this.O0000oo0.get(str3);
            if (o00000o != null && i <= o00000o.O00000oo) {
                o00000o.O00000o0 = str2;
                o00000o.O00000oo = i;
            }
        } else {
            return O00000Oo(str, str2, i);
        }
    }

    private synchronized String O00000Oo(String str, String str2, int i) {
        String O00000Oo2 = O00000Oo(str, 1);
        O00000o o00000o = this.O0000oo0.get(O00000Oo2);
        if (o00000o != null) {
            o00000o.O00000Oo = str;
            if (!TextUtils.isEmpty(str2)) {
                o00000o.O00000o0 = str2;
            }
            o00000o.O00000oo = i;
            this.O0000oo.put(str, O00000Oo2);
            return O00000Oo2;
        }
        String O000000o2 = O000000o(str, -1);
        if (O000000o2 != null) {
            return O000000o2;
        }
        String O000000o3 = O000000o(str, 2);
        if (O000000o3 != null) {
            return O000000o3;
        }
        String O000000o4 = O000000o(str, -2);
        if (O000000o4 != null) {
            return O000000o4;
        }
        O00000o0(str, str2, i);
        return str;
    }

    private String O000000o(String str, int i) {
        String O00000Oo2 = O00000Oo(str, i);
        O00000o o00000o = this.O0000oo0.get(O00000Oo2);
        if (o00000o == null) {
            return null;
        }
        o00000o.O00000Oo = str;
        this.O0000oo.put(str, O00000Oo2);
        return o00000o.f16936O000000o;
    }

    private static String O00000Oo(String str, int i) {
        String substring = str.substring(0, str.length() - 2);
        Integer valueOf = Integer.valueOf(Integer.valueOf(str.substring(str.length() - 2), 16).intValue() + i);
        return substring + String.format("%2X", valueOf);
    }

    public final synchronized String O00000oo(String str) {
        String str2 = this.O0000oo.containsKey(str) ? this.O0000oo.get(str) : str;
        if (this.O0000oo0.containsKey(str2)) {
            O00000o o00000o = this.O0000oo0.get(str2);
            String str3 = o00000o.O00000o0;
            if (!gqb.O000000o(o00000o.O00000o)) {
                str = str3 + " (" + o00000o.O00000o + ")";
            } else if (!gqb.O000000o(o00000o.O00000Oo())) {
                str = str3 + " (" + o00000o.O00000Oo() + ")";
            } else {
                str = str3;
            }
        }
        return str;
    }

    private synchronized String O0000o0O(String str) {
        if (!this.O0000oo.containsKey(str)) {
            return str;
        }
        return this.O0000oo.get(str);
    }

    public final synchronized String O0000OoO(String str) {
        String str2 = this.O0000oo.containsKey(str) ? this.O0000oo.get(str) : str;
        if (this.O0000oo0.containsKey(str2)) {
            O00000o o00000o = this.O0000oo0.get(str2);
            String str3 = o00000o.O00000o0;
            if (!gqb.O000000o(o00000o.O00000Oo())) {
                str = str3 + " (" + o00000o.O00000Oo() + ")";
            } else {
                str = str3;
            }
        }
        return str;
    }

    public final synchronized String O00000Oo(String str) {
        O00000o o00000o = this.O0000oo0.get(this.O0000oo.containsKey(str) ? this.O0000oo.get(str) : str);
        if (o00000o != null) {
            str = o00000o.O00000o0;
        }
        return str;
    }

    private synchronized void O00000o0(String str, String str2, int i) {
        O00000o o00000o = this.O0000oo0.get(str);
        if (o00000o == null) {
            o00000o = new O00000o();
            o00000o.f16936O000000o = str;
            o00000o.O00000o0 = str2;
            o00000o.O00000oo = i;
            this.O0000oo0.put(str, o00000o);
        }
        if (i <= o00000o.O00000oo) {
            if (!this.O0000oo.containsKey(O00000Oo(str, -1))) {
                o00000o.O00000oo = i;
                o00000o.O00000o0 = str2;
            }
        }
    }

    private static boolean O0000o0o(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return Pattern.compile("[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}:[0-9a-fA-F]{2}").matcher(str).matches();
    }

    private synchronized void O0000oOo() {
        this.O00000oo = true;
        this.O0000o00.postDelayed(new Runnable() {
            /* class _m_j.fqv.AnonymousClass4 */

            public final void run() {
                if (fqv.this.O00000oo) {
                    fqv fqv = fqv.this;
                    JSONObject O0000o0 = fqv.O0000o0();
                    JSONObject O0000o0O = fqv.O0000o0O();
                    fqv.O0000O0o = System.currentTimeMillis();
                    goq.O000000o(new Runnable(O0000o0, O0000o0O) {
                        /* class _m_j.fqv.AnonymousClass6 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ JSONObject f16927O000000o;
                        final /* synthetic */ JSONObject O00000Oo;

                        {
                            this.f16927O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            try {
                                JSONObject O0000o0o = fqv.this.O0000o0o();
                                SharedPreferences.Editor edit = ServiceApplication.getAppContext().getSharedPreferences(fqv.O0000Ooo(), 0).edit();
                                edit.putString("custom_tag_version_info", O0000o0o.toString());
                                edit.putString("custom_tag_info", this.f16927O000000o.toString());
                                if (this.O00000Oo != null) {
                                    edit.putString("custom_tag_order_info", this.O00000Oo.toString());
                                }
                                edit.apply();
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    ServiceApplication.getGlobalWorkerHandler().post(new Runnable(O0000o0, O0000o0O) {
                        /* class _m_j.fqv.AnonymousClass5 */

                        /* renamed from: O000000o  reason: collision with root package name */
                        final /* synthetic */ JSONObject f16925O000000o;
                        final /* synthetic */ JSONObject O00000Oo;

                        {
                            this.f16925O000000o = r2;
                            this.O00000Oo = r3;
                        }

                        public final void run() {
                            try {
                                JSONArray jSONArray = new JSONArray();
                                fqv.O000000o(this.f16925O000000o, 1001, jSONArray);
                                fqv.O000000o(this.O00000Oo, 2001, jSONArray);
                                JSONObject jSONObject = new JSONObject();
                                JSONObject O0000o0o = fqv.this.O0000o0o();
                                jSONObject.put("component_id", 0);
                                jSONObject.put("key", "1000");
                                jSONObject.put("data", O0000o0o);
                                jSONArray.put(jSONObject);
                                fuj.O000000o().O000000o(ServiceApplication.getAppContext(), jSONArray, new fsm<JSONObject, fso>() {
                                    /* class _m_j.fqv.AnonymousClass5.AnonymousClass1 */

                                    public final void onFailure(fso fso) {
                                    }

                                    public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                    }
                                });
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    fqv.this.O00000oo = false;
                }
            }
        }, 1000);
    }

    public final void O00000Oo(List<Device> list) {
        String str = this.O0000oO;
        if (!gqb.O000000o(this.O0000oOO)) {
            str = this.O0000oOO;
        }
        this.O0000oOo = O000000o(str, list);
        try {
            ggb O00000Oo2 = ggb.O00000Oo();
            if (!O00000Oo2.O00000oO()) {
                return;
            }
            if (O00000Oo2.O0000O0o == -1) {
                O00000Oo2.O0000o0O = list;
            } else if (O00000Oo2.O0000O0o == 6) {
                O00000Oo2.O0000o0O = O00000Oo2.O0000O0o();
            } else if (O00000Oo2.O0000O0o == 7) {
                gge.O000000o();
                O00000Oo2.O0000o0O = gge.O00000oO();
            } else if (O00000Oo2.O0000O0o == 2) {
                ArrayList<Device> arrayList = new ArrayList<>();
                Map<String, Device> O0000O0o2 = fno.O000000o().O0000O0o();
                if (O0000O0o2 != null && !O0000O0o2.isEmpty()) {
                    arrayList.addAll(O0000O0o2.values());
                }
                ArrayList arrayList2 = new ArrayList();
                Map<String, Set<String>> O0000OOo2 = fnn.O000000o().O00000Oo().O0000OOo();
                if (O0000OOo2 != null) {
                    if (!O0000OOo2.isEmpty()) {
                        Set set = O0000OOo2.get(O00000Oo2.O00000oo);
                        if (set != null) {
                            if (!set.isEmpty()) {
                                for (Device device : arrayList) {
                                    if (set.contains(device.did)) {
                                        arrayList2.add(device);
                                    }
                                }
                            }
                        }
                    }
                }
                O00000Oo2.O0000o0O = arrayList2;
            } else if (O00000Oo2.O00000o != null) {
                O00000Oo2.O0000o0O = O00000Oo2.O00000Oo(O00000Oo2.O00000o);
            } else {
                O00000Oo2.O0000o0O = list;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final Map<String, Set<String>> O0000OOo() {
        return this.O00oOooO.get(2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:44:0x0089, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x008b, code lost:
        return r5;
     */
    private synchronized List<Device> O000000o(String str, List<Device> list) {
        if (this.O0000oO0 != -1 && !TextUtils.isEmpty(str) && !TextUtils.equals(str, ServiceApplication.getAppContext().getString(R.string.tag_all_devices)) && list != null) {
            if (list.size() > 0) {
                if (this.O0000oO0 == 6) {
                    return ggb.O00000Oo().O0000O0o();
                } else if (this.O0000oO0 == 7) {
                    gge.O000000o();
                    return gge.O00000oO();
                } else {
                    Map map = this.O00oOooO.get(Integer.valueOf(this.O0000oO0));
                    if (map == null) {
                        return null;
                    }
                    Set set = (Set) map.get(str);
                    if (set != null) {
                        if (!set.isEmpty()) {
                            ArrayList arrayList = new ArrayList();
                            for (Device next : list) {
                                if (set.contains(next.did)) {
                                    arrayList.add(next);
                                }
                            }
                            return arrayList;
                        }
                    }
                }
            }
        }
    }

    public final void O00000o() {
        O0000OoO();
    }

    public final Set<Integer> O0000O0o() {
        HashSet hashSet = new HashSet();
        hashSet.add(4);
        hashSet.add(0);
        hashSet.add(2);
        return hashSet;
    }

    private synchronized List<String> O0000oo0() {
        List list;
        if (this.O000O00o == null || (list = this.O000O00o.get(4)) == null || list.size() <= 0) {
            return null;
        }
        return new ArrayList(list);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent}
     arg types: [java.lang.String, int]
     candidates:
      ClspMth{android.content.Intent.putExtra(java.lang.String, int):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, int[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Bundle):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.CharSequence):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, long):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.io.Serializable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, double[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, android.os.Parcelable):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, float[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, byte[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, java.lang.String):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, short[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, char[]):android.content.Intent}
      ClspMth{android.content.Intent.putExtra(java.lang.String, boolean):android.content.Intent} */
    public final void O0000Oo0() {
        Intent intent = new Intent("device_tag_selected_action");
        intent.putExtra("param_device_tag_type", -1);
        intent.putExtra("tag_selected_param", true);
        intent.putExtra("device_tag_param", ServiceApplication.getAppContext().getString(R.string.tag_all_devices));
        ft.O000000o(ServiceApplication.getAppContext()).O000000o(intent);
    }

    public final synchronized List<String> O000000o(int i, String str) {
        if (i == 4) {
            if (ggb.O00000Oo().O00000oO()) {
                return ggb.O00000Oo().O0000oO0(str);
            }
        }
        Map<String, Set<String>> O000000o2 = O000000o(i);
        if (!TextUtils.isEmpty(str) && O000000o2 != null) {
            if (!O000000o2.isEmpty()) {
                ArrayList arrayList = new ArrayList();
                for (String next : O000000o2.keySet()) {
                    Set set = O000000o2.get(next);
                    if (set != null && !set.isEmpty() && set.contains(str)) {
                        arrayList.add(next);
                    }
                }
                return arrayList;
            }
        }
        return null;
    }

    public final List<String> O00000Oo() {
        ArrayList arrayList = new ArrayList();
        for (int string : O00000Oo) {
            arrayList.add(ServiceApplication.getAppContext().getString(string));
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0085, code lost:
        return r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x00ef, code lost:
        return r8;
     */
    public final synchronized String O00000Oo(String str, String str2) {
        String str3;
        List<Room> list;
        String str4;
        if (ggb.O00000Oo().O00000oO()) {
            ggb O00000Oo2 = ggb.O00000Oo();
            ArrayList arrayList = new ArrayList();
            if (TextUtils.isEmpty(str2)) {
                list = O00000Oo2.O00000o();
            } else {
                list = O00000Oo2.O000000o(str2);
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    String name = ((Room) list.get(i)).getName();
                    if (!TextUtils.isEmpty(name) && name.contains(str)) {
                        arrayList.add(name);
                    }
                }
            }
            if (!arrayList.isEmpty()) {
                int i2 = 1;
                while (true) {
                    str4 = str + (arrayList.size() + i2);
                    Iterator it = arrayList.iterator();
                    boolean z = false;
                    while (it.hasNext()) {
                        if (((String) it.next()).equals(str4)) {
                            z = true;
                        }
                    }
                    if (!z) {
                        break;
                    }
                    i2++;
                }
                str = str4;
            }
        } else {
            ArrayList arrayList2 = new ArrayList();
            if (O00000Oo(4, str)) {
                for (String next : O000000o(4).keySet()) {
                    if (next.contains(str)) {
                        arrayList2.add(next);
                    }
                }
            }
            if (!arrayList2.isEmpty()) {
                int i3 = 1;
                while (true) {
                    str3 = str + (arrayList2.size() + i3);
                    Iterator it2 = arrayList2.iterator();
                    boolean z2 = false;
                    while (it2.hasNext()) {
                        if (((String) it2.next()).equals(str3)) {
                            z2 = true;
                        }
                    }
                    if (!z2) {
                        break;
                    }
                    i3++;
                }
                str = str3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0090, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0092, code lost:
        return;
     */
    public final synchronized void O00000oO() {
        int indexOf;
        if (this.O000O0Oo != null) {
            if (!this.O000O0Oo.isEmpty()) {
                Set<String> keySet = this.O000O0Oo.keySet();
                Map map = this.O00oOooO.get(4);
                if (map != null && !map.isEmpty()) {
                    for (String next : keySet) {
                        String str = this.O000O0Oo.get(next);
                        Set set = (Set) map.get(str);
                        if (set != null && set.contains(next)) {
                            set.remove(next);
                            Iterator<gts.O000000o> it = gts.O000000o().O00000o.iterator();
                            while (it.hasNext()) {
                                gts.O000000o next2 = it.next();
                                if (TextUtils.equals(str, next2.f18272O000000o) && (indexOf = next2.O00000Oo.indexOf(next)) >= 0 && indexOf < next2.O00000Oo.size()) {
                                    next2.O00000Oo.remove(indexOf);
                                }
                            }
                        }
                    }
                    O0000o0("tag_info_edited_action");
                    O0000oOo();
                }
            }
        }
    }

    public final void O00000oo() {
        Map<String, String> map = this.O000O0Oo;
        if (map != null) {
            map.clear();
        }
    }

    public static List<String> O0000o() {
        return new ArrayList(Arrays.asList(ServiceApplication.getAppContext().getResources().getStringArray(R.array.recommend_room_name)));
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|7|8|(3:11|12|19)(1:18)) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0014 */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x001c A[SYNTHETIC, Splitter:B:11:0x001c] */
    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    public final void O0000o00(String str) {
        if (str != null && str.length() > 0) {
            JSONArray jSONArray = null;
            jSONArray = new JSONObject(str).getJSONArray("catgory_info");
            jSONArray = new JSONArray(str);
            if (jSONArray == null) {
                try {
                    O000000o(jSONArray);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:55:0x011c, code lost:
        return;
     */
    public final synchronized void O0000oO0() {
        PluginDeviceInfo O00000oO2;
        if (this.O0000o0) {
            Map<String, DeviceTagInterface.Category> map = this.O0000o0o;
            if (map != null) {
                if (!map.isEmpty()) {
                    Map<String, Device> O00000oO3 = fno.O000000o().O00000oO();
                    if (O00000oO3 != null) {
                        HashMap hashMap = new HashMap();
                        HashMap hashMap2 = new HashMap();
                        int i = 0;
                        do {
                            try {
                                for (Map.Entry<String, Device> value : O00000oO3.entrySet()) {
                                    Device device = (Device) value.getValue();
                                    if (device != null && ((!fno.O000000o().O00000o(device) || device.isHomeShared()) && (O00000oO2 = CoreApi.O000000o().O00000oO(device.model)) != null)) {
                                        DeviceTagInterface.Category category = this.O00oOoOo.get(String.valueOf(O00000oO2.O0000oo0));
                                        if (category == null) {
                                            gsy.O000000o(6, "DeviceTagManager", "cannot find the category for " + device.model);
                                        } else {
                                            DeviceTagInterface.Category category2 = this.O0000o0o.get(category.parentId);
                                            if (category2 == null) {
                                                gsy.O000000o(6, "DeviceTagManager", "cannot find the parent category for " + category.name + ", id=" + category.id + ",parentid=" + category.parentId);
                                            } else {
                                                Object obj = (Set) hashMap.get(category2.name);
                                                if (obj == null) {
                                                    obj = new HashSet();
                                                    hashMap.put(category2.name, obj);
                                                }
                                                obj.add(device.did);
                                                Object obj2 = (Set) hashMap2.get(category.name);
                                                if (obj2 == null) {
                                                    obj2 = new HashSet();
                                                    hashMap2.put(category.name, obj2);
                                                }
                                                obj2.add(device.did);
                                            }
                                        }
                                    }
                                }
                                this.O00oOooO.put(0, hashMap);
                                this.O00oOooO.put(8, hashMap2);
                                O0000o0("category_info_updated_action");
                                return;
                            } catch (Exception e) {
                                e.printStackTrace();
                                i++;
                                if (i >= 3) {
                                }
                            }
                        } while (i >= 3);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a1, code lost:
        return false;
     */
    public final synchronized boolean O000000o(JSONArray jSONArray) {
        if (jSONArray == null) {
            return false;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        int i = 0;
        boolean z = true;
        while (i < jSONArray.length()) {
            try {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                DeviceTagInterface.Category category = new DeviceTagInterface.Category();
                category.id = jSONObject.optString("id");
                category.rank = jSONObject.optInt("rank");
                category.name = jSONObject.optString("name");
                hashMap.put(category.id, category);
                JSONArray optJSONArray = jSONObject.optJSONArray("subcategory");
                if (optJSONArray == null) {
                    z = false;
                } else {
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        DeviceTagInterface.Category category2 = new DeviceTagInterface.Category();
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                        category2.id = optJSONObject.optString("id");
                        category2.rank = optJSONObject.optInt("rank");
                        category2.name = optJSONObject.optString("name");
                        category2.parentId = category.id;
                        hashMap2.put(category2.id, category2);
                    }
                }
                i++;
            } catch (Exception e) {
                e.printStackTrace();
                z = false;
            }
        }
        this.O0000o0o = hashMap;
        this.O00oOoOo = hashMap2;
        O0000oO0();
        if (this.O0000o0o.size() > 0 && this.O00oOoOo.size() > 0 && z) {
            return true;
        }
    }

    public final synchronized DeviceTagInterface.Category O00000o0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(str);
        if (O00000oO2 == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(O00000oO2.O0000oo0);
        DeviceTagInterface.Category category = this.O00oOoOo.get(sb.toString());
        if (category == null) {
            return null;
        }
        DeviceTagInterface.Category category2 = this.O0000o0o.get(category.parentId);
        if (category2 == null) {
            return null;
        }
        return f16910O000000o ? category : category2;
    }

    public final synchronized DeviceTagInterface.Category O0000OOo(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (f16910O000000o) {
            return this.O00oOoOo.get(str);
        }
        return this.O0000o0o.get(str);
    }

    public final synchronized DeviceTagInterface.Category O0000Oo0(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.O00oOoOo.get(str);
    }

    public final synchronized DeviceTagInterface.Category O00000o(String str) {
        DeviceTagInterface.Category category;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = f16910O000000o ? this.O00oOoOo : this.O0000o0o;
        if (map == null) {
            map = new HashMap();
        }
        int i = 0;
        do {
            try {
                for (Map.Entry entry : map.entrySet()) {
                    if (entry != null && (category = (DeviceTagInterface.Category) entry.getValue()) != null && TextUtils.equals(str, category.name)) {
                        return category;
                    }
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                i++;
                if (i >= 3) {
                    return null;
                }
            }
        } while (i >= 3);
        return null;
    }

    public final synchronized List<DeviceTagInterface.Category> O00000oO(String str) {
        DeviceTagInterface.Category category;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Map map = f16910O000000o ? this.O00oOoOo : this.O0000o0o;
        if (map == null) {
            map = new HashMap();
        }
        int i = 0;
        do {
            try {
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    if (!(entry == null || (category = (DeviceTagInterface.Category) entry.getValue()) == null || !TextUtils.equals(str, category.name))) {
                        arrayList.add(category);
                    }
                }
                if (arrayList.isEmpty()) {
                    return null;
                }
                return arrayList;
            } catch (Exception e) {
                e.printStackTrace();
                i++;
                if (i >= 3) {
                    return null;
                }
            }
        } while (i >= 3);
        return null;
    }
}
