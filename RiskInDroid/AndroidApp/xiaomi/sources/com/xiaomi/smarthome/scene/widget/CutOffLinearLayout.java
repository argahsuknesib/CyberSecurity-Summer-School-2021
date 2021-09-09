package com.xiaomi.smarthome.scene.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

public class CutOffLinearLayout extends LinearLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f11330O000000o;
    private Paint O00000Oo;
    private final float O00000o;
    private boolean O00000o0;
    private int O00000oO;
    private int O00000oo;

    public CutOffLinearLayout(Context context) {
        this(context, null);
    }

    public CutOffLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CutOffLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11330O000000o = -1;
        this.O00000oo = -1;
        this.O00000Oo = new Paint(1);
        this.O00000Oo.setColor(-1);
        this.O00000o = 3.0f;
        this.O00000Oo.setPathEffect(new CornerPathEffect(this.O00000o / 2.0f));
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.f11330O000000o != -1) {
            if (this.O00000oo == -1 || this.O00000oO == -1) {
                View childAt = getChildAt(0);
                if (childAt instanceof SimplePagerTitleView) {
                    SimplePagerTitleView simplePagerTitleView = (SimplePagerTitleView) childAt;
                    this.O00000oo = simplePagerTitleView.getPaddingTop() + simplePagerTitleView.getContentTop();
                    this.O00000oO = getHeight() - (this.O00000oo * 2);
                }
            }
            this.O00000o0 = false;
            int i = this.f11330O000000o;
            float f = this.O00000o;
            int i2 = this.O00000oo;
            Canvas canvas2 = canvas;
            canvas2.drawRect(((float) i) - (f / 2.0f), (float) i2, ((float) i) + (f / 2.0f), (float) (i2 + this.O00000oO), this.O00000Oo);
        }
    }

    private int getStartY() {
        return (getHeight() - this.O00000oO) / 2;
    }

    public boolean isDirty() {
        return this.O00000o0 || super.isDirty();
    }
}
