package _m_j;

import _m_j.ccy;
import _m_j.cdd;
import android.text.TextUtils;
import java.util.HashMap;
import org.json.JSONObject;

public final class cdk implements ccy.O000000o {

    /* renamed from: O000000o  reason: collision with root package name */
    public static String f13667O000000o = (cct.f13639O000000o + "micra/state/server");

    public final void O000000o() {
        try {
            cdd.O000000o(ccx.O000000o(), ccs.O000000o() ? "http://agent.com/micra/state/server" : f13667O000000o, new HashMap(), new cdd.O00000Oo() {
                /* class _m_j.cdk.AnonymousClass1 */

                public final void O000000o(String str) {
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            try {
                                String string = new JSONObject(str).getString("server_time");
                                cdc.O000000o("Session getServerTime time ".concat(String.valueOf(string)), (Throwable) null);
                                if (!TextUtils.isEmpty(string)) {
                                    cde.O00000Oo(ccx.O000000o(), "server_delay", Long.valueOf(string).longValue() - System.currentTimeMillis());
                                }
                            } catch (Exception unused) {
                            }
                        }
                    } catch (Exception e) {
                        cdc.O000000o("Session getServerTime Exception " + e.toString(), (Throwable) null);
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception unused) {
        }
    }
}
