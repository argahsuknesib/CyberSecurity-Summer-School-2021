package com.xiasuhuei321.loadingdialog.view;

import _m_j.ihw;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class LoadCircleView extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    public final String f12144O000000o;
    private float O00000Oo;
    private Paint O00000o;
    private Context O00000o0;
    private int O00000oO;
    private int O00000oo;

    public LoadCircleView(Context context) {
        this(context, null);
    }

    public LoadCircleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public LoadCircleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f12144O000000o = getClass().getSimpleName();
        this.O00000Oo = 0.0f;
        this.O00000oO = 0;
        this.O00000oo = 0;
        this.O00000o0 = context;
        this.O00000o = new Paint();
        this.O00000o.setAntiAlias(true);
        this.O00000o.setStyle(Paint.Style.STROKE);
        this.O00000o.setStrokeWidth(8.0f);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != Integer.MIN_VALUE && mode2 != Integer.MIN_VALUE) {
            if (size < size2) {
                size = size2;
            }
            this.O00000oO = size;
        } else if (mode == Integer.MIN_VALUE && mode2 != Integer.MIN_VALUE) {
            this.O00000oO = size2;
        } else if (mode != Integer.MIN_VALUE) {
            this.O00000oO = size;
        } else {
            this.O00000oO = ihw.O000000o(this.O00000o0, 50.0f);
        }
        int i3 = this.O00000oO;
        setMeasuredDimension(i3, i3);
        this.O00000Oo = 8.0f;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.O00000oO;
        int i2 = i >> 1;
        int i3 = (i >> 1) - 8;
        if (this.O00000oo >= 12) {
            this.O00000oo = 0;
        }
        for (int i4 = 0; i4 < 12; i4++) {
            int i5 = this.O00000oo;
            if (i4 >= i5 + 4 || i4 < i5) {
                int i6 = this.O00000oo;
                if (i6 <= 8 || i4 >= (i6 + 4) - 12) {
                    this.O00000o.setColor(-1);
                } else {
                    this.O00000o.setColor(-7829368);
                }
            } else {
                this.O00000o.setColor(-7829368);
            }
            float f = (float) i2;
            double d = (double) i2;
            double d2 = (double) i3;
            Double.isNaN(d2);
            Double.isNaN(d);
            canvas.drawLine(f, (float) (d + (d2 * 0.5d)), f, (float) (i3 * 2), this.O00000o);
            canvas.rotate(30.0f, f, f);
        }
        this.O00000oo++;
        postInvalidateDelayed(50);
    }
}
