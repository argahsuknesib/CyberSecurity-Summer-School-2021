package _m_j;

import _m_j.fua;
import android.text.TextUtils;
import com.sankuai.waimai.router.annotation.RouterService;
import org.json.JSONObject;

@RouterService
public class fub extends gdy {
    private static final fub INSTANCE = new fub();

    public boolean onReceiveNotifiedMessage(String str, String str2) {
        return false;
    }

    @cug
    public static fub provideInstance() {
        return INSTANCE;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:20|21|22|23) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:22:0x007e */
    public boolean onReceiveMessage(String str, String str2) {
        gsy.O000000o(3, "RemoteAsyncApiPush", "RemoteAsyncApiPushListener onReceiveMessage:messageId=" + str + ",data=" + str2);
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(str2);
            long optLong = jSONObject.optLong("sid");
            if (optLong < 0) {
                return false;
            }
            fua.O000000o remove = fua.O000000o().O00000Oo.remove(Long.valueOf(optLong));
            if (remove != null) {
                if (remove.O00000o != null) {
                    fua.O000000o().O000000o(optLong);
                    ftt ftt = remove.O00000o.get();
                    if (ftt != null) {
                        JSONObject optJSONObject = jSONObject.optJSONObject("result");
                        if (optJSONObject != null) {
                            ftt.O000000o(optJSONObject);
                        } else {
                            String optString = jSONObject.optString("result");
                            if (!TextUtils.isEmpty(optString)) {
                                ftt.O000000o(new JSONObject(optString));
                                fua.O000000o().O00000Oo(optLong);
                            }
                        }
                    }
                }
            }
            return true;
        } catch (Exception unused) {
        }
    }
}
