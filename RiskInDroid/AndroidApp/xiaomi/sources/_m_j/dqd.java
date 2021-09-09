package _m_j;

import _m_j.dpf;
import android.graphics.Bitmap;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.Helper.ImageLoader;
import com.tmall.wireless.vaf.virtualview.view.image.NativeImageImp;

public final class dqd extends dqc {
    protected NativeImageImp O000o0;

    public final boolean O0000Oo0() {
        return true;
    }

    public dqd(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0 = new NativeImageImp(vafContext.O0000O0o());
    }

    public final void O000000o(Bitmap bitmap) {
        this.O000o0.setImageBitmap(bitmap);
    }

    public final View g_() {
        return this.O000o0;
    }

    public final void O00000o() {
        super.O00000o();
        ImageLoader O00000o = this.O000OoO0.O00000o();
        getComMeasuredWidth();
        getComMeasuredHeight();
        O00000o.O000000o(null, this);
    }

    public final void O00000oO() {
        super.O00000oO();
        this.O000o0.setScaleType(dqc.f14848O000000o.get(this.O000o00o));
        this.O000o00O = this.O000o00O;
        ImageLoader O00000o = this.O000OoO0.O00000o();
        String str = this.O000o00O;
        getComMeasuredWidth();
        getComMeasuredHeight();
        O00000o.O000000o(str, this);
    }

    public final void measureComponent(int i, int i2) {
        if (this.O000O0o0 > 0) {
            int i3 = this.O000O0o0;
            if (i3 != 1) {
                if (i3 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O000O0o) / this.O000O0oO), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O000O0oO) / this.O000O0o), 1073741824);
            }
        }
        this.O000o0.measureComponent(i, i2);
    }

    public final void onComMeasure(int i, int i2) {
        if (this.O000O0o0 > 0) {
            int i3 = this.O000O0o0;
            if (i3 != 1) {
                if (i3 == 2 && 1073741824 == View.MeasureSpec.getMode(i2)) {
                    i = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i2)) * this.O000O0o) / this.O000O0oO), 1073741824);
                }
            } else if (1073741824 == View.MeasureSpec.getMode(i)) {
                i2 = View.MeasureSpec.makeMeasureSpec((int) ((((float) View.MeasureSpec.getSize(i)) * this.O000O0oO) / this.O000O0o), 1073741824);
            }
        }
        this.O000o0.onComMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.O000o0.onComLayout(z, i, i2, i3, i4);
    }

    public final int getComMeasuredWidth() {
        return this.O000o0.getComMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return this.O000o0.getComMeasuredHeight();
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        this.O000o0.comLayout(i, i2, i3, i4);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqd(vafContext, dpg);
        }
    }
}
