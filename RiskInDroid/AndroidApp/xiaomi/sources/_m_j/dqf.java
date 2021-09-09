package _m_j;

import android.util.Log;
import com.tmall.wireless.vaf.framework.VafContext;

public abstract class dqf extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected boolean f14849O000000o = true;
    protected int O000o0 = 1;
    protected int O000o00O = -16777216;
    protected int O000o00o = 1;
    protected float[] O000o0O0 = {3.0f, 5.0f, 3.0f, 5.0f};

    public dqf(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public final boolean O00000Oo() {
        return this.f14849O000000o;
    }

    public final boolean O00000Oo(int i, float f) {
        if (i != 793104392) {
            return false;
        }
        this.O000o00o = bns.O00000Oo((double) f);
        if (this.O000o00o > 0) {
            return true;
        }
        this.O000o00o = 1;
        return true;
    }

    public final boolean O000000o(int i, String str) {
        boolean O000000o2 = super.O000000o(i, str);
        int i2 = 0;
        if (O000000o2) {
            return O000000o2;
        }
        if (i == 94842723) {
            this.O00000Oo.O000000o(this, 94842723, str, 3);
        } else if (i != 1037639619) {
            return false;
        } else {
            if (str != null) {
                String trim = str.trim();
                if (!trim.startsWith("[") || !trim.endsWith("]")) {
                    Log.e("LineBase_TMTEST", "no match []");
                } else {
                    String[] split = trim.substring(1, trim.length() - 1).split(",");
                    if (split.length <= 0 || (split.length & 1) != 0) {
                        Log.e("LineBase_TMTEST", "length invalidate:" + split.length);
                    } else {
                        float[] fArr = new float[split.length];
                        while (i2 < split.length) {
                            try {
                                fArr[i2] = Float.parseFloat(split[i2]);
                                i2++;
                            } catch (NumberFormatException unused) {
                            }
                        }
                        if (i2 == split.length) {
                            this.O000o0O0 = fArr;
                        }
                    }
                }
            }
        }
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
                if (i2 != 0) {
                    z = true;
                }
                this.f14849O000000o = z;
                break;
            case 94842723:
                this.O000o00O = i2;
                break;
            case 109780401:
                this.O000o0 = i2;
                break;
            case 793104392:
                this.O000o00o = bns.O00000Oo((double) i2);
                if (this.O000o00o <= 0) {
                    this.O000o00o = 1;
                    break;
                }
                break;
            default:
                return false;
        }
        return true;
    }

    public final boolean O00000Oo(int i, int i2) {
        boolean O00000Oo = super.O00000Oo(i, i2);
        if (O00000Oo) {
            return O00000Oo;
        }
        if (i != 793104392) {
            return false;
        }
        this.O000o00o = bns.O000000o((double) i2);
        if (this.O000o00o <= 0) {
            this.O000o00o = 1;
        }
        return true;
    }

    public final boolean O000000o(int i, float f) {
        boolean O000000o2 = super.O000000o(i, f);
        if (O000000o2) {
            return O000000o2;
        }
        if (i != 793104392) {
            return false;
        }
        this.O000o00o = bns.O000000o((double) f);
        if (this.O000o00o <= 0) {
            this.O000o00o = 1;
        }
        return true;
    }
}
