package _m_j;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.Error;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetError;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.core.entity.net.NetResult;
import com.xiaomi.smarthome.device.Device;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjn {
    private static volatile fjn O00000o;
    private static Object O00000oO = new Object();

    /* renamed from: O000000o  reason: collision with root package name */
    public ArrayList<Device> f16481O000000o = new ArrayList<>();
    SharedPreferences O00000Oo;
    long O00000o0;
    private fja O00000oo;
    private Handler O0000O0o = new Handler(Looper.getMainLooper());

    private fjn(Context context) {
        this.O00000Oo = PreferenceManager.getDefaultSharedPreferences(context);
        this.O00000o0 = this.O00000Oo.getLong("mitv_local_devices_report_time", 0);
    }

    public static fjn O000000o() {
        if (O00000o == null) {
            synchronized (O00000oO) {
                if (O00000o == null) {
                    O00000o = new fjn(CommonApplication.getAppContext());
                }
            }
        }
        return O00000o;
    }

    public final synchronized void O000000o(fja fja) {
        this.O00000oo = fja;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        return;
     */
    public final synchronized void O000000o(Device device) {
        if (device != null) {
            if (!TextUtils.isEmpty(device.getDid())) {
                Iterator<Device> it = this.f16481O000000o.iterator();
                while (it.hasNext()) {
                    if (device.getDid().equals(it.next().getDid())) {
                        return;
                    }
                }
                this.f16481O000000o.add(device);
                if (this.O00000oo != null) {
                    this.O00000oo.O000000o(device);
                }
                this.O0000O0o.postDelayed(new Runnable() {
                    /* class _m_j.fjn.AnonymousClass1 */

                    public final void run() {
                        fjn fjn = fjn.this;
                        ArrayList<Device> arrayList = fjn.f16481O000000o;
                        if (arrayList != null && !arrayList.isEmpty() && System.currentTimeMillis() - fjn.O00000o0 >= 86400000) {
                            if (oOOO00o0.O000000o(CommonApplication.getAppContext(), "android.permission.READ_PHONE_STATE") != 0) {
                                new SecurityException("need READ_PHONE_STATE").printStackTrace();
                                return;
                            }
                            String O000000o2 = gsa.O000000o(CommonApplication.getAppContext());
                            if (!TextUtils.isEmpty(O000000o2)) {
                                String O000000o3 = gpp.O000000o(O000000o2);
                                if (!TextUtils.isDigitsOnly(O000000o3)) {
                                    JSONObject jSONObject = new JSONObject();
                                    try {
                                        jSONObject.put("api_type", "scan");
                                        JSONObject jSONObject2 = new JSONObject();
                                        jSONObject2.put("imei", O000000o3);
                                        JSONArray jSONArray = new JSONArray();
                                        for (Device did : arrayList) {
                                            jSONArray.put(did.getDid());
                                        }
                                        jSONObject2.put("scan_result", jSONArray);
                                        jSONObject.put("data", jSONObject2);
                                        fjn.O00000o0 = System.currentTimeMillis();
                                        fjn.O00000Oo.edit().putLong("mitv_local_devices_report_time", fjn.O00000o0).apply();
                                        ArrayList arrayList2 = new ArrayList();
                                        JSONObject jSONObject3 = new JSONObject();
                                        try {
                                            jSONObject3.put("app_id", 10004);
                                            jSONObject3.put("params", jSONObject);
                                        } catch (JSONException unused) {
                                        }
                                        arrayList2.add(new KeyValuePair("data", jSONObject3.toString()));
                                        fdt.O000000o().O000000o(new NetRequest.O000000o().O000000o("POST").O00000Oo("/third/api").O000000o(arrayList2).O000000o(), new fdh<NetResult, NetError>() {
                                            /* class _m_j.fjn.AnonymousClass2 */

                                            public final /* bridge */ /* synthetic */ void onFailure(Error error) {
                                            }

                                            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                                            }
                                        });
                                    } catch (JSONException unused2) {
                                    }
                                }
                            }
                        }
                    }
                }, 60000);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x004e, code lost:
        return;
     */
    public final synchronized void O00000Oo(Device device) {
        if (device != null) {
            if (!TextUtils.isEmpty(device.getDid())) {
                for (int i = 0; i < this.f16481O000000o.size(); i++) {
                    if (device.getDid().equals(this.f16481O000000o.get(i).getDid())) {
                        if (this.O00000oo != null) {
                            this.O00000oo.O00000Oo(this.f16481O000000o.get(i));
                        }
                        this.f16481O000000o.remove(i);
                        return;
                    }
                }
            }
        }
    }

    public final synchronized void O00000Oo() {
        this.f16481O000000o.clear();
    }

    public final synchronized List<Device> O00000o0() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f16481O000000o);
        return arrayList;
    }
}
