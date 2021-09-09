package com.xiaomi.smarthome.newui.widget;

import _m_j.gsy;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.Transformation;
import android.widget.ImageView;
import android.widget.TextView;

@SuppressLint({"AppCompatCustomView"})
public class PieProgressBar extends ImageView {
    private final int MSG_INVALIDATE = 1;
    private PorterDuffXfermode mMode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);
    private boolean mOri = true;
    private RectF mOval;
    private float mPercent = 0.0f;
    private O000000o mProgressBarAnim;
    private Bitmap mProgressBmp;
    private O00000Oo mProgressTxtAnim;
    public TextView mTxtView = null;
    private Paint mXferPaint = new Paint(1);

    public PieProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mXferPaint.setStyle(Paint.Style.FILL);
        this.mXferPaint.setColor(-65536);
        this.mXferPaint.setXfermode(this.mMode);
        this.mOval = new RectF();
        RectF rectF = this.mOval;
        rectF.left = 0.0f;
        rectF.top = 0.0f;
        this.mProgressBmp = ((BitmapDrawable) getDrawable()).getBitmap();
        this.mProgressBarAnim = new O000000o();
        this.mProgressBarAnim.setInterpolator(new LinearInterpolator());
        this.mProgressTxtAnim = new O00000Oo();
    }

    public void setPercent(float f) {
        if (f < 0.0f) {
            f = 0.0f;
        } else if (f > 100.0f) {
            f = 100.0f;
        }
        this.mPercent = f;
        TextView textView = this.mTxtView;
        if (textView != null) {
            textView.setText(((int) this.mPercent) + "%");
        }
        invalidate();
    }

    public float getPercent() {
        return this.mPercent;
    }

    public float getPercentAnim() {
        return (float) this.mProgressBarAnim.O00000o0;
    }

    public void setFromPercent(int i) {
        O000000o o000000o = this.mProgressBarAnim;
        int i2 = i <= 0 ? 1 : i > 100 ? 100 : i;
        o000000o.f10319O000000o = i2;
        o000000o.O00000o0 = i2;
        PieProgressBar.this.setPercent((float) i2);
        O00000Oo o00000Oo = this.mProgressTxtAnim;
        if (i <= 0) {
            i = 1;
        } else if (i > 100) {
            i = 100;
        }
        o00000Oo.f10320O000000o = i;
        o00000Oo.O00000o0 = i;
    }

    public void setToPercent(int i) {
        this.mProgressBarAnim.O00000Oo = i <= 0 ? 1 : i > 100 ? 100 : i;
        O00000Oo o00000Oo = this.mProgressTxtAnim;
        if (i <= 0) {
            i = 1;
        } else if (i > 100) {
            i = 100;
        }
        o00000Oo.O00000Oo = i;
    }

    public void setDuration(long j) {
        this.mProgressBarAnim.setDuration(j);
        this.mProgressTxtAnim.setDuration((j * 1) / 2);
    }

    public void startPercentAnim() {
        startAnimation(this.mProgressBarAnim);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mProgressBarAnim.setInterpolator(interpolator);
    }

    public void setInterpolator(Context context, int i) {
        this.mProgressBarAnim.setInterpolator(context, i);
    }

    public void setOri(boolean z) {
        this.mOri = z;
    }

    public void setPercentView(TextView textView) {
        if (textView != null) {
            this.mTxtView = textView;
            TextView textView2 = this.mTxtView;
            textView2.setText(((int) this.mPercent) + "%");
        }
    }

    public void stopPercentAnim() {
        this.mProgressBarAnim.cancel();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i;
        if (isInEditMode()) {
            super.onDraw(canvas);
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            i = canvas.saveLayer(0.0f, 0.0f, (float) (getWidth() + 0), (float) (getHeight() + 0), null);
        } else {
            i = canvas.saveLayer(0.0f, 0.0f, (float) (getWidth() + 0), (float) (getHeight() + 0), null, 31);
        }
        int i2 = i;
        this.mOval.right = (float) getWidth();
        this.mOval.bottom = (float) getHeight();
        this.mXferPaint.setXfermode(null);
        if (this.mOri) {
            canvas.drawArc(this.mOval, -90.0f, (this.mPercent * 360.0f) / 100.0f, true, this.mXferPaint);
        } else {
            canvas.drawArc(this.mOval, -90.0f, (this.mPercent * -360.0f) / 100.0f, true, this.mXferPaint);
        }
        this.mXferPaint.setXfermode(this.mMode);
        Bitmap bitmap = this.mProgressBmp;
        canvas.drawBitmap(bitmap, new Rect(0, 0, bitmap.getWidth(), this.mProgressBmp.getHeight()), new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight()), this.mXferPaint);
        canvas.restoreToCount(i2);
    }

    public class O00000Oo extends Animation {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10320O000000o = 0;
        int O00000Oo = 0;
        int O00000o0 = 0;

        public O00000Oo() {
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            int i = this.f10320O000000o;
            int i2 = (int) (((float) i) + (((float) (this.O00000Oo - i)) * f));
            if (this.O00000o0 != i2) {
                this.O00000o0 = i2;
                if (PieProgressBar.this.mTxtView != null) {
                    TextView textView = PieProgressBar.this.mTxtView;
                    textView.setText(i2 + "%");
                }
                StringBuilder sb = new StringBuilder();
                sb.append(this.O00000o0);
                gsy.O000000o(6, "PieProgressBar", sb.toString());
            }
        }
    }

    public class O000000o extends Animation {

        /* renamed from: O000000o  reason: collision with root package name */
        int f10319O000000o = 0;
        int O00000Oo = 0;
        public int O00000o0 = 0;

        public O000000o() {
        }

        /* access modifiers changed from: protected */
        public final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            int i = this.f10319O000000o;
            int i2 = (int) (((float) i) + (((float) (this.O00000Oo - i)) * f));
            if (this.O00000o0 != i2) {
                this.O00000o0 = i2;
                PieProgressBar.this.setPercent((float) i2);
            }
        }
    }
}
