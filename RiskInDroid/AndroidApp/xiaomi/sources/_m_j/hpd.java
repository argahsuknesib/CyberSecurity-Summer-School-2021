package _m_j;

import android.os.Build;
import android.text.TextUtils;
import com.xiaomi.smarthome.AppConfigHelper;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.HashSet;
import java.util.Set;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class hpd {

    /* renamed from: O000000o  reason: collision with root package name */
    public static volatile boolean f462O000000o = false;
    public static volatile boolean O00000Oo = false;
    private static volatile int O00000o = 0;
    private static volatile int O00000o0 = 1;
    private static Set<String> O00000oO = new HashSet();
    private static Set<String> O00000oo = new HashSet();

    public static boolean O000000o() {
        if (!f462O000000o) {
            O00000Oo();
        }
        if (O00000o > gfr.O00000oO) {
            return false;
        }
        if (O00000o0 == 1) {
            return true;
        }
        if (O00000o0 == 2) {
            if (O00000oO.contains(O00000o0())) {
                return true;
            }
            return false;
        } else if (O00000o0 != 3 || O00000oo.contains(O00000o0())) {
            return false;
        } else {
            return true;
        }
    }

    public static void O00000Oo() {
        if (!O00000Oo) {
            O00000Oo = true;
            new AppConfigHelper(ServiceApplication.getAppContext()).O000000o("miui_geofence_config", "1", "zh_CN", null, new AppConfigHelper.O000000o() {
                /* class _m_j.hpd.AnonymousClass1 */

                /* renamed from: O000000o */
                public final void onSuccess(String str, Response response) {
                    try {
                        hpd.O000000o(str);
                        hpd.f462O000000o = true;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    hpd.O00000Oo = false;
                }

                public final void onFailure(gsf gsf, Exception exc, Response response) {
                    String str;
                    hpd.f462O000000o = false;
                    LogType logType = LogType.GENERAL;
                    StringBuilder sb = new StringBuilder("updateConfig onFailure ");
                    if (gsf == null) {
                        str = null;
                    } else {
                        str = gsf.f18205O000000o + "," + gsf.O00000Oo;
                    }
                    sb.append(str);
                    gsy.O00000Oo(logType, "MIUIGeoFenceConfigHelper", sb.toString());
                    hpd.O00000Oo = false;
                }
            });
        }
    }

    public static boolean O000000o(String str) throws JSONException {
        int i;
        if (TextUtils.isEmpty(str)) {
            LogType logType = LogType.GENERAL;
            gsy.O00000Oo(logType, "AppConfig geofence_config", "isFromCache:false" + ", content==null");
            str = "{\"strategy\":1,\"phone_list\":[],\"start_version\":62987}";
        }
        JSONObject jSONObject = new JSONObject(str);
        LogType logType2 = LogType.GENERAL;
        gsy.O00000Oo(logType2, "AppConfig geofence_config", "isFromCache:false" + ",parse content" + jSONObject);
        int optInt = jSONObject.optInt("strategy", 1);
        int optInt2 = jSONObject.optInt("start_version", 0);
        JSONArray optJSONArray = jSONObject.optJSONArray("phone_list");
        HashSet hashSet = new HashSet();
        int i2 = 0;
        while (true) {
            if (optJSONArray == null) {
                i = 0;
            } else {
                i = optJSONArray.length();
            }
            if (i2 >= i) {
                break;
            }
            String optString = optJSONArray.optString(i2);
            if (!TextUtils.isEmpty(optString)) {
                hashSet.add(optString);
            }
            i2++;
        }
        if (optInt == 2) {
            O00000oO = hashSet;
        } else if (optInt == 3) {
            O00000oo = hashSet;
        }
        O00000o = optInt2;
        O00000o0 = optInt;
        return true;
    }

    private static String O00000o0() {
        LogType logType = LogType.GENERAL;
        gsy.O00000Oo(logType, "MIUIGeoFenceConfigHelper", "getPhoneModel:MODEL=" + Build.MODEL + ",BRAND=" + Build.BRAND + ",BOARD=" + Build.BOARD + ",DEVICE=" + Build.DEVICE + ",DISPLAY=" + Build.DISPLAY + ",HARDWARE=" + Build.HARDWARE + ",PRODUCT=" + Build.PRODUCT + ",MANUFACTURER=" + Build.MANUFACTURER);
        return Build.DEVICE;
    }
}
