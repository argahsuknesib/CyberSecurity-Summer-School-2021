package _m_j;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mmkv.MMKV;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.config.model.MultimediaConfig;
import com.xiaomi.smarthome.core.entity.plugin.PluginPackageInfo;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class fbz {
    private static volatile fbz O00000o0;

    /* renamed from: O000000o  reason: collision with root package name */
    HashMap<String, fcf> f16059O000000o = new HashMap<>();
    public int O00000Oo = 5;

    private fbz() {
    }

    public static fbz O000000o() {
        if (O00000o0 == null) {
            synchronized (fbz.class) {
                if (O00000o0 == null) {
                    O00000o0 = new fbz();
                }
            }
        }
        return O00000o0;
    }

    public static String O000000o(JSONObject jSONObject) throws UnsupportedEncodingException {
        return hsk.O000000o(CommonApplication.getAppContext()) + "/app/service/getappconfig?data=" + URLEncoder.encode(jSONObject.toString(), "UTF-8");
    }

    /* access modifiers changed from: package-private */
    public final void O00000Oo() {
        SharedPreferences sharedPreferences;
        try {
            MMKV O000000o2 = MMKV.O000000o("sp_pre_connect_config");
            gsy.O00000Oo("MultimediaConfigManager", "loadPreConnectConfigMMKV");
            sharedPreferences = O000000o2;
        } catch (Exception e) {
            sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("sp_pre_connect_config", 4);
            gsy.O00000Oo("MultimediaConfigManager", "loadPreConnectConfigSP");
            gsy.O00000o0(LogType.CAMERA, "MultimediaConfigManager", e.toString());
        }
        String string = sharedPreferences.getString("content", "");
        gsy.O00000Oo("MultimediaConfigManager", "loadPreConnectConfigSP content=".concat(String.valueOf(string)));
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                gsy.O00000Oo("MultimediaConfigManager", "loadPreConnectConfigSP contentArray=" + jSONArray.length());
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject optJSONObject = jSONArray.optJSONObject(i);
                        fcf fcf = new fcf();
                        fcf.f16079O000000o = optJSONObject.optString("model");
                        fcf.O00000Oo = optJSONObject.optJSONArray("list");
                        fcf.O00000o0 = optJSONObject.optBoolean("isRN");
                        if (TextUtils.isEmpty(fcf.f16079O000000o)) {
                            fcf.O00000o = optJSONObject.optInt("maxCount", 0);
                            this.O00000Oo = fcf.O00000o;
                        } else {
                            this.f16059O000000o.put(fcf.f16079O000000o, fcf);
                        }
                    } catch (Exception e2) {
                        LogType logType = LogType.CAMERA;
                        gsy.O00000o0(logType, "MultimediaConfigManager", "loadPreConnectConfigSP for:" + e2.toString());
                    }
                }
            } catch (JSONException e3) {
                LogType logType2 = LogType.CAMERA;
                gsy.O00000o0(logType2, "MultimediaConfigManager", "loadPreConnectConfigSP:" + e3.toString());
            }
        }
        gsy.O00000Oo("MultimediaConfigManager", "loadPreConnectConfigSP result=" + this.f16059O000000o.size());
    }

    public final boolean O000000o(String str, String str2, boolean z) {
        try {
            if (this.f16059O000000o.isEmpty()) {
                gsy.O00000Oo("MultimediaConfigManager", "isRn:" + z + " needPreConnect preConnectConfigList=" + this.f16059O000000o.size());
                O00000Oo();
            }
            fcf fcf = this.f16059O000000o.get(str);
            if (fcf != null) {
                PluginPackageInfo O0000Oo = CoreApi.O000000o().O0000Oo(str);
                boolean z2 = O0000Oo != null && "rn".equalsIgnoreCase(O0000Oo.O0000O0o());
                gsy.O00000Oo("MultimediaConfigManager", "model:" + str + " isRnCamera=" + z2);
                if (z == z2 && fcf.O00000Oo != null && fcf.O00000Oo.length() > 0) {
                    if (TextUtils.isEmpty(str2)) {
                        return true;
                    }
                    for (int i = 0; i < fcf.O00000Oo.length(); i++) {
                        if (Integer.parseInt(String.valueOf(str2.charAt(str2.length() - 1))) % 10 == fcf.O00000Oo.optInt(i)) {
                            return true;
                        }
                    }
                }
            }
        } catch (Exception e) {
            LogType logType = LogType.CAMERA;
            gsy.O00000o0(logType, "MultimediaConfigManager", "isRn:" + z + " toPreConnect:" + e.toString());
        }
        return false;
    }

    public static void O000000o(String str) {
        SharedPreferences sharedPreferences = CommonApplication.getAppContext().getSharedPreferences("sp_multimedia_config", 0);
        sharedPreferences.edit().putString("content", str).commit();
        sharedPreferences.edit().putLong("timestamp", System.currentTimeMillis()).commit();
        gsy.O00000o0(LogType.CAMERA, "MultimediaConfigManager", "saveToSP:".concat(String.valueOf(str)));
    }

    private static List<MultimediaConfig> O00000o0() {
        ArrayList arrayList = new ArrayList();
        String string = CommonApplication.getAppContext().getSharedPreferences("sp_multimedia_config", 0).getString("content", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                JSONArray jSONArray = new JSONArray(string);
                for (int i = 0; i < string.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        MultimediaConfig multimediaConfig = new MultimediaConfig();
                        multimediaConfig.f6717O000000o = optJSONObject.optString("model");
                        multimediaConfig.O00000Oo = optJSONObject.optString("fw_version");
                        multimediaConfig.O00000o0 = optJSONObject.optBoolean("spec");
                        LogType logType = LogType.CAMERA;
                        gsy.O00000o0(logType, "MultimediaConfigManager", "loadFromSP:" + multimediaConfig.toString());
                        arrayList.add(multimediaConfig);
                    }
                }
            } catch (Exception e) {
                LogType logType2 = LogType.CAMERA;
                gsy.O00000o0(logType2, "MultimediaConfigManager", "loadFromSP:" + e.getLocalizedMessage());
            }
        }
        return arrayList;
    }

    public static boolean O00000Oo(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            for (MultimediaConfig next : O00000o0()) {
                if (str.equals(next.f6717O000000o) && next.O00000o0) {
                    z = true;
                }
            }
        }
        gsy.O00000Oo("MultimediaConfigManager", "isSupportSPEC:" + str + " result:" + z);
        return z;
    }
}
