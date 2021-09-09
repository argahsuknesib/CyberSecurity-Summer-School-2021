package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate;

public class SketchCardView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private SketchSmoothDelegate f10382O000000o;

    public SketchCardView(Context context) {
        this(context, null);
    }

    public SketchCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SketchCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10382O000000o = new SketchSmoothDelegate(context, attributeSet);
        setWillNotDraw(false);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f10382O000000o.O000000o(canvas);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10382O000000o.O000000o(i, i2, i3, i4);
    }

    public final void O000000o(int i) {
        this.f10382O000000o.O000000o(i);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public Path getOutline() {
        return this.f10382O000000o.f11849O000000o;
    }
}
