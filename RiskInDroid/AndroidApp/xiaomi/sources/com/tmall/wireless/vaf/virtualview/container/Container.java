package com.tmall.wireless.vaf.virtualview.container;

import _m_j.dox;
import _m_j.dpb;
import _m_j.dpc;
import _m_j.dpd;
import _m_j.dpf;
import _m_j.dqk;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;

public class Container extends ViewGroup implements dpb, dpc {

    /* renamed from: O000000o  reason: collision with root package name */
    protected dpf f5892O000000o;

    public View getHolderView() {
        return this;
    }

    public int getType() {
        return 0;
    }

    public Container(Context context) {
        super(context);
    }

    public void attachViews() {
        O000000o(this.f5892O000000o, this);
    }

    private void O000000o(dpf dpf, View view) {
        List<dpf> O00000Oo;
        dpf.O000000o(view);
        if (dpf instanceof dpd) {
            View g_ = dpf.g_();
            int i = 0;
            if (g_ != null) {
                addView(g_, new ViewGroup.LayoutParams(dpf.O000O0oo().f14826O000000o, dpf.O000O0oo().O00000Oo));
                if ((g_ instanceof dqk) && (O00000Oo = ((dpd) dpf).O00000Oo()) != null) {
                    int size = O00000Oo.size();
                    while (i < size) {
                        ((dqk) g_).O000000o(O00000Oo.get(i), g_);
                        i++;
                    }
                    return;
                }
                return;
            }
            List<dpf> O00000Oo2 = ((dpd) dpf).O00000Oo();
            if (O00000Oo2 != null) {
                int size2 = O00000Oo2.size();
                while (i < size2) {
                    O000000o(O00000Oo2.get(i), view);
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

    public void setVirtualView(dpf dpf) {
        if (dpf != null) {
            this.f5892O000000o = dpf;
            this.f5892O000000o.O00000Oo((View) this);
            if (this.f5892O000000o.O000O0Oo()) {
                setWillNotDraw(false);
            }
            new dox(this);
        }
    }

    public dpf getVirtualView() {
        return this.f5892O000000o;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        dpf dpf = this.f5892O000000o;
        if (dpf != null && dpf.O000O0Oo()) {
            this.f5892O000000o.O000000o(canvas);
        }
    }

    public void measureComponent(int i, int i2) {
        dpf dpf = this.f5892O000000o;
        if (dpf != null) {
            if (!dpf.O0000oo()) {
                this.f5892O000000o.measureComponent(i, i2);
            }
            setMeasuredDimension(this.f5892O000000o.getComMeasuredWidth(), this.f5892O000000o.getComMeasuredHeight());
        }
    }

    public void comLayout(int i, int i2, int i3, int i4) {
        dpf dpf = this.f5892O000000o;
        if (dpf != null && !dpf.O0000oo()) {
            this.f5892O000000o.comLayout(0, 0, i3 - i, i4 - i2);
            layout(i, i2, i3, i4);
        }
    }

    public void onComMeasure(int i, int i2) {
        dpf dpf = this.f5892O000000o;
        if (dpf != null) {
            if (!dpf.O0000oo()) {
                this.f5892O000000o.onComMeasure(i, i2);
            }
            setMeasuredDimension(this.f5892O000000o.getComMeasuredWidth(), this.f5892O000000o.getComMeasuredHeight());
        }
    }

    public void onComLayout(boolean z, int i, int i2, int i3, int i4) {
        dpf dpf = this.f5892O000000o;
        if (dpf != null && !dpf.O0000oo()) {
            this.f5892O000000o.onComLayout(z, i, i2, i3, i4);
        }
    }

    public int getComMeasuredWidth() {
        dpf dpf = this.f5892O000000o;
        if (dpf != null) {
            return dpf.getComMeasuredWidth();
        }
        return 0;
    }

    public int getComMeasuredHeight() {
        dpf dpf = this.f5892O000000o;
        if (dpf != null) {
            return dpf.getComMeasuredHeight();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        onComMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        onComLayout(z, 0, 0, i3 - i, i4 - i2);
    }
}
