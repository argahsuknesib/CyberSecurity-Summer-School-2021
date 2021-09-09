package _m_j;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class dmu {

    /* renamed from: O000000o  reason: collision with root package name */
    public dmt f14795O000000o = new dmt();
    private List<dnp> O00000Oo = new ArrayList();
    private int O00000o0;

    public dmu() {
        this.O00000Oo.add(new dnf());
        this.O00000Oo.add(new dog());
        this.O00000Oo.add(new dob());
        this.O00000Oo.add(new dnm());
        this.O00000Oo.add(new dnz());
        this.O00000Oo.add(new dno());
        this.O00000Oo.add(new doh());
        this.O00000Oo.add(new dnx());
        this.O00000Oo.add(new dod());
        this.O00000Oo.add(new dns());
        this.O00000Oo.add(new dnw());
        this.O00000Oo.add(new doc());
        this.O00000Oo.add(new dnn());
        this.O00000Oo.add(new dnr());
        this.O00000Oo.add(new dnv());
        this.O00000Oo.add(new dnq());
        this.O00000Oo.add(new dne());
        this.O00000Oo.add(new dof());
        this.O00000Oo.add(new doa());
        this.O00000Oo.add(new dnl());
        this.O00000Oo.add(new dny());
        this.O00000Oo.add(new dnt());
        this.O00000Oo.add(new dnu());
        this.O00000Oo.add(new dng());
        this.O00000Oo.add(new doe());
        this.O00000Oo.add(new dni());
        this.O00000o0 = this.O00000Oo.size();
    }

    public final void O000000o() {
        for (dnp O000000o2 : this.O00000Oo) {
            O000000o2.O000000o(this.f14795O000000o);
        }
    }

    public final boolean O000000o(Object obj, bnt bnt) {
        byte O000000o2;
        boolean z;
        dmr dmr = this.f14795O000000o.f14794O000000o;
        if (bnt == null) {
            return false;
        }
        dmr.f14792O000000o = bnt;
        dmr.O00000o0 = dmr.f14792O000000o.O00000Oo;
        dmr.O00000Oo = dmr.O00000o0;
        int i = 2;
        while (true) {
            O000000o2 = dmr.O000000o();
            if (O000000o2 >= 0 && O000000o2 < this.O00000o0) {
                dnp dnp = this.O00000Oo.get(O000000o2);
                dnp.O000000o();
                i = dnp.O000000o(obj);
                if (1 == i) {
                    if (dmr.O00000Oo == dmr.f14792O000000o.O00000o0) {
                        z = true;
                        continue;
                    } else {
                        z = false;
                        continue;
                    }
                    if (z) {
                        break;
                    }
                } else {
                    break;
                }
            } else {
                Log.e("ExprEngine_TMTEST", "operator code error:".concat(String.valueOf((int) O000000o2)));
            }
        }
        Log.e("ExprEngine_TMTEST", "operator code error:".concat(String.valueOf((int) O000000o2)));
        if (1 == i) {
            return true;
        }
        return false;
    }
}
