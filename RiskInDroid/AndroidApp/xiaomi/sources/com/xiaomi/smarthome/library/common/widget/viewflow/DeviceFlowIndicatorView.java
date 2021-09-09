package com.xiaomi.smarthome.library.common.widget.viewflow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.R;

public class DeviceFlowIndicatorView extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    int f9333O000000o;
    int O00000Oo;
    int O00000o;
    Drawable O00000o0 = getResources().getDrawable(R.drawable.sel_icon);
    int O00000oO = getResources().getDimensionPixelSize(R.dimen.margin_medium);
    Rect O00000oo = new Rect();

    public DeviceFlowIndicatorView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getCurrentPos() {
        return this.f9333O000000o;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.O00000o = getResources().getDisplayMetrics().widthPixels;
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (getChildCount() >= 2) {
            getChildAt(0).getHitRect(this.O00000oo);
            this.O00000oo.offsetTo(((getWidth() * this.O00000Oo) / (this.O00000o * getChildCount())) + this.O00000oO, 0);
            this.O00000o0.setBounds(this.O00000oo);
            this.O00000o0.draw(canvas);
        }
    }
}
