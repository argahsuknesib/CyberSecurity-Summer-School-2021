package _m_j;

import android.os.Build;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;

public class dpe extends dpf {

    /* renamed from: O000000o  reason: collision with root package name */
    protected View f14827O000000o;

    public dpe(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
    }

    public void O00000o() {
        super.O00000o();
        if (Build.VERSION.SDK_INT >= 16) {
            this.f14827O000000o.setBackground(null);
        } else {
            this.f14827O000000o.setBackgroundDrawable(null);
        }
    }

    public void O00000oO() {
        super.O00000oO();
    }

    /* access modifiers changed from: protected */
    public final void O000000o(int i) {
        this.f14827O000000o.setBackgroundColor(i);
    }

    public void onComMeasure(int i, int i2) {
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
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            ((dpc) view).onComMeasure(i, i2);
        }
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            ((dpc) view).onComLayout(z, i, i2, i3, i4);
        }
    }

    public int getComMeasuredWidth() {
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            return ((dpc) view).getComMeasuredWidth();
        }
        return view.getMeasuredWidth();
    }

    public int getComMeasuredHeight() {
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            return ((dpc) view).getComMeasuredHeight();
        }
        return view.getMeasuredHeight();
    }

    public void measureComponent(int i, int i2) {
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
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            ((dpc) view).measureComponent(i, i2);
        } else {
            view.measure(i, i2);
        }
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        super.comLayout(i, i2, i3, i4);
        View view = this.f14827O000000o;
        if (view instanceof dpc) {
            ((dpc) view).comLayout(i, i2, i3, i4);
        } else {
            view.layout(i, i2, i3, i4);
        }
    }

    public final View g_() {
        return this.f14827O000000o;
    }
}
