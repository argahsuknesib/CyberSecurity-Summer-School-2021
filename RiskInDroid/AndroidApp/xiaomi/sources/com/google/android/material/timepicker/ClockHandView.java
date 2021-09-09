package com.google.android.material.timepicker;

import _m_j.cb;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.xiaomi.smarthome.R;
import java.util.ArrayList;
import java.util.List;

class ClockHandView extends View {
    private boolean animatingOnTouchUp;
    private final float centerDotRadius;
    private boolean changedDuringTouch;
    private int circleRadius;
    private double degRad;
    private float downX;
    private float downY;
    private boolean isInTapRegion;
    private final List<OnRotateListener> listeners;
    private OnActionUpListener onActionUpListener;
    private float originalDeg;
    private final Paint paint;
    private ValueAnimator rotationAnimator;
    private int scaledTouchSlop;
    private final RectF selectorBox;
    private final int selectorRadius;
    private final int selectorStrokeWidth;

    public interface OnActionUpListener {
        void onActionUp(float f, boolean z);
    }

    public interface OnRotateListener {
        void onRotate(float f, boolean z);
    }

    public ClockHandView(Context context) {
        this(context, null);
    }

    public ClockHandView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialClockStyle);
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: _m_j.cb.O00000oO(android.view.View, int):void
     arg types: [com.google.android.material.timepicker.ClockHandView, int]
     candidates:
      _m_j.cb.O00000oO(android.view.View, float):void
      _m_j.cb.O00000oO(android.view.View, int):void */
    public ClockHandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.listeners = new ArrayList();
        this.paint = new Paint();
        this.selectorBox = new RectF();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{R.attr.clockHandColor, R.attr.materialCircleRadius, R.attr.selectorSize}, i, 2132739192);
        this.circleRadius = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.selectorRadius = obtainStyledAttributes.getDimensionPixelSize(2, 0);
        Resources resources = getResources();
        this.selectorStrokeWidth = resources.getDimensionPixelSize(R.dimen.material_clock_hand_stroke_width);
        this.centerDotRadius = (float) resources.getDimensionPixelSize(R.dimen.material_clock_hand_center_dot_radius);
        int color = obtainStyledAttributes.getColor(0, 0);
        this.paint.setAntiAlias(true);
        this.paint.setColor(color);
        setHandRotation(0.0f);
        this.scaledTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        cb.O00000oO((View) this, 2);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        setHandRotation(getHandRotation());
    }

    public void setHandRotation(float f) {
        setHandRotation(f, false);
    }

    public void setHandRotation(float f, boolean z) {
        ValueAnimator valueAnimator = this.rotationAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (!z) {
            setHandRotationInternal(f, false);
            return;
        }
        Pair<Float, Float> valuesForAnimation = getValuesForAnimation(f);
        this.rotationAnimator = ValueAnimator.ofFloat(((Float) valuesForAnimation.first).floatValue(), ((Float) valuesForAnimation.second).floatValue());
        this.rotationAnimator.setDuration(200L);
        this.rotationAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            /* class com.google.android.material.timepicker.ClockHandView.AnonymousClass1 */

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                ClockHandView.this.setHandRotationInternal(((Float) valueAnimator.getAnimatedValue()).floatValue(), true);
            }
        });
        this.rotationAnimator.addListener(new AnimatorListenerAdapter() {
            /* class com.google.android.material.timepicker.ClockHandView.AnonymousClass2 */

            public void onAnimationCancel(Animator animator) {
                animator.end();
            }
        });
        this.rotationAnimator.start();
    }

    private Pair<Float, Float> getValuesForAnimation(float f) {
        float handRotation = getHandRotation();
        if (Math.abs(handRotation - f) > 180.0f) {
            if (handRotation > 180.0f && f < 180.0f) {
                f += 360.0f;
            }
            if (handRotation < 180.0f && f > 180.0f) {
                handRotation += 360.0f;
            }
        }
        return new Pair<>(Float.valueOf(handRotation), Float.valueOf(f));
    }

    public void setHandRotationInternal(float f, boolean z) {
        float f2 = f % 360.0f;
        this.originalDeg = f2;
        this.degRad = Math.toRadians((double) (this.originalDeg - 90.0f));
        float width = ((float) (getWidth() / 2)) + (((float) this.circleRadius) * ((float) Math.cos(this.degRad)));
        float height = ((float) (getHeight() / 2)) + (((float) this.circleRadius) * ((float) Math.sin(this.degRad)));
        RectF rectF = this.selectorBox;
        int i = this.selectorRadius;
        rectF.set(width - ((float) i), height - ((float) i), width + ((float) i), height + ((float) i));
        for (OnRotateListener onRotate : this.listeners) {
            onRotate.onRotate(f2, z);
        }
        invalidate();
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.animatingOnTouchUp = z;
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.listeners.add(onRotateListener);
    }

    public void setOnActionUpListener(OnActionUpListener onActionUpListener2) {
        this.onActionUpListener = onActionUpListener2;
    }

    public float getHandRotation() {
        return this.originalDeg;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawSelector(canvas);
    }

    private void drawSelector(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        float f = (float) width;
        float f2 = (float) height;
        this.paint.setStrokeWidth(0.0f);
        canvas.drawCircle((((float) this.circleRadius) * ((float) Math.cos(this.degRad))) + f, (((float) this.circleRadius) * ((float) Math.sin(this.degRad))) + f2, (float) this.selectorRadius, this.paint);
        double sin = Math.sin(this.degRad);
        double cos = Math.cos(this.degRad);
        double d = (double) ((float) (this.circleRadius - this.selectorRadius));
        Double.isNaN(d);
        float f3 = (float) (width + ((int) (cos * d)));
        Double.isNaN(d);
        float f4 = (float) (height + ((int) (d * sin)));
        this.paint.setStrokeWidth((float) this.selectorStrokeWidth);
        canvas.drawLine(f, f2, f3, f4, this.paint);
        canvas.drawCircle(f, f2, this.centerDotRadius, this.paint);
    }

    public RectF getCurrentSelectorBox() {
        return this.selectorBox;
    }

    public int getSelectorRadius() {
        return this.selectorRadius;
    }

    public void setCircleRadius(int i) {
        this.circleRadius = i;
        invalidate();
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z;
        boolean z2;
        boolean z3;
        OnActionUpListener onActionUpListener2;
        int actionMasked = motionEvent.getActionMasked();
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        if (actionMasked != 0) {
            if (actionMasked == 1 || actionMasked == 2) {
                int i = (int) (x - this.downX);
                int i2 = (int) (y - this.downY);
                this.isInTapRegion = (i * i) + (i2 * i2) > this.scaledTouchSlop;
                boolean z4 = this.changedDuringTouch;
                z3 = actionMasked == 1;
                z2 = z4;
            } else {
                z3 = false;
                z2 = false;
            }
            z = false;
        } else {
            this.downX = x;
            this.downY = y;
            this.isInTapRegion = true;
            this.changedDuringTouch = false;
            z3 = false;
            z2 = false;
            z = true;
        }
        this.changedDuringTouch = handleTouchInput(x, y, z2, z, z3) | this.changedDuringTouch;
        if (this.changedDuringTouch && z3 && (onActionUpListener2 = this.onActionUpListener) != null) {
            onActionUpListener2.onActionUp((float) getDegreesFromXY(x, y), this.isInTapRegion);
        }
        return true;
    }

    private boolean handleTouchInput(float f, float f2, boolean z, boolean z2, boolean z3) {
        float degreesFromXY = (float) getDegreesFromXY(f, f2);
        boolean z4 = false;
        boolean z5 = getHandRotation() != degreesFromXY;
        if (z2 && z5) {
            return true;
        }
        if (!z5 && !z) {
            return false;
        }
        if (z3 && this.animatingOnTouchUp) {
            z4 = true;
        }
        setHandRotation(degreesFromXY, z4);
        return true;
    }

    private int getDegreesFromXY(float f, float f2) {
        int degrees = ((int) Math.toDegrees(Math.atan2((double) (f2 - ((float) (getHeight() / 2))), (double) (f - ((float) (getWidth() / 2)))))) + 90;
        return degrees < 0 ? degrees + 360 : degrees;
    }
}
