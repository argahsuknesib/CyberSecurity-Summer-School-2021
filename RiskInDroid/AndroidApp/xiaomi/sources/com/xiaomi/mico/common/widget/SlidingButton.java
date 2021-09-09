package com.xiaomi.mico.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.xiaomi.smarthome.R;

public class SlidingButton extends CheckBox {
    public Animator mAnimator;
    private Animator.AnimatorListener mAnimatorListener;
    private Bitmap mBarOff;
    private Paint mBarOffPaint;
    private Bitmap mBarOn;
    private Paint mBarOnPaint;
    private Drawable mFrame;
    private int mHeight;
    private int mLastX;
    private Bitmap mMask;
    private CompoundButton.OnCheckedChangeListener mOnCheckedChangeListener;
    public CompoundButton.OnCheckedChangeListener mOnPerformCheckedChangeListener;
    private int mOriginalTouchPointX;
    private boolean mSliderMoved;
    private Drawable mSliderOff;
    public int mSliderOffset;
    private Drawable mSliderOn;
    private int mSliderOnAlpha;
    public int mSliderPositionEnd;
    private int mSliderPositionStart;
    private int mSliderWidth;
    private int mTapThreshold;
    private Rect mTmpRect;
    private boolean mTracking;
    private int mWidth;

    public void setButtonDrawable(Drawable drawable) {
    }

    public SlidingButton(Context context) {
        this(context, null);
    }

