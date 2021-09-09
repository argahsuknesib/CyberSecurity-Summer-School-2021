package com.tmall.wireless.vaf.virtualview.view.page;

import _m_j.bnt;
import _m_j.dmu;
import _m_j.dpe;
import _m_j.dpf;
import _m_j.dpg;
import _m_j.dpj;
import _m_j.dqq;
import android.util.Log;
import androidx.annotation.Keep;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.page.PageView;
import org.json.JSONObject;

public class Page extends dpe implements PageView.O00000Oo {
    protected int O000o0 = 0;
    protected dqq O000o00O;
    protected bnt O000o00o;
    protected int O000o0O;
    protected int O000o0O0 = 0;

    public final boolean O0000Oo0() {
        return true;
    }

    public Page(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o00O = new dqq(vafContext);
        dqq dqq = this.O000o00O;
        this.f14827O000000o = dqq;
        dqq.setListener(this);
    }

    public final void O00000o() {
        super.O00000o();
        this.O000o00O.O000000o();
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
        if (i != -665970021) {
            return false;
        }
        this.O000o00o = bnt;
        return true;
    }

    public final boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        boolean z = false;
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case -1439500848:
                dqq dqq = this.O000o00O;
                if (1 == i2) {
                    z = true;
                }
                dqq.setOrientation(z);
                break;
            case -1171801334:
                this.O000o00O.setAnimationStyle(i2);
                break;
            case -380157501:
                dqq dqq2 = this.O000o00O;
                if (i2 > 0) {
                    z = true;
                }
                dqq2.setAutoSwitch(z);
                break;
            case -137744447:
                dqq dqq3 = this.O000o00O;
                if (i2 > 0) {
                    z = true;
                }
                dqq3.setSlide(z);
                break;
            case 78802736:
                this.O000o00O.setAutoSwitchTimeInterval(i2);
                break;
            case 207632732:
                this.O000o00O.setContainerId(i2);
                break;
            case 1322318022:
                this.O000o00O.setStayTime(i2);
                break;
            case 1347692116:
                this.O000o00O.setAnimatorTimeInterval(i2);
                break;
            case 1942742086:
                dqq dqq4 = this.O000o00O;
                if (i2 == 0) {
                    z = true;
                }
                dqq4.setLayoutOrientation(z);
                break;
            default:
                return false;
        }
        return true;
    }

    public final boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        if (O000000o2) {
            return O000000o2;
        }
        switch (i) {
            case -380157501:
                this.O00000Oo.O000000o(this, -380157501, str, 4);
                return true;
            case -137744447:
                this.O00000Oo.O000000o(this, -137744447, str, 4);
                return true;
            case 78802736:
                this.O00000Oo.O000000o(this, 78802736, str, 0);
                return true;
            case 1322318022:
                this.O00000Oo.O000000o(this, 1322318022, str, 0);
                return true;
            case 1347692116:
                this.O00000Oo.O000000o(this, 1347692116, str, 0);
                return true;
            default:
                return false;
        }
    }

    public final void O0000OOo(int i, int i2) {
        this.O000o0O0 = this.O000o0;
        this.O000o0 = i - 1;
        this.O000o0O = i2;
        this.O000OoO0.O00000Oo().O000000o(3, new dpj(this.O000OoO0, this));
        if (this.O000o00o != null) {
            dmu O00000oO = this.O000OoO0.O00000oO();
            if (O00000oO != null) {
                try {
                    O00000oO.f14795O000000o.O00000o0.O000000o((JSONObject) O0000OOo().O00000Oo);
                } catch (Exception e) {
                    e.printStackTrace();
                    return;
                }
            }
            if (O00000oO == null || !O00000oO.O000000o(this, this.O000o00o)) {
                Log.e("Page_TMTEST", "callPageFlip execute failed");
            }
        }
    }

    @Keep
    public void onScroll(int i) {
        Log.d("Page_TMTEST", "page scroll ".concat(String.valueOf(i)));
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new Page(vafContext, dpg);
        }
    }
}
