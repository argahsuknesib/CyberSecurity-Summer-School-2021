package _m_j;

import _m_j.dpf;
import android.util.Log;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.slider.SliderView;
import org.json.JSONObject;

public final class dqw extends dpe implements SliderView.O000000o {
    protected int O000o0;
    protected dqx O000o00O;
    protected bnt O000o00o;
    protected int O000o0O0;

    public final boolean O0000Oo0() {
        return true;
    }

    public dqw(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o00O = new dqx(vafContext);
        dqx dqx = this.O000o00O;
        this.f14827O000000o = dqx;
        dqx.setListener(this);
    }

    public final void O00000o() {
        super.O00000o();
        this.O000o00O.scrollTo(0, 0);
    }

    public final void O00000Oo(Object obj) {
        this.O000o00O.setData(obj);
        super.O00000Oo(obj);
    }

    public final boolean O00000Oo(int i, bnt bnt) {
        boolean O00000Oo = super.O00000Oo(i, bnt);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i != 1490730380) {
            return false;
        }
        this.O000o00o = bnt;
        return true;
    }

    public final boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 3536714) {
            this.O000o00O.setSpan(bns.O00000Oo((double) f));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O00000Oo((double) f));
            return true;
        }
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        if (i == -1439500848) {
            this.O000o00O.setOrientation(i2);
            return true;
        } else if (i == 3536714) {
            this.O000o00O.setSpan(bns.O00000Oo((double) i2));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O00000Oo((double) i2));
            return true;
        }
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i == 3536714) {
            this.O000o00O.setSpan(bns.O000000o((double) f));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O000000o((double) f));
            return true;
        }
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i == 3536714) {
            this.O000o00O.setSpan(bns.O000000o((double) i2));
            return true;
        } else if (i != 2146088563) {
            return false;
        } else {
            this.O000o00O.setItemWidth(bns.O000000o((double) i2));
            return true;
        }
    }

    public final void O0000OOo(int i, int i2) {
        this.O000o0 = i;
        this.O000o0O0 = i2;
        if (this.O000o00o != null) {
            dmu O00000oO = this.O000OoO0.O00000oO();
            if (O00000oO != null) {
                O00000oO.f14795O000000o.O00000o0.O000000o((JSONObject) O0000OOo().O00000Oo);
            }
            if (O00000oO == null || !O00000oO.O000000o(this, this.O000o00o)) {
                Log.e("Slider_TMTEST", "callPageFlip execute failed");
            }
        }
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqw(vafContext, dpg);
        }
    }
}
