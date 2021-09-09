package _m_j;

import com.xiaomi.smarthome.application.ServiceApplication;
import com.xiaomi.smarthome.library.log.LogType;
import org.json.JSONObject;

public class gwk {

    /* renamed from: O000000o  reason: collision with root package name */
    private static volatile gwk f18409O000000o;

    public static gwk O000000o() {
        if (f18409O000000o == null) {
            synchronized (gwk.class) {
                if (f18409O000000o == null) {
                    f18409O000000o = new gwk();
                }
            }
        }
        return f18409O000000o;
    }

    public final void O000000o(boolean z) {
        gns.O000000o(z);
        fuj.O000000o();
        fuj.O000000o(ServiceApplication.getAppContext(), "miot_quickfeedback_access", String.valueOf(gns.O00000Oo()), new fsm<JSONObject, fso>() {
            /* class _m_j.gwk.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "zhudong2_" + gns.f18056O000000o, "miot_quickfeedback_access_success：".concat(String.valueOf((JSONObject) obj)));
            }

            public final void onFailure(fso fso) {
                LogType logType = LogType.GENERAL;
                gsy.O00000o0(logType, "zhudong2_" + gns.f18056O000000o, "miot_quickfeedback_access_error:".concat(String.valueOf(fso)));
            }
        });
    }
}
