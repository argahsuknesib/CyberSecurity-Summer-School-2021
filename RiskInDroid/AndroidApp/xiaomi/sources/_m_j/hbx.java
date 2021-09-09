package _m_j;

import com.xiaomi.smarthome.newui.card.FlowCompleteAction;
import java.util.List;

public class hbx {
    private static final String O00000Oo = "hbx";

    /* renamed from: O000000o  reason: collision with root package name */
    public List<hcx> f18765O000000o;
    private FlowCompleteAction O00000o;
    private int O00000o0;

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof hbx)) {
            return false;
        }
        hbx hbx = (hbx) obj;
        if (hbx.O00000o0 != this.O00000o0 || hbx.O00000o != this.O00000o || hbx.f18765O000000o.size() != this.f18765O000000o.size()) {
            return false;
        }
        for (int i = 0; i < this.f18765O000000o.size(); i++) {
            if (!this.f18765O000000o.get(i).equals(hbx.f18765O000000o.get(i))) {
                return false;
            }
        }
        return true;
    }
}
