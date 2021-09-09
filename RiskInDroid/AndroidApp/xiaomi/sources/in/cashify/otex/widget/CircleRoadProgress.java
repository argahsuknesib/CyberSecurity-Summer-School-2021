package in.cashify.otex.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.xiaomi.smarthome.R;

public class CircleRoadProgress extends View implements Animator.AnimatorListener {

    /* renamed from: O000000o  reason: collision with root package name */
    public float f12276O000000o;
    public float O00000Oo;
    public float O00000o;
    public int O00000o0;
    public float O00000oO;
    public int O00000oo;
    public float O0000O0o;
    public float O0000OOo;
    public int O0000Oo;
    public boolean O0000Oo0;
    public float O0000OoO;
    public float O0000Ooo;
    public Paint O0000o;
    public float O0000o0;
    public int O0000o00;
    public float O0000o0O;
    public Paint O0000o0o;
    public Paint O0000oO;
    public Paint O0000oO0;
    public float O0000oOO;
    public ValueAnimator O0000oOo;
    public ValueAnimator.AnimatorUpdateListener O0000oo = new O000000o();
    public O00000Oo O0000oo0;

    public class O000000o implements ValueAnimator.AnimatorUpdateListener {
        public O000000o() {
        }

        public final void onAnimationUpdate(ValueAnimator valueAnimator) {
            float unused = CircleRoadProgress.this.O0000oOO = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            CircleRoadProgress circleRoadProgress = CircleRoadProgress.this;
            circleRoadProgress.O000000o(circleRoadProgress.O0000oOO);
        }
    }

    public interface O00000Oo {
        void O00000oO();
    }

