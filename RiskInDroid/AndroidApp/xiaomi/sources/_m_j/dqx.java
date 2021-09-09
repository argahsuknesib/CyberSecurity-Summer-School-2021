package _m_j;

import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.slider.SliderView;

public final class dqx extends SliderView implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f14858O000000o;

    public final void attachViews() {
    }

    public final View getHolderView() {
        return null;
    }

    public final int getType() {
        return -1;
    }

    public dqx(VafContext vafContext) {
        super(vafContext.O00000oo());
        this.O00000o = new doz(vafContext);
    }

    public final void setData(Object obj) {
        this.O00000o0 = true;
        this.O00000o.O000000o(obj);
    }

    public final void measureComponent(int i, int i2) {
        measure(i, i2);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        layout(i, i2, i3, i4);
    }

    public final void onComMeasure(int i, int i2) {
        onMeasure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        onLayout(z, i, i2, i3, i4);
    }

    public final int getComMeasuredWidth() {
        return getMeasuredWidth();
    }

    public final int getComMeasuredHeight() {
        return getMeasuredHeight();
    }

    public final void setVirtualView(dpf dpf) {
        this.f14858O000000o = dpf;
    }

    public final dpf getVirtualView() {
        return this.f14858O000000o;
    }
}