    public SlidingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTmpRect = new Rect();
        this.mAnimatorListener = new AnimatorListenerAdapter() {
            /* class com.xiaomi.mico.common.widget.SlidingButton.AnonymousClass1 */
            private boolean mCanceled;

            public void onAnimationStart(Animator animator) {
                this.mCanceled = false;
            }

            public void onAnimationCancel(Animator animator) {
                this.mCanceled = true;
            }

            public void onAnimationEnd(Animator animator) {
                if (!this.mCanceled) {
                    SlidingButton slidingButton = SlidingButton.this;
                    slidingButton.mAnimator = null;
                    final boolean z = slidingButton.mSliderOffset >= SlidingButton.this.mSliderPositionEnd;
                    if (z != SlidingButton.this.isChecked()) {
                        SlidingButton.this.setChecked(z);
                        if (SlidingButton.this.mOnPerformCheckedChangeListener != null) {
                            SlidingButton.this.post(new Runnable() {
                                /* class com.xiaomi.mico.common.widget.SlidingButton.AnonymousClass1.AnonymousClass1 */

                                public void run() {
                                    if (SlidingButton.this.mOnPerformCheckedChangeListener != null) {
                                        SlidingButton.this.mOnPerformCheckedChangeListener.onCheckedChanged(SlidingButton.this, z);
                                    }
                                }
                            });
                        }
                    }
                }
            }
        };
        setClickable(true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{16842964, R.attr.bar, R.attr.barOff, R.attr.barOn, R.attr.frame, R.attr.mask, R.attr.sliderOff, R.attr.sliderOn}, i, R.style.App_Widget_Mico_SlidingButton);
        setDrawingCacheEnabled(false);
        this.mTapThreshold = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mFrame = obtainStyledAttributes.getDrawable(4);
        this.mSliderOn = obtainStyledAttributes.getDrawable(7);
        this.mSliderOff = obtainStyledAttributes.getDrawable(6);
        if (Build.VERSION.SDK_INT >= 16) {
            setBackground(obtainStyledAttributes.getDrawable(0));
        } else {
            setBackgroundDrawable(obtainStyledAttributes.getDrawable(0));
        }
        this.mWidth = this.mFrame.getIntrinsicWidth();
        this.mHeight = this.mFrame.getIntrinsicHeight();
        this.mSliderWidth = Math.min(this.mWidth, this.mSliderOn.getIntrinsicWidth());
        this.mSliderPositionStart = 0;
        this.mSliderPositionEnd = this.mWidth - this.mSliderWidth;
        this.mSliderOffset = this.mSliderPositionStart;
        TypedValue typedValue = new TypedValue();
        obtainStyledAttributes.getValue(2, typedValue);
        TypedValue typedValue2 = new TypedValue();
        obtainStyledAttributes.getValue(3, typedValue2);
        this.mBarOff = Bitmap.createScaledBitmap(((BitmapDrawable) obtainStyledAttributes.getDrawable(2)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        if (typedValue.type == typedValue2.type && typedValue.data == typedValue2.data && typedValue.resourceId == typedValue2.resourceId) {
            this.mBarOn = this.mBarOff;
        } else {
            this.mBarOn = Bitmap.createScaledBitmap(((BitmapDrawable) obtainStyledAttributes.getDrawable(3)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        }
        this.mFrame.setBounds(0, 0, this.mWidth, this.mHeight);
        Drawable drawable = obtainStyledAttributes.getDrawable(5);
        drawable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mMask = convertToAlphaMask(drawable);
        this.mBarOffPaint = new Paint();
        this.mBarOnPaint = new Paint();
        this.mBarOnPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        this.mBarOffPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        obtainStyledAttributes.recycle();
    }

    public void setOnPerformCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnPerformCheckedChangeListener = onCheckedChangeListener;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnCheckedChangeListener = onCheckedChangeListener;
        super.setOnCheckedChangeListener(onCheckedChangeListener);
    }

    private Bitmap convertToAlphaMask(Drawable drawable) {
        Rect bounds = drawable.getBounds();
        Bitmap createBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ALPHA_8);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public void setChecked(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
            this.mSliderOffset = z ? this.mSliderPositionEnd : this.mSliderPositionStart;
            int i = 255;
            this.mBarOnPaint.setAlpha(z ? 255 : 0);
            this.mBarOffPaint.setAlpha(!z ? 255 : 0);
            if (!z) {
                i = 0;
            }
            this.mSliderOnAlpha = i;
            invalidate();
        }
    }

    public void setChecked(boolean z, boolean z2) {
        if (!z2) {
            super.setOnCheckedChangeListener(null);
            setChecked(z);
            super.setOnCheckedChangeListener(this.mOnCheckedChangeListener);
            return;
        }
        setChecked(z);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        this.mSliderOn.setState(getDrawableState());
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        Rect rect = this.mTmpRect;
        int i = this.mSliderOffset;
        rect.set(i, 0, this.mSliderWidth + i, this.mHeight);
        if (action == 0) {
            if (rect.contains(x, y)) {
                this.mTracking = true;
                setPressed(true);
            } else {
                this.mTracking = false;
            }
            this.mLastX = x;
            this.mOriginalTouchPointX = x;
            this.mSliderMoved = false;
        } else if (action == 1) {
            if (!this.mTracking || !this.mSliderMoved) {
                animateToggle();
            } else {
                animateToState(this.mSliderOffset >= this.mSliderPositionEnd / 2);
            }
            this.mTracking = false;
            this.mSliderMoved = false;
            setPressed(false);
        } else if (action != 2) {
            if (action == 3) {
                this.mTracking = false;
                this.mSliderMoved = false;
                setPressed(false);
                if (this.mSliderOffset >= this.mSliderPositionEnd / 2) {
                    z = true;
                }
                animateToState(z);
            }
        } else if (this.mTracking) {
            moveSlider(x - this.mLastX);
            this.mLastX = x;
            if (Math.abs(x - this.mOriginalTouchPointX) >= this.mTapThreshold) {
                this.mSliderMoved = true;
                getParent().requestDisallowInterceptTouchEvent(true);
            }
        }
        return true;
    }

    public void setPressed(boolean z) {
        super.setPressed(z);
        invalidate();
    }

    private void animateToggle() {
        animateToState(!isChecked());
    }

    private void animateToState(boolean z) {
        Animator animator = this.mAnimator;
        if (animator != null) {
            animator.cancel();
            this.mAnimator = null;
        }
        AnimatorSet animatorSet = new AnimatorSet();
        int[] iArr = new int[1];
        iArr[0] = z ? this.mSliderPositionEnd : this.mSliderPositionStart;
        ObjectAnimator ofInt = ObjectAnimator.ofInt(this, "SliderOffset", iArr);
        int[] iArr2 = new int[1];
        iArr2[0] = z ? 255 : 0;
        ObjectAnimator ofInt2 = ObjectAnimator.ofInt(this, "SliderOnAlpha", iArr2);
        ofInt2.setDuration(180L);
        ofInt.setDuration(180L);
        animatorSet.play(ofInt2).after(ofInt).after(100);
        this.mAnimator = animatorSet;
        this.mAnimator.addListener(this.mAnimatorListener);
        this.mAnimator.start();
    }

    private void moveSlider(int i) {
        this.mSliderOffset += i;
        int i2 = this.mSliderOffset;
        int i3 = this.mSliderPositionStart;
        if (i2 < i3) {
            this.mSliderOffset = i3;
        } else {
            int i4 = this.mSliderPositionEnd;
            if (i2 > i4) {
                this.mSliderOffset = i4;
            }
        }
        setSliderOffset(this.mSliderOffset);
    }

    public int getSliderOffset() {
        return this.mSliderOffset;
    }

    public void setSliderOffset(int i) {
        this.mSliderOffset = i;
        invalidate();
    }

    public int getSliderOnAlpha() {
        return this.mSliderOnAlpha;
    }

    public void setSliderOnAlpha(int i) {
        this.mSliderOnAlpha = i;
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) this.mMask.getWidth(), (float) this.mMask.getHeight(), isEnabled() ? 255 : 127, 31);
        canvas.drawBitmap(this.mMask, 0.0f, 0.0f, (Paint) null);
        drawBar(canvas);
        this.mFrame.draw(canvas);
        if (this.mSliderOnAlpha <= 255) {
            Drawable drawable = this.mSliderOff;
            int i = this.mSliderOffset;
            drawable.setBounds(i, 0, this.mSliderWidth + i, this.mHeight);
            this.mSliderOff.draw(canvas);
        }
        this.mSliderOn.setAlpha(this.mSliderOnAlpha);
        Drawable drawable2 = this.mSliderOn;
        int i2 = this.mSliderOffset;
        drawable2.setBounds(i2, 0, this.mSliderWidth + i2, this.mHeight);
        this.mSliderOn.draw(canvas);
        canvas.restore();
    }

    private void drawBar(Canvas canvas) {
        if (this.mBarOnPaint.getAlpha() != 0) {
            canvas.drawBitmap(this.mBarOn, 0.0f, 0.0f, this.mBarOnPaint);
        }
        if (this.mBarOffPaint.getAlpha() != 0) {
            canvas.drawBitmap(this.mBarOff, 0.0f, 0.0f, this.mBarOffPaint);
        }
    }
}
