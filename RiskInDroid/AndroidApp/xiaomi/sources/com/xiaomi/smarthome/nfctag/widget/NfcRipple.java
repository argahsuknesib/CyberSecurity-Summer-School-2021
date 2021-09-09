package com.xiaomi.smarthome.nfctag.widget;

import _m_j.gpc;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

public class NfcRipple extends View {

    /* renamed from: O000000o  reason: collision with root package name */
    private float f10475O000000o;
    private float O00000Oo;
    private Paint O00000o;
    private Context O00000o0;
    private List<O000000o> O00000oO;

    public NfcRipple(Context context) {
        this(context, null);
    }

    public NfcRipple(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NfcRipple(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = new ArrayList();
        this.O00000o0 = context;
        setBackgroundColor(0);
        this.O00000o = new Paint();
        this.O00000o.setStrokeWidth((float) gpc.O00000o0(this.O00000o0, 1.0f));
        this.O00000o.setStyle(Paint.Style.FILL);
        this.O00000o.setStrokeCap(Paint.Cap.ROUND);
        this.O00000o.setAntiAlias(true);
        this.O00000oO.add(new O000000o(gpc.O00000o0(this.O00000o0, 40.0f)));
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode == 1073741824) {
            this.f10475O000000o = (float) size;
        } else {
            this.f10475O000000o = (float) gpc.O00000o0(this.O00000o0, 160.0f);
        }
        if (mode2 == 1073741824) {
            this.O00000Oo = (float) size2;
        } else {
            this.O00000Oo = (float) gpc.O00000o0(this.O00000o0, 160.0f);
        }
        setMeasuredDimension((int) this.f10475O000000o, (int) this.O00000Oo);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.save();
        this.O00000o.setColor(getResources().getColor(R.color.mj_color_green_normal));
        for (int i = 0; i < this.O00000oO.size(); i++) {
            O000000o o000000o = this.O00000oO.get(i);
            float strokeWidth = (o000000o.f10476O000000o + o000000o.O00000o0) - this.O00000o.getStrokeWidth();
            this.O00000o.setAlpha((int) o000000o.O00000Oo);
            canvas.drawCircle(this.f10475O000000o / 2.0f, this.O00000Oo / 2.0f, strokeWidth, this.O00000o);
            if (strokeWidth > this.f10475O000000o / 2.0f) {
                this.O00000oO.remove(i);
            } else {
                double d = (double) o000000o.O00000o0;
                Double.isNaN(d);
                int i2 = (int) (51.0d - (d * 0.5d));
                if (i2 < 0) {
                    i2 = 0;
                } else if (i2 > 51) {
                    i2 = 51;
                }
                o000000o.O00000Oo = (float) i2;
                double d2 = (double) o000000o.O00000o0;
                Double.isNaN(d2);
                o000000o.O00000o0 = (float) (d2 + 0.4d);
            }
        }
        if (this.O00000oO.size() > 0) {
            List<O000000o> list = this.O00000oO;
            if (list.get(list.size() - 1).O00000o0 > ((float) gpc.O00000o0(this.O00000o0, 10.0f))) {
                this.O00000oO.add(new O000000o(gpc.O00000o0(this.O00000o0, 40.0f)));
            }
        }
        this.O00000o.setAlpha(255);
        this.O00000o.setColor(getResources().getColor(R.color.mj_color_white));
        canvas.drawCircle(this.f10475O000000o / 2.0f, this.O00000Oo / 2.0f, (float) gpc.O00000o0(this.O00000o0, 40.0f), this.O00000o);
        invalidate();
        canvas.restore();
    }

    class O000000o {

        /* renamed from: O000000o  reason: collision with root package name */
        float f10476O000000o;
        float O00000Oo = 51.0f;
        float O00000o0 = 0.0f;

        O000000o(int i) {
            this.f10476O000000o = (float) i;
        }
    }
}
