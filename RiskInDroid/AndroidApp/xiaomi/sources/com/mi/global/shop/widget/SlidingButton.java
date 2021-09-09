package com.mi.global.shop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.CheckBox;
import com.xiaomi.smarthome.R;

public class SlidingButton extends CheckBox {
    private boolean bDoAlphaAnimation;
    private Object data;
    private BitmapDrawable mActiveSlider;
    private int[] mAlphaPixels;
    private float mAnimatedVelocity;
    private boolean mAnimating;
    private long mAnimationLastTime;
    private float mAnimationPosition;
    private int[] mBarSlice;
    private long mCurrentAnimationTime;
    private long mCurrentTogglingAnimationTime;
    private Drawable mFrame;
    private Drawable mFrameOn;
    private final Handler mHandler;
    private int mHeight;
    private int mLastX;
    private BitmapDrawable mOffDisable;
    private O000000o mOnCheckedChangedListener;
    private BitmapDrawable mOnDisable;
    private int mOriginalTouchPointX;
    private BitmapDrawable mPressedSlider;
    private Drawable mSlideMask;
    private Bitmap mSlideOff;
    private Paint mSlideOffPaint;
    private Bitmap mSlideOn;
    private Paint mSlideOnPaint;
    private boolean mSliderMoved;
    private BitmapDrawable mSliderOffDrawable;
    private int mSliderOffset;
    private BitmapDrawable mSliderOnDrawable;
    private int mSliderPositionEnd;
    private int mSliderPositionStart;
    private int mSliderWidth;
    private int mTapThreshold;
    private boolean mTracking;
    private int mWidth;

    public interface O000000o {
        void O000000o(SlidingButton slidingButton, boolean z);
    }

    public void setButtonDrawable(Drawable drawable) {
    }

    public void setData(Object obj) {
        this.data = obj;
    }

    public Object getData() {
        return this.data;
    }

    public void setOnCheckedChangedListener(O000000o o000000o) {
        this.mOnCheckedChangedListener = o000000o;
    }

    public SlidingButton(Context context) {
        this(context, null);
    }