    public final ValueAnimator O000000o(long j) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.O0000oOO, 100.0f);
        ofFloat.setDuration(j);
        ofFloat.addListener(this);
        ofFloat.addUpdateListener(this.O0000oo);
        return ofFloat;
    }

    public final void O000000o() {
        ValueAnimator valueAnimator = this.O0000oOo;
        if (valueAnimator != null) {
            valueAnimator.removeListener(this);
            this.O0000oOo.removeAllUpdateListeners();
            this.O0000oOo.cancel();
            this.O0000oOo = null;
        }
    }

    public final void O000000o(float f) {
        this.O0000oOO = f;
        postInvalidate();
    }

    public void onAnimationCancel(Animator animator) {
    }

    public void onAnimationEnd(Animator animator) {
        O00000Oo o00000Oo = this.O0000oo0;
        if (o00000Oo != null) {
            o00000Oo.O00000oO();
        }
        this.O0000oOo = null;
    }

    public void onAnimationRepeat(Animator animator) {
    }

    public void onAnimationStart(Animator animator) {
    }

    public void setArcLoadingColor(int i) {
        this.O0000o00 = i;
        Paint paint = this.O0000oO;
        if (paint != null) {
            paint.setColor(i);
            this.O0000oO.setStrokeWidth(this.O0000o0);
        }
    }

    public void setRoadColor(int i) {
        this.O00000o0 = i;
        Paint paint = this.O0000o;
        if (paint != null) {
            paint.setColor(i);
            this.O0000o.setStrokeWidth(this.O00000o);
        }
    }

    public CircleRoadProgress(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.arcLoadingColor, R.attr.arcLoadingStartAngle, R.attr.arcLoadingStrokeWidth, R.attr.circleCenterPointX, R.attr.circleCenterPointY, R.attr.isDrawInnerCircle, R.attr.roadColor, R.attr.roadInnerCircleColor, R.attr.roadInnerCircleRadius, R.attr.roadInnerCircleStrokeWidth, R.attr.roadOuterCircleColor, R.attr.roadOuterCircleRadius, R.attr.roadOuterCircleStrokeWidth, R.attr.roadRadius, R.attr.roadStrokeWidth});
        this.f12276O000000o = obtainStyledAttributes.getFloat(3, 54.0f);
        this.O00000Oo = obtainStyledAttributes.getFloat(4, 54.0f);
        this.O00000o0 = obtainStyledAttributes.getColor(6, Color.parseColor("#29000000"));
        this.O00000o = obtainStyledAttributes.getDimension(14, getContext().getResources().getDimension(R.dimen.dimen_3));
        this.O00000oO = obtainStyledAttributes.getFloat(13, 42.0f);
        this.O00000oo = obtainStyledAttributes.getColor(7, Color.parseColor("#29000000"));
        this.O0000O0o = obtainStyledAttributes.getFloat(9, 0.0f);
        this.O0000OOo = obtainStyledAttributes.getFloat(8, 0.0f);
        this.O0000Oo0 = obtainStyledAttributes.getBoolean(5, false);
        this.O0000Oo = obtainStyledAttributes.getColor(10, Color.parseColor("#FFFFFF"));
        this.O0000OoO = obtainStyledAttributes.getDimension(12, getContext().getResources().getDimension(R.dimen.dimen_8));
        this.O0000Ooo = obtainStyledAttributes.getFloat(11, 42.0f);
        this.O0000o00 = obtainStyledAttributes.getColor(0, ContextCompat.O00000o0(getContext(), R.color.otexColorOrangeLight));
        this.O0000o0 = obtainStyledAttributes.getDimension(2, getContext().getResources().getDimension(R.dimen.dimen_3));
        this.O0000o0O = obtainStyledAttributes.getFloat(1, 270.0f);
        obtainStyledAttributes.recycle();
        setLayerType(1, null);
    }

    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = (float) (i >> 1);
        this.f12276O000000o = f;
        this.O00000Oo = (float) (i2 >> 1);
        float f2 = this.O00000o / 2.0f;
        this.O00000oO = f - f2;
        this.O0000Ooo = f - (this.O0000OoO / 2.0f);
        this.O0000OOo = (this.O00000oO - f2) + (this.O0000O0o / 2.0f);
        this.O0000oO0 = new Paint(7);
        this.O0000oO0.setDither(true);
        this.O0000oO0.setColor(this.O00000oo);
        this.O0000oO0.setStyle(Paint.Style.FILL);
        this.O0000oO0.setStrokeWidth(this.O0000O0o);
        this.O0000o0o = new Paint(7);
        this.O0000o0o.setDither(true);
        this.O0000o0o.setColor(this.O0000Oo);
        this.O0000o0o.setStyle(Paint.Style.STROKE);
        this.O0000o0o.setStrokeWidth(this.O0000OoO);
        this.O0000o = new Paint(7);
        this.O0000o.setDither(true);
        this.O0000o.setColor(this.O00000o0);
        this.O0000o.setStyle(Paint.Style.STROKE);
        this.O0000o.setStrokeWidth(this.O00000o);
        this.O0000oO = new Paint(7);
        this.O0000oO.setColor(this.O0000o00);
        this.O0000oO.setStyle(Paint.Style.STROKE);
        this.O0000oO.setStrokeCap(Paint.Cap.ROUND);
        this.O0000oO.setStrokeWidth(this.O0000o0);
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.O0000Oo0) {
            canvas.drawCircle(this.f12276O000000o, this.O00000Oo, this.O0000OOo, this.O0000oO0);
        }
        canvas.drawCircle(this.f12276O000000o, this.O00000Oo, this.O0000Ooo, this.O0000o0o);
        Paint paint = this.O0000oO;
        float f = this.f12276O000000o;
        float f2 = f - this.O00000oO;
        float f3 = (f - (f2 / 2.0f)) * 2.0f;
        Canvas canvas2 = canvas;
        canvas2.drawArc(new RectF(f2, f2, f3, f3), this.O0000o0O, this.O0000oOO * 360.0f * 0.01f, false, paint);
        canvas.drawCircle(this.f12276O000000o, this.O00000Oo, this.O00000oO, this.O0000o);
    }
}
