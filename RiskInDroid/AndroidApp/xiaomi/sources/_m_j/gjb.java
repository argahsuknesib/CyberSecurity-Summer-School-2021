package _m_j;

import android.text.TextUtils;
import com.xiaomi.smarthome.infrared.bean.IRKeyValue;
import com.xiaomi.smarthome.infrared.bean.IRType;
import java.util.LinkedList;
import java.util.List;

public final class gjb {

    /* renamed from: O000000o  reason: collision with root package name */
    public O000000o f17825O000000o;
    public LinkedList<gix> O00000Oo = new LinkedList<>();
    private List<gix> O00000o;
    private IRType O00000o0;

    public interface O000000o {
        void O000000o();

        void O000000o(IRKeyValue iRKeyValue, int i, int i2, int i3);

        void O000000o(String str);
    }

    public gjb(List<gix> list, IRType iRType, O000000o o000000o) {
        this.O00000o0 = iRType;
        this.O00000o = list;
        this.f17825O000000o = o000000o;
        O000000o("1");
    }

    public final void O000000o(String str) {
        gix O00000Oo2 = O00000Oo(str);
        this.O00000Oo.add(O00000Oo2);
        if (O00000Oo2 != null) {
            O000000o(O000000o(O00000Oo2), O00000Oo2.O00000oo, O00000Oo2.O0000O0o, this.O00000Oo.size());
        } else {
            O00000Oo();
        }
    }

    public final void O000000o() {
        String str = this.O00000Oo.getLast().O00000oO;
        if ("0".equals(str) || TextUtils.isEmpty(str)) {
            O00000Oo();
        } else {
            O000000o(str);
        }
    }

    public final void O000000o(IRKeyValue iRKeyValue, int i, int i2, int i3) {
        O000000o o000000o = this.f17825O000000o;
        if (o000000o != null) {
            o000000o.O000000o(iRKeyValue, i, i2, i3);
        }
    }

    private void O00000Oo() {
        O000000o o000000o = this.f17825O000000o;
        if (o000000o != null) {
            o000000o.O000000o();
        }
    }

    private gix O00000Oo(String str) {
        int i;
        try {
            i = Integer.parseInt(str) - 1;
        } catch (Throwable unused) {
            i = 0;
        }
        if (i < this.O00000o.size()) {
            gix gix = this.O00000o.get(i);
            if (TextUtils.equals(gix.f17820O000000o, str)) {
                return gix;
            }
        }
        for (gix next : this.O00000o) {
            if (TextUtils.equals(next.f17820O000000o, str)) {
                return next;
            }
        }
        return null;
    }

    public final IRKeyValue O000000o(gix gix) {
        String str = gix.O00000o0;
        giv giv = gix.O00000Oo;
        IRKeyValue iRKeyValue = new IRKeyValue();
        iRKeyValue.O00000o0 = this.O00000o0;
        String str2 = giv.O00000Oo;
        if ("0".equals(str2) || TextUtils.isEmpty(str2)) {
            iRKeyValue.O00000oo = giv.f17818O000000o;
        } else {
            if (iRKeyValue.O00000o0 == IRType.AC) {
                iRKeyValue.O00000o0 = IRType.NO_STATE_AC;
            }
            iRKeyValue.O00000oo = String.valueOf(str2);
        }
        iRKeyValue.O00000o = giv.O00000o0;
        iRKeyValue.O00000oO = "";
        iRKeyValue.O0000OOo = giv.O00000o;
        iRKeyValue.f9037O000000o = str;
        return iRKeyValue;
    }
}
