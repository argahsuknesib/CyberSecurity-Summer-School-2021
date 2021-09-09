package _m_j;

import android.os.Bundle;
import android.os.RemoteException;
import android.util.Base64;
import android.util.Log;
import com.xiaomi.miot.DeviceDescInfo;
import com.xiaomi.miot.DeviceInfo;
import com.xiaomi.miot.service.ICallback;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.plugin.PluginDeviceInfo;
import com.xiaomi.smarthome.device.Device;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.frame.plugin.runtime.util.DeviceCategory;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hsc implements Runnable {

    /* renamed from: O000000o  reason: collision with root package name */
    public final ICallback f579O000000o;
    public final boolean O00000Oo;
    private String O00000o;
    private final String O00000o0;

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public hsc(ICallback iCallback, boolean z, String str, String str2) {
        this.f579O000000o = iCallback;
        this.O00000o0 = str;
        this.O00000o = str2;
        this.O00000Oo = z;
    }

    public final void run() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new KeyValuePair("data", this.O00000o));
        CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo(this.O00000o0).O000000o(arrayList).O000000o(), $$Lambda$hsc$kJOpk5mawlezxyH27zWmxk4fe4.INSTANCE, Crypto.RC4, new fsm<JSONObject, fso>() {
            /* class _m_j.hsc.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                if (jSONObject == null) {
                    jSONObject = new JSONObject();
                }
                try {
                    ArrayList arrayList = new ArrayList();
                    hsc.O000000o(hsc.this.O00000Oo, arrayList, jSONObject.optJSONArray("description_list"), 2);
                    hsc.O000000o(hsc.this.O00000Oo, arrayList, jSONObject.optJSONArray("consumable_items"), 1);
                    Bundle bundle = new Bundle();
                    gsy.O000000o(4, "MiuiService", "CallApitTask oScs+" + Base64.encodeToString(String.valueOf(jSONObject).getBytes(), 2));
                    bundle.putString("current_uid", CoreApi.O000000o().O0000o0());
                    bundle.putParcelableArrayList("result", arrayList);
                    if (hsc.this.f579O000000o != null) {
                        hsc.this.f579O000000o.onSuccess(bundle);
                    }
                } catch (Throwable th) {
                    gsy.O000000o(6, "MiuiService", Log.getStackTraceString(th));
                }
            }

            public final void onFailure(fso fso) {
                gsy.O000000o(4, "MiuiService", "CallApitTask onfail");
                Bundle bundle = new Bundle();
                bundle.setClassLoader(DeviceInfo.class.getClassLoader());
                if (fso != null) {
                    bundle.putInt("error_code", fso.f17063O000000o);
                    bundle.putString("error_msg", fso.O00000Oo + fso.O00000o0);
                }
                try {
                    if (hsc.this.f579O000000o != null) {
                        hsc.this.f579O000000o.onFailure(bundle);
                    }
                } catch (RemoteException e) {
                    gsy.O000000o(6, "MiuiService", Log.getStackTraceString(e));
                }
            }
        });
    }

    public static void O000000o(boolean z, ArrayList<DeviceDescInfo> arrayList, JSONArray jSONArray, int i) {
        String str;
        String str2;
        ArrayList<DeviceDescInfo> arrayList2 = arrayList;
        JSONArray jSONArray2 = jSONArray;
        int i2 = i;
        if (jSONArray2 != null) {
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject optJSONObject = jSONArray2.optJSONObject(i3);
                if (optJSONObject != null) {
                    Device O000000o2 = fno.O000000o().O000000o(optJSONObject.optString("did"));
                    if (O000000o2 == null || (z && DeviceCategory.fromPid(O000000o2.pid) != DeviceCategory.Bluetooth && !O000000o2.isOnline)) {
                        gsy.O000000o(6, "MiuiService", "setItem de+" + Base64.encodeToString(String.valueOf(O000000o2).getBytes(), 2) + " size:" + fno.O000000o().O00000oO().size());
                    } else {
                        PluginDeviceInfo O00000oO = CoreApi.O000000o().O00000oO(O000000o2.model);
                        String O0000o0 = O00000oO != null ? O00000oO.O0000o0() : "";
                        JSONArray optJSONArray = optJSONObject.optJSONArray("details");
                        if (!(optJSONArray == null || optJSONArray.length() == 0)) {
                            if (i2 == 2) {
                                for (int i4 = 0; i4 < optJSONArray.length(); i4++) {
                                    JSONObject optJSONObject2 = optJSONArray.optJSONObject(i4);
                                    DeviceDescInfo deviceDescInfo = new DeviceDescInfo();
                                    deviceDescInfo.f6031O000000o = i2;
                                    deviceDescInfo.O00000oo = optJSONObject2.optString("description");
                                    deviceDescInfo.O0000O0o = optJSONObject2.optString("prop");
                                    deviceDescInfo.O00000o0 = O000000o2.name;
                                    deviceDescInfo.O00000oO = O000000o2.model;
                                    deviceDescInfo.O00000o = O0000o0;
                                    deviceDescInfo.O00000Oo = O000000o2.did;
                                    deviceDescInfo.O0000OOo = optJSONObject2.optLong("timestamp");
                                    arrayList2.add(deviceDescInfo);
                                }
                            } else {
                                if (optJSONArray.length() == 1) {
                                    str = optJSONArray.optJSONObject(0).optString("description");
                                    str2 = optJSONArray.optJSONObject(0).optString("prop");
                                } else {
                                    StringBuilder sb = new StringBuilder();
                                    StringBuilder sb2 = new StringBuilder();
                                    for (int i5 = 0; i5 < optJSONArray.length(); i5++) {
                                        JSONObject optJSONObject3 = optJSONArray.optJSONObject(i5);
                                        sb.append(optJSONObject3.optString("description"));
                                        sb.append(",");
                                        sb2.append(optJSONObject3.optString("prop"));
                                        sb2.append(",");
                                    }
                                    str = sb.deleteCharAt(sb.length() - 1).toString();
                                    str2 = sb2.deleteCharAt(sb2.length() - 1).toString();
                                }
                                DeviceDescInfo deviceDescInfo2 = new DeviceDescInfo();
                                deviceDescInfo2.f6031O000000o = i2;
                                deviceDescInfo2.O00000oo = str;
                                deviceDescInfo2.O0000O0o = str2;
                                deviceDescInfo2.O00000o0 = O000000o2.name;
                                deviceDescInfo2.O00000oO = O000000o2.model;
                                deviceDescInfo2.O00000o = O0000o0;
                                deviceDescInfo2.O00000Oo = O000000o2.did;
                                arrayList2.add(deviceDescInfo2);
                            }
                        }
                    }
                }
            }
        }
    }
}