    public SlidingButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.bDoAlphaAnimation = false;
        this.mAnimating = false;
        this.mHandler = new O00000Oo(this, (byte) 0);
        this.mAnimatedVelocity = 150.0f;
        this.data = null;
        this.mOnCheckedChangedListener = null;
        initialize(context, attributeSet, i);
    }

    public SlidingButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void initialize(Context context, AttributeSet attributeSet, int i) {
        setDrawingCacheEnabled(false);
        this.mTapThreshold = (int) ((getResources().getDisplayMetrics().density * 6.0f) + 0.5f);
        Resources resources = context.getResources();
        this.mFrame = resources.getDrawable(R.drawable.shop_sliding_btn_frame);
        this.mFrameOn = resources.getDrawable(R.drawable.shop_sliding_btn_frame_on);
        this.mSliderOffDrawable = (BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_slider);
        this.mSliderOnDrawable = (BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_slider_on);
        this.mPressedSlider = (BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_slider_pressed);
        this.mOnDisable = (BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_on_disable);
        this.mOffDisable = (BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_off_disable);
        this.mWidth = this.mFrame.getIntrinsicWidth();
        this.mHeight = this.mFrame.getIntrinsicHeight();
        BitmapDrawable bitmapDrawable = this.mSliderOnDrawable;
        this.mActiveSlider = bitmapDrawable;
        this.mSliderWidth = Math.min(this.mWidth, bitmapDrawable.getIntrinsicWidth());
        this.mSliderPositionStart = 0;
        this.mSliderPositionEnd = this.mWidth - this.mSliderWidth;
        this.mSliderOffset = this.mSliderPositionStart;
        this.mSlideOff = Bitmap.createScaledBitmap(((BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_off)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        this.mSlideOn = Bitmap.createScaledBitmap(((BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_on)).getBitmap(), (this.mWidth * 2) - this.mSliderWidth, this.mHeight, true);
        this.mSlideMask = resources.getDrawable(R.drawable.shop_sliding_btn_mask);
        this.mFrame.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mFrameOn.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mOnDisable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mOffDisable.setBounds(0, 0, this.mWidth, this.mHeight);
        this.mAlphaPixels = new int[(this.mWidth * this.mHeight)];
        Bitmap bitmap = ((BitmapDrawable) resources.getDrawable(R.drawable.shop_sliding_btn_mask)).getBitmap();
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, this.mWidth, this.mHeight, false);
        int[] iArr = this.mAlphaPixels;
        int i2 = this.mWidth;
        createScaledBitmap.getPixels(iArr, 0, i2, 0, 0, i2, this.mHeight);
        if (createScaledBitmap != bitmap) {
            createScaledBitmap.recycle();
        }
        this.mBarSlice = new int[(this.mWidth * this.mHeight)];
        this.mSlideOffPaint = new Paint();
        this.mSlideOnPaint = new Paint();
    }

    public void setChecked(boolean z) {
        boolean isChecked = isChecked();
        super.setChecked(z);
        this.mActiveSlider = z ? this.mSliderOnDrawable : this.mSliderOffDrawable;
        this.mSliderOffset = z ? this.mSliderPositionEnd : this.mSliderPositionStart;
        if (isChecked != z) {
            int i = 0;
            if (this.bDoAlphaAnimation) {
                doTogglingAnimation(0);
                return;
            }
            this.mSlideOnPaint.setAlpha(z ? 255 : 0);
            Paint paint = this.mSlideOffPaint;
            if (!z) {
                i = 255;
            }
            paint.setAlpha(i);
            invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(this.mWidth, this.mHeight);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int i = this.mSliderOffset;
        Rect rect = new Rect(i, 0, this.mSliderWidth + i, this.mHeight);
        if (action == 0) {
            if (rect.contains(x, y)) {
                this.mTracking = true;
                this.mActiveSlider = this.mPressedSlider;
                invalidate();
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
                int i2 = this.mSliderOffset;
                if (i2 < this.mSliderPositionStart || i2 > this.mSliderPositionEnd / 2) {
                    animateOn();
                } else {
                    animateOff();
                }
            }
            this.mTracking = false;
            this.mSliderMoved = false;
        } else if (action != 2) {
            if (action == 3) {
                this.mTracking = false;
                this.mSliderMoved = false;
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

    private void animateToggle() {
        if (isChecked()) {
            animateOff();
        } else {
            animateOn();
        }
    }

    private void animateOn() {
        performFling(150.0f);
        invalidate();
    }

    private void animateOff() {
        performFling(-150.0f);
        invalidate();
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
        invalidate();
    }

    private void performFling(float f) {
        this.mAnimating = true;
        this.mAnimationPosition = 0.0f;
        this.mAnimatedVelocity = f;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mAnimationLastTime = uptimeMillis;
        this.mCurrentAnimationTime = uptimeMillis + 16;
        this.mHandler.removeMessages(1000);
        Handler handler = this.mHandler;
        handler.sendMessageAtTime(handler.obtainMessage(1000), this.mCurrentAnimationTime);
    }

    public void doAnimation() {
        if (this.mAnimating) {
            incrementAnimation();
            moveSlider((int) this.mAnimationPosition);
            int i = this.mSliderOffset;
            if (i <= this.mSliderPositionStart || i >= this.mSliderPositionEnd) {
                this.mHandler.removeMessages(1000);
                boolean z = false;
                this.mAnimating = false;
                this.bDoAlphaAnimation = true;
                if (this.mSliderOffset >= this.mSliderPositionEnd) {
                    z = true;
                }
                setChecked(z);
                O000000o o000000o = this.mOnCheckedChangedListener;
                if (o000000o != null) {
                    o000000o.O000000o(this, isChecked());
                    return;
                }
                return;
            }
            this.mCurrentAnimationTime += 16;
            Handler handler = this.mHandler;
            handler.sendMessageAtTime(handler.obtainMessage(1000), this.mCurrentAnimationTime);
        }
    }

    private void incrementAnimation() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.mAnimationPosition += this.mAnimatedVelocity * (((float) (uptimeMillis - this.mAnimationLastTime)) / 1000.0f);
        this.mAnimationLastTime = uptimeMillis;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isEnabled()) {
            drawSlidingBar(canvas);
            this.mFrame.draw(canvas);
            this.mSlideMask.draw(canvas);
            BitmapDrawable bitmapDrawable = this.mActiveSlider;
            int i = this.mSliderOffset;
            bitmapDrawable.setBounds(i, 0, this.mSliderWidth + i, this.mHeight);
            this.mActiveSlider.draw(canvas);
        } else if (isChecked()) {
            this.mOnDisable.draw(canvas);
        } else {
            this.mOffDisable.draw(canvas);
        }
    }

    /* JADX DEBUG: Failed to find minimal casts for resolve overloaded methods, cast all args instead
     method: ClspMth{android.graphics.Canvas.drawBitmap(int[], int, int, int, int, int, int, boolean, android.graphics.Paint):void}
     arg types: [int[], int, int, int, int, int, int, int, android.graphics.Paint]
     candidates:
      ClspMth{android.graphics.Canvas.drawBitmap(int[], int, int, float, float, int, int, boolean, android.graphics.Paint):void}
      ClspMth{android.graphics.Canvas.drawBitmap(int[], int, int, int, int, int, int, boolean, android.graphics.Paint):void} */
    private void drawSlidingBar(Canvas canvas) {
        int i = this.mSliderPositionEnd - this.mSliderOffset;
        if (this.mSlideOnPaint.getAlpha() != 0) {
            Bitmap bitmap = this.mSlideOn;
            int[] iArr = this.mBarSlice;
            int i2 = this.mWidth;
            bitmap.getPixels(iArr, 0, i2, i, 0, i2, this.mHeight);
            cutEdge(this.mWidth, this.mHeight, this.mBarSlice);
            int[] iArr2 = this.mBarSlice;
            int i3 = this.mWidth;
            canvas.drawBitmap(iArr2, 0, i3, 0, 0, i3, this.mHeight, true, this.mSlideOnPaint);
        }
        if (this.mSlideOffPaint.getAlpha() != 0) {
            Bitmap bitmap2 = this.mSlideOff;
            int[] iArr3 = this.mBarSlice;
            int i4 = this.mWidth;
            bitmap2.getPixels(iArr3, 0, i4, i, 0, i4, this.mHeight);
            cutEdge(this.mWidth, this.mHeight, this.mBarSlice);
            int[] iArr4 = this.mBarSlice;
            int i5 = this.mWidth;
            canvas.drawBitmap(iArr4, 0, i5, 0, 0, i5, this.mHeight, true, this.mSlideOffPaint);
        }
    }

    private void cutEdge(int i, int i2, int[] iArr) {
        for (int i3 = (i * i2) - 1; i3 >= 0; i3--) {
            iArr[i3] = iArr[i3] & (((((iArr[i3] >>> 24) * (this.mAlphaPixels[i3] >>> 24)) / 255) << 24) + 16777215);
        }
    }

    public void doTogglingAnimation(int i) {
        if (this.mSlideOn != this.mSlideOff) {
            this.mHandler.removeMessages(1001);
            if (i == 0) {
                this.mCurrentTogglingAnimationTime = SystemClock.uptimeMillis();
            }
            if (i < 20) {
                int i2 = i + 1;
                int i3 = (i2 * 255) / 20;
                if (isChecked()) {
                    this.mSlideOffPaint.setAlpha(255 - i3);
                    this.mSlideOnPaint.setAlpha(i3);
                } else {
                    this.mSlideOffPaint.setAlpha(i3);
                    this.mSlideOnPaint.setAlpha(255 - i3);
                }
                this.mCurrentTogglingAnimationTime += 16;
                this.mHandler.sendMessageAtTime(this.mHandler.obtainMessage(1001, i2, 0), this.mCurrentTogglingAnimationTime);
                invalidate();
            }
            this.bDoAlphaAnimation = false;
        }
    }

    class O00000Oo extends Handler {
        private O00000Oo() {
        }

        /* synthetic */ O00000Oo(SlidingButton slidingButton, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i == 1000) {
                SlidingButton.this.doAnimation();
            } else if (i == 1001) {
                SlidingButton.this.doTogglingAnimation(message.arg1);
            }
        }
    }
}
