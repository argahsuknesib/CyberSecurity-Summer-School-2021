package com.tmall.wireless.vaf.virtualview.view.nlayout;

import _m_j.dov;
import _m_j.dox;
import _m_j.dpb;
import _m_j.dpd;
import _m_j.dpf;
import _m_j.dqj;
import _m_j.dqk;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class NativeLayoutImpl extends ViewGroup implements dpb, dqk {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f5894O000000o;

    public View getHolderView() {
        return this;
    }

    public int getType() {
        return -1;
    }

    public NativeLayoutImpl(Context context) {
        super(context);
    }

    public final void O000000o(dpf dpf, View view) {
        List<dpf> O00000Oo;
        dpf.O000000o(view);
        if (dpf instanceof dpd) {
            View g_ = dpf.g_();
            int i = 0;
            if (g_ == null || g_ == this) {
                dpf.O000000o(view);
                List<dpf> O00000Oo2 = ((dpd) dpf).O00000Oo();
                if (O00000Oo2 != null) {
                    int size = O00000Oo2.size();
                    while (i < size) {
                        O000000o(O00000Oo2.get(i), view);
                        i++;
                    }
                    return;
                }
                return;
            }
            addView(g_, new ViewGroup.LayoutParams(dpf.O000O0oo().f14826O000000o, dpf.O000O0oo().O00000Oo));
            if ((g_ instanceof dqk) && (O00000Oo = ((dpd) dpf).O00000Oo()) != null) {
                int size2 = O00000Oo.size();
                while (i < size2) {
                    ((dqk) g_).O000000o(O00000Oo.get(i), g_);
                    i++;
                }
                return;
            }
            return;
        }
        View g_2 = dpf.g_();
        if (g_2 != null) {
            addView(g_2, new ViewGroup.LayoutParams(dpf.O000O0oo().f14826O000000o, dpf.O000O0oo().O00000Oo));
        }
    }

    public void draw(Canvas canvas) {
        if (this.f5894O000000o != null) {
            dov.O000000o(this, canvas, getMeasuredWidth(), getMeasuredHeight(), this.f5894O000000o.O0000Ooo(), this.f5894O000000o.O0000o00(), this.f5894O000000o.O0000o0(), this.f5894O000000o.O0000o0O());
        }
        super.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        dpf dpf = this.f5894O000000o;
        if (dpf != null) {
            dov.O000000o(this, canvas, dpf.getComMeasuredWidth(), this.f5894O000000o.getComMeasuredHeight(), this.f5894O000000o.O0000Ooo(), this.f5894O000000o.O0000o00(), this.f5894O000000o.O0000o0(), this.f5894O000000o.O0000o0O());
        }
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        dpf dpf = this.f5894O000000o;
        if (!(dpf == null || dpf.O0000Oo() == 0)) {
            dov.O00000Oo(canvas, this.f5894O000000o.O0000Oo(), this.f5894O000000o.getComMeasuredWidth(), this.f5894O000000o.getComMeasuredHeight(), this.f5894O000000o.O0000OoO(), this.f5894O000000o.O0000Ooo(), this.f5894O000000o.O0000o00(), this.f5894O000000o.O0000o0(), this.f5894O000000o.O0000o0O());
        }
        super.onDraw(canvas);
        dpf dpf2 = this.f5894O000000o;
        if (dpf2 != null && dpf2.O000O0Oo()) {
            dpf dpf3 = this.f5894O000000o;
            if (dpf3 instanceof dqj) {
                ((dqj) dpf3).a_(canvas);
                this.f5894O000000o.O00000o0(canvas);
            }
        }
    }

    public void attachViews() {
        O000000o(this.f5894O000000o, this);
    }

    public void setVirtualView(dpf dpf) {
        if (dpf != null) {
            this.f5894O000000o = dpf;
            this.f5894O000000o.O00000Oo((View) this);
            if (this.f5894O000000o.O000O0Oo()) {
                setWillNotDraw(false);
            }
            new dox(this);
        }
    }

    public dpf getVirtualView() {
        return this.f5894O000000o;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        dpf dpf = this.f5894O000000o;
        if (dpf != null && (dpf instanceof dqj)) {
            if (!dpf.O0000oo()) {
                ((dqj) this.f5894O000000o).c_(i, i2);
            }
            setMeasuredDimension(this.f5894O000000o.getComMeasuredWidth(), this.f5894O000000o.getComMeasuredHeight());
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        dpf dpf = this.f5894O000000o;
        if (dpf != null && (dpf instanceof dqj) && !dpf.O0000oo()) {
            ((dqj) this.f5894O000000o).O000000o(z, 0, 0, i5, i6);
        }
    }
}
