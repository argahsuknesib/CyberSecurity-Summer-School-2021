package com.xiaomi.smarthome.newui.widget.topnavi.indicator.buildins.circlenavigator;

import _m_j.hhr;
import _m_j.hht;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import java.util.ArrayList;
import java.util.List;

public class CircleNavigator extends View implements hhr {

    /* renamed from: O000000o  reason: collision with root package name */
    private int f10344O000000o;
    private int O00000Oo;
    private int O00000o;
    private int O00000o0;
    private int O00000oO;
    private int O00000oo;
    private Interpolator O0000O0o = new LinearInterpolator();
    private Paint O0000OOo = new Paint(1);
    private float O0000Oo;
    private List<PointF> O0000Oo0 = new ArrayList();
    private boolean O0000OoO;
    private O000000o O0000Ooo;
    private float O0000o0;
    private float O0000o00;
    private int O0000o0O;
    private boolean O0000o0o = true;

    public interface O000000o {
    }

    public final void O000000o() {
    }

    public final void O00000Oo(int i) {
    }

    public final boolean O00000Oo() {
        return false;
    }

    public void setCompactMode(boolean z) {
    }

    public CircleNavigator(Context context) {
        super(context);
        this.O0000o0O = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f10344O000000o = hht.O000000o(context, 3.0d);
        this.O00000o = hht.O000000o(context, 8.0d);
        this.O00000o0 = hht.O000000o(context, 1.0d);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        this.O0000OOo.setColor(this.O00000Oo);
        this.O0000OOo.setStyle(Paint.Style.STROKE);
        this.O0000OOo.setStrokeWidth((float) this.O00000o0);
        int size = this.O0000Oo0.size();
        for (int i = 0; i < size; i++) {
            PointF pointF = this.O0000Oo0.get(i);
            canvas.drawCircle(pointF.x, pointF.y, (float) this.f10344O000000o, this.O0000OOo);
        }
        this.O0000OOo.setStyle(Paint.Style.FILL);
        if (this.O0000Oo0.size() > 0) {
            canvas.drawCircle(this.O0000Oo, (float) ((int) ((((float) getHeight()) / 2.0f) + 0.5f)), (float) this.f10344O000000o, this.O0000OOo);
        }
    }

    private void O00000o0() {
        this.O0000Oo0.clear();
        if (this.O00000oo > 0) {
            int height = (int) ((((float) getHeight()) / 2.0f) + 0.5f);
            int i = this.f10344O000000o;
            int i2 = (i * 2) + this.O00000o;
            int paddingLeft = i + ((int) ((((float) this.O00000o0) / 2.0f) + 0.5f)) + getPaddingLeft();
            for (int i3 = 0; i3 < this.O00000oo; i3++) {
                this.O0000Oo0.add(new PointF((float) paddingLeft, (float) height));
                paddingLeft += i2;
            }
            this.O0000Oo = this.O0000Oo0.get(this.O00000oO).x;
        }
    }

    public final void O000000o(int i, float f) {
        if (this.O0000o0o && !this.O0000Oo0.isEmpty()) {
            int min = Math.min(this.O0000Oo0.size() - 1, i);
            int min2 = Math.min(this.O0000Oo0.size() - 1, i + 1);
            PointF pointF = this.O0000Oo0.get(min);
            this.O0000Oo = pointF.x + ((this.O0000Oo0.get(min2).x - pointF.x) * this.O0000O0o.getInterpolation(f));
            invalidate();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        int action = motionEvent.getAction();
        if (action != 0) {
            if (action == 1 && this.O0000Ooo != null && Math.abs(x - this.O0000o00) <= ((float) this.O0000o0O) && Math.abs(y - this.O0000o0) <= ((float) this.O0000o0O)) {
                for (int i = 0; i < this.O0000Oo0.size(); i++) {
                    Math.abs(this.O0000Oo0.get(i).x - x);
                }
            }
        } else if (this.O0000OoO) {
            this.O0000o00 = x;
            this.O0000o0 = y;
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void O000000o(int i) {
        this.O00000oO = i;
        if (!this.O0000o0o) {
            this.O0000Oo = this.O0000Oo0.get(this.O00000oO).x;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        O00000o0();
    }

    public int getRadius() {
        return this.f10344O000000o;
    }

    public void setRadius(int i) {
        this.f10344O000000o = i;
        O00000o0();
        invalidate();
    }

    public int getCircleColor() {
        return this.O00000Oo;
    }

    public void setCircleColor(int i) {
        this.O00000Oo = i;
        invalidate();
    }

    public int getStrokeWidth() {
        return this.O00000o0;
    }

    public void setStrokeWidth(int i) {
        this.O00000o0 = i;
        invalidate();
    }

    public int getCircleSpacing() {
        return this.O00000o;
    }

    public void setCircleSpacing(int i) {
        this.O00000o = i;
        O00000o0();
        invalidate();
    }

    public Interpolator getStartInterpolator() {
        return this.O0000O0o;
    }

    public void setStartInterpolator(Interpolator interpolator) {
        this.O0000O0o = interpolator;
        if (this.O0000O0o == null) {
            this.O0000O0o = new LinearInterpolator();
        }
    }

    public int getCircleCount() {
        return this.O00000oo;
    }

    public void setCircleCount(int i) {
        this.O00000oo = i;
    }

    public void setTouchable(boolean z) {
        this.O0000OoO = z;
    }

    public void setFollowTouch(boolean z) {
        this.O0000o0o = z;
    }

    public O000000o getCircleClickListener() {
        return this.O0000Ooo;
    }

    public void setCircleClickListener(O000000o o000000o) {
        if (!this.O0000OoO) {
            this.O0000OoO = true;
        }
        this.O0000Ooo = o000000o;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int i3 = 0;
        if (mode == Integer.MIN_VALUE || mode == 0) {
            int i4 = this.O00000oo;
            size = (this.O00000o0 * 2) + (this.f10344O000000o * i4 * 2) + ((i4 - 1) * this.O00000o) + getPaddingLeft() + getPaddingRight();
        } else if (mode != 1073741824) {
            size = 0;
        }
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode2 == Integer.MIN_VALUE || mode2 == 0) {
            i3 = (this.f10344O000000o * 2) + (this.O00000o0 * 2) + getPaddingTop() + getPaddingBottom();
        } else if (mode2 == 1073741824) {
            i3 = size2;
        }
        setMeasuredDimension(size, i3);
    }
}
