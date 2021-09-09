package com.xiaomi.smarthome.newui.widget;

import _m_j.ep;
import _m_j.gpc;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;
import com.xiaomi.smarthome.R;

public class GridItemAnimView extends View {
    public static long O00000Oo = ((long) ((O0000oOO + O0000oOo) + O0000oo0));
    private static int O0000oOO = 300;
    private static int O0000oOo = 200;
    private static int O0000oo0 = 150;

    /* renamed from: O000000o  reason: collision with root package name */
    public int f10308O000000o;
    public float O00000o;
    public float O00000o0;
    public Context O00000oO;
    public float O00000oo = 0.0f;
    public int O0000O0o = -14634568;
    public int O0000OOo = -4867650;
    public int O0000Oo = -1;
    public int O0000Oo0 = -1;
    public AnimatorSet O0000OoO;
    private Paint O0000Ooo;
    private Xfermode O0000o = new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP);
    private ObjectAnimator O0000o0 = ObjectAnimator.ofFloat(this, "progress", 0.0f, 100.0f);
    private Paint O0000o00;
    private ObjectAnimator O0000o0O = ObjectAnimator.ofFloat(this, "alpha", 1.0f, 0.0f);
    private RectF O0000o0o;
    private float O0000oO;
    private float O0000oO0;
    private String O0000oo = getResources().getString(R.string.noti_device_on);
    private String O0000ooO = getResources().getString(R.string.noti_device_off);
    private int O0000ooo;

    public GridItemAnimView(Context context) {
        super(context);
        this.O00000oO = context;
        O000000o(null);
    }

    public GridItemAnimView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.O00000oO = context;
        O000000o(attributeSet);
    }

    public GridItemAnimView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.O00000oO = context;
        O000000o(attributeSet);
    }

    private void O000000o(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = this.O00000oO.obtainStyledAttributes(attributeSet, new int[]{R.attr.AnimColor, R.attr.NormalColor, R.attr.radius});
            this.O00000oo = obtainStyledAttributes.getDimension(2, 0.0f);
            this.O0000O0o = obtainStyledAttributes.getColor(0, this.O0000O0o);
            this.O0000Oo0 = obtainStyledAttributes.getColor(1, this.O0000Oo0);
            obtainStyledAttributes.recycle();
        }
        this.O0000o0.setDuration((long) O0000oOO);
        this.O0000o0.setInterpolator(new ep());
        this.O0000o0O.setDuration((long) O0000oo0);
        this.O0000OoO = new AnimatorSet();
        this.O0000OoO.play(this.O0000o0O).after(this.O0000o0).after((long) O0000oOo);
        this.O0000Ooo = new Paint(1);
        this.O0000o00 = new Paint(1);
        this.O0000o00.setColor(this.O0000Oo);
        this.O0000ooo = gpc.O000000o(this.O00000oO, 16.0f);
        this.O0000o00.setTextSize((float) this.O0000ooo);
        this.O0000o0o = new RectF();
    }

    public void setAnimatorExpendDuration(long j) {
        this.O0000o0.setDuration(j);
    }

    public int getAnimOpenExpendColor() {
        return this.O0000O0o;
    }

    public void setAnimOpenExpendColor(int i) {
        this.O0000O0o = i;
    }

    public int getAnimCloseExpendColor() {
        return this.O0000OOo;
    }

    public void setAnimCloseExpendColor(int i) {
        this.O0000OOo = i;
    }

    public int getNormalColor() {
        return this.O0000Oo0;
    }

    public void setNormalColor(int i) {
        this.O0000Oo0 = i;
    }

    public int getAllAnimDuration() {
        int i = O0000oo0;
        int i2 = O0000oOO;
        return i + i2 + i2;
    }

    public int getState() {
        return this.f10308O000000o;
    }

    public void setState(int i) {
        this.f10308O000000o = i;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = this.O0000o0o;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        rectF.right = (float) getMeasuredWidth();
        this.O0000o0o.bottom = (float) getMeasuredHeight();
        int i = this.f10308O000000o;
        if (i == 3) {
            O000000o(canvas, true);
        } else if (i == 4) {
            O000000o(canvas, false);
        }
    }

    private void O000000o(Canvas canvas, boolean z) {
        int i;
        int saveLayer = canvas.saveLayer(null, null, 31);
        this.O0000oO = this.O0000oO0 / 100.0f;
        this.O0000Ooo.setColor(this.O0000Oo0);
        canvas.save();
        this.O0000Ooo.setAlpha((int) (this.O0000oO * 255.0f));
        RectF rectF = this.O0000o0o;
        float f = this.O00000oo;
        canvas.drawRoundRect(rectF, f, f, this.O0000Ooo);
        this.O0000Ooo.setXfermode(this.O0000o);
        this.O0000Ooo.setColor(z ? this.O0000O0o : this.O0000OOo);
        int i2 = (int) ((this.O0000oO * 255.0f) + 20.0f);
        if (i2 >= 255) {
            i2 = 255;
        }
        this.O0000Ooo.setAlpha(i2);
        canvas.drawCircle(this.O00000o0, this.O00000o, ((float) Math.sqrt(Math.pow((double) this.O0000o0o.right, 2.0d) + Math.pow((double) this.O0000o0o.bottom, 2.0d))) * this.O0000oO, this.O0000Ooo);
        float f2 = this.O0000oO;
        if (((double) f2) < 0.5d) {
            i = 0;
        } else {
            double d = (double) f2;
            Double.isNaN(d);
            i = (int) ((d - 0.5d) * 255.0d * 2.5d);
        }
        if (i >= 255) {
            i = 255;
        }
        this.O0000o00.setAlpha(i);
        float f3 = this.O0000oO;
        if (((double) f3) > 0.5d) {
            this.O0000o00.setTextSize(((float) this.O0000ooo) * f3);
        }
        Paint.FontMetrics fontMetrics = this.O0000o00.getFontMetrics();
        canvas.drawText(z ? this.O0000oo : this.O0000ooO, (float) gpc.O00000o0(this.O00000oO, 14.0f), (float) ((int) (((this.O0000o0o.bottom / 2.0f) - (fontMetrics.top / 2.0f)) - (fontMetrics.bottom / 2.0f))), this.O0000o00);
        canvas.restore();
        this.O0000Ooo.setXfermode(null);
        canvas.restoreToCount(saveLayer);
    }

    public void setProgress(float f) {
        this.O0000oO0 = f;
        invalidate();
    }

    public float getProgress() {
        return this.O0000oO0;
    }
}
