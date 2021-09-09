package _m_j;

import _m_j.gwj;
import android.content.Context;
import com.xiaomi.smarthome.framework.store.PreferenceCredentialStore;
import com.xiaomi.smarthome.smartconfig.SmartConfigRouterFactory;
import java.util.Iterator;

public final class gfq {

    /* renamed from: O000000o  reason: collision with root package name */
    private static gfq f17661O000000o;
    private Context O00000Oo = SmartConfigRouterFactory.getSmartConfigManager().getAppContext();
    private gwj O00000o;
    private get O00000o0 = new PreferenceCredentialStore(this.O00000Oo);

    private gfq() {
    }

    public static gfq O000000o() {
        if (f17661O000000o == null) {
            f17661O000000o = new gfq();
        }
        return f17661O000000o;
    }

    public final void O000000o(gwj.O000000o o000000o) {
        if (this.O00000o == null) {
            this.O00000o = new gwj();
            this.O00000o.O000000o(this.O00000o0.O000000o());
        }
        gwj gwj = this.O00000o;
        Iterator<gwj.O000000o> it = gwj.f18407O000000o.iterator();
        while (true) {
            if (!it.hasNext()) {
                gwj.f18407O000000o.add(o000000o);
                break;
            }
            gwj.O000000o next = it.next();
            if (next.O00000oO.equalsIgnoreCase(o000000o.O00000oO)) {
                gwj.f18407O000000o.remove(next);
                gwj.f18407O000000o.add(o000000o);
                break;
            }
        }
        this.O00000o0.O000000o(this.O00000o.O000000o());
    }

    public final gwj.O000000o O000000o(String str) {
        if (this.O00000o == null) {
            this.O00000o = new gwj();
            this.O00000o.O000000o(this.O00000o0.O000000o());
        }
        for (gwj.O000000o next : this.O00000o.f18407O000000o) {
            if (next != null && next.O00000oO != null && next.O00000oO.equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public final void O00000Oo(String str) {
        if (this.O00000o == null) {
            this.O00000o = new gwj();
            this.O00000o.O000000o(this.O00000o0.O000000o());
        }
        gwj gwj = this.O00000o;
        for (gwj.O000000o next : gwj.f18407O000000o) {
            if (next.O00000oO.equalsIgnoreCase(str)) {
                gwj.f18407O000000o.remove(next);
                return;
            }
        }
    }
}
