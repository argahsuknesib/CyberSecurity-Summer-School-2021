package com.xiaomi.smarthome.framework.plugin.rn.viewmanager.mapsweeper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

public class MapView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    Path f8601O000000o;
    boolean O00000Oo;
    private Paint O00000o;
    private Context O00000o0;
    private int O00000oO;
    private float O00000oo;
    private float O0000O0o;

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
    }

    public MapView(Context context) {
        this(context, null);
    }

    public MapView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MapView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = Color.parseColor("#ffffff");
        this.O00000Oo = true;
        this.O00000o0 = context;
        this.O00000o = new Paint();
        this.O00000o.setColor(this.O00000oO);
        this.O00000o.setStrokeWidth(0.2f);
        this.O00000o.setStyle(Paint.Style.STROKE);
        this.O00000o.setAntiAlias(true);
        this.f8601O000000o = new Path();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        this.O00000oo = (float) View.MeasureSpec.getSize(i);
        this.O0000O0o = (float) View.MeasureSpec.getSize(i2);
        super.onMeasure(i, i2);
    }

    public float getViewWidth() {
        return this.O00000oo;
    }

    public float getViewHeight() {
        return this.O0000O0o;
    }

    public void setViewWidth(float f) {
        this.O00000oo = f;
    }

    public void setViewHeight(float f) {
        this.O0000O0o = f;
    }

    public void setLineColor(int i) {
        this.O00000oO = i;
        Paint paint = this.O00000o;
        if (paint != null) {
            paint.setColor(this.O00000oO);
        }
    }
}
