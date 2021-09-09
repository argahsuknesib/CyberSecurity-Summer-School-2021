package _m_j;

import android.os.Build;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.Log;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fqg {

    /* renamed from: O000000o  reason: collision with root package name */
    public final Map<String, List<String>> f16896O000000o;
    private final Object O00000Oo;
    private final Map<String, Map<String, Set<String>>> O00000o;
    private final List<O000000o> O00000o0;
    private List<O00000o0> O00000oO;

    public static class O00000Oo {

        /* renamed from: O000000o  reason: collision with root package name */
        public static fqg f16899O000000o = new fqg((byte) 0);
    }

    public interface O00000o0 {
        void O000000o();
    }

    /* synthetic */ fqg(byte b) {
        this();
    }

    public final boolean O000000o() {
        return this.O00000o0.size() > 0 && this.f16896O000000o.size() > 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        return r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
        if (_m_j.fml.O000000o(r4, (java.lang.String) r6.getKey()) < 0) goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0075, code lost:
        return 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        r4 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00b7, code lost:
        return r1;
     */
    public final int O000000o(Device device, String str) {
        boolean z;
        synchronized (this.O00000Oo) {
            List list = this.f16896O000000o.get(device.model);
            int i = 2;
            if (list == null || list.size() <= 0 || !list.contains(str)) {
                int i2 = 1;
                try {
                    String optString = new JSONObject(device.extra).optString("fw_version");
                    Map map = this.O00000o.get(device.model);
                    if (map != null && !TextUtils.isEmpty(optString)) {
                        Iterator it = map.entrySet().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                z = false;
                                break;
                            }
                            Map.Entry entry = (Map.Entry) it.next();
                            if (((Set) entry.getValue()).contains(str)) {
                                break;
                            }
                        }
                        if (z) {
                            return 2;
                        }
                    }
                } catch (Exception e) {
                    Log.e("GatewaySupportManger", "isGatewaySupportDevice", e);
                }
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
                PluginDeviceInfo O00000oO3 = CoreApi.O000000o().O00000oO(str);
                boolean z2 = O00000oO2 != null && O00000oO2.O0000o(8);
                boolean z3 = O00000oO3 != null && O00000oO3.O00000o() == 14;
                if (z2 && z3) {
                    i2 = 0;
                }
            } else if (O00000Oo.f16899O000000o.O000000o(str, device)) {
                i = 0;
            }
        }
    }

    public final boolean O000000o(Device device) {
        boolean z;
        try {
            String optString = new JSONObject(device.extra).optString("fw_version");
            Map map = this.O00000o.get(device.model);
            if (map != null && !TextUtils.isEmpty(optString)) {
                Iterator it = map.entrySet().iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (fml.O000000o(optString, (String) ((Map.Entry) it.next()).getKey()) >= 0) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                PluginDeviceInfo O00000oO2 = CoreApi.O000000o().O00000oO(device.model);
                return !z || (O00000oO2 == null && O00000oO2.O0000o(8));
            }
        } catch (Exception e) {
            Log.e("GatewaySupportManger", "isGatewaySupportDevice", e);
        }
        z = false;
        PluginDeviceInfo O00000oO22 = CoreApi.O000000o().O00000oO(device.model);
        if (!z) {
        }
    }

    public final List<String> O00000Oo(Device device) {
        if (device == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        List list = this.f16896O000000o.get(device.model);
        if (list != null) {
            arrayList.addAll(list);
        }
        Map map = this.O00000o.get(device.model);
        if (map != null) {
            try {
                String optString = new JSONObject(device.extra).optString("fw_version");
                for (Map.Entry entry : map.entrySet()) {
                    if (fml.O000000o(optString, (String) entry.getKey()) >= 0) {
                        arrayList.addAll((Collection) entry.getValue());
                    }
                }
            } catch (Exception e) {
                Log.e("GatewaySupportManger", "getGatewaySupportModel", e);
            }
        }
        return arrayList;
    }

    private fqg() {
        this.O00000Oo = new Object();
        this.O00000o0 = new ArrayList();
        this.f16896O000000o = new HashMap();
        this.O00000o = new HashMap();
        this.O00000oO = new ArrayList();
        if (this.O00000o0.size() <= 0 || this.f16896O000000o.size() <= 0) {
            gsy.O00000Oo(LogType.NETWORK, "GatewaySupportManger", "init loadConfigFromServer");
            new AppConfigHelper(CommonApplication.getAppContext()).O000000o("android_gateway_for_device_dict", "1", "en", null, new AppConfigHelper.O000000o() {
                /* class _m_j.fqg.AnonymousClass1 */

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                }

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    fqg.this.O000000o(str);
                }
            });
        }
    }

    public final boolean O000000o(String str) {
        Map<String, List<String>> map;
        try {
            if (!AppConfigHelper.O000000o(str)) {
                return false;
            }
            JSONArray jSONArray = new JSONObject(str).getJSONArray("companyDevices");
            if (jSONArray != null && jSONArray.length() > 0) {
                ArrayList<O000000o> arrayList = new ArrayList<>();
                for (int i = 0; i < jSONArray.length(); i++) {
                    O000000o O000000o2 = O000000o((JSONObject) jSONArray.get(i));
                    if (O000000o2 != null) {
                        arrayList.add(O000000o2);
                    }
                }
                synchronized (this.O00000Oo) {
                    this.O00000o0.clear();
                    this.O00000o0.addAll(arrayList);
                    for (O000000o o000000o : arrayList) {
                        Map<String, List<String>> map2 = o000000o.O00000o0;
                        if (!(map2 == null || (map = o000000o.f16898O000000o) == null)) {
                            for (String next : map.keySet()) {
                                List list = map.get(next);
                                List<String> list2 = map2.get(next);
                                if (!(list2 == null || list == null)) {
                                    for (String put : list2) {
                                        this.f16896O000000o.put(put, list);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            for (int size = this.O00000oO.size() - 1; size >= 0; size--) {
                this.O00000oO.get(size).O000000o();
            }
            return true;
        } catch (Exception e) {
            Log.e("GatewaySupportManger", "parseConfigData", e);
            return false;
        }
    }

    private O000000o O000000o(JSONObject jSONObject) {
        try {
            String optString = jSONObject.optString("company");
            ArrayList arrayList = new ArrayList();
            HashMap hashMap = new HashMap();
            HashMap hashMap2 = new HashMap();
            JSONObject optJSONObject = jSONObject.optJSONObject("deviceGateway");
            if (optJSONObject != null) {
                Iterator<String> keys = optJSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    ArrayList arrayList2 = new ArrayList();
                    JSONArray jSONArray = optJSONObject.getJSONArray(next);
                    if (jSONArray != null && jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            String string = jSONArray.getString(i);
                            if (!TextUtils.isEmpty(string)) {
                                arrayList2.add(string);
                            }
                        }
                        hashMap2.put(next, arrayList2);
                    }
                }
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("miHomeSupport");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                    String string2 = optJSONArray.getString(i2);
                    if (!TextUtils.isEmpty(string2)) {
                        arrayList.add(string2);
                    }
                }
            }
            JSONObject optJSONObject2 = jSONObject.optJSONObject("group");
            if (optJSONObject2 != null) {
                Iterator<String> keys2 = optJSONObject2.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    ArrayList arrayList3 = new ArrayList();
                    JSONArray jSONArray2 = optJSONObject2.getJSONArray(next2);
                    if (jSONArray2 != null && jSONArray2.length() > 0) {
                        for (int i3 = 0; i3 < jSONArray2.length(); i3++) {
                            arrayList3.add(jSONArray2.getString(i3));
                        }
                    }
                    hashMap.put(next2, arrayList3);
                }
            }
            JSONObject optJSONObject3 = jSONObject.optJSONObject("ikeaVersion");
            if (optJSONObject3 != null) {
                Map arrayMap = Build.VERSION.SDK_INT >= 19 ? new ArrayMap() : new HashMap();
                Iterator<String> keys3 = optJSONObject3.keys();
                while (keys3.hasNext()) {
                    String next3 = keys3.next();
                    arrayMap.put(next3, optJSONObject3.optString(next3));
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("zigbee_3_0");
            if (optJSONArray2 != null) {
                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                    JSONObject optJSONObject4 = optJSONArray2.optJSONObject(i4);
                    String optString2 = optJSONObject4.optString("version", "");
                    JSONArray optJSONArray3 = optJSONObject4.optJSONArray("supportModel");
                    HashSet hashSet = new HashSet();
                    if (optJSONArray3 != null) {
                        for (int i5 = 0; i5 < optJSONArray3.length(); i5++) {
                            hashSet.add(optJSONArray3.optString(i5));
                        }
                    }
                    JSONArray optJSONArray4 = optJSONObject4.optJSONArray("gatewayModel");
                    if (optJSONArray4 != null && hashSet.size() > 0) {
                        for (int i6 = 0; i6 < optJSONArray4.length(); i6++) {
                            String optString3 = optJSONArray4.optString(i6);
                            Map map = this.O00000o.get(optString3);
                            if (map == null) {
                                Map<String, Map<String, Set<String>>> map2 = this.O00000o;
                                Map arrayMap2 = Build.VERSION.SDK_INT >= 19 ? new ArrayMap() : new HashMap();
                                map2.put(optString3, arrayMap2);
                                map = arrayMap2;
                            }
                            map.put(optString2, hashSet);
                        }
                    }
                }
            }
            return new O000000o(optString, hashMap2, arrayList, hashMap);
        } catch (JSONException e) {
            Log.e("GatewaySupportManger", "fatal", e);
            return null;
        }
    }

    private boolean O000000o(String str, Device device) {
        String str2;
        if (device == null) {
            return false;
        }
        for (O000000o next : this.O00000o0) {
            if (!(next == null || next.O00000Oo == null || !next.O00000Oo.contains(str))) {
                try {
                    return next.O00000o == null || (str2 = next.O00000o.get(device.model)) == null || fml.O000000o(new JSONObject(device.extra).optString("fw_version"), str2) >= 0;
                } catch (Exception unused) {
                    gsy.O000000o(6, "GatewaySupportManger", "nextActivity check version parse fail:" + device.extra);
                }
            }
        }
        return true;
    }

    public final boolean O000000o(O00000o0 o00000o0) {
        return this.O00000oO.add(o00000o0);
    }

    public final boolean O00000Oo(O00000o0 o00000o0) {
        return this.O00000oO.remove(o00000o0);
    }

    public static final class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final Map<String, List<String>> f16898O000000o;
        public final List<String> O00000Oo;
        public final Map<String, String> O00000o = null;
        public final Map<String, List<String>> O00000o0;
        private final String O00000oO;

        public O000000o(String str, Map<String, List<String>> map, List<String> list, Map<String, List<String>> map2) {
            this.O00000oO = str;
            this.f16898O000000o = map;
            this.O00000Oo = list;
            this.O00000o0 = map2;
        }
    }
}
