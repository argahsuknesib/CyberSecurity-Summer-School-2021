package _m_j;

import android.text.TextUtils;
import com.xiaomi.miio.MiioLocalAPI;
import com.xiaomi.smarthome.frame.ErrorCode;
import org.json.JSONException;
import org.json.JSONObject;

public final class fjh {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile fjh f16472O000000o;
    private static Object O00000Oo = new Object();

    private fjh() {
    }

    public static fjh O000000o() {
        if (f16472O000000o == null) {
            synchronized (O00000Oo) {
                if (f16472O000000o == null) {
                    f16472O000000o = new fjh();
                }
            }
        }
        return f16472O000000o;
    }

    public final void O000000o(String str, String str2, String str3, String str4, final fjo<String> fjo) {
        if (TextUtils.isEmpty(str)) {
            gsy.O000000o(6, "RPC", "device ip is empty");
            try {
                fjo.O000000o(-9999, "ip is empty");
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            MiioLocalAPI.O000000o(str, str4, Long.valueOf(str2).longValue(), str3, new dxe() {
                /* class _m_j.fjh.AnonymousClass1 */

                public final void onResponse(String str) {
                    fjo fjo = fjo;
                    if (fjo != null) {
                        try {
                            fjo.O000000o(str);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            });
        }
    }

    public static void O000000o(String str, fjo<JSONObject> fjo) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("code");
            if (AnonymousClass3.f16476O000000o[ErrorCode.valueof(optInt).ordinal()] != 1) {
                fjo.O000000o(optInt);
                return;
            }
            JSONObject optJSONObject = jSONObject.optJSONObject("result");
            if (optJSONObject == null) {
                optJSONObject = jSONObject;
            }
            fjo.O000000o(optJSONObject);
        } catch (JSONException unused) {
            fjo.O000000o(-31);
        }
    }

    /* renamed from: _m_j.fjh$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: O000000o  reason: collision with root package name */
        static final /* synthetic */ int[] f16476O000000o = new int[ErrorCode.values().length];

        static {
            try {
                f16476O000000o[ErrorCode.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }
}
