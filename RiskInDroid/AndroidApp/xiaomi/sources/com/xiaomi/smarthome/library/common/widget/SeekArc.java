package com.xiaomi.smarthome.library.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class SeekArc extends View {
    protected static int O00000o = -1;
    protected static final String O00000o0 = "SeekArc";
    protected final int O00000oO = -90;
    protected Drawable O00000oo;
    protected int O0000O0o = 100;
    protected int O0000OOo = 0;
    protected int O0000Oo = 2;
    protected int O0000Oo0 = 4;
    protected int O0000OoO = 0;
    protected int O0000Ooo = 360;
    protected int O0000o = 0;
    protected boolean O0000o0 = false;
    protected int O0000o00 = 0;
    protected boolean O0000o0O = true;
    protected boolean O0000o0o = true;
    protected RectF O0000oO = new RectF();
    protected float O0000oO0 = 0.0f;
    protected Paint O0000oOO;
    protected Paint O0000oOo;
    protected int O0000oo;
    protected int O0000oo0;
    protected int O0000ooO;
    protected int O0000ooo;
    protected O000000o O000O00o;
    protected double O00oOooO;
    protected float O00oOooo;

    public interface O000000o {
    }

    public SeekArc(Context context) {
        super(context);
        O000000o(context, null, 0);
    }

    public SeekArc(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        O000000o(context, attributeSet, R.attr.seekArcStyle);
    }

    public SeekArc(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        O000000o(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void O000000o(Context context, AttributeSet attributeSet, int i) {
        this.O0000oO.set(0.0f, 0.0f, (float) O000000o(this), (float) O00000Oo(this));
        Resources resources = getResources();
        float f = context.getResources().getDisplayMetrics().density;
        int color = resources.getColor(R.color.mj_color_gray_lighter);
        int color2 = resources.getColor(17170450);
        this.O00000oo = resources.getDrawable(R.drawable.brightness_seekarc_thumb);
        this.O0000Oo0 = (int) (((float) this.O0000Oo0) * f);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.arcColor, R.attr.arcWidth, R.attr.clockwise, R.attr.progressColor, R.attr.progressWidth, R.attr.rotation, R.attr.roundEdges, R.attr.seek_max, R.attr.seek_progress, R.attr.startAngle, R.attr.sweepAngle, R.attr.thumb, R.attr.thumbOffset, R.attr.touchInside}, i, 0);
            Drawable drawable = obtainStyledAttributes.getDrawable(11);
            if (drawable != null) {
                this.O00000oo = drawable;
            }
            int intrinsicHeight = this.O00000oo.getIntrinsicHeight() / 2;
            int intrinsicWidth = this.O00000oo.getIntrinsicWidth() / 2;
            this.O00000oo.setBounds(-intrinsicWidth, -intrinsicHeight, intrinsicWidth, intrinsicHeight);
            this.O0000O0o = obtainStyledAttributes.getInteger(7, this.O0000O0o);
            this.O0000OOo = obtainStyledAttributes.getInteger(8, this.O0000OOo);
            this.O0000Oo0 = (int) obtainStyledAttributes.getDimension(4, (float) this.O0000Oo0);
            this.O0000Oo = (int) obtainStyledAttributes.getDimension(1, (float) this.O0000Oo);
            this.O0000OoO = obtainStyledAttributes.getInt(9, this.O0000OoO);
            this.O0000Ooo = obtainStyledAttributes.getInt(10, this.O0000Ooo);
            this.O0000o00 = obtainStyledAttributes.getInt(5, this.O0000o00);
            this.O0000o0 = obtainStyledAttributes.getBoolean(6, this.O0000o0);
            this.O0000o0O = obtainStyledAttributes.getBoolean(13, this.O0000o0O);
            this.O0000o0o = obtainStyledAttributes.getBoolean(2, this.O0000o0o);
            color = obtainStyledAttributes.getColor(0, color);
            color2 = obtainStyledAttributes.getColor(3, color2);
            obtainStyledAttributes.recycle();
        }
        int i2 = this.O0000OOo;
        int i3 = this.O0000O0o;
        if (i2 > i3) {
            i2 = i3;
        }
        this.O0000OOo = i2;
        int i4 = this.O0000OOo;
        if (i4 < 0) {
            i4 = 0;
        }
        this.O0000OOo = i4;
        int i5 = this.O0000Ooo;
        if (i5 > 360) {
            i5 = 360;
        }
        this.O0000Ooo = i5;
        int i6 = this.O0000Ooo;
        if (i6 < 0) {
            i6 = 0;
        }
        this.O0000Ooo = i6;
        int i7 = this.O0000OoO;
        if (i7 > 360) {
            i7 = 0;
        }
        this.O0000OoO = i7;
        int i8 = this.O0000OoO;
        if (i8 < 0) {
            i8 = 0;
        }
        this.O0000OoO = i8;
        this.O0000oOO = new Paint();
        this.O0000oOO.setColor(color);
        this.O0000oOO.setAntiAlias(true);
        this.O0000oOO.setStyle(Paint.Style.STROKE);
        this.O0000oOO.setStrokeWidth((float) this.O0000Oo);
        this.O0000oOo = new Paint();
        this.O0000oOo.setColor(color2);
        this.O0000oOo.setAntiAlias(true);
        this.O0000oOo.setStyle(Paint.Style.STROKE);
        this.O0000oOo.setStrokeWidth((float) this.O0000Oo0);
        if (this.O0000o0) {
            this.O0000oOO.setStrokeCap(Paint.Cap.ROUND);
            this.O0000oOo.setStrokeCap(Paint.Cap.ROUND);
        }
    }

    private static int O000000o(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception unused) {
        }
        return view.getMeasuredWidth();
    }

    private static int O00000Oo(View view) {
        try {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        } catch (Exception unused) {
        }
        return view.getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (!this.O0000o0o) {
            canvas.scale(-1.0f, 1.0f, this.O0000oO.centerX(), this.O0000oO.centerY());
        }
        int i = (this.O0000OoO - 90) + this.O0000o00;
        float f = (float) i;
        Canvas canvas2 = canvas;
        float f2 = f;
        canvas2.drawArc(this.O0000oO, f2, (float) this.O0000Ooo, false, this.O0000oOO);
        canvas.drawArc(this.O0000oO, f, this.O0000oO0, false, this.O0000oOo);
        canvas.translate((float) (this.O0000oo0 - this.O0000ooO), (float) (this.O0000oo - this.O0000ooo));
        this.O00000oo.draw(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int defaultSize = getDefaultSize(getSuggestedMinimumHeight(), i2);
        int defaultSize2 = getDefaultSize(getSuggestedMinimumWidth(), i);
        int min = Math.min(defaultSize2, defaultSize);
        this.O0000oo0 = (int) (((float) defaultSize2) * 0.5f);
        this.O0000oo = (int) (((float) defaultSize) * 0.5f);
        int paddingLeft = min - getPaddingLeft();
        int i3 = paddingLeft / 2;
        this.O0000o = i3;
        float f = (float) ((defaultSize / 2) - i3);
        float f2 = (float) ((defaultSize2 / 2) - i3);
        float f3 = (float) paddingLeft;
        this.O0000oO.set(f2, f, f2 + f3, f3 + f);
        double d = (double) this.O0000o;
        double d2 = (double) (((int) this.O0000oO0) + this.O0000OoO + this.O0000o00 + 90);
        double cos = Math.cos(Math.toRadians(d2));
        Double.isNaN(d);
        this.O0000ooO = (int) (d * cos);
        double d3 = (double) this.O0000o;
        double sin = Math.sin(Math.toRadians(d2));
        Double.isNaN(d3);
        this.O0000ooo = (int) (d3 * sin);
        setTouchInSide(this.O0000o0O);
        super.onMeasure(i, i2);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            O000000o(motionEvent);
        } else if (action == 1) {
            setPressed(false);
        } else if (action == 2) {
            O000000o(motionEvent);
        } else if (action == 3) {
            setPressed(false);
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.O00000oo;
        if (drawable != null && drawable.isStateful()) {
            this.O00000oo.setState(getDrawableState());
        }
        invalidate();
    }

    private void O000000o(MotionEvent motionEvent) {
        if (!O000000o(motionEvent.getX(), motionEvent.getY())) {
            setPressed(true);
            this.O00oOooO = O00000Oo(motionEvent.getX(), motionEvent.getY());
            O000000o(O000000o(this.O00oOooO));
        }
    }

    private boolean O000000o(float f, float f2) {
        float f3 = f - ((float) this.O0000oo0);
        float f4 = f2 - ((float) this.O0000oo);
        return ((float) Math.sqrt((double) ((f3 * f3) + (f4 * f4)))) < this.O00oOooo;
    }

    private double O00000Oo(float f, float f2) {
        float f3 = f - ((float) this.O0000oo0);
        float f4 = f2 - ((float) this.O0000oo);
        if (!this.O0000o0o) {
            f3 = -f3;
        }
        double degrees = Math.toDegrees((Math.atan2((double) f4, (double) f3) + 1.5707963267948966d) - Math.toRadians((double) this.O0000o00));
        if (degrees < 0.0d) {
            degrees += 360.0d;
        }
        double d = (double) this.O0000OoO;
        Double.isNaN(d);
        return degrees - d;
    }

    private int O000000o(double d) {
        double O000000o2 = (double) O000000o();
        Double.isNaN(O000000o2);
        int round = (int) Math.round(O000000o2 * d);
        if (round < 0) {
            round = O00000o;
        }
        return round > this.O0000O0o ? O00000o : round;
    }

    public int getProgress() {
        return this.O0000OOo;
    }

    private float O000000o() {
        return ((float) this.O0000O0o) / ((float) this.O0000Ooo);
    }

    private void O00000Oo() {
        double d = (double) this.O0000o;
        double d2 = (double) ((int) (((float) this.O0000OoO) + this.O0000oO0 + ((float) this.O0000o00) + 90.0f));
        double cos = Math.cos(Math.toRadians(d2));
        Double.isNaN(d);
        this.O0000ooO = (int) (d * cos);
        double d3 = (double) this.O0000o;
        double sin = Math.sin(Math.toRadians(d2));
        Double.isNaN(d3);
        this.O0000ooo = (int) (d3 * sin);
    }

    private void O000000o(int i) {
        if (i != O00000o) {
            int i2 = this.O0000O0o;
            if (i > i2) {
                i = i2;
            }
            if (this.O0000OOo < 0) {
                i = 0;
            }
            this.O0000OOo = i;
            this.O0000oO0 = (((float) i) / ((float) this.O0000O0o)) * ((float) this.O0000Ooo);
            O00000Oo();
            invalidate();
        }
    }

    public void setOnSeekArcChangeListener(O000000o o000000o) {
        this.O000O00o = o000000o;
    }

    public void setProgress(int i) {
        O000000o(i);
    }

    public int getProgressWidth() {
        return this.O0000Oo0;
    }

    public void setProgressWidth(int i) {
        this.O0000Oo0 = i;
        this.O0000oOo.setStrokeWidth((float) i);
    }

    public int getArcWidth() {
        return this.O0000Oo;
    }

    public void setArcWidth(int i) {
        this.O0000Oo = i;
        this.O0000oOO.setStrokeWidth((float) i);
    }

    public int getArcRotation() {
        return this.O0000o00;
    }

    public void setArcRotation(int i) {
        this.O0000o00 = i;
        O00000Oo();
    }

    public int getStartAngle() {
        return this.O0000OoO;
    }

    public void setStartAngle(int i) {
        this.O0000OoO = i;
        O00000Oo();
    }

    public int getSweepAngle() {
        return this.O0000Ooo;
    }

    public void setSweepAngle(int i) {
        this.O0000Ooo = i;
        O00000Oo();
    }

    public void setRoundedEdges(boolean z) {
        this.O0000o0 = z;
        if (this.O0000o0) {
            this.O0000oOO.setStrokeCap(Paint.Cap.ROUND);
            this.O0000oOo.setStrokeCap(Paint.Cap.ROUND);
            return;
        }
        this.O0000oOO.setStrokeCap(Paint.Cap.SQUARE);
        this.O0000oOo.setStrokeCap(Paint.Cap.SQUARE);
    }

    public void setTouchInSide(boolean z) {
        int intrinsicHeight = this.O00000oo.getIntrinsicHeight() / 2;
        int intrinsicWidth = this.O00000oo.getIntrinsicWidth() / 2;
        this.O0000o0O = z;
        if (this.O0000o0O) {
            this.O00oOooo = ((float) this.O0000o) / 4.0f;
        } else {
            this.O00oOooo = (float) (this.O0000o - Math.min(intrinsicWidth, intrinsicHeight));
        }
    }

    public void setClockwise(boolean z) {
        this.O0000o0o = z;
    }
}
