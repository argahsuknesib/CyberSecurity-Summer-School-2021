package _m_j;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.frame.core.CoreApi;
import com.xiaomi.smarthome.framework.push.PushType;
import org.json.JSONObject;

public final class hss extends fab {

    /* renamed from: O000000o  reason: collision with root package name */
    public static hss f605O000000o;
    private gdy O00000Oo = new gdy() {
        /* class _m_j.hss.AnonymousClass1 */

        public final boolean onReceiveMessage(String str, String str2) {
            try {
                hss.O000000o(new JSONObject(str2).optString("action"));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }

        public final boolean onReceiveNotifiedMessage(String str, String str2) {
            try {
                hss.O000000o(new JSONObject(str2).optString("action"));
                return true;
            } catch (Exception e) {
                e.printStackTrace();
                return true;
            }
        }
    };

    public final void O00000Oo() {
        super.O00000Oo();
        ezo.O000000o().registerPushListener(PushType.SHARE, this.O00000Oo);
    }

    public static void O000000o(String str) {
        if (TextUtils.equals("share_request", str) || TextUtils.equals("share_to_family_request", str) || TextUtils.equals("share_response", str)) {
            Bundle bundle = new Bundle();
            bundle.putInt("message_type", 1);
            bundle.putString("message_title", ServiceApplication.getAppContext().getString(R.string.miio_setting_share));
            fvj.O000000o("/message/MessageCenterListActivity", bundle, true, 0);
        } else if ((TextUtils.equals("share_message", str) || TextUtils.equals("share_to_family_message", str)) && ServiceApplication.getApplication() != null && ServiceApplication.getApplication().isAppForeground()) {
            gva.O000000o().checkNewMessage();
            guz O000000o2 = gva.O000000o();
            Context appContext = ServiceApplication.getAppContext();
            O000000o2.checkNewMessageForProfile(gpv.O00000Oo(appContext, "setting_main_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), System.currentTimeMillis()), 2);
            guz O000000o3 = gva.O000000o();
            Context appContext2 = ServiceApplication.getAppContext();
            O000000o3.checkNewMessageForProfile(gpv.O00000Oo(appContext2, "message_center_new_msg_timestamp" + CoreApi.O000000o().O0000o0(), System.currentTimeMillis()), 1);
        }
    }
}
