package com.xiaomi.smarthome.scene.widget;

import _m_j.hrq;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class MagicIndicator extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private hrq f11331O000000o;

    public MagicIndicator(Context context) {
        super(context);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public final void O000000o(int i, float f, int i2) {
        hrq hrq = this.f11331O000000o;
        if (hrq != null) {
            hrq.O000000o(i, f);
        }
    }

    public final void O000000o(int i) {
        hrq hrq = this.f11331O000000o;
        if (hrq != null) {
            hrq.O000000o(i);
        }
    }

    public final void O00000Oo(int i) {
        hrq hrq = this.f11331O000000o;
        if (hrq != null) {
            hrq.O00000Oo(i);
        }
    }

    public hrq getNavigator() {
        return this.f11331O000000o;
    }

    public void setNavigator(hrq hrq) {
        if (this.f11331O000000o != hrq) {
            this.f11331O000000o = hrq;
            removeAllViews();
            hrq hrq2 = this.f11331O000000o;
            if (hrq2 instanceof View) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((View) hrq2).getLayoutParams();
                if (layoutParams == null) {
                    if (this.f11331O000000o.O000000o()) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    }
                }
                addView((View) this.f11331O000000o, layoutParams);
                this.f11331O000000o.O00000o0();
            }
        }
    }
}
