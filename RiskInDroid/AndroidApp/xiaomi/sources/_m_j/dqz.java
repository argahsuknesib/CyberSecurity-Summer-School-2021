package _m_j;

import android.text.TextUtils;
import com.tmall.wireless.vaf.framework.VafContext;

public abstract class dqz extends dpf {
    protected int O000o = -1;
    protected String O000o0OO = "";
    protected int O000o0Oo = -16777216;
    protected int O000o0o;
    protected int O000o0o0 = bns.O00000Oo(20.0d);
    protected String O000o0oo;
    protected int O000oO00 = -1;

    public dqz(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000O0OO = "title";
        this.O000o0o = 0;
    }

    public void O00000o0(String str) {
        if (!TextUtils.equals(str, this.O000o0OO)) {
            this.O000o0OO = str;
            O000O0OO();
        }
    }

    public void O00000oO() {
        super.O00000oO();
        if (O000OOo0()) {
            int i = this.O000OOOo;
            if ((i & 2) != 0) {
                i = (i & -3) | 1;
            } else if ((i & 1) != 0) {
                i = (i & -2) | 2;
            }
            this.O000OOOo = i;
        }
    }

    public boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        if (O000000o2) {
            return O000000o2;
        }
        switch (i) {
            case -1063571914:
                this.O00000Oo.O000000o(this, -1063571914, str, 3);
                return O000000o2;
            case -1048634236:
                this.O00000Oo.O000000o(this, -1048634236, str, 8);
                return O000000o2;
            case -1003668786:
                this.O00000Oo.O000000o(this, -1003668786, str, 1);
                return O000000o2;
            case -675792745:
                this.O000o0oo = str;
                return O000000o2;
            case 3556653:
                if (bns.O000000o(str)) {
                    this.O00000Oo.O000000o(this, 3556653, str, 2);
                    return O000000o2;
                }
                this.O000o0OO = str;
                return O000000o2;
            default:
                return false;
        }
    }

    public boolean O00000Oo(int i, float f) {
        boolean O00000Oo = super.O00000Oo(i, f);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i != -1003668786) {
            return false;
        }
        this.O000o0o0 = bns.O00000Oo((double) Math.round(f));
        return true;
    }

    public boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i != -1003668786) {
            return false;
        }
        this.O000o0o0 = bns.O000000o((double) f);
        return true;
    }

    public boolean O00000o0(int i, int i2) {
        boolean O00000o0 = super.O00000o0(i, i2);
        if (O00000o0) {
            return O00000o0;
        }
        switch (i) {
            case -1063571914:
                this.O000o0Oo = i2;
                return true;
            case -1048634236:
                this.O000o0o = i2;
                return true;
            case -1003668786:
                this.O000o0o0 = bns.O00000Oo((double) i2);
                return true;
            case 102977279:
                this.O000o = i2;
                return true;
            case 1554823821:
                this.O000oO00 = i2;
                return true;
            default:
                return false;
        }
    }

    public boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i != -1003668786) {
            return false;
        }
        this.O000o0o0 = bns.O000000o((double) i2);
        return true;
    }
}
