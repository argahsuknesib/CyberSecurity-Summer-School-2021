package com.tencent.connect.avatar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class b extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private Rect f5852O000000o;
    private Paint O00000Oo = new Paint();

    public b(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect O000000o2 = O000000o();
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.O00000Oo.setStyle(Paint.Style.FILL);
        this.O00000Oo.setColor(Color.argb(100, 0, 0, 0));
        float f = (float) measuredWidth;
        Canvas canvas2 = canvas;
        float f2 = f;
        canvas2.drawRect(0.0f, 0.0f, f2, (float) O000000o2.top, this.O00000Oo);
        canvas2.drawRect(0.0f, (float) O000000o2.bottom, f2, (float) measuredHeight, this.O00000Oo);
        canvas.drawRect(0.0f, (float) O000000o2.top, (float) O000000o2.left, (float) O000000o2.bottom, this.O00000Oo);
        canvas.drawRect((float) O000000o2.right, (float) O000000o2.top, f, (float) O000000o2.bottom, this.O00000Oo);
        canvas.drawColor(Color.argb(100, 0, 0, 0));
        this.O00000Oo.setStyle(Paint.Style.STROKE);
        this.O00000Oo.setColor(-1);
        canvas.drawRect((float) O000000o2.left, (float) O000000o2.top, (float) (O000000o2.right - 1), (float) O000000o2.bottom, this.O00000Oo);
    }

    public final Rect O000000o() {
        if (this.f5852O000000o == null) {
            this.f5852O000000o = new Rect();
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            int min = Math.min(Math.min((measuredHeight - 60) - 80, measuredWidth), 640);
            int i = (measuredWidth - min) / 2;
            int i2 = (measuredHeight - min) / 2;
            this.f5852O000000o.set(i, i2, i + min, min + i2);
        }
        return this.f5852O000000o;
    }
}
