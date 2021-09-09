package com.xiaomi.smarthome.library.common.widget;

import _m_j.gnn;
import _m_j.hzf;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.xiaomi.smarthome.R;

public class SwitchButton extends CheckBox {
    protected Animator mAnimator;
    protected Animator.AnimatorListener mAnimatorListener;
    protected Bitmap mBarOff;
    protected Paint mBarOffPaint;
    protected Bitmap mBarOn;
    protected Paint mBarOnPaint;
    private CompoundButton.OnCheckedChangeListener mCacheListener;
    protected Drawable mFrame_check;
    protected Drawable mFrame_uncheck;
    protected int mHeight;
    protected int mLastX;
    protected Bitmap mMask;
    protected CompoundButton.OnCheckedChangeListener mOnPerformCheckedChangeListener;
    protected boolean mOnTouchEventEnable;
    protected int mOriginalTouchPointX;
    protected boolean mSliderMoved;
    protected Drawable mSliderOff;
    protected int mSliderOffset;
    protected Drawable mSliderOn;
    protected int mSliderOnAlpha;
    protected int mSliderPositionEnd;
    protected int mSliderPositionStart;
    protected int mSliderWidth;
    protected int mTapThreshold;
    protected Rect mTmpRect;
    protected boolean mTracking;
    protected int mWidth;

    public void setButtonDrawable(Drawable drawable) {
    }

    public SwitchButton(Context context) {
        this(context, null);
    }

