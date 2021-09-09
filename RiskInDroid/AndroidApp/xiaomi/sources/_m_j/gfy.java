package _m_j;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class gfy {

    /* renamed from: O000000o  reason: collision with root package name */
    public static List<String> f17668O000000o = new ArrayList();

    public static void O000000o(final List<String> list, final fsm fsm) {
        fru.O000000o().O00000Oo(list, new fsm<JSONObject, fso>() {
            /* class _m_j.gfy.AnonymousClass1 */

            public final void onFailure(fso fso) {
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onFailure(fso);
                }
            }

            public final /* synthetic */ void onSuccess(Object obj) {
                gfy.f17668O000000o.removeAll(list);
                fsm fsm = fsm;
                if (fsm != null) {
                    fsm.onSuccess(null);
                }
            }
        });
    }
}
