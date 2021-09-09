package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class MitvCircleView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Paint f9221O000000o = new Paint();
    int O00000Oo = 4;

    public MitvCircleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9221O000000o.setColor(-1);
        this.f9221O000000o.setAntiAlias(true);
        this.f9221O000000o.setStyle(Paint.Style.STROKE);
        this.f9221O000000o.setStrokeWidth((float) this.O00000Oo);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle((float) (getWidth() / 2), (float) (getHeight() / 2), (float) ((getWidth() / 2) - this.O00000Oo), this.f9221O000000o);
    }
}
