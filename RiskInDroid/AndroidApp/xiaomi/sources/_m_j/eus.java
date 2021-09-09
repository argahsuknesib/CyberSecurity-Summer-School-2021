package _m_j;

import _m_j.dpf;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.xiaomi.shopviews.adapter.bigvision.GravityImageVirtualView;

public final class eus extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected GravityImageVirtualView f15834O000000o;
    private int O000o0;
    private int O000o00O;
    private int O000o00o;
    private boolean O000o0O;
    private boolean O000o0O0;
    private boolean O000o0OO;

    public eus(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.f15834O000000o = new GravityImageVirtualView(vafContext.O0000O0o());
        dpw O0000Oo0 = VafContext.O0000Oo0();
        this.O000o00O = O0000Oo0.O000000o("enablePanoramaMode");
        this.O000o00o = O0000Oo0.O000000o("invertScrollDirection");
        this.O000o0 = O0000Oo0.O000000o("showScrollbar");
    }

    public final void onComMeasure(int i, int i2) {
        this.f15834O000000o.onComMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f15834O000000o.onComLayout(z, i, i2, i3, i4);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        this.f15834O000000o.comLayout(i, i2, i3, i4);
    }

    public final View g_() {
        return this.f15834O000000o;
    }

    public final int getComMeasuredWidth() {
        return this.f15834O000000o.getComMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return this.f15834O000000o.getComMeasuredHeight();
    }

    public final boolean O000000o(int i, String str) {
        if (i == this.O000o00O) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o00O, str, 4);
            } else {
                this.O000o0O0 = Boolean.parseBoolean(str);
            }
        } else if (i == this.O000o00o) {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o00o, str, 4);
            } else {
                this.O000o0O = Boolean.parseBoolean(str);
            }
        } else if (i != this.O000o0) {
            return super.O000000o(i, str);
        } else {
            if (bns.O000000o(str)) {
                this.O00000Oo.O000000o(this, this.O000o0, str, 4);
            } else {
                this.O000o0OO = Boolean.parseBoolean(str);
            }
        }
        return true;
    }

    public final void O00000o() {
        super.O00000o();
    }

    public final void O00000oO() {
        super.O00000oO();
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new eus(vafContext, dpg);
        }
    }
}
