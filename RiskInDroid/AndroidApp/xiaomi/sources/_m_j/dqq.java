package _m_j;

import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.page.PageView;

public final class dqq extends PageView implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f14851O000000o;

    public final void attachViews() {
    }

    public final View getHolderView() {
        return null;
    }

    public final int getType() {
        return -1;
    }

    public dqq(VafContext vafContext) {
        super(vafContext.O0000O0o());
        this.O00000o0 = new doz(vafContext);
    }

    public final void setContainerId(int i) {
        this.O00000o0.O000000o(i);
    }

    public final void O000000o() {
        O00000o();
        this.O00000o0.O000000o((Object) null);
    }

    public final void setData(Object obj) {
        this.O0000o = true;
        this.O00000o0.O000000o(obj);
        O00000o0();
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
        this.f14851O000000o = dpf;
    }

    public final dpf getVirtualView() {
        return this.f14851O000000o;
    }
}
