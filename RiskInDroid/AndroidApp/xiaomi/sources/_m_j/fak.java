package _m_j;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.authlib.IAuthCallBack;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.library.log.LogType;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class fak {
    public static String O0000OOo = "1.1.4";
    public static String O0000Oo = "-1";
    public static int O0000Oo0 = -1;
    private static fak O0000OoO;

    /* renamed from: O000000o  reason: collision with root package name */
    public String f16002O000000o;
    public faj O00000Oo;
    public String O00000o;
    public String O00000o0;
    public IAuthCallBack O00000oO;
    public Bundle O00000oo;
    public int O0000O0o = -1;

    private fak() {
    }

    public static fak O000000o() {
        if (O0000OoO == null) {
            O0000OoO = new fak();
        }
        return O0000OoO;
    }

    public final void O000000o(final fsm fsm, boolean z) {
        O00000Oo(new fsm() {
            /* class _m_j.fak.AnonymousClass1 */

            public final void onSuccess(Object obj) {
                fak fak = fak.this;
                fak.O00000Oo = (faj) obj;
                if (fak.O00000Oo != null) {
                    LogType logType = LogType.GENERAL;
                    gsy.O000000o(logType, "AuthManager", "updateAuthDefaultInfo" + fak.this.O00000Oo.toString());
                }
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(fak.this.O00000Oo);
                }
            }

            public final void onFailure(fso fso) {
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "AuthManager", "updateAuthDefaultInfo onFailure" + fso.f17063O000000o + fso.O00000Oo);
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }
        }, z);
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
    private fsn O00000Oo(fsm fsm, boolean z) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("application_id", this.f16002O000000o);
            if (z) {
                jSONObject.put("package_name", this.O00000o0);
                jSONObject.put("package_sign", this.O00000o);
                jSONObject.put("check_sign", true);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/auth/getdefaultauth").O000000o(arrayList).O000000o(), new fss<faj>() {
            /* class _m_j.fak.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                faj O000000o2 = faj.O000000o(jSONObject);
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "AuthManager", "auth parse:" + O000000o2.toString());
                return O000000o2;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(String str, fsm fsm) {
        LogType logType = LogType.GENERAL;
        gsy.O000000o(logType, "AuthManager", "scope:--" + str.toString());
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject.put("application_id", this.f16002O000000o);
            jSONObject.put("scope", str);
            jSONObject.put("sign", O00000oo());
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("package_name", this.O00000o0);
            jSONObject.put("package_sign", this.O00000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/auth/auth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(String str, String str2, String str3, String str4, String str5, fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        long currentTimeMillis = System.currentTimeMillis();
        try {
            jSONObject.put("response_type", str);
            jSONObject.put("client_id", this.f16002O000000o);
            jSONObject.put("device_id", str2);
            jSONObject.put("redirect_uri", str4);
            jSONObject.put("scope", str3);
            jSONObject.put("state", str5);
            jSONObject.put("sign", O00000oo());
            jSONObject.put("timestamp", currentTimeMillis / 1000);
            jSONObject.put("package_name", this.O00000o0);
            jSONObject.put("package_sign", this.O00000o);
            jSONObject.put("valid", 352800);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/oauth/authorize").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass4 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(String str, String str2, fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("application_id", this.f16002O000000o);
            jSONObject.put("redirect_uri", str2);
            jSONObject.put("state", str);
            jSONObject.put("sign", O00000oo());
            jSONObject.put("timestamp", currentTimeMillis);
            jSONObject.put("response_type", "token");
            jSONObject.put("scope", 5);
            jSONObject.put("package_name", this.O00000o0);
            jSONObject.put("package_sign", this.O00000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/auth/requesttoken").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("application_id", this.f16002O000000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/auth/revokeauth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass7 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "AuthManager", "deleteAuth---" + jSONObject.toString());
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O000000o(List<String> list, fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        StringBuilder sb = new StringBuilder();
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                if (i > 0) {
                    sb.append(",");
                }
                sb.append(list.get(i));
            }
        }
        try {
            if (sb.length() > 0) {
                jSONObject.put("device_ids", sb.toString());
            }
            jSONObject.put("client_id", this.f16002O000000o);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/oauth/revoke_auth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass8 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                LogType logType = LogType.GENERAL;
                gsy.O000000o(logType, "AuthManager", "deleteAuth---" + jSONObject.toString());
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    public final fsn O00000Oo(fsm fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            long currentTimeMillis = System.currentTimeMillis();
            jSONObject.put("client_id", this.f16002O000000o);
            jSONObject.put("sign", O00000oo());
            jSONObject.put("package_name", this.O00000o0);
            jSONObject.put("package_sign", this.O00000o);
            jSONObject.put("timestamp", currentTimeMillis);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        arrayList.add(new KeyValuePair("data", jSONObject.toString()));
        return CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/oauth/get_auth").O000000o(arrayList).O000000o(), new fss<JSONObject>() {
            /* class _m_j.fak.AnonymousClass9 */

            public final /* bridge */ /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                return jSONObject;
            }
        }, Crypto.RC4, fsm);
    }

    private String O00000oo() {
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.O00000o0);
            sb.append(this.f16002O000000o);
            sb.append(this.O00000o);
            StringBuilder sb2 = new StringBuilder();
            sb2.append(grv.O000000o(sb.toString()));
            if (CoreApi.O000000o().O0000Ooo()) {
                sb2.append(CoreApi.O000000o().O0000o0());
            }
            sb2.append(System.currentTimeMillis());
            LogType logType = LogType.GENERAL;
            gsy.O000000o(logType, "AuthManager", "sb--" + sb.toString() + "---sb2---" + sb2.toString() + "-----md5--" + grv.O000000o(sb2.toString()));
            return grv.O000000o(sb2.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public final boolean O00000Oo() {
        for (int i = 0; i < this.O00000Oo.O00000oo.size(); i++) {
            if (this.O00000Oo.O00000oo.get(i).f16001O000000o == 4) {
                return true;
            }
        }
        return false;
    }

    public final boolean O00000o0() {
        for (int i = 0; i < this.O00000Oo.O00000oo.size(); i++) {
            if (this.O00000Oo.O00000oo.get(i).f16001O000000o == 5) {
                return true;
            }
        }
        return false;
    }

    public final boolean O000000o(String str) {
        List<String> list = null;
        for (int i = 0; i < this.O00000Oo.O00000oo.size(); i++) {
            if (this.O00000Oo.O00000oo.get(i).f16001O000000o == 4) {
                list = this.O00000Oo.O00000oo.get(i).O00000Oo;
            }
        }
        if (!(list == null || list.size() == 0)) {
            for (int i2 = 0; i2 < list.size(); i2++) {
                if (str.equalsIgnoreCase(list.get(i2))) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean O00000Oo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            ServiceApplication.getAppContext().getPackageManager().getPackageInfo(str, 0);
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        } catch (Exception unused2) {
        }
        return true;
    }

    public static void O00000o() {
        if (O0000OoO != null) {
            O0000OoO = null;
        }
    }

    public static JSONObject O00000oO() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("sdk_version_code", O0000Oo0);
            jSONObject.put("sdk_version_name", O0000Oo);
            jSONObject.put("app_version_code", 8);
            jSONObject.put("app_version_name", O0000OOo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jSONObject;
    }
}
