package _m_j;

import _m_j.fuf;
import android.util.Base64;
import com.xiaomi.smarthome.application.CommonApplication;
import com.xiaomi.smarthome.core.entity.net.Crypto;
import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.security.KeyPair;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.crypto.Cipher;
import org.json.JSONException;
import org.json.JSONObject;

public final class fmx {
    private static fmx O00000o;

    /* renamed from: O000000o  reason: collision with root package name */
    public LinkedList<fuf.O00000o0> f16668O000000o = new LinkedList<>();
    public KeyPair O00000Oo = null;
    public AtomicBoolean O00000o0 = new AtomicBoolean(false);

    /* access modifiers changed from: private */
    public static /* synthetic */ JSONObject O000000o(JSONObject jSONObject) throws JSONException {
        return jSONObject;
    }

    public static fmx O000000o() {
        if (O00000o == null) {
            O00000o = new fmx();
        }
        return O00000o;
    }

    private fmx() {
    }

    public static fsn O000000o(String str, String str2, String str3, fsm<JSONObject, fso> fsm) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_pub", str2);
            jSONObject.put("bssid", str3);
            jSONObject.put("router_id", str);
            arrayList.add(new KeyValuePair("data", jSONObject.toString()));
            return CoreApi.O000000o().O000000o(CommonApplication.getAppContext(), new NetRequest.O000000o().O000000o("POST").O00000Oo("/v2/router/apply_local_pwd").O000000o(arrayList).O000000o(), $$Lambda$fmx$B6dvHQp9ri_pLEIRnaYYG3ECLNc.INSTANCE, Crypto.RC4, fsm);
        } catch (Exception unused) {
            return null;
        }
    }

    public static String O000000o(KeyPair keyPair, String str) {
        try {
            Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            instance.init(2, keyPair.getPrivate());
            return new String(instance.doFinal(Base64.decode(str, 2)));
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
