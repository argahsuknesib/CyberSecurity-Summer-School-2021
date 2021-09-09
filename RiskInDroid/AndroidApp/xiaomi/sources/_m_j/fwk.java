package _m_j;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.smarthome.framework.page.verify.manager.VerifyManager;

public class fwk extends VerifyManager {
    private static volatile fwk O00000o;

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj
     arg types: [android.content.Context, int]
     candidates:
      _m_j.fwj.O000000o(java.lang.String, javax.crypto.Cipher):java.lang.String
      _m_j.fwj.O000000o(java.lang.String, _m_j.fwe):void
      _m_j.fwj.O000000o(java.lang.String, boolean):void
      _m_j.fwj.O000000o(android.content.Context, boolean):_m_j.fwj */
    private fwk(Context context) {
        super(context);
        if (O00000o0(this.f8025O000000o)) {
            this.O00000Oo = fwj.O000000o(this.f8025O000000o, false);
        }
    }

    public static fwk O000000o(Context context) {
        if (O00000o == null) {
            synchronized (fwk.class) {
                if (O00000o == null) {
                    O00000o = new fwk(context);
                }
            }
        }
        return O00000o;
    }

    public final void O000000o(String str, String str2, final String str3, final String str4, final fwh fwh) {
        if (!O00000Oo(this.f8025O000000o)) {
            fwh.O00000o0();
        } else if (!TextUtils.isDigitsOnly(str4) || str4.length() != O000000o(str, str2)) {
            fwh.O000000o("pin format invalid");
        } else {
            fwa.O000000o().O000000o(this.f8025O000000o, str3, str4, new fsm<Boolean, fso>() {
                /* class _m_j.fwk.AnonymousClass4 */

                public final /* synthetic */ void onSuccess(Object obj) {
                    if (((Boolean) obj).booleanValue()) {
                        VerifyManager.O00000o0.put(str3, new fwc(str4));
                        fwh.O000000o();
                        return;
                    }
                    fwh.O00000Oo();
                }

                public final void onFailure(fso fso) {
                    fwh.O000000o(fso.O00000Oo);
                }
            });
        }
    }
}
