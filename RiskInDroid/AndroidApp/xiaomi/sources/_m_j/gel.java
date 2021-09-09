package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import org.json.JSONObject;

public final class gel extends gdy {
    public final boolean onReceiveMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    public final boolean onReceiveNotifiedMessage(String str, String str2) {
        O000000o(str2);
        return true;
    }

    private static void O000000o(String str) {
        try {
            O000000o.O000000o(new JSONObject(str));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static class O000000o {
        public static void O000000o(JSONObject jSONObject) {
            jSONObject.optLong("home_id");
            jSONObject.optLong("home_owner");
            jSONObject.optString("request");
            final long optLong = jSONObject.optLong("share_to");
            jSONObject.optInt("status");
            jSONObject.optString("type");
            if (gfr.O0000OOo) {
                gsy.O000000o(3, "HomeMemberPushProcessor", jSONObject.toString());
            }
            CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o0() {
                /* class _m_j.gel.O000000o.AnonymousClass1 */

                public final void onCoreReady() {
                    CoreApi.O000000o().O000000o(ServiceApplication.getAppContext(), new CoreApi.O0000o00() {
                        /* class _m_j.gel.O000000o.AnonymousClass1.AnonymousClass1 */

                        public final void onAccountReady(boolean z, String str) {
                            if (ServiceApplication.getStateNotifier().O000000o() == 4) {
                                if (!TextUtils.equals(str, String.valueOf(optLong))) {
                                    fbt fbt = new fbt(ServiceApplication.getAppContext(), "/message/MessageCenterListActivity");
                                    fbt.O000000o("message_type", 8);
                                    fbt.O000000o("message_title", ServiceApplication.getAppContext().getString(R.string.home_share));
                                    fbt.O00000Oo(268435456);
                                    fbs.O000000o(fbt);
                                    return;
                                }
                                fbt fbt2 = new fbt(ServiceApplication.getAppContext(), "MultiHomeManagerActivity");
                                fbt2.O000000o("from", 6);
                                fbt2.O00000Oo(268435456);
                                fbs.O000000o(fbt2);
                            }
                        }
                    });
                }
            });
        }
    }
}
