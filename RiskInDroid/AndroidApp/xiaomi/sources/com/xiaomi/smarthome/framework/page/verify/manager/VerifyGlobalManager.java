package com.xiaomi.smarthome.framework.page.verify.manager;

import _m_j.fsm;
import _m_j.fso;
import _m_j.fwc;
import _m_j.fwd;
import _m_j.fwg;
import _m_j.fwj;
import android.content.Context;
import com.xiaomi.smarthome.R;
import com.xiaomi.smarthome.frame.core.CoreApi;
import java.util.List;
import org.json.JSONObject;

public class VerifyGlobalManager extends VerifyManager {
    private static VerifyGlobalManager O00000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj
     arg types: [android.content.Context, int]
     candidates:
      _m_j.fwj.O000000o(java.lang.String, javax.crypto.Cipher):java.lang.String
      _m_j.fwj.O000000o(java.lang.String, _m_j.fwe):void
      _m_j.fwj.O000000o(java.lang.String, boolean):void
      _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj */
    public VerifyGlobalManager(Context context) {
        super(context);
        if (O00000o0(this.f8025O000000o)) {
            this.O00000Oo = fwj.O000000o(this.f8025O000000o, true);
        }
    }

    public static VerifyGlobalManager O000000o(Context context) {
        if (O00000o == null) {
            synchronized (VerifyGlobalManager.class) {
                if (O00000o == null) {
                    O00000o = new VerifyGlobalManager(context);
                }
            }
        }
        return O00000o;
    }

    public final void O000000o(Context context, final String str, String str2, final fwg<Boolean> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(context, str, str2, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass1 */

            public final /* synthetic */ void onSuccess(Object obj) {
                VerifyManager.O00000o0.put(CoreApi.O000000o().O0000o0(), new fwc(str));
                fwg.onSuccess((Boolean) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }

    public final void O000000o(Context context, String str, final fwg<Boolean> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(context, str, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass2 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                fwg.onSuccess((Boolean) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }

    public final void O000000o(Context context, final fwg<JSONObject> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(context, new fsm<JSONObject, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass3 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                fwg.onSuccess((JSONObject) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }

    public final void O000000o(Context context, List<String> list, final fwg<List<String>> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(context, list, new fsm<List<String>, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass5 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                fwg.onSuccess((List) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }

    public final void O000000o(Context context, List<String> list, int i, final fwg<List<String>> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O000000o(context, list, i, new fsm<List<String>, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass6 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                fwg.onSuccess((List) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }

    public final void O00000Oo(Context context, final fwg<Boolean> fwg) {
        if (!O00000Oo(context)) {
            fwg.onFailure(new fso(-1, context.getString(R.string.device_more_security_network_error)));
        }
        fwd.O000000o().O00000Oo(context, new fsm<Boolean, fso>() {
            /* class com.xiaomi.smarthome.framework.page.verify.manager.VerifyGlobalManager.AnonymousClass8 */

            public final /* bridge */ /* synthetic */ void onSuccess(Object obj) {
                fwg.onSuccess((Boolean) obj);
            }

            public final void onFailure(fso fso) {
                fwg.onFailure(fso);
            }
        });
    }
}
