package _m_j;

import _m_j.dpf;
import android.graphics.Canvas;
import android.view.View;
import com.tmall.wireless.vaf.framework.VafContext;
import com.tmall.wireless.vaf.virtualview.view.nlayout.NativeLayoutImpl;

public final class dqo extends dpr implements dqj {
    private NativeLayoutImpl O000o0O0;

    public final void O000000o(Canvas canvas) {
    }

    public final void O00000Oo(Canvas canvas) {
    }

    public final boolean O0000Oo0() {
        return true;
    }

    public dqo(VafContext vafContext, dpg dpg) {
        super(vafContext, dpg);
        this.O000o0O0 = new NativeLayoutImpl(vafContext.O0000O0o());
        this.O000o0O0.setVirtualView(this);
    }

    public final View g_() {
        return this.O000o0O0;
    }

    public final void onComMeasure(int i, int i2) {
        this.O000o0O0.measure(i, i2);
    }

    public final void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        this.O000o0O0.onLayout(z, i, i2, i3, i4);
    }

    public final void comLayout(int i, int i2, int i3, int i4) {
        this.O0000O0o = i;
        this.O0000OOo = i2;
        this.O000o0O0.layout(i, i2, i3, i4);
    }

    public final void c_(int i, int i2) {
        super.onComMeasure(i, i2);
    }

    public final void O000000o(boolean z, int i, int i2, int i3, int i4) {
        super.onComLayout(z, 0, 0, i3, i4);
    }

    public final void a_(Canvas canvas) {
        super.O000000o(canvas);
    }

    public static class O000000o implements dpf.O000000o {
        public final dpf O000000o(VafContext vafContext, dpg dpg) {
            return new dqo(vafContext, dpg);
        }
    }
}
