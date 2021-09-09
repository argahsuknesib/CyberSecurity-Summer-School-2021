package _m_j;

import android.app.Dialog;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.device.api.DeviceApi;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class fnr {

    /* renamed from: O000000o  reason: collision with root package name */
    Dialog f16712O000000o = null;

    public static boolean O000000o(String str) {
        try {
            JSONArray optJSONArray = new JSONObject(str).optJSONArray("result");
            ArrayList arrayList = null;
            if (optJSONArray != null && optJSONArray.length() > 0) {
                ArrayList arrayList2 = new ArrayList();
                for (int i = 0; i < optJSONArray.length(); i++) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    fni fni = new fni();
                    fni.O00000o = optJSONObject.optString("virtualModel");
                    fni.O00000Oo = optJSONObject.optString("company");
                    fni.f16695O000000o = optJSONObject.optString("name");
                    fni.O00000o0 = null;
                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("models");
                    if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                        fni.O00000o0 = new String[optJSONArray2.length()];
                        for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                            fni.O00000o0[i2] = optJSONArray2.optString(i2);
                        }
                    }
                    arrayList2.add(fni);
                }
                arrayList = arrayList2;
            }
            if (arrayList != null) {
                if (arrayList.size() != 0) {
                    fnn.O000000o().f16706O000000o.updateUsableGroupInfo(arrayList);
                    return true;
                }
            }
            return false;
        } catch (JSONException unused) {
            return true;
        }
    }

    public static void O000000o() {
        ServiceApplication.getGlobalWorkerHandler().post(new Runnable() {
            /* class _m_j.fnr.AnonymousClass1 */

            /* JADX WARNING: Code restructure failed: missing block: B:12:0x0067, code lost:
                if (r1.equals(_m_j.fnr.O00000Oo()) == false) goto L_0x006b;
             */
            /* JADX WARNING: Removed duplicated region for block: B:9:0x004c  */
            public final void run() {
                boolean z;
                String O00000o0 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_info_key", (String) null);
                boolean z2 = true;
                if (!TextUtils.isEmpty(O00000o0)) {
                    long O000000o2 = gpy.O000000o(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_last_check_key");
                    if (O000000o2 > 0) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        if (simpleDateFormat.format(new Date(O000000o2)).equals(simpleDateFormat.format(new Date(System.currentTimeMillis())))) {
                            z = false;
                            if (!z) {
                                String O00000o02 = gpy.O00000o0(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_last_locale_key", "");
                                if (!TextUtils.isEmpty(O00000o02)) {
                                }
                            }
                            z2 = z;
                        }
                    }
                    z = true;
                    if (!z) {
                    }
                    z2 = z;
                }
                if (z2) {
                    DeviceApi.getInstance().getModelGroupInfoJson(ServiceApplication.getAppContext(), new fsm<String, fso>() {
                        /* class _m_j.fnr.AnonymousClass1.AnonymousClass1 */

                        public final void onFailure(fso fso) {
                        }

                        public final /* synthetic */ void onSuccess(Object obj) {
                            String str = (String) obj;
                            if (fnr.O000000o(str)) {
                                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_last_check_key", System.currentTimeMillis());
                                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_info_key", str);
                                gpy.O000000o(ServiceApplication.getAppContext(), "prefs_virtual_device", "virtual_device_last_locale_key", fnr.O00000Oo());
                            }
                        }
                    });
                } else {
                    fnr.O000000o(O00000o0);
                }
            }
        });
    }

    public static String O00000Oo() {
        Locale O00oOooo = CoreApi.O000000o().O00oOooo();
        if (O00oOooo == null) {
            O00oOooo = Locale.getDefault();
        }
        if (O00oOooo == null) {
            return "";
        }
        return O00oOooo.getCountry() + "-" + O00oOooo.getLanguage();
    }
}
