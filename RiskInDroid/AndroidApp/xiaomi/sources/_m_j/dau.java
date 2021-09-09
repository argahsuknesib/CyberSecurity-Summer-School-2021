package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.sdu.didi.openapi.DIOpenSDK;
import com.sdu.didi.openapi.utils.Utils;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

public final class dau {

    /* renamed from: O000000o  reason: collision with root package name */
    private static dau f14422O000000o;

    private dau() {
    }

    public static synchronized dau O000000o() {
        dau dau;
        synchronized (dau.class) {
            if (f14422O000000o == null) {
                f14422O000000o = new dau();
            }
            dau = f14422O000000o;
        }
        return dau;
    }

    private synchronized String O00000o0(Context context) {
        String O000000o2;
        O000000o2 = dbe.O000000o(context, "sdk_id", "");
        if (TextUtils.isEmpty(O000000o2)) {
            O000000o2 = DIOpenSDK.getInstance().getSDKId(DIOpenSDK.getAppId(context));
            dbe.O00000Oo(context, "sdk_id", O000000o2);
        }
        return O000000o2;
    }

    public final synchronized void O00000Oo(Context context) {
        dbe.O00000Oo(context, "openid_json", "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00e7, code lost:
        return r1;
     */
    public final synchronized dax O000000o(Context context) {
        HashMap hashMap = new HashMap();
        dax dax = new dax();
        String O000000o2 = dbe.O000000o(context, "openid_json", "");
        if (!TextUtils.isEmpty(O000000o2)) {
            dax.O000000o(O000000o2);
        }
        if (dax.O000000o()) {
            return dax;
        }
        hashMap.put("appid", DIOpenSDK.getAppId(context));
        hashMap.put("ucode", O000000o().O00000o0(context));
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("imei", Utils.O000000o(context));
            jSONObject.put("mac", Utils.O00000Oo(context));
            jSONObject.put("ucode", O000000o().O00000o0(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String jSONObject2 = jSONObject.toString();
        hashMap.put("data", jSONObject2);
        String timestamp = Utils.getTimestamp();
        hashMap.put("timestamp", timestamp);
        String randomString = Utils.getRandomString(10);
        hashMap.put("noncestr", randomString);
        hashMap.put("version", Utils.getCurrentVersion());
        DIOpenSDK instance = DIOpenSDK.getInstance();
        hashMap.put("sign", instance.getSDKSign(DIOpenSDK.getAppId(context) + DIOpenSDK.getSecrectStr(context) + O000000o().O00000o0(context) + jSONObject2 + timestamp + randomString));
        String O000000o3 = daz.O000000o().O000000o("https://api.xiaojukeji.com/v1/permit/pGetOpenId", hashMap);
        if (!TextUtils.isEmpty(O000000o3)) {
            dax.O000000o(O000000o3);
            if (dax.O000000o()) {
                dbe.O00000Oo(context, "openid_json", O000000o3);
                return dax;
            }
            DIOpenSDK.O000000o(context, dax.O00000o0);
        }
    }
}
