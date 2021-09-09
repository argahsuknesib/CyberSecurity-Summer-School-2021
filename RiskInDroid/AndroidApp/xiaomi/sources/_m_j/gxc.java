package _m_j;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import com.xiaomi.smarthome.family.api.MessageApi;
import com.xiaomi.smarthome.framework.page.CommonActivity;
import com.xiaomi.smarthome.miio.message.p0.P0MessageAlertActivity;
import com.xiaomi.smarthome.miio.message.p0.model.P0MessageList;

public class gxc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static Uri f18445O000000o = fcm.f16084O000000o;
    private static final String O00000Oo = "gxc";
    private static String O00000o = "key_mijia_account";
    private static String O00000o0 = "content://com.miui.warningcenter.provider";
    private static String O00000oO = "key_mijia_server";
    private static String O00000oo = "key_mijia_login_status";

    public static void O000000o(final CommonActivity commonActivity) {
        if (commonActivity != null && commonActivity.isValid()) {
            MessageApi.instance.getP0MessageAlert(new fsm<P0MessageList, fso>() {
                /* class _m_j.gxc.AnonymousClass1 */

                public final void onFailure(fso fso) {
                }

                public final /* synthetic */ void onSuccess(Object obj) {
                    P0MessageList p0MessageList = (P0MessageList) obj;
                    if (p0MessageList != null && p0MessageList.f9729O000000o != null && !p0MessageList.f9729O000000o.isEmpty() && commonActivity.isValid()) {
                        P0MessageAlertActivity.startActivity(commonActivity, p0MessageList);
                    }
                }
            });
        }
    }

    public static void O000000o(Context context, boolean z, String str, String str2) {
        if (grr.O00000oO()) {
            try {
                Uri parse = Uri.parse(O00000o0);
                Bundle bundle = new Bundle();
                bundle.putString(O00000o, str);
                bundle.putString(O00000oO, str2);
                bundle.putInt(O00000oo, z ? 0 : 1);
                Bundle call = context.getContentResolver().call(parse, "setMijiaAccount", (String) null, bundle);
                if (call != null) {
                    String str3 = O00000Oo;
                    gsy.O00000Oo(str3, "return status: " + call.getInt("status_return"));
                    return;
                }
                gsy.O00000Oo(O00000Oo, "bundle == null");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
