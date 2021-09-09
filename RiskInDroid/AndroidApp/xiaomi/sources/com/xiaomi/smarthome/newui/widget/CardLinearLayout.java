package com.xiaomi.smarthome.newui.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate;

public class CardLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private SketchSmoothDelegate f10274O000000o;

    public CardLinearLayout(Context context) {
        this(context, null);
    }

    public CardLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10274O000000o = new SketchSmoothDelegate(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        canvas.clipPath(this.f10274O000000o.f11849O000000o);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10274O000000o.O000000o(i, i2, i3, i4);
    }
}
