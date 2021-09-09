package _m_j;

import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import in.cashify.otex.ExchangeManager;
import in.cashify.otex.ExchangeSetup;

public final class irc {

    /* renamed from: O000000o  reason: collision with root package name */
    public static final irc f1578O000000o = new irc();

    public static void O000000o(ee eeVar, ViewGroup viewGroup, String str, ExchangeSetup exchangeSetup) {
        try {
            ei O000000o2 = eeVar.O000000o();
            Fragment O000000o3 = eeVar.O000000o(str);
            if (O000000o3 == null) {
                O000000o3 = ExchangeManager.O000000o(exchangeSetup);
            } else if (O000000o3.isAdded()) {
                return;
            }
            O000000o2.O000000o(viewGroup != null ? viewGroup.getId() : 0, O000000o3, str);
            O000000o2.O00000o0();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void O000000o(ee eeVar, String str) {
        try {
            Fragment O000000o2 = eeVar.O000000o(str);
            if (O000000o2 != null) {
                ei O000000o3 = eeVar.O000000o();
                O000000o3.O000000o(O000000o2);
                O000000o3.O00000o0();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
