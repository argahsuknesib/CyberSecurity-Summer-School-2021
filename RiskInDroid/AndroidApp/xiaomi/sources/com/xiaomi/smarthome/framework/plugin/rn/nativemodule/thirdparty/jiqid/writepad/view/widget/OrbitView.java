package com.xiaomi.smarthome.framework.plugin.rn.nativemodule.thirdparty.jiqid.writepad.view.widget;

import _m_j.gaf;
import _m_j.md;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.ViewGroup;
import java.util.LinkedList;

public class OrbitView extends ViewGroup {

    /* renamed from: O000000o  reason: collision with root package name */
    public int f8433O000000o;
    public int O00000Oo;
    public float O00000o;
    public int O00000o0;
    public float O00000oO;
    public Paint O00000oo;
    public Path O0000O0o;
    public int O0000OOo;
    public int O0000Oo;
    public float O0000Oo0;
    public md O0000OoO;
    public Bitmap O0000Ooo;
    public int O0000o;
    public Canvas O0000o0;
    public Bitmap O0000o00;
    public Bitmap O0000o0O;
    public Canvas O0000o0o;
    private Context O0000oO;
    public LinkedList<Bitmap> O0000oO0;
    private int O0000oOO;
    private int O0000oOo;

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
    }

    public OrbitView(Context context) {
        this(context, null);
    }

    public OrbitView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public OrbitView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f8433O000000o = 27398;
        this.O00000Oo = 20500;
        this.O00000o0 = 2047;
        this.O00000o = 0.03f;
        this.O00000oO = 0.03f;
        this.O0000o = 10;
        super.setWillNotDraw(false);
        this.O0000oO = context;
        this.O0000OOo = -1;
        this.O0000Oo0 = (float) gaf.O00000o0(context);
        this.O0000Oo = -16777216;
        this.O00000oo = new Paint();
        this.O0000O0o = new Path();
        this.O00000oo.setStrokeWidth(this.O0000Oo0);
        this.O00000oo.setColor(this.O0000Oo);
        this.O00000oo.setStyle(Paint.Style.STROKE);
        this.O00000oo.setAntiAlias(true);
        this.O00000oo.setStrokeCap(Paint.Cap.ROUND);
        this.O00000oo.setStrokeJoin(Paint.Join.ROUND);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.O0000oOO = getMeasuredWidth();
        this.O0000oOo = getMeasuredHeight();
        this.O00000oO = Math.min(((float) this.O0000oOO) / ((float) this.f8433O000000o), ((float) this.O0000oOo) / ((float) this.O00000Oo));
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.O0000Ooo;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
        }
    }

    public static void O000000o(float[] fArr, Canvas canvas, Paint paint) {
        float f = fArr[2] - fArr[0];
        float f2 = fArr[3] - fArr[1];
        int max = (int) (Math.max(Math.abs(f), Math.abs(f2)) + 2.0f);
        float f3 = (float) max;
        float f4 = f / f3;
        float f5 = f2 / f3;
        for (int i = 0; i < max; i++) {
            float f6 = (float) i;
            float f7 = fArr[0] + (f6 * f4);
            float f8 = fArr[1] + (f6 * f5);
            if (!(canvas == null || paint == null)) {
                canvas.drawPoint(f7, f8, paint);
            }
        }
    }

    public final boolean O000000o() {
        LinkedList<Bitmap> linkedList = this.O0000oO0;
        return linkedList != null && linkedList.size() > 0;
    }

    public void setScale(float f) {
        this.O00000o = f * gaf.O000000o();
    }

    public void setDeviceWidth(int i) {
        this.f8433O000000o = i;
    }

    public void setDeviceHeight(int i) {
        this.O00000Oo = i;
    }

    public void setDevicePressure(int i) {
        this.O00000o0 = i;
    }

    public void setLineWidth(float f) {
        this.O0000Oo0 = f;
        Paint paint = this.O00000oo;
        if (paint != null) {
            paint.setStrokeWidth(f);
        }
    }

    public void setLineColor(int i) {
        this.O0000Oo = i;
        Paint paint = this.O00000oo;
        if (paint != null) {
            paint.setColor(i);
        }
    }

    public void setImageBgColor(int i) {
        this.O0000OOo = i;
    }

    public void setRevokeTimes(int i) {
        this.O0000o = i;
    }
}
