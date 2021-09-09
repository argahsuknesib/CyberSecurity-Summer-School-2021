package com.mi.blockcanary.ui;

import _m_j.byh;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public final class MoreDetailsView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f4583O000000o = new Paint(1);
    private boolean O00000Oo = true;

    public MoreDetailsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f4583O000000o.setStrokeWidth(byh.O000000o(2.0f, getResources()));
        this.f4583O000000o.setColor(-8083771);
    }

    /* access modifiers changed from: protected */
    public final void onDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        int i = width / 2;
        float f = (float) (height / 2);
        canvas.drawLine(0.0f, f, (float) width, f, this.f4583O000000o);
        if (this.O00000Oo) {
            float f2 = (float) i;
            canvas.drawLine(f2, 0.0f, f2, (float) height, this.f4583O000000o);
        }
    }

    public final void setFolding(boolean z) {
        if (z != this.O00000Oo) {
            this.O00000Oo = z;
            invalidate();
        }
    }
}