    public SwitchButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"NewApi"})
    public SwitchButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mTmpRect = new Rect();
        this.mOnTouchEventEnable = true;
        if (!isInEditMode()) {
            try {
                if (gnn.f18048O000000o) {
                    this.mAnimatorListener = new AnimatorListenerAdapter() {
                        /* class com.xiaomi.smarthome.library.common.widget.SwitchButton.AnonymousClass1 */
                        private boolean O00000Oo;

                        public final void onAnimationStart(Animator animator) {
                            this.O00000Oo = false;
                        }

                        public final void onAnimationCancel(Animator animator) {
                            this.O00000Oo = true;
                        }

                        public final void onAnimationEnd(Animator animator) {
                            if (!this.O00000Oo) {
                                SwitchButton switchButton = SwitchButton.this;
                                switchButton.mAnimator = null;
                                final boolean z = switchButton.mSliderOffset >= SwitchButton.this.mSliderPositionEnd;
                                if (z != SwitchButton.this.isChecked()) {
                                    SwitchButton.this.setChecked(z);
                                    hzf.O000000o((CompoundButton) SwitchButton.this);
                                    if (SwitchButton.this.mOnPerformCheckedChangeListener != null) {
                                        SwitchButton.this.post(new Runnable() {
                                            /* class com.xiaomi.smarthome.library.common.widget.SwitchButton.AnonymousClass1.AnonymousClass1 */

                                            public final void run() {
                                                if (SwitchButton.this.mOnPerformCheckedChangeListener != null) {
                                                    SwitchButton.this.mOnPerformCheckedChangeListener.onCheckedChanged(SwitchButton.this, z);
                                                }
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    };
                }
            } catch (Throwable unused) {
            }
        }
        setDrawingCacheEnabled(false);
        this.mTapThreshold = ViewConfiguration.get(context).getScaledTouchSlop() / 2;
        this.mFrame_uncheck = getResources().getDrawable(R.drawable.sliding_btn_frame_uncheck);
        this.mFrame_check = getResources().getDrawable(R.drawable.sliding_btn_frame_check);
        this.mSliderOn = getResources().getDrawable(R.drawable.mj_sliding_btn_slider_on_light);
        this.mSliderOff = getResources().getDrawable(R.drawable.mj_sliding_btn_slider_off_light);
        setBackgroundResource(R.drawable.mj_sliding_btn_bg_light);
        this.mWidth = this.mFrame_uncheck.getIntrinsicWidth();
        this.mHeight = this.mFrame_uncheck.getIntrinsicHeight();
        this.mSliderWidth = Math.min(this.mWidth, this.mSliderOn.getIntrinsicWidth());
        this.mSliderPositionStart = 0;
        this.mSliderPositionEnd = this.mWidth - this.mSliderWidth;
        this.mSliderOffset = this.mSliderPositionStart;
        this.mBarOff = Bitmap.createScaledBitmap(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.mico_sliding_btn_bar_off_light)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        this.mBarOn = Bitmap.createScaledBitmap(new BitmapDrawable(getResources(), BitmapFactory.decodeResource(getResources(), R.drawable.mico_sliding_btn_bar_on_light)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        this.mFrame_uncheck.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mFrame_check.setBounds(0, 0, this.mWidth, this.mHeight);
        Drawable drawable = getResources().getDrawable(R.drawable.mj_sliding_btn_mask_light);
        drawable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mMask = convertToAlphaMask(drawable);
        this.mBarOffPaint = new Paint();
        this.mBarOnPaint = new Paint();
        this.mBarOnPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        this.mBarOffPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST));
        setBackgroundColor(getResources().getColor(R.color.mj_color_black_00_transparent));
    }

    public void setOnPerformCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        this.mOnPerformCheckedChangeListener = onCheckedChangeListener;
    }

    /* access modifiers changed from: protected */
    public Bitmap convertToAlphaMask(Drawable drawable) {
        Rect bounds = drawable.getBounds();
        Bitmap createBitmap = Bitmap.createBitmap(bounds.width(), bounds.height(), Bitmap.Config.ALPHA_8);
        drawable.draw(new Canvas(createBitmap));
        return createBitmap;
    }

    public void setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener onCheckedChangeListener) {
        super.setOnCheckedChangeListener(onCheckedChangeListener);
        this.mCacheListener = onCheckedChangeListener;
    }

    public void setChecked(boolean z, boolean z2) {
        CompoundButton.OnCheckedChangeListener onCheckedChangeListener = null;
        if (!z2) {
            CompoundButton.OnCheckedChangeListener onCheckedChangeListener2 = this.mCacheListener;
            setOnCheckedChangeListener(null);
            onCheckedChangeListener = onCheckedChangeListener2;
        }
        setChecked(z);
        if (!z2) {
            setOnCheckedChangeListener(onCheckedChangeListener);
        }
    }

    public void setChecked(boolean z) {
        if (isChecked() != z) {
            super.setChecked(z);
            boolean isChecked = isChecked();
            this.mSliderOffset = isChecked ? this.mSliderPositionEnd : this.mSliderPositionStart;
            int i = 255;
            this.mBarOnPaint.setAlpha(isChecked ? 255 : 0);
            this.mBarOffPaint.setAlpha(!isChecked ? 255 : 0);
            if (!isChecked) {
                i = 0;
            }
            this.mSliderOnAlpha = i;
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        if (drawableState != null) {
            this.mSliderOn.setState(drawableState);
            this.mSliderOff.setState(drawableState);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (!isEnabled() || !this.mOnTouchEventEnable) {
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

    /* access modifiers changed from: protected */
    public void animateToggle() {
        animateToState(!isChecked());
    }

    /* access modifiers changed from: protected */
    @SuppressLint({"NewApi"})
    public void animateToState(final boolean z) {
        if (gnn.f18048O000000o) {
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
        } else if (z != isChecked()) {
            setChecked(z);
            hzf.O000000o((CompoundButton) this);
            if (this.mOnPerformCheckedChangeListener != null) {
                post(new Runnable() {
                    /* class com.xiaomi.smarthome.library.common.widget.SwitchButton.AnonymousClass2 */

                    public final void run() {
                        if (SwitchButton.this.mOnPerformCheckedChangeListener != null) {
                            SwitchButton.this.mOnPerformCheckedChangeListener.onCheckedChanged(SwitchButton.this, z);
                        }
                    }
                });
            }
        }
    }

    /* access modifiers changed from: protected */
    public void moveSlider(int i) {
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

    public void setOnTouchEnable(boolean z) {
        this.mOnTouchEventEnable = z;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        canvas.saveLayerAlpha(0.0f, 0.0f, (float) this.mMask.getWidth(), (float) this.mMask.getHeight(), isEnabled() ? 255 : 127, 31);
        canvas.drawBitmap(this.mMask, 0.0f, 0.0f, (Paint) null);
        drawBar(canvas);
        int i = this.mSliderOnAlpha;
        if (i < 255) {
            Drawable drawable = this.mSliderOff;
            int i2 = this.mSliderOffset;
            drawable.setBounds(i2, 0, this.mSliderWidth + i2, this.mHeight);
            this.mFrame_uncheck.draw(canvas);
            this.mSliderOff.draw(canvas);
        } else {
            this.mSliderOn.setAlpha(i);
            Drawable drawable2 = this.mSliderOn;
            int i3 = this.mSliderOffset;
            drawable2.setBounds(i3, 0, this.mSliderWidth + i3, this.mHeight);
            this.mFrame_check.draw(canvas);
            this.mSliderOn.draw(canvas);
        }
        canvas.restore();
    }

    /* access modifiers changed from: protected */
    public void drawBar(Canvas canvas) {
        if (this.mBarOnPaint.getAlpha() != 0) {
            canvas.drawBitmap(this.mBarOn, 0.0f, 0.0f, this.mBarOnPaint);
        }
        if (this.mBarOffPaint.getAlpha() != 0) {
            canvas.drawBitmap(this.mBarOff, 0.0f, 0.0f, this.mBarOffPaint);
        }
    }
}
