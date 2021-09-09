package com.mi.global.shop.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.xiaomi.smarthome.R;

public class ResponsiveRelativeLayout extends RelativeLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private Drawable f4963O000000o;

    public ResponsiveRelativeLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    public ResponsiveRelativeLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public ResponsiveRelativeLayout(Context context) {
        super(context);
        O000000o();
    }

    /* access modifiers changed from: protected */
    public Drawable getForegroundDrawable() {
        return getResources().getDrawable(R.drawable.shop_selector_home_staritem);
    }

    private void O000000o() {
        this.f4963O000000o = getForegroundDrawable();
        this.f4963O000000o.setCallback(this);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f4963O000000o.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        this.f4963O000000o.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f4963O000000o;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.f4963O000000o.setState(getDrawableState());
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f4963O000000o.setBounds(0, 0, i, i2);
    }
}
