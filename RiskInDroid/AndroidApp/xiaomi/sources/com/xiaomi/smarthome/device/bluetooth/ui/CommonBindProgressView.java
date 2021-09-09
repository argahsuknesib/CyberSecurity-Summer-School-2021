package com.xiaomi.smarthome.device.bluetooth.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

public class CommonBindProgressView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    protected RectF f7174O000000o = null;
    private Paint O00000Oo;
    private int O00000o0;

    public CommonBindProgressView(Context context) {
        super(context);
        O000000o();
    }

    public CommonBindProgressView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o();
    }

    public CommonBindProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o();
    }

    private void O000000o() {
        this.O00000Oo = new Paint();
        this.O00000Oo.setAntiAlias(true);
        this.O00000Oo.setStyle(Paint.Style.STROKE);
        this.O00000Oo.setStrokeWidth(6.0f);
    }

    public void setProgress(int i) {
        if (i < 0) {
            i = 0;
        }
        if (i > 100) {
            i = 100;
        }
        this.O00000o0 = i;
        invalidate();
    }

    public int getProgress() {
        return this.O00000o0;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f7174O000000o == null) {
            this.f7174O000000o = new RectF(3.0f, 3.0f, (float) (getWidth() - 3), (float) (getHeight() - 3));
        }
        this.O00000Oo.setColor(Color.parseColor("#fafafa"));
        Canvas canvas2 = canvas;
        canvas2.drawArc(this.f7174O000000o, 135.0f, 270.0f, false, this.O00000Oo);
        this.O00000Oo.setColor(Color.parseColor("#0099ff"));
        canvas2.drawArc(this.f7174O000000o, 135.0f, (float) ((this.O00000o0 * 270) / 100), false, this.O00000Oo);
    }
}
