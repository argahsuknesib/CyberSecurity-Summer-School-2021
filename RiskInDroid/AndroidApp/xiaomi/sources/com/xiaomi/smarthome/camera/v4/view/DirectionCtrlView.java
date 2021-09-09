package com.xiaomi.smarthome.camera.v4.view;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.xiaomi.smarthome.R;

public class DirectionCtrlView extends View {
    protected AttributeSet attr;
    protected Bitmap bitmap;
    protected int defStyleAttr;
    protected int direction;
    protected Runnable directionRunnable;
    protected boolean isPress;
    protected int mArrowH;
    protected int mArrowW;
    protected int mBgWidth;
    protected Bitmap mBitmapRockerDisable;
    protected int mCenterEdge;
    protected int mDiameter;
    protected long mDownTime;
    protected boolean mIsDisabled;
    protected OnDirectionCtrlListener mOnDirectionCtrlListener;
    protected Paint mPaint;
    protected Bitmap mPtzBottom;
    protected Bitmap mPtzCenter;
    protected Bitmap mPtzLeft;
    protected Bitmap mPtzRight;
    protected Bitmap mPtzTop;
    protected int mRadius;
    public float mScale;
    protected boolean supportCenterClick;
    protected float threshold;

    public interface OnDirectionCtrlListener {
        void onActionDown();

        void onActionUp(boolean z);

        void onCenterClick();

        void onClickPTZDirection(int i);
    }

