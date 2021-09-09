package com.xiaomi.smarthome.newui.widget.topnavi.indicator;

import _m_j.hhr;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;

public class MagicIndicator extends FrameLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    public hhr f10342O000000o;

    public MagicIndicator(Context context) {
        super(context);
    }

    public MagicIndicator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public hhr getNavigator() {
        return this.f10342O000000o;
    }

    public void setNavigator(hhr hhr) {
        if (this.f10342O000000o != hhr) {
            this.f10342O000000o = hhr;
            removeAllViews();
            hhr hhr2 = this.f10342O000000o;
            if (hhr2 instanceof View) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) ((View) hhr2).getLayoutParams();
                if (layoutParams == null) {
                    if (this.f10342O000000o.O00000Oo()) {
                        layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    } else {
                        layoutParams = new FrameLayout.LayoutParams(-1, -1);
                    }
                }
                addView((View) this.f10342O000000o, layoutParams);
                this.f10342O000000o.O000000o();
            }
        }
    }
}
