package _m_j;

import com.xiaomi.smarthome.core.entity.net.KeyValuePair;
import com.xiaomi.smarthome.core.entity.net.NetRequest;
import com.xiaomi.smarthome.frame.ApiErrorWrapper;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import java.util.Collections;
import org.json.JSONException;
import org.json.JSONObject;

public class hji {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile hji f18985O000000o;

    private hji() {
    }

    public static hji O000000o() {
        if (f18985O000000o == null) {
            synchronized (hji.class) {
                if (f18985O000000o == null) {
                    f18985O000000o = new hji();
                }
            }
        }
        return f18985O000000o;
    }

    public static class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        public final int f18989O000000o;
        public final String O00000Oo;
        public final boolean O00000o0;

        O000000o(int i, String str, boolean z) {
            this.f18989O000000o = i;
            this.O00000Oo = str;
            this.O00000o0 = z;
        }
    }

    public final Observable<O000000o> O000000o(String str) {
        final JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("identityToken", str);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return fsv.O000000o(new NetRequest.O000000o().O000000o("GET").O00000Oo("/v2/user/remove_privacy_data").O000000o(Collections.singletonList(new KeyValuePair("data", jSONObject.toString()))).O000000o(), new fss<O000000o>() {
            /* class _m_j.hji.AnonymousClass2 */

            public final /* synthetic */ Object parse(JSONObject jSONObject) throws JSONException {
                gsy.O00000Oo("DeleteAllPrivacyApi", "deleteAllData param: " + jSONObject + " ; response: " + jSONObject);
                return new O000000o(jSONObject.getInt("code"), jSONObject.getString("message"), jSONObject.getBoolean("result"));
            }
        }).onErrorReturn(new Function<Throwable, O000000o>() {
            /* class _m_j.hji.AnonymousClass1 */

            public final /* synthetic */ Object apply(Object obj) throws Exception {
                Throwable th = (Throwable) obj;
                gsy.O00000Oo("DeleteAllPrivacyApi", "deleteAllData error: ".concat(String.valueOf(th)));
                if (th instanceof ApiErrorWrapper) {
                    ApiErrorWrapper apiErrorWrapper = (ApiErrorWrapper) th;
                    if (apiErrorWrapper.code == -4005001) {
                        gsy.O00000Oo("DeleteAllPrivacyApi", "deleteAllData return: map to auth: " + apiErrorWrapper.detail);
                        return new O000000o(apiErrorWrapper.code, apiErrorWrapper.detail, false);
                    }
                }
                throw new Exception(th);
            }
        });
    }
}
