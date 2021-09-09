package com.xiaomi.smarthome.newui.widget.topnavi.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate;

public class CardConstraintLayout extends ConstraintLayout {

    /* renamed from: O000000o  reason: collision with root package name */
    private SketchSmoothDelegate f10358O000000o;

    public CardConstraintLayout(Context context) {
        this(context, null);
    }

    public CardConstraintLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CardConstraintLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10358O000000o = new SketchSmoothDelegate(context, attributeSet);
        setWillNotDraw(false);
    }

    public void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.f10358O000000o.O000000o(canvas);
        super.onDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f10358O000000o.O000000o(i, i2, i3, i4);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate.O000000o(boolean, boolean, boolean, boolean):void
     arg types: [int, int, boolean, boolean]
     candidates:
      com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate.O000000o(int, int, int, int):void
      com.xiaomi.smarthome.smoothcard.SketchSmoothDelegate.O000000o(boolean, boolean, boolean, boolean):void */
    public final void O000000o(boolean z, boolean z2) {
        this.f10358O000000o.O000000o(false, false, z, z2);
        invalidate();
    }

    /* access modifiers changed from: protected */
    public Path getOutline() {
        return this.f10358O000000o.f11849O000000o;
    }
}
