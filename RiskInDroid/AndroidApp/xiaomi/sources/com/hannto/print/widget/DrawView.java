package com.hannto.print.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class DrawView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public Paint f4364O000000o;
    public Path O00000Oo;
    public Context O00000o0;

    public DrawView(Context context) {
        this(context, null);
    }

    public DrawView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000o0 = context;
        this.f4364O000000o = new Paint();
        this.f4364O000000o.setColor(getResources().getColor(R.color.ht_color_white));
        this.f4364O000000o.setStrokeWidth((float) ((int) ((this.O00000o0.getResources().getDisplayMetrics().density * 2.0f) + 0.5f)));
        this.f4364O000000o.setStyle(Paint.Style.STROKE);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = this.O00000Oo;
        if (path != null) {
            canvas.drawPath(path, this.f4364O000000o);
        }
    }

    public void setPath(Path path) {
        this.O00000Oo = path;
        postInvalidate();
    }
}
