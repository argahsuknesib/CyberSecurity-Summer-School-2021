package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

public class ResizeLayout extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private O000000o f9245O000000o;

    public interface O000000o {
        void O000000o(int i, int i2);
    }

    public ResizeLayout(Context context) {
        super(context);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public ResizeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setResizeListener(O000000o o000000o) {
        this.f9245O000000o = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        O000000o o000000o = this.f9245O000000o;
        if (o000000o != null) {
            o000000o.O000000o(i2, i4);
        }
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void setHeight(int i) {
        getLayoutParams().height = i;
        requestLayout();
    }
}
