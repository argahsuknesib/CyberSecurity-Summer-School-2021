package com.xiaomi.qrcode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

public final class ViewfinderView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private final Paint f6597O000000o = new Paint(1);
    private final int O00000Oo = Color.parseColor("#66000000");
    private Rect O00000o0;

    public ViewfinderView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @SuppressLint({"DrawAllocation"})
    public final void onDraw(Canvas canvas) {
        Rect rect = this.O00000o0;
        if (rect != null) {
            int width = canvas.getWidth();
            int height = canvas.getHeight();
            this.f6597O000000o.setColor(this.O00000Oo);
            float f = (float) width;
            canvas.drawRect(0.0f, 0.0f, f, (float) rect.top, this.f6597O000000o);
            canvas.drawRect(0.0f, (float) rect.top, (float) rect.left, (float) (rect.bottom + 1), this.f6597O000000o);
            Canvas canvas2 = canvas;
            float f2 = f;
            canvas2.drawRect((float) (rect.right + 1), (float) rect.top, f2, (float) (rect.bottom + 1), this.f6597O000000o);
            canvas2.drawRect(0.0f, (float) (rect.bottom + 1), f2, (float) height, this.f6597O000000o);
        }
    }

    public final void setRect(Rect rect) {
        this.O00000o0 = rect;
    }
}