    public DirectionCtrlView(Context context) {
        super(context);
        this.isPress = false;
        this.direction = -1;
        this.mIsDisabled = true;
        this.supportCenterClick = false;
        this.mScale = 1.0f;
        this.threshold = 0.001f;
        this.mDownTime = 0;
        this.directionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView.AnonymousClass1 */

            public void run() {
                if (DirectionCtrlView.this.isPress) {
                    DirectionCtrlView directionCtrlView = DirectionCtrlView.this;
                    directionCtrlView.onDirection(directionCtrlView.direction);
                    DirectionCtrlView.this.getHandler().postDelayed(DirectionCtrlView.this.directionRunnable, 100);
                }
            }
        };
        init(null, 0);
    }

    public DirectionCtrlView(Context context, boolean z, float f) {
        super(context);
        this.isPress = false;
        this.direction = -1;
        this.mIsDisabled = true;
        this.supportCenterClick = false;
        this.mScale = 1.0f;
        this.threshold = 0.001f;
        this.mDownTime = 0;
        this.directionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView.AnonymousClass1 */

            public void run() {
                if (DirectionCtrlView.this.isPress) {
                    DirectionCtrlView directionCtrlView = DirectionCtrlView.this;
                    directionCtrlView.onDirection(directionCtrlView.direction);
                    DirectionCtrlView.this.getHandler().postDelayed(DirectionCtrlView.this.directionRunnable, 100);
                }
            }
        };
        this.mScale = f;
        this.supportCenterClick = z;
        init(null, 0);
    }

    public DirectionCtrlView(Context context, boolean z, float f, boolean z2) {
        super(context);
        this.isPress = false;
        this.direction = -1;
        int i = 1;
        this.mIsDisabled = true;
        this.supportCenterClick = false;
        this.mScale = 1.0f;
        this.threshold = 0.001f;
        this.mDownTime = 0;
        this.directionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView.AnonymousClass1 */

            public void run() {
                if (DirectionCtrlView.this.isPress) {
                    DirectionCtrlView directionCtrlView = DirectionCtrlView.this;
                    directionCtrlView.onDirection(directionCtrlView.direction);
                    DirectionCtrlView.this.getHandler().postDelayed(DirectionCtrlView.this.directionRunnable, 100);
                }
            }
        };
        this.mScale = f;
        this.supportCenterClick = z;
        init(null, 0, !z2 ? 2 : i);
    }

    public DirectionCtrlView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.isPress = false;
        this.direction = -1;
        this.mIsDisabled = true;
        this.supportCenterClick = false;
        this.mScale = 1.0f;
        this.threshold = 0.001f;
        this.mDownTime = 0;
        this.directionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView.AnonymousClass1 */

            public void run() {
                if (DirectionCtrlView.this.isPress) {
                    DirectionCtrlView directionCtrlView = DirectionCtrlView.this;
                    directionCtrlView.onDirection(directionCtrlView.direction);
                    DirectionCtrlView.this.getHandler().postDelayed(DirectionCtrlView.this.directionRunnable, 100);
                }
            }
        };
        init(attributeSet, 0);
    }

    public DirectionCtrlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.isPress = false;
        this.direction = -1;
        this.mIsDisabled = true;
        this.supportCenterClick = false;
        this.mScale = 1.0f;
        this.threshold = 0.001f;
        this.mDownTime = 0;
        this.directionRunnable = new Runnable() {
            /* class com.xiaomi.smarthome.camera.v4.view.DirectionCtrlView.AnonymousClass1 */

            public void run() {
                if (DirectionCtrlView.this.isPress) {
                    DirectionCtrlView directionCtrlView = DirectionCtrlView.this;
                    directionCtrlView.onDirection(directionCtrlView.direction);
                    DirectionCtrlView.this.getHandler().postDelayed(DirectionCtrlView.this.directionRunnable, 100);
                }
            }
        };
        init(attributeSet, i);
    }

    public void myConfigurationChanged(Configuration configuration) {
        init(this.attr, this.defStyleAttr, configuration.orientation);
    }

    public void myConfigurationChanged(int i) {
        init(this.attr, this.defStyleAttr, i);
    }

    public void setSupportCenterClick(boolean z) {
        this.supportCenterClick = z;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnDirectionCtrlListener onDirectionCtrlListener;
        OnDirectionCtrlListener onDirectionCtrlListener2;
        boolean z = false;
        if (getVisibility() != 0) {
            return false;
        }
        if (!this.mIsDisabled) {
            return true;
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            this.mDownTime = System.currentTimeMillis();
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int i = this.mRadius;
            float f = x - ((float) i);
            float f2 = y - ((float) i);
            if (Math.sqrt((double) ((f * f) + (f2 * f2))) <= ((double) this.mRadius)) {
                if (this.supportCenterClick) {
                    int i2 = this.mCenterEdge;
                    if (x > ((float) i2)) {
                        int i3 = this.mDiameter;
                        if (x < ((float) (i3 - i2)) && y > ((float) i2) && y < ((float) (i3 - i2))) {
                            this.isPress = true;
                            this.direction = 0;
                            invalidate();
                            if (!(this.direction == 0 || !this.isPress || (onDirectionCtrlListener = this.mOnDirectionCtrlListener) == null)) {
                                onDirectionCtrlListener.onActionDown();
                            }
                            if (this.direction != 0 && this.isPress) {
                                getHandler().post(this.directionRunnable);
                            }
                        }
                    }
                }
                if (x >= ((float) this.mRadius) || y <= x || y >= ((float) this.mDiameter) - x) {
                    int i4 = this.mRadius;
                    if (y >= ((float) i4) || x >= ((float) i4) ? y >= ((float) this.mDiameter) - x : y >= x) {
                        int i5 = this.mRadius;
                        if (x <= ((float) i5) || y >= ((float) i5) ? y >= x : y <= ((float) this.mDiameter) - x) {
                            int i6 = this.mRadius;
                            if (y <= ((float) i6) || x >= ((float) i6) ? y > x : y > ((float) this.mDiameter) - x) {
                                this.isPress = true;
                                this.direction = 4;
                                invalidate();
                            }
                            onDirectionCtrlListener.onActionDown();
                            getHandler().post(this.directionRunnable);
                        } else {
                            this.isPress = true;
                            this.direction = 2;
                            invalidate();
                            onDirectionCtrlListener.onActionDown();
                            getHandler().post(this.directionRunnable);
                        }
                    } else {
                        this.isPress = true;
                        this.direction = 3;
                        invalidate();
                        onDirectionCtrlListener.onActionDown();
                        getHandler().post(this.directionRunnable);
                    }
                } else {
                    this.isPress = true;
                    this.direction = 1;
                    invalidate();
                    onDirectionCtrlListener.onActionDown();
                    getHandler().post(this.directionRunnable);
                }
            }
        } else if (action == 1 || (action != 2 && action == 3)) {
            this.isPress = false;
            if (this.direction == 0 && (onDirectionCtrlListener2 = this.mOnDirectionCtrlListener) != null) {
                onDirectionCtrlListener2.onCenterClick();
            }
            if (this.mOnDirectionCtrlListener != null) {
                OnDirectionCtrlListener onDirectionCtrlListener3 = this.mOnDirectionCtrlListener;
                if (System.currentTimeMillis() - this.mDownTime > 500) {
                    z = true;
                }
                onDirectionCtrlListener3.onActionUp(z);
            }
            this.direction = -1;
            getHandler().removeCallbacks(this.directionRunnable);
            invalidate();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet, int i) {
        this.attr = attributeSet;
        this.defStyleAttr = i;
        if (Build.VERSION.SDK_INT >= 29) {
            setForceDarkAllowed(false);
        }
        init(attributeSet, i, 1);
    }

    /* access modifiers changed from: protected */
    public void init(AttributeSet attributeSet, int i, int i2) {
        TypedArray obtainStyledAttributes;
        if (!(attributeSet == null || (obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, new int[]{R.attr.view_scale})) == null)) {
            this.mScale = obtainStyledAttributes.getFloat(0, 1.0f);
            obtainStyledAttributes.recycle();
        }
        this.mPaint = new Paint();
        this.mPaint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        setBackgroundColor(0);
        if (i2 == 1) {
            this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_no_center);
        } else {
            this.bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg);
        }
        int width = (int) (((float) this.bitmap.getWidth()) * this.mScale);
        float f = this.mScale;
        int height = (int) (((float) this.bitmap.getHeight()) * f);
        if (Math.abs(f - 1.0f) > this.threshold) {
            this.bitmap = Bitmap.createScaledBitmap(this.bitmap, width, height, true);
        }
        this.mBgWidth = this.bitmap.getWidth();
        int i3 = this.mBgWidth;
        this.mDiameter = i3;
        this.mRadius = i3 / 2;
        double d = (double) ((float) this.mDiameter);
        Double.isNaN(d);
        this.mCenterEdge = (int) (d / 2.8d);
        if (i2 == 1) {
            this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_top);
        } else {
            this.mPtzTop = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_up_press);
        }
        int width2 = (int) (((float) this.mPtzTop.getWidth()) * this.mScale);
        float f2 = this.mScale;
        int height2 = (int) (((float) this.mPtzTop.getHeight()) * f2);
        if (Math.abs(f2 - 1.0f) > this.threshold) {
            this.mPtzTop = Bitmap.createScaledBitmap(this.mPtzTop, width2, height2, true);
        }
        this.mArrowW = this.mPtzTop.getWidth();
        this.mArrowH = this.mPtzTop.getHeight();
        if (i2 == 1) {
            this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bottom);
        } else {
            this.mPtzBottom = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_down_press);
        }
        int width3 = (int) (((float) this.mPtzBottom.getWidth()) * this.mScale);
        float f3 = this.mScale;
        int height3 = (int) (((float) this.mPtzBottom.getHeight()) * f3);
        if (Math.abs(f3 - 1.0f) > this.threshold) {
            this.mPtzBottom = Bitmap.createScaledBitmap(this.mPtzBottom, width3, height3, true);
        }
        if (i2 == 1) {
            this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_left);
        } else {
            this.mPtzLeft = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_left_press);
        }
        int width4 = (int) (((float) this.mPtzLeft.getWidth()) * this.mScale);
        float f4 = this.mScale;
        int height4 = (int) (((float) this.mPtzLeft.getHeight()) * f4);
        if (Math.abs(f4 - 1.0f) > this.threshold) {
            this.mPtzLeft = Bitmap.createScaledBitmap(this.mPtzLeft, width4, height4, true);
        }
        if (i2 == 1) {
            this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_right);
        } else {
            this.mPtzRight = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_right_press);
        }
        int width5 = (int) (((float) this.mPtzRight.getWidth()) * this.mScale);
        float f5 = this.mScale;
        int height5 = (int) (((float) this.mPtzRight.getHeight()) * f5);
        if (Math.abs(f5 - 1.0f) > this.threshold) {
            this.mPtzRight = Bitmap.createScaledBitmap(this.mPtzRight, width5, height5, true);
        }
        if (!this.supportCenterClick || i2 != 1) {
            this.mPtzCenter = null;
        } else {
            this.mPtzCenter = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_center);
            int width6 = (int) (((float) this.mPtzCenter.getWidth()) * this.mScale);
            float f6 = this.mScale;
            int height6 = (int) (((float) this.mPtzCenter.getHeight()) * f6);
            if (Math.abs(f6 - 1.0f) > this.threshold) {
                this.mPtzCenter = Bitmap.createScaledBitmap(this.mPtzCenter, width6, height6, true);
            }
        }
        if (i2 == 1) {
            this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_bg_no_center);
        } else {
            this.mBitmapRockerDisable = BitmapFactory.decodeResource(getResources(), R.drawable.home_ptz_fullscreen_bg);
        }
        int width7 = (int) (((float) this.mBitmapRockerDisable.getWidth()) * this.mScale);
        float f7 = this.mScale;
        int height7 = (int) (((float) this.mBitmapRockerDisable.getHeight()) * f7);
        if (Math.abs(f7 - 1.0f) > this.threshold) {
            this.mBitmapRockerDisable = Bitmap.createScaledBitmap(this.mBitmapRockerDisable, width7, height7, true);
        }
    }

    /* access modifiers changed from: protected */
    public void onDirection(int i) {
        OnDirectionCtrlListener onDirectionCtrlListener = this.mOnDirectionCtrlListener;
        if (onDirectionCtrlListener == null) {
            return;
        }
        if (i == 0) {
            onDirectionCtrlListener.onClickPTZDirection(0);
        } else if (i == 1) {
            onDirectionCtrlListener.onClickPTZDirection(1);
        } else if (i == 2) {
            onDirectionCtrlListener.onClickPTZDirection(2);
        } else if (i == 3) {
            onDirectionCtrlListener.onClickPTZDirection(3);
        } else if (i == 4) {
            onDirectionCtrlListener.onClickPTZDirection(4);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size2 = View.MeasureSpec.getSize(i2);
        if (mode != 1073741824) {
            size = getPaddingLeft() + this.mBitmapRockerDisable.getWidth() + getPaddingRight();
        }
        if (mode2 != 1073741824) {
            size2 = getPaddingTop() + this.mBitmapRockerDisable.getHeight() + getPaddingBottom();
        }
        setMeasuredDimension(size, size2);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvasOk(canvas);
    }

    /* access modifiers changed from: protected */
    public void canvasOk(Canvas canvas) {
        try {
            if (this.mIsDisabled) {
                canvas.drawBitmap(this.bitmap, (float) getPaddingLeft(), (float) getPaddingTop(), this.mPaint);
                if (this.mPtzCenter != null) {
                    canvas.drawBitmap(this.mPtzCenter, (float) getPaddingLeft(), (float) getPaddingTop(), this.mPaint);
                }
                if (this.isPress) {
                    int i = this.direction;
                    if (i != 0) {
                        if (i == 1) {
                            canvas.drawBitmap(this.mPtzLeft, (float) getPaddingLeft(), (float) (getPaddingTop() + ((this.mBgWidth - this.mArrowW) / 2)), this.mPaint);
                        } else if (i == 2) {
                            canvas.drawBitmap(this.mPtzRight, (float) (getPaddingLeft() + (this.mBgWidth - this.mArrowH)), (float) (getPaddingTop() + ((this.mBgWidth - this.mArrowW) / 2)), this.mPaint);
                        } else if (i == 3) {
                            canvas.drawBitmap(this.mPtzTop, (float) (getPaddingLeft() + ((this.mBgWidth - this.mArrowW) / 2)), (float) getPaddingTop(), this.mPaint);
                        } else if (i == 4) {
                            canvas.drawBitmap(this.mPtzBottom, (float) (getPaddingLeft() + ((this.mBgWidth - this.mArrowW) / 2)), (float) ((getPaddingTop() + this.mBgWidth) - this.mArrowH), this.mPaint);
                        }
                    } else if (this.mPtzCenter != null) {
                        canvas.drawBitmap(this.mPtzCenter, (float) getPaddingLeft(), (float) getPaddingTop(), this.mPaint);
                    }
                }
            } else {
                canvas.drawBitmap(this.mBitmapRockerDisable, (float) getPaddingLeft(), (float) getPaddingTop(), this.mPaint);
            }
            if (canvas == null) {
            }
        } catch (Exception e) {
            e.printStackTrace();
            if (canvas != null) {
            }
        }
    }

    public void setDisable(boolean z) {
        this.mIsDisabled = z;
        invalidate();
    }

    public int getRocherWidth() {
        return this.mBgWidth;
    }

    public void setOnDirectionCtrlListener(OnDirectionCtrlListener onDirectionCtrlListener) {
        this.mOnDirectionCtrlListener = onDirectionCtrlListener;
    }
}
